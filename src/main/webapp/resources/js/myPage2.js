const goodBtn = document.getElementById("good");
const badBtn = document.getElementById("bad");
const loginMemberNo = document.getElementById("loginMember");
const viewMemberNo = document.getElementById("goodMember");
const goodSpan = document.getElementById("good-span");
const badSpan = document.getElementById("bad-span");

goodBtn.addEventListener("click", function(){
    $.ajax({
        url : "myPage2/good",
        type : "POST",
        data : {"recNo" : loginMemberNo.value,
                "goodNo" : viewMemberNo.value},
        success : function(assessNum){
            goodSpan.innerText = assessNum;

        },
        error : function(){
            console.log("오류발생");
        }
    })

    
});


badBtn.addEventListener("click", function(){
    $.ajax({
        url : "myPage2/bad",
        type : "POST",
        data : {"recNo" : loginMemberNo.value,
                "badNo" : viewMemberNo.value},
        success : function(assessNum1){
            badSpan.innerText = assessNum1;

        },
        error : function(){
            console.log("오류발생");
        }
    })
});


