package swe482_Main;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ChangeEvent;

/**
 * @author Michael Barth UC-002 UC002View Design Implementing XUC-005, XUC-006,
 * XUC-007 Implementing XUC-008 (Under Construction) UC002View implementing
 * JDialog ModalityType.DOCUMENT_MODAL
 */
public class UC002View extends javax.swing.JFrame implements java.util.Observer {

    /*
    * UC-002 Add Paid-up Lease
    * XUC-005 Insert Order of Payment
    *   Order of Payment Effective Date
    *   Payment Terms (e.g. 60 days)
    *   Bonus per Acre (e.g. $150)
    *   Alternative Payee than Lessor
    * XUC-006 Insert Paid-up Lease Key Details
    *   Lease Effective Date
    *   Primary Term
    *   Secondary Term
    *   Royalty
    *   Lessor (e.g. Name, Address, etc.)
    *   Lessor (e.g. Name only)
    * XUC-007 Create/Link Leased Lands
    *   Add Placement Property Description
    *   Select Queried Property Descriptions
    *   
     */
    UC002View() {
        buildGUI();
    }

    @Override
    public void update(Observable obs, Object obj) {
        System.out.println("View : Observable is "
                + obj.getClass() + ", object passed is "
                + obj.getClass());
    }

    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
        }
    }

    void addController(ActionListener controller) {
        uc002_SaveButton.addActionListener(controller);
        uc002_CancelButton.addActionListener(controller);
        xuc007_AddProperty.addActionListener(controller);
        uc002_FindLessor.addActionListener(controller);
        xuc007_CloseAddProperty.addActionListener(controller);
        xuc007_InsertProperty.addActionListener(controller);
        xuc007_SearchProperty.addActionListener(controller);

    }
    
    void addButtonController(ActionListener controller, JButton button){
        button.addActionListener(controller);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.xuc005_cbxAlternativePayee);
        hash = 71 * hash + Objects.hashCode(this.xuc005_AlternatePayee);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UC002View other = (UC002View) obj;
        return true;
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
        EDIT_PROPERTY
    }

    private JFrame fUC002;
    private JPanel dpUC002;     // Replaces IDE JPanel
    /*
    *   XUC-007 Dialog
     */

    private JDialog dXUC007;
    private JPanel dpXUC007;    // Replaces IDE JPanel

//    private JPanel dpXUC007;    // Replaces IDE uc002DialogPane
//    private JPanel dpdXUC007;   // Replaces IDE uc002DialogPane
    private void buildGUI() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Insets ins = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        int sw = gc.getBounds().width - ins.left - ins.right;
        int sh = gc.getBounds().height - ins.top - ins.bottom;
        /*
        *   UC-002 Frame
         */
        fUC002 = new JFrame();
        JPanel pUC002 = new JPanel();
