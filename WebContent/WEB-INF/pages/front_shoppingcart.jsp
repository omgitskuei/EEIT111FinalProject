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
<title>購物車</title>
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
                    <h1>購物車</h1>
                    <p>您所購買的商品</p>
                </div>
            </div>
        </div>
      </div>
    </header>

<!-- SHOPPINGCART SECTION -->
<section class="py-3">
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col"><label class="img"></label> </th>
                            <th scope="col"><label class="name">商品名稱</label></th>
                            <th scope="col"><label class="inventory">庫存狀況</label></th>
                            <th scope="col" class="text-center"><label class="quentity">數量</label></th>
                            <th scope="col" class="text-right"><label class="price">金額</label></th>
                            <th><label class="delete"></label></th>
                        </tr>
                    </thead>
                    <tbody class="list_area">
                        <tr>
                            <td><img src="https://source.unsplash.com/random/51x50/?food" /> </td>
                            <td>商品一</td>
                            <td>足夠</td>
                            <td><input class="form-control" type="text" value="2" /></td>
                            <td class="text-right price">NT$ 100</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td><img src="https://source.unsplash.com/random/50x50/?food" /> </td>
                            <td class="name">商品二</td>
                            <td>足夠</td>
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-right price">NT$ 50</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td><img src="https://source.unsplash.com/random/50x52/?food" /> </td>
                            <td class="name">商品三</td>
                            <td>足夠</td>
                            <td><input class="form-control" type="text" value="1" /></td>
                            <td class="text-right price">NT$ 30</td>
                            <td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>購買總金額</td>
                            <td class="text-right">NT$ 180</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td>運費</td>
                            <td class="text-right">NT$ 18</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td><strong>總金額</strong></td>
                            <td class="text-right"><strong>NT$ 198</strong></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="col mb-2">
            <div class="row">
                <div class="col-sm-12  col-md-6">
                    <button class="btn btn-lg btn-block btn-light">繼續購物</button>
                </div>
                <div class="col-sm-12 col-md-6 text-right">
                    <a href="checkout.html" class="btn btn-lg btn-block btn-success text-white">結帳</a>
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
