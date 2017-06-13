package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MSurfaceRTI extends java.util.Observable {

    // Variable Declaration Area:  Do not change.
    private int counter;
    private int dbRecordID;
    private final String[] names = new String[4];
    private String address;
    private String city;
    private String state;
    private int zipcode;
    private String phone;
    // TO DO: Insert List<E> to hold recorded documents.

    // END Variable Declariation Area.
    MSurfaceRTI() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model SurfaceRTI()");

    }

    void setValues(
            int dbRecord,
            String name1,
            String name2,
            String name3,
            String name4,
            String address,
            String city,
            String state,
            int zipcode,
            String phone) {
        this.dbRecordID = dbRecord;
        this.names[0] = name1;
        this.names[1] = name2;
        this.names[2] = name3;
        this.names[3] = name4;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.phone = phone;
    }

}
