package swe482_Main;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Michael Barth UC-002 UC002Controller Class Object
 * @param <E>
 */
public class UC002Controller<E> implements java.awt.event.ActionListener {

    UC002Model model;
    UC002View view;
    int gridY = 0;
    private final String doubleRegEx = "^(([1-9]{1}(\\d+)?)(\\.\\d+)?)|([0]\\.(\\d+)?([1-9]{1})(\\d+)?)$";
    private final String royaltyRegEx = "^[1]?\\.[0]{1,10}$||^[1]$||^\\.[0-9]{1,10}$";
    private final String integerRegEx = "^[0-9]{1,3}$";
    private final String parcelIDRegEx = "^[0-9]{1,20}";
    private final String zipCodeRegEx = "^[0-9]{1,6}";
    private final String dateRegEx = "^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private final String streetAddressRegEx = "^(\\d{3,})\\s?(\\w{0,5})\\s([a-zA-Z]{2,30})\\s([a-zA-Z]{2,15})\\.?\\s?(\\w{0,5})$";
    private final String descriptionRegEx = "^(a-z|A-Z|0-9)*[^#$%^&*()']*$";
    private final String stringRegEx = "^[a-zA-Z0-9\\040]+$";
    private final String stateAbbreviationRegEx = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";
//    private final String townshipReg = ""; // ## + W|West E|East S|South N|North
//    private final String rangeReg = "";   // ## + W|West E|East S|South N|North
    private final String sectionRegEx = "^[1-6]$|^[1][0-9]$|^[2][0-9]$|^[3][0-6]$"; // 1 - 36 only

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
            if (this.validateLeaseForm() && model.getModCount()!= 0) {
                try {
                    if (!view.getXuc005_cbxAlternativePayee()) {
                        model.setIsAlternativePayee(false);
                        model.setXuc005_AlternatePayee(null);
                    } else {
                        if (view.getXuc005_AlternatePayee().isEmpty() || view.getXuc005_AlternatePayee().matches(stringRegEx)) {
                        } else {
                            model.setIsAlternativePayee(view.getXuc005_cbxAlternativePayee());
                            model.setXuc005_AlternatePayee(view.getXuc005_AlternatePayee());
                        }
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
                    model.committoDB();
                    view.dispose();
                } catch (NumberFormatException f1) {
                    System.out.println(f1.getMessage());
                }
            }
        }
        if (e.getActionCommand().equals(UserActions.SEARCH_PERSON.name())) {
            System.out.println("Action Triggered: Search/Add Lessor");
            // TO DO:   FUTURE ENHANCEMENT
        }

        if (e.getActionCommand().equals(UserActions.SEARCH_PROPERTY.name())) {
            System.out.println("Action Triggered: Search/Add Property");
            // TO DO:   FUTURE ENHANCEMENT
        }

