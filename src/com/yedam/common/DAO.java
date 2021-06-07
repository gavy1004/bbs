package com.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String user = "bbs";
   private String passwd = "bbs";
   public Connection conn;
   
   public DAO() {
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url, user, passwd);
         System.out.println("연결성공");
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
   }
  
}