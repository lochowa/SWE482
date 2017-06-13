package swe482_Main;

import Create_Database.DBConnect;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Michael Barth UC-002 UC002Model Class Object
 */
public class UC002Model extends java.util.Observable {
//        START XUC-007 Operations, Variable, Mutators and Accessors

    private ArrayList<XUC007Property> xuc007_LeasedProperty = new ArrayList<>();
    private int modCount = 0;
    
    private XUC007Property property;
    private int xuc007_ParcelID;
    private String xuc007_TaxAccountID;
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

    public int getModCount() {
        return this.modCount;
    }

    public void incrementModCount() {
        this.modCount++;
    }

    public XUC007Property getXuc007_LeasedProperty(int index) {
        return this.xuc007_LeasedProperty.get(index);
    }

    public void addXuc007_LeasedProperty(XUC007Property property) {
        this.xuc007_LeasedProperty.add(property);
    }

    public void removeXuc007_LeasedProperty(int index) {
        for (int i = 0; i < xuc007_LeasedProperty.size(); i++){
            if(xuc007_LeasedProperty.get(i).getInsertModCount() == index){
                xuc007_LeasedProperty.remove(i);
            }
        }
    }
    
    public void setXUC007Property(XUC007Property property){
        this.property = property;
    }
    public XUC007Property getXUC007Property(){
        return this.property;
    }

    public void parseXUCProperty(XUC007Property property) {
        this.setXuc007_ParcelID(property.getXuc007_ParcelID());
        this.setXuc007_TaxAccountID(property.getXuc007_TaxMapID());
        this.setXuc007_County(property.getXuc007_County());
        this.setXuc007_State(property.getXuc007_State());
        this.setXuc007_Acreage(property.getXuc007_Acreage());
        this.setXuc007_Township(property.getXuc007_Township());
        this.setXuc007_Range(property.getXuc007_Range());
        this.setXuc007_Section(property.getXuc007_Section());
        this.setXuc007_Meridian(property.getXuc007_Meridian());
        this.setIsPropertyBounders(property.isIsPropertyBounders());
        this.setXuc007_NorthBounder(property.getXuc007_NorthBounder());
        this.setXuc007_EastBounder(property.getXuc007_EastBounder());
        this.setXuc007_SouthBounder(property.getXuc007_SouthBounder());
        this.setXuc007_WestBounder(property.getXuc007_WestBounder());
    }

    public XUC007Property createXUCProperty(
            int insertModCount,
            int xuc007_ParcelID,
            String xuc007_TaxAccountID,
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
        this.setXUC007Property(new XUC007Property(
                insertModCount,
                xuc007_ParcelID,
                xuc007_TaxAccountID,
                xuc007_County,
                xuc007_State,
                xuc007_Acreage,
                xuc007_Township,
                xuc007_Range,
                xuc007_Section,
                xuc007_Meridian,
                xuc007_LegalDescription,
                isPropertyBounders,
                xuc007_NorthBounder,
                xuc007_EastBounder,
                xuc007_SouthBounder,
                xuc007_WestBounder));
        return this.getXUC007Property();
    }

    public String createDescriptionString(XUC007Property property) {
        return String.format("%s %s %s %s : %s",
                property.getXuc007_Township(),
                property.getXuc007_Range(),
                property.getXuc007_Section(),
                property.getXuc007_Meridian(),
                property.getXuc007_LegalDescription()
        );
    }

//        END XUC-007 UC002Model Operations, Variables, Mutators and Accessors
//        START UC-002 / XUC-005 Operations, Variables, Mutators and Accessors

