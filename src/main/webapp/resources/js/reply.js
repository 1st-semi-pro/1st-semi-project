// ---------------------------------------------------------------------------------------------------------- //
// 버튼클릭으로 수정,삭제,삽입이 진행되었을 때 reply.jsp와 같은 형식으로 바로 변경된 데이터를 띄워줄 화면

function selectReplyList(){
 
    // contextPath, boardNo, memberNo 전역 변수 사용
    $.ajax({
        url : contextPath + "/reply/selectReplyList",

        data : {"boardNo" : boardNo},

        type : "get", 

        dataType : "JSON", // JSON 형태의 문자열 응답 데이터를 JS 객체로 자동 변환

        success : function(ReplyList){
            // rList : 반환 받은 댓글 목록

            // 화면에 출력되어 있는 댓글 목록 삭제
            const replyList1 = document.getElementById("replyList"); // ul태그
            replyList1.innerHTML = '';

            // replyList에 저장된 요소를 하나씩 접근
            for(let reply of ReplyList){
               
                // 행
                const replyRow = document.createElement("li");
                replyRow.classList.add("replyRow");

                // 작성자
                const replyWriter = document.createElement("div");
                replyWriter.classList.add("replyWriter")

                const profileImage = document.createElement("img");

                if(reply.profileImage != null){ // 프로필이미지가 있는 경우
                    
                    profileImage.setAttribute("src", contextPath + reply.profileImage); // 해당이미지 주소 왜 됨

                }else{
                    profileImage.setAttribute("src", contextPath + "/resources/images/id.png");
                
                }

                // 작성자 닉네임
                const memberNickname = document.createElement("div");
                memberNickname.innerText = reply.memberNickname;

                memberNickname.classList.add("nickDate");



                // 작성일
                const replyDate = document.createElement("div");
                replyDate.classList.add("nickDate");
                replyDate.innerText = "(" + reply.createDate + ")";
                

                // 작성자 영역(div)에 프로필, 닉네임, 작성일 마지막 자식으로 추가
                replyWriter.append(profileImage, memberNickname, replyDate);

                // 댓글 내용
                const replyContent = document.createElement("div");
                replyContent.classList.add("replyContent");
                replyContent.innerHTML = reply.replyContent; // <br>태그 인식을 위해 innerHTML

                // 행에 작성자, 내용, 버튼영역 추가
                replyRow.append(replyWriter, replyContent);

                // 로그인한 회원 번호와 댓글 작성자의 회원 번호가 같을 때만 버튼을 추가하겠다.
                
                if(loginMemberNo == reply.memberNo){ // for문 안에있음

                    // 버튼 영역
                    const replyBtnArea = document.createElement("div");
                    replyBtnArea.classList.add("replyBtnDiv");
    
                    // 수정 버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    // 수정 버튼에 onclick 이벤트 속성 추가
                    updateBtn.setAttribute("onclick", "showUpdateReply(" + reply.replyNo + ", this)"); /// ???
    
                    // 삭제 버튼
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    // 삭제 버튼에 onclick 이벤트 속성 추가
                    deleteBtn.setAttribute("onclick", "deleteReply(" +reply.replyNo +")");

                    // 버튼 영역 마지막 자식으로 수정/삭제 버튼 추가
                    replyBtnArea.append(updateBtn, deleteBtn);

                    // 행에 버튼 영역 추가
                    replyRow.append(replyBtnArea);

                }

                // 댓글 목록(ul) 에 행(li) 추가
                replyList1.append(replyRow);

            }

        },

        error : function(){
            console.log("에러 발생");
        }

    });

} 


// ---------------------------------------------------------------------------------------------------------- //
// 댓글 등록
const addReply = document.getElementById("addReply");
const replyContent = document.getElementById("replyContent");

    if(addReply != null){

addReply.addEventListener("click",function(){ // 댓글 등록 버튼이 클릭 되었을 때

    // 2) 댓글 내용이 작성되어있나?
    if(replyContent.value.trim().length == 0){ ////textarea input속성 -> value로 가져온다.
        alert("댓글을 작성한 후 버튼을 클릭해주세요.");

        replyContent.value = ""; 
        replyContent.focus();
        return;

    }

    // 3) AJAX를 이용해서 댓글 내용 DB에 저장(INSERT)
    $.ajax({

        url : contextPath + "/reply/insert",
        data : {"replyContent" : replyContent.value,
                "memberNo" : loginMemberNo,
                "boardNo" : boardNo},
        
        type : "post",

        success : function(result){
            
            if(result > 0){
                alert("댓글이 등록 되었습니다.");

                replyContent.value = "";

                selectReplyList(); 

            }else{
                alert("댓글 등록에 실패했습니다.");
            }
        },

        error : function(req, status, error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }

    })

}) 

}
// ---------------------------------------------------------------------------------------------------------- //
// 댓글 수정
let beforeReplyRow; // 수정 전 원래 행의 상태를 저장할 변수

