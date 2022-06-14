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
import model.Product;

/**
 *
 * @author Admin
 */
public class ProductDAO extends DBContext {

    public List<Product> getAll() {
        String sql = "select * from Product";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductById(int id) {
        String sql = "select * from Product where productId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId")));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> getTopByCid(int top, int cid) {
        String sql = "select top(?) * from Product where categoryId=?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, top);
            st.setInt(2, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByCid(int cid) {
        String sql = "select * from Product where categoryId=?";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getListByPage(List<Product> list,
            int start, int end) {
        ArrayList<Product> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<Product> searchProductByName(String name) {
        String sql = "select * from Product where productName like N'%" + name + "%'";
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByOrder(String order, int cid, String key) {
        String sql = "select * from Product where productName like N'%" + key + "%'";
        List<Product> list = new ArrayList<>();
        if (cid != 0) {
            sql += " and categoryId=" + cid;
        }
        if (!order.equals("default")) {
            sql += " order by price " + order;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> getProductByPrice(String order, int cid, String key, int from, int to) {
        String sql = "select * from Product where productName like N'%" + key + "%' and price between "+from+" and "+to;
        List<Product> list = new ArrayList<>();
        if (cid != 0) {
            sql += " and categoryId=" + cid;
        }
        if (!order.equals("default")) {
            sql += " order by price " + order;
        }
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt("productId"), rs.getString("productName"), rs.getString("productDescription"),
                        rs.getString("image"), rs.getInt("price"), rs.getInt("stock"), new CategoryDAO().getCategoryById(rs.getInt("categoryId"))));
            }
        } catch (Exception e) {
        }
        return list;
    }

//    CRUD------------------------
//    private int id;
//    private String name;
//    private String desc;
//    private String image;
//    private int price;
//    private int stock;
//    private Category category;
    public void insertProduct(Product p) {
        String sql = "insert into Product values(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, p.getId());
            st.setString(2, p.getName());
            st.setString(3, p.getDesc());
            st.setString(4, p.getImage());
            st.setInt(5, p.getPrice());
            st.setInt(6, p.getStock());
            st.setInt(7, p.getCategory().getId());
            st.executeUpdate();//1 or 0
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteProduct(int id) {
        String sql = "delete from Product where productId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateProduct(Product p) {
        String sql = "update Product set productName=?, productDescription=?, image=?, price=?, stock=?, categoryId=? where productId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, p.getName());
            st.setString(2, p.getDesc());
            st.setString(3, p.getImage());
            st.setInt(4, p.getPrice());
            st.setInt(5, p.getStock());
            st.setInt(6, p.getCategory().getId());
            st.setInt(7, p.getId());
            st.executeUpdate();//1 or 0
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        ProductDAO pd = new ProductDAO();
//        pd.insertProduct(new Product(50, "OKOK", "sd", "sd", 0, 0, new CategoryDAO().getCategoryById(1)));
//        pd.updateProduct(new Product(50, "OKOK324", "sddf", "sd1111", 60, 50, new CategoryDAO().getCategoryById(2)));
//    pd.deleteProduct(50);
        System.out.println(pd.getProductByPrice("asc", 1, "sồi", 0, 18000000).size());
    }

}
