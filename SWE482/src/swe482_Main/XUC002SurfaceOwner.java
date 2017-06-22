package swe482_Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * @author Michael Barth This class object inherits attributes and
 * @author Andrew Lochow wrote SQL Portions
 * mutators/accessors from UC001Owner
 */


public class XUC002SurfaceOwner extends UC001Owner {

    XUC002SurfaceOwner(
            int insertModCount,
            double xuc002_Interest,
            String uc001_Name1,
            String uc001_Name2,
            String uc001_Name3,
            String uc001_Name4,
            String uc001_Address,
            String uc001_City,
            String uc001_State,
            int uc001_ZipCode,
            String uc001_ContactNumber,
            String uc001_DocumentType,
            String uc001_EffectiveDate,
            String uc001_RecordingDate,
            int uc001_DocumentID,
            int uc001_Book,
            int uc001_Page,
            String dbRecord
    ) {
        this.setInsertModCount(insertModCount);
        this.setXuc002_Interest(xuc002_Interest);        
        this.setUc001_Name1(uc001_Name1);
        this.setUc001_Name2(uc001_Name2);
        this.setUc001_Name3(uc001_Name3);
        this.setUc001_Name4(uc001_Name4);
        this.setUc001_Address(uc001_Address);
        this.setUc001_City(uc001_City);
        this.setUc001_State(uc001_State);
        this.setUc001_ZipCode(uc001_ZipCode);
        this.setUc001_ContactNumber(uc001_ContactNumber);
        this.setUc001_DocumentType(uc001_DocumentType);
        this.setUc001_EffectiveDate(uc001_EffectiveDate);
        this.setUc001_RecordingDate(uc001_RecordingDate);
        this.setUc001_DocumentID(uc001_DocumentID);
        this.setUc001_Book(uc001_Book);
        this.setUc001_Page(uc001_Page);
        this.setUc001_dbRecord(dbRecord);
        System.out.println("START Create Surface Owner");
        System.out.println("Unique ID: " + this.getInsertModCount());
        System.out.println("Name 1: " + this.getUc001_Name1());
        System.out.println("Name 2: " + this.getUc001_Name2());
        System.out.println("Name 3: " + this.getUc001_Name3());
        System.out.println("Name 4: " + this.getUc001_Name4());
        System.out.println("Address : " + this.getUc001_Address());
        System.out.println("City: " + this.getUc001_City());
        System.out.println("State: " + this.getUc001_State());
        System.out.println("ZipCode: " + this.getUc001_ZipCode());
        System.out.println("Contact Number: " + this.getUc001_ContactNumber());
        System.out.println("Interest: " + this.getXuc002_Interest());
        System.out.println("Document Type: " + this.getUc001_DocumentType());
        System.out.println("Effective Date: " + this.getUc001_EffectiveDate());
        System.out.println("Recording Date: " + this.getUc001_RecordingDate());
        System.out.println("Document Number: " + this.getUc001_DocumentID());
        System.out.println("Book: " + this.getUc001_Book());
        System.out.println("Page: " + this.getUc001_Page());
        System.out.println("END Creat Surface Owner");
    }
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
    
    public String getRandomUUID() {
        UUID UrecID = UUID.randomUUID();
        String recID = UrecID.toString();
        return recID;
    }
    
    public String getOwnerDBRecord(){
        return this.OwnerDbRecord;
    }
    
    public String getOwnershipDbRecord(){
        return this.OwnershipDbRecord;
    }
    
