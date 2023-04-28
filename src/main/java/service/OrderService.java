package service;

import dao.DBConnection;
import model.Order;
import model.Order_detail;
import model.Product;
import model.ProductSearchModel;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OrderService {
    public List<Order> getAllOder() {
        List<Order> od = new ArrayList<>();
        Order order = null;
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT order_id, user_name, payment, total_money, fee, date_order, transport, status FROM `order`";
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getInt(8));
                od.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return od;
    }

    public List<Order> getOderByUname(String uname)  throws Exception{
        List<Order> od = new ArrayList<>();
        Order order = null;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            sql = "SELECT order_id, user_name, payment, total_money, fee, date_order, transport, status FROM `order` WHERE user_name like ?";
            pst = DBConnection.getConnection().prepareStatement(sql);
            pst.setString(1, uname);
            rs = pst.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getInt(8));
                od.add(order);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return od;
    }

    public Order getOderById(int id)  throws Exception{

        Order order = null;
        ResultSet rs;
        PreparedStatement pst;
        String sql;
        try {
            sql = "SELECT order_id, user_name, payment, total_money, fee, date_order, transport, status FROM `order` WHERE order_id = " + id;
            pst = DBConnection.getConnection().prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getInt(5), rs.getDate(6), rs.getString(7), rs.getInt(8));

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
        return order;
    }

//    Usecase 5 - Đặt hàng: 11. createOrder()
    public void addOder(Order o) {
        String sql = "INSERT INTO `order` (order_id, user_name, payment, total_money, fee, date_order, transport, status) VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = null;
        int rs = 0;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, o.getOder_id());
            ps.setString(2, o.getUser_name());
            ps.setString(3, o.getPayment());
            ps.setLong(4, o.getTotal_money());
            ps.setInt(5, o.getFee());
            ps.setDate(6, o.getDateCurrent());
            ps.setString(7, o.getTransport());
            ps.setInt(8, o.getStatus());
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Usecase 5 - Đặt hàng: 13. createOrderDetail()
    public void addOrderDetail(Order_detail detail) {
        String sql = "INSERT INTO order_detail (id_oder, id_product, price, amount, fee, total) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        int rs = 0;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            ps.setInt(1, detail.getOrder().getOder_id());
            ps.setInt(2, detail.getId_product());
            ps.setLong(3, detail.getPrice());
            ps.setInt(4, detail.getAmount());
            ps.setInt(5, detail.getFee());
            ps.setLong(6, detail.getTotal());
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Order_detail> getOrderDById(int id) {
        List<Order_detail> od = new ArrayList<>();
        ResultSet rs;
        PreparedStatement ps;
        String sql = "SELECT id_product, price, amount, fee, total FROM order_detail WHERE id_oder = " + id;
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order_detail orderDetail = new Order_detail(0, new Order(1,"u","t",1,1, Date.valueOf(LocalDate.now()),"t",1), rs.getInt(1), rs.getLong(2), rs.getInt(3), rs.getInt(4), rs.getLong(5));
                od.add(orderDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return od;
    }

    public int getMaxMHD() {
        ResultSet rs;
        int result = 0;
        PreparedStatement ps;
        String sql = "SELECT MAX(order_id) FROM `order`";
        try {
            ps = DBConnection.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result + 1;
    }

    public static void main(String[] args)  throws Exception {
        OrderService os = new OrderService();

        System.out.println(os.getOderByUname("dung"));
    }
}
