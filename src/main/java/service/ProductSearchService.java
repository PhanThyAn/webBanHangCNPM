package service;

import dao.ProductSearchDAO;
import model.ProductSearchModel;

import java.util.List;

public class ProductSearchService {
    // Phan Thị An
    // 5. Hệ thống lấy ra dữ liệu trong cơ sở dữ liệu tương ứng với từ khóa tìm kiếm
    public static List<ProductSearchModel> searchByName(String txtSearch,int offset , int limit) throws Exception{
        return ProductSearchDAO.searchByName(txtSearch,offset,limit);
    }

    public static List<ProductSearchModel> searchByNameOderBy(String txtSearch,int offset , int limit, String column, String value) throws Exception{
        return ProductSearchDAO.searchByNameOderBy(txtSearch,offset,limit, column, value);
    }

    public static List<ProductSearchModel> searchByNameOnSale(String txtSearch,int offset , int limit)throws Exception{
        return ProductSearchDAO.searchByNameOnSale(txtSearch,offset,limit);
    }

}
