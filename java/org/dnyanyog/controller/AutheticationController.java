package org.dnyanyog.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutheticationController {
	@GetMapping
	public String data() throws SQLException  {
		
		String url = "jdbc:mysql://127.0.0.1:3306/ecommerce" ;
		String username = "root";
		String pass = "Pranav#17";
		
		Connection connection = DriverManager.getConnection(url,username,pass);
		
		Statement statement = connection.createStatement();
		
		String query = ("select * from ecommerce.user ");
		ResultSet result = statement.executeQuery(query);
		String name = "";
		while(result.next()) {
			System.out.println("User ID :" + result.getString(1));
			name = result.getString(2);
			System.out.println("password:" + result.getString(3));
			System.out.println("Gmail:"+ result.getString(4));
			
		}
		   return name ; 
		
	}

}
