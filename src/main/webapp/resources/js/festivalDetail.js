// 스위퍼
var swiper = new Swiper(".mySwiper", {
    slidesPerView: "auto",
    centeredSlides: true,
    spaceBetween: 15,
    autoplay: {
        delay:4000, disableOnInteraction: false, // false-스와이프 후 자동 재생
    },
    loop :false, loopAdditionalSlides:1,
    pagination: {
      el: ".swiper-pagination",
      clickable: true,
    },
});

// 지도 api 활성화 및 검색
   
     var map = new naver.maps.Map("map", {
        center: new naver.maps.LatLng(45.3595316, 127.1052133),
        zoom: 15,
        mapTypeControl: true
    });
    
    var infoWindow = new naver.maps.InfoWindow({
        anchorSkew: true
    });
    
    map.setCursor('pointer');
    
    function searchCoordinateToAddress(latlng) {
    
        infoWindow.close();
    
        naver.maps.Service.reverseGeocode({
            coords: latlng,
            orders: [
                naver.maps.Service.OrderType.ADDR,
                naver.maps.Service.OrderType.ROAD_ADDR
            ].join(',')
        }, function(status, response) {
            if (status === naver.maps.Service.Status.ERROR) {
                return alert('다시 검색해주세요.');
                /* 클릭하면 오류남 */
            }
    
            var items = response.v2.results,
                address = '',
                htmlAddresses = [];
    
            for (var i=0, ii=items.length, item, addrType; i<ii; i++) {
                item = items[i];
                address = makeAddress(item) || '';
                addrType = item.name === 'roadaddr' ? '[도로명 주소]' : '[지번 주소]';
    
                htmlAddresses.push((i+1) +'. '+ addrType +' '+ address);
            }
    
            infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 좌표</h4><br />',
                htmlAddresses.join('<br />'),
                '</div>'
            ].join('\n'));
    
            infoWindow.open(map, latlng);
        });
    }
    
    function searchAddressToCoordinate(address) {
        naver.maps.Service.geocode({
            query: address
        }, function(status, response) {
            if (status === naver.maps.Service.Status.ERROR) {
                return alert('다시 검색해주세요.');
                /* 왠진 모르겠지만 클릭하면 에러났다고 함 줌, 땡기기 이런것만 가능 */
            }
    
            if (response.v2.meta.totalCount === 0) {
                return alert('해당 검색어로 아무것도 검색되지 않았습니다.');
            }
    
            var htmlAddresses = [],
                item = response.v2.addresses[0],
                point = new naver.maps.Point(item.x, item.y);
    
            if (item.roadAddress) {
                htmlAddresses.push('[도로명 주소] ' + item.roadAddress);
            }
    
            if (item.jibunAddress) {
                htmlAddresses.push('[지번 주소] ' + item.jibunAddress);
            }
    
            if (item.englishAddress) {
                htmlAddresses.push('[영문명 주소] ' + item.englishAddress);
            }
    
            infoWindow.setContent([
                '<div style="padding:10px;min-width:200px;line-height:150%;">',
                '<h4 style="margin-top:5px;">검색 주소 : '+ address +'</h4><br />',
                htmlAddresses.join('<br />'),
                '</div>'
            ].join('\n'));
    
            map.setCenter(point);
            infoWindow.open(map, point);
        });
    }
    
    function initGeocoder() {
        map.addListener('click', function(e) {
            searchCoordinateToAddress(e.coord);
        });
    
        $('#address').on('keydown', function(e) {
            var keyCode = e.which;
    
            if (keyCode === 13) { // Enter Key
                searchAddressToCoordinate($('#address').val());
            }
        });
    
        $('#submit').on('click', function(e) {
            e.preventDefault();
    
            searchAddressToCoordinate($('#address').val());
        });
    
        searchAddressToCoordinate('역삼동');
    }
    
    function makeAddress(item) {
        if (!item) {
            return;
        }
    
        var name = item.name,
            region = item.region,
            land = item.land,
            isRoadAddress = name === 'roadaddr';
    
        var sido = '', sigugun = '', dongmyun = '', ri = '', rest = '';
    
        if (hasArea(region.area1)) {
            sido = region.area1.name;
        }
    
        if (hasArea(region.area2)) {
            sigugun = region.area2.name;
        }
    
        if (hasArea(region.area3)) {
            dongmyun = region.area3.name;
        }
    
        if (hasArea(region.area4)) {
            ri = region.area4.name;
        }
    
        if (land) {
            if (hasData(land.number1)) {
                if (hasData(land.type) && land.type === '2') {
                    rest += '산';
                }
    
                rest += land.number1;
    
                if (hasData(land.number2)) {
                    rest += ('-' + land.number2);
                }
            }
    
            if (isRoadAddress === true) {
                if (checkLastString(dongmyun, '면')) {
                    ri = land.name;
                } else {
                    dongmyun = land.name;
                    ri = '';
                }
    
                if (hasAddition(land.addition0)) {
                    rest += ' ' + land.addition0.value;
                }
            }
        }
    
        return [sido, sigugun, dongmyun, ri, rest].join(' ');
    }
    
    function hasArea(area) {
        return !!(area && area.name && area.name !== '');
    }
    
    function hasData(data) {
        return !!(data && data !== '');
    }
    
    function checkLastString (word, lastString) {
        return new RegExp(lastString + '$').test(word);
    }
    
    function hasAddition (addition) {
        return !!(addition && addition.value);
    }
    
    naver.maps.onJSContentLoaded = initGeocoder;
    
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.3595704, 127.105399),
        map: map
    });

    var HOME_PATH = window.HOME_PATH || '.';

        var cityhall = new naver.maps.LatLng(37.3595704, 127.105399),
            map = new naver.maps.Map('map', {
                center: cityhall.destinationPoint(0, 500),
                zoom: 15
            }),
            marker = new naver.maps.Marker({
                map: map,
                position: cityhall
            });

        var contentString = [
                '<div class="iw_inner">',
                '   <h3>서울특별시청</h3>',
                '   <p>서울특별시 중구 태평로1가 31 | 서울특별시 중구 세종대로 110 서울특별시청<br />',
                '       02-120 | 공공,사회기관 &gt; 특별,광역시청<br />',
                '       <a href="http://www.seoul.go.kr" target="_blank">www.seoul.go.kr/</a>',
                '   </p>',
                '</div>'
            ].join('');

        var infowindow = new naver.maps.InfoWindow({
            content: contentString
        });

        naver.maps.Event.addListener(marker, "click", function(e) {
            if (infowindow.getMap()) {
                infowindow.close();
            } else {
                infowindow.open(map, marker);
            }
        });

        infowindow.open(map, marker);




    $(window).on("load", function() {
        if (navigator.geolocation) {
            /**
             * navigator.geolocation 은 Chrome 50 버젼 이후로 HTTP 환경에서 사용이 Deprecate 되어 HTTPS 환경에서만 사용 가능 합니다.
             * http://localhost 에서는 사용이 가능하며, 테스트 목적으로, Chrome 의 바로가기를 만들어서 아래와 같이 설정하면 접속은 가능합니다.
             * chrome.exe --unsafely-treat-insecure-origin-as-secure="http://example.com"
             */
            navigator.geolocation.getCurrentPosition(onSuccessGeolocation, onErrorGeolocation);
        } else {
            var center = map.getCenter();
            infowindow.setContent('<div style="padding:20px;"><h5 style="margin-bottom:5px;color:#f00;">Geolocation not supported</h5></div>');
            infowindow.open(map, center);
        }
    });
    var marker = new naver.maps.Marker({
        position: new naver.maps.LatLng(37.3595704, 127.105399),
        map: map
    });




