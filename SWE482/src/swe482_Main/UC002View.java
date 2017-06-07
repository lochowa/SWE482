package swe482_Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;
import java.util.Observable;
import java.util.ResourceBundle;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;

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
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException | ClassNotFoundException ex) {
        }
        /* Turn off metal's use of bold fonts */

        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(() -> {
            UC002View view = new UC002View();
        });
    }

    UC002View() {
        buildGUI();
    }

    @Override
    public void update(Observable obs, Object obj) {
        System.out.println("View : Observable is "
                + obj.getClass() + ", object passed is "
                + obj.getClass());
    }

    private void _cbxBoundersActionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            e.getWindow().dispose();
        }
    }
    private static final WindowListener CLOSE = new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().dispose();
        }
    };

    void addController(ActionListener controller) {
//        Insert UserActions events here.
        uc002_SaveButton.addActionListener(controller);
        uc002_CancelButton.addActionListener(controller);
        xuc007_AddProperty.addActionListener(controller);
        uc002_FindLessor.addActionListener(controller);
        xuc007_CloseAddProperty.addActionListener(controller);
        xuc007_InsertProperty.addActionListener(controller);
        xuc007_SearchProperty.addActionListener(controller);
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
        CLOSE_ADDPROPERTY
    }

    private JFrame fUC002;
    private JDialog dUC002;
    private JPanel dpUC002;     // Replaces IDE JPanel
    /*
    *   XUC-007 Dialog
     */
    private JFrame fXUC007;


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
        fUC002.addWindowListener(CLOSE);
        JPanel pUC002 = new JPanel();
