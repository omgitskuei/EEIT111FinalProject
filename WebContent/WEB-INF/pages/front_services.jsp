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
<title>商品服務</title>
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
                    <h1>服務</h1>
                    <p>讓您購買安心與食用安心是本公司的最高原則</p>
                </div>
            </div>
          </div>
        </div>
    </header>

<!-- BREADCRUMB & SEARCH BAR -->
<section class="py-3">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <ol class="breadcrumb">
          <li class="breadcrumb-item">商品全覽</li>
        </ol>
      </div>
    <div class="col-md-6 ml-auto">
      <form action="#" class="form-inline">
        <div class="dropdown mx-4">
          <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            選擇類型
          </button>
          <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
            <a class="dropdown-item" href="#">蔬菜</a>
            <a class="dropdown-item" href="#">水果</a>
          </div>
        </div>
        <input type="text" class="form-control mr-2" placeholder="搜尋商品">
        <button class="btn btn-outline-success">搜尋</button>

      </form>
    </div>
  </div>
</div>
</section>



    <!-- SERVICES SECTION -->
<section id="services" class="py-3">
    <div class="container">
        <div class="row mb-4">
            <div class="col-md-4">
                <div class="card box-shadow">
                    <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/301x200/?fruit" alt="">
                    <div class="card-body">
                        <h4 class="card-title">商品一</h4>
                        <p class="card-text">
                            <small class="text-muted">Last updated 3 mins ago</small>
                        </p>
                        <div class="row ml-5">
                        <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                        <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                      </div>
                    </div>
                </div>
            </div>
            
            <div class="col-md-4">
                <div class="card box-shadow">
                    <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/300x200/?fruit" alt="">
                    <div class="card-body">
                        <h4 class="card-title">商品二</h4>
                        <p class="card-text">
                            <small class="text-muted">Last updated 3 mins ago</small>
                        </p>
                        <div class="row ml-5">
                          <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                          <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                        </div>  
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card box-shadow">
                    <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/299x200/?food" alt="">
                    <div class="card-body">
                        <h4 class="card-title">商品三</h4>
                        <p class="card-text">
                            <small class="text-muted">Last updated 3 mins ago</small>
                        </p>
                        <div class="row ml-5">
                          <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                          <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                        </div> 
                    </div>
                </div>
            </div>
        </div>
        <div class="row mb-4">
          <div class="col-md-4">
              <div class="card box-shadow">
                  <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/302x200/?fruit" alt="">
                  <div class="card-body">
                      <h4 class="card-title">商品四</h4>
                      <p class="card-text">
                          <small class="text-muted">Last updated 3 mins ago</small>
                      </p>
                      <div class="row ml-5">
                        <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                        <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                      </div> 
                  </div>
              </div>
          </div>
          
          <div class="col-md-4">
              <div class="card box-shadow">
                  <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/301x202/?fruit" alt="">
                  <div class="card-body">
                      <h4 class="card-title">商品五</h4>
                      <p class="card-text">
                          <small class="text-muted">Last updated 3 mins ago</small>
                      </p>
                      <div class="row ml-5">
                        <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                        <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                      </div>  
                  </div>
              </div>
          </div>
          <div class="col-md-4">
              <div class="card box-shadow">
                  <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/300x201/?food" alt="">
                  <div class="card-body">
                      <h4 class="card-title">商品六</h4>
                      <p class="card-text">
                          <small class="text-muted">Last updated 3 mins ago</small>
                      </p>
                      <div class="row ml-5">
                        <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                        <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                      </div> 
                  </div>
              </div>
          </div>
      </div>
      <div class="row mb-4">
        <div class="col-md-4">
            <div class="card box-shadow">
                <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/303x200/?fruit" alt="">
                <div class="card-body">
                    <h4 class="card-title">商品七</h4>
                    <p class="card-text">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </p>
                    <div class="row ml-5">
                      <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                      <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                    </div>  
                </div>
            </div>
        </div>
        
        <div class="col-md-4">
            <div class="card box-shadow">
                <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/303x202/?fruit" alt="">
                <div class="card-body">
                    <h4 class="card-title">商品八</h4>
                    <p class="card-text">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </p>
                    <div class="row ml-5">
                      <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                      <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                    </div> 
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card box-shadow">
                <img class="card-img-top img-fluid" src="https://source.unsplash.com/random/298x200/?food" alt="">
                <div class="card-body">
                    <h4 class="card-title">商品九</h4>
                    <p class="card-text">
                        <small class="text-muted">Last updated 3 mins ago</small>
                    </p>
                    <div class="row ml-5">
                      <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>
                      <a href="#" class="btn btn-danger  mt-2 ml-2">加入購物車</a>   
                    </div> 
                </div>
            </div>
        </div>
    </div>
    </div>