// ------------------------------------------------------------------------------------------------------- //    
/* 관심축제 등록 */


const btn1 = document.getElementById("btn1");

/* 상세페이지에 들어왔을때 해당 memberNo이 해당 festivalNo을 좋아요 눌렀는지
   안눌렀는지 구분해서 화면 표시 바꾸기 */

/* 조건문 안달면 이클립스에서 cannot parse string null 뜸 */
if(btn1.innerText == ""){

    (function(){
        
        $.ajax({

            url : "dibTest",

            data : {"festivalNo" : festivalNo,
                    "memberNo" : memberNo},

            type : "GET",
            
            success : function(result){

             if(result > 0){
                    
                    btn1.innerText = "내가 찜한 축제";
                    btn1.style.backgroundColor = "red";

    

                }else{
                   
                    btn1.innerText = "찜하기";
                    btn1.style.backgroundColor = "lightcoral";


                }

            }

        })

    })();

}


//  관심 축제 등록, 취소 function
btn1.addEventListener("click",function t1(){   
     
    if(btn1.innerText == "찜하기"){
        $.ajax({
            
            url : "dibInsert",
            
            data : {"festivalNo": festivalNo,
                    "memberNo" : memberNo},
            
            type : "GET",
            
            success : function(result){
                
                if(result > 0){
                    // 클릭시 insert
                    /* alert( festivalTitle + "를 찜하셨습니다."); */
                    Swal.fire(
                        festivalTitle ,
                        '축제를 찜하셨습니다.',
                        'success'
                      )
                    btn1.innerText = "내가 찜한 축제";
                    btn1.style.backgroundColor = "red";

                    
                }else{
                    alert("찜 실패");
                }

            },

            error : function(){

            }

        })
        return;
    }

    if (btn1.innerText == "내가 찜한 축제") {
        $.ajax({

            url: "dibDelete",

            data: {
                "festivalNo": festivalNo,
                "memberNo": memberNo},

            type: "GET",

            success: function (result) {
                
                if (result > 0) {
                    /* alert( festivalTitle + " 찜을 취소하셨습니다."); */
                    Swal.fire(
                        festivalTitle ,
                        '축제 찜을 취소하셨습니다.',
                        'error'
                      )
                    btn1.innerText = "찜하기";
                    btn1.style.backgroundColor = "lightcoral";


                } else {
                    alert("찜 취소 실패");
                }

            },

            error: function () {

            }
        });
        return;
    }

})