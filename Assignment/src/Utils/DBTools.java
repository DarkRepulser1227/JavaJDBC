package Utils;

import Model.students;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DBTools {
    private static Connection con = null;
    private static Connection getCon() {
        /**
         *该方法是获取与数据库的连接,必须先建立连接再继续完成增删改查等操作.
         */
        try {
            Class.forName(PropertiesTools.getValue("driver"));
            con = DriverManager.getConnection(
                    PropertiesTools.getValue("url"),
                    PropertiesTools.getValue("username"),
                    PropertiesTools.getValue("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static int insert(students student) {
        /**
         * 数据库插入数据
         */
        Connection conn = getCon();
        int flag = 0;
        String sql = "insert into students (s_id,s_name,s_major,s_score) values(?,?,?,?)";
        //?=='balabala' 不需要再写''
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, String.valueOf(student.getS_id()));
            //获取ID并转换为字符型
            pstmt.setString(2, student.getS_name());
            pstmt.setString(3, student.getS_major());
            pstmt.setString(4, String.valueOf(student.getS_score()));
            //获取分数并转换为字符型
            flag = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static List<students> selectAll(){
        Connection con = getCon();
        int flag = 0;
        String sql = "select * from students";
        PreparedStatement pstmt;
        List<students> list = new ArrayList<students>();
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            students students = null;
            while (rs.next()){
                //获取rs中的数据并添加进集合类
                students = new students();
                students.setS_id(rs.getInt(1));
                students.setS_name(rs.getString(2));
                students.setS_major(rs.getString(3));
                students.setS_score(rs.getDouble(4));

                list.add(students);

            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<students> selectSomeoneByName(String name){
        Connection con = getCon();
        int flag = 0;
        String sql = "select * from students where s_name like concat('%',?,'%')";//实现按姓名的模糊查询
        PreparedStatement pstmt;
        List<students> list = new ArrayList<students>();
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1, name);
            ResultSet rs = pstmt.executeQuery();
            students students = null;
            while (rs.next()){
                students = new students();
                students.setS_id(rs.getInt(1));
                students.setS_name(rs.getString(2));
                students.setS_major(rs.getString(3));
                students.setS_score(rs.getDouble(4));

                list.add(students);

            }
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static int update(students student){
        Connection con = getCon();
        int flag = 0;
        String sql = "update students set s_major=?,s_score=? where s_name=? AND s_id=?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1,student.getS_major());
            pstmt.setString(2,String.valueOf(student.getS_score()));
            pstmt.setString(3,student.getS_name());
            pstmt.setString(4,String.valueOf(student.getS_id()));
            flag = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    public static int delete(String id,String name) {
        Connection con = getCon();
        int flag = 0;
        String sql = "delete from students where s_name=? AND s_id=?" ;
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) con.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,id);
            flag = pstmt.executeUpdate();
            pstmt.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