</section>

<!-- PAGINATION -->
<nav class="container pagination">
  <ul class="pagination">
      <li class="page-item disabled">
          <a class="page-link" href="#">
              <span>«</span>
              <span class="sr-only">Previous</span>
          </a>
      </li>
      <li class="page-item active">
          <a class="page-link" href="#">1</a>
      </li>
      <li class="page-item">
          <a class="page-link" href="#">2</a>
      </li>
      <li class="page-item">
          <a class="page-link" href="#">3</a>
      </li>
      <li class="page-item">
          <a class="page-link" href="#">
              <span>»</span>
              <span class="sr-only">Next</span>
          </a>
      </li>
  </ul>
</nav>

     
<!-- FAQ -->
<section id="faq" class="p-5 bg-dark text-white">
  <div class="container">
    <h1 class="text-center">常見問題</h1>
    <hr>
    <div class="row">
      <div class="col-md-6">
        <div id="accordion">
          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseOne" data-toggle="collapse" data-parent="accordion" aria-expanded="true" class="">
                  Q1：如果貨送過來爛掉了怎麼辦？
                </a>
              </h5>
            </div>

            <div id="collapseOne" class="collapse show" style="">
              <div class="card-body">
                請透過聯絡我們告知本公司，本公司會派勿六去做回收食物，再透過物流寄送一批新貨給您，不用負擔任何費用，彼此做人留一線，日後好相見。
              </div>
            </div>
          </div>

          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseTwo" data-toggle="collapse" data-parent="accordion">
                  Q2：如果發現某超商賣的貨源比較便宜怎辦？
                </a>
              </h5>
            </div>

            <div id="collapseTwo" class="collapse">
              <div class="card-body">
                麻煩透過聯絡我們吿訴我們，提出證明，本公司會給予補助。
              </div>
            </div>
          </div>

          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseThree" data-toggle="collapse" data-parent="accordion">
                  Q3：是否有國際寄送服務？
                </a>
              </h5>
            </div>

            <div id="collapseThree" class="collapse">
              <div class="card-body">
                目前沒有喔，未來也沒打算。
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-6">
        <div id="accordion">
          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseFour" data-toggle="collapse" data-parent="accordion">
                  Q4：為何不進貨香菜？
                </a>
              </h5>
            </div>

            <div id="collapseFour" class="collapse">
              <div class="card-body">
                本公司的創辦人，不愛香菜，因而本公司禁止出現香菜任何字眼與圖片。
              </div>
            </div>
          </div>

          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseFive" data-toggle="collapse" data-parent="accordion">
                  Q5：是否有實體店面？
                </a>
              </h5>
            </div>

            <div id="collapseFive" class="collapse">
              <div class="card-body">
                本公司不提供實體店面。
              </div>
            </div>
          </div>

          <div class="card">
            <div class="card-header">
              <h5 class="mb-0">
                <a href="#collapseSix" data-toggle="collapse" data-parent="accordion">
                  Q5：是否有貨到付款？
                </a>
              </h5>
            </div>

            <div id="collapseSix" class="collapse">
              <div class="card-body">
                絕對有，歡迎使用。
              </div>
            </div>
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