    //committoDB Method Written by Andrew Lochow
    public void committoDB() {
        Connection con;
        PreparedStatement sostmt;
        PreparedStatement sosstmt;
        PreparedStatement uostmt;
        PreparedStatement uosstmt;
        PreparedStatement iostmt;
        PreparedStatement iosstmt;
        ResultSet rs;
        ResultSet rsos;
        ResultSet rso;

        // String select = "SELECT OwnerRecordID from Ownership Where REF_LandRecordID = ?";
        String selectowner = "SELECT OwnerRecordID from Owner Where NameLn1 = ? AND City = ? AND Phone = ?";
        String selectownership = "Select OwnershipRecordID from Ownership Where REF_OwnerRecordID = ? AND Int_Surface =1 AND Int_Mineral = 0"
                +" AND DocumentType = ? AND Book = ? AND Page = ? And DocumentID = ? AND REF_LandRecordID = ?";
                

        String updateowner = "UPDATE Owner "
                +" SET NameLn1 = ?, NameLn2 = ?, NameLn3 = ?, NameLn4 = ?,"
                +" AddressLn1 = ?, City = ?, State = ?, ZipCode = ?, Phone = ?"
                +" WHERE OwnerRecordID = ?";
        String updateownership = " UPDATE Ownership"
                +" SET RecordingDate = ?, EffectiveDate = ? , DocumentID = ?, Book =?, Page = ?"
                +" WHERE OwnershipRecordID = ?";
        String insertownership = " INSERT INTO Ownership"
                +"(OwnershipRecordID, REF_OwnerRecordID, DocumentType, RecordingDate, EffectiveDate, DocumentID, Book, Page, Int_Surface, Int_Mineral, REF_LandRecordID)"
                +" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String insertowner = "INSERT INTO Owner"
                +"(OwnerRecordID, NameLn1, NameLn2, NameLn3, NameLn4, AddressLn1, City, State, ZipCode, Phone)"
                +"VALUES (?,?,?,?,?,?,?,?,?,?)";

        try {
            con = this.connect();
            //sstmt = con.prepareStatement(select);
            sostmt= con.prepareStatement(selectowner);
            sosstmt = con.prepareStatement(selectownership);
            
            //sstmt.setString(1, this.dbRecord);
            // query Owner table for matching records.
            rso = sostmt.executeQuery();
            String ORID;
            ORID = rso.getString(1);
            sostmt.setString(1, ORID);
            sostmt.setString(2, this.getUc001_Name1());
            sostmt.setString(3, this.getUc001_City());
            sostmt.setString(4, this.getUc001_ContactNumber());
            rso = sostmt.executeQuery();
            // If records match, then update
            if (rso.next()) {
                ORID = rso.getString(1);
                System.out.println("Record Exists under Owner Record ID: " + ORID + ". Updating Record instead.");
                uostmt = con.prepareStatement(updateowner);
                uostmt.setString(1, this.getUc001_Name1());
                uostmt.setString(2, this.getUc001_Name2());
                uostmt.setString(3, this.getUc001_Name3());
                uostmt.setString(4, this.getUc001_Name4());
                uostmt.setString(5, this.getUc001_Address());
                uostmt.setString(6, this.getUc001_City());
                uostmt.setString(7, this.getUc001_State());
                uostmt.setInt(8, this.getUc001_ZipCode());
                uostmt.setString(9, this.getUc001_ContactNumber());
                uostmt.setString(10, ORID);
                uostmt.addBatch();

                con.setAutoCommit(false);
                uostmt.executeBatch();
                con.setAutoCommit(true);
                System.out.println("Owner Record Updated Successfully.");
                System.out.println("Checking if Ownership record exists.");
                
                // checking if Ownership record exists since it is known that the Owner exists.
                rsos = sosstmt.executeQuery();
                sosstmt.setString(1, ORID);
                sosstmt.setString(2, this.getUc001_DocumentType());
                sosstmt.setInt(3, this.getUc001_Book());
                sosstmt.setInt(4, this.getUc001_Page());
                sosstmt.setInt(5, this.getUc001_DocumentID());
                sosstmt.setString(6, this.getUc001_dbRecord());
                
                // If it does exist perform update.
                if (rsos.next()){
                    String OSRID = rsos.getString(1);
                    System.out.println("Record Exists under Ownership Record ID: " + OSRID + ". Updating Record instead.");
                    uosstmt = con.prepareStatement(updateownership);
                    uosstmt.setString(1, this.getUc001_RecordingDate());
                    uosstmt.setString(2, this.getUc001_EffectiveDate());
                    uosstmt.setInt(3, this.getUc001_DocumentID());
                    uosstmt.setInt(4, this.getUc001_Book());
                    uosstmt.setInt(5,this.getUc001_Page());
                    uosstmt.addBatch();
                    con.setAutoCommit(false);
                    uosstmt.executeBatch();
                    con.setAutoCommit(true);
                    System.out.println("Ownership Record Updated Successfully.");
                    
                
                // Otherwise insert the new ownership record for the existing owner
                } else {
                    System.out.println("Ownership Record does not exist");
                    iosstmt = con.prepareStatement(insertownership);
                    iosstmt.setString(1, this.getOwnershipDbRecord());
                    iosstmt.setString(2, this.getOwnerDBRecord());                    
                    iosstmt.setString(3, this.getUc001_DocumentType());
                    iosstmt.setString(4, this.getUc001_RecordingDate());
                    iosstmt.setString(5, this.getUc001_EffectiveDate());
                    iosstmt.setInt(6, this.getUc001_DocumentID());
                    iosstmt.setInt(7, this.getUc001_Book());
                    iosstmt.setInt(8, this.getUc001_Page());
                    iosstmt.setInt(9, 1);
                    iosstmt.setInt(10, 0);
                    iosstmt.setString(11, this.getUc001_dbRecord());
                    iosstmt.addBatch();
                    con.setAutoCommit(false);
                    iosstmt.executeBatch();
                    con.setAutoCommit(true);
                    System.out.println("Ownership Record Inserted Successfully.");
                    
                    
                }
                // close the connection
                con.close();

            } else {
                
                // Creating new Owner Record
                System.out.println("Record does not exist, creating new records");
                iostmt = con.prepareStatement(insertowner);
                iostmt.setString(1, ORID);
                iostmt.setString(2, this.getUc001_Name1());
                iostmt.setString(3, this.getUc001_Name2());
                iostmt.setString(4, this.getUc001_Name3());
                iostmt.setString(5, this.getUc001_Name4());
                iostmt.setString(6, this.getUc001_Address());
                iostmt.setString(7, this.getUc001_City());
                iostmt.setString(8, this.getUc001_State());
                iostmt.setInt(9, this.getUc001_ZipCode());
                iostmt.setString(10, this.getUc001_ContactNumber());
                iostmt.addBatch();
                con.setAutoCommit(false);
                iostmt.executeBatch();
                con.setAutoCommit(true);
                System.out.println("Owner Record Inserted Successfully.");
                
                // Also Creating new Ownership Record
                System.out.println("Now creating Ownership Record");
                iosstmt = con.prepareStatement(insertownership);
                iosstmt.setString(1, this.getOwnershipDbRecord());
                iosstmt.setString(2, this.getOwnerDBRecord());                    
                iosstmt.setString(3, this.getUc001_DocumentType());
                iosstmt.setString(4, this.getUc001_RecordingDate());
                iosstmt.setString(5, this.getUc001_EffectiveDate());
                iosstmt.setInt(6, this.getUc001_DocumentID());
                iosstmt.setInt(7, this.getUc001_Book());
                iosstmt.setInt(8, this.getUc001_Page());
                iosstmt.setInt(9, 1);
                iosstmt.setInt(10, 0);
                iosstmt.setString(11, this.getUc001_dbRecord());
                iosstmt.addBatch();
                con.setAutoCommit(false);
                iosstmt.executeBatch();
                con.setAutoCommit(true);
                System.out.println("Ownership Record Inserted Successfully.");
                
                // close the connection
                con.close();
                
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void setUc001_Name4(String uc001_Name4) {
        super.setUc001_Name4(uc001_Name4); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_Name4() {
        return super.getUc001_Name4(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_Name3(String uc001_Name3) {
        super.setUc001_Name3(uc001_Name3); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_Name3() {
        return super.getUc001_Name3(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_Name2(String uc001_Name2) {
        super.setUc001_Name2(uc001_Name2); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_Name2() {
        return super.getUc001_Name2(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_Name1(String uc001_Name1) {
        super.setUc001_Name1(uc001_Name1); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_Name1() {
        return super.getUc001_Name1(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    private final String OWNERSHIP = "SURFACE";
    private int insertModCount;
    private int modCount;
    private double xuc002_Interest;
    private String uc001_DocumentType;
    private String uc001_EffectiveDate;
    private String uc001_RecordingDate;
    private int uc001_DocumentID;
    private int uc001_Book;
    private int uc001_Page;
    private String dbRecord;
    private final String OwnerDbRecord = getRandomUUID();
    private final String OwnershipDbRecord = getRandomUUID();
    
    public double getXuc002_Interest() {
        return this.xuc002_Interest;
    }

    public void setXuc002_Interest(double xuc002_Interest) {
        this.xuc002_Interest = xuc002_Interest;
    }

    public int getModCount() {
        return this.modCount;
    }

    public void incrementModCount() {
        this.modCount++;
    }

    private String getOwnershipType() {
        return this.OWNERSHIP;
    }

    public int getInsertModCount() {
        return insertModCount;
    }

    public void setInsertModCount(int insertModCount) {
        this.insertModCount = insertModCount;
    }

    @Override
    public void setUc001_ZipCode(int uc001_ZipCode) {
        super.setUc001_ZipCode(uc001_ZipCode); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getUc001_ZipCode() {
        return super.getUc001_ZipCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_State(String uc001_State) {
        super.setUc001_State(uc001_State); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_State() {
        return super.getUc001_State(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_City(String uc001_City) {
        super.setUc001_City(uc001_City); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_City() {
        return super.getUc001_City(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_Address(String uc001_Address) {
        super.setUc001_Address(uc001_Address); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_Address() {
        return super.getUc001_Address(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUc001_ContactNumber(String uc001_ContactNumber) {
        super.setUc001_ContactNumber(uc001_ContactNumber); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUc001_ContactNumber() {
        return super.getUc001_ContactNumber(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getUc001_DocumentType() {
        return uc001_DocumentType;
    }

    public void setUc001_DocumentType(String uc001_DocumentType) {
        this.uc001_DocumentType = uc001_DocumentType;
    }

    public String getUc001_EffectiveDate() {
        return uc001_EffectiveDate;
    }

    public void setUc001_EffectiveDate(String uc001_EffectiveDate) {
        this.uc001_EffectiveDate = uc001_EffectiveDate;
    }

    public String getUc001_RecordingDate() {
        return uc001_RecordingDate;
    }

    public void setUc001_RecordingDate(String uc001_RecordingDate) {
        this.uc001_RecordingDate = uc001_RecordingDate;
    }

    public int getUc001_DocumentID() {
        return uc001_DocumentID;
    }

    public void setUc001_DocumentID(int uc001_DocumentID) {
        this.uc001_DocumentID = uc001_DocumentID;
    }

    public int getUc001_Book() {
        return uc001_Book;
    }

    public void setUc001_Book(int uc001_Book) {
        this.uc001_Book = uc001_Book;
    }

    public int getUc001_Page() {
        return uc001_Page;
    }

    public void setUc001_Page(int uc001_Page) {
        this.uc001_Page = uc001_Page;
    }
       


}
