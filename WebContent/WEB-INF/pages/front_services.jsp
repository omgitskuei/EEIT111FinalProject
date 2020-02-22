<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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
  <%@include file="/WEB-INF/pages/front_navbar.jsp" %>

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
        <div class="row mt-3">
        <jstl:forEach var="product" items="${InventoryList}" >
            <div class="col-md-4">
                <div class="card box-shadow">
                    <img class="card-img-top img-fluid" src="${product.productImg}" alt="${product.productName} 的圖" width="250px">
                    <div class="card-body">
                        <p>商品ID : productID </p>
                        <h4 class="card-title">${product.productName}</h4>
                        <p class="card-text">
                            <small class="text-muted">上架時間: ${product.productTimestamp}</small>
                        </p>
                        <p class="card-text">
                          <samll class="text-muted card-service-height">${product.productDescription}</samll>
                        </p>
                        <h3 id="productPrice" class="card-text">價格: ${product.productPrice} 元</h3>
                        <div class="row ml-5">
                        <a href="stock.html" class="btn btn-success text-white mt-2 ml-2">查看</a>

                        <a href="#" class="btn btn-danger  mt-2 ml-2 add-to-cart" data-name="${product.productName}" data-price="${product.productPrice}">加入購物車</a>   

                      </div>
                    </div>
                </div>
            </div>
        </jstl:forEach>
    <div>
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

       

      
       <script>
    // ***************************************************
    // Shopping Cart functions

    var shoppingCart = (function () {
        // Private methods and properties
        var cart = [];

        function Item(name, price, count) {
            this.name = name
            this.price = price
            this.count = count
        }

        function saveCart() {
            localStorage.setItem("shoppingCart", JSON.stringify(cart));
        }

        function loadCart() {
            cart = JSON.parse(localStorage.getItem("shoppingCart"));
            if (cart === null) {
                cart = []
            }
        }

        loadCart();



        // Public methods and properties
        var obj = {};

        obj.addItemToCart = function (name, price, count) {
            for (var i in cart) {
                if (cart[i].name === name) {
                    cart[i].count += count;
                    saveCart();
                    return;
                }
            }

            console.log("addItemToCart:", name, price, count);

            var item = new Item(name, price, count);
            cart.push(item);
            saveCart();
        };

        obj.setCountForItem = function (name, count) {
            for (var i in cart) {
                if (cart[i].name === name) {
                    cart[i].count = count;
                    break;
                }
            }
            saveCart();
        };


        obj.removeItemFromCart = function (name) { // Removes one item
            for (var i in cart) {
                if (cart[i].name === name) { // "3" === 3 false
                    cart[i].count--; // cart[i].count --
                    if (cart[i].count === 0) {
                        cart.splice(i, 1);
                    }
                    break;
                }
            }
            saveCart();
        };


        obj.removeItemFromCartAll = function (name) { // removes all item name
            for (var i in cart) {
                if (cart[i].name === name) {
                    cart.splice(i, 1);
                    break;
                }
            }
            saveCart();
        };


        obj.clearCart = function () {
            cart = [];
            saveCart();
        }


        obj.countCart = function () { // -> return total count
            var totalCount = 0;
            for (var i in cart) {
                totalCount += cart[i].count;
            }

            return totalCount;
        };

        obj.totalCart = function () { // -> return total cost
            var totalCost = 0;
            for (var i in cart) {
                totalCost += cart[i].price * cart[i].count;
            }
            return totalCost.toFixed(2);
        };

        obj.listCart = function () { // -> array of Items
            var cartCopy = [];
            console.log("Listing cart");
            console.log(cart);
            for (var i in cart) {
                console.log(i);
                var item = cart[i];
                var itemCopy = {};
                for (var p in item) {
                    itemCopy[p] = item[p];
                }
                itemCopy.total = (item.price * item.count).toFixed(2);
                cartCopy.push(itemCopy);
            }
            return cartCopy;
        };

        // ----------------------------
        return obj;
    })();
    </script>

       
       <script>
        // event就像一個function可以帶值進去
        $(".add-to-cart").click(function(event){
          // 不要a連結做預設動作
          event.preventDefault();
          // this代表點下去的那個
          // .attr("可以加一個屬性")
          var name = $(this).attr("data-name");
          // Number() convert to the Number
          var price = Number($(this).attr("data-price"));

          console.log("Click add to cart:"+name+" "+price);

          shoppingCart.addItemToCart(name, price, 1);
          displayCart();
        });

       // 寫清除
        $("#clear-cart").click(function(event){
          shoppingCart.clearCart();
          displayCart();
        });



        //displayCart();
        function displayCart() {
          console.log("*** Display Cart ***");
          var cartArray = shoppingCart.listCart();
          console.log("*** Count Cart:" + cartArray.length);
          var output = "";
          for(var i in cartArray) {
            output += "<li>"+cartArray[i].name+" <input class='item-count' type='number' data-name='"+cartArray[i].name+"' value='"+cartArray[i].count+"'>"+" x " + cartArray[i].price + " = " +cartArray[i].total+ 
            "<button class='plus-item' data-name='"+cartArray[i].name+"'>+</button>"+
            "<button class='subtract-item' data-name='"+cartArray[i].name+"'>-</button>" + "<button class='delete-item' data-name='"+cartArray[i].name+"'>X</button>"
            +"</li>";
          }
          // html會渲染所有東西
          $("#show-cart").html(output);
          $("#count-cart").html(shoppingCart.countCart());
          $("#total-cart").html(shoppingCart.totalCart());
        }
        // 不太確定這邊的on是為什麼
        $("#show-cart").on("click", ".delete-item", function(event){
          // this X button我們按的 
          var name = $(this).attr("data-name");
          shoppingCart.removeItemFromCartAll(name);
          displayCart();
        });
        // 寫加法的
        $("#show-cart").on("click", ".plus-item", function(event){
          var name = $(this).attr("data-name");
          // 對應下面的addItemToCart function
          // 不用放任何事情在price，但如果刪掉可能會undefined
          shoppingCart.addItemToCart(name, 0, 1);
          displayCart();

        });
        // 寫減法的
        $("#show-cart").on("click", ".subtract-item", function(){
          var name = $(this).attr("data-name");
          shoppingCart.removeItemFromCart(name);
          displayCart();
        });
        // 寫輸入數字的，注意是change
        $("#show-cart").on("change", ".item-count", function(event){
          var name = $(this).attr("data-name");
          // 要取得數字，取得數值是val
          // 避免String + Number = String現象發生所以加Number
          var count = Number($(this).val());
          shoppingCart.setCountForItem(name, count);
          displayCart();
        });


       

        displayCart();   
    </script>
  </body>
</html>
