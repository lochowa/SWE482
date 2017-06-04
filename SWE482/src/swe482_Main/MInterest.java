package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MInterest extends java.util.Observable {
    
    // Variable Declaration Area:  Do not change.
    private int dbRecordID;
    private int dbPropertyREFID;
    private int dbInterestID;
    private String nameQuery;
    private int interest;
    private String status;
    private String[] owners = new String[4];
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private String phone;
    // TO DO:  Insert List<E> to contain Recorded Documents
    private boolean active;
    
    // END Variable Declaration Area

    MInterest() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Interest()");

    }

    void setValues(
            int counter,
            int dbRecordID,
            int dbPropertyREFID,
            int dbInterestID
    ) {
        this.dbRecordID = dbRecordID;
        this.dbPropertyREFID = dbPropertyREFID;
        this.dbInterestID = dbInterestID;
    }

    void setOwner(
            int interest,
            String status,
            String[] owners,
            String address,
            String city,
            String state,
            int zipcode,
            String phone,
            boolean active) {
        this.interest = interest;
        this.status = status;
        this.owners = owners;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    
}