    public void setUC002Values(
            String xuc005_OOPDate,
            double xuc005_BPA,
            int xuc005_PaymentTerms,
            double xuc005_BonusSubtotal,
            String uc002_LeaseDate,
            double uc002_Royalty,
            int uc002_PrimaryTerm,
            int uc002_SecondaryTerm,
            String uc002_Lessor,
            String uc002_Address,
            String uc002_City,
            String uc002_State,
            int uc002_ZipCode,
            String uc002_Lessee
    ) {
        this.setXuc005_OOPDate(xuc005_OOPDate);
        this.setXuc005_BPA(xuc005_BPA);
        this.setXuc005_PaymentTerms(xuc005_PaymentTerms);
        this.setXuc005_BonusSubtotal(xuc005_BonusSubtotal);
        this.setIsAlternativePayee(isAlternativePayee);
        this.setXuc005_AlternatePayee(xuc005_AlternatePayee);
        this.setUc002_LeaseDate(uc002_LeaseDate);
        this.setUc002_Royalty(uc002_Royalty);
        this.setUc002_PrimaryTerm(uc002_PrimaryTerm);
        this.setUc002_SecondaryTerm(uc002_SecondaryTerm);
        this.setUc002_Lessor(uc002_Lessor);
        this.setUc002_Address(uc002_Address);
        this.setUc002_City(uc002_City);
        this.setUc002_State(uc002_State);
        this.setUc002_ZipCode(uc002_ZipCode);
        this.setUc002_Lessee(uc002_Lessee);
    }

    public void sqlStatement() {
        // TO DO: Write SQL INSERT Statement to schema.
        DBConnect.connect();
        /*
        Drafting the SQL statement here.
        IF Anyone is better than me, awesome.  Your help is needed.
        
        
        
        
        
        
        */

    }

    private String xuc005_OOPDate;
    private String uc002_LeaseDate;
    private double xuc005_BPA;
    private double uc002_Royalty;
    private int xuc005_PaymentTerms;
    private int uc002_PrimaryTerm;
    private double xuc005_BonusSubtotal;
    private int uc002_SecondaryTerm;
    private boolean isAlternativePayee;
    private String xuc005_AlternatePayee;
    private String uc002_Lessor;
    private String uc002_Address;
    private String uc002_City;
    private String uc002_State;
    private int uc002_ZipCode;
    private String uc002_Lessee;

    public void setIsAlternativePayee(boolean xuc005_cbxAlternatePayee) {
        this.isAlternativePayee = xuc005_cbxAlternatePayee;
    }

    public String getXuc005_OOPDate() {
        return xuc005_OOPDate;
    }

    public void setXuc005_OOPDate(String xuc005_OOPDate) {
        this.xuc005_OOPDate = xuc005_OOPDate;
    }

    public String getUc002_LeaseDate() {
        return uc002_LeaseDate;
    }

    public void setUc002_LeaseDate(String uc002_LeaseDate) {
        this.uc002_LeaseDate = uc002_LeaseDate;
    }

    public double getXuc005_BPA() {
        return xuc005_BPA;
    }

    public void setXuc005_BPA(double xuc005_BPA) {
        this.xuc005_BPA = xuc005_BPA;
    }

    public double getUc002_Royalty() {
        return uc002_Royalty;
    }

    public void setUc002_Royalty(double uc002_Royalty) {
        this.uc002_Royalty = uc002_Royalty;
    }

    public int getXuc005_PaymentTerms() {
        return xuc005_PaymentTerms;
    }

    public void setXuc005_PaymentTerms(int xuc005_PaymentTerms) {
        this.xuc005_PaymentTerms = xuc005_PaymentTerms;
    }

    public int getUc002_PrimaryTerm() {
        return uc002_PrimaryTerm;
    }

    public void setUc002_PrimaryTerm(int uc002_PrimaryTerm) {
        this.uc002_PrimaryTerm = uc002_PrimaryTerm;
    }

    public double getXuc005_BonusSubtotal() {
        return xuc005_BonusSubtotal;
    }

    public void setXuc005_BonusSubtotal(double xuc005_BonusSubtotal) {
        this.xuc005_BonusSubtotal = xuc005_BonusSubtotal;
    }