//        START Requires JPanel Form Insertion
        dpUC002 = new JPanel();
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        ResourceBundle bundle = ResourceBundle.getBundle("mvcproject.UC002AddLease");
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
            xuc005_lblOOPDate.setText(bundle.getString("JFD_Lease.xuc005_lblOOPDate.text"));
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
            uc002_lblLeaseDate.setText(bundle.getString("JFD_Lease.uc002_lblLeaseDate.text"));
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
            Xuc005_lblBPA.setText(bundle.getString("JFD_Lease.uc002_lblBPA.text"));
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
            uc002_lblRoyalty.setText(bundle.getString("JFD_Lease.uc002_lblRoyalty.text"));
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
            xuc005_lblPaymentTerms.setText(bundle.getString("JFD_Lease.xuc005_lblPaymentTerms.text"));
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
            uc002_lblPrimaryTerm.setText(bundle.getString("JFD_Lease.uc002_lblPrimaryTerm.text"));
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
            xuc005_lblBonusSubtotal.setText(bundle.getString("JFD_Lease.xuc005_lblBonusSubtotal.text"));
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
            uc002_lblSecondaryTerm.setText(bundle.getString("JFD_Lease.uc002_lblSecondaryTerm.text"));
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
            xuc005_cbxAlternativePayee.setText(bundle.getString("JFD_Lease.uc002_cbxAlternativePayee.text"));
            xuc005_cbxAlternativePayee.setFont(xuc005_cbxAlternativePayee.getFont().deriveFont(xuc005_cbxAlternativePayee.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_cbxAlternativePayee, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

            //---- xuc005_lblAlternativePayee ----
            xuc005_lblAlternativePayee.setText(bundle.getString("JFD_Lease.uc002_lblAlternativePayee.text"));
            xuc005_lblAlternativePayee.setFont(xuc005_lblAlternativePayee.getFont().deriveFont(xuc005_lblAlternativePayee.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc005_lblAlternativePayee, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

            //---- xuc005_AlternatePayee ----
            xuc005_AlternatePayee.setFont(xuc005_AlternatePayee.getFont().deriveFont(xuc005_AlternatePayee.getFont().getSize() + 1f));
            xuc005_AlternatePayee.setAutoscrolls(false);
            uc002_contentPane.add(xuc005_AlternatePayee, new GridBagConstraints(2, 6, 6, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

            //---- uc002_FindLessor ----
            uc002_FindLessor.setText(bundle.getString("JFD_Lease.uc002_FindLessor.text"));
            uc002_contentPane.add(uc002_FindLessor, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- uc002_lblLessor ----
            uc002_lblLessor.setText(bundle.getString("JFD_Lease.uc002_lblLessor.text"));
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
            uc002_lblAddress.setText(bundle.getString("JFD_Lease.uc002_lblAddress.text"));
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
            uc002_lblCity.setText(bundle.getString("JFD_Lease.uc002_lblCity.text"));
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
            uc002_lblState.setText(bundle.getString("JFD_Lease.uc002_lblState.text"));
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
            uc002_lblZipCode.setText(bundle.getString("JFD_Lease.uc002_lblZipCode.text"));
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
            uc002_lblLessee.setText(bundle.getString("JFD_Lease.uc002_lblLessee.text"));
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
            xuc007_AddProperty.setText(bundle.getString("JFD_Lease.xuc007_AddProperty.text"));
            uc002_contentPane.add(xuc007_AddProperty, new GridBagConstraints(0, 11, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //---- xuc007_lblLeasedLegalDescriptions ----
            xuc007_lblLeasedLegalDescriptions.setText(bundle.getString("JFD_Lease.xuc007_lblLeasedLegalDescriptions.text"));
            xuc007_lblLeasedLegalDescriptions.setFont(xuc007_lblLeasedLegalDescriptions.getFont().deriveFont(xuc007_lblLeasedLegalDescriptions.getFont().getSize() + 1f));
            uc002_contentPane.add(xuc007_lblLeasedLegalDescriptions, new GridBagConstraints(1, 11, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 5), 0, 0));

            //======== xuc007_scrollPanel ========
            {

                //======== xuc007Pane_LeasedProperty ========
                {
                    xuc007Pane_LeasedProperty.setAutoscrolls(true);
                    xuc007Pane_LeasedProperty.setLayout(new GridLayout());
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
                uc002_SaveButton.setText(bundle.getString("JFD_Lease.uc002_SaveButton.text"));
                uc002_ButtonBar.add(uc002_SaveButton);

                //---- uc002_CancelButton ----
                uc002_CancelButton.setText(bundle.getString("JFD_Lease.uc002_CancelButton.text"));
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
        dXUC007.addWindowListener(CLOSE);
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
        xuc007_ParcelID = new JTextField();
        xuc007_lblTownship = new JLabel();
        xuc007_Township = new JTextField();
        xuc007_lblTaxMapID = new JLabel();
        xuc007_TaxMapID = new JTextField();
        xuc007_lblRange = new JLabel();
        xuc007_Range = new JTextField();
        xuc_lblCounty = new JLabel();
        xuc007_County = new JTextField();
        xuc007_lblSection = new JLabel();
        textField3 = new JTextField();
        xuc007_lblState = new JLabel();
        xuc007_State = new JTextField();
        xuc007_lblMeridian = new JLabel();
        xuc007_Meridian = new JTextField();
        xuc007_lblAcreage = new JLabel();
        xuc007_Acreage = new JTextField();
        xuc007_lblLegalDescription = new JLabel();
        xuc007_scrollPane = new JScrollPane();
        xuc007_LegalDescription = new JTextArea();
        xuc007_cbxBounders = new JCheckBox();
        xuc007_paneBounders = new JPanel();
        xuc007_lblNorthBounder = new JLabel();
        xuc007_lblEastBounder = new JLabel();
        xuc007_lblSouthBounder = new JLabel();
        xuc007_lblWestBounder = new JLabel();
        xuc007_NorthBounder = new JTextField();
        xuc007_EastBounder = new JTextField();
        xuc007_SouthBounder = new JTextField();
        xuc007_WestBounder = new JTextField();
        xuc007_ButtonBar = new JPanel();
        xuc007_SearchProperty = new JButton();
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
            ((GridBagLayout)xuc007_dialogPane.getLayout()).columnWidths = new int[] {0, 0, 0};
            ((GridBagLayout)xuc007_dialogPane.getLayout()).rowHeights = new int[] {0, 0, 0};
            ((GridBagLayout)xuc007_dialogPane.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)xuc007_dialogPane.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

            //======== xuc007_contentPanel ========
            {
                xuc007_contentPanel.setPreferredSize(new Dimension(600, 375));
                xuc007_contentPanel.setLayout(null);

                //======== xuc007_paneProperty ========
                {
                    xuc007_paneProperty.setPreferredSize(null);
                    xuc007_paneProperty.setLayout(new GridBagLayout());
                    ((GridBagLayout)xuc007_paneProperty.getLayout()).columnWidths = new int[] {155, 155, 155, 150, 0};
                    ((GridBagLayout)xuc007_paneProperty.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                    ((GridBagLayout)xuc007_paneProperty.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)xuc007_paneProperty.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

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
                    xuc007_lblRange.setText("Range:");
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

                    //---- xuc_lblCounty ----
                    xuc_lblCounty.setText("County");
                    xuc_lblCounty.setFont(xuc_lblCounty.getFont().deriveFont(xuc_lblCounty.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc_lblCounty, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
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
                    xuc007_lblSection.setText("Section:");
                    xuc007_lblSection.setFont(xuc007_lblSection.getFont().deriveFont(xuc007_lblSection.getFont().getSize() + 2f));
                    xuc007_paneProperty.add(xuc007_lblSection, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));

                    //---- textField3 ----
//                    textField3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    textField3.setFont(textField3.getFont().deriveFont(textField3.getFont().getSize() + 1f));
                    xuc007_paneProperty.add(textField3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
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
                    xuc007_cbxBounders.setActionCommand("addPropertyBounders");
                    xuc007_cbxBounders.setFont(xuc007_cbxBounders.getFont().deriveFont(xuc007_cbxBounders.getFont().getSize() + 2f));
                    xuc007_cbxBounders.addActionListener(e -> _cbxBoundersActionPerformed(e));
                    xuc007_paneProperty.add(xuc007_cbxBounders, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                    //======== xuc007_paneBounders ========
                    {
                        xuc007_paneBounders.setLayout(new GridBagLayout());
                        ((GridBagLayout)xuc007_paneBounders.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
                        ((GridBagLayout)xuc007_paneBounders.getLayout()).rowHeights = new int[] {0, 25, 0};
                        ((GridBagLayout)xuc007_paneBounders.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};
                        ((GridBagLayout)xuc007_paneBounders.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

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
                        xuc007_NorthBounder.setFont(xuc007_NorthBounder.getFont().deriveFont(xuc007_NorthBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_NorthBounder, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_EastBounder ----
                        xuc007_EastBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_EastBounder.setAutoscrolls(false);
                        xuc007_EastBounder.setFont(xuc007_EastBounder.getFont().deriveFont(xuc007_EastBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_EastBounder, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_SouthBounder ----
                        xuc007_SouthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_SouthBounder.setAutoscrolls(false);
                        xuc007_SouthBounder.setFont(xuc007_SouthBounder.getFont().deriveFont(xuc007_SouthBounder.getFont().getSize() + 1f));
                        xuc007_paneBounders.add(xuc007_SouthBounder, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- xuc007_WestBounder ----
                        xuc007_WestBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        xuc007_WestBounder.setAutoscrolls(false);
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
                    for(int i = 0; i < xuc007_contentPanel.getComponentCount(); i++) {
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
                ((GridBagLayout)xuc007_ButtonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)xuc007_ButtonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- xuc007_SearchProperty ----
                xuc007_SearchProperty.setText("Property Verification");
                xuc007_ButtonBar.add(xuc007_SearchProperty, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc007_InsertProperty ----
                xuc007_InsertProperty.setText("INSERT");
                xuc007_InsertProperty.setActionCommand(UserActions.OPEN_ADDPROPERTY.name());
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
        dpXUC007.add(contentPane,BorderLayout.CENTER);
//        END JPanel Form Insertion
        pdXUC007.add(dpXUC007);
        cpXUC007.add(pdXUC007, BorderLayout.CENTER);
        dXUC007.setMinimumSize(new Dimension(680,500));

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
    private JLabel xuc_lblCounty;
    private JTextField xuc007_County;
    private JLabel xuc007_lblSection;
    private JTextField textField3;
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
            System.out.println("NULL PAYEE");
        }
        return this.xuc005_AlternatePayee.getText();
    }

    public void setXuc005_AlternatePayee(String uc002_AlternatePayee) {
        this.xuc005_AlternatePayee.setText(uc002_AlternatePayee);
    }
    // END UC-002 Mutators and Accessors
    // START UC-002 Validation Feedback Mutators

    public void setXuc005_cbxAlternatePayee(int feedback) {
        if (feedback == 1) {
            this.xuc005_cbxAlternativePayee.setForeground(Color.RED);
        } else {
            this.xuc005_cbxAlternativePayee.setForeground(Color.black);
        }
    }

    public void setXuc005_lblOOPDate(int feedback) {
        if (feedback == 1) {
            this.xuc005_lblOOPDate.setForeground(Color.RED);
        } else {
            this.xuc005_lblOOPDate.setForeground(Color.black);
        }
    }

    public void setUc002_lblLeaseDate(int feedback) {
        if (feedback == 1) {
            this.uc002_lblLeaseDate.setForeground(Color.RED);
        } else {
            this.uc002_lblLeaseDate.setForeground(Color.black);
        }
    }

    public void setXuc005_lblBPA(int feedback) {
        if (feedback == 1) {
            this.Xuc005_lblBPA.setForeground(Color.RED);
        } else {
            this.Xuc005_lblBPA.setForeground(Color.black);
        }
    }

    public void setUc002_lblRoyalty(int feedback) {
        if (feedback == 1) {
            this.uc002_lblRoyalty.setForeground(Color.RED);
        } else {
            this.uc002_lblRoyalty.setForeground(Color.black);
        }
    }

    public void setXuc005_lblPaymentTerms(int feedback) {
        if (feedback == 1) {
            this.xuc005_lblPaymentTerms.setForeground(Color.RED);
        } else {
            this.xuc005_lblPaymentTerms.setForeground(Color.black);
        }
    }

    public void setUc002_lblPrimaryTerm(int feedback) {
        if (feedback == 1) {
            this.uc002_lblPrimaryTerm.setForeground(Color.RED);
        } else {
            this.uc002_lblPrimaryTerm.setForeground(Color.black);
        }
    }

    public void setXuc005_lblBonusSubtotal(int feedback) {
        if (feedback == 1) {
            this.xuc005_lblBonusSubtotal.setForeground(Color.RED);
        } else {
            this.xuc005_lblBonusSubtotal.setForeground(Color.black);
        }
    }

    public void setUc002_lblSecondaryTerm(int feedback) {
        if (feedback == 1) {
            this.uc002_lblSecondaryTerm.setForeground(Color.RED);
        } else {
            this.uc002_lblSecondaryTerm.setForeground(Color.black);
        }
    }

    public void setXuc005_lblAlternativePayee(int feedback) {
        if (feedback == 1) {
            this.xuc005_lblAlternativePayee.setForeground(Color.RED);
        } else {
            this.xuc005_lblAlternativePayee.setForeground(Color.black);
        }
    }

    public void setUc002_lblLessor(int feedback) {
        if (feedback == 1) {
            this.uc002_lblLessor.setForeground(Color.RED);
        } else {
            this.uc002_lblLessor.setForeground(Color.black);
        }
    }

    public void setUc002_lblAddress(int feedback) {
        if (feedback == 1) {
            this.uc002_lblAddress.setForeground(Color.RED);
        } else {
            this.uc002_lblAddress.setForeground(Color.black);
        }
    }

    public void setUc002_lblCity(int feedback) {
        if (feedback == 1) {
            this.uc002_lblCity.setForeground(Color.RED);
        } else {
            this.uc002_lblCity.setForeground(Color.black);
        }
    }

    public void setUc002_lblState(int feedback) {
        if (feedback == 1) {
            this.uc002_lblState.setForeground(Color.RED);
        } else {
            this.uc002_lblState.setForeground(Color.black);
        }
    }

    public void setUc002_lblZipCode(int feedback) {
        if (feedback == 1) {
            this.uc002_lblZipCode.setForeground(Color.RED);
        } else {
            this.uc002_lblZipCode.setForeground(Color.black);
        }
    }

    public void setUc002_lblLessee(int feedback) {
        if (feedback == 1) {
            this.uc002_lblLessee.setForeground(Color.RED);
        } else {
            this.uc002_lblLessee.setForeground(Color.black);
        }
    }

    public void setXuc007_lblLeasedLegalDescriptions(int feedback) {
        if (feedback == 1) {
            this.xuc007_lblLeasedLegalDescriptions.setForeground(Color.RED);
        } else {
            this.xuc007_lblLeasedLegalDescriptions.setForeground(Color.black);
        }
    }
    
    public void displayAddProperty(boolean visibile){
        if(visibile){
            this.dXUC007.setVisible(true);
        } else { this.dXUC007.setVisible(false); }
    }
    // END UC-002 Validation Feedback Mutators
    // START XUC-007 Variabl


}