function showUpdateReply(replyNo, btn){
                      // 댓글번호, 이벤트발생요소(수정버튼)

    // ** 댓글 수정이 한 개만 열릴 수 있도록 **
    const upTextArea = document.getElementsByClassName("update-textarea");

    if(upTextArea.length > 0){ // 수정이 한 개 이상 열려있는 경우

        if(confirm("다른 댓글이 수정 중입니다. 현재 댓글을 수정하시겠습니까?")){ // 확인

            upTextArea[0].parentElement.innerHTML = beforeReplyRow;
            // beforeReplyRow = replyRow.innerHTML;

        }else{ 
            return;
        }

    }

    // 1. 댓글 수정이 클릭된 행을 선택
    const replyRow = btn.parentElement.parentElement // 수정 버튼의 부모의 부모 <li class=reply-row>

    // 2. 행 내용 삭제 전 현재 상태를 저장(백업)
    // (전역변수 이용)
    beforeReplyRow = replyRow.innerHTML; // 취소했을때 갖고올라고 만듬

    //취소버튼 동작 코드
    //replyRow.innerHTML = beforeReplyRow;

    //3.댓글에 작성되어 있던 내용만 얻어오기 -> 새롭게 생성된  textarea 추가될 예정

    //console.log(replyRow.children[1].innerHTML); // <br> 태그 유지를 위해 innerHTML 사용
    
    let beforeContent = replyRow.children[1].innerHTML;
    // let beforContent = btn.parentElement.previousElementSibling.innerHTML; 이런식으로도 가능

    // 4. 댓글 행 내부 내용을 모두 삭제
    replyRow.innerHTML = "";

    // 5. textarea 요소 생성 + 클래스 추가 + 내용 추가

    const textarea = document.createElement("textarea"); 
    textarea.classList.add("update-textarea");

    // ******************************************** //
    // XSS 방지 처리 해제
    // ******************************************** //
    beforeContent = beforeContent.replaceAll("&amp;", "&");
    beforeContent = beforeContent.replaceAll("&lt;", "<");
    beforeContent = beforeContent.replaceAll("&gt;", ">");
    beforeContent = beforeContent.replaceAll("&quot;", "\"");
    
    // 개행문자 처리 해제
    beforeContent = beforeContent.replaceAll("<br>", "\n");

    textarea.value = beforeContent; // 내용 추가

    // 6. replyRow에 생성된 textarea 추가
    replyRow.append(textarea);

    // 7. 버튼 영역 + 수정/취소 버튼 생성
    
    const replyBtnArea = document.createElement("div");
    replyBtnArea.classList.add("replyBtnDiv");
    
    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateReply("+replyNo+ ", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    // 8. 버튼 영역에 버튼 추가 후
    //    replyRow(행)에 버튼영역 추가
    
    replyBtnArea.append(updateBtn, cancelBtn);

    replyRow.append(replyBtnArea);

}

// 수정 취소
function updateCancel(btn){
    // 매개변수 btn : 클릭된 취소 버튼 태그 자체
    // 전역변수 beforeReplyRow : 수정 전 원래 행(댓글)을 저장한 변수

    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = beforeReplyRow;
        // <li></li> 안을 다시 갖고온다
    }

}

// 수정을 누른 뒤의 수정을 클릭했을 때의 event
function updateReply(replyNo, btn){

    // 새로 작성된 댓글 내용 얻어오기
    const replyContent = btn.parentElement.previousElementSibling.value; 
    
    $.ajax({

        url : contextPath + "/reply/update",

        data : {"replyNo" : replyNo,
                "replyContent" : replyContent},

        type : "POST",

        success : function(result){
            if(result > 0){
                alert("댓글이 수정되었습니다.");
                selectReplyList();
            }else{
                alert("댓글 수정 실패");
            }
            
        },

        error : function(req, status, error){
            console.log("댓글 수정 실패2");
            console.log("req.responseText");
        }



    });

}


// ---------------------------------------------------------------------------------------------------------- //
// 댓글 삭제

function deleteReply(replyNo){

    if(confirm("정말로 삭제 하시겠습니까?")){

        // DB에서 댓글 삭제 ==> REPLY_ST = 'Y' 변경

        $.ajax({

           url : contextPath + "/reply/delete",
           
           data : {"replyNo" : replyNo},

           type : "GET",

           success : function(result){
            if(result > 0 ){
                alert("삭제되었습니다.");

                selectReplyList(); 

            }else{
                alert("삭제를 실패했습니다.");
            }

           },

           error : function(req, status, error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }

        })

    }

}
