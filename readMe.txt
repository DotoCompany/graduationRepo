login.jsp
만약 bootstrap이 추가된 탭을 구현할 경우.
<ul class="nav nav-tabs">
		      <li class="active"><a data-toggle="tab" href="#attendantLogin" id ="selectedMU">로그인 하기</a></li>
		      <li><a data-toggle="tab" href="#hostLogin" id = "selectedMM">회원가입</a></li>
</ul>
이런식으로 작성하면 됨.

js/login.js
common/js/jquery-1.12.3.js
common/css/bootstrap.min.css
common/js/bootstrap.min.js
-----------------------------------------------------------
signUpPage.jsp
모달창 이용시 다음과 같은 포맷 사용.
<div class="col-md-12">
         <div id="signUpDes">
            <button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#hostInfoModal">플리마켓 주최란 ?</button><br>
            <button type="button" class="btn btn-link btn-xs" data-toggle="modal" data-target="#attendantInfoModal">일반사용자란 ?</button>
         </div>
</div>