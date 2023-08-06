const checkAll = document.getElementById("checkAll");
const checkOne = document.getElementById("checkOne");
const checkTwo = document.getElementById("checkTwo");
const checkThree = document.getElementById("checkThree");
const boxs = document.getElementsByClassName("boxs");

/* 전체동의 클릭시  */ 
 checkAll.addEventListener("click",function(){
    
    for(let i = 0; i < boxs.length; i++){
        boxs[i].checked = checkAll.checked;
    }

})

 /* 하나라도 체크 취소되면 전체동의 체크 취소, 다시 다 체크되면 전체동의 체크  */
for(let i = 0; i < boxs.length; i++){
    boxs[i].addEventListener("click",function(){
        let allChecked = true;
        for(let j = 1; j < boxs.length; j++){
            if(!boxs[j].checked){
                allChecked = false;
                break;
            }
        }
        checkAll.checked = allChecked;
    })
}

/* 3가지 동의사항 중 필수사항 2개가 체크되어야만 화면 넘기기 */

function agreeCheck(){

    if(checkOne.checked && checkTwo.checked){

        return true;
    }else{
        Swal.fire(
            '필수약관',
            '개인정보 처리방침, 서비스이용약관에 동의해주세요.',
            'error'
          )
        return false;
    }

}