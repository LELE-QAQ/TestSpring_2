import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import test.spring.aop.User;

import java.sql.*;
import java.util.List;


public class TestSql {

    /*使用jdbcTemplate实现增删改操作*/
    /*添加*/
    @Test
    public void fun1() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///test");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123");
        //System.out.println(driverManagerDataSource);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        String sql = "insert into stu values(?,?,?)";
        Object[] params = {22, "bob", 40};
        jdbcTemplate.update(sql, params);

    }

    /*删除*/
    @Test
    public void fun2() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql:///test");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        String sql = "delete from stu where id = ?";
        jdbcTemplate.update(sql, 20);

    }

    /*修改*/
    @Test
    public void fun3() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "update stu set name = ? where id = ?";
        jdbcTemplate.update(sql, "lele", 13);
    }


    /*查询返回值*/
    @Test
    public void fun5() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select count(*) from stu";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    /*使用JDBC实现查询*/
    @Test
    public void Jdbc() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///test", "root", "123");
            //String sql = "select * from stu where id = ?";
            String sql1 = "select * from stu";
            preparedStatement = connection.prepareStatement(sql1);
            //preparedStatement.setString(1, "13");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                User user = new User();
                user.setId(id);
                user.setName(name);
                user.setAge(age);
                System.out.println(user);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }


    /*使用JdbcTemplate实现查询操作*/
    /*查询某一对象*/
    @Test
    public void fun6() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from stu where id = ?";
        User user = jdbcTemplate.queryForObject(sql, new MyRowMapper(), 13);
        System.out.println(user);
    }

    /*查询list集合*/
    @Test
    public void fun7() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///test");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from stu";
        List<User> list = jdbcTemplate.query(sql, new MyRowMapper());
        System.out.println(list);

    }


}

class MyRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String id = resultSet.getString("id");
        String name = resultSet.getString("name");
        String age = resultSet.getString("age");
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
