package com.djh.demo.JDBC;

import org.junit.Test;

import java.sql.*;

/**
 * DriverManager ：依据数据库的不同，管理JDBC驱动
 * Connection ：负责连接数据库并担任传送数据的任务
 * Statement ：由 Connection 产生、负责执行SQL语句
 * ResultSet ：负责保存Statement执行后所产生的查询结果
 */
public class JDBC {
    @Test
    public void JDBC() throws SQLException {
        Connection conn = null;
//        Statement st = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            //如果终端和mysql中显示的时间不一致，在连接数据库时会报异常，解决办法：加上?serverTimezone=UTC
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabases?serverTimezone=UTC", "root", "root");
            //st = conn.createStatement();
            //String sql = "select * from t_user";
            //rs = st.executeQuery(sql);       //executeQuery用于执行查询操作，增删改为executeUpdate,返回的是int类型，如果！=0则为添加、删除、修改成功

            //String sql = "insert into t_user values(?,?,?)"  //添加数据操作
            String sql = "select * from t_user where name=?";
            ps = conn.prepareStatement(sql);  //对sql语句做预编译处理，可以防止sql注入
            ps.setString(1,"xiaoming");  //设置参数setString中String是字段类型
            rs = ps.executeQuery();

            //处理结果集
            while (rs.next()){
                //获取每一列的值
                //这里的1,2,3对应的时sql要查询字段的顺序
                System.out.println(rs.getString(1)+"---"+rs.getInt(2)+"---"+rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (rs!=null){
                    rs.close();
                }
                if (ps!=null){
                    ps.close();
                }
/*                if (st!=null){
                    st.close();
                }*/
                if (conn!=null){
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("");
            }
        }
    }
}
