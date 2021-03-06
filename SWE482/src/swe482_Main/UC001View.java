package swe482_Main;

/**
 *
 * @author Michael Barth UC-001 UC001View Design Implementing XUC-001, XUC-002,
 * XUC-003, JDialog ModalityType.DOCUMENT_MODAL
 * @author Andrew Lochow Lines 1369 to 1502
 *
 *
 * @author Jeff Reifler - added lines 1704 to 2177 created getters and setters
 * for JText XUC-002, XUC-003 and Validation Feedback Mutators for XUC-001,
 * XUC-002, XUC-003
 *
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;

public class UC001View extends JFrame implements java.util.Observer {

    /*
        UC-001: Process Abstract Title Report
        - XUC-001 (Extends) Create Land Record
        - XUC-002 (Extends) Create Surface _owner Record
        - XUC-003 (Extends) Create Mineral _owner Record
        - XUC-004 (Extends) Checksum Mineral _interest
     */
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
            System.exit(0);
        }
    }

    UC001View() {
        initComponents();
    }

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

        // OPEN means you're opening a dialog box.
        // CLOSE means you're closing a dialog box.
        // INSERT is the actio to save the dialog user input to XZY
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Property Controller");
        this.xuc001_CancelButton.addActionListener(controller);
        this.xuc004_SearchProperty.addActionListener(controller);
        this.xuc001_SaveProperty.addActionListener(controller);
        this.xuc002_AddSurfaceOwner.addActionListener(controller);
        this.xuc003_AddMineralOwner.addActionListener(controller);
        this.xuc002_InsertButton.addActionListener(controller);
        this.xuc002_CancelButton.addActionListener(controller);
        this.xuc004_SearchProperty.addActionListener(controller);
        this.xuc003_InsertButton.addActionListener(controller);
        this.xuc003_CancelButton.addActionListener(controller);
        this.xuc003_AttachBurden.addActionListener(controller);
    }

    void addButtonController(ActionListener controller, JButton button) {
        button.addActionListener(controller);
    }
    /*
    *   XUC-001 Initial Dialog
     */
    private JFrame fXUC001; // Replaces IDE contentPane
    /*
    *   XUC-002 Dialog
     */
    private JDialog dXUC002;
