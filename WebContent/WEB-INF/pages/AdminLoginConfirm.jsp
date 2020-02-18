<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.13/css/all.css" integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
  crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
  crossorigin="anonymous">
	<title>Admin's Login | 管理者登入頁</title>
	<!-- Stylesheet for HTML5 backward compatibility; normalize.css -->
	<!-- Dictate which Stylesheets to use for this webpage -->
    <style>
    	<%@include file="/WEB-INF/css/normalize.css"%>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>
    
</head>
<body>
 	<nav class="navbar navbar-expand-sm navbar-dark bg-dark p-0">
      <div class="container">
        <span class="navbar-brand">管理者</span>
      </div>
    </nav>

<!-- HEADER -->
<header id="main-header" class="py-2 bg-primary text-white">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1><i class="fas fa-user"> FarmVille管理者系統</i></h1>
      </div>
    </div>
  </div>
</header>

<!-- ACTIONS -->
<section id="action" class="py-4 mb-4 bg-light">
  <div class="container">
    <div class="row">
      
    </div>
  </div>
</section>

	
		
<section id="login">
  <div class="container">
    <div class="row">
      <div class="col-md-6 mx-auto">
        <div class="card">
            <div class="card-header">
                <h4>使用者注冊</h4>
            </div>
            <div class="card-body">
           <form class="form" name="loginForm" action="<jstl:url value="/adminSignUpStep2" />" method="post" id="myForm">
            <div class="form-group">
            <span id="nEmail">${nEmail}</span> | <span id="nPwd">${nPwd}</span>
            <br>
                  <label for="confirmCode"><b>Administrator Code</b></label>
                  <div>Please enter your administrator code below.</div>
                  <input type="text" class="form-control" name="confirmCode" value="">
                  <span id="codeErrorSpan">${errors.codeError}</span>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary btn-block">
            </form>
            </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- FOOTER -->
<%@include file="/WEB-INF/pages/AdminFooter2.jsp"%>
			

</body>

 <script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
    crossorigin="anonymous"></script>

  <script>
    // Get the current year for the copyright
    $('#year').text(new Date().getFullYear());
    
    
    $(function(){
    	$("#userEmail").keyup(function(){
    		var userEmail = $("#userEmail").val();
    		if(userEmail != ""){
    			var userPwd = $.cookie(userEmail);
    			if(userPwd!=null){
    				$("#userPwd").val(userPwd);
    				$("#rememberMe").attr(checked, true);
    			}
    			
    		}
    	})
    })

    

  </script>


</html>