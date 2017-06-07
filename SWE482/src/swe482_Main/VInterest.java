package swe482_Main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Wed May 31 10:01:01 MDT 2017
 */

/**
 * @author Michael Barth
 */
public class VInterest extends JFrame  {
    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    VInterest(){
        initComponents();
    }
    // CloseListener Class Object
   
    public enum Actions {
        ADDLEASEBURDEN,
        SEARCHNAME,
        CONVERTFRACTION,
        ADDRECORDEDINSTRUMENT,
        SAVEINTEREST,
        CLOSEWINDOW
    }
    void addController(ActionListener controller) {
        System.out.println("View: Adding Interest Controller");
        _SaveButton.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _SearchName.addActionListener(controller);
        _AddRecordedInstrument.addActionListener(controller);
        _ConvertFraction.addActionListener(controller);
        _AddLeaseBurden.addActionListener(controller);
        _cbxActiveStatus.addActionListener(controller);

    }
   
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblRecordID = new JLabel();
        _RecordID = new JTextField();
        lblPropertyREFID = new JLabel();
        textField2 = new JTextField();
        lblInterestID = new JLabel();
        textField4 = new JTextField();
        _NameQuery = new JTextField();
        _SearchName = new JButton();
        lblNetInterest = new JLabel();
        _NetInterest = new JTextField();
        _ConvertFraction = new JButton();
        lblInterestStatus = new JLabel();
        _cboInterestStatus = new JComboBox();
        _AddLeaseBurden = new JButton();
        lblName1 = new JLabel();
        _Name1 = new JTextField();
        lblName2 = new JLabel();
        _Name2 = new JTextField();
        lblName3 = new JLabel();
        _Name3 = new JTextField();
        lblName4 = new JLabel();
        _Name4 = new JTextField();
        lblAddress = new JLabel();
        _Address = new JTextField();
        lblCity = new JLabel();
        _City = new JTextField();
        lblState = new JLabel();
        _State = new JTextField();
        lblZipCode = new JLabel();
        _ZipCode = new JTextField();
        label9 = new JLabel();
        _ContactNumber = new JTextField();
        _AddRecordedInstrument = new JButton();
        panel2 = new JPanel();
        buttonBar = new JPanel();
        _cbxActiveStatus = new JCheckBox();
        _SaveButton = new JButton();
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
                contentPanel.setFont(contentPanel.getFont().deriveFont(contentPanel.getFont().getSize() + 1f));
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {140, 140, 140, 135, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblRecordID ----
                lblRecordID.setText("Record Identification");
                contentPanel.add(lblRecordID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _RecordID ----
                _RecordID.setEditable(false);
                _RecordID.setAutoscrolls(false);
                _RecordID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_RecordID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblPropertyREFID ----
                lblPropertyREFID.setText("Property REF No.");
                contentPanel.add(lblPropertyREFID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- textField2 ----
                textField2.setEditable(false);
                textField2.setAutoscrolls(false);
                textField2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(textField2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblInterestID ----
                lblInterestID.setText("Interest Record No.");
                contentPanel.add(lblInterestID, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- textField4 ----
                textField4.setEditable(false);
                textField4.setAutoscrolls(false);
                textField4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(textField4, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _NameQuery ----
                _NameQuery.setAutoscrolls(false);
                _NameQuery.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_NameQuery, new GridBagConstraints(1, 3, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- _SearchName ----
                _SearchName.setText("Unique Name Verification");
                _SearchName.setActionCommand(Actions.SEARCHNAME.name());
                _SearchName.setMargin(new Insets(2, 15, 2, 15));
                _SearchName.setFont(_SearchName.getFont().deriveFont(_SearchName.getFont().getStyle() & ~Font.BOLD, _SearchName.getFont().getSize() + 1f));
                contentPanel.add(_SearchName, new GridBagConstraints(1, 4, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 25, 0), 0, 0));

                //---- lblNetInterest ----
                lblNetInterest.setText("Net Interesst");
                lblNetInterest.setFont(lblNetInterest.getFont().deriveFont(lblNetInterest.getFont().getSize() + 1f));
                contentPanel.add(lblNetInterest, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _NetInterest ----
                _NetInterest.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_NetInterest, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _ConvertFraction ----
                _ConvertFraction.setText("Convert Fraction");
                contentPanel.add(_ConvertFraction, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblInterestStatus ----
                lblInterestStatus.setText("Status");
                lblInterestStatus.setFont(lblInterestStatus.getFont().deriveFont(lblInterestStatus.getFont().getSize() + 1f));
                contentPanel.add(lblInterestStatus, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _cboInterestStatus ----
                _cboInterestStatus.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_cboInterestStatus, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _AddLeaseBurden ----
                _AddLeaseBurden.setText("Add Lease Burden");
                _AddLeaseBurden.setActionCommand(Actions.ADDLEASEBURDEN.name());
                contentPanel.add(_AddLeaseBurden, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblName1 ----
                lblName1.setText("Name #1");
                lblName1.setFont(lblName1.getFont().deriveFont(lblName1.getFont().getSize() + 1f));
                contentPanel.add(lblName1, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name1 ----
                _Name1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name1, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblName2 ----
                lblName2.setText("Name #2");
                lblName2.setFont(lblName2.getFont().deriveFont(lblName2.getFont().getSize() + 1f));
                contentPanel.add(lblName2, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name2 ----
                _Name2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name2, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblName3 ----
                lblName3.setText("Name #3");
                lblName3.setFont(lblName3.getFont().deriveFont(lblName3.getFont().getSize() + 1f));
                contentPanel.add(lblName3, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name3 ----
                _Name3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name3, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblName4 ----
                lblName4.setText("Name #4");
                lblName4.setFont(lblName4.getFont().deriveFont(lblName4.getFont().getSize() + 1f));
                contentPanel.add(lblName4, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name4 ----
                _Name4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name4, new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblAddress ----
                lblAddress.setText("Address");
                lblAddress.setFont(lblAddress.getFont().deriveFont(lblAddress.getFont().getSize() + 1f));
                contentPanel.add(lblAddress, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Address ----
                _Address.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Address, new GridBagConstraints(1, 11, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblCity ----
                lblCity.setText("City");
                lblCity.setFont(lblCity.getFont().deriveFont(lblCity.getFont().getSize() + 1f));
                contentPanel.add(lblCity, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _City ----
                _City.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_City, new GridBagConstraints(1, 12, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblState ----
                lblState.setText("State");
                lblState.setFont(lblState.getFont().deriveFont(lblState.getFont().getSize() + 1f));
                contentPanel.add(lblState, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _State ----
                _State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_State, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblZipCode ----
                lblZipCode.setText("Zip Code");
                lblZipCode.setFont(lblZipCode.getFont().deriveFont(lblZipCode.getFont().getSize() + 1f));
                contentPanel.add(lblZipCode, new GridBagConstraints(0, 14, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _ZipCode ----
                _ZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_ZipCode, new GridBagConstraints(1, 14, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- label9 ----
                label9.setText("Contact Number");
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 1f));
                contentPanel.add(label9, new GridBagConstraints(0, 15, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _ContactNumber ----
                _ContactNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_ContactNumber, new GridBagConstraints(1, 15, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _AddRecordedInstrument ----
                _AddRecordedInstrument.setText("Add Recorded Document");
                _AddRecordedInstrument.setActionCommand(Actions.ADDRECORDEDINSTRUMENT.name());
                contentPanel.add(_AddRecordedInstrument, new GridBagConstraints(0, 16, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //======== panel2 ========
                {
                    panel2.setMinimumSize(new Dimension(0, 67));
                    panel2.setBorder(new EtchedBorder());
                    panel2.setPreferredSize(new Dimension(4, 67));
                    panel2.setLayout(new GridLayout());
                }
                contentPanel.add(panel2, new GridBagConstraints(0, 17, 4, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- _cbxActiveStatus ----
                _cbxActiveStatus.setText("Active?");
                _cbxActiveStatus.setFont(_cbxActiveStatus.getFont().deriveFont(_cbxActiveStatus.getFont().getSize() + 2f));
                _cbxActiveStatus.setSelected(true);
                buttonBar.add(_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- _SaveButton ----
                _SaveButton.setText("SAVE");
                _SaveButton.setActionCommand(Actions.SAVEINTEREST.name());
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
    private JLabel lblRecordID;
    private JTextField _RecordID;
    private JLabel lblPropertyREFID;
    private JTextField textField2;
    private JLabel lblInterestID;
    private JTextField textField4;
    private JTextField _NameQuery;
    private JButton _SearchName;
    private JLabel lblNetInterest;
    private JTextField _NetInterest;
    private JButton _ConvertFraction;
    private JLabel lblInterestStatus;
    private JComboBox _cboInterestStatus;
    private JButton _AddLeaseBurden;
    private JLabel lblName1;
    private JTextField _Name1;
    private JLabel lblName2;
    private JTextField _Name2;
    private JLabel lblName3;
    private JTextField _Name3;
    private JLabel lblName4;
    private JTextField _Name4;
    private JLabel lblAddress;
    private JTextField _Address;
    private JLabel lblCity;
    private JTextField _City;
    private JLabel lblState;
    private JTextField _State;
    private JLabel lblZipCode;
    private JTextField _ZipCode;
    private JLabel label9;
    private JTextField _ContactNumber;
    private JButton _AddRecordedInstrument;
    private JPanel panel2;
    private JPanel buttonBar;
    private JCheckBox _cbxActiveStatus;
    private JButton _SaveButton;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


}
