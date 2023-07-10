<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>동행자 뺀 글쓰기 페이지들</title>

    <style>

        *{box-sizing:border-box;     
        font-family: 'Hi Melody', cursive; font-size: 16px; /* border:1px solid black; */}

            html{
                height:1200px;
                display:flex;
                justify-content: center;
                align-items: center;
            }

            body{
                display:flex;
                width:60%;
                height:75%;
            }

            form{
                width:100%;
                height:100%;
            }

            #divKing{
                display:flex;
                width:100%;
                height:100%;
                flex-direction: column;

            }

            .divs{
                display:flex;
                /* width:100%; */
                width:100%;

            }

            #writingBoardTitle{
                height:10%;
                display:flex;
                align-items: center;
                /* 앞에 안붙일거면 justify도 */

            }

            #writingBoardTitle > span{
                font-size:30px;
                font-weight: bold;
                width:100%;
            }


            #title{
                height:10%;
                margin-bottom:20px;
            }

            hr{
                border:0.5px solid black;
            }

            #textArea{
                height:50%;
                display:flex;
                justify-content: center;
            }

            textArea{

                width:100%;
                height:80%;
                margin-top:0;
                border:0;
                border-top:1px solid black;
                border-bottom: 1px solid black;
                resize: none;
            }

            textArea:hover{
                border:1px solid black;
            }

            #divfoot{
                height:10%;
            }

            #divtest{
                display:flex;
                justify-content: space-evenly;
            }

            #btn1{
                border:0;
                background-color: black;
                color: white;
                width:120px;
                height:35px;
                border-radius: 5px;
                float:right;

            }

            #btn2{
                background-color: white;
                color: black;
                width:120px;
                height:35px;
                border-radius: 5px;
                float:right;
                margin-left:10px;
            }



            input{
                width:200%;
                border-radius: 5px;
                border:1px solid black;
                height:35px;
            }

            #selectBoard{
                width:200px;
            }

            table{
                width:100%;
                
            }

            select{
                border:1px solid black;
                height:35px;
                border-radius: 5px;
            }

            #selectBoard{
                width:100%;
            }


            #td2{
                display:flex;
                justify-content: end;
            }

            #subject{
                width:181px;
            }

            

    </style>

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">


</head>

<body>
    
    <form action="#" method="post">

        <div id="divKing">


            <div id="writingBoardTitle" class="divs">
                
                <span>땡땡땡땡 게시판 글쓰기 페이지       
                    <button id="btn2">취소</button> 
                    <button id="btn1">게시글 등록</button>

                    <hr>
                </span>

            </div>


            <div id="title" class="divs">

                <table>
                   
                    <tr>

                        <td>
                                <select id="selectBoard">
                                    <option value="none">--게시판을 선택해주세요--</option>
                                    <option value="1" disabled>공지사항 게시판</option>
                                    <option value="2">자유 게시판</option>
                                    <option value="3">축제후기 게시판</option>
                                    <option value="4">동행자구하기 게시판</option>
                                </select>
            
                        </td>


                        <td id="td2">
                            <select id="subject">
                                <option value="none">--말머리를 선택해주세요--</option>
                                <option value="1">예시1</option>
                                <option value="2">예시2</option>
                                <option value="3">예시3</option>
                                <option value="4">예시4</option>
                            </select>

                        </td>
                    </tr>

                    <tr>

                        <td><input type="text" placeholder="--제목을 입력해주세요--"></td>
                        
                    </tr>

                </table>    

                

            </div>        
                    
            <div id="textArea" class="divs">

                <textarea placeholder="내용을 입력해주세요."></textarea>


                

            </div>

            <div class="divs" id="divfoot">

                <tr>
                    <th>파일 첨부</th>
                    <td><input type="file" ></td>
                    <td></td>
                </tr>


            </div>        


            <div class="divs" id="divtest">

            </div>
















        </div>
        
    </form>



</body>

</html>
