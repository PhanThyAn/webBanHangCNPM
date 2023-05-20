<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Product" %>
<%@ page import="model.Product_type" %>
<%@ page import="java.util.List" %>
<%@page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if IE 9 ]><html class="ie ie9" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<!--<![endif]-->
<% Product product = (Product) request.getAttribute("pro");

%>
<html lang="zxx">


<!-- product-detail06:46-->
<head>
    <!-- Basic Page Needs -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title><%=product.name%></title>
    <link rel="icon" type="image/x-icon" href="/Template/web/img/home/Logo-happyhome-removebg-preview.png">
    <meta name="keywords" content="Furniture, Decor, Interior">
    <meta name="description" content="Furnitica - Minimalist Furniture HTML Template">
    <meta name="author" content="tivatheme">

    <div id="fb-root"></div>
    <script async defer crossorigin="anonymous" src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v15.0&appId=1827192387637142&autoLogAppEvents=1" nonce="TPPeMGh0"></script>
    <meta property="fb:app_id" content="1827192387637142" />
    <!-- Mobile Meta -->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <jsp:include page="/common/web/css.jsp"></jsp:include>

    <style>

        .model-cart-add{
            display: none;
            width: 100%;
            height: 100%;
            background-color: rgb(0, 0, 0);
            background-color: rgba(0, 0, 0, 0.5);
            position: fixed;
            z-index: 2;
            padding-top: 100px;
            left: 0;
            top: 0;
        }


        .model-add-into-cart{
            position: fixed;
            box-shadow: 0px 0px 19px 3px rgba(0, 0, 0, 0.5);
            border: 2px #817e7e;
            width: 650px;
            height: 280px;
            top: 24%;
            left: 30%;
            border-radius: 5px;
            opacity: 1;
            overflow: auto;
            background-color: #fff;
            -webkit-animation-name: animatetop;
            -webkit-animation-duration: 0.4s;
            animation-name: animatetop;
            animation-duration: 0.4s;
        }

        @-webkit-keyframes animatetop {
            from {
                top: 100px;
                opacity: 0;
            }
            to {
                top: 24%;
                opacity: 1;
            }
        }

        @keyframes animatetop {
            from {
                top: 100px;
                opacity: 0;
            }
            to {
                top: 24%;
                opacity: 1;
            }
        }

    </style>
</head>


<body id="product-detail">
<jsp:include page="/common/web/header.jsp"></jsp:include>

