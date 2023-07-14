const all = document.getElementById("all"); 
const checkList = document.getElementsByName("check");

all.addEventListener("click", function(){
    for(let i = 0 ; i < checkList.length ; i++){
        checkList[i].checked = all.checked;
    }
})

this.addEventListener("click", function(e){
    for(let i = 0 ; i < checkList.length ; i++){

        if(e.target == checkList[i]){

            if(!this.checked && all.checked){
                all.checked = false;
            }

            let flag = true;
            for(let j = 0 ; j < checkList.length ; j++){   

                if(!checkList[j].checked){ 
                    flag = false;
                }
            }

            if (!all.checked && flag){
                all.checked = true;
            }
        }
    }
})