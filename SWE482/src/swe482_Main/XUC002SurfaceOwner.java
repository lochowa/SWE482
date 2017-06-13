package swe482_Main;

import java.util.ArrayList;

/**
 * @author Michael Barth
 * This class object inherits attributes and mutators/accessors from UC001Owner
 */
public class XUC002SurfaceOwner extends UC001Owner {
    


    @Override
    public String getOwnerName(int index) {
        return super.getOwnerName(index); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addOwnerName(String name) {
        return super.addOwnerName(name); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final String OWNERSHIP = "SURFACE";
    private int insertModCount;
    private ArrayList<UC001Document> deedList = new ArrayList<>();
    private int modCount;
    private double interest;
    
    public double getInterest(){
        return this.interest;
    }
    
    public void setInterest(double interest){
        this.interest = interest;
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
}
