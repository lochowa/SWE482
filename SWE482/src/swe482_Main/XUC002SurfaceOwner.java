package swe482_Main;

import java.util.ArrayList;

/**
 * @author Michael Barth This class object inherits attributes and
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
            int uc001_Page
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
