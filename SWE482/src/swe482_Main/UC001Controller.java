package swe482_Main;

/**
 *
 * @author by Michael Barth
 * @modifications by Andrew Lochow (See save button section)
 */
import java.awt.event.ActionEvent;

public class UC001Controller implements java.awt.event.ActionListener {

    UC001Model model;
    UC001View view;

    private final String doubleRegEx = "^(([1-9]{1}(\\d+)?)(\\.\\d+)?)|([0]\\.(\\d+)?([1-9]{1})(\\d+)?)$";
    private final String royaltyRegEx = "^[1]?\\.[0]{1,10}$||^[1]$||^\\.[0-9]{1,10}$";
    private final String integerRegEx = "^[0-9]{1,3}$";
    private final String parcelIDRegEx = "^[0-9]{1,20}";
    private final String zipCodeRegEx = "^[0-9]{1,6}";
    private final String dateRegEx = "^(0?[1-9]|1[0-2])/(0?[1-9]|1[0-9]|2[0-9]|3[01])/\\d{4}$";
    private final String streetAddressRegEx = "^(\\d{3,})\\s?(\\w{0,5})\\s([a-zA-Z]{2,30})\\s([a-zA-Z]{2,15})\\.?\\s?(\\w{0,5})$";
    private final String descriptionRegEx = "^(a-z|A-Z|0-9)*[^#$%^&*()']*";
    private final String stringRegEx = "^[a-zA-Z0-9\\040]+$";
    private final String stateAbbreviationRegEx = "^(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))$";
    private final String townshipRegEx = "^([1-9][0-9]{1,2})[N|S]$"; // ## + W|West E|East S|South N|North
    private final String rangeRegEx = "^([1-9][0-9]{1,2})[E|W]$";   // ## + W|West E|East S|South N|North
    private final String sectionRegEx = "^[1-6]$|^[1][0-9]$|^[2][0-9]$|^[3][0-6]$"; // 1 - 36 only

    public enum UserActions {
        OPEN_SURFACEOWNER,
        OPEN_MINERALOWNER,
        SEARCH_PROPERTY,
        SEARCH_PERSON,
        CLOSE_ABSTRACT,
        CLOSE_SURFACEOWNER,
        CLOSE_MINERALOWNER,
        INSERT_SURFACEOWNER,
        INSERT_MINERALOWNER,
        EDIT_SURFACEOWNER,
        EDIT_MINERALOWENR,
        SAVE_ABSTRACT,
        REMOVE_SURFACEOWNER,
        REMOVE_MINERALOWNER,
        OPEN_DOCUMENT,
        INSERT_DOCUMENT,
        CLOSE_DOCUMENT,
        OPEN_BURDEN,
        CLOSE_BURDEN
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        System.out.println("Propety Controller: The " + e.getActionCommand()
                + " button is clicked at " + new java.util.Date(e.getWhen())
                + " with e.paramString: " + e.paramString());

        System.out.println("Controller: Acted on Property Model");

        if ((e.getActionCommand().equals(UserActions.OPEN_MINERALOWNER.name()))) {
            view.getMineralDialog().setVisible(true);
        }

