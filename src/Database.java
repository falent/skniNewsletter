
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
public class Database {
 
  private static Connection conn = null;
 

  private static String dbHost = "localhost";
 

  private static String dbPort = "3306";

  private static String database = "**";
 

  private static String dbUser = "root";

  private static String dbPassword = "**";
 
  private Database() {
    try {
 

      Class.forName("com.mysql.cj.jdbc.Driver");

      conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
          + dbPort + "/" + database + "?" + "user=" + dbUser + "&"
          + "password=" + dbPassword);
    } catch (ClassNotFoundException e) {
      System.out.println("Nie znalazlem sterownika");
    } catch (SQLException e) {
      System.out.println("polaczenie nie jest mozliwe");
    }
  }
 
  private static Connection getInstance()
  {
    if(conn == null)
      new Database();
    return conn;
  }
 
  /**
   * Schreibt die Namensliste in die Konsole
   */
  public static ArrayList<String> getNameMailList()
  {
    conn = getInstance();
    ArrayList<String> list = new ArrayList<String>();
    if(conn != null)
    {

      Statement query;
      try {
        query = conn.createStatement();
 

        String sql = "SELECT field_data_field_imie_uzyt.field_imie_uzyt_value, users.mail FROM field_data_field_imie_uzyt INNER JOIN users ON field_data_field_imie_uzyt.entity_id=users.uid ";
        ResultSet result = query.executeQuery(sql);
 

        while (result.next()) {
          String first_name = result.getString(1);
          String mail = result.getString(2);

 
          list.add(mail);
          list.add(first_name);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
	return list;
  }
 

}