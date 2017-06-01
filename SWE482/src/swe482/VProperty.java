package swe482;

/*
 * Created by JFormDesigner on Wed May 31 00:37:48 MDT 2017
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import info.clearthought.layout.*;
import java.util.Observable;

/**
 * @author Michael Barth
 */


public class VProperty extends JFrame implements java.util.Observer {
    
    public static class CloseListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e){
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }
    // CloseListener Class Object
    
    VProperty() {
        initComponents();
    }
    
    @Override
    public void update(Observable obs, Object obj) {
        // Test Script:  Who called the operation and what did they send?
        System.out.println("Property View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
 

    }
    public enum Actions {
        ADDMINERALOWNER,
        ADDSURFACEOWNER,
        DISPLAYBOUNDERS,
        SAVEPROPERTY,
        CBOTOWNSHIPCHANGE,
        CBORANGECHANGE,
        CBOSECTIONCHANGE,
        CBOMERIDIANCHANGE,
        CLOSEWINDOW

    }
    void addController(ActionListener controller) {
        System.out.println("View: Adding Property Controller");
        _SaveButton.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _AddMineralOwner.addActionListener(controller);
        _AddSurfaceOwner.addActionListener(controller);
        _cboTownship.addActionListener(controller);
        _cboRange.addActionListener(controller);
        _cbxBounders.addActionListener(controller);
    }
    
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        headerPanel = new JPanel();
        lblRecordID = new JLabel();
        _RecordID = new JTextField();
        headerLegalDescription = new JLabel();
        lblParcelID = new JLabel();
        _ParcelID = new JTextField();
        lblTaxMapID = new JLabel();
        _TaxMapID = new JTextField();
        lblCounty = new JLabel();
        _County = new JTextField();
        lblState = new JLabel();
        _State = new JTextField();
        lblAcreage = new JLabel();
        _Acreage = new JTextField();
        lblTownship = new JLabel();
        lblRange = new JLabel();
        lblSection = new JLabel();
        lblPrincipalMeridian = new JLabel();
        _cboTownship = new JComboBox();
        _cboRange = new JComboBox();
        _cboSection = new JComboBox();
        _cboPMeridian = new JComboBox();
        lblLegalDescription = new JLabel();
        scrollPane = new JScrollPane();
        _LegalDescription = new JTextArea();
        _cbxBounders = new JCheckBox();
        boundersPanel = new JPanel();
//        boundersPanel.setVisible(false);
        lblNorthBounder = new JLabel();
        lblEastBounder = new JLabel();
        lblSouthBounder = new JLabel();
        lblWestBounder = new JLabel();
        _NorthBounder = new JTextField();
        _EastBounder = new JTextField();
        _SouthBounder = new JTextField();
        _WestBounder = new JTextField();
        headerSurfaceOwner = new JLabel();
        _AddSurfaceOwner = new JButton();
        surfaceOwnerPanel = new JPanel();
        lblSOName = new JLabel();
        _SOName = new JTextField();
        lblSOAddress = new JLabel();
        _SOAddress = new JTextField();
        lblSOCity = new JLabel();
        _SOCity = new JTextField();
        lblSOState = new JLabel();
        _SOState = new JTextField();
        lblSOZipCode = new JLabel();
        _SOZipCode = new JTextField();
        headerMineralOwnership = new JLabel();
        _AddMineralOwner = new JButton();
        insertMOPanel = new JPanel();
        buttonBar = new JPanel();
        lblInterestSubtotal = new JLabel();
        _SaveButton = new JButton();
        _CancelButton = new JButton();

        //======== this ========
        setType(Window.Type.POPUP);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setAutoscrolls(true);
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //======== headerPanel ========
                {
                    headerPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout) headerPanel.getLayout()).columnWidths = new int[]{155, 155, 155, 150, 0};
                    ((GridBagLayout) headerPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 120, 0};
                    ((GridBagLayout) headerPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) headerPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- lblRecordID ----
                    lblRecordID.setText("Record Identification");
                    headerPanel.add(lblRecordID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _RecordID ----
                    _RecordID.setEnabled(false);
                    _RecordID.setAutoscrolls(false);
                    headerPanel.add(_RecordID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- headerLegalDescription ----
                    headerLegalDescription.setText("LEGAL DESCRIPTION");
                    headerLegalDescription.setFont(headerLegalDescription.getFont().deriveFont(Font.BOLD, headerLegalDescription.getFont().getSize() + 1f));
                    headerPanel.add(headerLegalDescription, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- lblParcelID ----
                    lblParcelID.setText("Parcel Number");
                    lblParcelID.setFont(lblParcelID.getFont().deriveFont(lblParcelID.getFont().getSize() + 1f));
                    headerPanel.add(lblParcelID, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _ParcelID ----
                    _ParcelID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _ParcelID.setAutoscrolls(false);
                    headerPanel.add(_ParcelID, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblTaxMapID ----
                    lblTaxMapID.setText("Tax Map Identification");
                    lblTaxMapID.setFont(lblTaxMapID.getFont().deriveFont(lblTaxMapID.getFont().getSize() + 1f));
                    headerPanel.add(lblTaxMapID, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _TaxMapID ----
                    _TaxMapID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _TaxMapID.setAutoscrolls(false);
                    headerPanel.add(_TaxMapID, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblCounty ----
                    lblCounty.setText("County");
                    lblCounty.setFont(lblCounty.getFont().deriveFont(lblCounty.getFont().getSize() + 1f));
                    headerPanel.add(lblCounty, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _County ----
                    _County.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _County.setAutoscrolls(false);
                    headerPanel.add(_County, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblState ----
                    lblState.setText("State");
                    lblState.setFont(lblState.getFont().deriveFont(lblState.getFont().getSize() + 1f));
                    headerPanel.add(lblState, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _State ----
                    _State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _State.setAutoscrolls(false);
                    headerPanel.add(_State, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblAcreage ----
                    lblAcreage.setText("Acreage:");
                    lblAcreage.setFont(lblAcreage.getFont().deriveFont(lblAcreage.getFont().getSize() + 1f));
                    headerPanel.add(lblAcreage, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _Acreage ----
                    _Acreage.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _Acreage.setAutoscrolls(false);
                    headerPanel.add(_Acreage, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblTownship ----
                    lblTownship.setText("Township");
                    lblTownship.setFont(lblTownship.getFont().deriveFont(lblTownship.getFont().getSize() + 1f));
                    headerPanel.add(lblTownship, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblRange ----
                    lblRange.setText("Range:");
                    lblRange.setFont(lblRange.getFont().deriveFont(lblRange.getFont().getSize() + 1f));
                    headerPanel.add(lblRange, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblSection ----
                    lblSection.setText("Section:");
                    lblSection.setFont(lblSection.getFont().deriveFont(lblSection.getFont().getSize() + 1f));
                    headerPanel.add(lblSection, new GridBagConstraints(2, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblPrincipalMeridian ----
                    lblPrincipalMeridian.setText("Principal Meridian:");
                    lblPrincipalMeridian.setFont(lblPrincipalMeridian.getFont().deriveFont(lblPrincipalMeridian.getFont().getSize() + 1f));
                    headerPanel.add(lblPrincipalMeridian, new GridBagConstraints(3, 7, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- _cboTownship ----
                    _cboTownship.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _cboTownship.setActionCommand(Actions.CBOTOWNSHIPCHANGE.name());
                    headerPanel.add(_cboTownship, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _cboRange ----
                    _cboRange.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _cboRange.setActionCommand(Actions.CBORANGECHANGE.name());
                    headerPanel.add(_cboRange, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _cboSection ----
                    _cboSection.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _cboSection.setActionCommand(Actions.CBOSECTIONCHANGE.name());
                    headerPanel.add(_cboSection, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _cboPMeridian ----
                    _cboPMeridian.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _cboPMeridian.setActionCommand(Actions.CBOMERIDIANCHANGE.name());
                    headerPanel.add(_cboPMeridian, new GridBagConstraints(3, 8, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- lblLegalDescription ----
                    lblLegalDescription.setText("Property Description:");
                    lblLegalDescription.setFont(lblLegalDescription.getFont().deriveFont(lblLegalDescription.getFont().getSize() + 1f));
                    headerPanel.add(lblLegalDescription, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //======== scrollPane ========
                    {

                        //---- _LegalDescription ----
                        _LegalDescription.setMinimumSize(new Dimension(4, 67));
                        _LegalDescription.setPreferredSize(new Dimension(4, 67));
                        _LegalDescription.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _LegalDescription.setAutoscrolls(false);
                        _LegalDescription.setLineWrap(true);
                        _LegalDescription.setWrapStyleWord(true);
                        scrollPane.setViewportView(_LegalDescription);
                    }
                    headerPanel.add(scrollPane, new GridBagConstraints(0, 10, 4, 3, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- _cbxBounders ----
                    _cbxBounders.setText("Property Bounders");
                    _cbxBounders.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    _cbxBounders.setActionCommand("addPropertyBounders");
                    headerPanel.add(_cbxBounders, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //======== boundersPanel ========
                    {
                        boundersPanel.setLayout(new TableLayout(new double[][]{
                            {TableLayout.FILL, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL},
                            {TableLayout.PREFERRED, TableLayout.PREFERRED}}));
                        ((TableLayout) boundersPanel.getLayout()).setHGap(5);
                        ((TableLayout) boundersPanel.getLayout()).setVGap(5);

                        //---- lblNorthBounder ----
                        lblNorthBounder.setText("North Bounder");
                        boundersPanel.add(lblNorthBounder, new TableLayoutConstraints(0, 0, 0, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- lblEastBounder ----
                        lblEastBounder.setText("East Bounder");
                        boundersPanel.add(lblEastBounder, new TableLayoutConstraints(1, 0, 1, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- lblSouthBounder ----
                        lblSouthBounder.setText("South Bounder");
                        boundersPanel.add(lblSouthBounder, new TableLayoutConstraints(2, 0, 2, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- lblWestBounder ----
                        lblWestBounder.setText("West Bounder");
                        boundersPanel.add(lblWestBounder, new TableLayoutConstraints(3, 0, 3, 0, TableLayoutConstraints.CENTER, TableLayoutConstraints.FULL));

                        //---- _NorthBounder ----
                        _NorthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _NorthBounder.setAutoscrolls(false);
                        boundersPanel.add(_NorthBounder, new TableLayoutConstraints(0, 1, 0, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- _EastBounder ----
                        _EastBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _EastBounder.setAutoscrolls(false);
                        boundersPanel.add(_EastBounder, new TableLayoutConstraints(1, 1, 1, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- _SouthBounder ----
                        _SouthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SouthBounder.setAutoscrolls(false);
                        boundersPanel.add(_SouthBounder, new TableLayoutConstraints(2, 1, 2, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));

                        //---- _WestBounder ----
                        _WestBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _WestBounder.setAutoscrolls(false);
                        boundersPanel.add(_WestBounder, new TableLayoutConstraints(3, 1, 3, 1, TableLayoutConstraints.FULL, TableLayoutConstraints.FULL));
                    }
                    headerPanel.add(boundersPanel, new GridBagConstraints(0, 14, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- headerSurfaceOwner ----
                    headerSurfaceOwner.setText("SURFACE OWNER");
                    headerSurfaceOwner.setFont(headerSurfaceOwner.getFont().deriveFont(headerSurfaceOwner.getFont().getStyle() | Font.BOLD, headerSurfaceOwner.getFont().getSize() + 1f));
                    headerPanel.add(headerSurfaceOwner, new GridBagConstraints(0, 15, 2, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _AddSurfaceOwner ----
                    _AddSurfaceOwner.setText("Add Surface Owner");
                    _AddSurfaceOwner.setActionCommand(Actions.ADDSURFACEOWNER.name());
                    headerPanel.add(_AddSurfaceOwner, new GridBagConstraints(3, 15, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //======== surfaceOwnerPanel ========
                    {
                        surfaceOwnerPanel.setLayout(new GridBagLayout());
                        ((GridBagLayout) surfaceOwnerPanel.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
                        ((GridBagLayout) surfaceOwnerPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0};
                        ((GridBagLayout) surfaceOwnerPanel.getLayout()).columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0E-4};
                        ((GridBagLayout) surfaceOwnerPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};

                        //---- lblSOName ----
                        lblSOName.setText("Surface Owner:");
                        lblSOName.setFont(lblSOName.getFont().deriveFont(lblSOName.getFont().getSize() + 1f));
                        surfaceOwnerPanel.add(lblSOName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                        //---- _SOName ----
                        _SOName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SOName.setEditable(false);
                        _SOName.setAutoscrolls(false);
                        surfaceOwnerPanel.add(_SOName, new GridBagConstraints(1, 0, 5, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //---- lblSOAddress ----
                        lblSOAddress.setText("Address:");
                        lblSOAddress.setFont(lblSOAddress.getFont().deriveFont(lblSOAddress.getFont().getSize() + 1f));
                        surfaceOwnerPanel.add(lblSOAddress, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 5), 0, 0));

                        //---- _SOAddress ----
                        _SOAddress.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SOAddress.setEditable(false);
                        _SOAddress.setAutoscrolls(false);
                        surfaceOwnerPanel.add(_SOAddress, new GridBagConstraints(1, 1, 5, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //---- lblSOCity ----
                        lblSOCity.setText("City:");
                        lblSOCity.setFont(lblSOCity.getFont().deriveFont(lblSOCity.getFont().getSize() + 1f));
                        surfaceOwnerPanel.add(lblSOCity, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- _SOCity ----
                        _SOCity.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SOCity.setEditable(false);
                        _SOCity.setAutoscrolls(false);
                        surfaceOwnerPanel.add(_SOCity, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- lblSOState ----
                        lblSOState.setText("State:");
                        lblSOState.setFont(lblSOState.getFont().deriveFont(lblSOState.getFont().getSize() + 1f));
                        surfaceOwnerPanel.add(lblSOState, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- _SOState ----
                        _SOState.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SOState.setEditable(false);
                        _SOState.setAutoscrolls(false);
                        surfaceOwnerPanel.add(_SOState, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- lblSOZipCode ----
                        lblSOZipCode.setText("Zip Code:");
                        lblSOZipCode.setFont(lblSOZipCode.getFont().deriveFont(lblSOZipCode.getFont().getSize() + 1f));
                        surfaceOwnerPanel.add(lblSOZipCode, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- _SOZipCode ----
                        _SOZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        _SOZipCode.setEditable(false);
                        _SOZipCode.setAutoscrolls(false);
                        surfaceOwnerPanel.add(_SOZipCode, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                    }
                    headerPanel.add(surfaceOwnerPanel, new GridBagConstraints(0, 16, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- headerMineralOwnership ----
                    headerMineralOwnership.setText("MINERAL OWNERSHIP");
                    headerMineralOwnership.setFont(headerMineralOwnership.getFont().deriveFont(headerMineralOwnership.getFont().getStyle() | Font.BOLD, headerMineralOwnership.getFont().getSize() + 1f));
                    headerPanel.add(headerMineralOwnership, new GridBagConstraints(0, 17, 2, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _AddMineralOwner ----
                    _AddMineralOwner.setText("Add Mineral Owner");
                    _AddMineralOwner.setActionCommand(Actions.ADDMINERALOWNER.name());
                    headerPanel.add(_AddMineralOwner, new GridBagConstraints(3, 17, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //======== insertMOPanel ========
                    {
                        insertMOPanel.setMinimumSize(new Dimension(580, 240));
                        insertMOPanel.setBorder(new EtchedBorder());
                        insertMOPanel.setLayout(new GridLayout());
                    }
                    headerPanel.add(insertMOPanel, new GridBagConstraints(0, 18, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(headerPanel);
                headerPanel.setBounds(new Rectangle(new Point(0, 0), headerPanel.getPreferredSize()));
                
                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.WEST);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- lblInterestSubtotal ----
                lblInterestSubtotal.setText("Net Interest Subtotal:");
                buttonBar.add(lblInterestSubtotal, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 15), 0, 0));

                //---- _SaveButton ----
                _SaveButton.setText("OK");
                _SaveButton.setActionCommand(Actions.SAVEPROPERTY.name());
                buttonBar.add(_SaveButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- _CancelButton ----
                _CancelButton.setText("Cancel");
                _CancelButton.setActionCommand(Actions.CLOSEWINDOW.name());
                buttonBar.add(_CancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.WEST);
        pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(getOwner());
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    // intComponents()

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel headerPanel;
    
    private JLabel lblRecordID;
    private JLabel lblParcelID;
    private JLabel lblTaxMapID;
    private JLabel lblCounty;
    private JLabel lblState;
    private JLabel lblAcreage;
    private JLabel lblTownship;
    private JLabel lblRange;
    private JLabel lblSection;
    private JLabel lblPrincipalMeridian;
    
    private JTextField _RecordID;
    private JTextField _ParcelID;
    private JTextField _TaxMapID;
    private JTextField _County;
    private JTextField _State;
    private JTextField _Acreage;
    private JComboBox _cboTownship;
    private JComboBox _cboRange;
    private JComboBox _cboSection;
    private JComboBox _cboPMeridian;
    
    private JLabel headerLegalDescription;
    private JLabel lblLegalDescription;
    private JScrollPane scrollPane;
    private JTextArea _LegalDescription;
    
    private JCheckBox _cbxBounders;
    private JPanel boundersPanel;
    private JLabel lblNorthBounder;
    private JLabel lblEastBounder;
    private JLabel lblSouthBounder;
    private JLabel lblWestBounder;
    private JTextField _NorthBounder;
    private JTextField _EastBounder;
    private JTextField _SouthBounder;
    private JTextField _WestBounder;
    
    private JPanel surfaceOwnerPanel;
    private JButton _AddSurfaceOwner;
    private JLabel headerSurfaceOwner;
    private JLabel lblSOName;
    private JLabel lblSOAddress;
    private JLabel lblSOCity;
    private JLabel lblSOState;
    private JLabel lblSOZipCode;
    
    private JTextField _SOName;
    private JTextField _SOAddress;
    private JTextField _SOCity;
    private JTextField _SOState;
    private JTextField _SOZipCode;
    
    private JLabel headerMineralOwnership;
    private JPanel insertMOPanel;
    private JButton _AddMineralOwner;
    
    private JPanel buttonBar;
    private JLabel lblInterestSubtotal;
    private JButton _SaveButton;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
