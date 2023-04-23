package dao;

import model.ImgProductSearchModel;
import model.ProductSearchModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductSearchDAO {

    public static List<ProductSearchModel> searchByName(String txtSearch, int offset, int limit)  throws Exception{
        List<ProductSearchModel>  list;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            list = new ArrayList<>();
            sql = "select * from product where name like ? limit ?,?";
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, "%" + txtSearch + "%");
            pst.setInt(2, offset);
            pst.setInt(3, limit);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProductSearchModel(rs.getInt("product_id"),rs.getString("name"),rs.getInt("price"),
                        rs.getInt("price_sell"),rs.getString("info"),rs.getInt("status"),findImg(rs.getInt("product_id"))));

            }
            return list.isEmpty()?null:list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ProductSearchModel> searchByNameOderBy(String txtSearch, int offset, int limit, String col, String value) throws Exception {
        List<ProductSearchModel> list ;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            list = new ArrayList<>();
            sql = "select * from product where name like ? order by " + col + " " + value + " limit ?,?";
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, "%" + txtSearch + "%");
            pst.setInt(2, offset);
            pst.setInt(3, limit);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProductSearchModel(rs.getInt("product_id"),rs.getString("name"),rs.getInt("price"),
                        rs.getInt("price_sell"),rs.getString("info"),rs.getInt("status"),findImg(rs.getInt("product_id"))));

            }
            return list.isEmpty()?null:list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ImgProductSearchModel> findImg(int id)  throws Exception{
        List<ImgProductSearchModel>  list = null;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            list = new ArrayList<>();
            sql = "select * from image where product_id = ?";
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ImgProductSearchModel(rs.getString("img_url")));

            }
            return list.isEmpty()?null:list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<ProductSearchModel> searchByNameOnSale(String txtSearch, int offset, int limit)  throws Exception {
        List<ProductSearchModel> list = null;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            list = new ArrayList<>();
            sql = "select * from product  where name like ? and price_sell < price limit ?,?";
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, "%" + txtSearch + "%");
            pst.setInt(2, offset);
            pst.setInt(3, limit);
            rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new ProductSearchModel(rs.getInt("product_id"),rs.getString("name"),rs.getInt("price"),
                        rs.getInt("price_sell"),rs.getString("info"),rs.getInt("status"),findImg(rs.getInt("product_id"))));
            }
            return list.isEmpty()?null:list;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(searchByName("bàn",0,3));
    }
}
