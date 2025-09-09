//import com.sun.jdi.connect.spi.Connection;

import com.zzzj.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.sql.*;

public class JDBCTest {
    //修改数据
    @Test
    public void testUpdate() throws Exception {
        //注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");//告诉程序使用的是哪一套实现驱动
        //获取数据库连接
        String url="jdbc:mysql://localhost:3306/web01";
        String user="root";
        String password="123456";
        Connection connection = DriverManager.getConnection(url, user, password);
        //获取SQL语句的执行对象
        Statement  statement = connection.createStatement();
        //编写SQL语句
        int i= statement.executeUpdate("update user set age=25 where id=1");//返回受影响的行数
        System.out.println(i);
        //释放资源
        statement.close();
        connection.close();
    }


        /**
         * 编写JDBC程序, 查询数据
         */
        @Test
        public void testJdbc() throws Exception {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");//告诉程序使用的是哪一套实现驱动
            //获取数据库连接
            // 获取连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "123456");
            // 创建预编译的PreparedStatement对象
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?");//prepareStatement是Statement的子接口，也可以用于执行SQL语句，并且可以传递参数。
            // 设置参数
            pstmt.setString(1, "daqiao"); // 第一个问号对应的参数
            pstmt.setString(2, "123456"); // 第二个问号对应的参数
            // 执行查询
            ResultSet rs = pstmt.executeQuery();// ResultSet rs封装查询返回的结果
            // 处理结果集
            while (rs.next()) {
                int id = rs.getInt("id");
                String uName = rs.getString("username");
                String pwd = rs.getString("password");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                User user = new User(id, pwd, uName, name, age);
                System.out.println(user);

                System.out.println("ID: " + id + ", Username: " + uName + ", Password: " + pwd + ", Name: " + name + ", Age: " + age);
            }
            // 关闭资源
            rs.close();
            pstmt.close();
            conn.close();
        }

    @ParameterizedTest
    @CsvSource({"1,123456,25"})
    public void testUpdate(int userId, String newPassword, int newAge) throws Exception {
        // 建立数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/web01", "root", "123456");
        // SQL 更新语句
        String sql = "UPDATE user SET password = ?, age = ? WHERE id = ?";
        // 创建预编译的PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置参数
        pstmt.setString(1, newPassword); // 第一个问号对应的参数
        pstmt.setInt(2, newAge);      // 第二个问号对应的参数
        pstmt.setInt(3, userId);         // 第三个问号对应的参数

        // 执行更新
        int rowsUpdated = pstmt.executeUpdate();

        // 输出结果
        System.out.println(rowsUpdated + " row(s) updated.");

        // 关闭资源
        pstmt.close();
        conn.close();
    }

    }
