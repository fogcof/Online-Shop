<%-- 
    Document   : addCus
    Created on : Mar 10, 2022, 3:41:30 PM
    Author     : Admin
--%>

<%-- 
    Document   : update
    Created on : Feb 28, 2022, 5:08:50 PM
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
        <title>Account</title>

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
              integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
              integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />

        <link rel="stylesheet" href="style.css">
        <style>
            .account-page {
                padding: 100px 0;
                background: radial-gradient(#fff, #ffd6d6);
            }

            .form-container {
                background: #fff;
                width: 300px;
                height: 400px;
                text-align: center;
                padding: 20px 0;
                margin: auto;
                box-shadow: 0 0 20px 0px rgba(0, 0, 0, 0.1);
            }

            .form-container span {
                font-weight: bold;
                padding: 0 10px;
                color: #555;
                cursor: pointer;
                width: 100px;
                display: inline-block;
            }

            .form-bt {
                display: inline-block;
            }

            .form-container form {
                max-width: 300px;
                padding: 0 20px;
                top: 130px;
                transition: transform 1s;
                position: absolute;

            }

            form input {
                width: 105%;
                height: 30px;
                margin: 10px 0;
                padding: 0 10px;
                border: 1px solid #ccc;
            }

            form .bt {
                width: 100%;
                border: none;
                cursor: pointer;
                margin: 10px 0;
            }

            form .bt:focus {
                outline: none;
            }

            form a {
                font-size: 12px;
                color: black;
            }

            #Indicator {
                width: 100px;
                border: none;
                background: #ff523b;
                height: 3px;
                margin-top: 8px;
            }

            .but {
                margin-top: 10px;
                margin-bottom: 10px;
                border-radius: 100px;
                background-color: coral;
                color: aliceblue;
                padding: 10px 30px;
            }
            th{
                text-align: left;
                padding-right: 20px;
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
                            <a class="nav-link" href="home">TRANG CH???</a>
                        </li>
                        <!-- <li class="nav-item">
                            <a class="nav-link" href="#">GI???I THI???U</a>
                        </li> -->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="shop" id="navbarDropdown" role="button"
                               data-bs-toggle="dropdown-toggle" aria-expanded="false">
                                C???A H??NG
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <c:forEach items="${requestScope.listc}" var="listc">
                                    <li><a class="dropdown-item" href="shop?cid=${listc.id}">${listc.name}</a></li>
                                    </c:forEach>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">LI??N H???</a>
                        </li>
                        <c:if test="${sessionScope.account!=null}">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle active" id="navbarDropdown" role="button"
                                   data-bs-toggle="dropdown-toggle" aria-expanded="false">
                                    T??I KHO???N
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="updatecus">C???P NH???T</a></li>
                                        <c:if test="${sessionScope.account.username eq 'chieu'}">
                                        <li><a class="dropdown-item" href="manage">QU???N L??</a></li>
                                        </c:if>
                                    <li><a class="dropdown-item" href="logout">????NG XU???T</a></li>
                                </ul>
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
                        <input class="form-control mr-sm-2" type="search" name="key" placeholder="T??m ki???m" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">T??m ki???m</button>
                    </form>

                </div>
            </div>
        </nav>

        <div class="mt-5 account-page">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="form-container">
                            <div class="form-bt">
                                <span>Add</span>
                                <hr id="Indicator">
                            </div>
                            <h6 style="color: red">${requestScope.mess}</h6>
                            <c:set var="a" value="${requestScope.cate}"/>
                            <form id="RegForm" action="${requestScope.path eq '/editcate'?"editcate":"addcate"}" method="post">
                                <input type="hidden" name="id" value="${cate.id}"/>
                                <table>
                                    <tr>
                                        <th>Name</th>
                                        <td><input type="text" placeholder="Name" required name="name" value="${a.name}"></td>
                                    </tr>
                                    <tr>
                                        <th>Description</th>
                                        <td><input type="text" placeholder="Description" required name="desc" value="${a.desc}"></td>
                                    </tr>
                                </table>
                                <button class="but" type="submit">ADD</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <footer class="mt-0 py-4"><!-- fix -->
            <div class="row container mx-auto pt-5">
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <img src="Image/KITN.png" alt="" style="width: 50px;">
                    <p class="pt-3">KITN s??? mang l???i cho b???n tr???i nghi???m nh???ng kh??ng gian v???i nh???ng
                        thi???t k??? ti???n nghi, tho???i m??i v?? gi?? th??nh h???p l?? nh???t.
                    </p>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 class="pb-2">??I???U H?????NG</h5>
                    <ul class="text-uppercase list-unstyled">
                        <li><a href="home">TRANG CH???</a></li>
                        <li><a href="shop">C???A H??NG</a></li>
                        <li><a href="#">LI??N H???</a></li>
                        <li><a href="#">????NG NH???P</a></li>
                    </ul>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12 mb-3">
                    <h5 class="pb-2">LI??N H???</h5>
                    <div>
                        <h6 class="text-uppercase">?????a ch???</h6>
                        <p>Wherever you need us!</p>
                    </div>
                    <div>
                        <h6 class="text-uppercase">S??? ??i???n tho???i</h6>
                        <p>0969180735</p>
                    </div>
                    <div>
                        <h6 class="text-uppercase">Email</h6>
                        <p>kitn0204@gmail.com</p>
                    </div>
                </div>
                <div class="footer-one col-lg-3 col-md-6 col-12">
                    <h5 class="pb-2">S???N PH???M</h5>
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

