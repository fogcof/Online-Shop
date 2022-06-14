<%-- 
    Document   : shop
    Created on : Feb 26, 2022, 3:20:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shop</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

        <link rel="stylesheet" href="style.css">
        <style>
            .product img {
                width: 100%;
                height: auto;
                box-sizing: border-box;
                object-fit: cover;
            }

            #featured > div.row.container.mx-auto > div.row.mx-auto.container.col-lg-9 > nav > ul > li.page-item.active > a{
                background-color: black;
            }
            #featured > div.row.container.mx-auto > div.row.mx-auto.container.col-lg-9 > nav > ul > li:nth-child(n):hover>a{
                background-color: coral;
            }

            .pagination a {
                color: #000;
            }

            select {
                border: 1px solid coral;
            }
            #lblCartCount {
                font-size: 12px;
                background: coral;
                color: #fff;
                padding: 0 5px;
                vertical-align: top;
                margin-left: -15px;
            }

            .badge {
                padding-left: 9px;
                padding-right: 9px;
                -webkit-border-radius: 9px;
                -moz-border-radius: 9px;
                border-radius: 9px;
            }

            .label-warning[href],
            .badge-warning[href] {
                background-color: #c67605;
            }

            /*filter----------------------------------*/
            .wrapper {
                width: 400px;
                height: 100%;
                background: #fff;
                border-radius: 10px;
                padding: 0px 25px 40px;
                box-shadow: 0 12px 35px rgba(0, 0, 0, 0.1);
            }

            .price-input {
                width: 100%;
                display: flex;
                margin: 30px 0 35px;
            }

            .price-input .field {
                display: flex;
                width: 100%;
                height: 45px;
                align-items: center;
            }

            .field input {
                width: 70px;
                height: 60%;
                outline: none;
                font-size: 12px;
                margin-left: 12px;
                border-radius: 5px;
                text-align: center;
                border: 1px solid #999;
                -moz-appearance: textfield;
            }

            input[type="number"]::-webkit-outer-spin-button,
            input[type="number"]::-webkit-inner-spin-button {
                -webkit-appearance: none;
            }

            .price-input .separator {
                width: 130px;
                display: flex;
                font-size: 19px;
                align-items: center;
                justify-content: center;
            }

            .slider {
                height: 5px;
                position: relative;
                background: #ddd;
                border-radius: 5px;
            }

            .slider .progress {
                height: 100%;
                left: 25%;
                right: 25%;
                position: absolute;
                border-radius: 5px;
                background: coral;
            }

            .range-input {
                position: relative;
            }

            .range-input input {
                position: absolute;
                width: 100%;
                height: 5px;
                top: -5px;
                background: none;
                pointer-events: none;
                -webkit-appearance: none;
                -moz-appearance: none;
            }

            input[type="range"]::-webkit-slider-thumb {
                height: 17px;
                width: 17px;
                border-radius: 50%;
                background: coral;
                pointer-events: auto;
                -webkit-appearance: none;
                box-shadow: 0 0 6px rgba(0, 0, 0, 0.05);
            }

            input[type="range"]::-moz-range-thumb {
                height: 17px;
                width: 17px;
                border: none;
                border-radius: 50%;
                background: coral;
                pointer-events: auto;
                -moz-appearance: none;
                box-shadow: 0 0 6px rgba(0, 0, 0, 0.05);
            }
        </style>
    </head>

    <body>

        <!-- NAVIGATION -->
        <nav class="navbar navbar-expand-lg navbar-light bg-light py-3 fixed-top">
            <div class="container">
                <a href="home"><img src="Image/KITN.png" alt="" width="50px"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span><i id="bar" class="fas fa-bars"></i></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="home">TRANG CHỦ</a>
                        </li>
                        <!-- <li class="nav-item">
                            <a class="nav-link" href="#">GIỚI THIỆU</a>
                        </li> -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="shop" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown-toggle" aria-expanded="false">
                                CỬA HÀNG
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:forEach items="${requestScope.listc}" var="listc">
                                    <li><a class="dropdown-item" href="shop?cid=${listc.id}">${listc.name}</a></li>
                                    </c:forEach>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">LIÊN HỆ</a>
                        </li>
                        <c:if test="${sessionScope.account!=null}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button"
                                   data-bs-toggle="dropdown-toggle" aria-expanded="false">
                                    TÀI KHOẢN
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="updatecus">CẬP NHẬT</a></li>
                                        <c:if test="${sessionScope.account.username eq 'chieu'}">
                                        <li><a class="dropdown-item" href="manage">QUẢN LÝ</a></li>
                                        </c:if>
                                    <li><a class="dropdown-item" href="logout">ĐĂNG XUẤT</a></li>
                                </ul>
                            </li>
                        </c:if>
                        <c:if test="${sessionScope.account==null}">
                            <li class="nav-item">
                                <a class="nav-link" href="login">ĐĂNG NHẬP</a>
                            </li>
                        </c:if>
                        <li class="nav-item">
                            <!-- <i class="fal fa-search"></i> -->
                            <a href="cart" style="color: black"><i class="fal fa-shopping-bag"></i></a>
                                <c:if test="${cookie.cart==null}">
                                <span class='badge badge-warning' id='lblCartCount'/>
                            </c:if>
                            <c:if test="${cookie.cart!=null}">
                                <c:set var="cart" value="${cookie.cart.value}"/>
                                <span class='badge badge-warning' id='lblCartCount'/> ${fn:length(fn:split(cart, ':'))}
                            </c:if>
                        </li>

                    </ul>
                    <form action="search" class="form-inline my-2 my-lg-0 ml-auto"> <!-- fix -->
                        <input class="form-control mr-sm-2" type="search" name="key" value="${requestScope.key}" placeholder="Tìm kiếm" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                    </form>

                </div>
            </div>
        </nav>

        <section id="featured" class="my-5 py-5">
            <div class="container mt-5 py-5 d-flex justify-content-between">
                <div>
                    <h2 class="font-weight-bold">Kết quả tìm kiếm cho "${requestScope.key}"</h2> <!-- fix -->
                    <hr>
                </div>
                <div class="d-flex justify-content-around">
                    <p class="mr-3" style="padding-top: 7px">Hiển thị ${requestScope.listp.size()} trong ${requestScope.size} sản phẩm</p>
                    <form action="select">
                        <input type="hidden" name="key" value="${requestScope.key}"/>
                        <select onchange="this.form.submit()" name="order" class="form-select p-2" aria-label="Default select example">
                            <option value="default">Thứ tự mặc định</option>
                            <option value="asc">Giá từ thấp đến cao</option>
                            <option value="desc">Giá từ cao đến thấp</option>
                        </select>
                    </form>
                </div>
            </div>
            <div class="row container mx-auto">
                <div class="wrapper mb-5 mx-auto col-lg-3">
                    <div class="price-input">
                        <div class="field">
                            <!--<span>Min</span>-->
                            <input id="from" type="number" class="input-min" name="from" value="0">&nbsp;₫
                        </div>
                        <div class="separator">-</div>
                        <div class="field">
                            <!--<span>Max</span>-->
                            <input id="to" type="number" class="input-max" name="to" value="20000000">&nbsp;₫
                        </div>
                    </div>
                    <div class="slider">
                        <div class="progress" style="left:0%;right: 0%"></div>
                    </div>
                    <div class="range-input d-flex justify-content-around">
                        <input type="range" class="range-min" min="0" max="20000000" value="0" step="10000">
                        <input type="range" class="range-max" min="0" max="20000000" value="20000000" step="10000">
                        <button class="mt-3 loc" style="border-radius: 20px;" 
                                onclick="window.location = 'filter?key=${requestScope.key}&order=${requestScope.order}&cid=${requestScope.cid}&from=' + document.getElementById('from').value + '&to=' + document.getElementById('to').value">
                            LỌC
                        </button>
                    </div>
                </div>
                <div class="row mx-auto container col-lg-9">

                    <c:forEach items="${requestScope.listp}" var="listp">
                        <div onclick="doDetail('${listp.id}')" class="product text-center col-lg-3 col-md-6 col-12">
                            <img class="img-fluid mb-3" src="${listp.image}" alt="">
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h5 class="p-name">${listp.name}</h5>
                            <c:set value="${listp.price} " var="price"/>
                            <c:set value="${(fn:length(price)-1)%3}" var="divide"/>
                            <c:set value="${fn:substring(price, 0, divide)}" var="newprice"/>
                            <c:forEach begin="0" end="${((fn:length(price)-1)/3)-1}" var="i">
                                <c:set value="${newprice},${fn:substring(price, divide+3*i, divide+3*i+3)}" var="newprice"/>
                            </c:forEach>
                            <h4 class="p-price">${newprice} ₫</h4>
                            <button class="buy-btn">MUA NGAY</button>
                        </div>
                    </c:forEach>
                    <c:set var="page" value="${requestScope.page}"/>
                    <c:set var="key" value="${requestScope.key}"/>
                    <nav class="col-12" aria-label="...">
                        <ul class="pagination mt-5">
                            <li class="page-item ${page==1?"disabled":""}">
                                <a class="page-link" href="search?page=${page-1}&key=${key}">Trước</a>
                            </li>
                            <c:forEach begin="1" end="${requestScope.num}" var="num">
                                <li class="page-item <c:if test="${num==page}">active</c:if>">
                                    <a class="page-link" href="search?page=${num}&key=${key}">${num}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item ${page==num?"disabled":""}">
                                <a class="page-link" href="search?page=${page+1}&key=${key}">Sau</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>

        </section>

        <footer class="mt-5 py-4"><!-- fix -->
            <div class="row container mx-auto pt-5">
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <img src="Image/KITN.png" alt="" style="width: 50px;">
                    <p class="pt-3">KITN sẽ mang lại cho bạn trải nghiệm những không gian với những
                        thiết kế tiện nghi, thoải mái và giá thành hợp lý nhất.
                    </p>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 class="pb-2">ĐIỀU HƯỚNG</h5>
                    <ul class="text-uppercase list-unstyled">
                        <li><a href="home">TRANG CHỦ</a></li>
                        <li><a href="shop">CỬA HÀNG</a></li>
                        <li><a href="#">LIÊN HỆ</a></li>
                        <li><a href="#">ĐĂNG NHẬP</a></li>
                    </ul>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 class="pb-2">LIÊN HỆ</h5>
                    <div>
                        <h6 class="text-uppercase">Địa chỉ</h6>
                        <p>Wherever you need us!</p>
                    </div>
                    <div>
                        <h6 class="text-uppercase">Số điện thoại</h6>
                        <p>0969180735</p>
                    </div>
                    <div>
                        <h6 class="text-uppercase">Email</h6>
                        <p>kitn0204@gmail.com</p>
                    </div>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12">
                    <h5 class="pb-2">SẢN PHẨM</h5>
                    <ul class="row">
                        <img class="img-fluid w-25 h-100 m-2" src="Image/8.jpg" alt="">
                        <img class="img-fluid w-25 h-100 m-2" src="Image/17.jpg" alt="">
                        <img class="img-fluid w-25 h-100 m-2" src="Image/4.jpg" alt="">
                        <img class="img-fluid w-25 h-100 m-2" src="Image/6-1.jpg" alt="">
                        <img class="img-fluid w-25 h-100 m-2" src="Image/5.jpg" alt="">
                    </ul>
                </div>
            </div>
        </footer>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
        crossorigin="anonymous"></script>
    </body>

