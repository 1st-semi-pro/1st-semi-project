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
    
        searchAddressToCoordinate('강남구');
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
    

                }else{
                   
                    btn1.innerText = "찜하기";

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
                    alert("찜하셨습니다.");
                    btn1.innerText = "내가 찜한 축제";
                    
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
                    alert("찜을 취소하셨습니다.");
                    btn1.innerText = "찜하기";
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