        if (e.getActionCommand().equals(UserActions.OPEN_SURFACEOWNER.name())) {
            view.getSurfaceDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_ABSTRACT.name())) {
            view.getSurfaceDialog().dispose();
            view.getMineralDialog().dispose();
            view.getAbstractTitleFrame().dispose();
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_SURFACEOWNER.name())) {
            view.getSurfaceDialog().dispose();
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_MINERALOWNER.name())) {
            view.getMineralDialog().dispose();
        }
        //Save actions modified by Andrew Lochow for managing Database input
        if (e.getActionCommand().equals(UserActions.SAVE_ABSTRACT.name())) {
        if (validatePropertyForm()){
            model.setUC001PropertyValues(
                    Integer.parseInt(view.getXuc001_ParcelID()),
                    view.getXuc001_TaxAccountID(),
                    view.getXuc001_County(),
                    view.getXuc001_State(),
                    Double.parseDouble(view.getXuc001_Acreage()),
                    view.getXuc001_Township(),
                    view.getXuc001_Range(),
                    Integer.parseInt(view.getXuc001_Section()),
                    view.getXuc001_Meridian(),
                    view.getXuc001_LegalDescription(),
                    view.getXuc001_NorthBounder(),
                    view.getXuc001_EastBounder(),
                    view.getXuc001_SouthBounder(),
                    view.getXuc001_WestBounder());
            model.committoDB();
        }
        }
        if (e.getActionCommand().equals(UserActions.OPEN_BURDEN.name())) {
            view.getBurdenDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_BURDEN.name())) {
            view.getBurdenDialog().dispose();
        }
        if (e.getActionCommand().equals(UserActions.OPEN_DOCUMENT.name())){
            view.getDocumentDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_DOCUMENT.name()))
            view.getDocumentDialog().dispose();
    }

    void addModel(UC001Model m) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Property Model");
        this.model = m;
    }

    void addView(UC001View v) {
        // Test Script: Operation Feedback
        System.out.println("Controller: Adding Property View");
        this.view = v;
    }

    private boolean validatePropertyForm() {
        int validFields = 0;

        if (view.getXuc001_ParcelID().isEmpty() || !view.getXuc001_ParcelID().matches(parcelIDRegEx)) {
            view.setXuc001_lblParcelID(true);

        } else {
            view.setXuc001_lblParcelID(false);
            validFields++;
        }
        if (view.getXuc001_TaxAccountID().isEmpty() || !view.getXuc001_TaxAccountID().matches(stringRegEx)) {
            view.setXuc001_lblTaxAccountID(true);
        } else {
            view.setXuc001_lblTaxAccountID(false);
            validFields++;
        }
        if (view.getXuc001_County().isEmpty() || !view.getXuc001_County().matches(stringRegEx)) {
            view.setXuc001_lblCounty(true);
        } else {
            view.setXuc001_lblCounty(false);
            validFields++;
        }
        if (view.getXuc001_State().isEmpty() || !view.getXuc001_State().toUpperCase().matches(stateAbbreviationRegEx)) {
            view.setXuc001_lblState(true);
        } else {
            view.setXuc001_lblState(false);
            validFields++;
        }
        if (view.getXuc001_Acreage().isEmpty() || !view.getXuc001_Acreage().matches(doubleRegEx)) {
            view.setXuc001_lblAcreage(true);
        } else {
            view.setXuc001_lblAcreage(false);
            validFields++;
        }
        if (view.getXuc001_Township().isEmpty() || !view.getXuc001_Township().matches(townshipRegEx)) {
            view.setXuc001_lblTownship(true);
        } else {
            view.setXuc001_lblTownship(false);
            validFields++;
        }
        if (view.getXuc001_Range().isEmpty() || !view.getXuc001_Range().matches(rangeRegEx)) {
            view.setXuc001_lblRange(true);
        } else {
            view.setXuc001_lblRange(false);
            validFields++;
        }
        if (view.getXuc001_Section().isEmpty() || !view.getXuc001_Section().matches(sectionRegEx)) {
            view.setXuc001_lblSection(true);
        } else {
            view.setXuc001_lblSection(false);
            validFields++;
        }
        if (view.getXuc001_Meridian().isEmpty() || !view.getXuc001_Meridian().matches(stringRegEx)) {
            view.setXuc001_lblMeridian(true);
        } else {
            view.setXuc001_lblMeridian(false);
            validFields++;
        }
        if (view.getXuc001_LegalDescription().isEmpty() || !view.getXuc001_LegalDescription().matches(descriptionRegEx)) {
            view.setXuc001_lblLegalDescription(true);
        } else {
            view.setXuc001_lblLegalDescription(false);
            validFields++;
        }
        if (!view.getXuc001_cbxBounders()) {
            if (!view.getXuc001_NorthBounder().isEmpty() && view.getXuc001_NorthBounder().matches(stringRegEx)) {
                view.setXuc001_cbxBounders(true);
            }
        }
        if (view.getXuc001_cbxBounders()) {
            if (view.getXuc001_NorthBounder().isEmpty() || !view.getXuc001_NorthBounder().matches(stringRegEx)) {
                view.setXuc001_lblNorthBounder(true);
                view.setXuc001_cbxBounders(false);
            } else {
                view.setXuc001_lblNorthBounder(false);
                validFields++;
                view.setXuc001_cbxBounders(false);
            }
        }
        if (!view.getXuc001_cbxBounders()) {
            if (!view.getXuc001_EastBounder().isEmpty() && view.getXuc001_EastBounder().matches(stringRegEx)) {
                view.setXuc001_cbxBounders(true);
            }
        }
        if (view.getXuc001_cbxBounders()) {
            if (view.getXuc001_EastBounder().isEmpty() || !view.getXuc001_EastBounder().matches(stringRegEx)) {
                view.setXuc001_lblEastBounder(true);
                view.setXuc001_cbxBounders(false);
            } else {
                view.setXuc001_lblEastBounder(false);
                validFields++;
                view.setXuc001_cbxBounders(false);
            }
        }

        if (!view.getXuc001_cbxBounders()) {
            if (!view.getXuc001_SouthBounder().isEmpty() && view.getXuc001_SouthBounder().matches(stringRegEx)) {
                view.setXuc001_cbxBounders(true);
            }
        }
        if (view.getXuc001_cbxBounders()) {
            if (view.getXuc001_SouthBounder().isEmpty() || !view.getXuc001_SouthBounder().matches(stringRegEx)) {
                view.setXuc001_lblSouthBounder(true);
                view.setXuc001_cbxBounders(false);
            } else {
                view.setXuc001_lblSouthBounder(false);
                validFields++;
                view.setXuc001_cbxBounders(false);
            }
        }

        if (!view.getXuc001_cbxBounders()) {
            if (!view.getXuc001_WestBounder().isEmpty() && view.getXuc001_WestBounder().matches(stringRegEx)) {
                view.setXuc001_cbxBounders(true);
            }
        }
        if (view.getXuc001_cbxBounders()) {
            if (view.getXuc001_WestBounder().isEmpty() || !view.getXuc001_WestBounder().matches(stringRegEx)) {
                view.setXuc001_lblWestBounder(true);
                view.setXuc001_cbxBounders(false);
            } else {
                view.setXuc001_lblWestBounder(false);
                validFields++;
                view.setXuc001_cbxBounders(false);
            }
        }
        if (view.getXuc001_cbxBounders() && validFields == 14) {
            return true;
        }
        return !view.getXuc001_cbxBounders() & validFields == 10;
    }

}
