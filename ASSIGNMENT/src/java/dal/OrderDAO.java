/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Order;
import model.OrderDetail;

/**
 *
 * @author Admin
 */
public class OrderDAO extends DBContext {

    public List<Order> getAll() {
        String sql = "select * from [Order]";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("orderId"), new CustomerDAO().getUserById(rs.getInt("customerId")),
                        rs.getInt("totalAmount"), rs.getString("shippingAddress"), rs.getString("orderDescription"),
                        rs.getString("orderDate"), rs.getString("shippingDate"), rs.getBoolean("orderStatus")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Order getOrderById(int id) {
        String sql = "select * from [Order] where orderId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt("orderId"), new CustomerDAO().getUserById(rs.getInt("customerId")),
                        rs.getInt("totalAmount"), rs.getString("shippingAddress"), rs.getString("orderDescription"),
                        rs.getString("orderDate"), rs.getString("shippingDate"), rs.getBoolean("orderStatus"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Order> getOrderByCusId(int id) {
        String sql = "select * from [Order] where customerId=?";
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt("orderId"), new CustomerDAO().getUserById(rs.getInt("customerId")),
                        rs.getInt("totalAmount"), rs.getString("shippingAddress"), rs.getString("orderDescription"),
                        rs.getString("orderDate"), rs.getString("shippingDate"), rs.getBoolean("orderStatus")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllDetail() {
        String sql = "select * from OrderDetail";
        List<OrderDetail> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt("orderDetailId"), new ProductDAO().getProductById(rs.getInt("productId")),
                        getOrderById(rs.getInt("orderId")), rs.getInt("price"), rs.getInt("quantity")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllDetailByOId(int id) {
        String sql = "select * from OrderDetail where orderId=?";
        List<OrderDetail> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt("orderDetailId"), new ProductDAO().getProductById(rs.getInt("productId")),
                        getOrderById(rs.getInt("orderId")), rs.getInt("price"), rs.getInt("quantity")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addOrder(Order order, List<OrderDetail> cart) {
        try {
            String sql = "insert into [Order] values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, order.getId());
            st.setInt(2, order.getCustomer().getId());
            st.setInt(3, order.getTotal());
            st.setString(4, order.getAddress());
            st.setString(5, order.getDesc());
            st.setString(6, order.getOrderdate());
            st.setString(7, order.getShipdate());
            st.setBoolean(8, order.isStatus());
            st.executeUpdate();

            for (OrderDetail detail : cart) {
                String sql1 = "insert into OrderDetail values(?, ?, ?, ?, ?)";
                PreparedStatement st1 = connection.prepareStatement(sql1);
                st1.setInt(1, detail.getId());
                st1.setInt(2, detail.getProduct().getId());
                st1.setInt(3, detail.getOrder().getId());
                st1.setInt(4, detail.getPrice());
                st1.setInt(5, detail.getQuantity());
                st1.executeUpdate();
            }

        } catch (Exception e) {
        }

    }

    public List<Order> getListByPage(List<Order> list,
            int start, int end) {
        ArrayList<Order> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public void updateStatusOrder() {
        String sql = "update [Order] set orderStatus=1 where shippingDate-GETDATE()<=0";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    public void updateStatusOrderByCusID(int id) {
        String sql = "update [Order] set orderStatus=1 where shippingDate-GETDATE()<=0 and customerId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        OrderDAO od = new OrderDAO();
        System.out.println(od.getOrderByCusId(2).size());
    }
}
