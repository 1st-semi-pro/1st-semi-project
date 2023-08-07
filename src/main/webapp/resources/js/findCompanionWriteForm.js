// 미리보기 관련 요소 모두 얻어오기

const inputImage = document.getElementsByClassName("inputImage"); //file
const preview = document.getElementsByClassName("preview"); //img
const deleteImage = document.getElementsByClassName("delete-image"); //span

const festivalDate = document.getElementById("festivalDate");
const festivalArea = document.getElementById("festivalArea");
const festivalCat = document.getElementById("festivalCat");

// 게시글 수정 시 삭제된 이미지의 레벨(위치)를 저장할 input 요소
const deleteList = document.getElementById("deleteList");

// 게시글 수정 시 삭제된 이미지의 레벨(위치)를 기록해 둘 Set 생성
const deleteSet = new Set(); // 순서 X, 중복 X; -> x를 여러번 누를 경우 중복값 저장 방지


for(let i = 0; i < inputImage.length; i++){

    // 파일이 선택 되었을 때
    inputImage[i].addEventListener("change", function(){

        if(this.files[0] != undefined){ // 파일이 선택되었을 때 // 이벤트 발생으로 확인하지만 더블체크함

            const reader = new FileReader(); // 선택된 파일을 읽을 객체를 생성

            reader.readAsDataURL(this.files[0]);
            // 지정된 파일을 읽음 -> result에 저장(URL 포함) -> URL을 이용해서 이미지를 볼 수 있다.

            reader.onload = function(e){ // (onclick처럼) onload = reader가 파일을 다  읽어온 경우에
                // e.target == reader;
                // e.target.result == 읽어들인 이미지의 URL
                // preview[i] == 파일이 선택된 input태그와 인접한 preview 이미지 태그
                preview[i].setAttribute("src", e.target.result); 
                // src를 reader.result (읽어들인 이미지 url이 담김) 로 set

                // 이미지가 성공적으로 불러와졌을 때
                // deleteSet에서 해당 레벨을 제거(삭제 목록에서 제외)
                deleteSet.delete(i);

            }

        }else{  // 파일을 선택하지 않았을 때 (취소했을 때)
            preview[i].removeAttribute("src"); // src 속성 제거

        } 


    });

    
    // 미리보기 삭제 버튼(X)이 클릭 되었을 때의 동작
    deleteImage[i].addEventListener("click",function(){

        // 미리보기가 존재하는 경우에만 (이전에 추가된 이미지가 있을 때만) X 버튼이 동작
        if(preview[i].getAttribute("src") != ""){
            
            // 미리보기 삭제
            preview[i].removeAttribute("src"); // 이미지만 지운거고 파일 value는 남아있음
            
            // input의 값을 ""로 만들기
            inputImage[i].value = ""; // 파일 값도 지움
    
            // deleteSet에 삭제된 이미지 레벨(i) 추가 <- for문 안임
            deleteSet.add(i);

        }
        
    })

    // 게시글이라 이미지 삭제, 삽입만 하면 끝

}



// 게시글 작성 유효성 검사
function writeValidate(){

    const boardTitle = document.getElementsByName("boardTitle")[0];
    const boardContent = document.querySelector("[name='boardContent']"); // css선택자 쿼리셀렉터는 여러개여도 앞에거만 얻어와서 [0]안해도됨

    if(boardTitle.value.trim().length == 0){
        alert("제목을 입력해주세요!!!");
        boardTitle.value = "";
        boardTitle.focus();
        return false;
    }

    if(boardContent.value.trim().length == 0){
        alert("내용을 입력해주세요!!!");
        boardContent.value = "";
        boardContent.focus();
        return false;
    }

    // 제목, 내용이 유효한 경우
    // deleteList(input 태그)에 deleteSet(삭제된 이미지 레벨)을 추가
    // -> JS 배열 특징 사용
    // --> JS 배열을 HTML 요소 또는 console에서 출력하게 되는 경우 1,2,3과 같은 문자열로 출력된다.
    //     배열 기호가 벗겨진다.

    // * Set -> Array로 변경 -> deleteList.value에 대입

    // Array.from(유사배열 | 컬렉션) : 유사배열 | 컬렉션을 배열로 변환해서 반환
    deleteList.value = Array.from(deleteSet);

    return true;

}
