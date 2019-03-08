package test.spring.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add() {
        String sql = "insert into stu values(?,?,?)";
        Object[] values = {22, "kl", 45};
        jdbcTemplate.update(sql , values);
        System.out.println("add success...");
    }
}
