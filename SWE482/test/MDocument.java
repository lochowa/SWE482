package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
public class MDocument {

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

    public int getRecordIdentification() {
        return _RecordIdentification;
    }

    public void setRecordIdentification(int _RecordIdentification) {
        this._RecordIdentification = _RecordIdentification;
    }

    public String getDocumentType() {
        return _DocumentType;
    }

    public void setDocumentType(String _DocumentType) {
        this._DocumentType = _DocumentType;
    }

    public String getEffectiveDate() {
        return _EffectiveDate;
    }

    public void setEffectiveDate(String _EffectiveDate) {
        this._EffectiveDate = _EffectiveDate;
    }

    public String getRecordedDate() {
        return _RecordedDate;
    }

    public void setRecordedDate(String _RecordedDate) {
        this._RecordedDate = _RecordedDate;
    }

    public int getReceptionNumber() {
        return _ReceptionNumber;
    }

    public void setReceptionNumber(int _ReceptionNumber) {
        this._ReceptionNumber = _ReceptionNumber;
    }

    public int getBook() {
        return _Book;
    }

    public void setBook(int _Book) {
        this._Book = _Book;
    }

    public int getPage() {
        return _Page;
    }

    public void setPage(int _Page) {
        this._Page = _Page;
    }
    
    
}
