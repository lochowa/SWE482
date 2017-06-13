package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UC001Model{

    UC001Model() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Property()");

    }   // UC001Model()

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
    private String Meridian;
    private String description;
    private String PM;
    private String b_north;
    private String b_east;
    private String b_south;
    private String b_west;
    private final String[] bounders = new String[4];
    // TO DO: Create List<E> to hold RTI MInterest recods
    
    private Connection connect() {
        // SQLite connection string
        //Commit Section Added 6/7/2017 by Andrew Lochow
        String url = "jdbc:sqlite:./db/landman.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
        this.b_north = b_north;
        this.b_east = b_east;
        this.b_south = b_south;
        this.b_west = b_west;
        
        // TO DO: Create List<E> to hold RTI MInterest recods
        
         

    }
    // setValues()
    
    //Commit Section Added 6/7/2017 by Andrew Lochow
    
    public void committoDB() throws SQLException {
        Connection con = null;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO Property"
                + "(LandRecordID,ID_Parcel,ID_Tax, Description, Acres)"
                + "VALUES(?,?,?,?,?)";

        try{
            con = this.connect();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,this.dbRecordID);
            pstmt.setInt(2,this.parcelID);
            pstmt.setString(3, this.taxMapID);
            pstmt.setString(4,this.description);
            pstmt.setInt(5,this.acreage);        
            pstmt.executeUpdate();
            System.out.println("Record is inserted into Property table!");
           
        }

        catch(SQLException e){
            System.out.println(e.getMessage());
        }       
        
    }
    
}

   