</html>
<script type="text/javascript">
                            function doDetail(id) {
                                window.location = "detail?id=" + id;
                            }
</script>
<script>
    const rangeInput = document.querySelectorAll(".range-input input"),
            priceInput = document.querySelectorAll(".price-input input"),
            range = document.querySelector(".slider .progress");
    let priceGap = 1000;

    priceInput.forEach(input => {
        input.addEventListener("input", e => {
            let minPrice = parseInt(priceInput[0].value),
                    maxPrice = parseInt(priceInput[1].value);

            if ((maxPrice - minPrice >= priceGap) && maxPrice <= rangeInput[1].max) {
                if (e.target.className === "input-min") {
                    rangeInput[0].value = minPrice;
                    range.style.left = ((minPrice / rangeInput[0].max) * 100) + "%";
                } else {
                    rangeInput[1].value = maxPrice;
                    range.style.right = 100 - (maxPrice / rangeInput[1].max) * 100 + "%";
                }
            }
        });
    });

    rangeInput.forEach(input => {
        input.addEventListener("input", e => {
            let minVal = parseInt(rangeInput[0].value),
                    maxVal = parseInt(rangeInput[1].value);

            if ((maxVal - minVal) < priceGap) {
                if (e.target.className === "range-min") {
                    rangeInput[0].value = maxVal - priceGap
                } else {
                    rangeInput[1].value = minVal + priceGap;
                }
            } else {
                priceInput[0].value = minVal;
                priceInput[1].value = maxVal;
                range.style.left = ((minVal / rangeInput[0].max) * 100) + "%";
                range.style.right = 100 - (maxVal / rangeInput[1].max) * 100 + "%";
            }
        });
    });
</script>