<!-- main content -->
<div class="main-content">
    <div id="wrapper-site">
        <div id="content-wrapper">
            <div id="main">
                <div class="page-home">

                    <!-- breadcrumb -->
                    <nav class="breadcrumb-bg">
                        <div class="container no-index">
                            <div class="breadcrumb">
                                <ol>
                                    <li>
                                        <a href="#">
                                            <span>Trang chủ</span>
                                        </a>
                                    </li>
                                    <li>
                                        <a href="#">
                                            <span>Bàn</span>
                                        </a>
                                    </li>
                                </ol>
                            </div>
                        </div>
                    </nav>
                    <div class="container">
                        <div class="content">
                            <div class="row">
                                <div class="sidebar-3 sidebar-collection col-lg-3 col-md-3 col-sm-4">

                                    <!-- category -->
                                    <div class="sidebar-block">

                                        <div class="title-block">Thể loại</div>
                                        <% List<Product_type> list0 = (List<Product_type>) request.getAttribute("listType");
                                            for (Product_type pty: list0
                                            ) {%>
                                        <div class="block-content">

                                            <div class="cateTitle hasSubCategory open level1">
                                                <a class="cateItem" href="productCate?cid=<%=pty.getType_id()%>"><%=pty.getType_name()%></a>
                                            </div>


                                        </div>
                                        <%}%>
                                    </div>

                                </div>
                                <div class="col-sm-8 col-lg-9 col-md-9">
                                    <div class="main-product-detail">
                                        <h2><%=product.name%></h2>
                                        <div class="product-single row">
                                            <div class="product-detail col-xs-12 col-md-5 col-sm-5">
                                                <div class="page-content" id="content">
                                                    <div class="images-container">
                                                        <div class="js-qv-mask mask tab-content border">
                                                            <div id="item1" class="tab-pane fade active in show">
                                                                <img src="<%=product.getImage(0)%>" alt="img">
                                                            </div>
                                                            <div id="item2" class="tab-pane fade">
                                                                <img src="<%=product.getImage(1)%>" alt="img">
                                                            </div>
                                                            <div id="item3" class="tab-pane fade">
                                                                <img src="<%=product.getImage(2)%>" alt="img">
                                                            </div>
                                                            <div id="item4" class="tab-pane fade">
                                                                <img src="<%=product.getImage(3)%>" alt="img">
                                                            </div>
                                                            <div class="layer hidden-sm-down" data-toggle="modal" data-target="#product-modal">
                                                                <i class="fa fa-expand"></i>
                                                            </div>
                                                        </div>
                                                        <ul class="product-tab nav nav-tabs d-flex">
                                                            <li class="active col">
                                                                <a href="#item1" data-toggle="tab" aria-expanded="true" class="active show">
                                                                    <img src="<%=product.getImage(0)%>" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item2" data-toggle="tab">
                                                                    <img src="<%=product.getImage(1)%>" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item3" data-toggle="tab">
                                                                    <img src="<%=product.getImage(2)%>" alt="img">
                                                                </a>
                                                            </li>
                                                            <li class="col">
                                                                <a href="#item4" data-toggle="tab">
                                                                    <img src="<%=product.getImage(3)%>" alt="img">
                                                                </a>
                                                            </li>
                                                        </ul>
                                                        <div class="modal fade" id="product-modal" role="dialog">
                                                            <div class="modal-dialog">

                                                                <!-- Modal content-->
                                                                <div class="modal-content">
                                                                    <div class="modal-header">
                                                                        <div class="modal-body">
                                                                            <div class="product-detail">
                                                                                <div>
                                                                                    <div class="images-container">
                                                                                        <div class="js-qv-mask mask tab-content">
                                                                                            <div id="modal-item1" class="tab-pane fade active in show">
                                                                                                <img src="<%=product.getImage(0)%>" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item2" class="tab-pane fade">
                                                                                                <img src="<%=product.getImage(1)%>" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item3" class="tab-pane fade">
                                                                                                <img src="<%=product.getImage(2)%>" alt="img">
                                                                                            </div>
                                                                                            <div id="modal-item4" class="tab-pane fade">
                                                                                                <img src="<%=product.getImage(3)%>" alt="img">
                                                                                            </div>
                                                                                        </div>
                                                                                        <ul class="product-tab nav nav-tabs">
                                                                                            <li class="active">
                                                                                                <a href="#modal-item1" data-toggle="tab" class=" active show">
                                                                                                    <img src="<%=product.getImage(0)%>" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item2" data-toggle="tab">
                                                                                                    <img src="<%=product.getImage(1)%>" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item3" data-toggle="tab">
                                                                                                    <img src="<%=product.getImage(2)%>" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                            <li>
                                                                                                <a href="#modal-item4" data-toggle="tab">
                                                                                                    <img src="<%=product.getImage(3)%>" alt="img">
                                                                                                </a>
                                                                                            </li>
                                                                                        </ul>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="product-info col-xs-12 col-md-7 col-sm-7">
                                                <div class="detail-description">
                                                    <div class="price-del">
                                                        <span class="price"><%=product.price_sell%> VNĐ</span>
                                                        <span class="float-right">
                                                                <span class="availb">Khả dụng: </span>
                                                            <% String result = "Còn hàng";
                                                                if(product.status == 0){
                                                                    result = "Hết hàng";
                                                                }
                                                            %>
                                                                <span class="check">
                                                                    <i class="fa fa-check-square-o" aria-hidden="true"></i><%=result%></span>
                                                            </span>

                                                    </div>

                                                    <div class="option has-border d-lg-flex size-color">
                                                        <div class="size">
                                                            <span class="size">Kích cỡ : <%=product.size%></span>

                                                        </div>
                                                        <div class="colors">
                                                            <b class="title">Màu : <%=product.color%> </b>

                                                        </div>
                                                    </div>
                                                    <div class="has-border cart-area">
                                                        <div class="product-quantity">
                                                            <div class="qty">
                                                                <div class="input-group">
                                                                    <div class="quantity">
                                                                        <span class="control-label">QTY : </span>
                                                                        <input type="text" name="qty" id="quantity_wanted" value="1" class="input-group form-control">

                                                                        <span class="input-group-btn-vertical">
                                                                                <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-up" type="button">
                                                                                    +
                                                                                </button>
                                                                                <button class="btn btn-touchspin js-touchspin bootstrap-touchspin-down" type="button">
                                                                                    -
                                                                                </button>
                                                                            </span>
                                                                    </div>
                                                                    <span class="add">
                                                                           <a class="addToWishlist" href="<c:url value="/cart/add?id=${pro.product_id}"></c:url>">
                                                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                            </a>
                                                                            <a class="addToWishlist" href="#">
                                                                                <i class="fa fa-heart" aria-hidden="true"></i>
                                                                            </a>
                                                                        </span>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="clearfix"></div>
                                                        <p class="product-minimal-quantity">
                                                        </p>
                                                    </div>
                                                    <div class="d-flex2 has-border">
                                                        <div class="btn-group">
                                                            <a href="#">
                                                                <i class="zmdi zmdi-share"></i>
                                                                <span>Chia sẻ</span>
                                                            </a>
                                                            <a href="#" class="email">
                                                                <i class="fa fa-envelope" aria-hidden="true"></i>
                                                                <span>CHIA SẺ CHO BẠN BÈ</span>
                                                            </a>
                                                            <a href="#" class="print">
                                                                <i class="zmdi zmdi-print"></i>
                                                                <span>IN</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="rating-comment has-border d-flex">
                                                        <div class="review-description d-flex">
                                                            <span>ĐÁNH GIÁ :</span>
                                                            <div class="rating">
                                                                <div class="star-content">
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                    <div class="star"></div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="read after-has-border">
                                                            <a href="#review">
                                                                <i class="fa fa-commenting-o color" aria-hidden="true"></i>
                                                                <span>ĐỌC ĐÁNH GIÁ</span>
                                                            </a>
                                                        </div>
                                                        <div class="apen after-has-border">
                                                            <a href="#review">
                                                                <i class="fa fa-pencil color" aria-hidden="true"></i>
                                                                <span>VIẾT ĐÁNH GIÁ</span>
                                                            </a>
                                                        </div>
                                                    </div>
                                                    <div class="content">
                                                        <p>Mã hàng :
                                                            <span class="content2">
                                                                    <a href="#"><%=product.code%></a>
                                                                </span>
                                                        </p>
                                                        <p>Loại sản phẩm :
                                                            <span class="content2">
                                                                    <a href="#"><%=product.getNType()%></a>
                                                                </span>
                                                        </p>
                                                        <p>Thời gian bảo hành :
                                                            <span class="content2">
                                                                    <a href="#"><%=product.product_insurance%></a>
                                                                </span>
                                                        </p>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="review">
                                            <ul class="nav nav-tabs">
                                                <li class="active">
                                                    <a data-toggle="tab" href="#description" class="active show">Mô tả sản phẩm </a>
                                                </li>
                                                <li>
                                                    <a data-toggle="tab" href="#tag">Đặc điểm sản phẩm</a>
                                                </li>
                                                <li>
                                                    <a data-toggle="tab" href="#review">Nhận xét</a>
                                                </li>
                                            </ul>

                                            <div class="tab-content">
                                                <div id="description" class="tab-pane fade in active show">
                                                    <p> <%=product.info%>
                                                    </p>
                                                </div>

                                                <div id="review" class="tab-pane fade">
                                                    <div class="spr-form">
                                                        <div class="fb-comments" data-href="https://nguyenthanhdat20130013.github.io/HappyHomeMVC/p<%=product.product_id%>" data-width="100%" data-numposts="5"></div>
                                                    </div>

                                                </div>
                                                <div id="tag" class="tab-pane fade in">
                                                    <p><%=product.attribute%>
                                                    </p>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="related">
                                            <div class="title-tab-content  text-center">
                                                <div class="title-product justify-content-start">
                                                    <h2>Sản phẩm liên quan</h2>
                                                </div>
                                            </div>
                                            <div class="tab-content">
                                                <div class="row">
                                                    <% List<Product> same = (List<Product>) request.getAttribute("sameProduct");
                                                        for (Product psm: same
                                                        ) {%>
                                                    <div class="item text-center col-md-4">
                                                        <div class="product-miniature js-product-miniature item-one first-item">
                                                            <div class="thumbnail-container border border">
                                                                <a href="product_detail?pid=<%=psm.product_id%>">
                                                                    <img class="img-fluid image-cover" src="<%=psm.getImage(0)%>" alt="img">
                                                                    <img class="img-fluid image-secondary" src="<%=psm.getImage(1)%>" alt="img">
                                                                </a>
                                                                <div class="highlighted-informations">
                                                                    <div class="variant-links">
                                                                        <a href="#" class="color beige" title="Beige"></a>
                                                                        <a href="#" class="color orange" title="Orange"></a>
                                                                        <a href="#" class="color green" title="Green"></a>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="product-description">
                                                                <div class="product-groups">
                                                                    <div class="product-title">
                                                                        <a href="product_detail?pid=<%=psm.product_id%>"><%=psm.name%></a>
                                                                    </div>
                                                                    <div class="rating">
                                                                        <div class="star-content">
                                                                            <div class="star"></div>
                                                                            <div class="star"></div>
                                                                            <div class="star"></div>
                                                                            <div class="star"></div>
                                                                            <div class="star"></div>
                                                                        </div>
                                                                    </div>
                                                                    <div class="product-group-price">
                                                                        <div class="product-price-and-shipping">
                                                                            <span class="price"><%=psm.price_sell%> vnd</span>

                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="product-buttons d-flex justify-content-center">
                                                                    <form action="#" method="post" class="formAddToCart">

                                                                        <a class="add-to-cart" href="<c:url value="/cart/add?id=/cart/add?id=${pro.product_id}"></c:url>" data-button-action="add-to-cart">
                                                                            <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                                                                        </a>
                                                                    </form>
                                                                    <a class="addToWishlist" href="#" data-rel="1" onclick="">
                                                                        <i class="fa fa-heart" aria-hidden="true"></i>
                                                                    </a>
                                                                    <a href="product_detail?pid=<%=psm.product_id%>" class="quick-view hidden-sm-down" data-link-action="quickview">
                                                                        <i class="fa fa-eye" aria-hidden="true"></i>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <%}%>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- footer -->
