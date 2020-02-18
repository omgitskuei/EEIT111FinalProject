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
   <title>聯絡我們</title>
  </head>
  <body>
    <!-- START -->
    <nav class="navbar navbar-expand-sm navbar-dark">
      <div class="container">
        <a href="index.html" class="navbar-brand" style="font-family: 'Kaushan Script', cursive;">FarmVille</a>
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
              <a href="contact.html" class="nav-link active">聯絡我們</a>
            </li>
            <li class="nav-item">
              <a href="shoppingcart.html" class="nav-link">購物車</a>
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
                    <h1>聯絡我們</h1>
                    <p>有任何問題歡迎與我們聯絡... </p>
                </div>
            </div>
        </div>
      </div>
    </header>
<!-- CONTACT SECTION -->
<section id="contact" class="py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-4">
        <div class="card p-4">
          <div class="card-body">
            <h4>Get In Touch</h4>
            <p>If you have any story to tell or would like to hear some of our company you can do so via the form: </p>
            <h4>地址：</h4>
            <p>5867 W Walbrook Dr. 95129 San Jose, CA</p>
            <h4>電子信箱：</h4>
            <p>luchienlin1994@gmail.com</p>
            <h4>電話：</h4>
            <p>(408)366-18888</p>
          </div>
        </div>
      </div>
      <div class="col-md-8">
        <div class="card p-4">
          <div class="card-body">
            <h3 class="text-center">請於表單輸入欲表達的內容：</h3>
            <hr>
            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="電子信箱：">
                </div>
              </div> 
              <div class="col-md-12">
                <div class="form-group">
                  <input type="text" class="form-control" placeholder="姓名：">
                </div>
              </div> 
              <div class="col-md-12">
                <div class="form-group">
                  <select class="form-control" id="QA">
                      <option>訂單問題</option>
                      <option>帳號問題</option>
                      <option>付款問題</option>
                      <option>商品問題</option>
                      <option>退換貨問題</option>
                      <option>其他問題</option>
                  </select>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <textarea name="" id="" cols="30" rows="10" class="form-control" placeholder="內容："></textarea>
                </div>
              </div>
              <div class="col-md-12">
                <div class="form-group">
                  <input type="submit" value="送出" class="btn btn-outline-danger btn-block">
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

<!-- STAFF -->
<section id="staff" class="py-5 text-center bg-dark text-white">
  <div class="container">
    <h1>我們的員工</h1>
    <hr>
    <div class="row mb-2">
      <div class="col-md-4">
        <img src="img/glozzom/person1.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>峰哥</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
      <div class="col-md-4">
        <img src="img/glozzom/person2.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>Jone Doe</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
      <div class="col-md-4">
        <img src="img/glozzom/person3.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>Jone Doe</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
    </div>
    <div class="row">
      <div class="col-md-4">
        <img src="img/glozzom/person4.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>Jone Doe</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
      <div class="col-md-4">
        <img src="img/glozzom/person4.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>Jone Doe</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
      <div class="col-md-4">
        <img src="img/glozzom/person4.jpg" alt="" class="img fluid rounded-circle mb-2">
        <h4>Jone Doe</h4>
        <p>這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字</p>
      </div>
    </div> 
  </div>
</section>

    <!-- FOOTER -->
    <footer id="main-footer" class="text-center p-4">
      <div class="container">
        <div class="row">
          <div class="col">
            <p>版權所有 &copy;
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js" integrity="sha256-NXRS8qVcmZ3dOv3LziwznUHPegFhPZ1F/4inU7uC8h0=" crossorigin="anonymous"></script>
    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());

    </script>
  </body>
</html>
