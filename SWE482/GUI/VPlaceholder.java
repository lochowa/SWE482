package JavaApp.mvccompliant;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ubuntu2B
 */
public class VPlaceholder  {

    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    // CloseListener Class Object
    @Override
    public void update(Observable obs, Object obj) {
        // Test Script:  Who called the operation and what did they send?
        System.out.println("Placeholder View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }

    public VPlaceholder() {
        initComponents();
    }

    private enum Actions {
        SAVEPROPERTY,
        CLOSEWINDOW,
        DISPLAYBOUNDERS
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Placeholder Controller");
        _SaveProperty.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _cbxPropertyBounders.addActionListener(controller);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblDBRecordID = new JLabel();
        _DBRecordID = new JTextField();
        lblParcelID = new JLabel();
        _ParcelID = new JTextField();
        lblTownship = new JLabel();
        _cboTownship = new JComboBox();
        label3 = new JLabel();
        textField3 = new JTextField();
        lblRange = new JLabel();
        _cboRange = new JComboBox();
        label4 = new JLabel();
        textField4 = new JTextField();
        lblSection = new JLabel();
        _cboSection = new JComboBox();
        label5 = new JLabel();
        textField5 = new JTextField();
        lblMeridian = new JLabel();
        _cboMeridian = new JComboBox();
        lblAcreage = new JLabel();
        _Acreage = new JTextField();
        lblPropertyDescription = new JLabel();
        scrollPane1 = new JScrollPane();
        _LegalDescription = new JTextArea();
        _cbxPropertyBounders = new JCheckBox();
        boundersPanel = new JPanel();
        lblNorthBounder = new JLabel();
        lblEastBounder = new JLabel();
        lblSouthBounder = new JLabel();
        lblWestBounder = new JLabel();
        _NorthBounder = new JTextField();
        _EastBounder = new JTextField();
        _SouthBounder = new JTextField();
        _WestBounder = new JTextField();
        _PropertyVerification = new JButton();
        buttonBar = new JPanel();
        _SaveProperty = new JButton();
        _CancelButton = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{140, 140, 140, 135, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- lblDBRecordID ----
                lblDBRecordID.setText("Record Identification");
                contentPanel.add(lblDBRecordID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _DBRecordID ----
                _DBRecordID.setAutoscrolls(false);
                _DBRecordID.setEditable(false);
                contentPanel.add(_DBRecordID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblParcelID ----
                lblParcelID.setText("Parcel Number");
                contentPanel.add(lblParcelID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _ParcelID ----
                _ParcelID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_ParcelID, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblTownship ----
                lblTownship.setText("Township");
                contentPanel.add(lblTownship, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));
                contentPanel.add(_cboTownship, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- label3 ----
                label3.setText("Tax Map Identification");
                contentPanel.add(label3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- textField3 ----
                textField3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(textField3, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblRange ----
                lblRange.setText("Range");
                contentPanel.add(lblRange, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));
                contentPanel.add(_cboRange, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- label4 ----
                label4.setText("County");
                contentPanel.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- textField4 ----
                textField4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(textField4, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblSection ----
                lblSection.setText("Section");
                contentPanel.add(lblSection, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));
                contentPanel.add(_cboSection, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- label5 ----
                label5.setText("State");
                contentPanel.add(label5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- textField5 ----
                textField5.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(textField5, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblMeridian ----
                lblMeridian.setText("Principal Meridian");
                contentPanel.add(lblMeridian, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));
                contentPanel.add(_cboMeridian, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblAcreage ----
                lblAcreage.setText("Acreage");
                contentPanel.add(lblAcreage, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_Acreage, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblPropertyDescription ----
                lblPropertyDescription.setText("Property Description:");
                contentPanel.add(lblPropertyDescription, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- _LegalDescription ----
                    _LegalDescription.setLineWrap(true);
                    _LegalDescription.setWrapStyleWord(true);
                    _LegalDescription.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    scrollPane1.setViewportView(_LegalDescription);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(0, 7, 4, 3, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- _cbxPropertyBounders ----
                _cbxPropertyBounders.setText("Property Bounders");
                _cbxPropertyBounders.setActionCommand(Actions.DISPLAYBOUNDERS.name());
                contentPanel.add(_cbxPropertyBounders, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== boundersPanel ========
                {
                    boundersPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout) boundersPanel.getLayout()).columnWidths = new int[]{140, 140, 140, 135, 0};
                    ((GridBagLayout) boundersPanel.getLayout()).rowHeights = new int[]{0, 0, 0};
                    ((GridBagLayout) boundersPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) boundersPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0E-4};

                    //---- lblNorthBounder ----
                    lblNorthBounder.setText("North Bounder");
                    boundersPanel.add(lblNorthBounder, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblEastBounder ----
                    lblEastBounder.setText("East Bounder");
                    boundersPanel.add(lblEastBounder, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblSouthBounder ----
                    lblSouthBounder.setText("South Bounder");
                    boundersPanel.add(lblSouthBounder, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblWestBounder ----
                    lblWestBounder.setText("West Bounder");
                    boundersPanel.add(lblWestBounder, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 0), 0, 0));
                    boundersPanel.add(_NorthBounder, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    boundersPanel.add(_EastBounder, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    boundersPanel.add(_SouthBounder, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    boundersPanel.add(_WestBounder, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(boundersPanel, new GridBagConstraints(0, 11, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- _PropertyVerification ----
                _PropertyVerification.setText("Property Verification");
                _PropertyVerification.setMinimumSize(new Dimension(149, 35));
                _PropertyVerification.setMaximumSize(new Dimension(149, 35));
                _PropertyVerification.setPreferredSize(new Dimension(149, 35));
                contentPanel.add(_PropertyVerification, new GridBagConstraints(0, 12, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- _SaveProperty ----
                _SaveProperty.setText("SAVE");
                _SaveProperty.setActionCommand(Actions.SAVEPROPERTY.name());
                buttonBar.add(_SaveProperty, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(getOwner());
        this.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel lblDBRecordID;
    private JTextField _DBRecordID;
    private JLabel lblParcelID;
    private JTextField _ParcelID;
    private JLabel lblTownship;
    private JComboBox _cboTownship;
    private JLabel label3;
    private JTextField textField3;
    private JLabel lblRange;
    private JComboBox _cboRange;
    private JLabel label4;
    private JTextField textField4;
    private JLabel lblSection;
    private JComboBox _cboSection;
    private JLabel label5;
    private JTextField textField5;
    private JLabel lblMeridian;
    private JComboBox _cboMeridian;
    private JLabel lblAcreage;
    private JTextField _Acreage;
    private JLabel lblPropertyDescription;
    private JScrollPane scrollPane1;
    private JTextArea _LegalDescription;
    private JCheckBox _cbxPropertyBounders;
    private JPanel boundersPanel;
    private JLabel lblNorthBounder;
    private JLabel lblEastBounder;
    private JLabel lblSouthBounder;
    private JLabel lblWestBounder;
    private JTextField _NorthBounder;
    private JTextField _EastBounder;
    private JTextField _SouthBounder;
    private JTextField _WestBounder;
    private JButton _PropertyVerification;
    private JPanel buttonBar;
    private JButton _SaveProperty;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
