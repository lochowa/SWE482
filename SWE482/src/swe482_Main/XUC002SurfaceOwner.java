package swe482_Main;

import java.util.ArrayList;

/**
 * @author Michael Barth
 * This class object inherits attributes and mutators/accessors from UC001Owner
 */
public class XUC002SurfaceOwner extends UC001Owner {
    
    XUC002SurfaceOwner(
            String uc001_Name1,
            String uc001_Name2,
            String uc001_Name3,
            String uc001_Name4,
            String uc001_Address,
            String uc001_City,
            String uc001_State,
            int uc001_ZipCode,
            double xuc002_Interest,
            int insertModCount
    ){
        this.setUc001_Name1(uc001_Name1);
        this.setUc001_Name2(uc001_Name2);
        this.setUc001_Name3(uc001_Name3);
        this.setUc001_Name4(uc001_Name4);
        this.setUc001_Address(uc001_Address);
        this.setUc001_City(uc001_City);
        this.setUc001_State(uc001_State);
        this.setUc001_ZipCode(uc001_ZipCode);
        this.setXuc002_Interest(xuc002_Interest);
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
    private ArrayList<UC001Document> deedList = new ArrayList<>();
    private int modCount;
    private double xuc002_Interest;
    
    public void addUC001Document(UC001Document document){
        this.deedList.add(document);
    }
    
    public UC001Document getUC001Document(int index){
        return this.deedList.get(index);
    }
    public void removeUC001Docuemnt(int index){
         for (int i = 0; i < deedList.size(); i++){
            if(deedList.get(i).getInsertModCount() == index){
                deedList.remove(i);
            }
        }
    }
    public double getXuc002_Interest(){
        return this.xuc002_Interest;
    }
    
    public void setXuc002_Interest(double xuc002_Interest){
        this.xuc002_Interest = xuc002_Interest;
    }
    
    public void addDocument(UC001Document document){
        this.deedList.add(document); 
    }
    
    public void getDocument(int index){
        this.deedList.get(index);
    }
    
    public int getModCount(){
        return this.modCount;
    }
    
    public void incrementModCount(){
        this.modCount++;
    }
    
    private String getOwnershipType(){
        return this.OWNERSHIP;
    }

    public ArrayList<UC001Document> getDeedList() {
        return deedList;
    }

    public void setDeedList(ArrayList<UC001Document> deedList) {
        this.deedList = deedList;
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

}
