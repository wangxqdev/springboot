package com.tec.anji;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DataMainApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        log.info(dataSource.getClass().toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.getClass().toString());
        connection.close();
    }
}
