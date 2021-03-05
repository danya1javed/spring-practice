import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class DBClass {

  private void insertMember(Connection con, String first_name, String last_name) throws Exception {
    PreparedStatement pst = con.prepareStatement("INSERT INTO members (first_name, last_name) VALUES (?, ?)");
    pst.setString(1, first_name);
    pst.setString(2, last_name);
    int rows = pst.executeUpdate();
    if(rows > 0) System.out.println("Record Inserted");
  }

  private void retrieveAllMembers(Connection con) throws Exception {
    Statement st = con.createStatement();
    ResultSet rs = st.executeQuery("SELECT * FROM members;");

    while(rs.next()){
      System.out.println(
              "User " + rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3)
      );
    }
  }

  private void retrieveMemberById(Connection con, int id) throws Exception {
    PreparedStatement st = con.prepareStatement("SELECT id, first_name, last_name from members where id=" + id);
    ResultSet rs = st.executeQuery();
    if (!rs.next()) System.out.println("No record found.");
    System.out.println(
            "User " + rs.getInt(1) + ": " + rs.getString(2) + " " + rs.getString(3)
    );
  }

  private void updateMember(Connection con, int id, String first_name, String last_name) throws Exception {
    PreparedStatement pst = con.prepareStatement("UPDATE members SET first_name=?, last_name=? where id=?");
    pst.setString(1, first_name);
    pst.setString(2, last_name);
    pst.setInt(3, id);
    int rowAffected = pst.executeUpdate();
    if (rowAffected > 0) {
      System.out.println("A user with ID - " + id + " was updated successfully!");
    }
  }

  private void deleteMember(Connection con, int id) throws Exception {
    PreparedStatement pst = con.prepareStatement("DELETE FROM members where id=" + id);
//    pst.setInt(1, id);
    int rowsAffected = pst.executeUpdate();
    if(rowsAffected > 0) System.out.println("Record Deleted, ID - " + id);
  }

  public static void main(String[] args) {
    DBClass dbClass = new DBClass();
    String url = "jdbc:postgresql://localhost:5432/testDB";
    String user = "postuser";
    final String pass = "1234";
    try (
      Connection con = DriverManager.getConnection(url, user, pass)
    ) {
//    INSERT THREE RECORDS
      System.out.println("INSERT RECORDS");
      dbClass.insertMember(con, "Felix", "Kjelberg");
      dbClass.insertMember(con, "Mark", "Rober");
      dbClass.insertMember(con, "Cody", "Ko");

//    RETRIEVE BY ID
      System.out.println("RETRIEVE BY ID");
      dbClass.retrieveMemberById(con, 2);

//    UPDATE BY ID
      System.out.println("UPDATE BY ID");
      dbClass.updateMember(con, 1, "Pew", "diepie");

//    DELETE BY ID
      System.out.println("DELETE BY ID");
      dbClass.deleteMember(con,3);

//    RETRIEVE ALL
      System.out.println("RETRIEVE ALL");
      dbClass.retrieveAllMembers(con);

    } catch (Exception ex) {
      System.out.println(ex.toString());
    }
  }
}
