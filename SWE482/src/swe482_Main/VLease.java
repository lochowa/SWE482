package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;


public class VLease extends JFrame implements java.util.Observer {

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
        System.out.println("Lease View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }

    public VLease() {
        initComponents();
    }

    private enum Actions {
        SAVECONTENTS,
        CLOSEWINDOW,
        SEARCHNAME,
        ADDLEGALDESCRIPTION,
        LESSEECLIENT
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Lease Controller");
        _SaveButton.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _SearchName.addActionListener(controller);
        _AddLegalDescription.addActionListener(controller);
        _cbxClientLessee.addActionListener(controller);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblRecordID = new JLabel();
        _dbRecordID = new JTextField();
        lblLeaseholdID = new JLabel();
        _LeaseholdID = new JTextField();
        lblOOPEffectiveDate = new JLabel();
        _OOPEffectiveDate = new JTextField();
        lblRoyalty = new JLabel();
        _Royalty = new JTextField();
        lblBonusPNMA = new JLabel();
        _BonusPNMA = new JTextField();
        lblPrimaryTerm = new JLabel();
        _PrimaryTerm = new JTextField();
        lblPaymentTerms = new JLabel();
        _PaymentTerms = new JTextField();
        lblPrimaryTermExpiration = new JLabel();
        _PrimaryTermExpiration = new JTextField();
        lblPaymentDueDate = new JLabel();
        _PaymentDueDate = new JTextField();
        lblOptionalTerm = new JLabel();
        _OptionalTerm = new JTextField();
        lblTotalBonusPayment = new JLabel();
        _TotalBonusPayment = new JTextField();
        lblOptionalTermExpiration = new JLabel();
        _OptionalTermExpiration = new JTextField();
        lblQueryMineralOwner = new JLabel();
        _QueryName = new JTextField();
        _SearchName = new JButton();
        headerLessor = new JLabel();
        lblLessorName = new JLabel();
        _LessorName = new JTextField();
        lblLessorAddress = new JLabel();
        _LessorAddress = new JTextField();
        lblLessorCity = new JLabel();
        _LessorCity = new JTextField();
        lblLessorState = new JLabel();
        _LessorState = new JTextField();
        lbLessorlZipCode = new JLabel();
        _LessorZipCode = new JTextField();
        _cbxClientLessee = new JCheckBox();
        nonclientLesseePanel = new JPanel();
        lblLesseeName = new JLabel();
        _LesseeName = new JTextField();
        lblLesseeAddress = new JLabel();
        _LesseeAddress = new JTextField();
        lblLesseeCity = new JLabel();
        _LesseeCity = new JTextField();
        lblLesseeState = new JLabel();
        _LesseeState = new JTextField();
        lblLesseeZipCode = new JLabel();
        _LesseeZipCode = new JTextField();
        _AddLegalDescription = new JButton();
        leasedDescriptionPanel = new JPanel();
        buttonBar = new JPanel();
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
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{140, 140, 140, 135, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

                //---- lblRecordID ----
                lblRecordID.setText("Record Identification");
                contentPanel.add(lblRecordID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_dbRecordID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblLeaseholdID ----
                lblLeaseholdID.setText("Leasehold ID");
                contentPanel.add(lblLeaseholdID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _LeaseholdID ----
                _LeaseholdID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LeaseholdID, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblOOPEffectiveDate ----
                lblOOPEffectiveDate.setText("OOP Effective Date");
                lblOOPEffectiveDate.setFont(lblOOPEffectiveDate.getFont().deriveFont(lblOOPEffectiveDate.getFont().getSize() + 1f));
                contentPanel.add(lblOOPEffectiveDate, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OOPEffectiveDate ----
                _OOPEffectiveDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OOPEffectiveDate, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblRoyalty ----
                lblRoyalty.setText("Royalty");
                lblRoyalty.setFont(lblRoyalty.getFont().deriveFont(lblRoyalty.getFont().getSize() + 1f));
                contentPanel.add(lblRoyalty, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Royalty ----
                _Royalty.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Royalty, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblBonusPNMA ----
                lblBonusPNMA.setText("Bonus per Net Acre");
                lblBonusPNMA.setFont(lblBonusPNMA.getFont().deriveFont(lblBonusPNMA.getFont().getSize() + 1f));
                contentPanel.add(lblBonusPNMA, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _BonusPNMA ----
                _BonusPNMA.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_BonusPNMA, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblPrimaryTerm ----
                lblPrimaryTerm.setText("Primary Term");
                lblPrimaryTerm.setFont(lblPrimaryTerm.getFont().deriveFont(lblPrimaryTerm.getFont().getSize() + 1f));
                contentPanel.add(lblPrimaryTerm, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _PrimaryTerm ----
                _PrimaryTerm.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PrimaryTerm, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblPaymentTerms ----
                lblPaymentTerms.setText("Payment Terms");
                lblPaymentTerms.setFont(lblPaymentTerms.getFont().deriveFont(lblPaymentTerms.getFont().getSize() + 1f));
                contentPanel.add(lblPaymentTerms, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _PaymentTerms ----
                _PaymentTerms.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PaymentTerms, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblPrimaryTermExpiration ----
                lblPrimaryTermExpiration.setText("Primary Expiration Date");
                lblPrimaryTermExpiration.setFont(lblPrimaryTermExpiration.getFont().deriveFont(lblPrimaryTermExpiration.getFont().getSize() + 1f));
                contentPanel.add(lblPrimaryTermExpiration, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _PrimaryTermExpiration ----
                _PrimaryTermExpiration.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PrimaryTermExpiration, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblPaymentDueDate ----
                lblPaymentDueDate.setText("Payment Due Date");
                lblPaymentDueDate.setFont(lblPaymentDueDate.getFont().deriveFont(lblPaymentDueDate.getFont().getSize() + 1f));
                contentPanel.add(lblPaymentDueDate, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _PaymentDueDate ----
                _PaymentDueDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PaymentDueDate, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblOptionalTerm ----
                lblOptionalTerm.setText("Optional Term");
                lblOptionalTerm.setFont(lblOptionalTerm.getFont().deriveFont(lblOptionalTerm.getFont().getSize() + 1f));
                contentPanel.add(lblOptionalTerm, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OptionalTerm ----
                _OptionalTerm.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OptionalTerm, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblTotalBonusPayment ----
                lblTotalBonusPayment.setText("Total Bonus Payment");
                lblTotalBonusPayment.setFont(lblTotalBonusPayment.getFont().deriveFont(lblTotalBonusPayment.getFont().getSize() + 1f));
                contentPanel.add(lblTotalBonusPayment, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _TotalBonusPayment ----
                _TotalBonusPayment.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_TotalBonusPayment, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblOptionalTermExpiration ----
                lblOptionalTermExpiration.setText("Optional Expiration Date");
                lblOptionalTermExpiration.setFont(lblOptionalTermExpiration.getFont().deriveFont(lblOptionalTermExpiration.getFont().getSize() + 1f));
                contentPanel.add(lblOptionalTermExpiration, new GridBagConstraints(2, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _OptionalTermExpiration ----
                _OptionalTermExpiration.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OptionalTermExpiration, new GridBagConstraints(3, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblQueryMineralOwner ----
                lblQueryMineralOwner.setText("Query Mineral Owner");
                lblQueryMineralOwner.setFont(lblQueryMineralOwner.getFont().deriveFont(lblQueryMineralOwner.getFont().getSize() + 1f));
                contentPanel.add(lblQueryMineralOwner, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _QueryName ----
                _QueryName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_QueryName, new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- _SearchName ----
                _SearchName.setText("Search Mineral Owners");
                _SearchName.setActionCommand(Actions.SEARCHNAME.name());
                contentPanel.add(_SearchName, new GridBagConstraints(1, 8, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- headerLessor ----
                headerLessor.setText("LESSOR");
                headerLessor.setFont(headerLessor.getFont().deriveFont(headerLessor.getFont().getStyle() | Font.BOLD, headerLessor.getFont().getSize() + 1f));
                contentPanel.add(headerLessor, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblLessorName ----
                lblLessorName.setText("Name");
                lblLessorName.setFont(lblLessorName.getFont().deriveFont(lblLessorName.getFont().getSize() + 1f));
                contentPanel.add(lblLessorName, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _LessorName ----
                _LessorName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LessorName, new GridBagConstraints(1, 10, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblLessorAddress ----
                lblLessorAddress.setText("Address");
                lblLessorAddress.setFont(lblLessorAddress.getFont().deriveFont(lblLessorAddress.getFont().getSize() + 1f));
                contentPanel.add(lblLessorAddress, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _LessorAddress ----
                _LessorAddress.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LessorAddress, new GridBagConstraints(1, 11, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblLessorCity ----
                lblLessorCity.setText("City");
                lblLessorCity.setFont(lblLessorCity.getFont().deriveFont(lblLessorCity.getFont().getSize() + 1f));
                contentPanel.add(lblLessorCity, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _LessorCity ----
                _LessorCity.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LessorCity, new GridBagConstraints(1, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblLessorState ----
                lblLessorState.setText("State");
                lblLessorState.setFont(lblLessorState.getFont().deriveFont(lblLessorState.getFont().getSize() + 1f));
                contentPanel.add(lblLessorState, new GridBagConstraints(2, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 15, 10, 5), 0, 0));

                //---- _LessorState ----
                _LessorState.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LessorState, new GridBagConstraints(3, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lbLessorlZipCode ----
                lbLessorlZipCode.setText("Zip Code");
                lbLessorlZipCode.setFont(lbLessorlZipCode.getFont().deriveFont(lbLessorlZipCode.getFont().getSize() + 1f));
                contentPanel.add(lbLessorlZipCode, new GridBagConstraints(0, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _LessorZipCode ----
                _LessorZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LessorZipCode, new GridBagConstraints(1, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _cbxClientLessee ----
                _cbxClientLessee.setText("Project Client is the Lessee?");
                _cbxClientLessee.setFont(_cbxClientLessee.getFont().deriveFont(_cbxClientLessee.getFont().getSize() + 2f));
                _cbxClientLessee.setActionCommand(Actions.LESSEECLIENT.name());
                contentPanel.add(_cbxClientLessee, new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== nonclientLesseePanel ========
                {
                    nonclientLesseePanel.setLayout(new GridBagLayout());
                    ((GridBagLayout) nonclientLesseePanel.getLayout()).columnWidths = new int[]{140, 140, 140, 135, 0};
                    ((GridBagLayout) nonclientLesseePanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0};
                    ((GridBagLayout) nonclientLesseePanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) nonclientLesseePanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- lblLesseeName ----
                    lblLesseeName.setText("Entity Name");
                    lblLesseeName.setFont(lblLesseeName.getFont().deriveFont(lblLesseeName.getFont().getSize() + 1f));
                    nonclientLesseePanel.add(lblLesseeName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _LesseeName ----
                    _LesseeName.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    nonclientLesseePanel.add(_LesseeName, new GridBagConstraints(1, 0, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- lblLesseeAddress ----
                    lblLesseeAddress.setText("Address");
                    lblLesseeAddress.setFont(lblLesseeAddress.getFont().deriveFont(lblLesseeAddress.getFont().getSize() + 1f));
                    nonclientLesseePanel.add(lblLesseeAddress, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _LesseeAddress ----
                    _LesseeAddress.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    nonclientLesseePanel.add(_LesseeAddress, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- lblLesseeCity ----
                    lblLesseeCity.setText("City");
                    lblLesseeCity.setFont(lblLesseeCity.getFont().deriveFont(lblLesseeCity.getFont().getSize() + 1f));
                    nonclientLesseePanel.add(lblLesseeCity, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- _LesseeCity ----
                    _LesseeCity.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    nonclientLesseePanel.add(_LesseeCity, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- lblLesseeState ----
                    lblLesseeState.setText("State");
                    lblLesseeState.setFont(lblLesseeState.getFont().deriveFont(lblLesseeState.getFont().getSize() + 1f));
                    nonclientLesseePanel.add(lblLesseeState, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 15, 10, 5), 0, 0));

                    //---- _LesseeState ----
                    _LesseeState.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    nonclientLesseePanel.add(_LesseeState, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- lblLesseeZipCode ----
                    lblLesseeZipCode.setText("Zip Code");
                    lblLesseeZipCode.setFont(lblLesseeZipCode.getFont().deriveFont(lblLesseeZipCode.getFont().getSize() + 1f));
                    nonclientLesseePanel.add(lblLesseeZipCode, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- _LesseeZipCode ----
                    _LesseeZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    nonclientLesseePanel.add(_LesseeZipCode, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPanel.add(nonclientLesseePanel, new GridBagConstraints(0, 15, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- _AddLegalDescription ----
                _AddLegalDescription.setText("Add Leased Legal Description");
                _AddLegalDescription.setActionCommand(Actions.ADDLEGALDESCRIPTION.name());
                contentPanel.add(_AddLegalDescription, new GridBagConstraints(1, 16, 3, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //======== leasedDescriptionPanel ========
                {
                    leasedDescriptionPanel.setPreferredSize(new Dimension(0, 167));
                    leasedDescriptionPanel.setBorder(new EtchedBorder());
                    leasedDescriptionPanel.setLayout(new GridLayout());
                }
                contentPanel.add(leasedDescriptionPanel, new GridBagConstraints(0, 17, 4, 1, 0.0, 0.0,
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

                //---- _SaveButton ----
                _SaveButton.setText("Save");
                _SaveButton.setActionCommand(Actions.SAVECONTENTS.name());
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
    private JTextField _dbRecordID;
    private JLabel lblLeaseholdID;
    private JTextField _LeaseholdID;
    private JLabel lblOOPEffectiveDate;
    private JTextField _OOPEffectiveDate;
    private JLabel lblRoyalty;
    private JTextField _Royalty;
    private JLabel lblBonusPNMA;
    private JTextField _BonusPNMA;
    private JLabel lblPrimaryTerm;
    private JTextField _PrimaryTerm;
    private JLabel lblPaymentTerms;
    private JTextField _PaymentTerms;
    private JLabel lblPrimaryTermExpiration;
    private JTextField _PrimaryTermExpiration;
    private JLabel lblPaymentDueDate;
    private JTextField _PaymentDueDate;
    private JLabel lblOptionalTerm;
    private JTextField _OptionalTerm;
    private JLabel lblTotalBonusPayment;
    private JTextField _TotalBonusPayment;
    private JLabel lblOptionalTermExpiration;
    private JTextField _OptionalTermExpiration;
    private JLabel lblQueryMineralOwner;
    private JTextField _QueryName;
    private JButton _SearchName;
    private JLabel headerLessor;
    private JLabel lblLessorName;
    private JTextField _LessorName;
    private JLabel lblLessorAddress;
    private JTextField _LessorAddress;
    private JLabel lblLessorCity;
    private JTextField _LessorCity;
    private JLabel lblLessorState;
    private JTextField _LessorState;
    private JLabel lbLessorlZipCode;
    private JTextField _LessorZipCode;
    private JCheckBox _cbxClientLessee;
    private JPanel nonclientLesseePanel;
    private JLabel lblLesseeName;
    private JTextField _LesseeName;
    private JLabel lblLesseeAddress;
    private JTextField _LesseeAddress;
    private JLabel lblLesseeCity;
    private JTextField _LesseeCity;
    private JLabel lblLesseeState;
    private JTextField _LesseeState;
    private JLabel lblLesseeZipCode;
    private JTextField _LesseeZipCode;
    private JButton _AddLegalDescription;
    private JPanel leasedDescriptionPanel;
    private JPanel buttonBar;
    private JButton _SaveButton;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JTextField getDbRecordID() {
        return _dbRecordID;
    }

    public void setDbRecordID(JTextField _dbRecordID) {
        this._dbRecordID = _dbRecordID;
    }

    public JTextField getLeaseholdID() {
        return _LeaseholdID;
    }

    public void setLeaseholdID(JTextField _LeaseholdID) {
        this._LeaseholdID = _LeaseholdID;
    }

    public JTextField getOOPEffectiveDate() {
        return _OOPEffectiveDate;
    }

    public void setOOPEffectiveDate(JTextField _OOPEffectiveDate) {
        this._OOPEffectiveDate = _OOPEffectiveDate;
    }

    public JTextField getRoyalty() {
        return _Royalty;
    }

    public void setRoyalty(JTextField _Royalty) {
        this._Royalty = _Royalty;
    }

    public JTextField getBonusPNMA() {
        return _BonusPNMA;
    }

    public void setBonusPNMA(JTextField _BonusPNMA) {
        this._BonusPNMA = _BonusPNMA;
    }

    public JTextField getPrimaryTerm() {
        return _PrimaryTerm;
    }

    public void setPrimaryTerm(JTextField _PrimaryTerm) {
        this._PrimaryTerm = _PrimaryTerm;
    }

    public JTextField getPaymentTerms() {
        return _PaymentTerms;
    }

    public void setPaymentTerms(JTextField _PaymentTerms) {
        this._PaymentTerms = _PaymentTerms;
    }

    public JTextField getPrimaryTermExpiration() {
        return _PrimaryTermExpiration;
    }

    public void setPrimaryTermExpiration(JTextField _PrimaryTermExpiration) {
        this._PrimaryTermExpiration = _PrimaryTermExpiration;
    }

    public JTextField getPaymentDueDate() {
        return _PaymentDueDate;
    }

    public void setPaymentDueDate(JTextField _PaymentDueDate) {
        this._PaymentDueDate = _PaymentDueDate;
    }

    public JTextField getOptionalTerm() {
        return _OptionalTerm;
    }

    public void setOptionalTerm(JTextField _OptionalTerm) {
        this._OptionalTerm = _OptionalTerm;
    }

    public JTextField getTotalBonusPayment() {
        return _TotalBonusPayment;
    }

    public void setTotalBonusPayment(JTextField _TotalBonusPayment) {
        this._TotalBonusPayment = _TotalBonusPayment;
    }

    public JTextField getOptionalTermExpiration() {
        return _OptionalTermExpiration;
    }

    public void setOptionalTermExpiration(JTextField _OptionalTermExpiration) {
        this._OptionalTermExpiration = _OptionalTermExpiration;
    }

    public JTextField getQueryName() {
        return _QueryName;
    }

    public void setQueryName(JTextField _QueryName) {
        this._QueryName = _QueryName;
    }

    public JTextField getLessorName() {
        return _LessorName;
    }

    public void setLessorName(JTextField _LessorName) {
        this._LessorName = _LessorName;
    }

    public JTextField getLessorAddress() {
        return _LessorAddress;
    }

    public void setLessorAddress(JTextField _LessorAddress) {
        this._LessorAddress = _LessorAddress;
    }

    public JTextField getLessorCity() {
        return _LessorCity;
    }

    public void setLessorCity(JTextField _LessorCity) {
        this._LessorCity = _LessorCity;
    }

    public JTextField getLessorState() {
        return _LessorState;
    }

    public void setLessorState(JTextField _LessorState) {
        this._LessorState = _LessorState;
    }

    public JTextField getLessorZipCode() {
        return _LessorZipCode;
    }

    public void setLessorZipCode(JTextField _LessorZipCode) {
        this._LessorZipCode = _LessorZipCode;
    }

    public JCheckBox getCbxClientLessee() {
        return _cbxClientLessee;
    }

    public void setCbxClientLessee(JCheckBox _cbxClientLessee) {
        this._cbxClientLessee = _cbxClientLessee;
    }

    public JTextField getLesseeName() {
        return _LesseeName;
    }

    public void setLesseeName(JTextField _LesseeName) {
        this._LesseeName = _LesseeName;
    }

    public JTextField getLesseeAddress() {
        return _LesseeAddress;
    }

    public void setLesseeAddress(JTextField _LesseeAddress) {
        this._LesseeAddress = _LesseeAddress;
    }

    public JTextField getLesseeCity() {
        return _LesseeCity;
    }

    public void setLesseeCity(JTextField _LesseeCity) {
        this._LesseeCity = _LesseeCity;
    }

    public JTextField getLesseeState() {
        return _LesseeState;
    }

    public void setLesseeState(JTextField _LesseeState) {
        this._LesseeState = _LesseeState;
    }

    public JTextField getLesseeZipCode() {
        return _LesseeZipCode;
    }

    public void setLesseeZipCode(JTextField _LesseeZipCode) {
        this._LesseeZipCode = _LesseeZipCode;
    }

}
