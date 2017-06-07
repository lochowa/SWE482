package aLochowSandbox.main;
/**
 * 
 * @author Michael Barth
 */
import swe482_Main.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Ubuntu2B
 * @param <E>
 */
public class VMineralRTI<E> extends JFrame  {
        
    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    VMineralRTI() {
        initComponents();
    }

    // CloseListener Class Object
    

    public enum Actions {
        ADDLEASEBURDEN,
        SEARCHNAME,
        CONVERTFRACTION,
        ADDINSTRUMENT,
        SAVEINTEREST,
        CLOSEWINDOW
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding MineralRTI Controller");
        _InsertButton.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _SearchName.addActionListener(controller);
        _AddInstrument.addActionListener(controller);
        _ConvertFraction.addActionListener(controller);
        _AddLeaseBurden.addActionListener(controller);
        _cbxActiveStatus.addActionListener(controller);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblRecordIdentification = new JLabel();
        _RecordIdentification = new JTextField();
        _NameQuery = new JTextField();
        _SearchName = new JButton();
        lblOwnerRTI = new JLabel();
        _OwnerRTI = new JTextField();
        _ConvertFraction = new JButton();
        lblStatus = new JLabel();
        _cboStatus = new JComboBox();
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
        _OwnerAddress = new JTextField();
        lblCity = new JLabel();
        _OwnerCity = new JTextField();
        lblState = new JLabel();
        _OwnerState = new JTextField();
        lblZipCode = new JLabel();
        _OwnerZipCode = new JTextField();
        label9 = new JLabel();
        _ContactNumber = new JTextField();
        _AddInstrument = new JButton();
        panel2 = new JPanel();
        buttonBar = new JPanel();
        _cbxActiveStatus = new JCheckBox();
        _InsertButton = new JButton();
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
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{140, 140, 135, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblRecordIdentification ----
                lblRecordIdentification.setText("Record Identification");
                contentPanel.add(lblRecordIdentification, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _RecordIdentification ----
                _RecordIdentification.setEditable(false);
                _RecordIdentification.setAutoscrolls(false);
                contentPanel.add(_RecordIdentification, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _NameQuery ----
                _NameQuery.setAutoscrolls(false);
                _NameQuery.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_NameQuery, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(30, 0, 10, 0), 0, 0));

                //---- _SearchName ----
                _SearchName.setText("Name Verification");
                _SearchName.setMargin(new Insets(2, 15, 2, 15));
                _SearchName.setFont(_SearchName.getFont().deriveFont(_SearchName.getFont().getStyle() & ~Font.BOLD, _SearchName.getFont().getSize() + 1f));
                _SearchName.setActionCommand(Actions.SEARCHNAME.name());
                contentPanel.add(_SearchName, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 25, 0), 0, 0));

