package JavaApp.mvccompliant;
/**
 *
 * @author by Michael Barth
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;


public class VLeasehold extends JFrame implements java.util.Observer {

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
        System.out.println("Leasehold View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }

    public VLeasehold() {
        initComponents();
    }

    private enum Actions {
        SAVELEASEHOLD,
        CLOSEWINDOW,
        ADDINSTRUMENT
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Leasehold Controller");
        _SaveLeasehold.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _AddInstrument.addActionListener(controller);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblRecordID = new JLabel();
        _dbRecordID = new JTextField();
        lblLesseeName = new JLabel();
        _Lessor = new JTextField();
        lblLesseeAddress = new JLabel();
        _Lessee = new JTextField();
        lblPrimaryTerm = new JLabel();
        _PrimaryTerm = new JTextField();
        lblOptionalTerm = new JLabel();
        _OptionalTerm = new JTextField();
        lblPrimaryTermExpiration = new JLabel();
        _PrimaryTermExpiration = new JTextField();
        lblOptionalTermExpiration = new JLabel();
        _OptionalTermExpiration = new JTextField();
        lblRoyalty = new JLabel();
        _Royalty = new JTextField();
        lblLeasedAcreage = new JLabel();
        _LeasedAcreage = new JTextField();
        lblCurrentLessee = new JLabel();
        _CurrentLessee = new JTextField();
        lblCurrentShallowRights = new JLabel();
        _CurrentShallowRights = new JTextField();
        lblSpecificShallowDepthRestrictions = new JLabel();
        _CurrenShallowDepthRestrictions = new JTextField();
        llblCurrentDeepDepthRights = new JLabel();
        _CurrentDeepDepthRights = new JTextField();
        lblSpecificDeepDepthRestrictions = new JLabel();
        _SpecificDeepDepthRestrictions = new JTextField();
        _AddInstrument = new JButton();
        _DocumentPane = new JPanel();
        buttonBar = new JPanel();
        _SaveLeasehold = new JButton();
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
                contentPanel.setFont(contentPanel.getFont().deriveFont(contentPanel.getFont().getStyle() & ~Font.BOLD, contentPanel.getFont().getSize() + 1f));
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {182, 140, 182, 135, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblRecordID ----
                lblRecordID.setText("Record Identification");
                contentPanel.add(lblRecordID, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_dbRecordID, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblLesseeName ----
                lblLesseeName.setText("LESSOR");
                lblLesseeName.setFont(lblLesseeName.getFont().deriveFont(lblLesseeName.getFont().getStyle() & ~Font.BOLD, lblLesseeName.getFont().getSize() + 1f));
                contentPanel.add(lblLesseeName, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Lessor ----
                _Lessor.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Lessor, new GridBagConstraints(1, 1, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblLesseeAddress ----
                lblLesseeAddress.setText("LESSEE");
                lblLesseeAddress.setFont(lblLesseeAddress.getFont().deriveFont(lblLesseeAddress.getFont().getStyle() & ~Font.BOLD, lblLesseeAddress.getFont().getSize() + 1f));
                contentPanel.add(lblLesseeAddress, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _Lessee ----
                _Lessee.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Lessee, new GridBagConstraints(1, 2, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblPrimaryTerm ----
                lblPrimaryTerm.setText("Primary Term");
                lblPrimaryTerm.setFont(lblPrimaryTerm.getFont().deriveFont(lblPrimaryTerm.getFont().getStyle() & ~Font.BOLD, lblPrimaryTerm.getFont().getSize() + 1f));
                contentPanel.add(lblPrimaryTerm, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _PrimaryTerm ----
                _PrimaryTerm.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PrimaryTerm, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblOptionalTerm ----
                lblOptionalTerm.setText("Optional Term");
                lblOptionalTerm.setFont(lblOptionalTerm.getFont().deriveFont(lblOptionalTerm.getFont().getStyle() & ~Font.BOLD, lblOptionalTerm.getFont().getSize() + 1f));
                contentPanel.add(lblOptionalTerm, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 10, 10, 5), 0, 0));

                //---- _OptionalTerm ----
                _OptionalTerm.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OptionalTerm, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblPrimaryTermExpiration ----
                lblPrimaryTermExpiration.setText("Primary Expiration Date");
                lblPrimaryTermExpiration.setFont(lblPrimaryTermExpiration.getFont().deriveFont(lblPrimaryTermExpiration.getFont().getStyle() & ~Font.BOLD, lblPrimaryTermExpiration.getFont().getSize() + 1f));
                contentPanel.add(lblPrimaryTermExpiration, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _PrimaryTermExpiration ----
                _PrimaryTermExpiration.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_PrimaryTermExpiration, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblOptionalTermExpiration ----
                lblOptionalTermExpiration.setText("Optional Expiration Date");
                lblOptionalTermExpiration.setFont(lblOptionalTermExpiration.getFont().deriveFont(lblOptionalTermExpiration.getFont().getStyle() & ~Font.BOLD, lblOptionalTermExpiration.getFont().getSize() + 1f));
                contentPanel.add(lblOptionalTermExpiration, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 10, 10, 5), 0, 0));

                //---- _OptionalTermExpiration ----
                _OptionalTermExpiration.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_OptionalTermExpiration, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblRoyalty ----
                lblRoyalty.setText("Royalty");
                lblRoyalty.setFont(lblRoyalty.getFont().deriveFont(lblRoyalty.getFont().getSize() + 1f));
                contentPanel.add(lblRoyalty, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_Royalty, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- lblLeasedAcreage ----
                lblLeasedAcreage.setText("Leased Acreage");
                lblLeasedAcreage.setFont(lblLeasedAcreage.getFont().deriveFont(lblLeasedAcreage.getFont().getStyle() & ~Font.BOLD, lblLeasedAcreage.getFont().getSize() + 1f));
                contentPanel.add(lblLeasedAcreage, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 10, 10, 5), 0, 0));

                //---- _LeasedAcreage ----
                _LeasedAcreage.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_LeasedAcreage, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblCurrentLessee ----
                lblCurrentLessee.setText("Current Lessee");
                lblCurrentLessee.setFont(lblCurrentLessee.getFont().deriveFont(lblCurrentLessee.getFont().getStyle() & ~Font.BOLD, lblCurrentLessee.getFont().getSize() + 1f));
                contentPanel.add(lblCurrentLessee, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _CurrentLessee ----
                _CurrentLessee.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_CurrentLessee, new GridBagConstraints(1, 6, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblCurrentShallowRights ----
                lblCurrentShallowRights.setText("Current Shallow Rights");
                lblCurrentShallowRights.setFont(lblCurrentShallowRights.getFont().deriveFont(lblCurrentShallowRights.getFont().getStyle() & ~Font.BOLD, lblCurrentShallowRights.getFont().getSize() + 1f));
                contentPanel.add(lblCurrentShallowRights, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _CurrentShallowRights ----
                _CurrentShallowRights.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_CurrentShallowRights, new GridBagConstraints(1, 7, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblSpecificShallowDepthRestrictions ----
                lblSpecificShallowDepthRestrictions.setText("Specific Depth Restrictions");
                lblSpecificShallowDepthRestrictions.setFont(lblSpecificShallowDepthRestrictions.getFont().deriveFont(lblSpecificShallowDepthRestrictions.getFont().getStyle() & ~Font.BOLD, lblSpecificShallowDepthRestrictions.getFont().getSize() + 1f));
                contentPanel.add(lblSpecificShallowDepthRestrictions, new GridBagConstraints(0, 8, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //---- _CurrenShallowDepthRestrictions ----
                _CurrenShallowDepthRestrictions.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_CurrenShallowDepthRestrictions, new GridBagConstraints(1, 8, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- llblCurrentDeepDepthRights ----
                llblCurrentDeepDepthRights.setText("Current Deep Depth Rights");
                llblCurrentDeepDepthRights.setFont(llblCurrentDeepDepthRights.getFont().deriveFont(llblCurrentDeepDepthRights.getFont().getStyle() & ~Font.BOLD, llblCurrentDeepDepthRights.getFont().getSize() + 1f));
                contentPanel.add(llblCurrentDeepDepthRights, new GridBagConstraints(0, 9, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_CurrentDeepDepthRights, new GridBagConstraints(1, 9, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- lblSpecificDeepDepthRestrictions ----
                lblSpecificDeepDepthRestrictions.setText("Specific Depth Restrictions");
                lblSpecificDeepDepthRestrictions.setFont(lblSpecificDeepDepthRestrictions.getFont().deriveFont(lblSpecificDeepDepthRestrictions.getFont().getStyle() & ~Font.BOLD, lblSpecificDeepDepthRestrictions.getFont().getSize() + 1f));
                contentPanel.add(lblSpecificDeepDepthRestrictions, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));
                contentPanel.add(_SpecificDeepDepthRestrictions, new GridBagConstraints(1, 10, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- _AddInstrument ----
                _AddInstrument.setText("Insert Recordiing Information");
                _AddInstrument.setActionCommand(Actions.ADDINSTRUMENT.name());
                _AddInstrument.setFont(_AddInstrument.getFont().deriveFont(_AddInstrument.getFont().getStyle() & ~Font.BOLD, _AddInstrument.getFont().getSize() + 1f));
                contentPanel.add(_AddInstrument, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //======== _DocumentPane ========
                {
                    _DocumentPane.setPreferredSize(new Dimension(0, 104));
                    _DocumentPane.setBorder(new EtchedBorder());
                    _DocumentPane.setLayout(new GridLayout());
                }
                contentPanel.add(_DocumentPane, new GridBagConstraints(0, 12, 4, 1, 0.0, 0.0,
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

                //---- _SaveLeasehold ----
                _SaveLeasehold.setText("SAVE");
                _SaveLeasehold.setActionCommand(Actions.SAVELEASEHOLD.name());
                buttonBar.add(_SaveLeasehold, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- _CancelButton ----
                _CancelButton.setText("CANCEL");
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
    private JLabel lblLesseeName;
    private JTextField _Lessor;
    private JLabel lblLesseeAddress;
    private JTextField _Lessee;
    private JLabel lblPrimaryTerm;
    private JTextField _PrimaryTerm;
    private JLabel lblOptionalTerm;
    private JTextField _OptionalTerm;
    private JLabel lblPrimaryTermExpiration;
    private JTextField _PrimaryTermExpiration;
    private JLabel lblOptionalTermExpiration;
    private JTextField _OptionalTermExpiration;
    private JLabel lblRoyalty;
    private JTextField _Royalty;
    private JLabel lblLeasedAcreage;
    private JTextField _LeasedAcreage;
    private JLabel lblCurrentLessee;
    private JTextField _CurrentLessee;
    private JLabel lblCurrentShallowRights;
    private JTextField _CurrentShallowRights;
    private JLabel lblSpecificShallowDepthRestrictions;
    private JTextField _CurrenShallowDepthRestrictions;
    private JLabel llblCurrentDeepDepthRights;
    private JTextField _CurrentDeepDepthRights;
    private JLabel lblSpecificDeepDepthRestrictions;
    private JTextField _SpecificDeepDepthRestrictions;
    private JButton _AddInstrument;
    private JPanel _DocumentPane;
    private JPanel buttonBar;
    private JButton _SaveLeasehold;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    
}
