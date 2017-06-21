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
    private final String royaltyRegEx = "^[1]\\.[0]{1,10}|[0]\\.\\d{1,10}|\\.\\d{1,10}$";
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
        CLOSE_BURDEN,
        UPDATE_SURFACEOWNER,
        UPDATE_MINERALOWNER
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Test Script:  Interobject Communication Feedback
        if ((e.getActionCommand().equals(UserActions.OPEN_MINERALOWNER.name()))) {
            this.clearMineralOwnerForm();
            view.getMineralDialog().setVisible(true);
        }

        if (e.getActionCommand().equals(UserActions.OPEN_SURFACEOWNER.name())) {
            this.clearSurfaceOwnerForm();
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
                } catch (NumberFormatException nf1) {
                    System.out.println(nf1.toString());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.INSERT_SURFACEOWNER.name())) {
            int valDocumentID, valBook, valPage;
            if (this.validateSurfaceOwnerForm()) {
                try {
                    if (view.getXuc002_DocumentID().isEmpty()) {
                        valDocumentID = 0;
                    } else {
                        valDocumentID = Integer.parseInt(view.getXuc002_DocumentID());
                    }
                    if (view.getXuc002_Book().isEmpty()) {
                        valBook = 0;
                    } else {
                        valBook = Integer.parseInt(view.getXuc002_Book());
                    }
                    if (view.getXuc002_Page().isEmpty()) {
                        valPage = 0;
                    } else {
                        valPage = Integer.parseInt(view.getXuc002_Page());
                    }
                    XUC002SurfaceOwner surface = model.createXUC002SurfaceOwner(
                            model.getModCount(),
                            100,
                            view.getXuc002_Name1(),
                            view.getXuc002_Name2(),
                            view.getXuc002_Name3(),
                            view.getXuc002_Name4(),
                            view.getXuc002_Address(),
                            view.getXuc002_City(),
                            view.getXuc002_State(),
                            Integer.parseInt(view.getXuc002_ZipCode()),
                            view.getXuc002_ContactNumber(),
                            view.getXuc002_cboDocumentType(),
                            view.getXuc002_EffectiveDate(),
                            view.getXuc002_RecordingDate(),
                            valDocumentID,
                            valBook,
                            valPage);
                    view.addSurfaceOwner(model.createSurfaceOwnerString(surface), model.getModCount());
                    view.getEditSurfaceOwnerButton().setActionCommand(UserActions.EDIT_SURFACEOWNER.name());
                    view.addButtonController(this, view.getEditSurfaceOwnerButton());
                    view.getRemoveSurfaceOwnerButton().setActionCommand(UserActions.REMOVE_SURFACEOWNER.name());
                    view.addButtonController(this, view.getRemoveSurfaceOwnerButton());
                    model.addXUC002SurfaceOwner(surface);
                    model.incrementMModCount();
                    view.getSurfaceDialog().dispose();
                } catch (NumberFormatException nf2) {
                    System.out.println(nf2.getMessage());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.EDIT_SURFACEOWNER.name())) {
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            XUC002SurfaceOwner surfaceOwwner = model.getXUC002SurfaceOwner(index);
            this.clearSurfaceOwnerForm();
            this.importSurfaceOwner(surfaceOwwner, source.getName());
            view.getSurfaceDialog().setVisible(true);
        }

        if (e.getActionCommand().equals(UserActions.UPDATE_SURFACEOWNER.name())) {
            JButton source = (JButton) e.getSource();
            int updateSurfaceOwner = Integer.parseInt(source.getName());
            if (this.validateSurfaceOwnerForm()) {
                try {
                    int getSurfaceOwnerIndex = model.getXUC002SurfaceOwnerIndex(updateSurfaceOwner);
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Name1(view.getXuc002_Name1());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Name2(view.getXuc002_Name2());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Name3(view.getXuc002_Name3());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Name4(view.getXuc002_Name4());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Address(view.getXuc002_Address());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_City(view.getXuc002_City());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_State(view.getXuc002_State());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_ZipCode(Integer.parseInt(view.getXuc002_ZipCode()));
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_ContactNumber(view.getXuc002_ContactNumber());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_DocumentType(view.getXuc002_cboDocumentType());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_EffectiveDate(view.getXuc002_EffectiveDate());
                    model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_RecordingDate(view.getXuc002_RecordingDate());
                    if (!view.getXuc002_DocumentID().isEmpty()) {
                        model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_DocumentID(Integer.parseInt(view.getXuc002_DocumentID()));
                    }
                    if (!view.getXuc002_Book().isEmpty()) {
                        model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Book(Integer.parseInt(view.getXuc002_Book()));
                    }
                    if (!view.getXuc002_Page().isEmpty()) {
                        model.getXUC002SurfaceOwner(getSurfaceOwnerIndex).setUc001_Page(Integer.parseInt(view.getXuc002_Page()));
                    }
                    view.updateSurfaceOwner(model.createSurfaceOwnerString(model.getXUC002SurfaceOwner(updateSurfaceOwner)), updateSurfaceOwner);
                    view.getSurfaceDialog().dispose();
                } catch (NumberFormatException nf3) {
                    System.out.println("Update Surface Owner\n" + nf3.getMessage());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.REMOVE_SURFACEOWNER.name())) {
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            view.removeSurfaceOwner(index);
            model.removeXUC002SurfaceOwner(index);
        }

        if (e.getActionCommand().equals(UserActions.INSERT_MINERALOWNER.name())) {
            int varZipCode, valDocumentID, valBook, valPage;
            if (this.validateMineralOwnerForm()) {
                try {
                    if (view.getXuc003_ZipCode().isEmpty()) {
                        varZipCode = 0;
                    } else {
                        varZipCode = Integer.parseInt(view.getXuc003_ZipCode());
                    }
                    if (view.getXuc003_DocumentID().isEmpty()) {
                        valDocumentID = 0;
                    } else {
                        valDocumentID = Integer.parseInt(view.getXuc003_DocumentID());
                    }
                    if (view.getXuc003_Book().isEmpty()) {
                        valBook = 0;
                    } else {
                        valBook = Integer.parseInt(view.getXuc003_Book());
                    }
                    if (view.getXuc003_Page().isEmpty()) {
                        valPage = 0;
                    } else {
                        valPage = Integer.parseInt(view.getXuc003_Page());
                    }
                    XUC003MineralOwner mineral = model.createXUC003MineralOwner(
                            model.getModCount(),
                            Double.parseDouble(view.getXuc003_Interest()),
                            view.getXuc003_InterestStatus(),
                            view.getXuc003_Name1(),
                            view.getXuc003_Name2(),
                            view.getXuc003_Name3(),
                            view.getXuc003_Name4(),
                            view.getXuc003_Address(),
                            view.getXuc003_City(),
                            view.getXuc003_State(),
                            varZipCode,
                            view.getXuc003_ContactNumber(),
                            view.getXuc003_cboDocumentType(),
                            view.getXuc003_EffectiveDate(),
                            view.getXuc003_RecordingDate(),
                            valDocumentID,
                            valBook,
                            valPage);
                    view.addMineralOwner(model.createMineralOwnerString(mineral), mineral.getXuc003_InterestStatus(), Double.toString(mineral.getXuc003_Interest()), model.getModCount());
                    view.getEditMineralOwnerButton().setActionCommand(UserActions.EDIT_MINERALOWENR.name());
                    view.addButtonController(this, view.getEditMineralOwnerButton());
                    view.getRemoveMineralOwnerButton().setActionCommand(UserActions.REMOVE_MINERALOWNER.name());
                    view.addButtonController(this, view.getRemoveMineralOwnerButton());
                    model.addXUC003MineralOwner(mineral);
                    model.incrementMModCount();
                    model.incrementXuc001_InterestChecksum(Double.parseDouble(view.getXuc003_Interest()));
                    view.setXuc001_InterestChecksum(model.createInterestChecksumString());
                    view.setXuc001_InterestChecksum(model.validateInterestChecksum());
                    view.getMineralDialog().dispose();
                } catch (NumberFormatException nf4) {
                    System.out.println(nf4.toString());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.UPDATE_MINERALOWNER.name())) {
            JButton source = (JButton) e.getSource();
            int updateMineralOwnerIndex = Integer.parseInt(source.getName());
            if (this.validateMineralOwnerForm()) {
                try {
                    int getMineralOwnerIndex = model.getXUC003MineralOwnerIndex(updateMineralOwnerIndex);
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Name1(view.getXuc003_Name1());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Name2(view.getXuc003_Name2());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Name3(view.getXuc003_Name3());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Name4(view.getXuc003_Name4());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Address(view.getXuc003_Address());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_City(view.getXuc003_City());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_State(view.getXuc003_State());
                    if (!view.getXuc003_ZipCode().isEmpty()) {
                        model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_ZipCode(Integer.parseInt(view.getXuc003_ZipCode()));
                    }
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_ContactNumber(view.getXuc003_ContactNumber());

                    model.decrementXuc001_InterestChecksum(model.getXUC003MineralOwner(getMineralOwnerIndex).getXuc003_Interest());

                    model.getXUC003MineralOwner(getMineralOwnerIndex).setXuc003_Interest(Double.parseDouble(view.getXuc003_Interest()));
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setXuc003_InterestStatus(view.getXuc003_InterestStatus());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_DocumentType(view.getXuc003_cboDocumentType());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_EffectiveDate(view.getXuc003_EffectiveDate());
                    model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_RecordingDate(view.getXuc003_RecordingDate());
                    if (!view.getXuc003_DocumentID().isEmpty()) {
                        model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_DocumentID(Integer.parseInt(view.getXuc003_DocumentID()));
                    }
                    if (!view.getXuc003_Book().isEmpty()) {
                        model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Book(Integer.parseInt(view.getXuc003_Book()));
                    }
                    if (!view.getXuc003_Page().isEmpty()) {
                        model.getXUC003MineralOwner(getMineralOwnerIndex).setUc001_Page(Integer.parseInt(view.getXuc003_Page()));
                    }
                    model.incrementXuc001_InterestChecksum(Double.parseDouble(view.getXuc003_Interest()));
                    view.setXuc001_InterestChecksum(model.createInterestChecksumString());
                    view.setXuc001_InterestChecksum(model.validateInterestChecksum());
                    view.updateMineralOwner(
                            model.createMineralOwnerString(model.getXUC003MineralOwner(getMineralOwnerIndex)),
                            model.getXUC003MineralOwner(getMineralOwnerIndex).getXuc003_InterestStatus(),
                            Double.toString(model.getXUC003MineralOwner(getMineralOwnerIndex).getXuc003_Interest()),
                            updateMineralOwnerIndex);
                    System.out.println(model.createMineralOwnerString(model.getXUC003MineralOwner(getMineralOwnerIndex)));
                    System.out.println(model.getXUC003MineralOwner(getMineralOwnerIndex).getXuc003_InterestStatus());
                    System.out.println(Double.toString(model.getXUC003MineralOwner(getMineralOwnerIndex).getXuc003_Interest()));
                    System.out.println(updateMineralOwnerIndex);
                    view.getMineralDialog().dispose();
                } catch (NumberFormatException nf3) {
                    System.out.println("Update Mineral Owner\n" + nf3.getMessage());
                }
            }
        }

        if (e.getActionCommand().equals(UserActions.EDIT_MINERALOWENR.name())) {
            this.clearMineralOwnerForm();
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            XUC003MineralOwner editMineral = model.getXUC003MineralOwner(index);
            this.importMineralOwner(editMineral, source.getName());
            view.getMineralDialog().setVisible(true);
        }

        if (e.getActionCommand().equals(UserActions.REMOVE_MINERALOWNER.name())) {
            JButton source = (JButton) e.getSource();
            int index = Integer.parseInt(source.getName());
            view.removeMineralOwner(index);
            model.decrementXuc001_InterestChecksum(model.getXUC003MineralOwner(index).getXuc003_Interest());
            view.setXuc001_InterestChecksum(model.createInterestChecksumString());
            view.setXuc001_InterestChecksum(model.validateInterestChecksum());
            model.removeXUC003MineralOwner(index);
        }

        if (e.getActionCommand().equals(UserActions.SAVE_ABSTRACT.name())) {
            if (this.validatePropertyForm() && model.validateInterestChecksum()) {
                model.committoDB();
                view.getSurfaceDialog().dispose();
                view.getMineralDialog().dispose();
                view.getAbstractTitleFrame().dispose();
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

        if(model.getMineralOwnerList().size() > 0 && model.getSurfaceOwnerList().size() > 0){
            validFields++;
        }

        if (view.getXuc001_cbxBounders() && validFields == 14) {
            return true;
        }
        return !view.getXuc001_cbxBounders() & validFields == 10;
    }

    public boolean validateSurfaceOwnerForm() {
        int validFields = 0;

        if (view.getXuc002_Name1().isEmpty() || !view.getXuc002_Name1().matches(stringRegEx)) {
            view.setXuc002_lblName1(true);

        } else {
            view.setXuc002_lblName1(false);
            validFields++;
        }

        if (!view.getXuc002_Name2().isEmpty()) {
            if (!view.getXuc002_Name2().matches(stringRegEx)) {
                view.setXuc002_lblName2(true);

            } else {
                view.setXuc002_lblName2(false);
                validFields++;
            }
        }
        if (!view.getXuc002_Name3().isEmpty()) {
            if (!view.getXuc002_Name3().matches(stringRegEx)) {
                view.setXuc002_lblName3(true);

            } else {
                view.setXuc002_lblName3(false);
                validFields++;
            }
        }
        if (!view.getXuc002_Name4().isEmpty()) {
            if (!view.getXuc002_Name4().matches(stringRegEx)) {

                view.setXuc002_lblName4(true);

            } else {
                view.setXuc002_lblName4(false);
                validFields++;
            }
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
            }
        }

        if (view.getXuc002_EffectiveDate().isEmpty() || !view.getXuc002_EffectiveDate().matches(dateRegEx)) {
            view.setXuc002_lblEffectiveDate(true);
        } else {
            view.setXuc002_lblEffectiveDate(false);
            validFields++;
        }

        if (view.getXuc002_RecordingDate().isEmpty() || !view.getXuc002_RecordingDate().matches(dateRegEx)) {
            view.setXuc002_lblRecordingDate(true);
        } else {
            view.setXuc002_lblRecordingDate(false);
            validFields++;
        }

        if (!view.getXuc002_DocumentID().isEmpty()) {
            if (!view.getXuc002_DocumentID().matches(parcelIDRegEx)) {
                view.setXuc002_lblDocumentID(true);
            } else {
                view.setXuc002_lblDocumentID(false);
            }
        }

        if (!view.getXuc002_Book().isEmpty()) {
            if (!view.getXuc002_Book().matches(parcelIDRegEx)) {
                view.setXuc002_lblBook(true);
            } else {
                view.setXuc002_lblBook(false);
            }
        }

        if (!view.getXuc002_Page().isEmpty()) {
            if (!view.getXuc002_Page().matches(parcelIDRegEx)) {
                view.setXuc002_lblPage(true);
            } else {
                view.setXuc002_lblPage(false);
            }
        }

        if (!view.getXuc002_DocumentID().isEmpty()) {
            if (view.getXuc002_Book().isEmpty() && view.getXuc002_Page().isEmpty()) {
                validFields++;
            }
        }
        if (!view.getXuc002_Book().isEmpty() && !view.getXuc002_Page().isEmpty()) {
            if (view.getXuc002_DocumentID().isEmpty()) {
                validFields++;
            }
        }

        if (validFields == 8) {
            return true;
        } else if (!view.getXuc002_Name2().isEmpty()
                && view.getXuc002_Name3().isEmpty()
                && view.getXuc002_Name4().isEmpty()
                && validFields == 9) {
            return true;
        } else if (!view.getXuc002_Name2().isEmpty()
                && !view.getXuc002_Name3().isEmpty()
                && view.getXuc002_Name4().isEmpty()
                && validFields == 10) {
            return true;
        } else if (!view.getXuc002_Name2().isEmpty()
                && !view.getXuc002_Name3().isEmpty()
                && !view.getXuc002_Name4().isEmpty()
                && validFields == 11) {
            return true;
        }

        return false;
    } // END validateSurfaceOwnerForm()

    public boolean validateMineralOwnerForm() {
        int validFields = 0;

        if (view.getXuc003_Interest().isEmpty() || !view.getXuc003_Interest().matches(royaltyRegEx)) {
            view.setXuc003_lblInterest(true);
        } else {
            view.setXuc003_lblInterest(false);
            validFields++;
        }

        if (view.getXuc003_Name1().isEmpty() || !view.getXuc003_Name1().matches(stringRegEx)) {
            view.setXuc003_lblName1(true);

        } else {
            view.setXuc003_lblName1(false);
            validFields++;
        }

        if (!view.getXuc003_Name2().isEmpty()) {
            if (!view.getXuc003_Name2().matches(stringRegEx)) {
                view.setXuc003_lblName2(true);

            } else {
                view.setXuc003_lblName2(false);
                validFields++;
            }
        }
        if (!view.getXuc003_Name3().isEmpty()) {
            System.out.println("Test: " + validFields);
            if (!view.getXuc003_Name3().matches(stringRegEx)) {
                view.setXuc003_lblName3(true);

            } else {
                view.setXuc003_lblName3(false);
                validFields++;
            }
        }
        if (!view.getXuc003_Name4().isEmpty()) {
            System.out.println("Test: " + validFields);
            if (!view.getXuc003_Name4().matches(stringRegEx)) {
                view.setXuc003_lblName4(true);

            } else {
                view.setXuc003_lblName4(false);
                validFields++;
            }
        }

        if (view.getXuc003_cbxLastKnownAddress()) {
            if (!view.getXuc003_Address().isEmpty()) {
                if (!view.getXuc003_Address().matches(streetAddressRegEx)) {
                    view.setXuc003_lblAddress(true);

                } else {
                    view.setXuc003_lblAddress(false);
                }
            }
            if (!view.getXuc003_City().isEmpty()) {
                if (!view.getXuc003_City().matches(stringRegEx)) {
                    view.setXuc003_lblCity(true);

                } else {
                    view.setXuc003_lblCity(false);
                }
            }
            if (!view.getXuc003_State().isEmpty()) {
                if (!view.getXuc003_State().matches(stateAbbreviationRegEx)) {
                    view.setXuc003_lblState(true);

                } else {
                    view.setXuc003_lblState(false);
                }
            }
            if (!view.getXuc003_ZipCode().isEmpty()) {
                if (!view.getXuc003_ZipCode().matches(zipCodeRegEx)) {

                    view.setXuc002_lblZipCode(true);

                } else {
                    view.setXuc003_lblZipCode(false);
                }
            }
        }
        if (!view.getXuc003_ContactNumber().isEmpty()) {
            if (!view.getXuc003_ContactNumber().matches(stringRegEx)) {
                view.setXuc003_lblState(true);
            } else {
                view.setXuc003_lblState(false);
            }
        }

        if (view.getXuc003_EffectiveDate().isEmpty() || !view.getXuc003_EffectiveDate().matches(dateRegEx)) {
            view.setXuc003_lblEffectiveDate(true);
        } else {
            view.setXuc003_lblEffectiveDate(false);
            validFields++;
        }

        if (view.getXuc003_RecordingDate().isEmpty() || !view.getXuc003_RecordingDate().matches(dateRegEx)) {
            view.setXuc003_lblRecordingDate(true);
        } else {
            view.setXuc003_lblRecordingDate(false);
            validFields++;
        }

        if (!view.getXuc003_DocumentID().isEmpty()) {
            if (!view.getXuc003_DocumentID().matches(parcelIDRegEx)) {
                view.setXuc003_lblDocumentID(true);
            } else {
                view.setXuc003_lblDocumentID(false);
            }
        }

        if (!view.getXuc003_Book().isEmpty()) {
            if (!view.getXuc003_Book().matches(parcelIDRegEx)) {
                view.setXuc003_lblBook(true);
            } else {
                view.setXuc003_lblBook(false);
            }
        }

        if (!view.getXuc003_Page().isEmpty()) {
            if (!view.getXuc003_Page().matches(parcelIDRegEx)) {
                view.setXuc003_lblPage(true);
            } else {
                view.setXuc003_lblPage(false);
            }
        }

        if (!view.getXuc003_DocumentID().isEmpty()) {
            if (view.getXuc003_Book().isEmpty() && view.getXuc003_Page().isEmpty()) {
                validFields++;
            }
        }
        if (!view.getXuc003_Book().isEmpty() && !view.getXuc003_Page().isEmpty()) {
            if (view.getXuc003_DocumentID().isEmpty()) {
                validFields++;
            }
        }

        if (validFields == 5) {
            return true;
        } else if (!view.getXuc003_Name2().isEmpty()
                && view.getXuc003_Name3().isEmpty()
                && view.getXuc003_Name4().isEmpty()
                && validFields == 6) {
            return true;
        } else if (!view.getXuc003_Name2().isEmpty()
                && !view.getXuc003_Name3().isEmpty()
                && view.getXuc003_Name4().isEmpty()
                && validFields == 7) {
            return true;
        } else if (!view.getXuc003_Name2().isEmpty()
                && !view.getXuc003_Name3().isEmpty()
                && !view.getXuc003_Name4().isEmpty()
                && validFields == 8) {
            return true;
        }

        return false;
    }

    private void importSurfaceOwner(XUC002SurfaceOwner owner, String index) {
        view.setXuc002_Name1(owner.getUc001_Name1());
        if (owner.getUc001_Name2().isEmpty()) {
            view.setXuc002_Name2(null);
        } else {
            view.setXuc002_Name2(owner.getUc001_Name2());
        }
        if (owner.getUc001_Name3().isEmpty()) {
            view.setXuc002_Name3(null);
        } else {
            view.setXuc002_Name3(owner.getUc001_Name3());
        }
        if (owner.getUc001_Name4().isEmpty()) {
            view.setXuc002_Name4(null);
        } else {
            view.setXuc002_Name4(owner.getUc001_Name4());
        }
        view.setXuc002_Address(owner.getUc001_Address());
        view.setXuc002_City(owner.getUc001_City());
        view.setXuc002_State(owner.getUc001_State());
        view.setXuc002_ZipCode(Integer.toString(owner.getUc001_ZipCode()));
        if (owner.getUc001_ContactNumber().isEmpty()) {
            view.setXuc002_ContactNumber(null);
        } else {
            view.setXuc002_ContactNumber(owner.getUc001_ContactNumber());
        }

        view.setXuc002_EffectiveDate(owner.getUc001_EffectiveDate());
        view.setXuc002_RecordingDate(owner.getUc001_RecordingDate());
        if (owner.getUc001_DocumentID() != 0) {
            view.setXuc002_DocumentID(Integer.toString(owner.getUc001_DocumentID()));
        }
        if (owner.getUc001_Book() != 0) {
            view.setXuc002_Book(Integer.toString(owner.getUc001_Book()));
        }
        if (owner.getUc001_Page() != 0) {
            view.setXuc002_Page(Integer.toString(owner.getUc001_Page()));
        }
        view.importSurfaceOwnerButtonProperties(true, index);
    }

    private void clearSurfaceOwnerForm() {
        view.setXuc002_Name1(null);
        view.setXuc002_Name2(null);
        view.setXuc002_Name3(null);
        view.setXuc002_Name4(null);
        view.setXuc002_Address(null);
        view.setXuc002_City(null);
        view.setXuc002_State(null);
        view.setXuc002_ZipCode(null);
        view.setXuc002_ContactNumber(null);
    }

    private void importMineralOwner(XUC003MineralOwner owner, String index) {
        view.setXuc003_InterestStatus(owner.getXuc003_InterestStatus());
        view.setXuc003_Interest(Double.toString(owner.getXuc003_Interest()));
        view.setXuc003_Name1(owner.getUc001_Name1());
        if (owner.getUc001_Name2().isEmpty()) {
            view.setXuc003_Name2(null);
        } else {
            view.setXuc003_Name2(owner.getUc001_Name2());
        }
        if (owner.getUc001_Name3().isEmpty()) {
            view.setXuc003_Name3(null);
        } else {
            view.setXuc003_Name3(owner.getUc001_Name3());
        }
        if (owner.getUc001_Name4().isEmpty()) {
            view.setXuc003_Name4(null);
        } else {
            view.setXuc003_Name4(owner.getUc001_Name4());
        }
        if (owner.getUc001_Address().isEmpty()) {
            view.setXuc003_Address(null);
        } else {
            view.setXuc003_Address(owner.getUc001_Address());
        }
        if (owner.getUc001_City().isEmpty()) {
            view.setXuc003_City(null);
        } else {
            view.setXuc003_City(owner.getUc001_City());
        }
        if (owner.getUc001_State().isEmpty()) {
            view.setXuc003_State(null);
        } else {
            view.setXuc003_State(owner.getUc001_State());
        }
        if (owner.getUc001_ZipCode() != 0) {
            view.setXuc003_ZipCode(Integer.toString(owner.getUc001_ZipCode()));
        } else {
            view.setXuc003_ZipCode(null);
        }
        if (owner.getUc001_ContactNumber().isEmpty()) {
            view.setXuc003_ContactNumber(null);
        } else {
            view.setXuc003_ContactNumber(owner.getUc001_ContactNumber());
        }

        view.setXuc003_EffectiveDate(owner.getUc001_EffectiveDate());
        view.setXuc003_RecordingDate(owner.getUc001_RecordingDate());
        if (owner.getUc001_DocumentID() != 0) {
            view.setXuc003_DocumentID(Integer.toString(owner.getUc001_DocumentID()));
        }
        if (owner.getUc001_Book() != 0) {
            view.setXuc003_Book(Integer.toString(owner.getUc001_Book()));
        }
        if (owner.getUc001_Page() != 0) {
            view.setXuc003_Page(Integer.toString(owner.getUc001_Page()));
        }
        view.importMineralOwnerButtonProperties(true, index);
    }

    private void clearMineralOwnerForm() {
        view.setXuc003_InterestStatus("Open");
        view.setXuc003_lblInterest(false);
        view.setXuc003_Interest(null);
        view.setXuc003_lblName1(false);
        view.setXuc003_Name1(null);
        view.setXuc003_lblName2(false);
        view.setXuc003_Name2(null);
        view.setXuc003_lblName3(false);
        view.setXuc003_Name3(null);
        view.setXuc003_lblName4(false);
        view.setXuc003_Name4(null);
        view.setXuc003_lblAddress(false);
        view.setXuc003_Address(null);
        view.setXuc003_City(null);
        view.setXuc003_lblCity(false);
        view.setXuc003_State(null);
        view.setXuc003_lblState(false);
        view.setXuc003_ZipCode(null);
        view.setXuc003_lblZipCode(false);
        view.setXuc003_ContactNumber(null);
        view.setXuc003_lblContactNumber(false);
        view.setXuc003_EffectiveDate(null);
        view.setXuc003_lblEffectiveDate(false);
        view.setXuc003_RecordingDate(null);
        view.setXuc003_lblRecordingDate(false);
        view.setXuc003_DocumentID(null);
        view.setXuc003_lblDocumentID(false);
        view.setXuc003_Book(null);
        view.setXuc003_lblBook(false);
        view.setXuc003_Page(null);
        view.setXuc003_lblPage(false);
    }

}
