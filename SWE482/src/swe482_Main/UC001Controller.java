package swe482_Main;

/**
 *
 * @author by Michael Barth
 * @modifications by Andrew Lochow (See save button section)
 *
 * @author Jeff Event Action method writing.
 */
import java.awt.event.ActionEvent;
import javax.swing.JButton;

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
            if (validatePropertyForm()) {
                try {
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
                } catch (NumberFormatException f2) {
                    System.out.println(f2.toString());
                }
            }
        }
        if (e.getActionCommand().equals(UserActions.OPEN_BURDEN.name())) {
            view.getBurdenDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_BURDEN.name())) {
            view.getBurdenDialog().dispose();
        }
        if (e.getActionCommand().equals(UserActions.OPEN_DOCUMENT.name())) {
//          SETS DOCUMENT CALLER ATTRIBUTE VALUE
            JButton source = (JButton) e.getSource();
            view.setDocumentCaller(source.getName());
            view.getDocumentDialog().setVisible(true);
        }
        if (e.getActionCommand().equals(UserActions.CLOSE_DOCUMENT.name())) {
            view.getDocumentDialog().dispose();
        }
        if (e.getActionCommand().equals(UserActions.INSERT_DOCUMENT.name())) {
//          REUSES ADD DOCUMENT DIALOG CODE TO DISTINGUISH WHERE TO INSERT THE DOCUMENT
            if (view.getDocumentCaller().equals("Mineral")) {

            }
            if (view.getDocumentCaller().equals("Surface")) {

            }
        }
        if (e.getActionCommand().equals(UserActions.INSERT_SURFACEOWNER.name())) {
            // TO DO: Add boolean check here.
            try {
                model.addXUC002SurfaceOwner(model.createXUC002SurfaceOwner(
                        view.getXuc002_Name1(),
                        view.getXuc002_Name2(),
                        view.getXuc002_Name3(),
                        view.getXuc002_Name4(),
                        view.getXuc002_Address(),
                        view.getXuc002_City(),
                        view.getXuc002_State(),
                        Integer.parseInt(view.getXuc002_ZipCode()),
                        100 / model.getMModCount(),
                        model.getSModCount()));
            } catch (NumberFormatException f1) {

            }

        }

        if (e.getActionCommand().equals(UserActions.INSERT_MINERALOWNER.name())) {

            try {
                model.addXUC003MineralOwner(model.createXUC003MineralOwner(
                        view.getXuc003_Name1(),
                        view.getXuc003_Name2(),
                        view.getXuc003_Name3(),
                        view.getXuc003_Name4(),
                        view.getXuc003_Address(),
                        view.getXuc003_City(),
                        view.getXuc003_State(),
                        Integer.parseInt(view.getXuc003_ZipCode()),
                        model.getMModCount(),
                        Integer.parseInt(view.getXuc003_Interest()),
                        view.getXuc003_InterestStatus()));
            } catch (NumberFormatException f1) {
            }

        }
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

        if (model.getMModCount() != 0) {
            validFields++;
        }
        if (model.getSModCount() != 0) {
            validFields++;
        }

        if (view.getXuc001_cbxBounders() && validFields == 16) {
            return true;
        }
        return !view.getXuc001_cbxBounders() & validFields == 12;
    }

    public void validateSurfaceOwnerForm() {
        int validFields = 0;

        if (view.getXuc002_Name1().isEmpty() || !view.getXuc002_Name1().matches(stringRegEx)) {
            view.setXuc002_lblName1(true);

        } else {
            view.setXuc002_lblName1(false);
            validFields++;
        }

        if (view.getXuc002_Name2().isEmpty() || !view.getXuc002_Name2().matches(stringRegEx)) {
            view.setXuc002_lblName2(true);

        } else {
            view.setXuc002_lblName2(false);
            validFields++;
        }
        if (view.getXuc002_Name3().isEmpty() || !view.getXuc002_Name3().matches(stringRegEx)) {
            view.setXuc003_lblName2(true);

        } else {
            view.setXuc003_lblName2(false);
            validFields++;
        }

        if (view.getXuc002_Name4().isEmpty() || !view.getXuc002_Name4().matches(stringRegEx)) {
            view.setXuc002_lblName4(true);

        } else {
            view.setXuc002_lblName4(false);
            validFields++;
        }
        if (view.getXuc002_Address().isEmpty() || !view.getXuc002_Address().matches(streetAddressRegEx)) {
            view.setXuc002_lblAddress(true);

        } else {
            view.setXuc002_lblAddress(false);
            validFields++;
        }

        if (view.getXuc002_City().isEmpty() || !view.getXuc002_City().matches(stringRegEx)) {
            view.setXuc002_lblCity(true);

        } else {
            view.setXuc002_lblCity(false);
            validFields++;
        }
        if (view.getXuc002_State().isEmpty() || !view.getXuc002_State().matches(stateAbbreviationRegEx)) {
            view.setXuc002_lblState(true);

        } else {
            view.setXuc002_lblState(false);
            validFields++;
        }
        if (view.getXuc002_ZipCode().isEmpty() || !view.getXuc002_ZipCode().matches(zipCodeRegEx)) {
            view.setXuc002_lblZipCode(true);

        } else {
            view.setXuc002_lblZipCode(false);
            validFields++;
        }
        if (!view.getXuc002_ContactNumber().isEmpty()) {
            if (!view.getXuc002_ContactNumber().matches(stringRegEx)) {
                view.setXuc002_lblState(true);
            } else {
                view.setXuc002_lblState(false);
                validFields++;
            }
        }

    } // END validateSurfaceOwnerForm()

    public void validateMineralOwnerForm() {
       int validFields = 0;

        if (view.getXuc003_Name1().isEmpty() || !view.getXuc003_Name1().matches(stringRegEx)) {
            view.setXuc003_lblName1(true);

        } else {
            view.setXuc003_lblName1(false);
            validFields++;
        }

        if (view.getXuc003_Name2().isEmpty() || !view.getXuc003_Name2().matches(stringRegEx)) {
            view.setXuc003_lblName2(true);

        } else {
            view.setXuc003_lblName2(false);
            validFields++;
        }
        if (view.getXuc003_Name3().isEmpty() || !view.getXuc003_Name3().matches(stringRegEx)) {
            view.setXuc003_lblName2(true);

        } else {
            view.setXuc003_lblName2(false);
            validFields++;
        }

        if (view.getXuc003_Name4().isEmpty() || !view.getXuc003_Name4().matches(stringRegEx)) {
            view.setXuc003_lblName4(true);

        } else {
            view.setXuc003_lblName4(false);
            validFields++;
        }
        if (view.getXuc003_Address().isEmpty() || !view.getXuc003_Address().matches(streetAddressRegEx)) {
            view.setXuc003_lblAddress(true);

        } else {
            view.setXuc003_lblAddress(false);
            validFields++;
        }

        if (view.getXuc003_City().isEmpty() || !view.getXuc003_City().matches(stringRegEx)) {
            view.setXuc003_lblCity(true);

        } else {
            view.setXuc003_lblCity(false);
            validFields++;
        }
        if (view.getXuc003_State().isEmpty() || !view.getXuc003_State().matches(stateAbbreviationRegEx)) {
            view.setXuc003_lblState(true);

        } else {
            view.setXuc003_lblState(false);
            validFields++;
        }
        if (view.getXuc003_ZipCode().isEmpty() || !view.getXuc003_ZipCode().matches(zipCodeRegEx)) {
            view.setXuc002_lblZipCode(true);

        } else {
            view.setXuc003_lblZipCode(false);
            validFields++;
        }
        if (!view.getXuc003_ContactNumber().isEmpty()) {
            if (!view.getXuc003_ContactNumber().matches(stringRegEx)) {
                view.setXuc003_lblState(true);
            } else {
                view.setXuc003_lblState(false);
                validFields++;
            }
        }
    }

    public void validateDocumentForm() {

    }
}
