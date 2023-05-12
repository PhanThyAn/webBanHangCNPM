package controller.web;

import model.Article_Category;
import model.Introduce;
import model.ProductSearchModel;
import model.Product_type;
import service.ArticleService;
import service.IntroService;
import service.ProductService;
import service.ProductSearchService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchProductController", value = "/search")
public class SearchProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

        //Lay ra danh sach loai bai viet
        ArticleService service = new ArticleService();
        ProductService productService = new ProductService();
        List<Article_Category> listt = service.getListArCategory();
        request.setAttribute("listAr", listt);
        //Lay ra danh sach loai sp de chen vao header
        List<Product_type> listType = productService.getAllProduct_type();
        request.setAttribute("listType",listType);
        //Lay ra thong tin de chen vao footer
        IntroService intr = new IntroService();
        Introduce intro = intr.getIntro();
        request.setAttribute("info", intro);
        String textSearch = request.getParameter("search");

        int limit = 5;
        int page = 1;
        int totalItem = 0;
        int totalPage;
        String display = "grid";
        String orderBy = "";
        String sortBy = "";
        List<ProductSearchModel> list;

        if(request.getParameter("display") != null && request.getParameter("display") != ""){
            display = request.getParameter("display");
        }
        // nếu có số trang thì
        if(request.getParameter("page") != null && request.getParameter("page") != ""){
            // lấy ra số trang đang ở hiện tại
            page = Integer.parseInt(request.getParameter("page"));
        }
        // vị trí lấy từ offset
        int offset = (page-1) * limit;
            orderBy = request.getParameter("orderBy");
            sortBy =  request.getParameter("sortBy");
  //Phan Thị An_20130195 làm
  // Use case 3: Chức năng Tìm kiếm
    // 6. Hệ thống nhận về thông tin các sản phẩm khớp với trường đã nhập
            list = list(request,response,orderBy,sortBy,textSearch,offset,limit,totalItem);
            System.out.println("L" + list);
            request.setAttribute("listPro",list);


            if(list != null)totalItem = list.size();
            totalPage = (int)(Math.ceil((double) totalItem/limit));
        request.setAttribute("totalItem",totalItem);
        request.setAttribute("textSearch",textSearch);
        request.setAttribute("display",display);
        request.setAttribute("page",page);
        request.setAttribute("totalPage",totalPage);
        request.setAttribute("orderBy",orderBy);
        request.setAttribute("sortBy",sortBy);
        RequestDispatcher rd = request.getRequestDispatcher("views/web/search.jsp");
        rd.forward(request,response);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public List<ProductSearchModel> list(HttpServletRequest request, HttpServletResponse response,String orderBy,
                                         String sortBy,String textSearch,int offset,int limit,int totalItem){
        try {
            List<ProductSearchModel> list;
            if(request.getParameter("orderBy") != null && request.getParameter("orderBy") != ""){
                if(orderBy.equals("onsale")){

                        list = ProductSearchService.searchByNameOnSale(textSearch, offset, limit);

                    if(list != null)totalItem = list.size();
                } else{
                    list = ProductSearchService.searchByNameOderBy(textSearch, offset, limit,orderBy,sortBy);
                    if(list != null)totalItem = list.size();
                }
            } else {
                list = ProductSearchService.searchByName(textSearch, offset, limit);

            }
            return  list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
