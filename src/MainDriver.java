import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class MainDriver {
	public static void main(String[] args) {
		
		Connection c = null;
		Statement stmt = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/finalprojectdb", "postgres", "gF7wEuyVLXF4P9SC");
			System.out.println("Connected to the database.");
		} catch(Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