    public int getUc002_SecondaryTerm() {
        return uc002_SecondaryTerm;
    }

    public void setUc002_SecondaryTerm(int uc002_SecondaryTerm) {
        this.uc002_SecondaryTerm = uc002_SecondaryTerm;
    }

    public boolean isIsAlternativePayee() {
        return isAlternativePayee;
    }

    public String getUc002_AlternatePayee() {
        return xuc005_AlternatePayee;
    }

    public void setXuc005_AlternatePayee(String uc002_AlternatePayee) {
        this.xuc005_AlternatePayee = uc002_AlternatePayee;
    }

    public String getUc002_Lessor() {
        return uc002_Lessor;
    }

    public void setUc002_Lessor(String uc002_Lessor) {
        this.uc002_Lessor = uc002_Lessor;
    }

    public String getUc002_Address() {
        return uc002_Address;
    }

    public void setUc002_Address(String uc002_Address) {
        this.uc002_Address = uc002_Address;
    }

    public String getUc002_City() {
        return uc002_City;
    }

    public void setUc002_City(String uc002_City) {
        this.uc002_City = uc002_City;
    }

    public String getUc002_State() {
        return uc002_State;
    }

    public void setUc002_State(String uc002_State) {
        this.uc002_State = uc002_State;
    }

    public int getUc002_ZipCode() {
        return uc002_ZipCode;
    }

    public void setUc002_ZipCode(int uc002_ZipCode) {
        this.uc002_ZipCode = uc002_ZipCode;
    }

    public String getUc002_Lessee() {
        return uc002_Lessee;
    }

    public void setUc002_Lessee(String uc002_Lessee) {
        this.uc002_Lessee = uc002_Lessee;
    }

    public void printUC002Values() {
        System.out.println("ORDER PAYMENT INFORMATION");
        System.out.println("Order Payment Date: " + this.xuc005_OOPDate);
        System.out.println("Bonus per Acre (BPA): " + this.xuc005_BPA);
        System.out.println("Payment Terms: " + this.xuc005_PaymentTerms);
        System.out.println("Bonus Payment Subtotal: " + this.xuc005_BonusSubtotal);
        System.out.println("Is Alternate Payee? " + this.isAlternativePayee);
        System.out.println("Alternative Payee: " + this.xuc005_AlternatePayee);
        System.out.println("LEASE INFOMATION");
        System.out.println("Lease Date: " + this.uc002_LeaseDate);
        System.out.println("Royalty: " + this.uc002_Royalty);
        System.out.println("Primary Term: " + this.uc002_PrimaryTerm);
        System.out.println("Secondary Term: " + this.uc002_SecondaryTerm);
        System.out.println("Lessor: " + this.uc002_Lessor);
        System.out.println("Adddress: " + this.uc002_Address);
        System.out.println("City: " + this.uc002_City);
        System.out.println("State: " + this.uc002_State);
        System.out.println("Zip Code: " + this.uc002_ZipCode);
        System.out.println("Lessee Entitiy: " + this.uc002_Lessee);
    }
    // END UC-002 / XUC-005 Operations, Variables, Mutators and Accessors

    public ArrayList<XUC007Property> getXuc007_LeasedProperty() {
        return xuc007_LeasedProperty;
    }

    public void setXuc007_LeasedProperty(ArrayList<XUC007Property> xuc007_LeasedProperty) {
        this.xuc007_LeasedProperty = xuc007_LeasedProperty;
    }

    public int getXuc007_ParcelID() {
        return xuc007_ParcelID;
    }

    public void setXuc007_ParcelID(int xuc007_ParcelID) {
        this.xuc007_ParcelID = xuc007_ParcelID;
    }

    public String getXuc007_TaxAccountID() {
        return xuc007_TaxAccountID;
    }

    public void setXuc007_TaxAccountID(String xuc007_TaxAccountID) {
        this.xuc007_TaxAccountID = xuc007_TaxAccountID;
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

}
