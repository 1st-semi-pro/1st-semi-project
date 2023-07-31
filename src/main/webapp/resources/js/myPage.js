// 회원 프로필 이미지 변경(미리보기)
const inputImage = document.getElementById("input-image");

if(inputImage != null){ // inputImage 요소가 화면에 존재할 때
    inputImage.addEventListener("change", function(){

        // this : 이벤트가 발생한 요소(input type="file")

        // files :  input type="file"만 사용 가능한 속성으로
        //          선택된 파일 목록(배열)을 반환
        console.log(this.files);
        console.log(this.files[0]); // 파일 목록에서 첫번째 파일 객체를 선택

        if(this.files[0] != undefined){
            const reader = new FileReader();
            // 자바스크립트의 FileReader
            // -웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 사용하는 객체
            
            //reader.readAsArrayBuffer // 여러개를 읽어올 때
            //reader.readAsBinaryString // 바이너리 코드를 읽어올 때
            reader.readAsDataURL(this.files[0]); 
            // - 지정된 파일의 내용을 읽기 시작함
            // - 읽어오는게 완료되면 result 속성 data:에
            //   읽어온 파일의 위치를 나타내는 URL이 포함된다.
            //   해당 URL을 이용해서 브라우저에 이미지를 볼 수 있다.

            //   읽어오는 result 속성 -> data : url(파일경로) 

            // FildReader.onload = function(){}
            // - FileReader가 파일을 다 읽어온 경우 함수를 수행
            reader.onload = function(e){ // 고전 이벤트 모델
                // e : 이벤트 발생 객체
                // e.target : 이벤트가 발생한 요소(객체) -> FileReader
                // e.target.result : FileReader가 읽어온 파일의 URL

                // 프로필 이미지의 src속성의 값을 FileReader가 읽어온 파일의 URL로 변경
                const profileImage = document.getElementById("profile-image");
                
                profileImage.setAttribute("src", e.target.result);
                // -> setAttribute()호출 시 중복되는 속성이 본재하면 덮어쓰기

                document.getElementById("delete").value=0;
                // 새로운 이미지가 선택되어있기 때문에 1 -> 0(안눌러짐 상태) 
            }
        }

    });
}

function profileValidate(){

    const inputImage = document.getElementById("input-image");

    const del = document.getElementById("delete");
    if(inputImage.value == "" && del.value == 0){ // 빈문자열 == 파일 선택 X
        alert("이미지를 선택한 후 변경 버튼을 클릭해주세요.");
        return false;
    }
    
    return true;

}

// 프로필 이미지 옆 x버튼 클릭 시
document.getElementById("delete-image").addEventListener("click", function(){

    const del = document.getElementById("delete");
    
    if(del.value ==0){
        // 1) 프로필 이미지를 기본 이미지로 변경
        document.getElementById("profile-image").setAttribute("src",contextPath + "/resources/images/default_profile.png");

        // 2) input type="file"에 저장된 값(value)에 "" 대입
        document.getElementById("input-image").value="";

        del.value = 1;
    }
})

/* 즉시실행함수 */
(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ // 목록으로 버튼이 화면에 있을 때만 이벤트 추가하겠다.

        goToListBtn.addEventListener("click", function(){

            // location 객체(BOM)

            // 문자열.substring(시작, 끝) : 시작 이상 끝 미만 인덱스까지 문자열 자르기

            // 문자열.indexOf("검색 문자열", 시작 인덱스)
            // : 문자열에서 "검색 문자열"의 위치(인덱스)를 찾아서 반환
            // 단, 시작 인덱스 이후부터 검색

            const pathname = location.pathname; // 주소상에서 요청 경로 반환


            // 이동할 주소를 저장
            let url = pathname.substring(0, pathname.indexOf("/", 1));
            // url에 /community가 저장됨

            url += "/board/list?" // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리 스트링만 별도 객체로 반환
        
            /* http://localhost:8080/community/board/detail?no=1502&cp=1&type=1 에서 */
            /* http://localhost:8080/community/board/list?type=1 으로 */
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // type = 1
            let cp = "cp=" + (params.get("cp") !="" ? params.get("cp") : "1" );// cp = 1

            // 조립
            // /community/board/list?type=1&cp=1
            url += type + "&" + cp;

            // 검색 key, query가 존재하는 경우 url에 추가 ( 상세페이지 들어갔다가 목록으로 나가도 특정 검색어 검색목록 유지되게끔)
            if(params.get("key") != null){
                const key = "&key=" + params.get("key");
                const query = "&query=" + params.get("query");

                url += key + query; // ure뒤에 붙이기
            }

            // location.href = "주소"; -> 해당 주소로 이동
            location.href = url;

        });

    }

})();