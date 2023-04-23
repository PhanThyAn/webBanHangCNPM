package service;

import dao.CategoryProDAO;
import model.CategoryProModel;

import java.util.List;

public class CategoryProService {
    public static void addCate(String name) throws Exception{
        CategoryProDAO.addCate(name);
    }

    public static void deleteCate(int id) throws Exception{
        CategoryProDAO.deleteCate(id);
    }

    public static void updateCate(int id, String name) throws Exception{
        CategoryProDAO.updateCate(id,name);
    }

    public static List<CategoryProModel> findAll() throws Exception{
        return CategoryProDAO.findAll();
    }

    public static CategoryProModel findById(int id) throws Exception{
        return CategoryProDAO.findById(id);
    }
}
