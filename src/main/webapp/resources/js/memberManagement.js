const all = document.getElementById("all"); 
const checkList = document.getElementsByName("checkRow");
const deleteSet = new Set();

all.addEventListener("click", function(){
    for(let i = 0 ; i < checkList.length ; i++){
        checkList[i].checked = all.checked;
    }
});

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
});





function searchValidate(){

    if(document.getElementById("mem-search").value.trim().length == 0){
        alert("검색어를 입력해주세요.");
        return false;
    }
    return true;
};



(function(){
    const select = document.getElementById("ctg");

    const input = document.getElementById("mem-search");

    const option = select.children;

    if(select != null){ 

        const params = new URL(location.href).searchParams;

        const ctg = params.get("ctg");
        const search = params.get("search");

        input.value = search;

        for(let op of option){
            if(op.value == ctg){
                op.selected = true;
            }
        }

    }

})();


function selectMemberList(){

    $.ajax({
        url : "board/memberList2",
        type : "get",
        dataType : "JSON",
        success : function(mList){
            const memberList = document.getElementById("member-list");
            memberList.innerHTML = "";

            for(let item of mList){
                const tr = document.createElement("tr");
                const td1 = document.createElement("td");
                const td2 = document.createElement("td");
                const td3 = document.createElement("td");
                const td4 = document.createElement("td");
                const td5 = document.createElement("td");
                const td6 = document.createElement("td");
                const td7 = document.createElement("td");
                const td8 = document.createElement("td");
                const input = document.createElement("input");

                td1.innerText = item.memberNo;
                td2.innerText  = item

                tr.append(td);
            }

        },
        error : function(){
            console.log("에러발생");
        }
    })
}






function goToDeleteMember(){
    if(confirm("정말 탈퇴시키겠습니까?")){
        const checkRow = document.getElementsByName("checkRow");
        flag = false;

        for(i = 0 ; i < checkRow.length ; i++){
            if(checkRow[i].checked){
                flag = true;
               /*  deleteSet.add(checkRow[i].value); */
            }
        }

        if(flag == false){
            alert("하나 이상 선택되어야 삭제 가능합니다.")
            return;
        }

       

        document.memberform.submit();
            
        alert("탈퇴시켰습니다.");
        /* selectMemberList(); */

        
    }
};

