import java.sql.*;
import java.util.ArrayList;
import oracle.jdbc.driver.OracleDriver; 
public class testJDBC {
  private static Connection connection = null;
  private static String URL = "jdbc:oracle:thin:@//msk-sap-ora001:1521/prd_gkdb_msk_sap_ora001";
  private static String USERNAME = "gkc1_gksm";
  private static String PASSWORD = "Qazwsx123"; 
  public ArrayList selectDB(String SQL, String columnLabel) {
    Statement sttmnt = null;
    ResultSet resSet = null;
    ArrayList<String> arrayList = new ArrayList<>();
    try {
      System.out.println("Connecting to DB"); 
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      sttmnt = connection.createStatement();
      resSet = sttmnt.executeQuery(SQL);
      while (resSet.next()) {
        try {
          arrayList.add(resSet.getString(columnLabel));
        } catch (SQLException throwables) {
          throwables.printStackTrace();
        }
      }
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      System.out.println("Connection to DB closed");
      try {
        connection.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace(); 
      }
    }
    return arrayList;
  }
  public void deleteFromDB(String SQL) {
    try {
      Statement sttmnt = null;
      System.out.println("Connecting to DB");
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
      sttmnt = connection.createStatement();
      sttmnt.executeQuery(SQL); 
    } catch (Exception e) {
      System.out.println(e);
    } finally { 
      System.out.println("Connection to DB closed");
      try {
        connection.close();
      } catch (SQLException throwables) {
        throwables.printStackTrace();
      }
    }
  }
}

