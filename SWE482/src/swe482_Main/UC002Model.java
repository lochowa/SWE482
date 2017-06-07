package swe482_Main;

/**
 *
 * @author Michael Barth 
 UC-002 UC002Model Class Object
 */
public class UC002Model extends java.util.Observable {
//        START XUC-007 Operations, Variable, Mutators and Accessors

//      ArrayList<Property> xuc007_LeasedProperty = new ArrayList<>();
    
    
//        END XUC-007 UC002Model Operations, Variables, Mutators and Accessors
//        START UC-002 / XUC-005 Operations, Variables, Mutators and Accessors

    public void printPayee(){
        System.out.println(this.xuc005_AlternatePayee);
        System.out.println(this.isAlternativePayee);
    }
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

    public void setIsAlternativePayee(boolean xuc005_cbxAlternatePayee){
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
    
    public void printUC002Values(){
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

    
}
