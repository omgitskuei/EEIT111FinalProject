<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>首頁</title>
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

              <a href=<jstl:url value="/directaboutus"/> class="nav-link">關於我們</a>

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

    <!-- SHOWCASE SLIDER -->
    <section id="showcase">
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item carousel-image-1 active">
            <div class="container">
              <div class="dark-overlay">
              <div class="carousel-caption d-none d-sm-block text-right mb-5">
                <h1 class="display-3">無農藥</h1>
                <p class="lead">
                  讓您吃得安心
                </p>
                <a href="signup.html" class="btn btn-success btn-lg btn-color-signup text-white">現在就註冊</a>
              </div>
              </div>
            </div>
          </div>

          <div class="carousel-item carousel-image-2">
            <div class="dark-overlay">
            <div class="container">
              <div class="carousel-caption d-none d-sm-block mb-5">
                <h1 class="display-3">低GI，低熱量</h1>
                <p class="lead">
                  專為健身減肥的人準備
                </p>
              </div>
            </div>
          </div>
          </div>

          <div class="carousel-item carousel-image-3">
            <div class="dark-overlay">
            <div class="container">
              <div class="carousel-caption d-none d-sm-block text-right mb-5">
                <h1 class="display-3">品質保證</h1>
                <p class="lead">
                  絕對有通過食品安全認證，也...絕對沒有香菜
                </p>
              </div>
            </div>
          </div>
          </div>
        </div>

        <a href="#myCarousel" data-slide="prev" class="carousel-control-prev">
          <span class="carousel-control-prev-icon"></span>
        </a>

        <a href="#myCarousel" data-slide="next" class="carousel-control-next">
          <span class="carousel-control-next-icon"></span>
        </a>
      </div>
    </section>

    <!-- HOME ICON SECTION -->
    <section id="home-icons" class="py-5">
      <div class="container">
        <div class="row">
          <div class="col-md-4 mb-4 text-center">
            <i class="fas fa-user-shield fa-3x mb-2"> </i>
            <h3>食品安全</h3>
            <p>
              我們專注於食品安全，所有架上的食品都會通過嚴厲的審核，請購買人士安心
            </p>
          </div>
          <div class="col-md-4 mb-4 text-center">
            <i class="fas fa-shopping-bag fa-3x mb-2"> </i>
            <h3>不用出門買菜</h3>
            <p>
              我們主打食品線上化，不用在煩惱出門得武漢肺癌的疑慮，去到菜市場密集的空間，總是令人擔憂
            </p>
          </div>
          <div class="col-md-4 mb-4 text-center">
            <i class="fab fa-alipay fa-3x mb-2"> </i>
            <h3>金錢公開透明</h3>
            <p>
              我們只會比別人便宜不會比別人貴，架上金額就是您所購買的金額，第一年試營運不用運費
            </p>
          </div>
        </div>
      </div>
    </section>

    <!-- HOME HEADING SECTION -->
    <section id="home-heading" class="p-5">
      <div class="dark-overlay">
        <div class="row">
          <div class="col">
            <div class="container pt-5">
              <h1>還在想什麼？</h1>
              <p class="d-none d-md-block">
                歡迎加入FarmVille線上買菜平台，絕對給您前所未有的買菜樂趣，買菜與玩開心農場一樣簡單
              </p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- INFO SECTION -->
    <section id="info" class="py-3">
      <div class="container">
        <div class="row">
          <div class="col-md-6 align-self-center">
            <h3>本月主打商品</h3>
            <p>
              這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字這是文字
            </p>
            <a href="stock.html" class="btn btn-outline-danger btn-lg">前往觀看</a>
          </div>
          <div class="col-md-6">
            <img src="img/glozzom/laptop.png" alt="商品圖片，寫死的，可能沒讀到" class="img-fluid" />
          </div>
        </div>
      </div>
    </section>

    <!-- VIDEO PLAY -->
    <!-- 抓Youtube網址後的ID -->
    <section id="video-play">
      <div class="dark-overlay">
        <div class="row">
          <div class="col">
            <div class="container p-5">
              <a
                href="#"
                class="video"
                data-video="https://www.youtube.com/embed/Icg1cjQED8I"
                data-toggle="modal"
                data-target="#videoModal"
              >
                <i class="fas fa-play fa-3x"></i>
              </a>
              <h1>我們在做什麼？</h1>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- PHOTO PRODUCT GALLERY -->
    <!-- 這部分要額外CDN -->
    <section id="gallery" class="py-5">
      <div class="container">
        <h1 class="text-center">促銷商品</h1>
        <p class="text-center">點按商品可以看更多商品資訊</p>
        <div class="row mb-4">
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/560x560/?food" data-toggle="lightbox" data-gallery="img-gallery" data-height="560"
              data-width="560">
              <img src="https://source.unsplash.com/random/560x560" alt="" class="img-fluid">
            </a>
          </div>
  
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/561x561" data-toggle="lightbox" data-gallery="img-gallery" data-height="561"
              data-width="561">
              <img src="https://source.unsplash.com/random/561x561" alt="" class="img-fluid">
            </a>
          </div>
  
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/562x562" data-toggle="lightbox" data-gallery="img-gallery" data-height="562"
              data-width="562">
              <img src="https://source.unsplash.com/random/562x562" alt="" class="img-fluid">
            </a>
          </div>
        </div>
  
        <div class="row mb-4">
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/563x563" data-toggle="lightbox" data-gallery="img-gallery" data-height="563"
              data-width="563">
              <img src="https://source.unsplash.com/random/563x563" alt="" class="img-fluid">
            </a>
          </div>
  
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/564x564" data-toggle="lightbox" data-gallery="img-gallery" data-height="564"
              data-width="564">
              <img src="https://source.unsplash.com/random/564x564" alt="" class="img-fluid">
            </a>
          </div>
  
          <div class="col-md-4">
            <a href="https://source.unsplash.com/random/565x565" data-toggle="lightbox" data-gallery="img-gallery" data-height="565"
              data-width="565">
              <img src="https://source.unsplash.com/random/565x565" alt="" class="img-fluid">
            </a>
          </div>
        </div>
      </div>
    </section>

    <!-- NEWSLETTER -->
    <section id="newsletter" class="text-center p-5 bg-dark text-white">
      <div class="container">
        <div class="row">
          <div class="col">
            <h1>訂閱我們的電子報</h1>
            <p>即時收到本公司的最新通知，有任何食品促銷會在第一時間通知您，您也可以隨時取消訂閱</p>
            <form action="" class="form-inline justify-content-center">
              <input type="text" class="form-control mb-2 mr-2" placeholder="輸入電子信箱">
              <button class="btn btn-success text-white mb-2">送出</button>
            </form>
          </div>
        </div>
      </div>
    </section>

    <!-- FOOTER -->
    <footer id="main-footer" class="text-center p-4 ">
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

    <!-- VIDEO MODAL -->
    <div class="modal fade" id="videoModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-body">
            <button class="close" data-dismiss="modal">
              <span>&times;</span>
            </button>
            <iframe
              src=""
              frameborder="0"
              height="350"
              width="100%"
              allowfullscreen
            ></iframe>
          </div>
        </div>
      </div>
    </div>

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
    <script src="https://kit.fontawesome.com/c3dc04dc4d.js" crossorigin="anonymous"></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
      integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
      crossorigin="anonymous"
    ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.min.js" integrity="sha256-Y1rRlwTzT5K5hhCBfAFWABD4cU13QGuRN6P5apfWzVs=" crossorigin="anonymous"></script>
    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());

      // Configure Slider
      $(".carousel").carousel({
        interval: 6000,
        pause: "hover"
      });
      // LightBox Init
      $(document).on('click', '[data-toggle="lightbox"]', function(event) {
                event.preventDefault();
                $(this).ekkoLightbox();
            });

      // Video Play
      $(function() {
        // Auto play modal video
        $(".video").click(function() {
          var theModal = $(this).data("target"),
            videoSRC = $(this).attr("data-video"),
            videoSRCauto =
              videoSRC +
              "?modestbranding=1&rel=0&controls=0&showinfo=0&html5=1&autoplay=1";
          $(theModal + " iframe").attr("src", videoSRCauto);
          $(theModal + " button.close").click(function() {
            $(theModal + " iframe").attr("src", videoSRC);
          });
        });
      });
    </script>
  </body>
</html>
