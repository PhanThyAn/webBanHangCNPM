package Cart;

import beans.Cart;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "CartDel", value = "/cart/del")
// xoa sp
public class CartDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // lay id dc truyen qua request
        String id = request.getParameter("id");
        int pid = Integer.parseInt(id); // chuyen id thanh so nguyen
        Product p = null;
        try {
            p = ProductService.getProductById(pid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // lay thong tin gio hang request.getSession().getAttribute(“cart”)
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        cart.remove(p.getKey());//xoa sp voi khoa là key
    // luu thong tin gio hang
        request.getSession().setAttribute("cart",cart);
        response.sendRedirect("/WebCNPM/cart_detail");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
