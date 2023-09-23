package com.example.library;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLconnect {
    static Connection getConnection() throws Exception {
        //JDBCドライバのロード
        Class.forName("org.mariadb.jdbc.Driver").newInstance();
        //各設定
        String url = "jdbc:mariadb://10.0.2.2:3306/lib_test?useUnicode = true&charaEncoding=utf8&useJDBCCompliantTimeZoneShift = true&useLegacyDatetimeCode = false&serverTimezone = UTC";
        String user = "root";
        String pass = null;
        //データベースに接続
        Connection con = DriverManager.getConnection(url,user,pass);
        return con;
    }
}
