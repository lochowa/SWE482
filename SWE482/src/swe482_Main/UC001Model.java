package swe482_Main;

/**
 *
 * @author by Michael Barth
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class UC001Model {

    UC001Model() {
    }   // UC001Model()

    private final ArrayList<XUC002SurfaceOwner> SurfaceOwnerList = new ArrayList<>();
    private final ArrayList<XUC003MineralOwner> MineralOwnerList = new ArrayList<>();
    private XUC002SurfaceOwner XUC002_SurfaceOwner;
    private XUC003MineralOwner XUC003_MineralOwner;
    private int modCount;

    public void addXUC002SurfaceOwner(XUC002SurfaceOwner owner) {
        this.SurfaceOwnerList.add(owner);
    }

    public XUC002SurfaceOwner getXUC002SurfaceOwner(int index) {
        for (int i = 0; i < SurfaceOwnerList.size(); i++) {
            if (SurfaceOwnerList.get(i).getInsertModCount() == index) {
                return this.SurfaceOwnerList.get(i);
            }
        }
        return null;
    }

    public int getXUC002SurfaceOwnerIndex(int index) {
        int number = 0;
        for (int i = 0; i < SurfaceOwnerList.size(); i++) {
            if (SurfaceOwnerList.get(i).getInsertModCount() == index) {
                number = i;
            }
        }
        return number;
    }

    public void removeXUC002SurfaceOwner(int index) {
        for (int i = 0; i < SurfaceOwnerList.size(); i++) {
            if (SurfaceOwnerList.get(i).getInsertModCount() == index) {
                SurfaceOwnerList.remove(i);
            }
        }
    }

    public void addXUC003MineralOwner(XUC003MineralOwner owner) {
        this.MineralOwnerList.add(owner);
    }

    public XUC003MineralOwner getXUC003MineralOwner(int index) {
        for (int i = 0; i < MineralOwnerList.size(); i++) {
            if (MineralOwnerList.get(i).getInsertModCount() == index) {
                return this.MineralOwnerList.get(i);
            }
        }
        return null;
    }

    public int getXUC003MineralOwnerIndex(int index) {
        int number = 0;
        for (int i = 0; i < SurfaceOwnerList.size(); i++) {
            if (SurfaceOwnerList.get(i).getInsertModCount() == index) {
                number = i;
            }
        }
        return number;
    }

    public void removeXUC003MineralOwner(int index) {
        for (int i = 0; i < MineralOwnerList.size(); i++) {
            if (MineralOwnerList.get(i).getInsertModCount() == index) {
                MineralOwnerList.remove(i);
            }
        }
    }

    public int getModCount() {
        return this.modCount;
    }

    public void incrementMModCount() {
        this.modCount++;
    }

    public final String dbRecordID = getDBRecordID();
    private int xuc001_ParcelID;
    private String xuc001_TaxAccountID;
    private String xuc001_County;
    private String xuc001_State;
    private double xuc001_Acreage;
    private String xuc001_Township;
    private String xuc001_Range;
    private int xuc001_Section;
    private String xuc001_LegalDescription;
    private String xuc001_Meridian;
    private final String[] PropertyBounders = new String[4];
    private double xuc001_InterestChecksum = 0;

    public String getDBRecordID() {
        UUID UrecID = UUID.randomUUID();
        String recID = UrecID.toString();
        return recID;
    }
    
    public String getDBRecord(){
        return this.dbRecordID;
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
    // END Variable Declaration Area

    void setUC001PropertyValues(
            int xuc001_ParcelID,
            String xuc001_TaxAccountID,
            String xuc001_County,
            String xuc001_State,
            double xuc001_Acreage,
            String xuc001_Township,
            String xuc001_Range,
            int xuc001_Section,
            String xuc001_Meridian,
            String xuc001_LegalDescription,
            String xuc001_NorthBounder,
            String xuc001_EastBounder,
            String xuc001_SouthBounder,
            String xuc001_WestBounder
    // Setters added by Andrew Lochow
    ) {
        //this.dbRecordID = dbRecordID;
        this.xuc001_ParcelID = xuc001_ParcelID;
        this.xuc001_TaxAccountID = xuc001_TaxAccountID;
        this.xuc001_County = xuc001_County;
        this.xuc001_State = xuc001_State;
        this.xuc001_Acreage = xuc001_Acreage;
        this.xuc001_Township = xuc001_Township;
        this.xuc001_Range = xuc001_Range;
        this.xuc001_Section = xuc001_Section;
        this.xuc001_Meridian = xuc001_Meridian;
        this.xuc001_LegalDescription = xuc001_LegalDescription;
        this.PropertyBounders[0] = xuc001_NorthBounder;
        this.PropertyBounders[1] = xuc001_EastBounder;
        this.PropertyBounders[2] = xuc001_SouthBounder;
        this.PropertyBounders[3] = xuc001_WestBounder;
    }

    //CommittoDB Method Added 6/7/2017 by Andrew Lochow
    public void committoDB() {
        Connection con;
        PreparedStatement istmt;
        PreparedStatement sstmt;
        PreparedStatement ustmt;
        ResultSet rs;

        String select = "SELECT LandRecordID from Property Where ID_Parcel = ?";

        String update = "UPDATE Property SET ID_Tax = ? , Description = ? , Acres = ?, Township = ?, Range = ?, Section = ?, NorthBounder = ?, EastBounder = ?, SouthBounder = ?, WestBounder = ?, PM = ? WHERE LandRecordID = ?";

        String insert = "INSERT INTO Property"
                + "(LandRecordID,ID_Parcel,ID_Tax, Description, Acres, Township, Range, Section, NorthBounder, EastBounder, SouthBounder, WestBounder, PM)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            con = this.connect();
            sstmt = con.prepareStatement(select);
            sstmt.setInt(1, this.xuc001_ParcelID);
            rs = sstmt.executeQuery();
            String PID;
            if (rs.next()) {
                PID = rs.getString(1);
                System.out.println("Record Exists under Record ID: " + PID + ". Updating Record instead.");
                ustmt = con.prepareStatement(update);
                System.out.println("Test: " + xuc001_LegalDescription);
                ustmt.setString(1, xuc001_TaxAccountID);
                ustmt.setString(2, xuc001_LegalDescription);
                ustmt.setDouble(3, xuc001_Acreage);
                ustmt.setString(4, this.xuc001_Township);
                ustmt.setString(5, this.xuc001_Range);
                ustmt.setInt(6, this.xuc001_Section);
                ustmt.setString(7, this.PropertyBounders[0]);
                ustmt.setString(8, this.PropertyBounders[1]);
                ustmt.setString(9, this.PropertyBounders[2]);
                ustmt.setString(10, this.PropertyBounders[3]);
                ustmt.setString(11, this.xuc001_Meridian);
                ustmt.setString(12, PID);
                ustmt.addBatch();

                con.setAutoCommit(false);
                ustmt.executeBatch();
                con.setAutoCommit(true);
                System.out.println("Record Updated Successfully.");
                con.close();

            } else {
                System.out.println("Record does not exist, creating new record");
                istmt = con.prepareStatement(insert);
                istmt.setString(1, this.dbRecordID);
                istmt.setInt(2, this.xuc001_ParcelID);
                istmt.setString(3, this.xuc001_TaxAccountID);
                istmt.setString(4, this.xuc001_LegalDescription);
                istmt.setDouble(5, this.xuc001_Acreage);
                istmt.setString(6, this.xuc001_Township);
                istmt.setString(7, this.xuc001_Range);
                istmt.setInt(8, this.xuc001_Section);
                istmt.setString(9, this.PropertyBounders[0]);
                istmt.setString(10, this.PropertyBounders[1]);
                istmt.setString(11, this.PropertyBounders[2]);
                istmt.setString(12, this.PropertyBounders[3]);
                istmt.setString(13, this.xuc001_Meridian);
                
                istmt.executeUpdate();
                System.out.println("Record is inserted into Property table!");
                //  Add committSurfacetoDB() and committMineraltoDB() here.
                //  It chains methods while the connection is open, if it works.  
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public XUC002SurfaceOwner createXUC002SurfaceOwner(
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
            String uc001_dbRecord
    ) {
        this.XUC002_SurfaceOwner = new XUC002SurfaceOwner(
                insertModCount,
                xuc002_Interest,
                uc001_Name1,
                uc001_Name2,
                uc001_Name3,
                uc001_Name4,
                uc001_Address,
                uc001_City,
                uc001_State,
                uc001_ZipCode,
                uc001_ContactNumber,
                uc001_DocumentType,
                uc001_EffectiveDate,
                uc001_RecordingDate,
                uc001_DocumentID,
                uc001_Book,
                uc001_Page,
                uc001_dbRecord
        );
        return this.XUC002_SurfaceOwner;
    }

    public XUC003MineralOwner createXUC003MineralOwner(
            int insertModCount,
            double xuc003_Interest,
            String xuc003_InterestStatus,
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
            String uc001_dbRecord
    ) {
        this.XUC003_MineralOwner = new XUC003MineralOwner(
                insertModCount,
                xuc003_Interest,
                xuc003_InterestStatus,
                uc001_Name1,
                uc001_Name2,
                uc001_Name3,
                uc001_Name4,
                uc001_Address,
                uc001_City,
                uc001_State,
                uc001_ZipCode,
                uc001_ContactNumber,
                uc001_DocumentType,
                uc001_EffectiveDate,
                uc001_RecordingDate,
                uc001_DocumentID,
                uc001_Book,
                uc001_Page,
                uc001_dbRecord
        );
        return this.XUC003_MineralOwner;
    }

    public String createSurfaceOwnerString(XUC002SurfaceOwner owner) {
        String string = owner.getUc001_Name1();
        if (!owner.getUc001_Name2().isEmpty()
                || !owner.getUc001_Name3().isEmpty()
                || !owner.getUc001_Name4().isEmpty()) {
            string += String.format(" et al");
        }
        string += String.format(", %s", owner.getUc001_Address());
        string += String.format(", %s", owner.getUc001_City());
        string += String.format(", %s", owner.getUc001_State().toUpperCase());
        string += String.format(", %s", owner.getUc001_ZipCode());
        return string;
    }

    public String createMineralOwnerString(XUC003MineralOwner owner) {
        String string = owner.getUc001_Name1();
        if (!owner.getUc001_Name2().isEmpty()
                || !owner.getUc001_Name3().isEmpty()
                || !owner.getUc001_Name4().isEmpty()) {
            string += String.format("et al");
        }
        return string;
    }

    public String getPropertyBounders(int index) {
        return PropertyBounders[index];
    }

    public void setPropertyBounders(String bounder, int index) {
        this.PropertyBounders[index] = bounder;
    }

    public int getXuc001_ParcelID() {
        return xuc001_ParcelID;
    }

    public void setXuc001_ParcelID(int xuc001_ParcelID) {
        this.xuc001_ParcelID = xuc001_ParcelID;
    }

    public String getXuc001_TaxAccountID() {
        return xuc001_TaxAccountID;
    }

    public void setXuc001_TaxAccountID(String xuc001_TaxAccountID) {
        this.xuc001_TaxAccountID = xuc001_TaxAccountID;
    }

    public String getXuc001_County() {
        return xuc001_County;
    }

    public void setXuc001_County(String xuc001_County) {
        this.xuc001_County = xuc001_County;
    }

    public String getXuc001_State() {
        return xuc001_State;
    }

    public void setXuc001_State(String xuc001_State) {
        this.xuc001_State = xuc001_State;
    }

    public double getXuc001_Acreage() {
        return xuc001_Acreage;
    }

    public void setXuc001_Acreage(double xuc001_Acreage) {
        this.xuc001_Acreage = xuc001_Acreage;
    }

    public String getXuc001_Township() {
        return xuc001_Township;
    }

    public void setXuc001_Township(String xuc001_Township) {
        this.xuc001_Township = xuc001_Township;
    }

    public String getXuc001_Range() {
        return xuc001_Range;
    }

    public void setXuc001_Range(String xuc001_Range) {
        this.xuc001_Range = xuc001_Range;
    }

    public int getXuc001_Section() {
        return xuc001_Section;
    }

    public void setXuc001_Section(int xuc001_Section) {
        this.xuc001_Section = xuc001_Section;
    }

    public String getXuc001_LegalDescription() {
        return xuc001_LegalDescription;
    }

    public void setXuc001_LegalDescription(String xuc001_LegalDescription) {
        this.xuc001_LegalDescription = xuc001_LegalDescription;
    }

    public String getXuc001_Meridian() {
        return xuc001_Meridian;
    }

    public void setXuc001_Meridian(String xuc001_Meridian) {
        this.xuc001_Meridian = xuc001_Meridian;
    }

    public double getXuc001_InterestChecksum() {
        return xuc001_InterestChecksum;
    }

    public void incrementXuc001_InterestChecksum(double xuc001_InterestChecksum) {
        this.xuc001_InterestChecksum += xuc001_InterestChecksum;
    }

    public void decrementXuc001_InterestChecksum(double xuc001_InterestChecksum){
        this.xuc001_InterestChecksum -= xuc001_InterestChecksum;
    }
    
    public String createInterestChecksumString(){
        return String.format("Interest Checksum: %.10f", this.getXuc001_InterestChecksum());
    }
    
    public boolean validateInterestChecksum(){
        return this.xuc001_InterestChecksum <= 1 && this.xuc001_InterestChecksum > 0;
    }

    public ArrayList<XUC002SurfaceOwner> getSurfaceOwnerList() {
        return SurfaceOwnerList;
    }

    public ArrayList<XUC003MineralOwner> getMineralOwnerList() {
        return MineralOwnerList;
    }
}
