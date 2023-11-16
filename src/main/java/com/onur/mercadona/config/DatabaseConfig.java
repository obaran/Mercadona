//package com.onur.mercadona.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import javax.sql.DataSource;
//import java.net.URI;
//import java.net.URISyntaxException;
//
//@Configuration
//public class DatabaseConfig {
//    @Value("${DATABASE_URL}")
//    private String databaseUrl;
//
//    @Bean
//    public DataSource dataSource() throws URISyntaxException {
//        URI dbUri = new URI(databaseUrl);
//
//        String username = dbUri.getUserInfo().split(":")[0];
//        String password = dbUri.getUserInfo().split(":")[1];
//        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
//
//        return DataSourceBuilder.create()
//                .url(dbUrl)
//                .username(username)
//                .password(password)
//                .build();
//    }
//}

