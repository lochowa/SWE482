package swe482_Main;

import java.util.ArrayList;

/**
 *
 * @author Ubuntu2B
 */
public class XUC003MineralOwner extends UC001Owner {
    
    XUC003MineralOwner(
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
            int uc001_Page
    ){
        this.setInsertModCount(insertModCount);
        this.setXuc003_Interest(xuc003_Interest);
        this.setXuc003_InterestStatus(xuc003_InterestStatus);
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
    }

    private final String OWNERSHIP = "MINERAL";
    private int insertModCount;
    private double xuc003_Interest;
    private String xuc003_InterestStatus;
    private XUC003Burden burden;
    private String uc001_DocumentType;
    private String uc001_EffectiveDate;
    private String uc001_RecordingDate;
    private int uc001_DocumentID;
    private int uc001_Book;
    private int uc001_Page;
    
    public double getXuc003_Interest(){
        return this.xuc003_Interest;
    }
    
    public void setXuc003_Interest(double xuc003_Interest){
        this.xuc003_Interest = xuc003_Interest;
    }
    
    public String getOwnershipType(){
        return this.OWNERSHIP;
    }

    public String getXuc003_InterestStatus() {
        return xuc003_InterestStatus;
    }

    public void setXuc003_InterestStatus(String xuc003_InterestStatus) {
        this.xuc003_InterestStatus = xuc003_InterestStatus;
    }

    public XUC003Burden getBurden() {
        return burden;
    }

    public void setBurden(XUC003Burden burden) {
        this.burden = burden;
    }

    public int getInsertModCount() {
        return insertModCount;
    }

    public void setInsertModCount(int insertModCount) {
        this.insertModCount = insertModCount;
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
