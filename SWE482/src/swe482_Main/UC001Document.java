package swe482_Main;

/**
 *
 * @author Michael Barth UC001Document class object created to store document
 * information, as an object.
 */
public class UC001Document {
    
    UC001Document(
            int InsertModCount,
            String uc001_DocumentType,
            String uc001_EffectiveDate,
            String uc001_RecordingDate,
            int uc001_ReceptionID,
            int uc001_Book,
            int uc001_Page
    ) {
        this.setInsertModCount(InsertModCount);
        this.setUc001_DocumentType(uc001_DocumentType);
        this.setUc001_EffectiveDate(uc001_EffectiveDate);
        this.setUc001_RecordingDate(uc001_RecordingDate);
        this.setUc001_DocumentID(uc001_DocumentID);
        this.setUc001_Book(uc001_Book);
        this.setUc001_Page(uc001_Page);
    }
    
    private int insertModCount;
    private String uc001_DocumentType;
    private String uc001_EffectiveDate;
    private String uc001_RecordingDate;
    private int uc001_DocumentID;
    private int uc001_Book;
    private int uc001_Page;
    
    public String getUc001_DocumentType() {
        return uc001_DocumentType;
    }
    
    public void setUc001_DocumentType(String uc001_DocumentType) {
        this.uc001_DocumentType = uc001_DocumentType;
    }
    
    public String getUc001_EffectiveDate() {
        return uc001_EffectiveDate;
    }
    
    public void setUc001_EffectiveDate(String uc001_EffectiveDate) {
        this.uc001_EffectiveDate = uc001_EffectiveDate;
    }
    
    public String getUc001_RecordingDate() {
        return uc001_RecordingDate;
    }
    
    public void setUc001_RecordingDate(String uc001_RecordingDate) {
        this.uc001_RecordingDate = uc001_RecordingDate;
    }
    
    public int getUc001_DocumentID() {
        return uc001_DocumentID;
    }
    
    public void setUc001_DocumentID(int uc001_DocumentID) {
        this.uc001_DocumentID = uc001_DocumentID;
    }
    
    public int getUc001_Book() {
        return uc001_Book;
    }
    
    public void setUc001_Book(int uc001_Book) {
        this.uc001_Book = uc001_Book;
    }
    
    public int getUc001_Page() {
        return uc001_Page;
    }
    
    public void setUc001_Page(int uc001_Page) {
        this.uc001_Page = uc001_Page;
    }
    
    public int getInsertModCount() {
        return insertModCount;
    }
    
    public void setInsertModCount(int insertModCount) {
        this.insertModCount = insertModCount;
    }
}