//    private JPanel dpXUC002;    // Replaces IDE contentPane
    /*
    *  XUC-003 Dialog
     */
    private JDialog dXUC003;
    /*
    *  XUC-003 Burden Dialog
     */
    private JDialog bXUC003;
    /*
    *  UC-001 Document Dialog
     */
    private JDialog dUC001;

    private void initComponents() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Insets ins = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        int sw = gc.getBounds().width - ins.left - ins.right;
        int sh = gc.getBounds().height - ins.top - ins.bottom;
        /*
        *   UC-001 Process Abstract Title Report
        *   XUC-003 Create Property Record
         */
        fXUC001 = new JFrame();
        xuc001_dialogPane = new JPanel();
        xuc001_contentPanel = new JPanel();
        xuc004_SearchProperty = new JButton();
        xuc004_SearchProperty.setActionCommand(UserActions.SEARCH_PROPERTY.name());
        xuc001_lblParcelID = new JLabel();
        xuc001_ParcelID = new JTextField();
        xuc001_lblTownship = new JLabel();
        xuc001_Township = new JTextField();
        xuc001_lblTaxAccountID = new JLabel();
        xuc001_TaxAccountID = new JTextField();
        xuc001_lblRange = new JLabel();
        xuc001_Range = new JTextField();
        xuc001_lblCounty = new JLabel();
        xuc001_County = new JTextField();
        xuc001_lblSection = new JLabel();
        xuc001_Section = new JTextField();
        xuc001_lblState = new JLabel();
        xuc001_State = new JTextField();
        xuc001_lblMeridian = new JLabel();
        xuc001_Meridian = new JTextField();
        xuc001_cboMeridian = new JComboBox(MeridianList);
        xuc001_lblAcreage = new JLabel();
        xuc001_Acreage = new JTextField();
        xuc001_lblLegalDescription = new JLabel();
        scrollPane1 = new JScrollPane();
        xuc001_LegalDescription = new JTextArea();
        xuc001_cbxBounders = new JCheckBox();
        xuc001_boundersPanel = new JPanel();
        xuc001_lblNorthBounder = new JLabel();
        xuc001_lblEastBounder = new JLabel();
        xuc001_lblSouthBounder = new JLabel();
        xuc001_lblWestBounder = new JLabel();
        xuc001_NorthBounder = new JTextField();
        xuc001_EastBounder = new JTextField();
        xuc001_SouthBounder = new JTextField();
        xuc001_WestBounder = new JTextField();
        xuc002_AddSurfaceOwner = new JButton();
        xuc002_AddSurfaceOwner.setActionCommand(UserActions.OPEN_SURFACEOWNER.name());
        xuc002_lblSurfaceOwnership = new JLabel();
        xuc002_SurfaceOwnerPane = new JPanel();
        xuc003_AddMineralOwner = new JButton();
        xuc003_AddMineralOwner.setActionCommand(UserActions.OPEN_MINERALOWNER.name());
        xuc003_lblMineralOwnership = new JLabel();
        xuc003_MineralOwnerPane = new JPanel();
        xuc001_buttonBar = new JPanel();
        xuc001_SaveProperty = new JButton();
        xuc001_SaveProperty.setActionCommand(UserActions.SAVE_ABSTRACT.name());
        xuc001_CancelButton = new JButton();
        xuc001_CancelButton.setActionCommand(UserActions.CLOSE_ABSTRACT.name());
        xuc001_InterestChecksum = new JLabel();

        //======== this ========
        fXUC001.setLayout(new BorderLayout());

        //======== xuc001_dialogPane ========
        {
            xuc001_dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            xuc001_dialogPane.setLayout(new BorderLayout());

            //======== xuc001_contentPanel ========
            {
                xuc001_contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc001_contentPanel.getLayout()).columnWidths = new int[]{70, 70, 142, 135, 75, 70, 0};
                ((GridBagLayout) xuc001_contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 101, 0, 0, 0, 140, 0, 140, 0};
                ((GridBagLayout) xuc001_contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) xuc001_contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- xuc004_SearchProperty ----
                xuc004_SearchProperty.setText("Search Database");
                xuc004_SearchProperty.setVisible(false); // FUTURE ENHANCEMENT
                xuc001_contentPanel.add(xuc004_SearchProperty, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblParcelID ----
                xuc001_lblParcelID.setText("Parcel Number");
                xuc001_lblParcelID.setFont(xuc001_lblParcelID.getFont().deriveFont(xuc001_lblParcelID.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblParcelID, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_ParcelID ----
                xuc001_ParcelID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_ParcelID, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblTownship ----
                xuc001_lblTownship.setText("Township");
                xuc001_lblTownship.setFont(xuc001_lblTownship.getFont().deriveFont(xuc001_lblTownship.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblTownship, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));

                //---- xuc001_Township ----
                xuc001_Township.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_Township, new GridBagConstraints(4, 1, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc001_lblTaxAccountID ----
                xuc001_lblTaxAccountID.setText("Tax Account ID");
                xuc001_lblTaxAccountID.setFont(xuc001_lblTaxAccountID.getFont().deriveFont(xuc001_lblTaxAccountID.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblTaxAccountID, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_TaxAccountID ----
                xuc001_TaxAccountID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_TaxAccountID, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblRange ----
                xuc001_lblRange.setText("Range");
                xuc001_lblRange.setFont(xuc001_lblRange.getFont().deriveFont(xuc001_lblRange.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblRange, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));

                //---- xuc001_Range ----
                xuc001_Range.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_Range, new GridBagConstraints(4, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc001_lblCounty ----
                xuc001_lblCounty.setText("County");
                xuc001_lblCounty.setFont(xuc001_lblCounty.getFont().deriveFont(xuc001_lblCounty.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblCounty, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_County ----
                xuc001_County.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_County, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblSection ----
                xuc001_lblSection.setText("Section");
                xuc001_lblSection.setFont(xuc001_lblSection.getFont().deriveFont(xuc001_lblSection.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblSection, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));

                //---- xuc001_Section ----
                xuc001_Section.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_Section, new GridBagConstraints(4, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc001_lblState ----
                xuc001_lblState.setText("State");
                xuc001_lblState.setFont(xuc001_lblState.getFont().deriveFont(xuc001_lblState.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblState, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_State ----
                xuc001_State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_State, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblMeridian ----
                xuc001_lblMeridian.setText("Principal Meridian");
                xuc001_lblMeridian.setFont(xuc001_lblMeridian.getFont().deriveFont(xuc001_lblMeridian.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblMeridian, new GridBagConstraints(3, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 10, 5), 0, 0));

                //---- xuc001_Meridian ----
//                xuc001_Meridian.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_cboMeridian.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_cboMeridian, new GridBagConstraints(4, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc001_lblAcreage ----
                xuc001_lblAcreage.setText("Acreage");
                xuc001_lblAcreage.setFont(xuc001_lblAcreage.getFont().deriveFont(xuc001_lblAcreage.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblAcreage, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_Acreage ----
                xuc001_Acreage.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_Acreage, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc001_lblLegalDescription ----
                xuc001_lblLegalDescription.setText("Legal Description:");
                xuc001_lblLegalDescription.setFont(xuc001_lblLegalDescription.getFont().deriveFont(xuc001_lblLegalDescription.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_lblLegalDescription, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== scrollPane1 ========
                {

                    //---- xuc001_LegalDescription ----
                    xuc001_LegalDescription.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    scrollPane1.setViewportView(xuc001_LegalDescription);
                }
                xuc001_contentPanel.add(scrollPane1, new GridBagConstraints(1, 7, 5, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc001_cbxBounders ----
                xuc001_cbxBounders.setText("Property Bounders");
                xuc001_cbxBounders.setFont(xuc001_cbxBounders.getFont().deriveFont(xuc001_cbxBounders.getFont().getSize() + 2f));
                xuc001_cbxBounders.addChangeListener((ChangeEvent e) -> {
                    if (xuc001_cbxBounders.isSelected()) {
                        this.xuc001_NorthBounder.setEditable(true);
                        this.xuc001_EastBounder.setEditable(true);
                        this.xuc001_SouthBounder.setEditable(true);
                        this.xuc001_WestBounder.setEditable(true);
                    } else {
                        this.xuc001_NorthBounder.setEditable(false);
                        this.setXuc001_NorthBounder(null);
                        this.xuc001_EastBounder.setEditable(false);
                        this.setXuc001_EastBounder(null);
                        this.xuc001_SouthBounder.setEditable(false);
                        this.setXuc001_SouthBounder(null);
                        this.xuc001_WestBounder.setEditable(false);
                        this.setXuc001_WestBounder(null);
                    }
                });
                xuc001_contentPanel.add(xuc001_cbxBounders, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== xuc001_boundersPanel ========
                {
                    xuc001_boundersPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout) xuc001_boundersPanel.getLayout()).columnWidths = new int[]{140, 140, 140, 135, 0};
                    ((GridBagLayout) xuc001_boundersPanel.getLayout()).rowHeights = new int[]{0, 25, 0};
                    ((GridBagLayout) xuc001_boundersPanel.getLayout()).columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0E-4};
                    ((GridBagLayout) xuc001_boundersPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 1.0E-4};

                    //---- xuc001_lblNorthBounder ----
                    xuc001_lblNorthBounder.setText("North Bounder");
                    xuc001_lblNorthBounder.setFont(xuc001_lblNorthBounder.getFont().deriveFont(xuc001_lblNorthBounder.getFont().getSize() + 1f));
                    xuc001_boundersPanel.add(xuc001_lblNorthBounder, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc001_lblEastBounder ----
                    xuc001_lblEastBounder.setText("East Bounder");
                    xuc001_lblEastBounder.setFont(xuc001_lblEastBounder.getFont().deriveFont(xuc001_lblEastBounder.getFont().getSize() + 1f));
                    xuc001_boundersPanel.add(xuc001_lblEastBounder, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc001_lblSouthBounder ----
                    xuc001_lblSouthBounder.setText("South Bounder");
                    xuc001_lblSouthBounder.setFont(xuc001_lblSouthBounder.getFont().deriveFont(xuc001_lblSouthBounder.getFont().getSize() + 1f));
                    xuc001_boundersPanel.add(xuc001_lblSouthBounder, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 5), 0, 0));

                    //---- xuc001_lblWestBounder ----
                    xuc001_lblWestBounder.setText("West Bounder");
                    xuc001_lblWestBounder.setFont(xuc001_lblWestBounder.getFont().deriveFont(xuc001_lblWestBounder.getFont().getSize() + 1f));
                    xuc001_boundersPanel.add(xuc001_lblWestBounder, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                            new Insets(0, 0, 10, 0), 0, 0));

                    //---- xuc001_NorthBounder ----
                    xuc001_NorthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_NorthBounder.setEditable(false);
                    xuc001_boundersPanel.add(xuc001_NorthBounder, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_EastBounder ----
                    xuc001_EastBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_EastBounder.setEditable(false);
                    xuc001_boundersPanel.add(xuc001_EastBounder, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_SouthBounder ----
                    xuc001_SouthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_SouthBounder.setEditable(false);
                    xuc001_boundersPanel.add(xuc001_SouthBounder, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_WestBounder ----
                    xuc001_WestBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_WestBounder.setEditable(false);
                    xuc001_boundersPanel.add(xuc001_WestBounder, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
                xuc001_contentPanel.add(xuc001_boundersPanel, new GridBagConstraints(0, 9, 6, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 15, 0), 0, 0));

                //---- xuc002_AddSurfaceOwner ----
                xuc002_AddSurfaceOwner.setText("Add");
                xuc001_contentPanel.add(xuc002_AddSurfaceOwner, new GridBagConstraints(0, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblSurfaceOwnership ----
                xuc002_lblSurfaceOwnership.setText("Surface Ownership");
                xuc002_lblSurfaceOwnership.setFont(xuc002_lblSurfaceOwnership.getFont().deriveFont(xuc002_lblSurfaceOwnership.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc002_lblSurfaceOwnership, new GridBagConstraints(1, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== xuc002_SurfaceOwnerPane ========
                {
                    xuc002_SurfaceOwnerPane.setLayout(new GridBagLayout());
                    ((GridBagLayout) xuc002_SurfaceOwnerPane.getLayout()).columnWidths = new int[]{0, 0, 0};
                    ((GridBagLayout) xuc002_SurfaceOwnerPane.getLayout()).rowHeights = new int[]{0, 0};
                    ((GridBagLayout) xuc002_SurfaceOwnerPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) xuc002_SurfaceOwnerPane.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};
                }
                xuc001_contentPanel.add(xuc002_SurfaceOwnerPane, new GridBagConstraints(0, 11, 6, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_AddMineralOwner ----
                xuc003_AddMineralOwner.setText("Add");
                xuc001_contentPanel.add(xuc003_AddMineralOwner, new GridBagConstraints(0, 12, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblMineralOwnership ----
                xuc003_lblMineralOwnership.setText("Mineral Ownership");
                xuc003_lblMineralOwnership.setFont(xuc003_lblMineralOwnership.getFont().deriveFont(xuc003_lblMineralOwnership.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc003_lblMineralOwnership, new GridBagConstraints(1, 12, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== xuc003_MineralOwnerPane ========
                {
                    xuc003_MineralOwnerPane.setLayout(new GridBagLayout());
                    ((GridBagLayout) xuc003_MineralOwnerPane.getLayout()).columnWidths = new int[]{0, 0, 0};
                    ((GridBagLayout) xuc003_MineralOwnerPane.getLayout()).rowHeights = new int[]{0, 0};
                    ((GridBagLayout) xuc003_MineralOwnerPane.getLayout()).columnWeights = new double[]{0.0, 0.0, 1.0E-4};
                    ((GridBagLayout) xuc003_MineralOwnerPane.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};
                }
                xuc001_contentPanel.add(xuc003_MineralOwnerPane, new GridBagConstraints(0, 13, 6, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc001_dialogPane.add(xuc001_contentPanel, BorderLayout.CENTER);

            //======== xuc001_buttonBar ========
            {
                xuc001_buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                xuc001_buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc001_buttonBar.getLayout()).columnWidths = new int[]{0, 85, 85, 0, 0};
                ((GridBagLayout) xuc001_buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
                
                //---- xuc001_fractionalInterestChecksum ----
                xuc001_InterestChecksum.setFont(xuc001_InterestChecksum.getFont().deriveFont(xuc001_InterestChecksum.getFont().getSize() + 1f));
                xuc001_buttonBar.add(xuc001_InterestChecksum, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
                
                //---- xuc001_SaveProperty ----
                xuc001_SaveProperty.setText("SAVE");
                xuc001_buttonBar.add(xuc001_SaveProperty, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc001_CancelButton ----
                xuc001_CancelButton.setText("Cancel");
                xuc001_buttonBar.add(xuc001_CancelButton, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc001_dialogPane.add(xuc001_buttonBar, BorderLayout.SOUTH);
        }
//        dpXUC001.add(xuc001_dialogPane, BorderLayout.CENTER);
//        dpXUC001.setVisible(true);
        fXUC001.add(xuc001_dialogPane, BorderLayout.CENTER);
//        pXUC001.add(dpXUC001);
//        fXUC001.add(pXUC001);
        fXUC001.setSize(660, 900);
        fXUC001.setVisible(true);
        fXUC001.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fXUC001.setLocationRelativeTo(getOwner());
//        END XUC-003 Create Property Record

        /*
        *   XUC-002 Dialog: Add Surface _owner
         */
        dXUC002 = new JDialog(fXUC001, null, Dialog.ModalityType.DOCUMENT_MODAL);
        JPanel pdXUC002 = new JPanel();
//        ADD SURFACE OWNER JPANEL HERE

        xuc002_dialogPane = new JPanel();
        xuc002_contentPanel = new JPanel();
        xuc002_NameQuery = new JTextField();
        xuc002_NameQuery.setVisible(false); // FUTURE ENHANCEMENT
        xuc002_SearchName = new JButton();
        xuc002_SearchName.setActionCommand(UserActions.SEARCH_PERSON.name());
        xuc002_SearchName.setVisible(false); // FUTURE ENHANCEMENT
        xuc002_lblName1 = new JLabel();
        xuc002_Name1 = new JTextField();
        xuc002_lblName2 = new JLabel();
        xuc002_Name2 = new JTextField();
        xuc002_lblName3 = new JLabel();
        xuc002_Name3 = new JTextField();
        xuc002_lblName4 = new JLabel();
        xuc002_Name4 = new JTextField();
        xuc002_lblAddress = new JLabel();
        xuc002_Address = new JTextField();
        xuc002_lblCity = new JLabel();
        xuc002_City = new JTextField();
        xuc002_lblState = new JLabel();
        xuc002_State = new JTextField();
        xuc002_lblZipCode = new JLabel();
        xuc002_ZipCode = new JTextField();
        xuc002_lblContactNumber = new JLabel();
        xuc002_ContactNumber = new JTextField();
        xuc002_lblSourceInformation = new JLabel();
        xuc002_lblDocumentType = new JLabel();
        xuc002_cboDocumentType = new JComboBox(DeedList);
        xuc002_lblEffectiveDate = new JLabel();
        xuc002_EffectiveDate = new JTextField();
        xuc002_lblRecordedDate = new JLabel();
        xuc002_RecordingDate = new JTextField();
        xuc002_lblDocumentID = new JLabel();
        xuc002_DocumentID = new JTextField();
        xuc002_lblValidationFeedback = new JTextArea();
        xuc002_lblBook = new JLabel();
        xuc002_Book = new JTextField();
        xuc002_lblPage = new JLabel();
        xuc002_Page = new JTextField();
        xuc002_ButtonBar = new JPanel();
        xuc002_cbxActiveStatus = new JCheckBox();
        xuc002_InsertButton = new JButton();
        xuc002_InsertButton.setActionCommand(UserActions.INSERT_SURFACEOWNER.name());
        xuc002_CancelButton = new JButton();
        xuc002_CancelButton.setActionCommand(UserActions.CLOSE_SURFACEOWNER.name());

        //======== this ========
        pdXUC002.setBorder(new EmptyBorder(12, 12, 12, 12));
        pdXUC002.setLayout(new BorderLayout());

        //======== xuc002_dialogPane ========
        {
            xuc002_dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            xuc002_dialogPane.setLayout(new BorderLayout());

            //======== xuc002_contentPanel ========
            {
                xuc002_contentPanel.setFont(xuc002_contentPanel.getFont().deriveFont(xuc002_contentPanel.getFont().getSize() + 1f));
                xuc002_contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc002_contentPanel.getLayout()).columnWidths = new int[]{70, 70, 140, 135, 0};
                ((GridBagLayout) xuc002_contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) xuc002_contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) xuc002_contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- xuc002_NameQuery ----
                xuc002_NameQuery.setAutoscrolls(false);
                xuc002_NameQuery.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_NameQuery, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_SearchName ----
                xuc002_SearchName.setText("Search Database");
                xuc002_SearchName.setActionCommand("SEARCHNAME");
                xuc002_SearchName.setMargin(new Insets(2, 15, 2, 15));
                xuc002_SearchName.setFont(xuc002_SearchName.getFont().deriveFont(xuc002_SearchName.getFont().getStyle() & ~Font.BOLD, xuc002_SearchName.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_SearchName, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 25, 0), 0, 0));

                //---- xuc002_lblName1 ----
                xuc002_lblName1.setText("Name #1");
                xuc002_lblName1.setFont(xuc002_lblName1.getFont().deriveFont(xuc002_lblName1.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblName1, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name1 ----
                xuc002_Name1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Name1, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName2 ----
                xuc002_lblName2.setText("Name #2");
                xuc002_lblName2.setFont(xuc002_lblName2.getFont().deriveFont(xuc002_lblName2.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblName2, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name2 ----
                xuc002_Name2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Name2, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName3 ----
                xuc002_lblName3.setText("Name #3");
                xuc002_lblName3.setFont(xuc002_lblName3.getFont().deriveFont(xuc002_lblName3.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblName3, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name3 ----
                xuc002_Name3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Name3, new GridBagConstraints(2, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName4 ----
                xuc002_lblName4.setText("Name #4");
                xuc002_lblName4.setFont(xuc002_lblName4.getFont().deriveFont(xuc002_lblName4.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblName4, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name4 ----
                xuc002_Name4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Name4, new GridBagConstraints(2, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblAddress ----
                xuc002_lblAddress.setText("Address");
                xuc002_lblAddress.setFont(xuc002_lblAddress.getFont().deriveFont(xuc002_lblAddress.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblAddress, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Address ----
                xuc002_Address.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Address, new GridBagConstraints(2, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblCity ----
                xuc002_lblCity.setText("City");
                xuc002_lblCity.setFont(xuc002_lblCity.getFont().deriveFont(xuc002_lblCity.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblCity, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_City ----
                xuc002_City.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_City, new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblState ----
                xuc002_lblState.setText("State");
                xuc002_lblState.setFont(xuc002_lblState.getFont().deriveFont(xuc002_lblState.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblState, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_State ----
                xuc002_State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_State, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblZipCode ----
                xuc002_lblZipCode.setText("Zip Code");
                xuc002_lblZipCode.setFont(xuc002_lblZipCode.getFont().deriveFont(xuc002_lblZipCode.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblZipCode, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_ZipCode ----
                xuc002_ZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_ZipCode, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblContactNumber ----
                xuc002_lblContactNumber.setText("Contact Number");
                xuc002_lblContactNumber.setFont(xuc002_lblContactNumber.getFont().deriveFont(xuc002_lblContactNumber.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblContactNumber, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_ContactNumber ----
                xuc002_ContactNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_ContactNumber, new GridBagConstraints(2, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblSourceInformation ----
                xuc002_lblSourceInformation.setText("Source Information");
                xuc002_lblSourceInformation.setFont(xuc002_lblSourceInformation.getFont().deriveFont(xuc002_lblSourceInformation.getFont().getSize() + 2f));
                xuc002_contentPanel.add(xuc002_lblSourceInformation, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblDocumentType ----
                xuc002_lblDocumentType.setText("Document Type");
                xuc002_lblDocumentType.setFont(xuc002_lblDocumentType.getFont().deriveFont(xuc002_lblDocumentType.getFont().getSize() + 2f));
                xuc002_contentPanel.add(xuc002_lblDocumentType, new GridBagConstraints(0, 12, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                xuc002_contentPanel.add(xuc002_cboDocumentType, new GridBagConstraints(2, 12, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblEffectiveDate ----
                xuc002_lblEffectiveDate.setText("Effective Date");
                xuc002_lblEffectiveDate.setFont(xuc002_lblEffectiveDate.getFont().deriveFont(xuc002_lblEffectiveDate.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblEffectiveDate, new GridBagConstraints(0, 13, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_EffectiveDate ----
                xuc002_EffectiveDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_EffectiveDate, new GridBagConstraints(2, 13, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblRecordedDate ----
                xuc002_lblRecordedDate.setText("Recording Date");
                xuc002_lblRecordedDate.setFont(xuc002_lblRecordedDate.getFont().deriveFont(xuc002_lblRecordedDate.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblRecordedDate, new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_RecordingDate ----
                xuc002_RecordingDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_RecordingDate, new GridBagConstraints(2, 14, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblDocumentID ----
                xuc002_lblDocumentID.setText("Document Number");
                xuc002_lblDocumentID.setFont(xuc002_lblDocumentID.getFont().deriveFont(xuc002_lblDocumentID.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblDocumentID, new GridBagConstraints(0, 15, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_DocumentID ----
                xuc002_DocumentID.setFont(xuc002_DocumentID.getFont().deriveFont(xuc002_DocumentID.getFont().getSize() + 1f));
                xuc002_DocumentID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_DocumentID, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                
//                //---- xuc003_lblValidationFeedback ----
                xuc002_lblValidationFeedback.setText("The source Document Number or Book/Page is required.");
                xuc002_lblValidationFeedback.setLineWrap(true);
                xuc002_lblValidationFeedback.setWrapStyleWord(true);
                xuc002_lblValidationFeedback.setFont(xuc002_lblValidationFeedback.getFont().deriveFont(xuc002_lblValidationFeedback.getFont().getSize() + 1f));
                xuc002_lblValidationFeedback.setAutoscrolls(false);
                xuc002_lblValidationFeedback.setOpaque(false);
                xuc002_lblValidationFeedback.setEditable(false);
                xuc002_lblValidationFeedback.setForeground(Color.red);
                xuc002_contentPanel.add(xuc002_lblValidationFeedback, new GridBagConstraints(3, 15, 1, 3, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 0, 0), 0, 0));

                //---- xuc002_lblBook ----
                xuc002_lblBook.setText("Book");
                xuc002_lblBook.setFont(xuc002_lblBook.getFont().deriveFont(xuc002_lblBook.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblBook, new GridBagConstraints(0, 16, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Book ----
                xuc002_Book.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Book, new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblPage ----
                xuc002_lblPage.setText("Page");
                xuc002_lblPage.setFont(xuc002_lblPage.getFont().deriveFont(xuc002_lblPage.getFont().getSize() + 1f));
                xuc002_contentPanel.add(xuc002_lblPage, new GridBagConstraints(0, 17, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc002_Page ----
                xuc002_Page.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc002_contentPanel.add(xuc002_Page, new GridBagConstraints(2, 17, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
            }
            xuc002_dialogPane.add(xuc002_contentPanel, BorderLayout.CENTER);

            //======== xuc002_ButtonBar ========
            {
                xuc002_ButtonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                xuc002_ButtonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc002_ButtonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) xuc002_ButtonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- xuc002_cbxActiveStatus ----
                xuc002_cbxActiveStatus.setText("Active?");
                xuc002_cbxActiveStatus.setFont(xuc002_cbxActiveStatus.getFont().deriveFont(xuc002_cbxActiveStatus.getFont().getSize() + 2f));
                xuc002_cbxActiveStatus.setSelected(true);
                xuc002_ButtonBar.add(xuc002_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc002_InsertButton ----
                xuc002_InsertButton.setText("INSERT");
                xuc002_ButtonBar.add(xuc002_InsertButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc002_CancelButton ----
                xuc002_CancelButton.setText("Cancel");
                xuc002_ButtonBar.add(xuc002_CancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc002_dialogPane.add(xuc002_ButtonBar, BorderLayout.SOUTH);
        }
        pdXUC002.add(xuc002_dialogPane, BorderLayout.CENTER);
        dXUC002.add(pdXUC002);
        dXUC002.setSize(480, 640);
        dXUC002.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dXUC002.setLocationRelativeTo(getOwner());

        /*
        *   XUC-003 Dialog: Add Mineral _owner
         */
        dXUC003 = new JDialog(fXUC001, null, Dialog.ModalityType.DOCUMENT_MODAL);
        JPanel pdXUC003 = new JPanel();
//        ADD MINERAL OWNER JPANEL HERE

        xuc003_dialogPane = new JPanel();
        xuc003_contentPanel = new JPanel();
        xuc003_NameQuery = new JTextField();
        xuc003_NameQuery.setVisible(false);     // FUTURE ENHANCEMENT
        xuc003_SearchName = new JButton();
        xuc003_SearchName.setActionCommand(UserActions.SEARCH_PERSON.name());
        xuc003_SearchName.setVisible(false);    // FUTURE ENHANCEMENT
        xuc003_lblStatus = new JLabel();
        xuc003_cboStatus = new JComboBox(statusOptions);
        xuc003_lblInterest = new JLabel();
        xuc003_Interest = new JTextField();
        xuc003_AttachBurden = new JButton();
        xuc003_AttachBurden.setActionCommand(UserActions.OPEN_BURDEN.name());
        xuc003_AttachBurden.setVisible(false);  // FUTURE ENHANCEMENT
        xuc003_lblName1 = new JLabel();
        xuc003_Name1 = new JTextField();
        xuc003_lblName2 = new JLabel();
        xuc003_Name2 = new JTextField();
        xuc003_lblName3 = new JLabel();
        xuc003_Name3 = new JTextField();
        xuc003_lblName4 = new JLabel();
        xuc003_Name4 = new JTextField();
        xuc003_lblAddress = new JLabel();
        xuc003_Address = new JTextField();
        xuc003_lblCity = new JLabel();
        xuc003_City = new JTextField();
        xuc003_lblState = new JLabel();
        xuc003_State = new JTextField();
        xuc003_lblZipCode = new JLabel();
        xuc003_ZipCode = new JTextField();
        xuc003_lblContactNumber = new JLabel();
        xuc003_ContactNumber = new JTextField();
        xuc003_lblSourceInformation = new JLabel();
        xuc003_lblDocumentType = new JLabel();
        xuc003_cboDocumentType = new JComboBox(DeedList);
        xuc003_lblEffectiveDate = new JLabel();
        xuc003_EffectiveDate = new JTextField();
        xuc003_lblRecordedDate = new JLabel();
        xuc003_RecordingDate = new JTextField();
        xuc003_lblDocumentID = new JLabel();
        xuc003_DocumentID = new JTextField();
        xuc003_lblValidationFeedback = new JTextArea();
        xuc003_lblBook = new JLabel();
        xuc003_Book = new JTextField();
        xuc003_lblPage = new JLabel();
        xuc003_Page = new JTextField();
        xuc003_ButtonBar = new JPanel();
        xuc003_cbxActiveStatus = new JCheckBox();
        xuc003_InsertButton = new JButton();
        xuc003_InsertButton.setActionCommand(UserActions.INSERT_MINERALOWNER.name());
        xuc003_CancelButton = new JButton();
        xuc003_CancelButton.setActionCommand(UserActions.CLOSE_MINERALOWNER.name());
        xuc003_cbxLastKnownAddress = new JCheckBox();

        //======== this ========
        pdXUC003.setLayout(new BorderLayout());

        //======== xuc003_dialogPane ========
        {
            xuc003_dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            xuc003_dialogPane.setLayout(new BorderLayout());

            //======== xuc003_contentPanel ========
            {
                xuc003_contentPanel.setFont(xuc003_contentPanel.getFont().deriveFont(xuc003_contentPanel.getFont().getSize() + 1f));
                xuc003_contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc003_contentPanel.getLayout()).columnWidths = new int[]{70, 70, 140, 135, 0};
                ((GridBagLayout) xuc003_contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) xuc003_contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) xuc003_contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- xuc003_NameQuery ----
                xuc003_NameQuery.setAutoscrolls(false);
                xuc003_NameQuery.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_NameQuery, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_SearchName ----
                xuc003_SearchName.setText("Search Database");
                xuc003_SearchName.setActionCommand("SEARCHNAME");
                xuc003_SearchName.setMargin(new Insets(2, 15, 2, 15));
                xuc003_SearchName.setFont(xuc003_SearchName.getFont().deriveFont(xuc003_SearchName.getFont().getStyle() & ~Font.BOLD, xuc003_SearchName.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_SearchName, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 25, 0), 0, 0));

                //---- xuc003_lblStatus ----
                xuc003_lblStatus.setText("Status");
                xuc003_lblStatus.setFont(xuc003_lblStatus.getFont().deriveFont(xuc003_lblStatus.getFont().getSize() + 2f));
                xuc003_contentPanel.add(xuc003_lblStatus, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                xuc003_contentPanel.add(xuc003_cboStatus, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblInterest ----
                xuc003_lblInterest.setText("Net Interest");
                xuc003_lblInterest.setFont(xuc003_lblInterest.getFont().deriveFont(xuc003_lblInterest.getFont().getSize() + 2f));
                xuc003_contentPanel.add(xuc003_lblInterest, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Interest ----
                xuc003_Interest.setFont(xuc003_Interest.getFont().deriveFont(xuc003_Interest.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_Interest, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_AttachBurden ----
                xuc003_AttachBurden.setText("Add Burden");
                xuc003_contentPanel.add(xuc003_AttachBurden, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblName1 ----
                xuc003_lblName1.setText("Name #1");
                xuc003_lblName1.setFont(xuc003_lblName1.getFont().deriveFont(xuc003_lblName1.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblName1, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Name1 ----
                xuc003_Name1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Name1, new GridBagConstraints(2, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblName2 ----
                xuc003_lblName2.setText("Name #2");
                xuc003_lblName2.setFont(xuc003_lblName2.getFont().deriveFont(xuc003_lblName2.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblName2, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Name2 ----
                xuc003_Name2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Name2, new GridBagConstraints(2, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblName3 ----
                xuc003_lblName3.setText("Name #3");
                xuc003_lblName3.setFont(xuc003_lblName3.getFont().deriveFont(xuc003_lblName3.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblName3, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Name3 ----
                xuc003_Name3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Name3, new GridBagConstraints(2, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblName4 ----
                xuc003_lblName4.setText("Name #4");
                xuc003_lblName4.setFont(xuc003_lblName4.getFont().deriveFont(xuc003_lblName4.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblName4, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Name4 ----
                xuc003_Name4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Name4, new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblAddress ----
                xuc003_lblAddress.setText("Address");
                xuc003_lblAddress.setFont(xuc003_lblAddress.getFont().deriveFont(xuc003_lblAddress.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblAddress, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Address ----
                xuc003_Address.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Address, new GridBagConstraints(2, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblCity ----
                xuc003_lblCity.setText("City");
                xuc003_lblCity.setFont(xuc003_lblCity.getFont().deriveFont(xuc003_lblCity.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblCity, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_City ----
                xuc003_City.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_City, new GridBagConstraints(2, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblState ----
                xuc003_lblState.setText("State");
                xuc003_lblState.setFont(xuc003_lblState.getFont().deriveFont(xuc003_lblState.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblState, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_State ----
                xuc003_State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_State, new GridBagConstraints(2, 10, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblZipCode ----
                xuc003_lblZipCode.setText("Zip Code");
                xuc003_lblZipCode.setFont(xuc003_lblZipCode.getFont().deriveFont(xuc003_lblZipCode.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblZipCode, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_ZipCode ----
                xuc003_ZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_ZipCode, new GridBagConstraints(2, 11, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblContactNumber ----
                xuc003_lblContactNumber.setText("Contact Number");
                xuc003_lblContactNumber.setFont(xuc003_lblContactNumber.getFont().deriveFont(xuc003_lblContactNumber.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblContactNumber, new GridBagConstraints(0, 12, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_ContactNumber ----
                xuc003_ContactNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_ContactNumber, new GridBagConstraints(2, 12, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- label1 ----
                xuc003_lblSourceInformation.setText("Source Information");
                xuc003_lblSourceInformation.setFont(xuc003_lblSourceInformation.getFont().deriveFont(xuc003_lblSourceInformation.getFont().getSize() + 2f));
                xuc003_contentPanel.add(xuc003_lblSourceInformation, new GridBagConstraints(0, 13, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblDocumentType ----
                xuc003_lblDocumentType.setText("Document Type");
                xuc003_lblDocumentType.setFont(xuc003_lblDocumentType.getFont().deriveFont(xuc003_lblDocumentType.getFont().getSize() + 2f));
                xuc003_contentPanel.add(xuc003_lblDocumentType, new GridBagConstraints(0, 14, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                xuc003_contentPanel.add(xuc003_cboDocumentType, new GridBagConstraints(2, 14, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc003_lblEffectiveDate ----
                xuc003_lblEffectiveDate.setText("Effective Date");
                xuc003_lblEffectiveDate.setFont(xuc003_lblEffectiveDate.getFont().deriveFont(xuc003_lblEffectiveDate.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblEffectiveDate, new GridBagConstraints(0, 15, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_EffectiveDate ----
                xuc003_EffectiveDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_EffectiveDate, new GridBagConstraints(2, 15, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblRecordedDate ----
                xuc003_lblRecordedDate.setText("Recording Date");
                xuc003_lblRecordedDate.setFont(xuc003_lblRecordedDate.getFont().deriveFont(xuc003_lblRecordedDate.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblRecordedDate, new GridBagConstraints(0, 16, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_RecordingDate ----
                xuc003_RecordingDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_RecordingDate, new GridBagConstraints(2, 16, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblDocumentID ----
                xuc003_lblDocumentID.setText("Document Number");
                xuc003_lblDocumentID.setFont(xuc003_lblDocumentID.getFont().deriveFont(xuc003_lblDocumentID.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblDocumentID, new GridBagConstraints(0, 17, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_DocumentID ----
                xuc003_DocumentID.setFont(xuc003_DocumentID.getFont().deriveFont(xuc003_DocumentID.getFont().getSize() + 1f));
                xuc003_DocumentID.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_DocumentID, new GridBagConstraints(2, 17, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblValidationFeedback ----
                xuc003_lblValidationFeedback.setText("The source Document Number or Book/Page is required.");
                xuc003_lblValidationFeedback.setLineWrap(true);
                xuc003_lblValidationFeedback.setWrapStyleWord(true);
                xuc003_lblValidationFeedback.setFont(xuc003_lblValidationFeedback.getFont().deriveFont(xuc003_lblValidationFeedback.getFont().getSize() + 1f));
                xuc003_lblValidationFeedback.setAutoscrolls(false);
                xuc003_lblValidationFeedback.setOpaque(false);
                xuc003_lblValidationFeedback.setEditable(false);
                xuc003_lblValidationFeedback.setForeground(Color.red);
                xuc003_contentPanel.add(xuc003_lblValidationFeedback, new GridBagConstraints(3, 17, 1, 3, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 5, 0, 0), 0, 0));

                //---- xuc003_lblBook ----
                xuc003_lblBook.setText("Book");
                xuc003_lblBook.setFont(xuc003_lblBook.getFont().deriveFont(xuc003_lblBook.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblBook, new GridBagConstraints(0, 18, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_Book ----
                xuc003_Book.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Book, new GridBagConstraints(2, 18, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc003_lblPage ----
                xuc003_lblPage.setText("Page");
                xuc003_lblPage.setFont(xuc003_lblPage.getFont().deriveFont(xuc003_lblPage.getFont().getSize() + 1f));
                xuc003_contentPanel.add(xuc003_lblPage, new GridBagConstraints(0, 19, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc003_Page ----
                xuc003_Page.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc003_contentPanel.add(xuc003_Page, new GridBagConstraints(2, 19, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
            }
            xuc003_dialogPane.add(xuc003_contentPanel, BorderLayout.CENTER);

            //======== xuc003_buttonBar ========
            {
                xuc003_ButtonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                xuc003_ButtonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc003_ButtonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) xuc003_ButtonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};
                //---- xuc003_cbxActiveStatus ----
                xuc003_cbxActiveStatus.setText("Active?");
                xuc003_cbxActiveStatus.setFont(xuc003_cbxActiveStatus.getFont().deriveFont(xuc003_cbxActiveStatus.getFont().getSize() + 2f));
                xuc003_cbxActiveStatus.setSelected(true);
                xuc003_ButtonBar.add(xuc003_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc003_InsertButton ----
                xuc003_InsertButton.setText("INSERT");
                xuc003_ButtonBar.add(xuc003_InsertButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc003_CancelButton ----
                xuc003_CancelButton.setText("Cancel");
                xuc003_ButtonBar.add(xuc003_CancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc003_dialogPane.add(xuc003_ButtonBar, BorderLayout.SOUTH);
        }

        pdXUC003.add(xuc003_dialogPane, BorderLayout.CENTER);
        dXUC003.add(pdXUC003);
        dXUC003.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dXUC003.setSize(490, 700);
        dXUC003.setLocationRelativeTo(getOwner());

        /*
        *   XUC003 Burden dialog
        *   FUTURE ENHANCEMENT
         */
//        bXUC003 = new JDialog(dXUC003, null, Dialog.ModalityType.DOCUMENT_MODAL);
//        JPanel pbXUC003 = new JPanel();
//        // ADD MINERAL OWNER JPANEL HERE
//        // INSERT new dialog UI above here.
//        bXUC003.add(pbXUC003);
//        bXUC003.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        bXUC003.setLocationRelativeTo(getOwner());

    }

    public String getXuc001_InterestChecksum() {
        return xuc001_InterestChecksum.getText();
    }

    public void setXuc001_InterestChecksum(String xuc001_InterestChecksum) {
        this.xuc001_InterestChecksum.setText(xuc001_InterestChecksum);
    }
    
    public void setXuc001_InterestChecksum(boolean feedback){
        if (!feedback){
            this.xuc001_InterestChecksum.setForeground(Color.RED);
        } else {
            this.xuc001_InterestChecksum.setForeground(Color.black);
        }
    }

    public JDialog getSurfaceDialog() {
        return this.dXUC002;
    }

    public JDialog getMineralDialog() {
        return this.dXUC003;
    }

    public JFrame getAbstractTitleFrame() {
        return this.fXUC001;
    }

//    public JDialog getBurdenDialog() {
//        return this.bXUC003;
//    }

    public JDialog getDocumentDialog() {
        return this.dUC001;
    }

// START XUC-001 Form Elements
    private JPanel xuc001_dialogPane;
    private JPanel xuc001_contentPanel;
    private JButton xuc004_SearchProperty;
    private JLabel xuc001_lblParcelID;
    private JTextField xuc001_ParcelID;
    private JLabel xuc001_lblTownship;
    private JTextField xuc001_Township;
    private JLabel xuc001_lblTaxAccountID;
    private JTextField xuc001_TaxAccountID;
    private JLabel xuc001_lblRange;
    private JTextField xuc001_Range;
    private JLabel xuc001_lblCounty;
    private JTextField xuc001_County;
    private JLabel xuc001_lblSection;
    private JTextField xuc001_Section;
    private JLabel xuc001_lblState;
    private JTextField xuc001_State;
    private JLabel xuc001_lblMeridian;
    private JTextField xuc001_Meridian;
    private JComboBox xuc001_cboMeridian;
    private JLabel xuc001_lblAcreage;
    private JTextField xuc001_Acreage;
    private JLabel xuc001_lblLegalDescription;
    private JScrollPane scrollPane1;
    private JTextArea xuc001_LegalDescription;
    private JCheckBox xuc001_cbxBounders;
    private JPanel xuc001_boundersPanel;
    private JLabel xuc001_lblNorthBounder;
    private JLabel xuc001_lblEastBounder;
    private JLabel xuc001_lblSouthBounder;
    private JLabel xuc001_lblWestBounder;
    private JTextField xuc001_NorthBounder;
    private JTextField xuc001_EastBounder;
    private JTextField xuc001_SouthBounder;
    private JTextField xuc001_WestBounder;
    private JButton xuc002_AddSurfaceOwner;
    private JLabel xuc002_lblSurfaceOwnership;
    private JPanel xuc002_SurfaceOwnerPane;
    private JButton xuc003_AddMineralOwner;
    private JLabel xuc003_lblMineralOwnership;
    private JPanel xuc003_MineralOwnerPane;
    private JPanel xuc001_buttonBar;
    private JButton xuc001_SaveProperty;
    private JButton xuc001_CancelButton;
    private JLabel xuc001_InterestChecksum;
    private final String[] MeridianList = {
        "1st P.M.",
        "2nd P.M.",
        "3rd P.M.",
        "4th P.M.",
        "5th P.M.",
        "6th P.M.",
        "Black Hills",
        "Boise",
        "Chicksaw",
        "Cimarron",
        "Copper River",
        "Fairbanks",
        "Gila and Salt River",
        "Humboldt",
        "Huntsville",
        "Indian",
        "Kateel River",
        "Louisiana",
        "Michigan",
        "Montana",
        "Mount Diablo",
        "Navajo",
        "New Mexico Principal",
        "St. Helena",
        "St. Stephens",
        "Salt Lake",
        "San Bernardino",
        "Seward",
        "Tallahassee",
        "Uintah",
        "Umiat",
        "Ute",
        "Washington (Mississippi)",
        "Willamette",
        "Wind River"
    };

    // START XUC-002 Form Elements
    private JPanel xuc002_dialogPane;
    private JPanel xuc002_contentPanel;
    private JTextField xuc002_NameQuery;
    private JButton xuc002_SearchName;
    private JLabel xuc002_lblName1;
    private JTextField xuc002_Name1;
    private JLabel xuc002_lblName2;
    private JTextField xuc002_Name2;
    private JLabel xuc002_lblName3;
    private JTextField xuc002_Name3;
    private JLabel xuc002_lblName4;
    private JTextField xuc002_Name4;
    private JLabel xuc002_lblAddress;
    private JTextField xuc002_Address;
    private JLabel xuc002_lblCity;
    private JTextField xuc002_City;
    private JLabel xuc002_lblState;
    private JTextField xuc002_State;
    private JLabel xuc002_lblZipCode;
    private JTextField xuc002_ZipCode;
    private JLabel xuc002_lblContactNumber;
    private JTextField xuc002_ContactNumber;
    private JButton xuc002_AddDocument;
    private JPanel xuc002_DocumentPane;
    private JPanel xuc002_ButtonBar;
    private JCheckBox xuc002_cbxActiveStatus;
    private JButton xuc002_InsertButton;
    private JButton xuc002_CancelButton;

    // START XUC003 Form Elements
    private final String[] statusOptions = {
        "OPEN",
        "LEASED",
        "HELD BY PRODUCTION",
        "STORAGE"
    };
    private JButton xuc003_AttachBurden;
    private JPanel xuc003_dialogPane;
    private JPanel xuc003_contentPanel;
    private JTextField xuc003_NameQuery;
    private JButton xuc003_SearchName;
    private JLabel xuc003_lblStatus;
    private JComboBox xuc003_cboStatus;
    private JLabel xuc003_lblInterest;
    private JTextField xuc003_Interest;
    private JLabel xuc003_lblName1;
    private JTextField xuc003_Name1;
    private JLabel xuc003_lblName2;
    private JTextField xuc003_Name2;
    private JLabel xuc003_lblName3;
    private JTextField xuc003_Name3;
    private JLabel xuc003_lblName4;
    private JTextField xuc003_Name4;
    private JLabel xuc003_lblAddress;
    private JTextField xuc003_Address;
    private JLabel xuc003_lblCity;
    private JTextField xuc003_City;
    private JLabel xuc003_lblState;
    private JTextField xuc003_State;
    private JLabel xuc003_lblZipCode;
    private JTextField xuc003_ZipCode;
    private JLabel xuc003_lblContactNumber;
    private JTextField xuc003_ContactNumber;
    private JButton xuc003_AddDocument;
    private JPanel xuc003_DocumentPane;
    private JPanel xuc003_ButtonBar;
    private JCheckBox xuc003_cbxActiveStatus;
    private JButton xuc003_InsertButton;
    private JButton xuc003_CancelButton;
    private JCheckBox xuc003_cbxLastKnownAddress;

    // START XUC-003 Add Burden Form Elements
    // START UC-001 Add Document Form Elements
    private JLabel xuc003_lblSourceInformation;
    private JLabel xuc003_lblDocumentType;
    private JComboBox xuc003_cboDocumentType;
    private JLabel xuc003_lblEffectiveDate;
    private JTextField xuc003_EffectiveDate;
    private JLabel xuc003_lblRecordedDate;
    private JTextField xuc003_RecordingDate;
    private JLabel xuc003_lblDocumentID;
    private JTextField xuc003_DocumentID;
    private JTextArea xuc003_lblValidationFeedback;
    private JLabel xuc003_lblBook;
    private JTextField xuc003_Book;
    private JLabel xuc003_lblPage;
    private JTextField xuc003_Page;
    private JLabel xuc002_lblSourceInformation;
    private JLabel xuc002_lblDocumentType;
    private JComboBox xuc002_cboDocumentType;
    private JLabel xuc002_lblEffectiveDate;
    private JTextField xuc002_EffectiveDate;
    private JLabel xuc002_lblRecordedDate;
    private JTextField xuc002_RecordingDate;
    private JLabel xuc002_lblDocumentID;
    private JTextField xuc002_DocumentID;
    private JTextArea xuc002_lblValidationFeedback;
    private JLabel xuc002_lblBook;
    private JTextField xuc002_Book;
    private JLabel xuc002_lblPage;
    private JTextField xuc002_Page;
    private final String[] DeedList = {
        "WD  - Warranty Deed",
        "SWD - Special Warranty Deed",
        "BS  - Bargain and Sale",
        "QCD - Quitclaim",
        "GD  - Grant Deed",
        "PRD - Personal Representative Deed",
        "FD  - Fiduciary Deed",
        "ST  - Survivorship Tenancy",
        "TDT - Transfer on Death Tenancy",
        "DD  - Dower"
    };
    private String documentCaller;

    public void addSurfaceOwner(String owner, int gridY) {
        xuc002_SurfaceOwnerPane.add(addSurfaceOwnerPane(owner, gridY), new GridBagConstraints(0, gridY, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        xuc002_SurfaceOwnerPane.revalidate();
    }

    public void updateSurfaceOwner(String owner, int gridY) {
        JPanel test = (JPanel) xuc002_SurfaceOwnerPane.getComponent(gridY);
        JTextField field = (JTextField) test.getComponent(0);
        field.setText(owner);
    }

    public void removeSurfaceOwner(int gridY) {
        Component[] componentList = this.xuc002_SurfaceOwnerPane.getComponents();
        for (Component c : componentList) {
            if (c.getComponentAt(0, gridY).getName().equals(Integer.toString(gridY))) {
                this.xuc002_SurfaceOwnerPane.remove(c);
            }
        }
        this.xuc002_SurfaceOwnerPane.revalidate();
        this.xuc002_SurfaceOwnerPane.repaint();
    }

    public JPanel addSurfaceOwnerPane(String owner, int index) {

        JPanel surface = new JPanel();
        JTextField _owner = new JTextField();
        _owner.setName(Integer.toString(index));
        JButton edit = new JButton();
        edit.setText("Edit");
        edit.setActionCommand(UserActions.EDIT_SURFACEOWNER.name());
        edit.setName(Integer.toString(index));
        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setActionCommand(UserActions.REMOVE_SURFACEOWNER.name());
        remove.setName(Integer.toString(index));

        //======== this ========
        surface.setLayout(new GridBagLayout());
        ((GridBagLayout) surface.getLayout()).columnWidths = new int[]{480, 0, 0};
        ((GridBagLayout) surface.getLayout()).rowHeights = new int[]{0, 0};
        ((GridBagLayout) surface.getLayout()).columnWeights = new double[]{0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout) surface.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};

        //---- _owner ----
        _owner.setText(owner);
        _owner.setFont(_owner.getFont().deriveFont(_owner.getFont().getSize() + 2f));
        _owner.setEditable(false);
        surface.add(_owner, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        // ---- _remove ----
        surface.add(remove, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        //---- xuc007_EditProperty ----
        surface.add(edit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        this.xuc002_EditSurfaceOwner = edit;
        this.xuc002_RemoveSurfaceOwner = remove;
        return surface;
    }

    JButton xuc002_EditSurfaceOwner = new JButton();
    JButton xuc002_RemoveSurfaceOwner = new JButton();

    public JButton getEditSurfaceOwnerButton() {
        return this.xuc002_EditSurfaceOwner;
    }

    public JButton getRemoveSurfaceOwnerButton() {
        return this.xuc002_RemoveSurfaceOwner;
    }

    public void addMineralOwner(String owner, String status, String interest, int gridY) {
        xuc003_MineralOwnerPane.add(addMineralOwnerPane(owner, status, interest, gridY), new GridBagConstraints(0, gridY, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        xuc003_MineralOwnerPane.revalidate();
    }

    public void updateMineralOwner(String owner, String status, String interest, int gridY) {
        Component[] componentList = this.xuc003_MineralOwnerPane.getComponents();
        for (Component c : componentList) {
            if (c.getComponentAt(0, gridY).getName().equals(Integer.toString(gridY))) {
                c = this.addMineralOwnerPane(owner, status, interest, gridY);
            }
        }
        this.xuc003_MineralOwnerPane.revalidate();
    }

    public void removeMineralOwner(int gridY) {
        Component[] componentList = this.xuc003_MineralOwnerPane.getComponents();
        for (Component c : componentList) {
            if (c.getComponentAt(0, gridY).getName().equals(Integer.toString(gridY))) {
                this.xuc003_MineralOwnerPane.remove(c);
            }
        }
        this.xuc003_MineralOwnerPane.revalidate();
        this.xuc003_MineralOwnerPane.repaint();
    }

    public JPanel addMineralOwnerPane(String owner, String status, String interest, int index) {
        JPanel mineral = new JPanel();
        JTextField _owner = new JTextField();
        _owner.setName(Integer.toString(index));
        _owner.setText(owner);
        JButton edit = new JButton();
        edit.setText("Edit");
        edit.setActionCommand(UserActions.EDIT_SURFACEOWNER.name());
        edit.setName(Integer.toString(index));
        JButton remove = new JButton();
        remove.setText("Remove");
        remove.setActionCommand(UserActions.REMOVE_SURFACEOWNER.name());
        remove.setName(Integer.toString(index));
        JTextField _status = new JTextField();
        _status.setText(status);
        _status.setName(Integer.toString(index));
        JTextField _interest = new JTextField();
        _interest.setText(interest);
        _interest.setName(Integer.toString(index));

        //======== this ========
        mineral.setLayout(new GridBagLayout());
        ((GridBagLayout) mineral.getLayout()).columnWidths = new int[]{72, 99, 304, 0, 0, 0};
        ((GridBagLayout) mineral.getLayout()).rowHeights = new int[]{0, 0};
        ((GridBagLayout) mineral.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout) mineral.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};

        //---- _status ----
        _status.setFont(_status.getFont().deriveFont(_status.getFont().getSize() + 1f));
        _status.setAutoscrolls(false);
        _status.setEditable(false);
        mineral.add(_status, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- _interest ----
        _interest.setFont(_interest.getFont().deriveFont(_interest.getFont().getSize() + 1f));
        _interest.setAutoscrolls(false);
        _interest.setEditable(false);
        mineral.add(_interest, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- _owner ----
        _owner.setFont(_owner.getFont().deriveFont(_owner.getFont().getSize() + 1f));
        _owner.setAutoscrolls(false);
        _owner.setEditable(false);
        mineral.add(_owner, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- button2 ----
        mineral.add(remove, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 5), 0, 0));

        //---- button1 ----
        mineral.add(edit, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        this.xuc002_EditMineralOwner = edit;
        this.xuc002_RemoveMineralOwner = remove;
        return mineral;
    }

    private JButton xuc002_EditMineralOwner = new JButton();
    private JButton xuc002_RemoveMineralOwner = new JButton();

    public void importSurfaceOwnerButtonProperties(boolean toggle, String index) {
        if (toggle) {
            xuc002_InsertButton.setText("UPDATE");
            xuc002_InsertButton.setName(index);
            xuc002_InsertButton.setActionCommand(UserActions.UPDATE_SURFACEOWNER.name());
        } else {
            xuc002_InsertButton.setText("INSERT");
            xuc002_InsertButton.setActionCommand(UserActions.INSERT_SURFACEOWNER.name());
        }
    }

    public void importMineralOwnerButtonProperties(boolean toggle, String index) {
        if (toggle) {
            xuc003_InsertButton.setText("UPDATE");
            xuc003_InsertButton.setName(index);
            xuc003_InsertButton.setActionCommand(UserActions.UPDATE_MINERALOWNER.name());
        } else {
            xuc003_InsertButton.setText("INSERT");
            xuc003_InsertButton.setActionCommand(UserActions.INSERT_SURFACEOWNER.name());
        }
    }

    public JButton getEditMineralOwnerButton() {
        return this.xuc002_EditMineralOwner;
    }

    public JButton getRemoveMineralOwnerButton() {
        return this.xuc002_RemoveMineralOwner;
    }

    //   START GETTERS/SETTERS
    // Getters for field values *Added by Andrew Lochow*
    public String getXuc001_ParcelID() {
        return xuc001_ParcelID.getText();
    }

    public void setXuc001_ParcelID(String parcelID) {
        this.xuc001_ParcelID.setText(parcelID);
    }

    public String getXuc001_TaxAccountID() {
        return xuc001_TaxAccountID.getText();
    }

    public void setXuc001_TaxAccountID(String xuc001_TaxAccountID) {
        this.xuc001_TaxAccountID.setText(xuc001_TaxAccountID);
    }

    public String getXuc001_County() {
        return xuc001_County.getText();
    }

    public void setXuc001_County(String xuc001_County) {
        this.xuc001_County.setText(xuc001_County);
    }

    public String getXuc001_State() {
        return xuc001_State.getText();
    }

    public void setXuc001_State(String xuc001_State) {
        this.xuc001_State.setText(xuc001_State);
    }

    public String getXuc001_Acreage() {
        return this.xuc001_Acreage.getText();
    }

    public void setXuc001_Acrage(String xuc001_Acreage) {
        this.xuc001_Acreage.setText(xuc001_Acreage);
    }

    public String getXuc001_Township() {
        return xuc001_Township.getText();
    }

    public void setXuc001_Township(String xuc001_Township) {
        this.xuc001_Township.setText(xuc001_Township);
    }

    public String getXuc001_Range() {
        return xuc001_Range.getText();
    }

    public void setXuc001_Range(String xuc001_Range) {
        this.xuc001_Range.setText(xuc001_Range);
    }

    public String getXuc001_Section() {
        return xuc001_Section.getText();
    }

    public void setXuc001_Section(String xuc001_Section) {
        this.xuc001_Section.setText(xuc001_Section);
    }

    public String getXuc001_LegalDescription() {
        return xuc001_LegalDescription.getText();
    }

    public void setXuc001_LegalDescription(String xuc001_LegalDescription) {
        this.xuc001_LegalDescription.setText(xuc001_LegalDescription);
    }

    public String getXuc001_Meridian() {
        return xuc001_cboMeridian.getSelectedItem().toString();
    }

    public void setXuc001_Meridian(String xuc001_Meridian) {
        for (int index = 0; index < MeridianList.length; index++) {
            if (this.MeridianList[index].equals(xuc001_Meridian)) {
                this.xuc001_cboMeridian.setSelectedIndex(index);
            }
        }
    }

    public String getXuc001_NorthBounder() {
        return xuc001_NorthBounder.getText();
    }

    public void setXuc001_NorthBounder(String xuc001_NorthBounder) {
        this.xuc001_NorthBounder.setText(xuc001_NorthBounder);
    }

    public String getXuc001_SouthBounder() {
        return xuc001_SouthBounder.getText();
    }

    public void setXuc001_SouthBounder(String xuc001_SouthBounder) {
        this.xuc001_SouthBounder.setText(xuc001_SouthBounder);
    }

    public String getXuc001_EastBounder() {
        return xuc001_EastBounder.getText();
    }

    public void setXuc001_EastBounder(String xuc001_EastBounder) {
        this.xuc001_EastBounder.setText(xuc001_EastBounder);
    }

    public String getXuc001_WestBounder() {
        return xuc001_WestBounder.getText();
    }

    public void setXuc001_WestBounder(String xuc001_WestBounder) {
        this.xuc001_WestBounder.setText(xuc001_WestBounder);
    }

    public boolean getXuc001_cbxBounders() {
        return xuc001_cbxBounders.isSelected();
    }
    //Getters and Setters for JText XUC-002 Form Elements created by Jeff Reifler

    public String getXuc002_NameQuery() {
        return xuc002_NameQuery.getText();
    }

    public void setXuc002_NameQuery(String NameQuery) {
        this.xuc002_NameQuery.setText(NameQuery);
    }

    public String getXuc002_Name1() {
        return xuc002_Name1.getText();
    }

    public void setXuc002_Name1(String Name1) {
        this.xuc002_Name1.setText(Name1);
    }

    public String getXuc002_Name2() {
        return xuc002_Name2.getText();
    }

    public void setXuc002_Name2(String Name2) {
        this.xuc002_Name2.setText(Name2);
    }

    public String getXuc002_Name3() {
        return xuc002_Name3.getText();
    }

    public void setXuc002_Name3(String Name3) {
        this.xuc002_Name3.setText(Name3);
    }

    public String getXuc002_Name4() {
        return xuc002_Name4.getText();
    }

    public void setXuc002_Name4(String Name4) {
        this.xuc002_Name4.setText(Name4);
    }

    public String getXuc002_Address() {
        return xuc002_Address.getText();
    }

    public void setXuc002_Address(String Address) {
        this.xuc002_Address.setText(Address);
    }

    public String getXuc002_City() {
        return xuc002_City.getText();
    }

    public void setXuc002_City(String City) {
        this.xuc002_City.setText(City);
    }

    public String getXuc002_State() {
        return xuc002_State.getText();
    }

    public void setXuc002_State(String State) {
        this.xuc002_State.setText(State);
    }

    public String getXuc002_ZipCode() {
        return xuc002_ZipCode.getText();
    }

    public void setXuc002_ZipCode(String ZipCode) {
        this.xuc002_ZipCode.setText(ZipCode);
    }

    public String getXuc002_ContactNumber() {
        return xuc002_ContactNumber.getText();
    }

    public void setXuc002_ContactNumber(String ContactNumber) {
        this.xuc002_ContactNumber.setText(ContactNumber);
    }

    //Getters and Setters for JText XUC-003 Form Elements created by Jeff Reifler
    public String getXuc003_NameQuery() {
        return xuc003_NameQuery.getText();
    }

    public void setXuc003_NameQuery(String NameQuery) {
        this.xuc003_NameQuery.setText(NameQuery);
    }

    public String getXuc003_Interest() {
        return xuc003_Interest.getText();
    }

    public String getXuc003_InterestStatus() {
        return this.xuc003_cboStatus.getSelectedItem().toString();
    }

    public void setXuc003_InterestStatus(String status) {
        for (int i = 0; i < xuc003_cboStatus.getItemCount(); i++) {
            if (xuc003_cboStatus.getItemAt(i).equals(status)) {
                this.xuc003_cboStatus.setSelectedIndex(i);
            }
        }
    }

    public void setXuc003_Interest(String Interest) {
        this.xuc003_Interest.setText(Interest);
    }

    public String getXuc003_Name1() {
        return xuc003_Name1.getText();
    }

    public void setXuc003_Name1(String Name1) {
        this.xuc003_Name1.setText(Name1);
    }

    public String getXuc003_Name2() {
        return xuc003_Name2.getText();
    }

    public void setXuc003_Name2(String Name2) {
        this.xuc003_Name2.setText(Name2);
    }

    public String getXuc003_Name3() {
        return xuc003_Name3.getText();
    }

    public void setXuc003_Name3(String Name3) {
        this.xuc003_Name3.setText(Name3);
    }

    public String getXuc003_Name4() {
        return xuc003_Name4.getText();
    }

    public void setXuc003_Name4(String Name4) {
        this.xuc003_Name4.setText(Name4);
    }

    public String getXuc003_Address() {
        return xuc003_Address.getText();
    }

    public void setXuc003_Address(String Address) {
        this.xuc003_Address.setText(Address);
    }

    public String getXuc003_City() {
        return xuc003_City.getText();
    }

    public void setXuc003_City(String City) {
        this.xuc003_City.setText(City);
    }

    public String getXuc003_State() {
        return xuc003_State.getText();
    }

    public void setXuc003_State(String State) {
        this.xuc003_State.setText(State);
    }

    public String getXuc003_ZipCode() {
        return xuc003_ZipCode.getText();
    }

    public void setXuc003_ZipCode(String ZipCode) {
        this.xuc003_ZipCode.setText(ZipCode);
    }

    public String getXuc003_ContactNumber() {
        return xuc003_ContactNumber.getText();
    }

    public void setXuc003_ContactNumber(String ContactNumber) {
        this.xuc003_ContactNumber.setText(ContactNumber);
    }

    // START XUC-001 Validation Feedback Mutators by Jeff Reifler
    public void setXuc001_lblParcelID(boolean feedback) {
        if (feedback) {
            this.xuc001_lblParcelID.setForeground(Color.RED);
        } else {
            this.xuc001_lblParcelID.setForeground(Color.black);
        }
    }

    public void setXuc001_lblTownship(boolean feedback) {
        if (feedback) {
            this.xuc001_lblTownship.setForeground(Color.RED);
        } else {
            this.xuc001_lblTownship.setForeground(Color.black);
        }
    }

    public void setXuc001_lblTaxAccountID(boolean feedback) {
        if (feedback) {
            this.xuc001_lblTaxAccountID.setForeground(Color.RED);
        } else {
            this.xuc001_lblTaxAccountID.setForeground(Color.black);
        }
    }

    public void setXuc001_lblRange(boolean feedback) {
        if (feedback) {
            this.xuc001_lblRange.setForeground(Color.RED);
        } else {
            this.xuc001_lblRange.setForeground(Color.black);
        }
    }

    public void setXuc001_lblCounty(boolean feedback) {
        if (feedback) {
            this.xuc001_lblCounty.setForeground(Color.RED);
        } else {
            this.xuc001_lblCounty.setForeground(Color.black);
        }
    }

    public void setXuc001_lblState(boolean feedback) {
        if (feedback) {
            this.xuc001_lblState.setForeground(Color.RED);
        } else {
            this.xuc001_lblState.setForeground(Color.black);
        }
    }

    public void setXuc001_lblSection(boolean feedback) {
        if (feedback) {
            this.xuc001_lblSection.setForeground(Color.RED);
        } else {
            this.xuc001_lblSection.setForeground(Color.black);
        }
    }

    public void setXuc001_lblMeridian(boolean feedback) {
        if (feedback) {
            this.xuc001_lblMeridian.setForeground(Color.RED);
        } else {
            this.xuc001_lblMeridian.setForeground(Color.black);
        }
    }

    public void setXuc001_lblAcreage(boolean feedback) {
        if (feedback) {
            this.xuc001_lblAcreage.setForeground(Color.RED);
        } else {
            this.xuc001_lblAcreage.setForeground(Color.black);
        }
    }

    public void setXuc001_lblLegalDescription(boolean feedback) {
        if (feedback) {
            this.xuc001_lblLegalDescription.setForeground(Color.RED);
        } else {
            this.xuc001_lblLegalDescription.setForeground(Color.black);
        }
    }

    public void setXuc001_cbxBounders(boolean feedback) {
        if (feedback) {
            this.xuc001_cbxBounders.setForeground(Color.RED);
        } else {
            this.xuc001_cbxBounders.setForeground(Color.black);
        }
    }

    public void setXuc001_lblNorthBounder(boolean feedback) {
        if (feedback) {
            this.xuc001_lblNorthBounder.setForeground(Color.RED);
        } else {
            this.xuc001_lblNorthBounder.setForeground(Color.black);
        }
    }

    public void setXuc001_lblEastBounder(boolean feedback) {
        if (feedback) {
            this.xuc001_lblEastBounder.setForeground(Color.RED);
        } else {
            this.xuc001_lblEastBounder.setForeground(Color.black);
        }
    }

    public void setXuc001_lblSouthBounder(boolean feedback) {
        if (feedback) {
            this.xuc001_lblSouthBounder.setForeground(Color.RED);
        } else {
            this.xuc001_lblSouthBounder.setForeground(Color.black);
        }
    }

    public void setXuc001_lblWestBounder(boolean feedback) {
        if (feedback) {
            this.xuc001_lblWestBounder.setForeground(Color.RED);
        } else {
            this.xuc001_lblWestBounder.setForeground(Color.black);
        }
    }

    public void setXuc002_lblSurfaceOwnership(boolean feedback) {
        if (feedback) {
            this.xuc002_lblSurfaceOwnership.setForeground(Color.RED);
        } else {
            this.xuc002_lblSurfaceOwnership.setForeground(Color.black);
        }
    }

    public void setXuc003_lblMineralOwnership(boolean feedback) {
        if (feedback) {
            this.xuc003_lblMineralOwnership.setForeground(Color.RED);
        } else {
            this.xuc003_lblMineralOwnership.setForeground(Color.black);
        }
    }

    // START XUC-002 Validation Feedback Mutators by Jeff Reifler
    public void setXuc002_lblName1(boolean feedback) {
        if (feedback) {
            this.xuc002_lblName1.setForeground(Color.RED);
        } else {
            this.xuc002_lblName1.setForeground(Color.black);
        }
    }

    public void setXuc002_lblName2(boolean feedback) {
        if (feedback) {
            this.xuc002_lblName2.setForeground(Color.RED);
        } else {
            this.xuc002_lblName2.setForeground(Color.black);
        }
    }

    public void setXuc002_lblName3(boolean feedback) {
        if (feedback) {
            this.xuc002_lblName3.setForeground(Color.RED);
        } else {
            this.xuc002_lblName3.setForeground(Color.black);
        }
    }

    public void setXuc002_lblName4(boolean feedback) {
        if (feedback) {
            this.xuc002_lblName4.setForeground(Color.RED);
        } else {
            this.xuc002_lblName4.setForeground(Color.black);
        }
    }

    public void setXuc002_lblAddress(boolean feedback) {
        if (feedback) {
            this.xuc002_lblAddress.setForeground(Color.RED);
        } else {
            this.xuc002_lblAddress.setForeground(Color.black);
        }
    }

    public void setXuc002_lblCity(boolean feedback) {
        if (feedback) {
            this.xuc002_lblCity.setForeground(Color.RED);
        } else {
            this.xuc002_lblCity.setForeground(Color.black);
        }
    }

    public void setXuc002_lblState(boolean feedback) {
        if (feedback) {
            this.xuc002_lblState.setForeground(Color.RED);
        } else {
            this.xuc002_lblState.setForeground(Color.black);
        }
    }

    public void setXuc002_lblZipCode(boolean feedback) {
        if (feedback) {
            this.xuc002_lblZipCode.setForeground(Color.RED);
        } else {
            this.xuc002_lblZipCode.setForeground(Color.black);
        }
    }

    public void setXuc002_lblContactNumber(boolean feedback) {
        if (feedback) {
            this.xuc002_lblContactNumber.setForeground(Color.RED);
        } else {
            this.xuc002_lblContactNumber.setForeground(Color.black);
        }
    }

    // START XUC-003 Validation Feedback Mutators by Jeff Reifler
    public void setXuc003_lblStatus(boolean feedback) {
        if (feedback) {
            this.xuc003_lblStatus.setForeground(Color.RED);
        } else {
            this.xuc003_lblStatus.setForeground(Color.black);
        }
    }

    public void setXuc003_lblInterest(boolean feedback) {
        if (feedback) {
            this.xuc003_lblInterest.setForeground(Color.RED);
        } else {
            this.xuc003_lblInterest.setForeground(Color.black);
        }
    }

    public void setXuc003_lblName1(boolean feedback) {
        if (feedback) {
            this.xuc003_lblName1.setForeground(Color.RED);
        } else {
            this.xuc003_lblName1.setForeground(Color.black);
        }
    }

    public void setXuc003_lblName2(boolean feedback) {
        if (feedback) {
            this.xuc003_lblName2.setForeground(Color.RED);
        } else {
            this.xuc003_lblName2.setForeground(Color.black);
        }
    }

    public void setXuc003_lblName3(boolean feedback) {
        if (feedback) {
            this.xuc003_lblName3.setForeground(Color.RED);
        } else {
            this.xuc003_lblName3.setForeground(Color.black);
        }
    }

    public void setXuc003_lblName4(boolean feedback) {
        if (feedback) {
            this.xuc003_lblName4.setForeground(Color.RED);
        } else {
            this.xuc003_lblName4.setForeground(Color.black);
        }
    }

    public void setXuc003_lblAddress(boolean feedback) {
        if (feedback) {
            this.xuc003_lblAddress.setForeground(Color.RED);
        } else {
            this.xuc003_lblAddress.setForeground(Color.black);
        }
    }

    public void setXuc003_lblCity(boolean feedback) {
        if (feedback) {
            this.xuc003_lblCity.setForeground(Color.RED);
        } else {
            this.xuc003_lblCity.setForeground(Color.black);
        }
    }

    public void setXuc003_lblState(boolean feedback) {
        if (feedback) {
            this.xuc003_lblState.setForeground(Color.RED);
        } else {
            this.xuc003_lblState.setForeground(Color.black);
        }
    }

    public void setXuc003_lblZipCode(boolean feedback) {
        if (feedback) {
            this.xuc003_lblZipCode.setForeground(Color.RED);
        } else {
            this.xuc003_lblZipCode.setForeground(Color.black);
        }
    }

    public void setXuc003_lblContactNumber(boolean feedback) {
        if (feedback) {
            this.xuc003_lblContactNumber.setForeground(Color.RED);
        } else {
            this.xuc003_lblContactNumber.setForeground(Color.black);
        }
    }

    public boolean getXuc003_cbxLastKnownAddress() {
        return this.xuc003_cbxLastKnownAddress.isSelected();
    }

    public String getXuc003_cboDocumentType() {
        return this.xuc003_cboDocumentType.getSelectedItem().toString();
    }

    public String getXuc003_EffectiveDate() {
        return this.xuc003_EffectiveDate.getText();
    }

    public String getXuc003_RecordingDate() {
        return this.xuc003_RecordingDate.getText();
    }

    public String getXuc003_DocumentID() {
        return this.xuc003_DocumentID.getText();
    }

    public String getXuc003_Book() {
        return this.xuc003_Book.getText();
    }

    public String getXuc003_Page() {
        return this.xuc003_Page.getText();
    }

    public void setXuc003_cboDocumentType(String uc001_cboDocumentType) {
        for (int index = 0; index < DeedList.length; index++) {
            if (this.DeedList[index].equals(uc001_cboDocumentType)) {
                this.xuc003_cboDocumentType.setSelectedIndex(index);
            }
        }
    }

    public void setXuc003_EffectiveDate(String uc001_EffectiveDate) {
        this.xuc003_EffectiveDate.setText(uc001_EffectiveDate);
    }

    public void setXuc003_RecordingDate(String uc001_RecordingDate) {
        this.xuc003_RecordingDate.setText(uc001_RecordingDate);
    }

    public void setXuc003_DocumentID(String uc001_DocumentID) {
        this.xuc003_DocumentID.setText(uc001_DocumentID);
    }

    public void setXuc003_Book(String uc001_Book) {
        this.xuc003_Book.setText(uc001_Book);
    }

    public void setXuc003_Page(String uc001_Page) {
        this.xuc003_Page.setText(uc001_Page);
    }

    public void setXuc003_lblEffectiveDate(boolean feedback) {
        if (feedback) {
            this.xuc003_lblEffectiveDate.setForeground(Color.RED);
        } else {
            this.xuc003_lblEffectiveDate.setForeground(Color.black);
        }
    }

    public void setXuc003_lblRecordingDate(boolean feedback) {
        if (feedback) {
            this.xuc003_lblRecordedDate.setForeground(Color.RED);
        } else {
            this.xuc003_lblRecordedDate.setForeground(Color.black);
        }
    }

    public void setXuc003_lblDocumentID(boolean feedback) {
        if (feedback) {
            this.xuc003_lblDocumentID.setForeground(Color.RED);
        } else {
            this.xuc003_lblDocumentID.setForeground(Color.black);
        }
    }

    public void setXuc003_lblBook(boolean feedback) {
        if (feedback) {
            this.xuc003_lblBook.setForeground(Color.RED);
        } else {
            this.xuc003_lblBook.setForeground(Color.black);
        }
    }

    public void setXuc003_lblPage(boolean feedback) {
        if (feedback) {
            this.xuc003_lblPage.setForeground(Color.RED);
        } else {
            this.xuc003_lblPage.setForeground(Color.black);
        }
    }

    public String getXuc002_cboDocumentType() {
        return this.xuc002_cboDocumentType.getSelectedItem().toString();
    }

    public String getXuc002_EffectiveDate() {
        return this.xuc002_EffectiveDate.getText();
    }

    public String getXuc002_RecordingDate() {
        return this.xuc002_RecordingDate.getText();
    }

    public String getXuc002_DocumentID() {
        return this.xuc002_DocumentID.getText();
    }

    public String getXuc002_Book() {
        return this.xuc002_Book.getText();
    }

    public String getXuc002_Page() {
        return this.xuc002_Page.getText();
    }

    public void setXuc002_cboDocumentType(String uc001_cboDocumentType) {
        for (int index = 0; index < DeedList.length; index++) {
            if (this.DeedList[index].equals(uc001_cboDocumentType)) {
                this.xuc002_cboDocumentType.setSelectedIndex(index);
            }
        }
    }

    public void setXuc002_EffectiveDate(String uc001_EffectiveDate) {
        this.xuc002_EffectiveDate.setText(uc001_EffectiveDate);
    }

    public void setXuc002_RecordingDate(String uc001_RecordingDate) {
        this.xuc002_RecordingDate.setText(uc001_RecordingDate);
    }

    public void setXuc002_DocumentID(String uc001_DocumentID) {
        this.xuc002_DocumentID.setText(uc001_DocumentID);
    }

    public void setXuc002_Book(String uc001_Book) {
        this.xuc002_Book.setText(uc001_Book);
    }

    public void setXuc002_Page(String uc001_Page) {
        this.xuc002_Page.setText(uc001_Page);
    }

    public void setXuc002_lblEffectiveDate(boolean feedback) {
        if (feedback) {
            this.xuc002_lblEffectiveDate.setForeground(Color.RED);
        } else {
            this.xuc002_lblEffectiveDate.setForeground(Color.black);
        }
    }

    public void setXuc002_lblRecordingDate(boolean feedback) {
        if (feedback) {
            this.xuc002_lblRecordedDate.setForeground(Color.RED);
        } else {
            this.xuc002_lblRecordedDate.setForeground(Color.black);
        }
    }

    public void setXuc002_lblDocumentID(boolean feedback) {
        if (feedback) {
            this.xuc002_lblDocumentID.setForeground(Color.RED);
        } else {
            this.xuc002_lblDocumentID.setForeground(Color.black);
        }
    }

    public void setXuc002_lblBook(boolean feedback) {
        if (feedback) {
            this.xuc002_lblBook.setForeground(Color.RED);
        } else {
            this.xuc002_lblBook.setForeground(Color.black);
        }
    }

    public void setXuc002_lblPage(boolean feedback) {
        if (feedback) {
            this.xuc002_lblPage.setForeground(Color.RED);
        } else {
            this.xuc002_lblPage.setForeground(Color.black);
        }
    }

}
