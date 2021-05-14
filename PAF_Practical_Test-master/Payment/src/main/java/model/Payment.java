package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Payment {
	private Connection connect()
	 {
			Connection con = null;
		try
	 {
			Class.forName("com.mysql.jdbc.Driver");

//Provide the correct details: DBServer/DBName, username, password
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gadgetbadget", "root", "");
}
	 catch (Exception e)
		{e.printStackTrace();
}
	 return con;
}

	public String insertDetails(String name, String phone,String card,String cvv)
	 {
	 		String output = "";
	 try
	 {
		 	Connection con = connect();
	 if (con == null)
	 {
		 return "Error while connecting to the database for inserting.";
	 }
// create a prepared statement
	 String query = " insert into payment(`ID`,`cname`,`cphone`,`ccard`,`cvv`)" + " values (?,?,?,?,?,?,?)";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
 // binding values
		preparedStmt.setInt(1, 0);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, phone);
		preparedStmt.setString(4, card);
		preparedStmt.setString(5, cvv);
		
// execute the statement

		preparedStmt.execute();
		con.close();
	 
		public String readDetails()
		 {
			String output = "";
		 try
		 {
			 Connection con = connect();
		 if (con == null)
		 {
			 return "Error while connecting to the database for reading."; 
		 }
		 }
	//Prepare the html table to be displayed
		output = "<table border=\"1\"><tr><th>Name</th><th>Phone</th><th>Card</th><th>Cvv</th>";

			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
	// iterate through the rows in the result set
		while (rs.next())
		{
			
			String cname = rs.getString("cname");
			String cphone =rs.getString("cphone");
			String ccard= rs.getString("ccard");
			String CVV = rs.getString("Cvv");
			String ID= Integer.toString(rs.getInt("ID"));

	// Add into the html table
		output += "<tr><td>"+ cname + "</td>";
		output += "<td>" + cphone + "</td>";
		output += "<td>" + ccard+ "</td>";
		output += "<td>" + cvv + "</td>";
	// buttons
		output += "<td><input name='btnUpdate' type='button' value='Update' "
		+ "class='btnUpdate btn btn-secondary' data-paymentid='" + ID + "'></td>"
		+ "<td><input name='btnRemove' type='button' value='Remove' "
		+ "class='btnRemove btn btn-danger' data-paymentid='" + ID + "'></td></tr>";
		} 
		 con.close();
	 // Complete the html table
		 output += "</table>";
		 }
		 catch (Exception e)
		 {
			 output = "Error while reading the details.";
			 System.err.println(e.getMessage());
		 }
		 return output;
		 }
	public String updateDetails(String ID,String cname, String cphone,String ccard,String cvv)

	 {
		String output = "";
	 try
	 {
		 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for updating."; 
	 }
	 }
 // create a prepared statement
	 	String query = " update details set cname=?,cphone=?, ccard=?, cvv=? where ID=?";
	 	PreparedStatement preparedStmt = con.prepareStatement(query);
// binding values
	    preparedStmt.setString(1, cname);
		preparedStmt.setInt(3, Integer.parseInt(cphone));
		preparedStmt.setString(4, ccard);
		preparedStmt.setString(5, cvv);
		preparedStmt.setInt(7, Integer.parseInt(ID));
// execute the statement
		preparedStmt.execute();
		con.close();
	 String newItems =readDetails();
	 	output = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
	 }
	 catch (Exception e)
 {
	 output = "{\"status\":\"error\", \"data\": \"Error while updating the item.\"}";
	 System.err.println(e.getMessage());
 } 
	 return output;
	 }
	public String readDetails() {
// TODO Auto-generated method stub
		return null;
	}

	public String deleteDetails(String ID)
	 {
		String result = "";
		
		try {
			Connection con = connect();
			
			if(con == null) {
				return "Error while connecting to the Database";
			}
			
			String query = " delete from payment where ID=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setInt(1, Integer.parseInt(ID));
			preparedStmt.execute();
			
			con.close();
			String newItems = readDetails();
			result = "{\"status\":\"success\", \"data\": \"" +newItems + "\"}";
			 }
			 catch (Exception e)
			 {
				 result = "{\"status\":\"error\", \"data\":\"Error while deleting the Details.\"}";
			 System.err.println(e.getMessage());
			 } 
		
		return result;	
	 }
	} 