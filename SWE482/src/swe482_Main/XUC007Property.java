
package swe482_Main;

/**
 *
 * @author Michael Barth
 */
public class XUC007Property {
    
    XUC007Property(
            int insertModCount,
            int xuc007_ParcelID,
            String xuc007_TaxMapID,
            String xuc007_County,
            String xuc007_State,
            double xuc007_Acreage,
            String xuc007_Township,
            String xuc007_Range,
            int xuc007_Section,
            String xuc007_Meridian,
            String xuc007_LegalDescription,
            boolean isPropertyBounders,
            String xuc007_NorthBounder,
            String xuc007_EastBounder,
            String xuc007_SouthBounder,
            String xuc007_WestBounder
    ) {
        this.insertModCount = insertModCount;
        this.xuc007_ParcelID = xuc007_ParcelID;
        this.xuc007_TaxMapID = xuc007_TaxMapID;
        this.xuc007_County = xuc007_County;
        this.xuc007_State = xuc007_State;
        this.xuc007_Acreage = xuc007_Acreage;
        this.xuc007_Township = xuc007_Township;
        this.xuc007_Range = xuc007_Range;
        this.xuc007_Section = xuc007_Section;
        this.xuc007_Meridian = xuc007_Meridian;
        this.xuc007_LegalDescription = xuc007_LegalDescription;
        this.isPropertyBounders = isPropertyBounders;
        this.xuc007_NorthBounder = xuc007_NorthBounder;
        this.xuc007_EastBounder = xuc007_EastBounder;
        this.xuc007_SouthBounder = xuc007_SouthBounder;
        this.xuc007_WestBounder = xuc007_WestBounder;
    }
    
    private int insertModCount;
    private int xuc007_ParcelID;
    private String xuc007_TaxMapID;
    private String xuc007_County;
    private String xuc007_State;
    private double xuc007_Acreage;
    private String xuc007_Township;
    private String xuc007_Range;
    private int xuc007_Section;
    private String xuc007_Meridian;
    private String xuc007_LegalDescription;
    private boolean isPropertyBounders;
    private String xuc007_NorthBounder;
    private String xuc007_EastBounder;
    private String xuc007_SouthBounder;
    private String xuc007_WestBounder;

    public int getXuc007_ParcelID() {
        return xuc007_ParcelID;
    }

    public void setXuc007_ParcelID(int xuc007_ParcelID) {
        this.xuc007_ParcelID = xuc007_ParcelID;
    }

    public String getXuc007_TaxMapID() {
        return xuc007_TaxMapID;
    }

    public void setXuc007_TaxMapID(String xuc007_TaxMapID) {
        this.xuc007_TaxMapID = xuc007_TaxMapID;
    }

    public String getXuc007_County() {
        return xuc007_County;
    }

    public void setXuc007_County(String xuc007_County) {
        this.xuc007_County = xuc007_County;
    }

    public String getXuc007_State() {
        return xuc007_State;
    }

    public void setXuc007_State(String xuc007_State) {
        this.xuc007_State = xuc007_State;
    }

    public double getXuc007_Acreage() {
        return xuc007_Acreage;
    }

    public void setXuc007_Acreage(double xuc007_Acreage) {
        this.xuc007_Acreage = xuc007_Acreage;
    }

    public String getXuc007_Township() {
        return xuc007_Township;
    }

    public void setXuc007_Township(String xuc007_Township) {
        this.xuc007_Township = xuc007_Township;
    }

    public String getXuc007_Range() {
        return xuc007_Range;
    }

    public void setXuc007_Range(String xuc007_Range) {
        this.xuc007_Range = xuc007_Range;
    }

    public int getXuc007_Section() {
        return xuc007_Section;
    }

    public void setXuc007_Section(int xuc007_Section) {
        this.xuc007_Section = xuc007_Section;
    }

    public String getXuc007_Meridian() {
        return xuc007_Meridian;
    }

    public void setXuc007_Meridian(String xuc007_Meridian) {
        this.xuc007_Meridian = xuc007_Meridian;
    }

    public String getXuc007_LegalDescription() {
        return xuc007_LegalDescription;
    }

    public void setXuc007_LegalDescription(String xuc007_LegalDescription) {
        this.xuc007_LegalDescription = xuc007_LegalDescription;
    }

    public boolean isIsPropertyBounders() {
        return isPropertyBounders;
    }

    public void setIsPropertyBounders(boolean isPropertyBounders) {
        this.isPropertyBounders = isPropertyBounders;
    }

    public String getXuc007_NorthBounder() {
        return xuc007_NorthBounder;
    }

    public void setXuc007_NorthBounder(String xuc007_NorthBounder) {
        this.xuc007_NorthBounder = xuc007_NorthBounder;
    }

    public String getXuc007_EastBounder() {
        return xuc007_EastBounder;
    }

    public void setXuc007_EastBounder(String xuc007_EastBounder) {
        this.xuc007_EastBounder = xuc007_EastBounder;
    }

    public String getXuc007_SouthBounder() {
        return xuc007_SouthBounder;
    }

    public void setXuc007_SouthBounder(String xuc007_SouthBounder) {
        this.xuc007_SouthBounder = xuc007_SouthBounder;
    }

    public String getXuc007_WestBounder() {
        return xuc007_WestBounder;
    }

    public void setXuc007_WestBounder(String xuc007_WestBounder) {
        this.xuc007_WestBounder = xuc007_WestBounder;
    }

    public int getInsertModCount() {
        return insertModCount;
    }

    public void setInsertModCount(int insertModCount) {
        this.insertModCount = insertModCount;
    }

}
