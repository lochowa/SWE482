package swe482_Main;
/**
 * @author Michael Barth
 * XUC003Burden is a class object associated to XUC003MineralOWner, to record non-client leasing details.
 *
 */
public class XUC003Burden {
    
    private UC001Document documentReference;
    private String lessee;
    private int primaryTerm;
    private int secondaryTerm;
    private double royalty;
    private String pTermEndDate;
    private String sTermEndDate;
    private int acreage;
    private String currentLessee;
    private String shallowRights;
    private String shallowDepthRestriction;
    private String deeepRights;
    private String deepDepthRestriction;

    public UC001Document getDocumentReference() {
        return documentReference;
    }

    public void setDocumentReference(UC001Document documentReference) {
        this.documentReference = documentReference;
    }

    public String getLessee() {
        return lessee;
    }

    public void setLessee(String lessee) {
        this.lessee = lessee;
    }

    public int getPrimaryTerm() {
        return primaryTerm;
    }

    public void setPrimaryTerm(int primaryTerm) {
        this.primaryTerm = primaryTerm;
    }

    public int getSecondaryTerm() {
        return secondaryTerm;
    }

    public void setSecondaryTerm(int secondaryTerm) {
        this.secondaryTerm = secondaryTerm;
    }

    public double getRoyalty() {
        return royalty;
    }

    public void setRoyalty(double royalty) {
        this.royalty = royalty;
    }

    public String getpTermEndDate() {
        return pTermEndDate;
    }

    public void setpTermEndDate(String pTermEndDate) {
        this.pTermEndDate = pTermEndDate;
    }

    public String getsTermEndDate() {
        return sTermEndDate;
    }

    public void setsTermEndDate(String sTermEndDate) {
        this.sTermEndDate = sTermEndDate;
    }

    public int getAcreage() {
        return acreage;
    }

    public void setAcreage(int acreage) {
        this.acreage = acreage;
    }

    public String getCurrentLessee() {
        return currentLessee;
    }

    public void setCurrentLessee(String currentLessee) {
        this.currentLessee = currentLessee;
    }

    public String getShallowRights() {
        return shallowRights;
    }

    public void setShallowRights(String shallowRights) {
        this.shallowRights = shallowRights;
    }

    public String getShallowDepthRestriction() {
        return shallowDepthRestriction;
    }

    public void setShallowDepthRestriction(String shallowDepthRestriction) {
        this.shallowDepthRestriction = shallowDepthRestriction;
    }

    public String getDeeepRights() {
        return deeepRights;
    }

    public void setDeeepRights(String deeepRights) {
        this.deeepRights = deeepRights;
    }

    public String getDeepDepthRestriction() {
        return deepDepthRestriction;
    }

    public void setDeepDepthRestriction(String deepDepthRestriction) {
        this.deepDepthRestriction = deepDepthRestriction;
    }
    
}
