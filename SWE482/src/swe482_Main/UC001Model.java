package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.sql.*;

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
    // Setters added by Andrew Lochow
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
    
    public void committoDB(){
        Connection con = null;
        PreparedStatement istmt = null;
        PreparedStatement sstmt = null;
        PreparedStatement ustmt = null;
        ResultSet rs = null;
        String select = "SELECT ID_Parcel from Property Where LandRecordID = ?";
        
        String update = "UPDATE PROPERTY SET ID_Tax =? ,"
                +"Description = ?"
                +"Acres = ?"
                +"WHERE LandRecordID = ?";
        
        String insert = "INSERT INTO Property"
                + "(LandRecordID,ID_Parcel,ID_Tax, Description, Acres)"
                + "VALUES(?,?,?,?,?)";
        

        try{
            con = this.connect();
            sstmt = con.prepareStatement(select);
            sstmt.setString(1,this.dbRecordID);
            rs = sstmt.executeQuery();
            int PID = 0;
            if(rs.next()){
                PID = rs.getInt(1);
                System.out.println("Record Exists under Parcel no.: " + PID + "Updating Record");
                ustmt = con.prepareStatement(update);
                ustmt.setString(1, this.taxMapID);
                ustmt.setString(2,this.description);
                ustmt.setInt(3,this.acreage);
                ustmt.setString(4,this.dbRecordID);
                ustmt.executeUpdate();
                System.out.println("Record Updated Successfully.");
                con.close();                
            }
            else{
            System.out.println("Record does not exist, creating new record");
            istmt = con.prepareStatement(insert);
            istmt.setString(1,this.dbRecordID);
            istmt.setInt(2,this.parcelID);
            istmt.setString(3, this.taxMapID);
            istmt.setString(4,this.description);
            istmt.setInt(5,this.acreage);        
            istmt.executeUpdate();
            System.out.println("Record is inserted into Property table!");
            con.close();
            }
        }

        catch(SQLException e){
            System.out.println(e.getMessage());
        }       
        
    }
    
}

   