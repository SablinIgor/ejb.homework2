/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sablin.j2ee.service;

import com.sablin.j2ee.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.sql.DataSource;

/**
 *
 * @author Igor
 */
@Singleton
public class ProductCatalogBean {
    
    @Resource(lookup="jdbc/MyResource")
    private DataSource ds;
    List<Category> AllCategories;
    
    @PostConstruct
    public void init(){
        System.out.println("ProductCatalogBean.init");
        AllCategories = new ArrayList();
             
        UpdateCategories();            
    }

    public Category getCategory(Long id){
        System.out.println("ProductCatalogBean.getCategory");
        
        Category result = new Category();
        final String q = "select id, code, name, creation_date from public.product_category where id=?";
                
        try (Connection c = ds.getConnection();
             PreparedStatement ps = createCategoryStatement(c, q, id);
             ResultSet r = ps.executeQuery()) {
       
            if (r.next())
            {
                System.out.println("id: " +r.getLong("id"));
                
                result.setId(r.getLong("id"));
                result.setName(r.getString("name"));
                result.setCode(r.getString("code"));
                result.setCreationDate(r.getDate("creation_date"));

                // return new Category(r.getLong("id"), r.getString("name"),r.getString("code"),r.getDate("creation_date"));
                // r.getTimestamp()
                //
            }
            
        }catch(SQLException exc){
            exc.printStackTrace();
        }
                
        return result;
    }

    private static PreparedStatement createCategoryStatement( final Connection c,
                                                              final String s,
                                                              final Long id) throws SQLException{
        PreparedStatement ps = c.prepareStatement(s);
        ps.setLong(1, id);

        return ps;
    }

    public List<Category> getCategories(){
        System.out.println("ProductCatalogBean.getCategories");
                        
        return AllCategories;
    }
    
    public void UpdateCategories(){
        System.out.println("ProductCatalogBean.UpdateCategories");

        AllCategories.clear();
        
        System.out.println("Лезем в базу " + new Date().toString() );
        try (Connection c = ds.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("select id, code, name, creation_date from public.product_category");) {         
       
            while (r.next()) 
            {
                AllCategories.add(new Category(r.getLong("id"),r.getString("name"),r.getString("code"),r.getDate("creation_date")));                
            }
        }catch(SQLException exc){
            exc.printStackTrace();
        }      
    }    
    
    // insert into product_category (code, name) values('xxx','YYY')
    public void createCategory(final String name, final String code){
        System.out.println("ProductCatalogBean.createCategory");

        try (Connection c = ds.getConnection();
             Statement s = c.createStatement();)
        {
             s.executeUpdate("insert into product_category (code, name) values('" + code + "','" + name +"')");         
             UpdateCategories();  
       
        }catch(SQLException exc){
            exc.printStackTrace();
        }             
    }    
    
    public void deleteCategory(final Long id){
        System.out.println("ProductCatalogBean.deleteCategory");

        try (Connection c = ds.getConnection();
             Statement s = c.createStatement();)
        {
             s.executeUpdate("delete from product_category where id = " + id);         
             UpdateCategories();  
       
        }catch(SQLException exc){
            exc.printStackTrace();
        }             
    }       
}
