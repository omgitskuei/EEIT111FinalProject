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
   <title>結帳</title>
  </head>
  <body>
    <!-- START -->
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
                    <h1>結帳</h1>
                    <p>此為您的帳單</p>
                </div>
            </div>
        </div>
      </div>
    </header>

<!-- CHECKOUT SECTION -->
<section class="py-3">
<div class="container" >
  <div class="row mt-3">
      <div class="col-12 col-md">
          <div class="alert alert-success alert-rounded text-center" role="alert">1.輸入訂單資料</div>
      </div>
      <div class="col-12 col-md">
          <div class="alert alert-light alert-rounded text-center" role="alert">2.金流付款</div>
      </div>
      <div class="col-12 col-md">
          <div class="alert alert-light alert-rounded text-center" role="alert">3.訂單完成</div>
      </div>
  </div>

  <div class="row justify-content-center mt-4">
      <div class="col-md-8">
          <div class="accordion" id="accordionExample">
              <div class="card card-bottom">
                  <div class="card-header  d-flex justify-content-between" id="headingOne">
                      <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne"
                          aria-expanded="true" aria-controls="collapseOne">
                          顯示購物車細節
                      </button>
                      <div class="h3 d-inline-block mt-2">
                          <strong>$ 1059</strong>
                      </div>
                  </div>

              </div>
              <div id="collapseOne" class="collapse show " aria-labelledby="headingOne" data-parent="#accordionExample">
                  <table class="table table-sm">
                      <thead>
                          <tr>
                              <th width="20"></th>
                              <th width="100"></th>
                              <th> 商品名稱</th>
                              <th>數量</th>
                              <th class="text-center" width="120">小計</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr>
                              <td class="align-middle"><a href="#removeModal" class="text-dark" data-price="999"
                                      data-title="一級偽裝帽" data-toggle="modal" data-target="#removeModal"><i class="far fa-trash-alt mr-3"></i></a></td>
                              <td class="align-middle">
                                  <div class="card p-1 card-bottom">
                                      <img src="https://images.unsplash.com/photo-1447005497901-b3e9ee359928?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=967&q=80"
                                          alt="..." width="80px;">
                                  </div>
                              </td>
                              <td class="align-middle "> 一級偽裝帽</td>
                              <td class="align-middle">1件</td>
                              <td class="align-middle text-right">$999</td>
                          </tr>
                          <tr class="text-right">
                              <td colspan="4"><strong>運費</strong></td>
                              <td><strong>$ 60</strong></td>
                          </tr>
                          <tr class="text-right">
                              <td colspan="4"><strong>合計</strong></td>
                              <td><strong>$ 1059</strong></td>
                          </tr>
                      </tbody>

                  </table>


              </div>
          </div>

          <div class="card text-center my-5 border-0">
              <div class="card-header border-0">
                  <div class="h3 mt-1"> 訂購人資訊 </div>
              </div>
              <form class="needs-validation" novalidate>
                  <div class="form-row text-left mt-3">
                      <div class="form-group col-md-6">
                          <label for="name">姓名</label>
                          <input type="text" class="form-control " id="name" placeholder="姓名" required>
                          <div class="invalid-feedback">請填寫姓名</div>
                      </div>
                      <div class="form-group col-md-6">
                          <label for="mail">Email</label>
                          <input type="email" class="form-control" id="mail" placeholder="Email" required>
                          <div class="invalid-feedback">請填寫Email</div>
                      </div>
                  </div>
                  <div class="form-row text-left">
                      <div class="form-group col-md-4">
                          <label for="section">國家</label>
                          <select name="" id="section" class="form-control">
                              <option value="">台灣</option>
                              <option value="">...</option>
                          </select>
                      </div>
                      <div class="form-group col-md-4">
                          <label for="zone">城市</label>
                          <select name="" id="zone" class="form-control">
                              <option value="">台北市</option>
                              <option value="">台中市</option>
                              <option value="">高雄市</option>
                          </select>
                      </div>
                      <div class="form-group col-md-4">
                          <label for="postal-code">郵遞區號</label>
                          <input type="text" class="form-control" id="postal-code" placeholder="" required>
                      </div>
                  </div>
                  <div class="form-row">
                      <label for="address">地址</label>
                      <input type="text" class="form-control" id="mail" required>
                  </div>
                  <div class="form-row">
                    <label for="shipaddress">送貨地址</label>
                    <input type="text" class="form-control" id="mailaddress" required>
                  </div>
                  <div class="mt-3 d-flex justify-content-end">
                      <a href="service.html" class="btn btn-secondary mr-2">繼續選購</a>
                      <a href="orderfinish.html" type="submit" class="btn btn-success">確認付款</a>
                  </div>
              </form>
              </section>

    <!-- FOOTER -->
    <footer id="main-footer" class="text-center p-4 bg-dark text-white">
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
    <script src="https://kit.fontawesome.com/c3dc04dc4d.js" crossorigin="anonymous"></script>
    <script>
      // Get the current year for copyright
      $("#year").text(new Date().getFullYear());
      

      
    </script>
    </body>
</html>
