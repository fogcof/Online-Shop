/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

/**
 *
 * @author Admin
 */
public class CustomerDAO extends DBContext {

    //    customerId int not null primary key,
//	email nvarchar(50),
//	username nvarchar(50),
//	password nvarchar(50),
//	phone nvarchar(50),
//	address nvarchar(50)
    public List<Customer> getAll() {
        String sql = "select * from Customer";
        List<Customer> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Customer a = new Customer(rs.getInt("customerId"), rs.getString("email"), rs.getString("username"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"));
                list.add(a);
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Customer check(String user, String pass) {
        String sql = "select * from Customer where username=? and password=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer a = new Customer(rs.getInt("customerId"), rs.getString("email"), rs.getString("username"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Customer checkUser(String user) {
        String sql = "select * from Customer where username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer a = new Customer(rs.getInt("customerId"), rs.getString("email"), rs.getString("username"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Customer getUserById(int id) {
        String sql = "select * from Customer where customerId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer a = new Customer(rs.getInt("customerId"), rs.getString("email"), rs.getString("username"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void insertCustomer(Customer a) {
        String sql = "insert into Customer(customerId, email, username, password) values(?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, a.getId());
            st.setString(2, a.getEmail());
            st.setString(3, a.getUsername());
            st.setString(4, a.getPassword());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCustomer(Customer a) {
        String sql = "update Customer set email=?, username=?, password=?, phone=?, address=? where customerId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, a.getEmail());
            st.setString(2, a.getUsername());
            st.setString(3, a.getPassword());
            st.setString(4, a.getPhone());
            st.setString(5, a.getAddress());
            st.setInt(6, a.getId());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Customer serchByEmailAndUser(String email, String user) {
        String sql = "select * from Customer where email=? and username=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, email);
            st.setString(2, user);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer a = new Customer(rs.getInt("customerId"), rs.getString("email"), rs.getString("username"), rs.getString("password"),
                        rs.getString("phone"), rs.getString("address"));
                return a;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Customer> getListByPage(List<Customer> list,
            int start, int end) {
        ArrayList<Customer> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
}
