// 회원 프로필 이미지 변경(미리보기)
const inputImage = document.getElementById("input-image");
const inputMessage = document.getElementById("profile-message");
const del = document.getElementById("delete-image");
const chan = document.getElementById("change-image");
const chanMsg = document.getElementById("change-message");

if(inputImage != null){ // inputImage 요소가 화면에 존재할 때
    inputImage.addEventListener("change", function(){

        // this : 이벤트가 발생한 요소(input type="file")

        // files :  input type="file"만 사용 가능한 속성으로
        //          선택된 파일 목록(배열)을 반환
        // console.log(this.files);
        // console.log(this.files[0]); // 파일 목록에서 첫번째 파일 객체를 선택

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

                del.value = 0;
                chan.value = 1;
                // 새로운 이미지가 선택되어있기 때문에 1 -> 0(안눌러짐 상태) 
            }
        }

    });
}

inputMessage.addEventListener("change", function(){ // 프로필 메세지 내용 변경 시
    if(inputMessage.value == memberMessage) chanMsg.value = 0; //DB에 저장된 내용과 같으면 0
    else chanMsg.value = 1; // 기존 내용과 달라졌다면 1
})


function profileValidate(){
    // DB에 저장된 프로필 메세지와 마이페이지 프로필 메세지가 같다 == 변경되지 않음
    if(inputImage.value == "" && del.value == 0 && inputMessage.value == memberMessage){ // 빈문자열 == 파일 선택 X
        alert("변경사항이 없습니다.")
        return false;
    }

    return true;

}

// 프로필 이미지 옆 x버튼 클릭 시
document.getElementById("delete-image-btn").addEventListener("click", function(){
    
    if(del.value ==0){
        // 1) 프로필 이미지를 기본 이미지로 변경
        document.getElementById("profile-image").setAttribute("src",contextPath + "/resources/images/default_profile.png");

        // 2) input type="file"에 저장된 값(value)에 "" 대입
        document.getElementById("input-image").value="";

        del.value = 1;
        chan.value = 1;
    }
})
