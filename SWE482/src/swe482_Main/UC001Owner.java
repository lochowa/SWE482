package swe482_Main;

/**
 *
 * @author Michael Barth
 * Parent Class Object to XUC002SurfaceOwner and XUC003MineralOwner
 */
public class UC001Owner {
    
    private String[] ownerName = new String[4];
    private String address;
    private String city;
    private String state;
    private int zipCode;

    public String getOwnerName(int index) {
        return this.ownerName[index];
    }
    
    public boolean addOwnerName(String name){
        for (String n : ownerName) {
            if(n.isEmpty()){
                n = name;
                return true;
            }
        }
        return false;
    }

    public void setOwnerName(String[] ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    
}
