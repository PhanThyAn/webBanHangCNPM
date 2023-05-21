<%@ page import="model.Product" %>
<%@ page import="java.util.Collection" %>
<%@ page import="model.UserModel" %>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="cart" class="beans.Cart" scope="session"/>
<% UserModel user = (UserModel)session.getAttribute("user"); %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<html lang="en">


<!-- product-cart07:06-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Giỏ hàng</title>

    <meta name="keywords" content="Furniture, Decor, Interior">
    <meta name="description" content="Furnitica - Minimalist Furniture HTML Template">
    <meta name="author" content="tivatheme">

    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <jsp:include page="/common/web/css.jsp"></jsp:include>
</head>

<body class="product-cart checkout-cart blog">
    <jsp:include page="/common/web/header.jsp"></jsp:include>

    <!-- main content -->
    <div class="main-content" id="cart">
        <!-- main -->
        <div id="wrapper-site">
            <!-- breadcrumb -->
            <nav class="breadcrumb-bg">
                <div class="container no-index">
                    <div class="breadcrumb">
                        <ol>
                            <li>
                                <a href="/home">
                                    <span>Trang chủ</span>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span>Giỏ hàng</span>
                                </a>
                            </li>
                        </ol>
                    </div>
                </div>
            </nav>
            <div class="container">
                <div class="row">
                    <div id="content-wrapper" class="col-xs-12 col-sm-12 col-md-12 col-lg-12 onecol">
                        <section id="main">
                            <div class="cart-grid row">
                                <div class="col-md-9 col-xs-12 check-info">
                                    <h1 class="title-page">Giỏ hàng</h1>
                                    <div class="cart-container">
                                        <div class="cart-overview js-cart">
                                            <ul class="cart-items">
                                                <%  Collection<Product> list = cart.getListProduct();
                                                    for (Product p: list) {%> <!-- lay ds sp trong gio hang va hien thi giao dien-->
                                                <li class="cart-item">
                                                    <div class="product-line-grid row justify-content-between">
                                                        <div class="product-line-grid-left col-md-2">
                                                            <span class="product-image media-middle">
                                                                <a href="/product_detail?id=<%=p.getProduct_id()%>"><!--lay id-->
                                                                    <img class="img-fluid" src="<%=p.getImage(0)%>" alt=""><!--lay hinh-->
                                                                </a>
                                                            </span>
                                                        </div>
                                                        <div class="product-line-grid-body col-md-6">
                                                            <div class="product-line-info">
                                                                <a class="label" href="/product_detail?id=<%=p.getProduct_id()%>" data-id_customization="0"><%=p.getName()%> <!--lay ten--></a>
                                                            </div>
                                                            <div class="product-line-info product-price">
                                                                <span class="value"><%=p.getPrice_sell()%> vnđ <!--lay gia ban--></span>
                                                            </div>

                                                        </div>
                                                        <div class="product-line-grid-right text-center product-line-actions col-md-4">
                                                            <div class="row">
                                                                <div class="col-md-5 col qty">
                                                                    <div class="label">Qty:</div>
                                                                    <div class="quantity">
                                                                        <input type="text" name="qty" value="<%=p.getQuantity()%> " class="input-group form-control"><!--lay so luong-->

                                                                        <span class="input-group-btn-vertical">
                                                                            <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-up" type="button">
                                                                               <a class="add-cart" href="/WebCNPM/cart/add?id=<%=p.product_id%>">+</a>
                                                                            </button>
                                                                            <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-down" type="button">
                                                                                <a class="add-cart" href="/WebCNPM/cart/sub?id=<%=p.product_id%>">-</a>
                                                                            </button>
                                                                        </span>
                                                                    </div>
                                                                </div>
                                                                <% long priceI = (p.getPrice_sell())*(p.getQuantity()); %>
                                                                <div class="col-md-5 col price">
                                                                    <div class="label">Tổng:</div>
                                                                    <div class="product-price total">
                                                                        <%=priceI%> vnđ
                                                                    </div>
                                                                </div>
                                                                <div class="col-md-2 col text-xs-right align-self-end">
                                                                    <div class="cart-line-product-actions ">
                                                                        <a class="remove-from-cart" rel="nofollow" href="/WebCNPM/cart/del?id=<%=p.getProduct_id()%>" data-link-action="delete-from-cart" data-id-product="1">
                                                                            <i class="fa fa-trash-o" aria-hidden="true"></i>
                                                                        </a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </li>
                                                <%}%>
                                            </ul>
                                        </div>
                                    </div>
                                    <a href="/WebCNPM/checkout" class="continue btn btn-primary pull-xs-right">
                                        Tiếp tục
                                    </a>
                                </div>
                                <div class="cart-grid-right col-xs-12 col-lg-3">
                                    <div class="cart-summary">
                                        <div class="cart-detailed-totals">
                                            <div class="cart-summary-products">
                                                <div class="summary-label">Có ${cart.quantity} <!--lay sl-->sản phẩm trong giỏ hàng của bạn</div>
                                            </div>
                                            <div class="cart-summary-line" id="cart-subtotal-products">
                                                <span class="label js-subtotal">
                                                    Tổng Sản phẩm:
                                                </span>
                                                <span class="value">${cart.total} vnđ</span>
                                            </div>
                                            <div class="cart-summary-line" id="cart-subtotal-shipping">
                                                <span class="label">
                                                    Tổng phí chuyển hàng:
                                                </span>
                                                <span class="value">Miễn phí</span>
                                                <div>
                                                    <small class="value"></small>
                                                </div>
                                            </div>
                                            <div class="cart-summary-line cart-total">
                                                <span class="label">Tổng:</span>
                                                <span class="value">${cart.total} vnđ (bao gồm thuế.)</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- footer -->
    <jsp:include page="/common/web/css.jsp"></jsp:include>

    <!-- Vendor JS -->
    <jsp:include page="/common/web/js.jsp"></jsp:include>
</body>
</html>