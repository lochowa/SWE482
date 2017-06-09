package swe482_Main;

import java.awt.event.ActionEvent;

/**
 *
 * @author Michael Barth UC-002 UC002Controller Class Object
 * @param <E>
 */
public class UC002Controller<E> implements java.awt.event.ActionListener {

    UC002Model model;
    UC002View view;
    int gridY = 0;
    private final String doubleReg = "^(([1-9]{1}(\\d+)?)(\\.\\d+)?)|([0]\\.(\\d+)?([1-9]{1})(\\d+)?)$";
    private final String royaltyReg = "^[1]?\\.[0]{1,10}$||^[1]$||^\\.[0-9]{1,10}$";
    private final String integerReg = "^[0-9]{1,3}$";
    private final String parcelReg = "^[0-9]{1,20}";
    private final String zipCodeReg = "^[0-9]{1,6}";
    private final String dateReg = "^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private final String streetReg = "^(\\d{3,})\\s?(\\w{0,5})\\s([a-zA-Z]{2,30})\\s([a-zA-Z]{2,15})\\.?\\s?(\\w{0,5})$";
    private final String descriptionReg = "^(a-z|A-Z|0-9)*[^#$%^&*()']*$";
    private final String stringReg = "^[a-zA-Z0-9\\040]+$";
    private final String stateReg = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";
//    private final String townshipReg = ""; // ## + W|West E|East S|South N|North
//    private final String rangeReg = "";   // ## + W|West E|East S|South N|North
    private final String sectionReg = "^[1-6]$|^[1][0-9]$|^[2][0-9]$|^[3][0-6]$"; // 1 - 36 only

    void addModel(UC002Model m) {
        this.model = m;
    }

    void addView(UC002View v) {
        this.view = v;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(UserActions.CLOSE_LEASE.name())) {
            System.out.println("Action Triggered: Close Lease");
            view.getDxuc007().dispose();
            view.getfUC002().dispose();
        }
        if (e.getActionCommand().equals(UserActions.OPEN_ADDPROPERTY.name())) {
            System.out.println("Action Triggered: Add Property");
            this.clearAddPropertyForm();
            view.displayAddProperty(true);

        }
        if (e.getActionCommand().equals(UserActions.SAVE_LEASE.name())) {
            System.out.println("Action Triggered: Save Lease");
            if (this.validateLeaseForm()) { // TO DO: Need correct boolean return.
                try {
                    if (view.getXuc005_cbxAlternativePayee()) {
                        if (!view.getXuc005_AlternatePayee().isEmpty() && !view.getXuc005_AlternatePayee().matches(stringReg)) {
                            model.setIsAlternativePayee(view.getXuc005_cbxAlternativePayee());
                            model.setXuc005_AlternatePayee(view.getXuc005_AlternatePayee());
                        }
                    } else {
                        model.setIsAlternativePayee(false);
                        model.setXuc005_AlternatePayee(null);
                    }
                    model.setUC002Values(
                            view.getXuc005_OOPDate().trim(),
                            Double.parseDouble(view.getXuc005_BPA().trim()),
                            Integer.parseInt(view.getXuc005_PaymentTerms().trim()),
                            Double.parseDouble(view.getXuc005_BonusSubtotal()),
                            view.getUc002_LeaseDate().trim(),
                            Double.parseDouble(view.getUc002_Royalty().trim()),
                            Integer.parseInt(view.getUc002_PrimaryTerm().trim()),
                            Integer.parseInt(view.getUc002_SecondaryTerm().trim()),
                            view.getUc002_Lessor().trim(),
                            view.getUc002_Address().trim(),
                            view.getUc002_City().trim(),
                            view.getUc002_State().trim(),
                            Integer.parseInt(view.getUc002_ZipCode().trim()),
                            view.getUc002_Lessee().trim());

                    System.out.println("Valid Data\n");
                    model.printUC002Values();
                    model.sqlStatement();

                } catch (NumberFormatException f1) {
                    return;
                }
            }
        }
        if (e.getActionCommand().equals(UserActions.SEARCH_PERSON.name())) {
            System.out.println("Action Triggered: Search/Add Lessor");
        }

        if (e.getActionCommand().equals(UserActions.SEARCH_PROPERTY.name())) {
            System.out.println("Action Triggered: Search/Add Property");

            view.addXuc007Pane_LeasedProperty("Test", gridY);
            gridY++;
        }