//        START Requires JPanel Form Insertion
        dpUC002 = new JPanel();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        uc002_contentPane = new JPanel();
        xuc005_lblOOPDate = new JLabel();
        uc002_lblLeaseDate = new JLabel();
        Xuc005_lblBPA = new JLabel();
        uc002_lblRoyalty = new JLabel();
        uc002_lblPrimaryTerm = new JLabel();
        xuc005_lblPaymentTerms = new JLabel();
        xuc005_lblBonusSubtotal = new JLabel();
        uc002_lblSecondaryTerm = new JLabel();
        xuc005_lblAlternativePayee = new JLabel();
        uc002_lblLessor = new JLabel();
        uc002_lblAddress = new JLabel();
        uc002_lblCity = new JLabel();
        uc002_lblState = new JLabel();
        uc002_lblZipCode = new JLabel();
        uc002_lblLessee = new JLabel();
        xuc007_lblLeasedLegalDescriptions = new JLabel();

        xuc005_OOPDate = new JTextField();
        uc002_LeaseDate = new JTextField();
        xuc005_BPA = new JTextField();
        uc002_Royalty = new JTextField();
        xuc005_PaymentTerms = new JTextField();
        uc002_PrimaryTerm = new JTextField();
        xuc005_BonusSubtotal = new JTextField();
        uc002_SecondaryTerm = new JTextField();
        xuc005_AlternatePayee = new JTextField();
        uc002_Lessor = new JTextField();
        uc002_Address = new JTextField();
        uc002_City = new JTextField();
        uc002_State = new JTextField();
        uc002_ZipCode = new JTextField();
        uc002_Lessee = new JTextField();

        xuc007_scrollPanel = new JScrollPane();
        xuc007Pane_LeasedProperty = new JPanel();
        uc002_ButtonBar = new JPanel();
        xuc005_cbxAlternativePayee = new JCheckBox();
        uc002_FindLessor = new JButton();
        uc002_FindLessor.setActionCommand(UserActions.SEARCH_PERSON.name());
        uc002_FindLessor.setVisible(false);  /// FUTURE ENHANCEMENT
        xuc007_AddProperty = new JButton();
        xuc007_AddProperty.setActionCommand(UserActions.OPEN_ADDPROPERTY.name());
        uc002_SaveButton = new JButton();
        uc002_SaveButton.setActionCommand(UserActions.SAVE_LEASE.name());
        uc002_CancelButton = new JButton();
        uc002_CancelButton.setActionCommand(UserActions.CLOSE_LEASE.name());

        //======== this ========
        dpUC002.setBorder(new EmptyBorder(12, 12, 12, 12));
        dpUC002.setLayout(new BorderLayout());

        //======== uc002_contentPane ========
        {
            uc002_contentPane.setMinimumSize(new Dimension(600, 468));
            uc002_contentPane.setLayout(new GridBagLayout());

            ((GridBagLayout) uc002_contentPane.getLayout()).columnWidths = new int[]{72, 72, 72, 72, 72, 72, 72, 67, 0};
            ((GridBagLayout) uc002_contentPane.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 77, 0, 0};
            ((GridBagLayout) uc002_contentPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout) uc002_contentPane.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

            //---- xuc005_lblOOPDate ----
            xuc005_lblOOPDate.setText("Effective Date (OOP)");
            xuc005_lblOOPDate.setFont(xuc005_lblOOPDate.getFont().deriveFont(xuc005_lblOOPDate.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_lblOOPDate, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc005_OOPDate ----
            xuc005_OOPDate.setFont(xuc005_OOPDate.getFont().deriveFont(xuc005_OOPDate.getFont().getSize() + 1f));
            xuc005_OOPDate.setAutoscrolls(false);
            uc002_contentPane.add(xuc005_OOPDate, new GridBagConstraints(2, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblLeaseDate ----
            uc002_lblLeaseDate.setText("Lease Effective Date");
            uc002_lblLeaseDate.setFont(uc002_lblLeaseDate.getFont().deriveFont(uc002_lblLeaseDate.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblLeaseDate, new GridBagConstraints(4, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_LeaseDate ----
            uc002_LeaseDate.setFont(uc002_LeaseDate.getFont().deriveFont(uc002_LeaseDate.getFont().getSize() + 1f));
            uc002_LeaseDate.setAutoscrolls(false);
            uc002_contentPane.add(uc002_LeaseDate, new GridBagConstraints(6, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- Xuc005_lblBPA ----
            Xuc005_lblBPA.setText("Bonus per Acre (BPA)");
            Xuc005_lblBPA.setFont(Xuc005_lblBPA.getFont().deriveFont(Xuc005_lblBPA.getFont().getSize() + 1f));
            uc002_contentPane.add(Xuc005_lblBPA, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc005_BPA ----
            xuc005_BPA.setFont(xuc005_BPA.getFont().deriveFont(xuc005_BPA.getFont().getSize() + 1f));
            xuc005_BPA.setAutoscrolls(false);
            uc002_contentPane.add(xuc005_BPA, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblRoyalty ----
            uc002_lblRoyalty.setText("Royalty");
            uc002_lblRoyalty.setFont(uc002_lblRoyalty.getFont().deriveFont(uc002_lblRoyalty.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblRoyalty, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_Royalty ----
            uc002_Royalty.setFont(uc002_Royalty.getFont().deriveFont(uc002_Royalty.getFont().getSize() + 1f));
            uc002_Royalty.setAutoscrolls(false);
            uc002_contentPane.add(uc002_Royalty, new GridBagConstraints(6, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- xuc005_lblPaymentTerms ----
            xuc005_lblPaymentTerms.setText("Payment Terms");
            xuc005_lblPaymentTerms.setFont(xuc005_lblPaymentTerms.getFont().deriveFont(xuc005_lblPaymentTerms.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_lblPaymentTerms, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc005_PaymentTerms ----
            xuc005_PaymentTerms.setFont(xuc005_PaymentTerms.getFont().deriveFont(xuc005_PaymentTerms.getFont().getSize() + 1f));
            xuc005_PaymentTerms.setAutoscrolls(false);
            uc002_contentPane.add(xuc005_PaymentTerms, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblPrimaryTerm ----
            uc002_lblPrimaryTerm.setText("Primary Term");
            uc002_lblPrimaryTerm.setFont(uc002_lblPrimaryTerm.getFont().deriveFont(uc002_lblPrimaryTerm.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblPrimaryTerm, new GridBagConstraints(4, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_PrimaryTerm ----
            uc002_PrimaryTerm.setFont(uc002_PrimaryTerm.getFont().deriveFont(uc002_PrimaryTerm.getFont().getSize() + 1f));
            uc002_PrimaryTerm.setAutoscrolls(false);
            uc002_contentPane.add(uc002_PrimaryTerm, new GridBagConstraints(6, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- xuc005_lblBonusSubtotal ----
            xuc005_lblBonusSubtotal.setText("Bonus Pmt. Subtotal");
            xuc005_lblBonusSubtotal.setFont(xuc005_lblBonusSubtotal.getFont().deriveFont(xuc005_lblBonusSubtotal.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_lblBonusSubtotal, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc005_BonusSubtotal ----
            xuc005_BonusSubtotal.setFont(xuc005_BonusSubtotal.getFont().deriveFont(xuc005_BonusSubtotal.getFont().getSize() + 1f));
            xuc005_BonusSubtotal.setAutoscrolls(false);
            uc002_contentPane.add(xuc005_BonusSubtotal, new GridBagConstraints(2, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblSecondaryTerm ----
            uc002_lblSecondaryTerm.setText("Secondary Term");
            uc002_lblSecondaryTerm.setFont(uc002_lblSecondaryTerm.getFont().deriveFont(uc002_lblSecondaryTerm.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblSecondaryTerm, new GridBagConstraints(4, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_SecondaryTerm ----
            uc002_SecondaryTerm.setFont(uc002_SecondaryTerm.getFont().deriveFont(uc002_SecondaryTerm.getFont().getSize() + 1f));
            uc002_SecondaryTerm.setAutoscrolls(false);
            uc002_contentPane.add(uc002_SecondaryTerm, new GridBagConstraints(6, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- xuc005_cbxAlternativePayee ----
            xuc005_cbxAlternativePayee.setText("Alternate Non-Lessor Payee?");
            xuc005_cbxAlternativePayee.setFont(xuc005_cbxAlternativePayee.getFont().deriveFont(xuc005_cbxAlternativePayee.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_cbxAlternativePayee, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
            xuc005_cbxAlternativePayee.addChangeListener((ChangeEvent e) -> {
                        if(xuc005_cbxAlternativePayee.isSelected()){
                            xuc005_AlternatePayee.setEditable(true);
                        } else {
                            xuc005_AlternatePayee.setEditable(false);
                        }
                    });

            //---- xuc005_lblAlternativePayee ----
            xuc005_lblAlternativePayee.setText("Alternate Payee");
            xuc005_lblAlternativePayee.setFont(xuc005_lblAlternativePayee.getFont().deriveFont(xuc005_lblAlternativePayee.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_lblAlternativePayee, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

            //---- xuc005_AlternatePayee ----
            xuc005_AlternatePayee.setFont(xuc005_AlternatePayee.getFont().deriveFont(xuc005_AlternatePayee.getFont().getSize() + 1f));
            xuc005_AlternatePayee.setAutoscrolls(false);
            xuc005_AlternatePayee.setEditable(false);
            uc002_contentPane.add(xuc005_AlternatePayee, new GridBagConstraints(2, 6, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

            //---- uc002_FindLessor ----
            uc002_FindLessor.setText("Add");
            uc002_contentPane.add(uc002_FindLessor, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblLessor ----
            uc002_lblLessor.setText("Lessor");
            uc002_lblLessor.setFont(uc002_lblLessor.getFont().deriveFont(uc002_lblLessor.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblLessor, new GridBagConstraints(1, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_Lessor ----
            uc002_Lessor.setFont(uc002_Lessor.getFont().deriveFont(uc002_Lessor.getFont().getSize() + 1f));
            uc002_Lessor.setAutoscrolls(false);
            uc002_contentPane.add(uc002_Lessor, new GridBagConstraints(2, 7, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- uc002_lblAddress ----
            uc002_lblAddress.setText("Address");
            uc002_lblAddress.setFont(uc002_lblAddress.getFont().deriveFont(uc002_lblAddress.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblAddress, new GridBagConstraints(1, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_Address ----
            uc002_Address.setFont(uc002_Address.getFont().deriveFont(uc002_Address.getFont().getSize() + 1f));
            uc002_Address.setAutoscrolls(false);
            uc002_contentPane.add(uc002_Address, new GridBagConstraints(2, 8, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- uc002_lblCity ----
            uc002_lblCity.setText("City");
            uc002_lblCity.setFont(uc002_lblCity.getFont().deriveFont(uc002_lblCity.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblCity, new GridBagConstraints(1, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_City ----
            uc002_City.setFont(uc002_City.getFont().deriveFont(uc002_City.getFont().getSize() + 1f));
            uc002_City.setAutoscrolls(false);
            uc002_contentPane.add(uc002_City, new GridBagConstraints(2, 9, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblState ----
            uc002_lblState.setText("State");
            uc002_lblState.setFont(uc002_lblState.getFont().deriveFont(uc002_lblState.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblState, new GridBagConstraints(4, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_State ----
            uc002_State.setFont(uc002_State.getFont().deriveFont(uc002_State.getFont().getSize() + 1f));
            uc002_State.setAutoscrolls(false);
            uc002_contentPane.add(uc002_State, new GridBagConstraints(5, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblZipCode ----
            uc002_lblZipCode.setText("Zip Code");
            uc002_lblZipCode.setFont(uc002_lblZipCode.getFont().deriveFont(uc002_lblZipCode.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblZipCode, new GridBagConstraints(6, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_ZipCode ----
            uc002_ZipCode.setFont(uc002_ZipCode.getFont().deriveFont(uc002_ZipCode.getFont().getSize() + 1f));
            uc002_ZipCode.setAutoscrolls(false);
            uc002_contentPane.add(uc002_ZipCode, new GridBagConstraints(7, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- uc002_lblLessee ----
            uc002_lblLessee.setText("Lessee");
            uc002_lblLessee.setFont(uc002_lblLessee.getFont().deriveFont(uc002_lblLessee.getFont().getSize() + 1f));
            uc002_contentPane.add(uc002_lblLessee, new GridBagConstraints(1, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 10, 5), 0, 0));

            //---- uc002_Lessee ----
            uc002_Lessee.setFont(uc002_Lessee.getFont().deriveFont(uc002_Lessee.getFont().getSize() + 1f));
            uc002_Lessee.setAutoscrolls(false);
            uc002_contentPane.add(uc002_Lessee, new GridBagConstraints(2, 10, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 10, 0), 0, 0));

            //---- xuc007_AddProperty ----
            xuc007_AddProperty.setText("Add");
            uc002_contentPane.add(xuc007_AddProperty, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc007_lblLeasedLegalDescriptions ----
            xuc007_lblLeasedLegalDescriptions.setText("Leased Legal Descriptions");
            xuc007_lblLeasedLegalDescriptions.setFont(xuc007_lblLeasedLegalDescriptions.getFont().deriveFont(xuc007_lblLeasedLegalDescriptions.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc007_lblLeasedLegalDescriptions, new GridBagConstraints(1, 11, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //======== xuc007_scrollPanel ========
            {

                //======== xuc007Pane_LeasedProperty ========
                {
                    xuc007Pane_LeasedProperty.setAutoscrolls(true);
                    xuc007Pane_LeasedProperty.setLayout(new GridBagLayout());
                    ((GridBagLayout) xuc007Pane_LeasedProperty.getLayout()).columnWidths = new int[]{0, 0};
                    ((GridBagLayout) xuc007Pane_LeasedProperty.getLayout()).rowHeights = new int[]{0, 0};
                    ((GridBagLayout) xuc007Pane_LeasedProperty.getLayout()).columnWeights = new double[]{1.0, 1.0E-4};
                    ((GridBagLayout) xuc007Pane_LeasedProperty.getLayout()).rowWeights = new double[]{1.0, 1.0E-4};
                }
                xuc007_scrollPanel.setViewportView(xuc007Pane_LeasedProperty);
            }

            uc002_contentPane.add(xuc007_scrollPanel, new GridBagConstraints(0, 12, 8, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //======== uc002_ButtonBar ========
            {
                uc002_ButtonBar.setLayout(new GridLayout(1, 2));

                //---- uc002_SaveButton ----
                uc002_SaveButton.setText("SAVE");
                uc002_ButtonBar.add(uc002_SaveButton);

                //---- uc002_CancelButton ----
                uc002_CancelButton.setText("CANCEL");
                uc002_ButtonBar.add(uc002_CancelButton);
            }
            uc002_contentPane.add(uc002_ButtonBar, new GridBagConstraints(6, 13, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(10, 0, 10, 0), 0, 0));
        }
        dpUC002.add(uc002_contentPane, BorderLayout.CENTER);
        dpUC002.add(uc002_ButtonBar, BorderLayout.SOUTH);
        dpUC002.setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
//        END JPanel Form Insertion
        pUC002.add(dpUC002);
        fUC002.add(pUC002);
        fUC002.setMinimumSize(new Dimension(650, 520));
        fUC002.setVisible(true);
        fUC002.setLocationRelativeTo(getOwner());

        /*
        *   XUC-007 Dialog: Add Untitled Property
        *   DOCUMENT_MODAL to UC-002 Frame
         */
        dXUC007 = new JDialog(fUC002, null, Dialog.ModalityType.DOCUMENT_MODAL);
        dXUC007.setSize(460, 350);
        Container cpXUC007 = dXUC007.getContentPane();
        cpXUC007.setLayout(new BorderLayout());
        JPanel pdXUC007 = new JPanel();
//        START Requires JPanel Form Insertion
        dpXUC007 = new JPanel();
        xuc007_dialogPane = new JPanel();
        xuc007_contentPanel = new JPanel();
        xuc007_paneProperty = new JPanel();
        xuc007_lblParcelID = new JLabel();
        xuc007_lblTownship = new JLabel();
        xuc007_lblTaxMapID = new JLabel();
        xuc007_lblRange = new JLabel();
        xuc007_lblCounty = new JLabel();
        xuc007_lblState = new JLabel();
        xuc007_lblMeridian = new JLabel();
        xuc007_lblSection = new JLabel();
        xuc007_lblAcreage = new JLabel();
        xuc007_lblLegalDescription = new JLabel();
        xuc007_lblNorthBounder = new JLabel();
        xuc007_lblEastBounder = new JLabel();
        xuc007_lblSouthBounder = new JLabel();
        xuc007_lblWestBounder = new JLabel();

        xuc007_ParcelID = new JTextField(null);
        xuc007_Township = new JTextField(null);
        xuc007_TaxMapID = new JTextField(null);
        xuc007_Range = new JTextField(null);
        xuc007_County = new JTextField(null);
        xuc007_Section = new JTextField(null);
        xuc007_State = new JTextField(null);
        xuc007_Meridian = new JTextField(null);
        xuc007_Acreage = new JTextField(null);

        xuc007_scrollPane = new JScrollPane();
        xuc007_LegalDescription = new JTextArea();
        xuc007_LegalDescription.setText(null);

        xuc007_cbxBounders = new JCheckBox();
        xuc007_paneBounders = new JPanel();
        xuc007_NorthBounder = new JTextField();
        xuc007_EastBounder = new JTextField();
        xuc007_SouthBounder = new JTextField();
        xuc007_WestBounder = new JTextField();

        xuc007_ButtonBar = new JPanel();
        xuc007_SearchProperty = new JButton();
        xuc007_SearchProperty.setVisible(false); // FUTURE ENHANCEMENT
        xuc007_InsertProperty = new JButton();
        xuc007_CloseAddProperty = new JButton();

        //======== this ========
        setType(Window.Type.POPUP);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== xuc007_dialogPane ========
        {
            xuc007_dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            xuc007_dialogPane.setAutoscrolls(true);
            xuc007_dialogPane.setMinimumSize(null);
            xuc007_dialogPane.setPreferredSize(null);
            xuc007_dialogPane.setLayout(new GridBagLayout());
            ((GridBagLayout) xuc007_dialogPane.getLayout()).columnWidths = new int[]{0, 0, 0};
            ((GridBagLayout) xuc007_dialogPane.getLayout()).rowHeights = new int[]{0, 0, 0};
            ((GridBagLayout) xuc007_dialogPane.getLayout()).columnWeights = new double[]{0.0, 1.0, 1.0E-4};
            ((GridBagLayout) xuc007_dialogPane.getLayout()).rowWeights = new double[]{1.0, 0.0, 1.0E-4};

            //======== xuc007_contentPanel ========
            {
                xuc007_contentPanel.setPreferredSize(new Dimension(600, 375));
                xuc007_contentPanel.setLayout(null);

                //======== xuc007_paneProperty ========
                {
                    xuc007_paneProperty.setPreferredSize(null);
                    xuc007_paneProperty.setLayout(new GridBagLayout());
                    ((GridBagLayout) xuc007_paneProperty.getLayout()).columnWidths = new int[]{155, 155, 155, 150, 0};
                    ((GridBagLayout) xuc007_paneProperty.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout) xuc007_paneProperty.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) xuc007_paneProperty.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                    //---- xuc007_lblParcelID ----
                    xuc007_lblParcelID.setText("Parcel Number");
                    xuc007_lblParcelID.setFont(xuc007_lblParcelID.getFont().deriveFont(xuc007_lblParcelID.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblParcelID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_ParcelID ----
//                    xuc007_ParcelID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_ParcelID.setAutoscrolls(false);
                    xuc007_ParcelID.setFont(xuc007_ParcelID.getFont().deriveFont(xuc007_ParcelID.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_ParcelID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_lblTownship ----
                    xuc007_lblTownship.setText("Township");
                    xuc007_lblTownship.setFont(xuc007_lblTownship.getFont().deriveFont(xuc007_lblTownship.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblTownship, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 5, 10, 5), 0, 0));

                    //---- xuc007_Township ----
//                    xuc007_Township.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_Township.setFont(xuc007_Township.getFont().deriveFont(xuc007_Township.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_Township, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc007_lblTaxMapID ----
                    xuc007_lblTaxMapID.setText("Tax Map Identification");
                    xuc007_lblTaxMapID.setFont(xuc007_lblTaxMapID.getFont().deriveFont(xuc007_lblTaxMapID.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblTaxMapID, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_TaxMapID ----
//                    xuc007_TaxMapID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_TaxMapID.setAutoscrolls(false);
                    xuc007_TaxMapID.setFont(xuc007_TaxMapID.getFont().deriveFont(xuc007_TaxMapID.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_TaxMapID, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_lblRange ----
                    xuc007_lblRange.setText("Range");
                    xuc007_lblRange.setFont(xuc007_lblRange.getFont().deriveFont(xuc007_lblRange.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblRange, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 5, 10, 5), 0, 0));

                    //---- xuc007_Range ----
//                    xuc007_Range.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_Range.setFont(xuc007_Range.getFont().deriveFont(xuc007_Range.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_Range, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc007_lblCounty ----
                    xuc007_lblCounty.setText("County");
                    xuc007_lblCounty.setFont(xuc007_lblCounty.getFont().deriveFont(xuc007_lblCounty.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblCounty, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_County ----
//                    xuc007_County.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_County.setAutoscrolls(false);
                    xuc007_County.setFont(xuc007_County.getFont().deriveFont(xuc007_County.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_County, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_lblSection ----
                    xuc007_lblSection.setText("Section");
                    xuc007_lblSection.setFont(xuc007_lblSection.getFont().deriveFont(xuc007_lblSection.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblSection, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 5, 10, 5), 0, 0));

                    //---- xuc007_Section ----
//                    xuc007_Section.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_Section.setFont(xuc007_Section.getFont().deriveFont(xuc007_Section.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_Section, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc007_lblState ----
                    xuc007_lblState.setText("State");
                    xuc007_lblState.setFont(xuc007_lblState.getFont().deriveFont(xuc007_lblState.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblState, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_State ----
//                    xuc007_State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_State.setAutoscrolls(false);
                    xuc007_State.setFont(xuc007_State.getFont().deriveFont(xuc007_State.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_State, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_lblMeridian ----
                    xuc007_lblMeridian.setText("Principal Meridian:");
                    xuc007_lblMeridian.setFont(xuc007_lblMeridian.getFont().deriveFont(xuc007_lblMeridian.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblMeridian, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 5, 10, 5), 0, 0));

                    //---- xuc007_Meridian ----
//                    xuc007_Meridian.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_Meridian.setFont(xuc007_Meridian.getFont().deriveFont(xuc007_Meridian.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_Meridian, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc007_lblAcreage ----
                    xuc007_lblAcreage.setText("Acreage:");
                    xuc007_lblAcreage.setFont(xuc007_lblAcreage.getFont().deriveFont(xuc007_lblAcreage.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblAcreage, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_Acreage ----
//                    xuc007_Acreage.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_Acreage.setAutoscrolls(false);
                    xuc007_Acreage.setFont(xuc007_Acreage.getFont().deriveFont(xuc007_Acreage.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(xuc007_Acreage, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc007_lblLegalDescription ----
                    xuc007_lblLegalDescription.setText("Property Description:");
                    xuc007_lblLegalDescription.setFont(xuc007_lblLegalDescription.getFont().deriveFont(xuc007_lblLegalDescription.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblLegalDescription, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //======== xuc007_scrollPane ========
                    {

                        //---- xuc007_LegalDescription ----
                        xuc007_LegalDescription.setMinimumSize(new Dimension(4, 67));
                        xuc007_LegalDescription.setPreferredSize(new Dimension(4, 67));
                        xuc007_LegalDescription.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_LegalDescription.setAutoscrolls(false);
                        xuc007_LegalDescription.setLineWrap(true);
                        xuc007_LegalDescription.setWrapStyleWord(true);
                        xuc007_LegalDescription.setFont(xuc007_LegalDescription.getFont().deriveFont(xuc007_LegalDescription.getFont().getSize() + 1f));
                        xuc007_scrollPane.setViewportView(xuc007_LegalDescription);
                    }
                    xuc007_paneProperty.add(xuc007_scrollPane, new GridBagConstraints(0, 6, 4, 3, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc007_cbxBounders ----
                    xuc007_cbxBounders.setText("Property Bounders");
                    xuc007_cbxBounders.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc007_cbxBounders.addChangeListener((ChangeEvent e) -> {
                        if(xuc007_cbxBounders.isSelected()){
                            xuc007_NorthBounder.setEditable(true);
                            xuc007_EastBounder.setEditable(true);
                            xuc007_SouthBounder.setEditable(true);
                            xuc007_WestBounder.setEditable(true);
                        } else {
                            xuc007_NorthBounder.setEditable(false);
                            xuc007_EastBounder.setEditable(false);
                            xuc007_SouthBounder.setEditable(false);
                            xuc007_WestBounder.setEditable(false);
                        }
                    });
                    xuc007_cbxBounders.setFont(xuc007_cbxBounders.getFont().deriveFont(xuc007_cbxBounders.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_cbxBounders, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //======== xuc007_paneBounders ========
                    {
                        xuc007_paneBounders.setLayout(new GridBagLayout());
                        ((GridBagLayout) xuc007_paneBounders.getLayout()).columnWidths = new int[]{0, 0, 0, 0, 0};
                        ((GridBagLayout) xuc007_paneBounders.getLayout()).rowHeights = new int[]{0, 25, 0};
                        ((GridBagLayout) xuc007_paneBounders.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0E-4};
                        ((GridBagLayout) xuc007_paneBounders.getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0E-4};

                        //---- xuc007_lblNorthBounder ----
                        xuc007_lblNorthBounder.setText("North Bounder");
                        xuc007_lblNorthBounder.setFont(xuc007_lblNorthBounder.getFont().deriveFont(xuc007_lblNorthBounder.getFont().getSize() + 2f));
                        xuc007_paneBounders.add(xuc007_lblNorthBounder, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));

                        //---- xuc007_lblEastBounder ----
                        xuc007_lblEastBounder.setText("East Bounder");
                        xuc007_lblEastBounder.setFont(xuc007_lblEastBounder.getFont().deriveFont(xuc007_lblEastBounder.getFont().getSize() + 2f));
                        xuc007_paneBounders.add(xuc007_lblEastBounder, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));

                        //---- xuc007_lblSouthBounder ----
                        xuc007_lblSouthBounder.setText("South Bounder");
                        xuc007_lblSouthBounder.setFont(xuc007_lblSouthBounder.getFont().deriveFont(xuc007_lblSouthBounder.getFont().getSize() + 2f));
                        xuc007_paneBounders.add(xuc007_lblSouthBounder, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 5), 0, 0));

                        //---- xuc007_lblWestBounder ----
                        xuc007_lblWestBounder.setText("West Bounder");
                        xuc007_lblWestBounder.setFont(xuc007_lblWestBounder.getFont().deriveFont(xuc007_lblWestBounder.getFont().getSize() + 2f));
                        xuc007_paneBounders.add(xuc007_lblWestBounder, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                                new Insets(0, 0, 5, 0), 0, 0));

                        //---- xuc007_NorthBounder ----
                        xuc007_NorthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_NorthBounder.setAutoscrolls(false);
                        xuc007_NorthBounder.setEditable(false);
                        xuc007_NorthBounder.setFont(xuc007_NorthBounder.getFont().deriveFont(xuc007_NorthBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_NorthBounder, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_EastBounder ----
                        xuc007_EastBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_EastBounder.setAutoscrolls(false);
                        xuc007_EastBounder.setEditable(false);
                        xuc007_EastBounder.setFont(xuc007_EastBounder.getFont().deriveFont(xuc007_EastBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_EastBounder, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_SouthBounder ----
                        xuc007_SouthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_SouthBounder.setAutoscrolls(false);
                        xuc007_SouthBounder.setEditable(false);
                        xuc007_SouthBounder.setFont(xuc007_SouthBounder.getFont().deriveFont(xuc007_SouthBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_SouthBounder, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_WestBounder ----
                        xuc007_WestBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_WestBounder.setAutoscrolls(false);
                        xuc007_WestBounder.setEditable(false);
                        xuc007_WestBounder.setFont(xuc007_WestBounder.getFont().deriveFont(xuc007_WestBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_WestBounder, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                    }
                    xuc007_paneProperty.add(xuc007_paneBounders, new GridBagConstraints(0, 10, 4, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 10, 0), 0, 0));
                }
                xuc007_contentPanel.add(xuc007_paneProperty);
                xuc007_paneProperty.setBounds(new Rectangle(new Point(0, 0), xuc007_paneProperty.getPreferredSize()));

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for (int i = 0; i < xuc007_contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = xuc007_contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = xuc007_contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    xuc007_contentPanel.setMinimumSize(preferredSize);
                    xuc007_contentPanel.setPreferredSize(preferredSize);
                }
            }
            xuc007_dialogPane.add(xuc007_contentPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

            //======== xuc007_ButtonBar ========
            {
                xuc007_ButtonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                xuc007_ButtonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc007_ButtonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) xuc007_ButtonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- xuc007_SearchProperty ----
                xuc007_SearchProperty.setText("Property Verification");
                xuc007_SearchProperty.setActionCommand(UserActions.SEARCH_PROPERTY.name());
                xuc007_ButtonBar.add(xuc007_SearchProperty, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc007_InsertProperty ----
                xuc007_InsertProperty.setText("INSERT");
                xuc007_InsertProperty.setActionCommand(UserActions.INSERT_PROPERTY.name());
                xuc007_ButtonBar.add(xuc007_InsertProperty, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc007_CloseAddProperty ----
                xuc007_CloseAddProperty.setText("CLOSE");
                xuc007_CloseAddProperty.setActionCommand(UserActions.CLOSE_ADDPROPERTY.name());
                xuc007_ButtonBar.add(xuc007_CloseAddProperty, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc007_dialogPane.add(xuc007_ButtonBar, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(xuc007_dialogPane, BorderLayout.CENTER);
        dpXUC007.add(contentPane, BorderLayout.CENTER);
//        END JPanel Form Insertion
        pdXUC007.add(dpXUC007);
        cpXUC007.add(pdXUC007, BorderLayout.CENTER);
        dXUC007.setMinimumSize(new Dimension(680, 500));
    }

    private JPanel uc002_contentPane;
    private JLabel xuc005_lblOOPDate;
    private JTextField xuc005_OOPDate;
    private JLabel uc002_lblLeaseDate;
    private JTextField uc002_LeaseDate;
    private JLabel Xuc005_lblBPA;
    private JTextField xuc005_BPA;
    private JLabel uc002_lblRoyalty;
    private JTextField uc002_Royalty;
    private JLabel xuc005_lblPaymentTerms;
    private JTextField xuc005_PaymentTerms;
    private JLabel uc002_lblPrimaryTerm;
    private JTextField uc002_PrimaryTerm;
    private JLabel xuc005_lblBonusSubtotal;
    private JTextField xuc005_BonusSubtotal;
    private JLabel uc002_lblSecondaryTerm;
    private JTextField uc002_SecondaryTerm;
    private JCheckBox xuc005_cbxAlternativePayee;
    private JLabel xuc005_lblAlternativePayee;
    private JTextField xuc005_AlternatePayee;
    private JButton uc002_FindLessor;
    private JLabel uc002_lblLessor;
    private JTextField uc002_Lessor;
    private JLabel uc002_lblAddress;
    private JTextField uc002_Address;
    private JLabel uc002_lblCity;
    private JTextField uc002_City;
    private JLabel uc002_lblState;
    private JTextField uc002_State;
    private JLabel uc002_lblZipCode;
    private JTextField uc002_ZipCode;
    private JLabel uc002_lblLessee;
    private JTextField uc002_Lessee;
    private JButton xuc007_AddProperty;
    private JLabel xuc007_lblLeasedLegalDescriptions;
    private JScrollPane xuc007_scrollPanel;
    private JPanel xuc007Pane_LeasedProperty;
    private JPanel uc002_ButtonBar;
    private JButton uc002_SaveButton;
    private JButton uc002_CancelButton;

    private JPanel xuc007_dialogPane;
    private JPanel xuc007_contentPanel;
    private JPanel xuc007_paneProperty;
    private JLabel xuc007_lblParcelID;
    private JTextField xuc007_ParcelID;
    private JLabel xuc007_lblTownship;
    private JTextField xuc007_Township;
    private JLabel xuc007_lblTaxMapID;
    private JTextField xuc007_TaxMapID;
    private JLabel xuc007_lblRange;
    private JTextField xuc007_Range;
    private JLabel xuc007_lblCounty;
    private JTextField xuc007_County;
    private JLabel xuc007_lblSection;
    private JTextField xuc007_Section;
    private JLabel xuc007_lblState;
    private JTextField xuc007_State;
    private JLabel xuc007_lblMeridian;
    private JTextField xuc007_Meridian;
    private JLabel xuc007_lblAcreage;
    private JTextField xuc007_Acreage;
    private JLabel xuc007_lblLegalDescription;
    private JScrollPane xuc007_scrollPane;
    private JTextArea xuc007_LegalDescription;
    private JCheckBox xuc007_cbxBounders;
    private JPanel xuc007_paneBounders;
    private JLabel xuc007_lblNorthBounder;
    private JLabel xuc007_lblEastBounder;
    private JLabel xuc007_lblSouthBounder;
    private JLabel xuc007_lblWestBounder;
    private JTextField xuc007_NorthBounder;
    private JTextField xuc007_EastBounder;
    private JTextField xuc007_SouthBounder;
    private JTextField xuc007_WestBounder;
    private JPanel xuc007_ButtonBar;
    private JButton xuc007_SearchProperty;
    private JButton xuc007_InsertProperty;
    private JButton xuc007_CloseAddProperty;

    public String getXuc007_ParcelID() {
        return xuc007_ParcelID.getText();
    }

    public void setXuc007_ParcelID(String xuc007_ParcelID) {
        this.xuc007_ParcelID.setText(xuc007_ParcelID);
    }

    public String getXuc007_Township() {
        return xuc007_Township.getText();
    }

    public void setXuc007_Township(String xuc007_Township) {
        this.xuc007_Township.setText(xuc007_Township);
    }

    public String getXuc007_TaxMapID() {
        return xuc007_TaxMapID.getText();
    }

    public void setXuc007_TaxMapID(String xuc007_TaxMapID) {
        this.xuc007_TaxMapID.setText(xuc007_TaxMapID);
    }

    public String getXuc007_Range() {
        return xuc007_Range.getText();
    }

    public void setXuc007_Range(String xuc007_Range) {
        this.xuc007_Range.setText(xuc007_Range);
    }

    public String getXuc007_County() {
        return xuc007_County.getText();
    }

    public void setXuc007_County(String xuc007_County) {
        this.xuc007_County.setText(xuc007_County);
    }

    public String getXuc007_State() {
        return xuc007_State.getText();
    }

    public void setXuc007_State(String xuc007_State) {
        this.xuc007_State.setText(xuc007_State);
    }

    public String getXuc007_Meridian() {
        return xuc007_Meridian.getText();
    }

    public void setXuc007_Meridian(String xuc007_Meridian) {
        this.xuc007_Meridian.setText(xuc007_Meridian);
    }

    public String getXuc007_Acreage() {
        return xuc007_Acreage.getText();
    }

    public void setXuc007_Acreage(String xuc007_Acreage) {
        this.xuc007_Acreage.setText(xuc007_Acreage);
    }

    public String getXuc007_LegalDescription() {
        return xuc007_LegalDescription.getText();
    }

    public void setXuc007_LegalDescription(String xuc007_LegalDescription) {
        this.xuc007_LegalDescription.setText(xuc007_LegalDescription);
    }

    public String getXuc007_NorthBounder() {
        return xuc007_NorthBounder.getText();
    }

    public void setXuc007_NorthBounder(String xuc007_NorthBounder) {
        this.xuc007_NorthBounder.setText(xuc007_NorthBounder);
    }

    public String getXuc007_EastBounder() {
        return xuc007_EastBounder.getText();
    }

    public void setXuc007_EastBounder(String xuc007_EastBounder) {
        this.xuc007_EastBounder.setText(xuc007_EastBounder);
    }

    public String getXuc007_SouthBounder() {
        return xuc007_SouthBounder.getText();
    }

    public void setXuc007_SouthBounder(String xuc007_SouthBounder) {
        this.xuc007_SouthBounder.setText(xuc007_SouthBounder);
    }

    public String getXuc007_WestBounder() {
        return xuc007_WestBounder.getText();
    }

    public void setXuc007_WestBounder(String xuc007_WestBounder) {
        this.xuc007_WestBounder.setText(xuc007_WestBounder);
    }

    public String getXuc007_Section() {
        return xuc007_Section.getText();
    }

    public void setXuc007_Section(String xuc007_Section) {
        this.xuc007_Section.setText(xuc007_Section);
    }

    public boolean getXuc007_cbxBounders() {
        return this.xuc007_cbxBounders.isSelected();
    }
    public void uncheckXuc007_cbxBounders(boolean condition){
        this.xuc007_cbxBounders.setSelected(condition);
    }

    // START UC-002 Mutators and Accessors
    public boolean getXuc005_cbxAlternativePayee() {
        return this.xuc005_cbxAlternativePayee.isSelected();
    }

    public String getXuc005_OOPDate() {
        return xuc005_OOPDate.getText();
    }

    public void setXuc005_OOPDate(String xuc005_OOPDate) {
        this.xuc005_OOPDate.setText(xuc005_OOPDate);
    }

    public String getUc002_LeaseDate() {
        return uc002_LeaseDate.getText();
    }

    public void setUc002_LeaseDate(String uc002_LeaseDate) {
        this.uc002_LeaseDate.setText(uc002_LeaseDate);
    }

    public String getXuc005_BPA() {
        return xuc005_BPA.getText();
    }

    public void setXuc005_BPA(String xuc005_BPA) {
        this.xuc005_BPA.setText(xuc005_BPA);
    }

    public String getUc002_Royalty() {
        return uc002_Royalty.getText();
    }

    public void setUc002_Royalty(String uc002_Royalty) {
        this.uc002_Royalty.setText(uc002_Royalty);
    }

    public String getXuc005_PaymentTerms() {
        return xuc005_PaymentTerms.getText();
    }

    public void setXuc005_PaymentTerms(String xuc005_PaymentTerms) {
        this.xuc005_PaymentTerms.setText(xuc005_PaymentTerms);
    }

    public String getUc002_PrimaryTerm() {
        return uc002_PrimaryTerm.getText();
    }

    public void setUc002_PrimaryTerm(String uc002_PrimaryTerm) {
        this.uc002_PrimaryTerm.setText(uc002_PrimaryTerm);
    }

    public String getXuc005_BonusSubtotal() {
        return xuc005_BonusSubtotal.getText();
    }

    public void setXuc005_BonusSubtotal(String xuc005_BonusSubtotal) {
        this.xuc005_BonusSubtotal.setText(xuc005_BonusSubtotal);
    }

    public String getUc002_Lessor() {
        return uc002_Lessor.getText();
    }

    public void setUc002_Lessor(String uc002_Lessor) {
        this.uc002_Lessor.setText(uc002_Lessor);
    }

    public String getUc002_Address() {
        return uc002_Address.getText();
    }

    public void setUc002_Address(String uc002_Address) {
        this.uc002_Address.setText(uc002_Address);
    }

    public String getUc002_City() {
        return uc002_City.getText();
    }

    public void setUc002_City(String uc002_City) {
        this.uc002_City.setText(uc002_City);
    }

    public String getUc002_State() {
        return uc002_State.getText();
    }

    public void setUc002_State(String uc002_State) {
        this.uc002_State.setText(uc002_State);
    }

    public String getUc002_ZipCode() {
        return uc002_ZipCode.getText();
    }

    public void setUc002_ZipCode(String uc002_ZipCode) {
        this.uc002_ZipCode.setText(uc002_ZipCode);
    }

    public String getUc002_Lessee() {
        return uc002_Lessee.getText();
    }

    public void setUc002_Lessee(String uc002_Lessee) {
        this.uc002_Lessee.setText(uc002_Lessee);
    }

    public String getUc002_SecondaryTerm() {
        return this.uc002_SecondaryTerm.getText();
    }

    public void setUc002_SecondaryTerm(String uc002_SecondaryTerm) {
        this.uc002_SecondaryTerm.setText(uc002_SecondaryTerm);
    }

    public String getXuc005_AlternatePayee() {
        if (this.xuc005_AlternatePayee == null) {
        }
        return this.xuc005_AlternatePayee.getText();
    }

    public void setXuc005_AlternatePayee(String uc002_AlternatePayee) {
        this.xuc005_AlternatePayee.setText(uc002_AlternatePayee);
    }
    // END UC-002 Mutators and Accessors

    public JDialog getDxuc007() {
        return dXUC007;
    }

    public JFrame getfUC002() {
        return fUC002;
    }
    // START UC-002 Validation Feedback Mutators

    public void setXuc005_cbxAlternatePayee(boolean feedback) {
        if (feedback) {
            this.xuc005_cbxAlternativePayee.setForeground(Color.RED);
        } else {
            this.xuc005_cbxAlternativePayee.setForeground(Color.black);
        }
    }

    public void setXuc005_lblOOPDate(boolean feedback) {
        if (feedback) {
            this.xuc005_lblOOPDate.setForeground(Color.RED);
        } else {
            this.xuc005_lblOOPDate.setForeground(Color.black);
        }
    }

    public void setUc002_lblLeaseDate(boolean feedback) {
        if (feedback) {
            this.uc002_lblLeaseDate.setForeground(Color.RED);
        } else {
            this.uc002_lblLeaseDate.setForeground(Color.black);
        }
    }

    public void setXuc005_lblBPA(boolean feedback) {
        if (feedback) {
            this.Xuc005_lblBPA.setForeground(Color.RED);
        } else {
            this.Xuc005_lblBPA.setForeground(Color.black);
        }
    }

    public void setUc002_lblRoyalty(boolean feedback) {
        if (feedback) {
            this.uc002_lblRoyalty.setForeground(Color.RED);
        } else {
            this.uc002_lblRoyalty.setForeground(Color.black);
        }
    }

    public void setXuc005_lblPaymentTerms(boolean feedback) {
        if (feedback) {
            this.xuc005_lblPaymentTerms.setForeground(Color.RED);
        } else {
            this.xuc005_lblPaymentTerms.setForeground(Color.black);
        }
    }

    public void setUc002_lblPrimaryTerm(boolean feedback) {
        if (feedback) {
            this.uc002_lblPrimaryTerm.setForeground(Color.RED);
        } else {
            this.uc002_lblPrimaryTerm.setForeground(Color.black);
        }
    }

    public void setXuc005_lblBonusSubtotal(boolean feedback) {
        if (feedback) {
            this.xuc005_lblBonusSubtotal.setForeground(Color.RED);
        } else {
            this.xuc005_lblBonusSubtotal.setForeground(Color.black);
        }
    }

    public void setUc002_lblSecondaryTerm(boolean feedback) {
        if (feedback) {
            this.uc002_lblSecondaryTerm.setForeground(Color.RED);
        } else {
            this.uc002_lblSecondaryTerm.setForeground(Color.black);
        }
    }

    public void setXuc005_lblAlternativePayee(boolean feedback) {
        if (feedback) {
            this.xuc005_lblAlternativePayee.setForeground(Color.RED);
        } else {
            this.xuc005_lblAlternativePayee.setForeground(Color.black);
        }
    }

    public void setUc002_lblLessor(boolean feedback) {
        if (feedback) {
            this.uc002_lblLessor.setForeground(Color.RED);
        } else {
            this.uc002_lblLessor.setForeground(Color.black);
        }
    }

    public void setUc002_lblAddress(boolean feedback) {
        if (feedback) {
            this.uc002_lblAddress.setForeground(Color.RED);
        } else {
            this.uc002_lblAddress.setForeground(Color.black);
        }
    }

    public void setUc002_lblCity(boolean feedback) {
        if (feedback) {
            this.uc002_lblCity.setForeground(Color.RED);
        } else {
            this.uc002_lblCity.setForeground(Color.black);
        }
    }

    public void setUc002_lblState(boolean feedback) {
        if (feedback) {
            this.uc002_lblState.setForeground(Color.RED);
        } else {
            this.uc002_lblState.setForeground(Color.black);
        }
    }

    public void setUc002_lblZipCode(boolean feedback) {
        if (feedback) {
            this.uc002_lblZipCode.setForeground(Color.RED);
        } else {
            this.uc002_lblZipCode.setForeground(Color.black);
        }
    }

    public void setUc002_lblLessee(boolean feedback) {
        if (feedback) {
            this.uc002_lblLessee.setForeground(Color.RED);
        } else {
            this.uc002_lblLessee.setForeground(Color.black);
        }
    }

    public void setXuc007_lblLeasedLegalDescriptions(boolean feedback) {
        if (feedback) {
            this.xuc007_lblLeasedLegalDescriptions.setForeground(Color.RED);
        } else {
            this.xuc007_lblLeasedLegalDescriptions.setForeground(Color.black);
        }
    }

    public void displayAddProperty(boolean visibile) {
        if (visibile) {
            this.dXUC007.setVisible(true);
        } else {
            this.dXUC007.setVisible(false);
        }
    }
    // END UC-002 Validation Feedback Mutators
    // START XUC-007 User Input Validation Feedback

    public void setXuc007_lblParcelID(boolean feedback) {
        if (feedback) {
            xuc007_lblParcelID.setForeground(Color.RED);
        } else {
            xuc007_lblParcelID.setForeground(Color.black);
        }
    }

    public void setXuc007_lblTaxMapID(boolean feedback) {
        if (feedback) {
            xuc007_lblTaxMapID.setForeground(Color.RED);
        } else {
            xuc007_lblTaxMapID.setForeground(Color.black);
        }
    }

    public void setXuc007_lblCounty(boolean feedback) {
        if (feedback) {
            xuc007_lblCounty.setForeground(Color.RED);
        } else {
            xuc007_lblCounty.setForeground(Color.black);
        }
    }

    public void setXuc007_lblState(boolean feedback) {
        if (feedback) {
            xuc007_lblState.setForeground(Color.RED);
        } else {
            xuc007_lblState.setForeground(Color.black);
        }
    }

    public void setXuc007_lblAcreage(boolean feedback) {
        if (feedback) {
            xuc007_lblAcreage.setForeground(Color.RED);
        } else {
            xuc007_lblAcreage.setForeground(Color.black);
        }
    }

    public void setXuc007_lblTownship(boolean feedback) {
        if (feedback) {
            xuc007_lblTownship.setForeground(Color.RED);
        } else {
            xuc007_lblTownship.setForeground(Color.black);
        }
    }

    public void setXuc007_lblRange(boolean feedback) {
        if (feedback) {
            xuc007_lblRange.setForeground(Color.RED);
        } else {
            xuc007_lblRange.setForeground(Color.black);
        }
    }

    public void setXuc007_lblSection(boolean feedback) {
        if (feedback) {
            xuc007_lblSection.setForeground(Color.RED);
        } else {
            xuc007_lblSection.setForeground(Color.black);
        }
    }

    public void setXuc007_lblMeridian(boolean feedback) {
        if (feedback) {
            xuc007_lblMeridian.setForeground(Color.RED);
        } else {
            xuc007_lblMeridian.setForeground(Color.black);
        }
    }

    public void setXuc007_lblLegalDescription(boolean feedback) {
        if (feedback) {
            xuc007_lblLegalDescription.setForeground(Color.RED);
        } else {
            xuc007_lblLegalDescription.setForeground(Color.black);
        }
    }

    public void setXuc007_cbxBounders(boolean feedback) {
        if (feedback) {
            xuc007_cbxBounders.setForeground(Color.RED);
        } else {
            xuc007_cbxBounders.setForeground(Color.black);
        }
    }

    public void setXuc007_lblNorthBounder(boolean feedback) {
        if (feedback) {
            xuc007_lblNorthBounder.setForeground(Color.RED);
        } else {
            xuc007_lblNorthBounder.setForeground(Color.black);
        }
    }

    public void setXuc007_lblEastBounder(boolean feedback) {
        if (feedback) {
            xuc007_lblEastBounder.setForeground(Color.RED);
        } else {
            xuc007_lblEastBounder.setForeground(Color.black);
        }
    }

    public void setXuc007_lblSouthBounder(boolean feedback) {
        if (feedback) {
            xuc007_lblSouthBounder.setForeground(Color.RED);
        } else {
            xuc007_lblSouthBounder.setForeground(Color.black);
        }
    }

    public void setXuc007_lblWestBounder(boolean feedback) {
        if (feedback) {
            xuc007_lblWestBounder.setForeground(Color.RED);
        } else {
            xuc007_lblWestBounder.setForeground(Color.black);
        }
    }
    

    public void addXuc007Pane_LeasedProperty(String description, int gridY) {
        xuc007Pane_LeasedProperty.add(addComponent(description, gridY), new GridBagConstraints(0, gridY, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 5, 0), 0, 0));
        xuc007Pane_LeasedProperty.revalidate();

    }

    public JPanel addComponent(String description, int index) {

        JPanel newProperty = new JPanel();
        JTextField _description = new JTextField();
        JButton edit = new JButton();
        edit.setText("Edit");
        edit.setActionCommand(UserActions.EDIT_PROPERTY.name());
        edit.setName(Integer.toString(index));

        //======== this ========
        newProperty.setLayout(new GridBagLayout());
        ((GridBagLayout) newProperty.getLayout()).columnWidths = new int[]{84, 390, 57, 0};
        ((GridBagLayout) newProperty.getLayout()).rowHeights = new int[]{0, 0};
        ((GridBagLayout) newProperty.getLayout()).columnWeights = new double[]{0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout) newProperty.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};

        //---- _description ----
        _description.setMinimumSize(new Dimension(357, 22));
        _description.setText(description);
        _description.setFont(_description.getFont().deriveFont(_description.getFont().getSize() + 2f));
        _description.setEditable(false);
        newProperty.add(_description, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- xuc007_EditProperty ----

        newProperty.add(edit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        
        this.xuc007_EditPropertyButton = edit;
        return newProperty;
    }
    
    JButton xuc007_EditPropertyButton = new JButton();
    
    public JButton getXuc007_EditPropertyButton(){
        return this.xuc007_EditPropertyButton;
    }
}
