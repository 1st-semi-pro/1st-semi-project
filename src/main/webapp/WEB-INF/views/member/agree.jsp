<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>agree</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/agree.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Hi+Melody&family=Moirai+One&display=swap" rel="stylesheet">
    


</head>

<body>

    <form action="${contextPath}/member/join" method ="get" onsubmit="return agreeCheck()">

    <div id="divKing">

        <div class="divs" id="firstDiv">
            <a href="${contextPath}">
            <img src="${contextPath}/resources/images/logo.png">
            </a>
        </div>


        <section>

        <div class="divs" id="secondDiv">
          

            <input type="checkbox" id="checkAll" class="boxs">
            
            <label for="checkAll" class="labels">
                <span id="bold">축제축제의 개인정보 처리방침, 서비스 이용약관, 마케팅 수신 여부에 대해 모두 동의합니다.</span>
            </label>


        </div>

        <div class="divs" id="thirdDiv">
            
        <article>
            <input type="checkbox" id="checkOne" class="boxs" >
            <label for="checkOne" class="labels">
                <span class="spans">개인정보 처리방침 동의 <span class="necessary">(필수)</span></span>
            </label>
        </article>

        <article class="textareaArticle">
            <textarea readonly>
                여러분을 환영합니다.
                축제축제 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 축제축제 
                서비스의 이용과 관련하여 축제축제 서비스를 제공하는 축제축제 주식회사(이하 ‘축제축제’)와 
                이를 이용하는 축제축제 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 
                아울러 여러분의 축제축제 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
    
                축제축제 서비스를 이용하시거나 축제축제 서비스 회원으로 가입하실 경우 여러분은 본 약관 및 
                관련 운영 정책을 확인하거나 동의하게 되므로, 잠시 시간을 내시어 주의 깊게 살펴봐 주시기 바랍니다.
                
                다양한 축제축제 서비스를 즐겨보세요.
                축제축제는 축제축제 도메인의 웹사이트 및  을 통해 정보 검색, 다른 이용자와의 커뮤니케이션, 
                콘텐츠 제공, 등 여러분의 생활에 편리함을 더할 수 있는 다양한 서비스를 제공하고 있습니다. 
                여러분은 PC, 휴대폰 등 인터넷 이용이 가능한 각종 단말기를 통해 각양각색의 축제축제 서비스를 
                자유롭게 이용하실 수 있으며, 개별 서비스들의 구체적인 내용은 각 서비스 상의 안내, 공지사항, 
                축제축제  웹고객센터(이하 ‘고객센터’) 도움말 등에서 쉽게 확인하실 수 있습니다.
                
                축제축제는 기본적으로 여러분 모두에게 동일한 내용의 서비스를 제공합니다. 
                다만, '청소년보호법' 등 관련 법령이나 기타 개별 서비스 제공에서의 특별한 필요에 의해서 연령 
                또는 일정한 등급을 기준으로 이용자를 구분하여 제공하는 서비스의 내용, 이용 시간, 이용 횟수 
                등을 다르게 하는 등 일부 이용을 제한하는 경우가 있습니다. 자세한 내용은 역시 각 서비스 상의 
                안내, 공지사항, 고객센터 도움말 등에서 확인하실 수 있습니다.
            </textarea>
        </article>

        </div>

        <div class="divs" id="forthDiv"> 
            

            <article>
            <input type="checkbox" id="checkTwo" class="boxs">
           
            <label for="checkTwo" class="labels">
                
                <span class="spans">서비스 이용약관 동의 <span class="necessary">(필수)</span></span>

            </label>
        </article>

        <article class="textareaArticle">

            <textarea readonly>
            개인정보보호법에 따라 축제축제에 회원가입 신청하시는 분께 수집하는 개인정보의 항목, 개인정보의 
            수집 및 이용목적, 개인정보의 보유 및 이용기간, 동의 거부권 및 동의 거부 시 불이익에 관한 사항을 
            안내 드리오니 자세히 읽은 후 동의하여 주시기 바랍니다.

            1. 수집하는 개인정보
            이용자는 회원가입을 하지 않아도 정보 검색, 뉴스 보기 등 대부분의 축제축제 서비스를 회원과 동일하게 
            이용할 수 있습니다. 

            회원가입 시점에 축제축제가 이용자로부터 수집하는 개인정보는 아래와 같습니다.
            - 회원 가입 시 필수항목으로 아이디, 비밀번호, 이름, 생년월일, 성별, 휴대전화번호 등을 수집합니다.

            서비스 이용 과정에서 이용자로부터 수집하는 개인정보는 아래와 같습니다.
            
            - 회원정보 또는 개별 서비스에서 프로필 정보(별명, 프로필 사진)를 설정할 수 있습니다. 
            회원정보에 별명을 입력하지 않은 경우에는 마스킹 처리된 아이디가 별명으로 자동 입력됩니다.
            
            - 축제축제 내의 개별 서비스 이용, 이벤트 응모 및 경품 신청 과정에서 해당 서비스의 이용자에 한해 추가 
            개인정보 수집이 발생할 수 있습니다. 추가로 개인정보를 수집할 경우에는 해당 개인정보 수집 시점에서 
            이용자에게  ‘수집하는 개인정보 항목, 개인정보의 수집 및 이용목적, 개인정보의 보관기간’ 에 대해 
            안내 드리고 동의를 받습니다.

            서비스 이용 과정에서 IP 주소, 쿠키, 서비스 이용 기록, 기기정보, 위치정보가 생성되어 수집될 수 있습니다. 
            또한 이미지 및 음성을 이용한 검색 서비스 등에서 이미지나 음성이 수집될 수 있습니다.

            2. 수집한 개인정보의 이용
            네이버 및 네이버 관련 제반 서비스(모바일 웹/앱 포함)의 회원관리, 서비스 개발・제공 및 향상, 안전한 
            인터넷 이용환경 구축 등 아래의 목적으로만 개인정보를 이용합니다.

            3. 개인정보 수집 및 이용 동의를 거부할 권리
            이용자는 개인정보의 수집 및 이용 동의를 거부할 권리가 있습니다. 회원가입 시 수집하는 최소한의 개인정보, 
            즉, 필수 항목에 대한 수집 및 이용 동의를 거부하실 경우, 회원가입이 어려울 수 있습니다.

        
            </textarea>
       
        </article>

        </div>

        <div class="divs" id="fifthDiv">
           
        <article>
            <input type="checkbox" id="checkThree" class="boxs" >
            
            <label for="checkThree" class="labels">
                
                <span class="spans">마케팅 수신 동의 <span id="notNecessary">(선택)</span></span>

            </label>
        </article>

        <article class="textareaArticle">

            <textarea readonly>
            축제축제 서비스 및 제휴 이벤트・혜택 등의 정보를 휴대전화(축제축제앱 알림 또는 문자), 이메일로 
            받을 수 있습니다. 
            
            일부 서비스(별개의 회원 체계 운영, 축제축제 가입 후 추가 가입하는 서비스 등)의 경우, 수신에 대해
            별도로 안내드리며 동의를 구합니다.
            </textarea>

        </article>    

    </div>
	
        <div class="divs" id="sixthDiv">
            <button id = "btn">다음</button>
        </div>

      </div>
    
    </section>

    </form>
    
            <footer>

			<sec class="find1">

				<a> 이용약관 | 개인정보 처리 방침 | 책임의 한계와 법적고지 | 회원정보 고객센터 </a>

			</sec>

			<sec class="find1">

				<sec>

					<a>Copyright &copy; 2023 OTSUMO CO., LTD. ALL rights reserved<span>|</span></a>

				</sec>

			</sec>
		</footer>


    <script src="${contextPath}/resources/js/agree.js"></script>  

</body>
</html>