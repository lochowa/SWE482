package swe482_Main;

import java.util.ArrayList;

/**
 *
 * @author Ubuntu2B
 */
public class XUC003MineralOwner extends UC001Owner {
    
    XUC003MineralOwner(
                String uc001_Name1,
                String uc001_Name2,
                String uc001_Name3,
                String uc001_Name4,
                String uc001_Address,
                String uc001_City,
                String uc001_State,
                int uc001_ZipCode,
                int insertModCount,
                String xuc003_InterestStatus,
                double xuc003_Interest
    
    ){
        this.setUc001_Name1(uc001_Name1);
        this.setUc001_Name2(uc001_Name2);
        this.setUc001_Name3(uc001_Name3);
        this.setUc001_Name4(uc001_Name4);
        this.setUc001_Address(uc001_Address);
        this.setUc001_City(uc001_City);
        this.setUc001_State(uc001_State);
        this.setUc001_ZipCode(uc001_ZipCode);
        this.setInsertModCount(insertModCount);
        this.setXuc003_Interest(xuc003_Interest);
        this.setXuc003_InterestStatus(xuc003_InterestStatus);
    }

    private final String OWNERSHIP = "MINERAL";
    private int insertModCount;
    ArrayList<UC001Document> deedList = new ArrayList<>();
    private double xuc003_Interest;
    private String xuc003_InterestStatus;
    private XUC003Burden burden;
    
    public double getXuc003_Interest(){
        return this.xuc003_Interest;
    }
    
    public void setXuc003_Interest(double xuc003_Interest){
        this.xuc003_Interest = xuc003_Interest;
    }
    
    public void addDocument(UC001Document document){
        this.deedList.add(document); 
    }
    
    public void getDocument(int index){
        this.deedList.get(index);
    }
    
    private String getOwnershipType(){
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
}
