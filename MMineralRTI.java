package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
public class MMineralRTI extends java.util.Observable {

    MMineralRTI() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model MineralRTI()");
    }

    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()

    // Variable Declaration Area:  Do not change.
    private int counter;
    private int dbRecordID;
    private double interest;
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
            boolean active) {
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
        notifyObservers(counter);
    }

}
