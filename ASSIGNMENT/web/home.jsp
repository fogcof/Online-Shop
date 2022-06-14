<%-- 
    Document   : home.jsp
    Created on : Feb 19, 2022, 11:21:17 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Home</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

        <link rel="stylesheet" href="style.css">
        <style>
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
                            <a class="nav-link active" href="#">TRANG CHỦ</a>
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

        <section id="home">
            <div class="container">
                <h5>MỘT KHÔNG GIAN MỚI</h5>
                <h1><span>Giá tốt nhất</span> Thời điểm này</h1>
                <p>Kitn tạo ra sự thoải mái cho bạn<br>trong sắp xếp và tiện nghi</p>
                <button><a href="shop" style="color: aliceblue;text-decoration: none">Trải Nghiệm</a></button>
            </div>
        </section>

        <c:forEach items="${requestScope.listc}" var="listc">
            <section id="featured" class="my-5 pb-5">
                <div class="container text-center mt-5 py-5">
                    <h2>${listc.name}</h2>  <!-- fix -->
                    <hr class="mx-auto">
                    <p>${listc.desc}</p>
                </div>
                <div class="row mx-auto container-fluid">
                    <c:forEach items="${requestScope.listp}" var="listp">
                        <c:if test="${listc.id==listp.category.id}">
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
                        </c:if>
                    </c:forEach>
                </div>
            </section>
        </c:forEach>

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
                        <li><a href="#">TRANG CHỦ</a></li>
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