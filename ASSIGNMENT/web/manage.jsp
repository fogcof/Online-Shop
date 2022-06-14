<%-- 
    Document   : manage
    Created on : Mar 2, 2022, 3:30:20 PM
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
            .account-page {
                padding: 100px 0;
                background: radial-gradient(#fff, #ffd6d6);
            }

            .list-group-item {
                font-weight: 550;
                opacity: 1;
                transition: 0.3s all;
                text-align: center;
                text-transform: uppercase;
            }

            .select {
                background-color: #fb774b;
                color: aliceblue;
            }

            .list-group-item:hover {
                color: aliceblue;
                background-color: #1d1d1d;
            }

            table{
                width: 100%;
                border-collapse: collapse;
                table-layout: fixed;
                white-space: nowrap;
                overflow-x: auto;
            }

            table img{
                width: 70px;
            }

            table td:nth-child(1){
                text-align: center;
            }

            table thead{
                border: 2px solid #acc2a9;
                border-left: none;
                border-right: none;
            }

            thead td{
                font-weight: 700;
                text-transform: uppercase;
                font-size: 13px;
                padding: 18px 0;
            }

            tr:not(:last-child){
                border: 1px solid #bbc9b9;
                border-left: none;
                border-right: none;
            }

            td{
                text-align: center;
            }

            tbody tr td{
                padding-top: 15px;
                padding-bottom: 15px;
            }

            tbody td{
                font-size: 15px;
            }

            body>div.mt-5.account-page>nav>ul>li.page-item.active>a {
                background-color: black;
            }

            body>div.mt-5.account-page>nav>ul>li:nth-child(n):hover>a {
                background-color: coral;
                color: #fff;
            }

            .pagination a {
                color: #000;
            }

            #add{
                background-color: black;
                opacity: 1;
                transition: 0.3s all;
                font-size: 13px;
                font-weight: 700;
            }

            #add:hover{
                background-color: coral;
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
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
        <script type="text/javascript">
            google.charts.load("current", {packages: ["corechart"]});
            google.charts.setOnLoadCallback(drawChart);
            function drawChart() {
                var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
            <c:set value="${requestScope.listnum}" var="listnum"/>
            <c:set value="0" var="x"  />
            <c:forEach items="${requestScope.listc}" var="listc">
                ['${listc.name}', ${listnum.get(x)}],
                <c:set value="${x+1}" var="x"  />
            </c:forEach>
                ]);

                var options = {
                    title: 'Mặt hàng bán chạy',
                    is3D: true,
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
                chart.draw(data, options);
            }
        </script>
        <script type="text/javascript">
            google.charts.load('current', {'packages': ['corechart']});
            google.charts.setOnLoadCallback(drawChart);

            function drawChart() {

                var data = google.visualization.arrayToDataTable([
                ['Task', 'Hours per Day'],
            <c:set value="${requestScope.listtotal}" var="listtotal"/>
            <c:set value="0" var="x"  />
            <c:set value="0" var="y"  />
            <c:forEach items="${requestScope.listc}" var="listc">
                ['${listc.name}', ${listtotal.get(x)}],
                <c:set value="${y+listtotal.get(x)}" var="y"/>
                <c:set value="${x+1}" var="x"  />
            </c:forEach>
                ]);

                var options = {
                    title: 'Tổng doanh thu ${y} ₫'
                };

                var chart = new google.visualization.PieChart(document.getElementById('piechart'));

                chart.draw(data, options);
            }
        </script>
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
                                <a class="nav-link dropdown-toggle active" id="navbarDropdown" role="button"
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
        <!-- Modal -->
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Thống kê mặt hàng</h5>
                        <!--<button type="button" style="color: white" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>-->
                    </div>
                    <div class="modal-body">
                        <div id="piechart_3d" style="width: 400px; height: 200px;"></div>
                        <div id="piechart" style="width: 400px; height: 200px;"></div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>

        <div class="mt-5 account-page">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-md-4 col-sm-12 mb-3">
                        <div class="list-group" id="list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action ${requestScope.type eq 'customer'?"select":""}" id="list-messages-list" data-toggle="list"
                               href="manage?type=customer" role="tab" aria-controls="messages">TÀI KHOẢN</a>
                            <a class="list-group-item list-group-item-action ${requestScope.type eq 'category'?"select":""}" id="list-profile-list" data-toggle="list"
                               href="manage?type=category" role="tab" aria-controls="profile">MẶT HÀNG</a>
                            <a class="list-group-item list-group-item-action ${requestScope.type eq 'product'?"select":""}" id="list-home-list" data-toggle="list"
                               href="manage?type=product" role="tab" aria-controls="home">SẢN PHẨM</a>
                            <a class="list-group-item list-group-item-action ${requestScope.type eq 'order'?"select":""}" id="list-home-list" data-toggle="list"
                               href="manage?type=order" role="tab" aria-controls="home">ĐƠN HÀNG</a>
                            <br>
                            <c:if test="${requestScope.type eq 'product'}">
                                <a id="add" style="width: 60%;margin:auto;" class="btn btn-primary" href="addpro" role="button">THÊM MỚI</a>
                            </c:if>
                            <c:if test="${requestScope.type eq 'customer'}">
                                <a id="add" style="width: 60%;margin:auto;" class="btn btn-primary" href="addcus" role="button">THÊM MỚI</a>
                            </c:if>
                            <c:if test="${requestScope.type eq 'category'}">
                                <a id="add" style="width: 60%;margin:auto;" class="btn btn-primary" href="addcate" role="button">THÊM MỚI</a>
                                <button type="button" style="width: 60%;margin:auto;margin-top: 10px" id="add" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
                                    thống kê
                                </button>
                            </c:if>
                            <c:if test="${requestScope.type eq 'order'}">
                                <a id="add" style="width: 60%;margin:auto;" class="btn btn-primary" href="updateStatus" role="button">CẬP NHẬT</a>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-lg-10 col-md-8 col-sm-12">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade ${requestScope.type eq 'product'?"show active":""}" id="list-home" role="tabpanel"
                                 aria-labelledby="list-home-list"> <!-- set active and show class to visible-->
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>ID</td>
                                            <td>Name</td>
                                            <td>Image</td>
                                            <td>Price</td>
                                            <td>Action</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listp}" var="listp">
                                            <tr>
                                                <td>${listp.id}</td>
                                                <td style="overflow: hidden;">${listp.name}</td>
                                                <td style="cursor: pointer" onclick="window.location = 'detail?id=${listp.id}'"><img src="${listp.image}"></td>
                                                <td>${listp.price} ₫</td>
                                                <td><a href="#" onclick="doDelete('${listp.id}')"><i
                                                            class="far fa-times-circle"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
                                                        href="updatepro?id=${listp.id}"> <i class="far fa-wrench"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade ${requestScope.type eq 'category'?"show active":""}" id="list-profile" role="tabpanel"
                                 aria-labelledby="list-profile-list">
                                <table width="100%">
                                    <thead>
                                        <tr>
                                            <td>ID</td>
                                            <td>Name</td>
                                            <td>Description</td>
                                            <td>Action</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listc}" var="listc">
                                            <tr>
                                                <td>${listc.id}</td>
                                                <td style="overflow: hidden;">${listc.name}</td>
                                                <td style="overflow: hidden;">${listc.desc}</td>
                                                <td><a href="editcate?id=${listc.id}"> <i class="far fa-wrench"></i></a></td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade ${requestScope.type eq 'customer'?"show active":""}" id="list-messages" role="tabpanel"
                                 aria-labelledby="list-messages-list"><table width="100%">
                                    <thead>
                                        <tr>
                                            <td>ID</td>
                                            <td>Email</td>
                                            <td>Username</td>
                                            <td>Password</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.lista}" var="lista">
                                            <tr>
                                                <td>${lista.id}</td>
                                                <td style="overflow: hidden;">${lista.email}</td>
                                                <td style="overflow: hidden;">${lista.username}</td>
                                                <td style="overflow: hidden;">${lista.password}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade ${requestScope.type eq 'order'?"show active":""}" id="list-messages" role="tabpanel"
                                 aria-labelledby="list-messages-list"><table width="100%">
                                    <thead>
                                        <tr>
                                            <td>ID</td>
                                            <td>Name</td>
                                            <td>Order Date</td>
                                            <td>Ship Date</td>
                                            <td>Address</td>
                                            <td>Status</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${requestScope.listo}" var="listo">
                                            <tr style="cursor: pointer" onclick="window.location = 'showdetail?id=${listo.id}&total=${listo.total}'">
                                                <td>${listo.id}</td>
                                                <td style="overflow: hidden;">${listo.customer.username}</td>
                                                <td style="overflow: hidden;">${fn:substring(listo.orderdate, 0, 10)}</td>
                                                <td style="overflow: hidden;">${fn:substring(listo.shipdate, 0, 10)}</td>
                                                <td style="overflow: hidden;">${listo.address}</td>
                                                <td style="overflow: hidden;">${listo.status==true?"Đã giao":"Đang vận chuyển"}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${requestScope.type eq 'product'}">
                <nav class="d-flex justify-content-center" aria-label="...">
                    <ul class="pagination mt-5">
                        <li class="page-item ${page==1?"disabled":""}">
                            <a class="page-link" href="manage?type=product&page=${page-1}">Trước</a>
                        </li>
                        <c:forEach begin="1" end="${requestScope.num}" var="num">
                            <li class="page-item <c:if test="${num==page}">active</c:if>">
                                <a class="page-link" href="manage?type=product&page=${num}">${num}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item ${page==num?"disabled":""}">
                            <a class="page-link" href="manage?type=product&page=${page+1}">Sau</a>
                        </li>    
                    </ul>
                </nav>
            </c:if>
            <c:if test="${requestScope.type eq 'order'}">
                <nav class="d-flex justify-content-center" aria-label="...">
                    <ul class="pagination mt-5">
                        <li class="page-item ${page==1?"disabled":""}">
                            <a class="page-link" href="manage?type=order&page=${page-1}">Trước</a>
                        </li>
                        <c:forEach begin="1" end="${requestScope.num}" var="num">
                            <li class="page-item <c:if test="${num==page}">active</c:if>">
                                <a class="page-link" href="manage?type=order&page=${num}">${num}</a>
                            </li>
                        </c:forEach>
                        <li class="page-item ${page==num?"disabled":""}">
                            <a class="page-link" href="manage?type=order&page=${page+1}">Sau</a>
                        </li>    
                    </ul>
                </nav>
            </c:if>
        </div>

        <footer class="mt-0 py-4"><!-- fix -->
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
                                                function doDelete(id) {
                                                    if (confirm("Bạn có chắc chắn muốn xóa sản phẩm id='" + id + "'?")) {
                                                        window.location = "deletepro?id=" + id;
                                                    }
                                                }
</script>