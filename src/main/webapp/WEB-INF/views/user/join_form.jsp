<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
		<form action="/auth/joinProc" method="post">
	<div class="form-group">
			<label for="username">user name : </label>
			<input type="text" class="form-control" placeholder="Enter username" id="username" name="username">
	</div>
	<div class="form-group">
			<label for="password">Password : </label>
			<input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
	</div>
	
	<div class="form-group">
			<label for="email">Email Address : </label>
			<input type="email" class="form-control" placeholder="Enter email" id="email" name="email">
	</div>
	
	<button id="btn-save" type="submit" class="btn btn-primary">회원가입</button>
		</form>
</div>
<br/>
<!-- 
<script src="js/user.js"></script>
 -->
<%@ include file="../layout/footer.jsp"%>