        if (e.getActionCommand().equals(UserActions.INSERT_PROPERTY.name())) {
            System.out.println("Action Triggered: Insert Property");
            if (this.validatePropertyForm()) {
                try {
                    XUC007Property property = model.createXUCProperty(
                            model.getModCount(),
                            Integer.parseInt(view.getXuc007_ParcelID()),
                            view.getXuc007_TaxAccountID(),
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
                    view.addXuc007Pane_LeasedProperty(model.createDescriptionString(property), model.getModCount());
                    view.addButtonController(this, view.getXuc007_EditPropertyButton());
                    view.addButtonController(this, view.getXuc007_RemovePropertyButton());
                    model.addXuc007_LeasedProperty(property);
                    model.incrementModCount();
                    view.getDxuc007().dispose();

                } catch (NumberFormatException f2) {
                    System.out.println(f2.getMessage());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.CLOSE_ADDPROPERTY.name())) {
            System.out.println("Action Triggered: Close Add Property Window");
            view.getDxuc007().dispose();
        }
        if (e.getActionCommand().equals(UserActions.EDIT_PROPERTY.name())) {
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            XUC007Property property = model.getXuc007_LeasedProperty(index);
            this.clearAddPropertyForm();
            this.importPropertyData(property, source.getName());
        }
        if (e.getActionCommand().equals(UserActions.UPDATE_PROPERTY.name())) {
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            if (this.validatePropertyForm()) {
                try {
                    model.getXuc007_LeasedProperty(index).setXuc007_ParcelID(Integer.parseInt(view.getXuc007_ParcelID()));
                    model.getXuc007_LeasedProperty(index).setXuc007_TaxMapID(view.getXuc007_TaxAccountID());
                    model.getXuc007_LeasedProperty(index).setXuc007_County(view.getXuc007_County());
                    model.getXuc007_LeasedProperty(index).setXuc007_State(view.getXuc007_State());
                    model.getXuc007_LeasedProperty(index).setXuc007_Acreage(Double.parseDouble(view.getXuc007_Acreage()));
                    model.getXuc007_LeasedProperty(index).setXuc007_Township(view.getXuc007_Township());
                    model.getXuc007_LeasedProperty(index).setXuc007_Range(view.getXuc007_Range());
                    model.getXuc007_LeasedProperty(index).setXuc007_Section(Integer.parseInt(view.getXuc007_Section()));
                    model.getXuc007_LeasedProperty(index).setXuc007_LegalDescription(view.getXuc007_LegalDescription());
                    if (view.getXuc007_cbxBounders()) {
                        // True
                        model.getXuc007_LeasedProperty(index).setIsPropertyBounders(view.getXuc007_cbxBounders());
                        model.getXuc007_LeasedProperty(index).setXuc007_NorthBounder(view.getXuc007_NorthBounder());
                        model.getXuc007_LeasedProperty(index).setXuc007_EastBounder(view.getXuc007_EastBounder());
                        model.getXuc007_LeasedProperty(index).setXuc007_SouthBounder(view.getXuc007_SouthBounder());
                        model.getXuc007_LeasedProperty(index).setXuc007_WestBounder(view.getXuc007_WestBounder());
                    }
                    if (!view.getXuc007_cbxBounders()) {
                        model.getXuc007_LeasedProperty(index).setIsPropertyBounders(view.getXuc007_cbxBounders());
                        model.getXuc007_LeasedProperty(index).setXuc007_NorthBounder(null);
                        model.getXuc007_LeasedProperty(index).setXuc007_EastBounder(null);
                        model.getXuc007_LeasedProperty(index).setXuc007_SouthBounder(null);
                        model.getXuc007_LeasedProperty(index).setXuc007_WestBounder(null);
                    }
                    view.updateXuc007Pane_LeasedProperty(model.createDescriptionString(model.getXuc007_LeasedProperty(index)), index);
                view.getDxuc007().dispose();
                } catch (NumberFormatException f3) {
                    System.out.println(f3.getMessage());
                }
            }
        }
        if (e.getActionCommand().equals(UserActions.REMOVE_PROPERTY.name())){
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            System.out.println("Removing JPanel: " + index);
            view.removeXuc007Pane_LeasedProperty(index);
            model.removeXuc007_LeasedProperty(index);
        }
    }

    private enum UserActions {
        SEARCH_PERSON,
        OPEN_ADDPROPERTY,
        CLOSE_LEASE,
        SAVE_LEASE,
        SEARCH_PROPERTY,
        INSERT_PROPERTY,
        CLOSE_ADDPROPERTY,
        DISPLAY_BOUNDERS,
        EDIT_PROPERTY,
        UPDATE_PROPERTY,
        REMOVE_PROPERTY
    }

    private boolean validatePropertyForm() {
        int validFields = 0;

        if (view.getXuc007_ParcelID().isEmpty() || !view.getXuc007_ParcelID().matches(parcelIDRegEx)) {
            view.setXuc007_lblParcelID(true);

        } else {
            view.setXuc007_lblParcelID(false);
            validFields++;
        }
        if (view.getXuc007_TaxAccountID().isEmpty() || !view.getXuc007_TaxAccountID().matches(stringRegEx)) {
            view.setXuc007_lblTaxAccountID(true);
        } else {
            view.setXuc007_lblTaxAccountID(false);
            validFields++;
        }
        if (view.getXuc007_County().isEmpty() || !view.getXuc007_County().matches(stringRegEx)) {
            view.setXuc007_lblCounty(true);
        } else {
            view.setXuc007_lblCounty(false);
            validFields++;
        }
        if (view.getXuc007_State().isEmpty() || !view.getXuc007_State().toUpperCase().matches(stateAbbreviationRegEx)) {
            view.setXuc007_lblState(true);
        } else {
            view.setXuc007_lblState(false);
            validFields++;
        }
        if (view.getXuc007_Acreage().isEmpty() || !view.getXuc007_Acreage().matches(doubleRegEx)) {
            view.setXuc007_lblAcreage(true);
        } else {
            view.setXuc007_lblAcreage(false);
            validFields++;
        }
        if (view.getXuc007_Township().isEmpty() || !view.getXuc007_Township().matches(stringRegEx)) {
            view.setXuc007_lblTownship(true);
        } else {
            view.setXuc007_lblTownship(false);
            validFields++;
        }
        if (view.getXuc007_Range().isEmpty() || !view.getXuc007_Range().matches(stringRegEx)) {
            view.setXuc007_lblRange(true);
        } else {
            view.setXuc007_lblRange(false);
            validFields++;
        }
        if (view.getXuc007_Section().isEmpty() || !view.getXuc007_Section().matches(sectionRegEx)) {
            view.setXuc007_lblSection(true);
        } else {
            view.setXuc007_lblSection(false);
            validFields++;
        }
        if (view.getXuc007_Meridian().isEmpty() || !view.getXuc007_Meridian().matches(stringRegEx)) {
            view.setXuc007_lblMeridian(true);
        } else {
            view.setXuc007_lblMeridian(false);
            validFields++;
        }
        if (view.getXuc007_LegalDescription().isEmpty() || !view.getXuc007_LegalDescription().matches(descriptionRegEx)) {
            view.setXuc007_lblLegalDescription(true);
        } else {
            view.setXuc007_lblLeasedLegalDescriptions(false);
            validFields++;
        }
        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_NorthBounder().isEmpty() && view.getXuc007_NorthBounder().matches(stringRegEx)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_NorthBounder().isEmpty() || !view.getXuc007_NorthBounder().matches(stringRegEx)) {
                view.setXuc007_lblNorthBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblNorthBounder(false);
                validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }
        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_EastBounder().isEmpty() && view.getXuc007_EastBounder().matches(stringRegEx)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_EastBounder().isEmpty() || !view.getXuc007_EastBounder().matches(stringRegEx)) {
                view.setXuc007_lblEastBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblEastBounder(false);
                validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }

        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_SouthBounder().isEmpty() && view.getXuc007_SouthBounder().matches(stringRegEx)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_SouthBounder().isEmpty() || !view.getXuc007_SouthBounder().matches(stringRegEx)) {
                view.setXuc007_lblSouthBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblSouthBounder(false);
                validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }

        if (!view.getXuc007_cbxBounders()) {
            if (!view.getXuc007_WestBounder().isEmpty() && view.getXuc007_WestBounder().matches(stringRegEx)) {
                view.setXuc007_cbxBounders(true);
            }
        }
        if (view.getXuc007_cbxBounders()) {
            if (view.getXuc007_WestBounder().isEmpty() || !view.getXuc007_WestBounder().matches(stringRegEx)) {
                view.setXuc007_lblWestBounder(true);
                view.setXuc007_cbxBounders(false);
            } else {
                view.setXuc007_lblWestBounder(false);
                validFields++;
                view.setXuc007_cbxBounders(false);
            }
        }
        if (view.getXuc007_cbxBounders() && validFields == 14) { return true; }
        return !view.getXuc007_cbxBounders() & validFields == 10;
    }

    private boolean validateLeaseForm() {
        int validFields = 0;

        if (view.getXuc005_OOPDate().isEmpty() || !view.getXuc005_OOPDate().matches(dateRegEx)) {
            view.setXuc005_lblOOPDate(true);

        } else {
            view.setXuc005_lblOOPDate(false);
            validFields++;
        }
        if (view.getXuc005_BPA().isEmpty() || !view.getXuc005_BPA().matches(doubleRegEx)) {
            view.setXuc005_lblBPA(true);

        } else {
            view.setXuc005_lblBPA(false);
            validFields++;
        }
        if (view.getXuc005_PaymentTerms().isEmpty() || !view.getXuc005_PaymentTerms().matches(integerRegEx)) {
            view.setXuc005_lblPaymentTerms(true);

        } else {
            view.setXuc005_lblPaymentTerms(false);
            validFields++;
        }
        if (view.getXuc005_BonusSubtotal().isEmpty() || !view.getXuc005_BonusSubtotal().matches(doubleRegEx)) {
            view.setXuc005_lblBonusSubtotal(true);

        } else {
            view.setXuc005_lblBonusSubtotal(false);
            validFields++;
        }
        
        if (!view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty() && view.getXuc005_AlternatePayee().matches(stringRegEx)) {
                view.setXuc005_cbxAlternatePayee(true);

            }
        }
        if (view.getXuc005_cbxAlternativePayee()) {
            if (!view.getXuc005_AlternatePayee().isEmpty() && view.getXuc005_AlternatePayee().matches(stringRegEx)) {
                view.setXuc005_cbxAlternatePayee(false);

            }
            if (view.getXuc005_AlternatePayee().isEmpty() || !view.getXuc005_AlternatePayee().matches(stringRegEx)) {
                view.setXuc005_lblAlternativePayee(true);

            } else {
                view.setXuc005_lblAlternativePayee(false);
                validFields++;
            }
        }
        if (view.getUc002_Lessor().isEmpty() || !view.getUc002_Lessor().matches(stringRegEx)) {
            view.setUc002_lblLessor(true);
        } else {
            view.setUc002_lblLessor(false);
            validFields++;
        }
        if (view.getUc002_Address().isEmpty() || !view.getUc002_Address().matches(streetAddressRegEx)) {
            view.setUc002_lblAddress(true);

        } else {
            view.setUc002_lblAddress(false);
            validFields++;
        }
        if (view.getUc002_City().isEmpty() || !view.getUc002_City().matches(stringRegEx)) {
            view.setUc002_lblCity(true);

        } else {
            view.setUc002_lblCity(false);
            validFields++;
        }
        if (view.getUc002_State().isEmpty() || !view.getUc002_State().toUpperCase().matches(stateAbbreviationRegEx)) {
            view.setUc002_lblState(true);

        } else {
            view.setUc002_lblState(false);
            validFields++;
        }
        if (view.getUc002_ZipCode().isEmpty() || !view.getUc002_ZipCode().matches(zipCodeRegEx)) {
            view.setUc002_lblZipCode(true);

        } else {
            view.setUc002_lblZipCode(false);
            validFields++;
        }
        if (view.getUc002_Lessee().isEmpty() || !view.getUc002_Lessee().matches(stringRegEx)) {
            view.setUc002_lblLessee(true);

        } else {
            view.setUc002_lblLessee(false);
            validFields++;
        }
        if (view.getUc002_LeaseDate().isEmpty() || !view.getUc002_LeaseDate().matches(dateRegEx)) {
            view.setUc002_lblLeaseDate(true);

        } else {
            view.setUc002_lblLeaseDate(false);
            validFields++;
        }
        if (view.getUc002_PrimaryTerm().isEmpty() || !view.getUc002_PrimaryTerm().matches(integerRegEx)) {
            view.setUc002_lblPrimaryTerm(true);

        } else {
            view.setUc002_lblPrimaryTerm(false);
            validFields++;
        }
        if (view.getUc002_SecondaryTerm().isEmpty() || !view.getUc002_SecondaryTerm().matches(integerRegEx)) {
            view.setUc002_lblSecondaryTerm(true);

        } else {
            view.setUc002_lblSecondaryTerm(false);
            validFields++;
        }
        if (view.getUc002_Royalty().isEmpty() || !view.getUc002_Royalty().matches(royaltyRegEx)) {
            view.setUc002_lblRoyalty(true);

        } else {
            view.setUc002_lblRoyalty(false);
            validFields++;
        }

        if (!view.getXuc005_cbxAlternativePayee() && validFields == 14) { return true; }
        return view.getXuc005_cbxAlternativePayee() && validFields == 15;
    }

    void clearAddPropertyForm() {
        view.setXuc007_ParcelID(null);
        view.setXuc007_Township(null);
        view.setXuc007_TaxAccountID(null);
        view.setXuc007_Range(null);
        view.setXuc007_County(null);
        view.setXuc007_Section(null);
        view.setXuc007_State(null);
        view.setXuc007_Meridian(null);
        view.setXuc007_Acreage(null);
        view.setXuc007_LegalDescription(null);
        view.uncheckXuc007_cbxBounders(false);
        view.setXuc007_NorthBounder(null);
        view.setXuc007_EastBounder(null);
        view.setXuc007_SouthBounder(null);
        view.setXuc007_WestBounder(null);
        view.importButtonProperties(false, null);
    }

    private void importPropertyData(XUC007Property property, String index) {
        view.setXuc007_ParcelID(Integer.toString(property.getXuc007_ParcelID()));
        view.setXuc007_Township(property.getXuc007_Township());
        view.setXuc007_TaxAccountID(property.getXuc007_TaxMapID());
        view.setXuc007_Range(property.getXuc007_Range());
        view.setXuc007_County(property.getXuc007_County());
        view.setXuc007_Section(Integer.toString(property.getXuc007_Section()));
        view.setXuc007_State(property.getXuc007_State());
        view.setXuc007_Meridian(property.getXuc007_Meridian());
        view.setXuc007_Acreage(Double.toString(property.getXuc007_Acreage()));
        view.setXuc007_LegalDescription(property.getXuc007_LegalDescription());
        view.uncheckXuc007_cbxBounders(property.isIsPropertyBounders());
        if (property.isIsPropertyBounders()) {
            view.setXuc007_NorthBounder(property.getXuc007_NorthBounder());
            view.setXuc007_EastBounder(property.getXuc007_EastBounder());
            view.setXuc007_SouthBounder(property.getXuc007_SouthBounder());
            view.setXuc007_WestBounder(property.getXuc007_WestBounder());
        }
        view.importButtonProperties(true, index);
        view.displayAddProperty(true);
    }
}
