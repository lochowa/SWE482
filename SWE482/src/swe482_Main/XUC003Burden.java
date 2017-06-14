package swe482_Main;
/**
 * @author Michael Barth
 * XUC003Burden is a class object associated to XUC003MineralOWner, to record non-client leasing details.
 *
 */
public class XUC003Burden {
    
    private UC001Document documentReference;
    private String burden_Lessee;
    private int burden_PrimaryTerm;
    private int burden_SecondaryTerm;
    private double burden_Royalty;
    private String burden_pTermEndDate;
    private String burden_sTermEndDate;
    private double burden_Acreage;
    private String burden_CurrentLessee;
    private String burden_ShallowRights;
    private String burden_ShallowDepthRestriction;
    private String burden_DeepRights;
    private String burden_DeepDepthRestriction;

    public UC001Document getDocumentReference() {
        return documentReference;
    }

    public void setDocumentReference(UC001Document documentReference) {
        this.documentReference = documentReference;
    }

    public String getBurden_Lessee() {
        return burden_Lessee;
    }

    public void setBurden_Lessee(String burden_Lessee) {
        this.burden_Lessee = burden_Lessee;
    }

    public int getBurden_PrimaryTerm() {
        return burden_PrimaryTerm;
    }

    public void setBurden_PrimaryTerm(int burden_PrimaryTerm) {
        this.burden_PrimaryTerm = burden_PrimaryTerm;
    }

    public int getBurden_SecondaryTerm() {
        return burden_SecondaryTerm;
    }

    public void setBurden_SecondaryTerm(int burden_SecondaryTerm) {
        this.burden_SecondaryTerm = burden_SecondaryTerm;
    }

    public double getBurden_Royalty() {
        return burden_Royalty;
    }

    public void setBurden_Royalty(double burden_Royalty) {
        this.burden_Royalty = burden_Royalty;
    }

    public String getBurden_pTermEndDate() {
        return burden_pTermEndDate;
    }

    public void setBurden_pTermEndDate(String burden_pTermEndDate) {
        this.burden_pTermEndDate = burden_pTermEndDate;
    }

    public String getBurden_sTermEndDate() {
        return burden_sTermEndDate;
    }

    public void setBurden_sTermEndDate(String burden_sTermEndDate) {
        this.burden_sTermEndDate = burden_sTermEndDate;
    }

    public double getBurden_Acreage() {
        return burden_Acreage;
    }

    public void setBurden_Acreage(double burden_Acreage) {
        this.burden_Acreage = burden_Acreage;
    }

    public String getBurden_CurrentLessee() {
        return burden_CurrentLessee;
    }

    public void setBurden_CurrentLessee(String burden_CurrentLessee) {
        this.burden_CurrentLessee = burden_CurrentLessee;
    }

    public String getBurden_ShallowRights() {
        return burden_ShallowRights;
    }

    public void setBurden_ShallowRights(String burden_ShallowRights) {
        this.burden_ShallowRights = burden_ShallowRights;
    }

    public String getBurden_ShallowDepthRestriction() {
        return burden_ShallowDepthRestriction;
    }

    public void setBurden_ShallowDepthRestriction(String burden_ShallowDepthRestriction) {
        this.burden_ShallowDepthRestriction = burden_ShallowDepthRestriction;
    }

    public String getBurden_DeepRights() {
        return burden_DeepRights;
    }

    public void setBurden_DeepRights(String burden_DeepRights) {
        this.burden_DeepRights = burden_DeepRights;
    }

    public String getBurden_DeepDepthRestriction() {
        return burden_DeepDepthRestriction;
    }

    public void setBurden_DeepDepthRestriction(String burden_DeepDepthRestriction) {
        this.burden_DeepDepthRestriction = burden_DeepDepthRestriction;
    }
    
}
