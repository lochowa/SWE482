package swe482_Main;

/**
 *
 * @author Michael Barth
 UC001Document class object created to store document information, as an object.
 */
public class UC001Document {
    
    private int insertModCount;
    private String deedType;
    private String effectiveDate;
    private String recordingDate;
    private int documentNumber;
    private int book;
    private int page;

    public String getDeedType() {
        return deedType;
    }

    public void setDeedType(String deedType) {
        this.deedType = deedType;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(String recordingDate) {
        this.recordingDate = recordingDate;
    }

    public int getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(int documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getInsertModCount() {
        return insertModCount;
    }

    public void setInsertModCount(int insertModCount) {
        this.insertModCount = insertModCount;
    }
}
