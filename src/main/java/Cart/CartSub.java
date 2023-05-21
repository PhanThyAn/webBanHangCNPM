package Cart;

import beans.Cart;
import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CartSub", value = "/cart/sub")
// them sl sp
public class CartSub extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        int pid = Integer.parseInt(id);
        Product p = null;
        try {
            p = ProductService.getProductById(pid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Cart cart = (Cart) request.getSession().getAttribute("cart"); // lay thong tin gi hang
        cart.sub(p); // giam so luong san pham

        request.getSession().setAttribute("cart",cart); // luu thong tin gio hang
        response.sendRedirect("/cart_detail");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
