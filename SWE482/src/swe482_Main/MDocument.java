package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MDocument extends java.util.Observable {

    void incrementValue() {
        ++counter;
    } // incrementValue()

    int getCounter() {
        return counter;
    } // getCounter()

    MDocument() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Menu()");
    }

    // Variable Declaration Area:  Do not change.
    private int counter;
    private int dbRecordID;
    private String docType;
    private String effectiveDate;
    private String recordingDate;
    private int documentID;
    private int book;
    private int page;

    // END Variable Declaration Area
    void setValues(
            int dbRecordID,
            String docType,
            String effectiveDate,
            String recordingDate,
            int documentID,
            int book,
            int page) {
        this.dbRecordID = dbRecordID;
        this.docType = docType;
        this.effectiveDate = effectiveDate;
        this.recordingDate = recordingDate;
        this.documentID = documentID;
        this.book = book;
        this.page = page;
                notifyObservers(counter);
    }
}
