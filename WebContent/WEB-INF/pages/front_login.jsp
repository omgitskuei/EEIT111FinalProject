<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <link href="https://fonts.googleapis.com/css?family=Kaushan+Script|Noto+Sans+TC&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" integrity="sha256-HAaDW5o2+LelybUhfuk0Zh2Vdk8Y2W2UeKmbaXhalfA=" crossorigin="anonymous" />
    <style>
    	<%@include file="/WEB-INF/css/bootstrap.css"%>
        <%@include file="/WEB-INF/css/style.css"%>
    </style>
<title>登入</title>
 </head>
  <body>
  <!-- START -->
    <nav class="navbar navbar-expand-sm navbar-dark">
      <div class="container">
        <a
          href="index.html"
          class="navbar-brand"
          style="font-family: 'Kaushan Script', cursive;"
          >FarmVille</a
        >
        <button
          class="navbar-toggler"
          data-toggle="collapse"
          data-target="#navbarCollapse"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item first">
              <a href="about.html" class="nav-link">關於我們</a>
            </li>
            <li class="nav-item">
              <a href="services.html" class="nav-link">服務</a>
            </li>
            <li class="nav-item">
              <a href="contact.html" class="nav-link">聯絡我們</a>
            </li>
            <li class="nav-item">
              <a href="shoppingcart.html" class="nav-link active">購物車</a>
            </li>
            <li class="nav-item">
              <a href="login.html" class="nav-link">登入</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- PAGE HEADER -->

    <header id="page-header">
      <div class="dark-overlay-title">
        <div class="container">
          <div class="row">
            <div class="col-md-6 m-auto text-center">
              <h1>訂單完成</h1>
              <p>感謝您</p>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- SHOPPINGCART SECTION -->
    <section class="py-3">
      <div class="container">
        <div class="row justify-content-center mt-3">
          <div class="col-md-8 text-center">
            <div class="alert alert-success alert-rounded " role="alert">
              3.訂單完成
            </div>
            <div class="h4">購買資訊</div>
            <table class="table table-sm my-4">
              <thead>
                <tr>
                  <th width="100"></th>
                  <th>商品名稱</th>
                  <th>數量</th>
                  <th class="text-center" width="120">小計</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td class="align-middle">
                    <div class="card p-1 card-bottom">
                      <img
                        src="https://images.unsplash.com/photo-1447005497901-b3e9ee359928?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80"
                        alt="..."
                        width="80px;"
                      />
                    </div>
                  </td>
                  <td class="align-middle ">一級偽裝帽</td>
                  <td class="align-middle">1件</td>
                  <td class="align-middle text-right">$999</td>
                </tr>
                <tr class="text-right">
                  <td colspan="3"><strong>運費</strong></td>
                  <td><strong>$ 60</strong></td>
                </tr>
                <tr class="text-right">
                  <td colspan="3"><strong>合計</strong></td>
                  <td><strong>$ 1059</strong></td>
                </tr>
              </tbody>
            </table>

            <div class="h4 mt-5">個人資料</div>
            <table class="table  mt-3 text-left">
              <tbody>
                <tr>
                  <th width="200">Email</th>
                  <td>ccc9***@happymail.com</td>
                </tr>
                <tr>
                  <th>姓名</th>
                  <td>王*明</td>
                </tr>
                <tr>
                  <th>電話</th>
                  <td>0912-345***</td>
                </tr>
                <tr>
                  <th>地址</th>
                  <td>台北市晴天路二段321號5樓</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <div class="text-center mt-4">
          <a href="index.html" class="btn btn-success px-5 text-white mb-3"
            >回首頁</a
          >
        </div>
      </div>
    </section>

    <!-- FOOTER -->
    <footer id="main-footer" class="text-center p-4 bg-dark text-white">
      <div class="container">
        <div class="row">
          <div class="col">
            <p>
              版權所有 &copy;
              <span id="year"> FarmVille</span>
            </p>
          </div>
        </div>
      </div>
    </footer>

    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
      integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
      integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"
      integrity="sha256-NXRS8qVcmZ3dOv3LziwznUHPegFhPZ1F/4inU7uC8h0="
      crossorigin="anonymous"
    ></script>
    <script
      src="https://kit.fontawesome.com/c3dc04dc4d.js"
      crossorigin="anonymous"
    ></script>
    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());
    </script>
  </body>
</html>
