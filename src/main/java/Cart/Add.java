package Cart;

import beans.Cart;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Add", value = "/cart/add")
// them sp
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        // lay id dc truyen qua request
        String id = request.getParameter("id");
         // chuyen id thanh so nguyen
        int pid = Integer.parseInt(id);
        Product p = null;
        try {
            p = ProductService.getProductById(pid); //gan product co id la pid cho p
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        p.setQuantity(1);
        // lay thong tin gio hang request.getSession().getAttribute(“cart”).
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();

        }

        cart.put(p);// dua sp vao gio
        request.getSession().setAttribute("cart",cart); // luu thong tin gio hang
        response.sendRedirect("/cart_detail"); // chuyen huong trang
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
