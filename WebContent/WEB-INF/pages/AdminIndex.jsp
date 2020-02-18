<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>

<%@ taglib
	prefix="jstl"
	uri="http://java.sun.com/jsp/jstl/core"
%>

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
    <title>Admin's Index | 管理者首頁</title>
    <!-- Stylesheet for HTML5 backward compatibility; normalize.css -->

    <!-- Dictate which Stylesheets to use for this webpage -->
    <style>
    	<%@include file="/WEB-INF/css/normalize.css"%>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>


</head>

<body>
<!-- NAVBAR -->
<%@include file="/WEB-INF/pages/AdminNavbar.jsp" %>
<!-- HEADER -->
<header id="main-header" class="py-2 bg-primary text-white">
  <div class="container">
    <div class="row">
      <div class="col-md-6">
        <h1><i class="fas fa-cog"> 管理者儀表板</i></h1>
      </div>
    </div>
  </div>
</header>

<!-- ACTIONS -->
<section id="actions" class="py-4 bg-light">
  <div class="container">
    <div class="row">
      <div class="col-md-3">
        <a href="#" class="btn btn-primary btn-block" data-toggle="modal" data-target="#addInventoryModal">
          <i class="fas fa-plus"></i> 新增庫存
        </a>
      </div>
      <div class="col-md-3">
        <a href="#" class="btn btn-success btn-block" data-toggle="modal" data-target="#addOrderModal">
          <i class="fas fa-plus"></i> 新增訂單
        </a>
      </div>
      <div class="col-md-3">
        <a href="#" class="btn btn-warning btn-block text-black" data-toggle="modal" data-target="#addUserModal">
          <i class="fas fa-plus"></i> 新增使用者
        </a>
      </div>
    </div>
  </div>
</section>

<!-- SEARCH -->
<section id="search" class="py-4 mb-4 bg-light">
  <div class="container">
    <div class="row">
      <div class="col-md-6 ml-auto">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="搜尋...">
            <div class="input-group-append">
                <button class="btn btn-primary">搜尋</button>
            </div>
        </div>
      </div>
      <div class="col-md-6 ml-auto">
      	<div class="form-group">
      		<select name="#" id="theme" class="form-control">
      			<option>搜尋全部...</option>
      			<option>商品名稱</option>
      			<option>商品類別</option>
      			<option>訂單編號</option>
      			<option>寄送方式</option>
      			<option>買家帳號</option>
      			<option>付款方式</option>
      			<option>電子郵件</option>
      			<option>身份</option>
      		</select>
      	</div>
      </div>
     </div>
    </div>
   </section>

<!-- INVENTORY -->
<section id="inventory">
  <div class="container">
    <div class="row">
      <div class="col-md-9">
        <div class="card">
          <div class="card-header">
            <h4>最新庫存商品</h4>
          </div>
          <table class="table table-striped">
            <thead class="thead-dark">
              <tr>
                <th>#</th>
                <th>商品名稱</th>
                <th>商品類別</th>
                <th>商品數量（斤）</th>
                <th>商品單價</th>
                <th>商品快照</th>
                <th>商品描述</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>1</td>
                <td>香菜</td>
                <td>蔬菜</td>
                <td>100</td>
                <td>10</td>
                <td>EMPTY</td>
                <td>EMPTY</td>
                <td>
                  <!-- <a href="/controller.AdminInventoryDetailController" class="btn btn-secondary">
                    <i class="fas fa-angle-double-right"></i> 詳細資訊
                  </a> -->
				  <form class="form" name="DirectInventoryDetailForm"
					action=<jstl:url value="/controller.AdminInventoryDetailController" />
					method="post">
				  <input type="submit"
				   class="btn btn-secondary" title="Admin InventoryDetail Button"
				    name="adminInventoryDetailButton" value="詳細資訊">
				  </form>
			   </td>
              </tr>
              <tr>
                <td>2</td>
                <td>高麗菜</td>
                <td>蔬菜</td>
                <td>300</td>
                <td>10</td>
                <td>EMPTY</td>
                <td>EMPTY</td>
                <td>
                   <form class="form" name="DirectInventoryDetailForm"
					action=<jstl:url value="/controller.AdminInventoryDetailController" />
					method="post">
				  <input type="submit"
				   class="btn btn-secondary" title="Admin InventoryDetail Button"
				    name="adminInventoryDetailButton" value="詳細資訊">
				  </form>
                </td>
              </tr>
              <tr>
                <td>3</td>
                <td>花椰菜</td>
                <td>蔬菜</td>
                <td>400</td>
                <td>10</td>
                <td>EMPTY</td>
                <td>EMPTY</td>
                <td>
                   <form class="form" name="DirectInventoryDetailForm"
					action=<jstl:url value="/controller.AdminInventoryDetailController" />
					method="post">
				  <input type="submit"
				   class="btn btn-secondary" title="Admin InventoryDetail Button"
				    name="adminInventoryDetailButton" value="詳細資訊">
				  </form>
                </td>
              </tr>
              <tr>
                <td>4</td>
                <td>蘋果</td>
                <td>水果</td>
                <td>1</td>
                <td>10</td>
                <td>EMPTY</td>
                <td>EMPTY</td>
                <td>
                   <form class="form" name="DirectInventoryDetailForm"
					action=<jstl:url value="/controller.AdminInventoryDetailController" />
					method="post">
				  <input type="submit"
				   class="btn btn-secondary" title="Admin InventoryDetail Button"
				    name="adminInventoryDetailButton" value="詳細資訊">
				  </form>
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
      
      
      <div class="col-md-3">
        <div class="card text-center bg-primary text-white mb-3">
          <div class="card-body">
            <h3>庫存商品</h3>
            <h4 class="display-4">
              <i class="fas fa-pencil-alt"></i> 6
            </h4>
            <a href=<jstl:url value="/AdminProduct/inventories"/> class="btn btn-outline-light btn-sm">檢視</a>
          </div>
        </div>

        <div class="card text-center bg-success text-white mb-3">
          <div class="card-body">
            <h3>訂單</h3>
            <h4 class="display-4">
              <i class="fas fa-folder"></i> 4
            </h4>
            <a href=<jstl:url value="/orders"/> class="btn btn-outline-light btn-sm">檢視</a>
          </div>
        </div>

        <div class="card text-center bg-warning text-white mb-3">
          <div class="card-body">
            <h3>使用者</h3>
            <h4 class="display-4">
              <i class="fas fa-users"></i> 4
            </h4>
            <a href="<jstl:url value="/AdminProfile/list" />" class="btn btn-outline-light btn-sm" > Show Profile </a>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- FOOTER -->