                //---- lblOwnerRTI ----
                lblOwnerRTI.setText("Net Interesst");
                lblOwnerRTI.setFont(lblOwnerRTI.getFont().deriveFont(lblOwnerRTI.getFont().getSize() + 1f));
                contentPanel.add(lblOwnerRTI, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OwnerRTI ----
                _OwnerRTI.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OwnerRTI, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _ConvertFraction ----
                _ConvertFraction.setText("Convert Fraction");
                _ConvertFraction.setActionCommand(Actions.CONVERTFRACTION.name());
                contentPanel.add(_ConvertFraction, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblStatus ----
                lblStatus.setText("Status");
                lblStatus.setFont(lblStatus.getFont().deriveFont(lblStatus.getFont().getSize() + 1f));
                contentPanel.add(lblStatus, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _cboStatus ----
                _cboStatus.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_cboStatus, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _AddLeaseBurden ----
                _AddLeaseBurden.setText("Add Lease Burden");
                _AddLeaseBurden.setActionCommand(Actions.ADDLEASEBURDEN.name());
                contentPanel.add(_AddLeaseBurden, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblName1 ----
                lblName1.setText("Name #1");
                lblName1.setFont(lblName1.getFont().deriveFont(lblName1.getFont().getSize() + 1f));
                contentPanel.add(lblName1, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name1 ----
                _Name1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name1, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblName2 ----
                lblName2.setText("Name #2");
                lblName2.setFont(lblName2.getFont().deriveFont(lblName2.getFont().getSize() + 1f));
                contentPanel.add(lblName2, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name2 ----
                _Name2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name2, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblName3 ----
                lblName3.setText("Name #3");
                lblName3.setFont(lblName3.getFont().deriveFont(lblName3.getFont().getSize() + 1f));
                contentPanel.add(lblName3, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name3 ----
                _Name3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name3, new GridBagConstraints(1, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblName4 ----
                lblName4.setText("Name #4");
                lblName4.setFont(lblName4.getFont().deriveFont(lblName4.getFont().getSize() + 1f));
                contentPanel.add(lblName4, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Name4 ----
                _Name4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Name4, new GridBagConstraints(1, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblAddress ----
                lblAddress.setText("Address");
                lblAddress.setFont(lblAddress.getFont().deriveFont(lblAddress.getFont().getSize() + 1f));
                contentPanel.add(lblAddress, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OwnerAddress ----
                _OwnerAddress.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OwnerAddress, new GridBagConstraints(1, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblCity ----
                lblCity.setText("City");
                lblCity.setFont(lblCity.getFont().deriveFont(lblCity.getFont().getSize() + 1f));
                contentPanel.add(lblCity, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OwnerCity ----
                _OwnerCity.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OwnerCity, new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblState ----
                lblState.setText("State");
                lblState.setFont(lblState.getFont().deriveFont(lblState.getFont().getSize() + 1f));
                contentPanel.add(lblState, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OwnerState ----
                _OwnerState.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OwnerState, new GridBagConstraints(1, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblZipCode ----
                lblZipCode.setText("Zip Code");
                lblZipCode.setFont(lblZipCode.getFont().deriveFont(lblZipCode.getFont().getSize() + 1f));
                contentPanel.add(lblZipCode, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OwnerZipCode ----
                _OwnerZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OwnerZipCode, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- label9 ----
                label9.setText("Contact Number");
                label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 1f));
                contentPanel.add(label9, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _ContactNumber ----
                _ContactNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_ContactNumber, new GridBagConstraints(1, 13, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- _AddInstrument ----
                _AddInstrument.setText("Add Vesting Instrument");
                _AddInstrument.setActionCommand(Actions.ADDINSTRUMENT.name());
                contentPanel.add(_AddInstrument, new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== panel2 ========
                {
                    panel2.setMinimumSize(new Dimension(0, 67));
                    panel2.setBorder(new EtchedBorder());
                    panel2.setPreferredSize(new Dimension(4, 67));
                    panel2.setLayout(new GridLayout());
                }
                contentPanel.add(panel2, new GridBagConstraints(0, 15, 3, 1, 0.0, 0.0,
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

                //---- _cbxActiveStatus ----
                _cbxActiveStatus.setText("Active?");
                _cbxActiveStatus.setFont(_cbxActiveStatus.getFont().deriveFont(_cbxActiveStatus.getFont().getSize() + 2f));
                _cbxActiveStatus.setSelected(true);
                buttonBar.add(_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- _InsertButton ----
                _InsertButton.setText("INSERT");
                _InsertButton.setActionCommand(Actions.SAVEINTEREST.name());
                buttonBar.add(_InsertButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JLabel lblRecordIdentification;
    private JTextField _RecordIdentification;
    private JTextField _NameQuery;
    private JButton _SearchName;
    private JLabel lblOwnerRTI;
    private JTextField _OwnerRTI;
    private JButton _ConvertFraction;
    private JLabel lblStatus;
    private JComboBox _cboStatus;
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
    private JTextField _OwnerAddress;
    private JLabel lblCity;
    private JTextField _OwnerCity;
    private JLabel lblState;
    private JTextField _OwnerState;
    private JLabel lblZipCode;
    private JTextField _OwnerZipCode;
    private JLabel label9;
    private JTextField _ContactNumber;
    private JButton _AddInstrument;
    private JPanel panel2;
    private JPanel buttonBar;
    private JCheckBox _cbxActiveStatus;
    private JButton _InsertButton;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

        
    String getNameQuery(){
        return this._NameQuery.getText();
    }
    
    String getOwnerRTI(){
        return this._OwnerRTI.getText();
    }
    
    void setOwnerRTI(String OwnerRTI){
        this._OwnerRTI.setText(OwnerRTI);
    }
    
    String getStatus(){
        return this._cboStatus.getSelectedItem().toString();
    }
   
    String getName1(){
        return this._Name1.getText();
    }
    
    void setName1(String Name1){
        this._Name1.setText(Name1);
    }
    
    String getName2(){
        return this._Name2.getText();
    }
    
    void setName2(String Name2){
        this._Name2.setText(Name2);
    }
    
    String getName3(){
        return this._Name3.getText();
    }
    
    void setName3(String Name3){
        this._Name3.setText(Name3);
    }
    
    String getName4(){
        return this._Name4.getText();
    }
    
    void setName4(String Name4){
        this._Name4.setText(Name4);
    }
    
    String getOwnerAddress(){
        return this._OwnerAddress.getText();
    }
    
    void setownerAddress(String Address){
        this._OwnerAddress.setText(Address);
    }
    
    String getOwnerCity(){
        return this._OwnerCity.getText();
    }
    
    void setOwnerCity(String City){
        this._OwnerCity.setText(City);
    }
    
    String getOwnerState(){
        return this._OwnerState.getText();
    }
    
    void setOwnerState(String State){
        this._OwnerState.setText(State);
    }
    
    String getOwnerZipCode(){
        return this._OwnerZipCode.getText();
    }
    
    void setOwnerZipCode(String ZipCode){
        this._OwnerZipCode.setText(ZipCode);
    }
    
    String getContactNumber(){
        return this._ContactNumber.getText();
    }
    
    void setContactNumber(String ContactNumber){
        this._ContactNumber.setText(ContactNumber);
    }
   
}
