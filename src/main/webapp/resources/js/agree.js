
/*  const form = document.getElementById("form");
    const all = document.getElementById("all");
    const divs = document.getElementsByTagName("div");
    const boxs = document.getElementsByClassName("boxs");
    const span = document.getElementsByTagName("span");
    const btn = document.getElementById("btn");
    const out = document.getElementById("out");

all.addEventListener("click",function(){
       
        for(let i = 0; i < boxs.length; i++){

            boxs[i].checked = all.checked;
        }
        
    })

    for(let i = 0; i < boxs.length; i++){
    boxs[i].addEventListener("click",function(){
        let allChecked = true;
        for(let j = 0; j < boxs.length; j++){
            if(!boxs[j].checked){
                allChecked = false;
                break;
            }
        }
        all.checked = allChecked;
    })
    }

    /*      

        for(let i = 0; i < boxs.length; i++){

    boxs[i].addEventListener("click",function(){

        if(!boxs[i].checked){
            all.checked = false;
        }else{
            all.checked = true;
        }
    })

    }

        }) */

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

 /* 하나라도 체크 취소되면 전체동의 체크 취소  */
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

/* 

function agreeCheck(){

    if(!checkOne.checked){
        alert("개인정보 처리방침에 동의해주세요.");
    
    }
    
    
    return true;
} 
 */

/* checkAll.addEventListener("click",function(){
       
    for(let i = 0; i < boxs.length; i++){

        boxs[i].checked = checkAll.checked;
    }
    
})

for(let i = 0; i < boxs.length; i++){
boxs[i].addEventListener("click",function(){
    let allChecked = true;
    for(let j = 0; j < boxs.length; j++){
        if(!boxs[j].checked){
            allChecked = false;
            break;
        }
    }
    checkAll.checked = allChecked;
})
}*/