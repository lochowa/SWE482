package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MProperty{

    MProperty() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Property()");

    }   // MProperty()

    // Variable Declaration Area:  Do not change.

    private String dbRecordID;
    private int parcelID;
    private String taxMapID;
    private String county;
    private String state;
    private int acreage;
    private String township;
    private String range;
    private int section;
    private String PM;
    private String description;
    private final String[] bounders = new String[4];
    // TO DO: Create List<E> to hold RTI MInterest recods
    
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:./db/landman.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Database Connection Established");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            try {
                if (conn != null) {
                    System.out.println("Could not connect to Database");
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    // END Variable Declaration Area
 
    void setValues(
            String dbRecordID,
            int parcelID,
            String taxMapID,
            String county,
            String state,
            int acreage,
            String township,
            String range,
            int section,
            String PM,
            String description,
            String b_north,
            String b_east,
            String b_south,
            String b_west
    // TO DO: Integrate List<E>
    ) {

        this.dbRecordID = dbRecordID;
        this.parcelID = parcelID;
        this.taxMapID = taxMapID;
        this.county = county;
        this.state = state;
        this.acreage = acreage;
        this.township = township;
        this.range = range;
        this.section = section;
        this.PM = PM;
        this.description = description;
        this.bounders[0] = b_north;
        this.bounders[1] = b_east;
        this.bounders[2] = b_south;
        this.bounders[3] = b_west;
        
        
        // TO DO: Create List<E> to hold RTI MInterest recods
        
         

    }
    // setValues()
    
    //Commit Section Added 6/7/2017 by Andrew Lochow
    
    public void committoDB(){
        
        String sql = "INSERT INTO Property (LandRecordID,ID_Parcel,ID_Tax, Description, Acres) VALUES(?,?,?,?,?)";
        Connection con = this.connect();
        PreparedStatement pstmt = null;
        try{
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, this.dbRecordID);
            pstmt.setInt(2, this.parcelID);
            pstmt.setString(3, this.taxMapID);
            pstmt.setString(4, this.description);
            pstmt.setInt(5, this.acreage);
            con.commit();
            pstmt.close();
        }

        catch(SQLException e){
            System.out.println(e.getMessage());
        }       
        
    }
    
}

   