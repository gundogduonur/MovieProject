package importcsv;

import java.sql.*;
import java.util.*;

import com.onurgundogdu.database.DatabaseConnection;

public interface IClient<T> {

	public void insert(T t); 
	
	public void update(T t); 
	
	public void delete(T t); 
	
	public ArrayList<T> list(); 	
	default Connection getInterfaceConnection() {
		
		return DatabaseConnection.getInstance().getConnection();
		
	}
}
