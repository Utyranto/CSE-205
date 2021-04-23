package DatabaseFunctions;

import java.sql.ResultSet;
import java.sql.*;

public class Database {
	
	// Create a table (list of values and attributes) of a customer.
	public void createUsersTable(Statement stmt, Connection c, String position) {
		try {
			stmt = c.createStatement();
			// AUTO_INCREMENT function will automatically assign a primary key (identifier) to each entry of the table, similar to an index of an array for lack of a better explanation.
			// AUTO_INCREMENT will increment the key automatically as well, handling this without the user doing it themselves.
			// This table (named users) will contain: a user name, password, first name, last name, email address, mailing address, and position.
			String sql = "CREATE TABLE USERS" + "(ID int NOT NULL AUTO_INCREMENT," + " USERNAME TEXT NOT NULL, " + "PASSWORD TEXT NOT NULL," + " FIRSTNAME TEXT NOT NULL, " + 
			"LASTNAME TEXT NOT NULL," + " EMAILADDRESS TEXT NOT NULL, " + "MAILINGADDRESS TEXT NOT NULL, " + position + "TEXT NOT NULL);";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("The table of Users has been created.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// Create a table (list of values and attributes) of a product.
	public void createShoppingCartTable(Statement stmt, Connection c) {
		try {
			stmt = c.createStatement();
			// AUTO_INCREMENT function will automatically assign a primary key (identifier) to each entry of the table, similar to an index of an array for lack of a better explanation.
			// AUTO_INCREMENT will increment the key automatically as well, handling this without the user doing it themselves.
			// Each item in this table (named shoppingcart) will contain: an item name, quantity, and a price. (Real is the format of a float).
			String sql = "CREATE TABLE SHOPPINGCART" + "(ID int NOT NULL AUTO_INCREMENT," + " ITEMNAME TEXT NOT NULL, " + "QUANTITY INT NOT NULL, " + "PRICE REAL NOT NULL);";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			System.out.println("The shopping cart has been created.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// Create a table (list of values and attributes) of a product.
	public void createPendingOrdersTable(Statement stmt, Connection c) {
		try {
			stmt = c.createStatement();
			// AUTO_INCREMENT function will automatically assign a primary key (identifier) to each entry of the table, similar to an index of an array for lack of a better explanation.
			// AUTO_INCREMENT will increment the key automatically as well, handling this without the user doing it themselves.
			// Each item in this table (named pendingorders) will contain: an item name and a price. (Real is the format of a float).
			String sql = "CREATE TABLE PENDINGORDERS" + "(ID int NOT NULL AUTO_INCREMENT," + " ITEMNAME TEXT NOT NULL, " + "QUANTITY INT NOT NULL, " + "PRICE REAL NOT NULL);";
			
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			
			// Define the behavior for this to be sent to the GUI. It is currently not completed (PLEASE FINISH).
			System.out.println("The shopping cart has been created.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// Public "wrapper" functionality that will accept strings to form credentials, to then combine together and pass that as an argument into its private method call.
	public void registerCustomer(String username, String password, String firstname, String lastname, String emailaddress, String mailingaddress, Connection c, Statement stmt) {
		// Appending the passing in argument parameters and concatenating them into a string format.
		String fullCredentials = username + "," + password + "," + firstname + "," + lastname + "," + emailaddress + "," + mailingaddress;
		// I decided to append position after the initial credentials string building, due to this being the sole factor that stucks out for differentiates the customers from employees.
		fullCredentials += ",CUSTOMER";
		
		// This public "wrapper" has concatenated the information into a string to be read in this private method (specifically the sql string in it).
		insertUser(stmt, c, fullCredentials);
	}
	
	// Public "wrapper" functionality that will accept strings to form credentials, to then combine together and pass that as an argument into its private method call.
	public void registerEmployee(String username, String password, String firstname, String lastname, String emailaddress, String mailingaddress, String position, Connection c, Statement stmt) {
		// Appending the passing in argument parameters and concatenating them into a string format.
		String fullCredentials = username + "," + password + "," + firstname + "," + lastname + "," + emailaddress + "," + mailingaddress;
		// I decided to append position after the initial credentials string building, due to this being the sole factor that stucks out for differentiates the customers from employees.
		fullCredentials += "," + position;
		
		// This public "wrapper" has concatenated the information into a string to be read in this private method (specifically the sql string in it).
		insertUser(stmt, c, fullCredentials);
	}
	
	// A method that handles inserting the created user's account into the database by passing in a statement, connection, and credentials as a string.
	private void insertUser(Statement stmt, Connection c, String credentials) {
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			// Each entry in the table (named users) will contain: username, password, first name, last name, email address, mailing address, position.
			String sql = "INSERT INTO USERS" + "(USERNAME,PASSWORD,FIRSTNAME,LASTNAME,EMAILADDRESS,MAILINGADDRESS,POSITION) " + "VALUES(" + credentials + ");";
			stmt.executeLargeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
			System.out.println("Created Account.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// A method that handles inserting the shopping cart item into the database by passing in a statement, connection, and item in a string format.
	public void insertItem(Statement stmt, Connection c, String itemName, float price) {
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			String sql = "INSERT INTO SHOPPINGCART" + "(ITEMNAME,PRICE) " + "VALUES(" + itemName + "," + price + ");";
			stmt.executeLargeUpdate(sql);
			
			stmt.close();
			c.commit();
			c.close();
			System.out.println("Inserted Item into Cart.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	public void shoppingCarttoPendingOrder() {
		
	}
	
	// Delete item function, not complete yet, but will take in the argument that is passed into it and delete the respective item.
	public void deleteItem(Statement stmt, Connection c, int ID) {
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			// Deletion sql injection clause.
			String sql = "DELETE from SHOPPINGCART where ID = " + ID + ";";
			stmt.executeUpdate(sql);
			c.commit();
			
			// Closing resources.
			stmt.close();
			c.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// [INCOMPLETE] This will allow the modification of the item's quantity, referenced with its ID.
	public void updateShoppingCart(Statement stmt, Connection c, String itemName, int quantity, int ID) {
		try {
			c.setAutoCommit(false);
			stmt = c.createStatement();
			// Sql injected command, where the table (shopping cart) is 'set' (indicated by QUANTITY) to a new value, which was passed in from the above argument.
			String sql = "UPDATE SHOPPINGCART set" + " QUANTITY = " + quantity + "where ID = " + ID + ";";
			stmt.executeUpdate(sql);
			c.commit();
			
			// Close resources.
			stmt.close();
			c.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
	
	// Login "check" method that will enable whether the credentials are correct from the user. Use this for when you want to check for log-in being properly done.
	public boolean loginVerification(Statement stmt, Connection c, String tableName, String user, String pass) {
		try {
			stmt = c.createStatement();
			// Grabs all of the information, brings it back to print it out.
			ResultSet rs = stmt.executeQuery("select USERNAME,PASSWORD from " + tableName + ";");
			
			// While loop that iterates over the result set, assigned the .get call to username and password for comparisons.
			while(rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				
				if (userName.equals(user)) {
					if (passWord.equals(pass)) {
						return true;
					}
				}
			}
			
			// Closing the various elements.
			rs.close();
			stmt.close();
			c.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		// Return the other case scenario of when the credentials don't match, otherwise it wouldn't properly finish.
		return false;
	}
	
	public void logOut() {
		
	}
}
