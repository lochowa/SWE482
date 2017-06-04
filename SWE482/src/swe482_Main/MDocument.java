package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MDocument extends java.util.Observable {

    MDocument() {
        // Test Script:  Intercommunication Feedback.
        System.out.println("Model Menu()");
    }

    // Variable Declaration Area:  Do not change.
    private int _RecordIdentification;
    private String _DocumentType;
    private String _EffectiveDate;
    private String _RecordedDate;
    private int _ReceptionNumber;
    private int _Book;
    private int _Page;

    // END Variable Declaration Area
    void setValues(
            int RecordIdentification,
            String DocumentType,
            String EffectiveDate,
            String RecordedDate,
            int ReceptionNumber,
            int Book,
            int Page) {
        this._RecordIdentification = RecordIdentification;
        this._DocumentType = DocumentType;
        this._EffectiveDate = EffectiveDate;
        this._RecordedDate = RecordedDate;
        this._ReceptionNumber = ReceptionNumber;
        this._Book = Book;
        this._Page = Page;
    }
}
