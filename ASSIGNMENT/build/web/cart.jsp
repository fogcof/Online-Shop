<%-- 
    Document   : cart
    Created on : Mar 6, 2022, 9:34:22 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Details</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

        <link rel="stylesheet" href="style.css">
        <style>
            .sproduct input{
                width: 50px;
                height: 40px;
                padding-left: 10px;
                font-size: 16px;
                margin-right: 10px;
            }

            .sproduct input:focus{
                outline: none;
            }

            .buy-btn{
                background-color: #fb774b;
                opacity: 1;
                transition: 0.3s all;
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
            #cart-container{
                overflow-x: auto;
            }

            #cart-container table {
                border-collapse: collapse;
                width: 100%;
                table-layout: fixed;
                /* white-space: nowrap; */
            }

            #cart-container table thead {
                font-weight: 700;
            }

            #cart-container table thead td{
                background-color: #fd8c66;
                color: #fff;
                border: none;
                padding: 6px 0;

            }

            #cart-container table td{
                border: 1px solid #b6b3b3;
                text-align: center;
            }

            #cart-container table td:nth-child(1){
                width: 100px;
            }

            #cart-container table td:nth-child(2),
            #cart-container table td:nth-child(3){
                width: 200px;
            }

            #cart-container table td:nth-child(4),
            #cart-container table td:nth-child(5),
            #cart-container table td:nth-child(6){
                width: 170px;
            }

            #cart-container table tbody img{
                width: 80px;
                height: 80px;
                object-fit: cover;
            }

            #cart-container table tbody i{
                color: #8d8c89;
            }

            #cart-bottom .coupon>div,
            #cart-bottom .total>div{
                border: 1px solid #b6b3b3;
            }

            #cart-bottom .coupon h5,
            #cart-bottom .total h5{
                background-color: #fd8c66;
                color: #fff;
                border: none;
                padding: 6px 12px;
                font-weight: 700;
            }

            #cart-bottom .coupon p,
            #cart-bottom .coupon input{
                padding: 0 12px;
            }

            #cart-bottom .coupon input{
                height: 44px;
            }

            #cart-bottom .coupon input,
            #cart-bottom .coupon button{
                margin: 0 0 20px 12px;
            }

            #cart-bottom .total div>div{
                padding: 0 12px;
            }

            #cart-bottom .total h6{
                color: #2a2a2a;
            }

            .second-hr{
                background-color: #b8b7b3;
                width: 100%;
                height: 1px;
            }

            #cart-bottom .total div>button{
                margin: 0 12px 20px 0;
                display: flex;
                justify-content: flex-end;
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
                            <a class="nav-link dropdown-toggle" href="shop" id="navbarDropdown" role="button"
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
                        <input class="form-control mr-sm-2" type="search" name="key" placeholder="Tìm kiếm" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Tìm kiếm</button>
                    </form>

                </div>
            </div>
        </nav>

        <section id="blog-home" class="pt-5 mt-5 container">
            <h2 class="font-weight-bold pt-5">Giỏ Hàng</h2>
            <hr>
            <button ${sessionScope.account==null?"hidden":""} onclick="window.location='showorder'" style="border-radius: 5px">Đơn hàng</button>
            <c:if test="${cookie.cart==null}">
                <h2 class="font-weight-bold pt-5" style="text-align: center;color: red">Giỏ hàng của bạn còn trống</h2>
                <h3 style="margin-bottom:250px;text-align: center;"><a style="text-decoration: none;font-weight: 500;color: red" href="shop">Cửa Hàng</a></h3>
            </c:if>
        </section>
        <c:if test="${cookie.cart!=null}">
            <section id="cart-container" class="container mt-2 mb-5">
                <table width="100%">
                    <thead>
                        <tr>
                            <td>Xóa</td>
                            <td>Ảnh</td>
                            <td>Sản phẩm</td>
                            <td>Giá</td>
                            <td>Số lượng</td>
                            <td>Tổng</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:set value="${requestScope.listq}" var="quantity"/>
                        <c:set value="0" var="t"/>
                        <c:set value="0" var="total"/>
                        <c:forEach items="${requestScope.listp}" var="listp">    
                            <tr>
                                <td><a href="delitem?t=${t}"><i class="fas fa-trash-alt"></i></a></td>
                                <td><img src="${listp.image}" alt=""></td>
                                <td><h5>${listp.name}</h5></td>
                                <td><h5>${listp.price} ₫</h5></td>
                                <td><button style="padding: 2px 7px;background-color: #fd8c66"><a style="color: white; text-decoration: none" href="process?num=-1&id=${listp.id}">-</a></button>
                                    ${quantity[t]}
                                    <button style="padding: 2px 6px;background-color: #fd8c66"><a style="color: white; text-decoration: none" href="process?num=1&id=${listp.id}">+</a></button></td>
                                <td><h5>${quantity[t]*listp.price} ₫</h5></td>
                            </tr>
                        <p hidden>${total=total+quantity[t]*listp.price}</p>
                        <p hidden>${t=t+1}</p>
                    </c:forEach>
                    </tbody>
                </table>
            </section>

            <section id="cart-bottom" class="container">
                <div class="row">
                    <div class="coupon col-lg-6 col-md-6 col-12 mb-4">
                        <div>
                            <h5>MÃ GIẢM GIÁ</h5>
                            <p>Nhập kitnfreeship để được miễn phí vận chuyển.</p>
                            <input id="coupon" type="text" name="coupon" placeholder="Nhập mã giảm giá" value="${requestScope.coupon}">
                            <button onclick="window.location = 'cart?coupon=' + document.getElementById('coupon').value">Sử dụng</button>
                        </div>
                    </div>
                    <div class="total col-lg-6 col-md-6 col-12">
                        <div>
                            <h5>TỔNG GIỎ HÀNG</h5>
                            <div class="d-flex justify-content-between">
                                <h6>Tổng tiền</h6>
                                <p>${total} ₫</p>
                            </div>
                            <div class="d-flex justify-content-between">
                                <h6>Phí vận chuyển</h6>
                                <p>${requestScope.coupon eq 'kitnfreeship'?"Miễn phí":"100000 ₫"}</p>
                            </div>
                            <hr class="second-hr">
                            <div class="d-flex justify-content-between">
                                <h6>Tổng đơn hàng</h6>
                                <c:if test="${requestScope.coupon eq 'kitnfreeship'}">
                                    <p>${total} ₫</p>
                                </c:if>
                                <c:if test="${requestScope.coupon ne 'kitnfreeship'}">
                                    <p>${total+100000} ₫</p>
                                </c:if>
                            </div>
                            <c:if test="${requestScope.coupon eq 'kitnfreeship'}">
                                <button class="ml-auto" onclick="location.href = 'checkout?total=' +${total}">Đặt hàng</button>
                            </c:if>
                            <c:if test="${requestScope.coupon ne 'kitnfreeship'}">
                                <button class="ml-auto" onclick="location.href = 'checkout?total=' +${total+100000}">Đặt hàng</button>
                            </c:if>
                        </div>
                    </div>
                </div>
            </section>
        </c:if>
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