<jsp:include page="/common/web/footer.jsp"></jsp:include>

<div class="model-cart-add" id="model-cart-add">
    <div class="model-add-into-cart">
        <div class="card-header" style="height: 50px">
            <p>Sản phẩm đã được thêm vào giỏ hàng của bạn.</p>
        </div>
        <div class="card-body">
            <div class="cart-product" style="display: flex;gap: 5px">
                <img src="img/product/ban-sofa-tron-st3015-001.jpg" alt="" style="height: 40px;width: 40px">
                <div style="width: 70%" ><a href="">Bàn sofa, bàn cafe nhựa cao cấp nhiều màu ST3015</a></div>
                <div style="float: right">
                    <span>1</span>&nbsp;x&nbsp<span>790.000 vnđ</span>
                </div>
            </div>
            <div style="margin-top: 10px">
                <label><Strong>Options:</Strong></label>
                <br>
                <span>Màu: Xanh</span>
                <br>
                <span>Size: M</span>
            </div>
            <div style="padding-top: 10px">
                <button class="btn btn-dark" id="continue-shopping">Tiếp tục mua sắm</button>
                <a class="btn btn-dark" href="product-cart.jsp" style="float: right">Xem giỏ hàng</a>
            </div>
        </div>
    </div>
</div>
<!-- Vendor JS -->
<jsp:include page="/common/web/js.jsp"></jsp:include>
<script>
    // var model = document.getElementById("model-cart-add");
    // var btnAddToCart = document.querySelectorAll(".add-item");
    // var btnContinue = document.getElementById('continue-shopping');
    //
    // btnContinue.onclick = function () {
    //     model.style.display = "none";
    // };
    //
    // for (let i = 0; i < btnAddToCart.length; i++) {
    //     btnAddToCart[i].addEventListener("click", function () {
    //         model.style.display = "block";
    //     });
    // }
    //
    // window.onclick = function (event) {
    //     if (event.target == model) {
    //         model.style.display = "none";
    //     }
    // };

</script>
</body>
</html>