        if (e.getActionCommand().equals(UserActions.INSERT_PROPERTY.name())) {
            System.out.println("Action Triggered: Insert Property");
            if(this.validatePropertyForm()){  // TO DO: Need correct boolean return.
            try {
                XUC007Property property = model.createXUCProperty(
                        Integer.parseInt(view.getXuc007_ParcelID()),
                        view.getXuc007_TaxMapID(),
                        view.getXuc007_County(),
                        view.getXuc007_State(),
                        Double.parseDouble(view.getXuc007_Acreage()),
                        view.getXuc007_Township(),
                        view.getXuc007_Range(),
                        Integer.parseInt(view.getXuc007_Section()),
                        view.getXuc007_Meridian(),
                        view.getXuc007_LegalDescription(),
                        view.getXuc007_cbxBounders(),
                        view.getXuc007_NorthBounder(),
                        view.getXuc007_EastBounder(),
                        view.getXuc007_SouthBounder(),
                        view.getXuc007_WestBounder()
                );
            view.addXuc007Pane_LeasedProperty(model.createDescriptionString(property),model.getModCount());
            model.addXuc007_LeasedProperty(property);
            model.incrementModCount();
            view.getDxuc007().dispose();
            } catch (NumberFormatException f2) {

            }
            }
        }

        if (e.getActionCommand().equals(UserActions.CLOSE_ADDPROPERTY.name())) {
            System.out.println("Action Triggered: Close Add Property Window");
            view.getDxuc007().dispose();
        }
    }

    private enum UserActions {
        SEARCH_PERSON,
        OPEN_ADDPROPERTY,
        CLOSE_LEASE,
        SAVE_LEASE,
        SEARCH_PROPERTY,
        INSERT_PROPERTY,
        CLOSE_ADDPROPERTY
    }

    private boolean validatePropertyForm() {
        int validFields = 0;

        if (view.getXuc007_ParcelID().isEmpty() || !view.getXuc007_ParcelID().matches(parcelReg)) {
            view.setXuc007_lblParcelID(true);

        } else {
            view.setXuc007_lblParcelID(false); validFields++;
        }
        if (view.getXuc007_TaxMapID().isEmpty() || !view.getXuc007_TaxMapID().matches(stringReg)) {
            view.setXuc007_lblTaxMapID(true);
        } else {
            view.setXuc007_lblTaxMapID(false); validFields++;
        }
        if (view.getXuc007_County().isEmpty() || !view.getXuc007_County().matches(stringReg)) {
            view.setXuc007_lblCounty(true);
        } else {
            view.setXuc007_lblCounty(false); validFields++;
        }
        if (view.getXuc007_State().isEmpty() || !view.getXuc007_State().toUpperCase().matches(stateReg)) {
            view.setXuc007_lblState(true);
        } else {
            view.setXuc007_lblState(false); validFields++;
        }
        if (view.getXuc007_Acreage().isEmpty() || !view.getXuc007_Acreage().matches(doubleReg)) {
            view.setXuc007_lblAcreage(true);
        } else {
            view.setXuc007_lblAcreage(false); validFields++;
        }
        if (view.getXuc007_Township().isEmpty() || !view.getXuc007_Township().matches(stringReg)) {
            view.setXuc007_lblTownship(true);
        } else {
            view.setXuc007_lblTownship(false); validFields++;
        }
        if (view.getXuc007_Range().isEmpty() || !view.getXuc007_Range().matches(stringReg)) {
            view.setXuc007_lblRange(true);
        } else { 
            view.setXuc007_lblRange(false); validFields++;
        }
        if (view.getXuc007_Section().isEmpty() || !view.getXuc007_Section().matches(sectionReg)) {
            view.setXuc007_lblSection(true);
        } else {
            view.setXuc007_lblSection(false); validFields++;
        }
        if (view.getXuc007_Meridian().isEmpty() || !view.getXuc007_Meridian().matches(stringReg)) {
            view.setXuc007_lblMeridian(true);
        } else {
            view.setXuc007_lblMeridian(false); validFields++;
        }
        if (view.getXuc007_LegalDescription().isEmpty() || !view.getXuc007_LegalDescription().matches(descriptionReg)) {
            view.setXuc007_lblLegalDescription(true);
        } else {
            view.setXuc007_lblLeasedLegalDescriptions(false); validFields++;
        }
        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_NorthBounder().isEmpty() && view.getXuc007_NorthBounder().matches(stringReg)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_NorthBounder().isEmpty() || !view.getXuc007_NorthBounder().matches(stringReg)) {
                view.setXuc007_lblNorthBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblNorthBounder(false); validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }
        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_EastBounder().isEmpty() && view.getXuc007_EastBounder().matches(stringReg)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_EastBounder().isEmpty() || !view.getXuc007_EastBounder().matches(stringReg)) {
                view.setXuc007_lblEastBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblEastBounder(false); validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }

        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_SouthBounder().isEmpty() && view.getXuc007_SouthBounder().matches(stringReg)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_SouthBounder().isEmpty() || !view.getXuc007_SouthBounder().matches(stringReg)) {
                view.setXuc007_lblSouthBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblSouthBounder(false); validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }

        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_WestBounder().isEmpty() && view.getXuc007_WestBounder().matches(stringReg)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_WestBounder().isEmpty() || !view.getXuc007_WestBounder().matches(stringReg)) {
                view.setXuc007_lblWestBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblWestBounder(false); validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }

        if(view.getXuc007_cbxBounders() && validFields == 14){
            return true;
        }
        if(!view.getXuc007_cbxBounders() & validFields == 10){
            return true;
        }
        return false;
    }

    private boolean validateLeaseForm() {
        int validFields = 0;

        if (view.getXuc005_OOPDate().isEmpty() || !view.getXuc005_OOPDate().matches(dateReg)) {
            view.setXuc005_lblOOPDate(true);

        } else {
            view.setXuc005_lblOOPDate(false); validFields++;
        }
        if (view.getXuc005_BPA().isEmpty() || !view.getXuc005_BPA().matches(doubleReg)) {
            view.setXuc005_lblBPA(true);

        } else {
            view.setXuc005_lblBPA(false); validFields++;
        }
        if (view.getXuc005_PaymentTerms().isEmpty() || !view.getXuc005_PaymentTerms().matches(integerReg)) {
            view.setXuc005_lblPaymentTerms(true);

        } else {
            view.setXuc005_lblPaymentTerms(false); validFields++;
        }
        if (view.getXuc005_BonusSubtotal().isEmpty() || !view.getXuc005_BonusSubtotal().matches(doubleReg)) {
            view.setXuc005_lblBonusSubtotal(true);

        } else {
            view.setXuc005_lblBonusSubtotal(false); validFields++;
        }
        if (view.getXuc005_AlternatePayee().isEmpty() || !view.getXuc005_AlternatePayee().matches(stringReg)) {
            view.setXuc005_lblAlternativePayee(true);

        } else {
            view.setXuc005_lblAlternativePayee(false); validFields++;
        }

        if (!view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty() && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(true);

            }
        }
        if (view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty()
                    && view.getXuc005_AlternatePayee().matches(stringReg)) {
                view.setXuc005_cbxAlternatePayee(false); validFields++;
            }
        }
        if (view.getUc002_Lessor().isEmpty() || !view.getUc002_Lessor().matches(stringReg)) {
            view.setUc002_lblLessor(true);
        } else {
            view.setUc002_lblLessor(false); validFields++;
        }
        if (view.getUc002_Address().isEmpty() || !view.getUc002_Address().matches(streetReg)) {
            view.setUc002_lblAddress(true);

        } else {
            view.setUc002_lblAddress(false); validFields++;
        }
        if (view.getUc002_City().isEmpty() || !view.getUc002_City().matches(stringReg)) {
            view.setUc002_lblCity(true);

        } else {
            view.setUc002_lblCity(false); validFields++;
        }
        if (view.getUc002_State().isEmpty() || !view.getUc002_State().toUpperCase().matches(stateReg)) {
            view.setUc002_lblState(true);

        } else {
            view.setUc002_lblState(false); validFields++;
        }
        if (view.getUc002_ZipCode().isEmpty() || !view.getUc002_ZipCode().matches(zipCodeReg)) {
            view.setUc002_lblZipCode(true);

        } else {
            view.setUc002_lblZipCode(false); validFields++;
        }
        if (view.getUc002_Lessee().isEmpty() || !view.getUc002_Lessee().matches(stringReg)) {
            view.setUc002_lblLessee(true);

        } else {
            view.setUc002_lblLessee(false); validFields++;
        }
        if (view.getUc002_LeaseDate().isEmpty() || !view.getUc002_LeaseDate().matches(dateReg)) {
            view.setUc002_lblLeaseDate(true);

        } else {
            view.setUc002_lblLeaseDate(false); validFields++;
        }
        if (view.getUc002_PrimaryTerm().isEmpty() || !view.getUc002_PrimaryTerm().matches(integerReg)) {
            view.setUc002_lblPrimaryTerm(true);

        } else {
            view.setUc002_lblPrimaryTerm(false); validFields++;
        }
        if (view.getUc002_SecondaryTerm().isEmpty() || !view.getUc002_SecondaryTerm().matches(integerReg)) {
            view.setUc002_lblSecondaryTerm(true);

        } else {
            view.setUc002_lblSecondaryTerm(false); validFields++;
        }
        if (view.getUc002_Royalty().isEmpty() || !view.getUc002_Royalty().matches(royaltyReg)) {
            view.setUc002_lblRoyalty(true);

        } else {
            view.setUc002_lblRoyalty(false); validFields++;
        }
        
        if(view.getXuc005_cbxAlternativePayee() && validFields == 16){
            return true;
        }
        if(!view.getXuc005_cbxAlternativePayee() && validFields ==15){
            return true;
        }

        return false;
    }

    void clearAddPropertyForm(){       
        view.setXuc007_ParcelID(null);
        view.setXuc007_Township(null);
        view.setXuc007_TaxMapID(null);
        view.setXuc007_Range(null);
        view.setXuc007_County(null);
        view.setXuc007_Section(null);
        view.setXuc007_State(null);
        view.setXuc007_Meridian(null);
        view.setXuc007_Acreage(null);
        view.uncheckXuc007_cbxBounders();
        view.setXuc007_NorthBounder(null);
        view.setXuc007_EastBounder(null);
        view.setXuc007_SouthBounder(null);
        view.setXuc007_WestBounder(null);
    }
}
