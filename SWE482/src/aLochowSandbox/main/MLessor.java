package aLochowSandbox.main;

import swe482_Main.*;

/**
 *
 * @author by Michael Barth
 */
public class MLessor extends java.util.Observable {

    MLessor() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Lessor()");
    }

    // Variable Declaration Area:  Do not change.
    private int dbRecordID;
    private double interest;
    private String status;
    private String[] owners = new String[4];
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private String phone;
    private boolean active;
    // TO DO:  Insert List<E> to contain Recorded Documents   
    // END Variable Declaration Area

    void setValues(
            int dbRecordID,
            double interest,
            String status,
            String name1,
            String name2,
            String name3,
            String name4,
            String address,
            String city,
            String state,
            int zipcode,
            String phone,
            boolean active) // TO DO:  Insert code to include Recorded Document
    {
        this.interest = interest;
        this.status = status;
        this.owners[0] = name1;
        this.owners[1] = name2;
        this.owners[2] = name3;
        this.owners[3] = name4;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        // TO DO: Insert code to include Recorded Document
    }

}
