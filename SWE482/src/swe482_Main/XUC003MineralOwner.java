package swe482_Main;

import java.util.ArrayList;

/**
 *
 * @author Ubuntu2B
 */
public class XUC003MineralOwner extends UC001Owner {
    
    private final String OWNERSHIP = "MINERAL";
    private int insertModCount;
    ArrayList<UC001Document> deedList = new ArrayList<>();
    private int modCount;
    private double interest;
    private String status;
    private XUC003Burden burden;
    
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
}
