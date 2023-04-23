package service;

import dao.ProductSearchDAO;
import model.ProductSearchModel;

import java.util.List;

public class ProductSearchService {

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
