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
    <title>單一商品</title>
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
              <a href="services.html" class="nav-link active">服務</a>
            </li>
            <li class="nav-item">
              <a href="contact.html" class="nav-link">聯絡我們</a>
            </li>
            <li class="nav-item">
              <a href="shoppingcart.html" class="nav-link">購物車</a>
            </li>
            <li class="nav-item">
              <a href="login.html" class="nav-link">註冊/登入</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- PAGE HEADER -->
<section>
    <header id="page-header">
      <div class="dark-overlay-title">
        <div class="container">
            <div class="row">
                <div class="col-md-6 m-auto text-center">
                    <h1>商品</h1>
          
                </div>
            </div>
          </div>
        </div>
    </header>
  </section>

<section class="my-3">
    <div class="container">
      <div class="row">
      <div class="col-md-12">
        <ol class="breadcrumb">
          <li class="breadcrumb-item">商品全覽</li>
        </ol>
      </div>
    </div>
  </div>
  </section>

  <!-- STOCK -->
  <section class="py-3">
  <div class="container">
      <div class="row">
          <div class="col-md-4">
              <div class="sticky-top" style="top: 10px;">
                  <img src="https://source.unsplash.com/random/400x500/?fruit" class="mb-3 img-fluid" alt="">
                  <h1>商品標題<small class="text-secondary ml-1">副標題</small></h1>
                  <div class="d-flex justify-content-end align-items-end">
                      <del class="text-muted">售價 $2999</del>
                      <div class="h3 ml-auto mb-0 text-danger">
                          <small>特價 $NT</small>
                          <strong> 1999</strong>
                      </div>
                  </div>
                  <hr>
                  <div class="input-group mt-3">
                      <select name="" id="" class="form-control">
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                      </select>
                      <a href="#" class="btn btn-success text-white ml-1">加入購物車</a>
                  </div>
              </div>

          </div>
          <div class="col-md-8">
              <h2>商品特色</h2>
              <ul>
                <li class="h3">商品特色一</li>
                <li class="h3">商品特色二</li>
                <li class="h3">商品特色三</li>
              </ul>

              <div class="card mt-5">
                  <div class="card-body bg-light">
                      <h2 class="text-center">購物說明</h2>
                      <p>
                        <ul>
                          <li>
                            選好數量（斤），按下加入購物車
                          </li>
                          <li>
                            有效退費或換貨，只要尚未經過任何加工
                          </li>
                          <li>
                            選好商品到資料庫做結帳
                          </li>
                          <li>
                            有任何問題請透過聯絡我們
                          </li>
                        </ul>
                      </p>
                  </div>
              </div>
          </div>
      </div>
  </div>
</section>


    <!-- FOOTER -->
    <footer id="main-footer" class="text-center p-4 text-white bg-dark">
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
