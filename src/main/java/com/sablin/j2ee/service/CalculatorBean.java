package com.sablin.j2ee.service;

import com.sablin.j2ee.model.Operation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
@Stateless
public class CalculatorBean {

    @Resource(lookup="jdbc/MyResource")
    private DataSource ds;

    @PostConstruct
    public void postConstruct(){
        System.out.println("Call PostConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Call PreDestroy");
    }

    public double calculate(double v1,
                            double v2,
                            String operator){

        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);
        System.out.println("operator=" + operator);
        double result = 0;

        if ("+".equals(operator))
        {
            return v1 + v2;
        }

        if ("-".equals(operator))
        {
            return v1 - v2;
        }

        if ("/".equals(operator))
        {
            return v1 / v2;
        }

        if ("*".equals(operator))
        {
            return v1 * v2;
        }
        return -1;
    }

    public void saveToLog(String v1,
                          String v2,
                          String operation,
                          String result)
    {
        System.out.println("CalculatorBean.saveToLog");

        try (Connection c = ds.getConnection();
             Statement s = c.createStatement();)
        {
            s.executeUpdate("insert into calculation_log (v1, v2, operation, result) values('" + v1 + "','" + v2 + "','" + operation + "','" + result + "')");

        }catch(SQLException exc){
            exc.printStackTrace();
        }
    }

    public List<Operation> getListOperations(){
        List<Operation> AllOperations = new ArrayList<>();

        try (Connection c = ds.getConnection();
             Statement s = c.createStatement();
             ResultSet r = s.executeQuery("select v1, v2, operation, result from public.calculation_log order by creation_date desc limit 10");) {

            while (r.next())
            {
                AllOperations.add(new Operation(r.getString("v1"),
                                                r.getString("v2"),
                                                r.getString("operation"),
                                                r.getString("result")
                        )
                );
            }

            return AllOperations;

        }catch(SQLException exc){
            exc.printStackTrace();
        }

        return null;
    }
}