<%@include file="/WEB-INF/pages/AdminFooter2.jsp" %>
  
  <!-- MODALS -->

<!-- ADD Inventory MODAL -->
<div class="modal fade" id="addInventoryModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-primary text-white">
        <h5 class="modal-title">新增庫存</h5>
        <button class="close" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="inventoryTitle">商品名稱
            </label>
            <input type="text" class="form-control">
          </div>
          <div class="form-group">
            <label for="inventoryCategory">商品類別</label>
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
            <label for="inventoryPrice">商品單價</label>
            <div class="input-group">
              <div class="input-group-prepend">
                  <span class="input-group-text">NT$</span>
              </div>
              <input class="form-control" type="text">
              <div class="input-group-append">
                  <span class="input-group-text">元</span>
              </div>
          </div>
          </div>
          <div class="form-group">
            <label for="image">上傳圖片</label>
            <div class="custom-file">
              <input type="file" class="custom-file-input" id="image">
              <label for="image" class="custom-file-label">選擇檔案</label>
            </div>
            <small class="form-text text-muted">檔案勿超過3MB</small>
          </div>
          <div class="form-group">
            <label for="inventoryDiscription">商品描述</label>
            <textarea name="editor1" class="form-control"></textarea>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-primary" data-dismiss="modal">儲存</button>
      </div>
    </div>
  </div>
</div>

<!-- ADD Order MODAL -->
<div class="modal fade" id="addOrderModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-success text-white">
        <h5 class="modal-title">新增訂單</h5>
        <button class="close" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
          <label for="orderTitle">商品名稱
            </label>
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
      <div class="modal-footer">
        <button class="btn btn-success" data-dismiss="modal">儲存</button>
      </div>
    </div>
  </div>
</div>

<!-- ADD User MODAL -->
<div class="modal fade" id="addUserModal">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header bg-warning text-black">
        <h5 class="modal-title">新增使用者</h5>
        <button class="close" data-dismiss="modal">
          <span>&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form name="newUserForm" action="<jstl:url value="/controller.AdminNewUserController" />" method="post">
          <div class="form-group">
            <label for="email">電子信箱</label>
            <input type="email" class="form-control" name="newEmail">
          </div>
          <div class="form-group">
            <label for="password">密碼</label>
            <input type="password" class="form-control" name="newPwd">
          </div>
          <div class="form-group">
            <label for="password2">確認密碼</label>
            <input type="password" class="form-control" name="repeatPwd">
          </div>
          <div class="form-group">
            <label for="orderPayMethod">身份</label>
            <select class="form-control" name="userType">
              <option value="">一般使用者</option>
              <option value="">管理者</option>
            </select>
           </div>
        </form>
      </div>
      <div class="modal-footer">
        <button class="btn btn-warning" data-dismiss="modal">儲存</button>
      </div>
    </div>
  </div>
</div>
<script src="http://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
    crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
    crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
    crossorigin="anonymous"></script>
  <script src="https://cdn.ckeditor.com/4.9.2/standard/ckeditor.js"></script>

  <script>
    // Get the current year for the copyright
    $('#year').text(new Date().getFullYear());

   /*  CKEDITOR.replace('editor1'); */
  </script>
</body>


</html>