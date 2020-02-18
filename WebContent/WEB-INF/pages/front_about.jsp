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

  <title>關於我們</title>
  </head>
  <body>
 <!-- START -->
 
<!-- NAVBAR -->
<nav class="navbar navbar-expand-sm navbar-dark">
      <div class="container">
        <a href="index.html" class="navbar-brand">FarmVille</a>

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
                    <h1>關於我們</h1>
                </div>
            </div>
          </div>  
        </div>
    </header>

    <!-- ABOUT SECTION -->
    <section id="about" class="py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h1>我們做什麼？</h1>
                    <p>我們是一群來自資策會的合作夥伴，隨著科技不段進步，人們越來越靠著線上購物解決一切，達到不出門就可以購物的流程，但由於現今社會考量到食品新鮮度與食安問題，蔬果類的販售卻不是很多。</p>
                    <p>為了讓人們在食用上安心，我們在食物安全性上遵守政府的管道，絕不做偷工減料的事情，絕對對食品新鮮度有所注意，絕對無農藥噴灑，讓客戶吃得安心，才是本公司的最高原則，如果有任何問題，請隨時透過<a href="contact.html">聯繫我們</a>，並只要還沒吃過或調理過都...准許您無條件退換貨</p>
                    <p>由於武漢肺炎的盛行，請大家少去菜市場，多透過本公司的管道喔❤</p>
                </div>
                <div class="col-md-6">
                    <img src="https://source.unsplash.com/random/700x700/?food" alt="" class="img-fluid rounded-circle d-none d-md-block about-img">
                </div>
            </div>
        </div>
    </section>

    <!-- ICON BOXES -->
    <section id="icon-boxes" class="p-5">
        <div class="container">
            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="card bg-success text-white text-center card-height">
                        <div class="card-body">
                            <i class="fas fa-shipping-fast fa-3x"></i>
                            <h3>6hrs到貨</h3>
                            講究食品新鮮度，我們在物流過程中絕對不超過24小時，就能讓這些蔬果回到您的冰箱內。
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card bg-dark text-white text-center card-height">
                        <div class="card-body">
                            <i class="fas fa-exchange-alt fa-3x"></i>
                            <h3>無條件退換貨</h3>
                            客戶第一，食品本身攸關自身身體健康，只要您無加工只要發現用農藥跡象或是不夠新鮮，歡迎退換貨。
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card bg-success text-white text-center card-height">
                        <div class="card-body">
                            <i class="fas fa-user-check fa-3x"></i>
                            <h3>24hrs客服服務</h3>
                            只要透過聯繫我們，會立即給予回覆，絕不超過3hrs，如果超過歡迎申訴，本公司立即給您補償。
                        </div>
                    </div>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-4">
                    <div class="card bg-dark text-white text-center card-height">
                        <div class="card-body">
                            <i class="fab fa-fedex fa-3x"></i>
                            <h3>與Fedex合作</h3>
                            When there is no tomorrow...
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card bg-success text-white text-center card-height">
                        <div class="card-body">
                            <i class="fab fa-usps fa-3x"></i>
                            <h3>與Usps合作</h3>
                            絕對不會只有一家物流可以選...
                        </div>
                    </div>
                </div>
                <div class="col-md-4">
                    <div class="card bg-dark text-white text-center card-height">
                        <div class="card-body">
                            <i class="fab fa-alipay fa-3x "></i>
                            <h3>與第三方支付合作</h3>
                            各大支付平台都可以使用喔
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- TESTIMONIALS -->
  <section id="testimonials" class="p-4 bg-dark text-white">
      <div class="container">
          <h2 class="text-center">各家推薦</h2>
          <div class="row text-center">
              <div class="col">
                  <div class="slider">
                      <div>
                          <blockquote class="blockquote">
                              <p class="mb-0">
                                這是我第一次吃到這種味道，這道菜有著前所未有的新鮮味，溫潤的甜味，讓整盤菜更顯出奧妙....過熟柿子自然樸實的甜味，跟蔬菜的味道十分搭配，將青椒肉絲的嫩與脆襯托的更為出色，呈現出完美的青椒肉絲
                              </p>
                              <footer class="blockquote-footer">小當家
                                  <cite title="Company 1">中華一番</cite>
                              </footer>
                          </blockquote>
                      </div>
                      <div>
                        <blockquote class="blockquote">
                            <p class="mb-0">
                              這種濃郁的味道真不可思議，和極有嚼勁的面搭配起來，讓人不禁想要一口接一口...
                            </p>
                            <footer class="blockquote-footer">小當家
                                <cite title="Company 2">中華一番</cite>
                            </footer>
                        </blockquote>
                    </div>
                    <div>
                        <blockquote class="blockquote">
                            <p class="mb-0">
                              所謂的料理啊，就是把自己的一切都盛進盤子里。
                            </p>
                            <footer class="blockquote-footer">幸平城一郎
                                <cite title="Company 3">食戟之靈</cite>
                            </footer>
                        </blockquote>
                    </div>
                  </div>
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


    <!-- PAGE HEADER -->
    <header id="page-header" >
      <div class="dark-overlay-title">
      <div class="container">
        <div class="row">
          <div class="col-md-6 m-auto text-center">
            <h1>忘記密碼</h1>
          </div>
        </div>
      </div>
    </div>
    </header>

    <!-- LOGIN SECTION -->
<section class="py-3">
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card p-4">
          <div class="card-body">
            <form action="">
            <h3 class="text-center">輸入驗證碼</h3>
            <hr>
            <div class="row">
              <div class="col-md-12">
                <div class="form-group">
                  <label for="admincode">請輸入信箱的驗證碼</label>
                  <input type="text" class="form-control" placeholder="驗證碼：">
                  <span style="color: red;" class="ml-auto">驗證碼有效錯誤</span>
                </div>
              </div> 
              <div class="col-md-12">
                <div class="form-group">
                  <a href="authmail.html" type="submit" class="btn btn-success btn-block text-white">送出驗證信</a>
                </div>
              </div>
            </div>
          </form>
          </div>
        </div>
      </div>
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

    <script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js" integrity="sha256-NXRS8qVcmZ3dOv3LziwznUHPegFhPZ1F/4inU7uC8h0=" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/c3dc04dc4d.js" crossorigin="anonymous"></script>
  </head>
    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());


      $('.slider').slick({
          infinite: true,
          slideToSHow: 1,
          slideToScoll: 1

    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());
    </script>
  </body>
</html>
