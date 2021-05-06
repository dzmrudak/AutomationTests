package tests;

import org.testng.annotations.Test;
import sevices.JdbcService;

public class SqlTest {

    @Test
    public void connectionTest() {
        JdbcService jdbcService = new JdbcService();
        jdbcService.closeConnection();
    }
}
