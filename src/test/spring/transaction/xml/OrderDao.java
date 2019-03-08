package test.spring.transaction.xml;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void lessMoney() {
        String sql = "update account set balance=balance-? where name=?";
        jdbcTemplate.update(sql, 100,"zhangsan");
    }
    public void addMoney() {
        String sql = "update account set balance=balance+? where name=?";
        jdbcTemplate.update(sql, 100,"lisi");
    }
}
