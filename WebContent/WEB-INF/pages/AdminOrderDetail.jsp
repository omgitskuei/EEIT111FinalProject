<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB"
	crossorigin="anonymous">
<!-- 這標題到時後可以的話，用EL依照修改項目標題改一下名稱 -->
<title>Admin's Order Detail | 管理者修改各訂單頁面</title>
<!-- Stylesheet for HTML5 backward compatibility; normalize.css -->
<!-- Dictate which Stylesheets to use for this webpage -->
<style>
<%@ include file="/WEB-INF/css/normalize.css"%>
<%@ include file="/WEB-INF/css/style.css"%>
</style>
</head>
<body>
<!-- NAVBAR -->
<%@include file="/WEB-INF/pages/AdminNavbar.jsp" %>
<!-- HEADER -->
<header id="main-header" class="py-2 bg-success text-white">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <!-- 這標題裡面的編號要用EL抓Model裡面的id，AdminDetailController的也要改 -->
        <h1><i class="fas fa-pencil-alt"> 訂單#</i></h1>
      </div>
    </div>
  </div>
</header>

<!-- ACTIONS -->
<section id="actions" class="py-4 mb-4 bg-light">
  <div class="container">
    <div class="row">
      <div class="col-md-3">
      <!-- 返回AdminIndex -->
        <form class="form"  name="DirectInventoryForm" action=<jstl:url value="/controller.AdminRedirectController" />
        method="post" >
        	<input type="submit" class="btn btn-block btn-outline-secondary" title="Admin Index Button" name="adminIndexButton" value="返回儀表板">
        </form>
      </div>
      <div class="col-md-3">
        <a href="index.html" class="btn btn-success btn-block">
        <!-- 儲存的Controller沒寫，還沒效 -->
          <i class="fas fa-check"></i> 儲存訂單
        </a>
      </div>
      <div class="col-md-3">
        <a href="index.html" class="btn btn-warning btn-block">
        <!-- 刪除的Controller沒寫，還沒效 -->
          <i class="fas fa-plus"></i> 刪除訂單
        </a>
      </div>
    </div>
  </div>
</section>

<!-- INVENTORY -->
<section id="details">
  <div class="container">
  <div class="row">
    <div class="col">
      <div class="card">
        <div class="card-header">
          <h4> 編輯訂單資料</h4>
          <div class="card-body">
            <form>
          		<div class="form-group">
          		<label for="orderTitle">商品名稱</label>
            <input type="text" class="form-control">
          </div>
          <div class="form-group">
            <label for="orderCategory">商品類別</label>
            <select class="form-control">
              <option value="">蔬菜</option>
              <option value="">水果</option>
            </select>
          </div>
          <div class="form-group">
            <label for="inventoryQuantity">商品數量</label>
            <input type="number" class="form-control" min="0">
          </div>
          <div class="form-group">
            <label for="orderUserID">買家帳號</label>
            <input type="text" class="form-control">
          </div>
          <div class="form-group">
            <label for="orderTransportMethod">寄送方式</label>
            <select class="form-control">
              <option value="">全家</option>
              <option value="">7-11</option>
              <option value="">郵局</option>
              <option value="">黑貓宅急便</option>
            </select>
          </div>
          <div class="form-group">
            <label for="orderPayMethod">付款方式</label>
            <select class="form-control">
              <option value="">貨到付款</option>
              <option value="">信用卡付款</option>
              <option value="">轉帳</option>
              <option value="">Apple Pay</option>
              <option value="">街口支付</option>
              <option value="">Line Pay</option>
            </select>
          </div>
          <div class="form-group">
            <label for="orderQuote">備註</label>
            <textarea name="editor1" class="form-control"></textarea>
          </div>
        </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  </div>
</section>

<!-- Footer -->
<%@include file="/WEB-INF/pages/AdminFooter2.jsp" %>

<!-- JavaScript -->
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
		integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
		crossorigin="anonymous"></script>

	<script>
    // Get the current year for the copyright
    $('#year').text(new Date().getFullYear());

  </script>

</body>
</html>