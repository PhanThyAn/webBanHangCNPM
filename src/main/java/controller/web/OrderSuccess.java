package controller.web;

import beans.Cart;
import model.*;
import service.ArticleService;
import service.IntroService;
import service.OrderService;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "OrderSuccess", value = "/order_success")
public class OrderSuccess extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderService oderService = new OrderService();
        int orderid = oderService.getMaxMHD();
        try {

        ArticleService service = new ArticleService();
        ProductService productService = new ProductService();
        List<Article_Category> list = service.getListArCategory();
        request.setAttribute("listAr", list);
        //Lay ra danh sach loai sp de chen vao header
        List<Product_type> listType = productService.getAllProduct_type();
        request.setAttribute("listType", listType);
        //Lay ra thong tin de chen vao footer
        IntroService intr = new IntroService();
        Introduce intro = intr.getIntro();
        request.setAttribute("info", intro);

        Cart cart = (Cart) request.getSession().getAttribute("cart");
        Collection<Product> listp = cart.getListProduct();
//            Usecase 5 - Đặt hàng: 8. Tiến hành kiểm tra thông tin
//            Usecase 5 - Đặt hàng: 9. Kiểm tra đăng nhâp
        UserModel user = (UserModel) request.getSession().getAttribute("user");
//            Usecase 5 - Đặt hàng: 9.1 Yêu cầu  đăng nhập
        if (Objects.isNull(user)) {
            response.sendRedirect("/login");

        } else if (listp.size() == 0) {
            response.sendRedirect("/home");
        } else if (!(Objects.isNull(user)) && !(listp.size() == 0)) {
            //lay ra user
            try {
                response.setContentType("text/html;charset=UTF-8");
                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                String ptthanhtoan = request.getParameter("thanhtoan");
                UserModel u = user;
                long money = cart.getTotal();
                Date current = Date.valueOf(LocalDate.now());
//                Usecase 5 - Đặt hàng: 10. addOrder()
                Order od = new Order(orderid, u.getUserName(), "Tien mat", money, 0, current, " ", 0);
                oderService.addOder(od);
                od.setOder_id(orderid);
                Collection<Product> productList = cart.getListProduct();
//                Usecase 5 - Đặt hàng: 12. addOrderDetail()
                for (Product p : productList) {
                    Order_detail orderDetail = new Order_detail(13, od, p.getProduct_id(), p.getPrice_sell(), p.getQuantity(), 0, (p.getPrice_sell() * p.getQuantity()));
                    oderService.addOrderDetail(orderDetail);
                }
            } catch (Exception e) {
                response.sendRedirect("/home");
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/order-success.jsp");
        rd.forward(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
