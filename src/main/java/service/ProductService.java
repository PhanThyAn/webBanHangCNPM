package service;

import dao.DBConnection;
import model.Product;
import model.Image;
import model.Product_type;
import model.Slider;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProductService {
    //lay ra tat ca san pham
    public static List<Product> getAllProduct()  throws Exception{
        List<Product> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from product";
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {

                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13), 0);
                list.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;


    }

    public static List<Slider> getAllSlider()  throws Exception{
        List<Slider> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from slideimg";
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
               Slider s= new Slider(rs.getInt(1),rs.getString(2),rs.getInt(3));
               list.add(s);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;


    }
    //lay ra hinh anh tuong ung
    public ArrayList<Image> getImage(int id)  throws Exception{
        ArrayList<Image> imgUrl = new ArrayList<>();
        Image img = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from image where product_id = " + id;
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                img = new Image(rs.getInt(1), rs.getInt(2), rs.getString(3));
                imgUrl.add(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;

    }

    //lay ra tat ca loai san pham
    public ArrayList<Product_type> getAllProduct_type()  throws Exception{
        ArrayList<Product_type> type_name = new ArrayList();
        String sql = "select type_id, type_name from product_type";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product_type t = new Product_type(rs.getInt(1), rs.getString(2));
                type_name.add(t);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return type_name;
    }

    //lay ra san pham theo id
    public static Product getProductById(int id)  throws Exception{
        Product pro = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from product where product_id =" + id;
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                 pro = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13), 0);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return pro;
    }

    //lay ra san pham theo loai
    public static List<Product> selectProductByType(int typeid)  throws Exception{
        List<Product> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "select * from product where product_type =" + typeid;
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13), 0);
                list.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //lay ra ten cua loai sp
    public Product_type getNameType(int id) throws Exception {
        Product_type type_name = null;
        String sql = "select type_id , type_name from product_type where type_id = " + id;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                type_name = new Product_type(rs.getInt(1), rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return type_name;
    }

    //lay ra san pham tuong tu
    public static List<Product> selectSameProduct(int typeid)  throws Exception{
        List<Product> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "( select * from product where product_type = " + typeid + " ORDER BY product_id DESC ) LIMIT 3";
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(12), rs.getString(13), 0);
                list.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    // lay ra san pham ban chay
    public List<Product> getBestSale() throws Exception{
        List<Product> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "SELECT product.*, SUM(order_detail.amount) AS soLgDaBan FROM product" +
                    " INNER JOIN order_detail ON order_detail.id_product = product.product_id GROUP BY order_detail.id_product ORDER BY soLgDaBan DESC";
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(11), rs.getString(12), 0);
                list.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    // lay ra san pham moi nhat
    public List<Product> getNewProduct(int n) throws Exception{
        List<Product> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql;
        try {
            sql = "SELECT * FROM product p ORDER BY p.product_id DESC LIMIT " + n;
            ps = DBConnection.getConnection().prepareStatement(sql);
            list = new ArrayList<>();
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(11), rs.getString(12), 0);
                list.add(p);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    //lay ra tong so san pham de phan trang
    public int getTotalProduct() {
        String sql = "Select  count(*) from product";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);

            rs = ps.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> pagingProduct(int index) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product\n" +
                "ORDER BY product_id LIMIT " + ((index - 1) * 5) + ",5";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);

            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(11), rs.getString(12), 0);
                list.add(p);
            }

        } catch (Exception e) {

        }
        return list;
    }

    //dem sl san pham theo loai sp
    public int getTotalProductType(int type) {
        String sql = "Select  count(*) from product where product_type = " + type;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);

            rs = ps.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Product> pagingProductBType(int index, int typeid) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM product\n" + " WHERE product_type = " + typeid +
                " ORDER BY product_id LIMIT " + ((index - 1) * 5) + ",5";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getInt(11), rs.getString(12), 0);
                list.add(p);
            }

        } catch (Exception e) {

        }
        return list;
    }

    public void addProduct(Product p) {

        String sql = "INSERT INTO product(name, price, price_sell, info, code, brand, color, size, attribute, status, product_type, product_insurance) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;

        int rs = 0;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getPrice());
            ps.setInt(3, p.getPrice_sell());
            ps.setString(4, p.getInfo());
            ps.setString(5, p.getCode());
            ps.setString(6, p.getBrand());
            ps.setString(7, p.getColor());
            ps.setString(8, p.getSize());
            ps.setString(9, p.getAttribute());
            ps.setInt(10, p.getStatus());
            ps.setInt(11, p.getProduct_type());
            ps.setString(12, p.getProduct_insurance());
            rs = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void edit(Product p, int id) {

        String sql = "UPDATE product SET name = ?, price = ?, price_sell = ?, info = ?, code= ?, brand = ?, color = ?, size = ?, attribute = ?, status = ?, product_type = ?, product_insurance = ? WHERE product_id = " + id;
        PreparedStatement ps = null;

        int rs = 0;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getPrice());
            ps.setInt(3, p.getPrice_sell());
            ps.setString(4, p.getInfo());
            ps.setString(5, p.getCode());
            ps.setString(6, p.getBrand());
            ps.setString(7, p.getColor());
            ps.setString(8, p.getSize());
            ps.setString(9, p.getAttribute());
            ps.setInt(10, p.getStatus());
            ps.setInt(11, p.getProduct_type());
            ps.setString(12, p.getProduct_insurance());
            rs = ps.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public static void main(String[] args)  throws Exception{

        System.out.println(getAllProduct());
    }

}
