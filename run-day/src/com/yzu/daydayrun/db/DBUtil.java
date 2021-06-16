package com.yzu.daydayrun.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    private static String DriverClass;
    private static String url;
    private static String user;
    private static String password;

    static{
        DriverClass   ="com.mysql.jdbc.Driver";
        url  ="jdbc:mysql://localhost:3306/run_day?serverTimezone=UTC";
        user ="root";
        password = "root";
        try {
            Class.forName(DriverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws Exception{
        return  DriverManager.getConnection(url,user,password);
    }
    public static void closeAll(ResultSet rs, Statement stmt, Connection conn)
    {
        if(rs!=null)
        {
            try{
                rs.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        if(stmt!=null)
        {
            try{
                stmt.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

        if(conn!=null)
        {
            try{
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }

    }


}