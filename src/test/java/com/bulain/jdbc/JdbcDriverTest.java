package com.bulain.jdbc;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

@Slf4j
class JdbcDriverTest {

    @SneakyThrows
    @Test
    void testDameng() {

        Class.forName("dm.jdbc.driver.DmDriver");
        Connection conn = DriverManager.getConnection("jdbc:dm://localhost:5236", "demo", "******");
        DatabaseMetaData metaData = conn.getMetaData();
        String databaseProductName = metaData.getDatabaseProductName();
        log.info("{}", databaseProductName);

    }

    @SneakyThrows
    @Test
    void testKingbase() {

        Class.forName("com.kingbase8.Driver");
        Connection conn = DriverManager.getConnection("jdbc:kingbase8://localhost:54321/test", "kingbase", "******");
        DatabaseMetaData metaData = conn.getMetaData();
        String databaseProductName = metaData.getDatabaseProductName();
        log.info("{}", databaseProductName);

    }

}
