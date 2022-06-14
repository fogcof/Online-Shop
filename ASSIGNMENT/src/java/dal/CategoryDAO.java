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
import model.Category;

/**
 *
 * @author Admin
 */
public class CategoryDAO extends DBContext {

    public List<Category> getAll() {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt("categoryId"), rs.getString("categoryName"), rs.getString("categoryDescription")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Category getCategoryById(int id) {
        String sql = "select * from Category where categoryId = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("categoryId"), rs.getString("categoryName"), rs.getString("categoryDescription"));
                return category;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Category> getListByPage(List<Category> list,
            int start, int end) {
        ArrayList<Category> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }
    
    public void insertCate(Category cate){
        String sql="insert into Category values(?, ?, ?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, cate.getId());
            st.setString(2, cate.getName());
            st.setString(3, cate.getDesc());
            st.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public void updateCate(Category cate){
        String sql="update Category set categoryName=?, categoryDescription=? where categoryId=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cate.getName());
            st.setString(2, cate.getDesc());
            st.setInt(3, cate.getId());
            st.executeUpdate();
        } catch (Exception e) {
        }
        
    }
}
