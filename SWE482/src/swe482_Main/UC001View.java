package swe482_Main;

/**
 *
 * @author Michael Barth UC-001 UC001View Design Implementing XUC-001, XUC-002,
 * XUC-003, JDialog ModalityType.DOCUMENT_MODAL
 *
 * Add your @Author here.
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;
import java.util.UUID;
import javax.swing.event.ChangeEvent;

public class UC001View extends JFrame implements java.util.Observer {

    /*
        UC-001: Process Abstract Title Report
        - XUC-001 (Extends) Create Land Record
        - XUC-002 (Extends) Create Surface Owner Record
        - XUC-003 (Extends) Create Mineral Owner Record
        o Addendum XUC-003: Create Leasehold Record on NON-Open Status RTI (“Right Title Interest”
        o Addendum XUC-003 (Self-Help Feature): Convert Fractions to Decimals
         Not all abstract title reports report interest in decimal format.
        - XUC-004 (Extends) Checksum Mineral Interest
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
        OPEN_BURDEN
        
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
        this.xuc002_AddDocument.addActionListener(controller);
        this.xuc003_InsertButton.addActionListener(controller);
        this.xuc003_CancelButton.addActionListener(controller);
        this.xuc003_AttachBurden.addActionListener(controller);
    }
    
    
    /*
    *   XUC-001 Initial Dialog
     */
    private JFrame fXUC001;
    private JDialog dXUC001;
    private JPanel dpXUC001;     // Replaces IDE contentPane
    /*
    *   XUC-002 Dialog
     */
    private JDialog dXUC002;
    private JPanel dpXUC002;    // Replaces IDE contentPane
    /*
    *  XUC-003 Dialog
    */
    private JDialog dXUC003;
    private JPanel dpXUC003;   // Replaces IDE contentPane
    /*
    *  XUC-003 Burden Dialog
    */
    private JDialog bXUC003;
    private JPanel bpXUC003;    //  Replace IDE d
    
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
        JPanel pXUC001 = new JPanel();
        dpXUC001 = new JPanel();
//        START XUC-003 Create Property Record        
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
        xuc001_state = new JLabel();
        xuc001_State = new JTextField();
        xuc001_lblMeridian = new JLabel();
        xuc001_Meridian = new JTextField();
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

        //======== this ========
        dpXUC001.setBorder(new EmptyBorder(12, 12, 12, 12));
        dpXUC001.setLayout(new BorderLayout());

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

                //---- xuc001_state ----
                xuc001_state.setText("State");
                xuc001_state.setFont(xuc001_state.getFont().deriveFont(xuc001_state.getFont().getSize() + 2f));
                xuc001_contentPanel.add(xuc001_state, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
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
                xuc001_Meridian.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                xuc001_contentPanel.add(xuc001_Meridian, new GridBagConstraints(4, 4, 2, 1, 0.0, 0.0,
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
                        this.setXuc001NorthBounder(null);
                        this.xuc001_EastBounder.setEditable(false);
                        this.setXuc001EastBounder(null);
                        this.xuc001_SouthBounder.setEditable(false);
                        this.setXuc001SouthBounder(null);
                        this.xuc001_WestBounder.setEditable(false);
                        this.setXuc001WestBounder(null);
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
                    xuc001_boundersPanel.add(xuc001_NorthBounder, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_EastBounder ----
                    xuc001_EastBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_boundersPanel.add(xuc001_EastBounder, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_SouthBounder ----
                    xuc001_SouthBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    xuc001_boundersPanel.add(xuc001_SouthBounder, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                    //---- xuc001_WestBounder ----
                    xuc001_WestBounder.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
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
        dpXUC001.add(xuc001_dialogPane, BorderLayout.CENTER);
        dpXUC001.setVisible(true);

        pXUC001.add(dpXUC001);
        fXUC001.add(pXUC001);
        fXUC001.setSize(640, 880);
        fXUC001.setVisible(true);
        fXUC001.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fXUC001.setLocationRelativeTo(getOwner());
//        END XUC-003 Create Property Record

        /*
        *   XUC-002 Dialog: Add Surface Owner
         */
        dXUC002 = new JDialog(fXUC001, null, Dialog.ModalityType.DOCUMENT_MODAL);

        Container cpXUC002 = dXUC002.getContentPane();
        cpXUC002.setLayout(new BorderLayout());
        JPanel pdXUC002 = new JPanel();
//        ADD SURFACE OWNER JPANEL HERE
        dpXUC002 = new JPanel();

        dialogPane = new JPanel();
        contentPanel = new JPanel();
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
        xuc002_AddDocument = new JButton();
        xuc002_AddDocument.setActionCommand(UserActions.OPEN_DOCUMENT.name());
        xuc002_DocumentPane = new JPanel();
        buttonBar = new JPanel();
        xuc002_cbxActiveStatus = new JCheckBox();
        xuc002_InsertButton = new JButton();
        xuc002_InsertButton.setActionCommand(UserActions.INSERT_SURFACEOWNER.name());
        xuc002_CancelButton = new JButton();
        xuc002_CancelButton.setActionCommand(UserActions.CLOSE_SURFACEOWNER.name());

        //======== this ========
        dpXUC002.setBorder(new EmptyBorder(12, 12, 12, 12));
        dpXUC002.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setFont(contentPanel.getFont().deriveFont(contentPanel.getFont().getSize() + 1f));
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{70, 70, 140, 135, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- xuc002_NameQuery ----
                xuc002_NameQuery.setAutoscrolls(false);
                xuc002_NameQuery.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_NameQuery, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_SearchName ----
                xuc002_SearchName.setText("Search Database");
                xuc002_SearchName.setActionCommand("SEARCHNAME");
                xuc002_SearchName.setMargin(new Insets(2, 15, 2, 15));
                xuc002_SearchName.setFont(xuc002_SearchName.getFont().deriveFont(xuc002_SearchName.getFont().getStyle() & ~Font.BOLD, xuc002_SearchName.getFont().getSize() + 1f));
                contentPanel.add(xuc002_SearchName, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 25, 0), 0, 0));

                //---- xuc002_lblName1 ----
                xuc002_lblName1.setText("Name #1");
                xuc002_lblName1.setFont(xuc002_lblName1.getFont().deriveFont(xuc002_lblName1.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblName1, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name1 ----
                xuc002_Name1.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_Name1, new GridBagConstraints(2, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName2 ----
                xuc002_lblName2.setText("Name #2");
                xuc002_lblName2.setFont(xuc002_lblName2.getFont().deriveFont(xuc002_lblName2.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblName2, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name2 ----
                xuc002_Name2.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_Name2, new GridBagConstraints(2, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName3 ----
                xuc002_lblName3.setText("Name #3");
                xuc002_lblName3.setFont(xuc002_lblName3.getFont().deriveFont(xuc002_lblName3.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblName3, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name3 ----
                xuc002_Name3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_Name3, new GridBagConstraints(2, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblName4 ----
                xuc002_lblName4.setText("Name #4");
                xuc002_lblName4.setFont(xuc002_lblName4.getFont().deriveFont(xuc002_lblName4.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblName4, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Name4 ----
                xuc002_Name4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_Name4, new GridBagConstraints(2, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblAddress ----
                xuc002_lblAddress.setText("Address");
                xuc002_lblAddress.setFont(xuc002_lblAddress.getFont().deriveFont(xuc002_lblAddress.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblAddress, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_Address ----
                xuc002_Address.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_Address, new GridBagConstraints(2, 6, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblCity ----
                xuc002_lblCity.setText("City");
                xuc002_lblCity.setFont(xuc002_lblCity.getFont().deriveFont(xuc002_lblCity.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblCity, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_City ----
                xuc002_City.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_City, new GridBagConstraints(2, 7, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_lblState ----
                xuc002_lblState.setText("State");
                xuc002_lblState.setFont(xuc002_lblState.getFont().deriveFont(xuc002_lblState.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblState, new GridBagConstraints(0, 8, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_State ----
                xuc002_State.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_State, new GridBagConstraints(2, 8, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblZipCode ----
                xuc002_lblZipCode.setText("Zip Code");
                xuc002_lblZipCode.setFont(xuc002_lblZipCode.getFont().deriveFont(xuc002_lblZipCode.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblZipCode, new GridBagConstraints(0, 9, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_ZipCode ----
                xuc002_ZipCode.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_ZipCode, new GridBagConstraints(2, 9, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_lblContactNumber ----
                xuc002_lblContactNumber.setText("Contact Number");
                xuc002_lblContactNumber.setFont(xuc002_lblContactNumber.getFont().deriveFont(xuc002_lblContactNumber.getFont().getSize() + 1f));
                contentPanel.add(xuc002_lblContactNumber, new GridBagConstraints(0, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- xuc002_ContactNumber ----
                xuc002_ContactNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(xuc002_ContactNumber, new GridBagConstraints(2, 10, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- xuc002_AddDocument ----
                xuc002_AddDocument.setText("Add Document");
                contentPanel.add(xuc002_AddDocument, new GridBagConstraints(0, 11, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //======== xuc002_DocumentPane ========
                {
                    xuc002_DocumentPane.setMinimumSize(new Dimension(0, 67));
                    xuc002_DocumentPane.setBorder(new EtchedBorder());
                    xuc002_DocumentPane.setPreferredSize(new Dimension(4, 67));
                    xuc002_DocumentPane.setLayout(new GridLayout());
                }
                contentPanel.add(xuc002_DocumentPane, new GridBagConstraints(0, 12, 4, 1, 0.0, 0.0,
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

                //---- xuc002_cbxActiveStatus ----
                xuc002_cbxActiveStatus.setText("Active?");
                xuc002_cbxActiveStatus.setFont(xuc002_cbxActiveStatus.getFont().deriveFont(xuc002_cbxActiveStatus.getFont().getSize() + 2f));
                xuc002_cbxActiveStatus.setSelected(true);
                buttonBar.add(xuc002_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc002_InsertButton ----
                xuc002_InsertButton.setText("INSERT");

                buttonBar.add(xuc002_InsertButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc002_CancelButton ----
                xuc002_CancelButton.setText("Cancel");
                buttonBar.add(xuc002_CancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        dpXUC002.add(dialogPane, BorderLayout.CENTER);
        pdXUC002.add(dpXUC002);
        dXUC002.add(pdXUC002);
        dXUC002.setSize(460, 520);
        dXUC002.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dXUC002.setLocationRelativeTo(getOwner());

        /*
        *   XUC-003 Dialog: Add Mineral Owner
         */
        dXUC003 = new JDialog(fXUC001, null, Dialog.ModalityType.DOCUMENT_MODAL);
        Container cpXUC003 = dXUC003.getContentPane();
        JPanel pdXUC003 = new JPanel();
//        ADD MINERAL OWNER JPANEL HERE
        dpXUC003 = new JPanel();
        
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
        xuc003_AddDocument = new JButton();
        xuc003_AddDocument.setActionCommand(UserActions.OPEN_DOCUMENT.name());
        xuc003_DocumentPane = new JPanel();
        xuc003_buttonBar = new JPanel();
        xuc003_cbxActiveStatus = new JCheckBox();
        xuc003_InsertButton = new JButton();
        xuc003_InsertButton.setActionCommand(UserActions.INSERT_MINERALOWNER.name());
        xuc003_CancelButton = new JButton();
        xuc003_CancelButton.setActionCommand(UserActions.CLOSE_MINERALOWNER.name());

        //======== this ========
        
        dpXUC003.setBorder(new EmptyBorder(12, 12, 12, 12));
        dpXUC003.setLayout(new BorderLayout());

        //======== xuc003_dialogPane ========
        {
            xuc003_dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            xuc003_dialogPane.setLayout(new BorderLayout());

            //======== xuc003_contentPanel ========
             {
                xuc003_contentPanel.setFont(xuc003_contentPanel.getFont().deriveFont(xuc003_contentPanel.getFont().getSize() + 1f));
                xuc003_contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)xuc003_contentPanel.getLayout()).columnWidths = new int[] {70, 70, 140, 135, 0};
                ((GridBagLayout)xuc003_contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)xuc003_contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)xuc003_contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

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

                //---- xuc003_AddDocument ----
                xuc003_AddDocument.setText("Add Document");
                xuc003_contentPanel.add(xuc003_AddDocument, new GridBagConstraints(0, 13, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 10, 5), 0, 0));

                //======== xuc003_DocumentPane ========
                {
                    xuc003_DocumentPane.setMinimumSize(new Dimension(0, 67));
                    xuc003_DocumentPane.setBorder(new EtchedBorder());
                    xuc003_DocumentPane.setPreferredSize(new Dimension(4, 67));
                    xuc003_DocumentPane.setLayout(new GridLayout());
                }
                xuc003_contentPanel.add(xuc003_DocumentPane, new GridBagConstraints(0, 14, 4, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc003_dialogPane.add(xuc003_contentPanel, BorderLayout.CENTER);

            //======== xuc003_buttonBar ========
            {
                xuc003_buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                xuc003_buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) xuc003_buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) xuc003_buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- xuc003_cbxActiveStatus ----
                xuc003_cbxActiveStatus.setText("Active?");
                xuc003_cbxActiveStatus.setFont(xuc003_cbxActiveStatus.getFont().deriveFont(xuc003_cbxActiveStatus.getFont().getSize() + 2f));
                xuc003_cbxActiveStatus.setSelected(true);
                xuc003_buttonBar.add(xuc003_cbxActiveStatus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc003_InsertButton ----
                xuc003_InsertButton.setText("INSERT");
                xuc003_buttonBar.add(xuc003_InsertButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- xuc003_CancelButton ----
                xuc003_CancelButton.setText("Cancel");
                xuc003_buttonBar.add(xuc003_CancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            xuc003_dialogPane.add(xuc003_buttonBar, BorderLayout.SOUTH);
        }
        
        dpXUC003.add(xuc003_dialogPane, BorderLayout.CENTER);
        pdXUC003.add(dpXUC003);
        dXUC003.add(pdXUC003);
        dXUC003.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dXUC003.setSize(490, 600);
        dXUC003.setLocationRelativeTo(getOwner());
        
        /*
        *   XUC003 Add Leasehold Burder
        */
//        bXUC003 = new JDialog(dXUC003, null, Dialog.ModalityType.DOCUMENT_MODAL);
//        Container cpbXUC003 = bXUC003.getContentPane();
//        JPanel pbXUC003 = new JPanel();
////        ADD MINERAL OWNER JPANEL HERE
//        bpXUC003 = new JPanel();
//        
//        
//        // INSERT new dialog UI above here.
//        pdXUC003.add(bpXUC003);
//        bXUC003.add(pdXUC003);
//        bXUC003.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        bXUC003.setSize(490, 600);
//        bXUC003.setLocationRelativeTo(getOwner());
        
    }

    public JDialog getdXUC002() {
        return this.dXUC002;
    }

    public JDialog getdXUC003() {
        return this.dXUC003;
    }

    public JFrame getfXUC001() {
        return this.fXUC001;
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
    private JLabel xuc001_state;
    private JTextField xuc001_State;
    private JLabel xuc001_lblMeridian;
    private JTextField xuc001_Meridian;
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

    // START XUC-002 Form Elements
    private JPanel dialogPane;
    private JPanel contentPanel;
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
    private JPanel buttonBar;
    private JCheckBox xuc002_cbxActiveStatus;
    private JButton xuc002_InsertButton;
    private JButton xuc002_CancelButton;

    // START XUC003 Form Elements
    private String[] statusOptions = {
        "OPEN",
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
    private JPanel xuc003_buttonBar;
    private JCheckBox xuc003_cbxActiveStatus;
    private JButton xuc003_InsertButton;
    private JButton xuc003_CancelButton;

    // START XUC-003 Add Burden Form Elements
    
    
// Getters for field values *Added by Andrew Lochow*
    public String getDBRecordID() {
        UUID UrecID = UUID.randomUUID();
        String recID = UrecID.toString();
        return recID;
    }

    public String geXuc001tParcelID() {
        return xuc001_ParcelID.getText();
    }
    
    public void setXuc001ParcelID(String parcelID){
        this.xuc001_ParcelID.setText(parcelID);
    }

    public String getXuc001TaxAccountID() {
        return xuc001_TaxAccountID.getText();
    }

    public String getXuc001County() {
        return xuc001_County.getText();
    }

    public String getXuc001State() {
        return xuc001_State.getText();
    }

    public int getXuc001Acreage() {
        return Integer.parseInt(xuc001_Acreage.getText());
    }

    public String getXuc001Township() {
        return xuc001_Township.getText();

    }

    public String getXuc001Range() {
        return xuc001_Range.getText();
    }

    public String getXuc001Section() {
        return xuc001_Section.getText();
    }

    public String getXuc001Description() {
        return xuc001_LegalDescription.getText();
    }

    public String getXuc001Meridian() {
        return xuc001_Meridian.getText();
    }

    public String getXuc001NorthBounder() {
        return xuc001_NorthBounder.getText();
    }

    public String getXuc001SouthBounder() {
        return xuc001_SouthBounder.getText();
    }

    public String getXuc001EastBounder() {
        return xuc001_EastBounder.getText();
    }

    public String getXuc001WestBounder() {
        return xuc001_WestBounder.getText();
    }

    public boolean getXuc001cbxBounders() {
        return xuc001_cbxBounders.isSelected();
    }

    public void setXuc001NorthBounder(String bounder) {
        this.xuc001_NorthBounder.setText(bounder);
    }

    public void setXuc001EastBounder(String bounder) {
        this.xuc001_EastBounder.setText(bounder);
    }

    public void setXuc001SouthBounder(String bounder) {
        this.xuc001_SouthBounder.setText(bounder);
    }

    public void setXuc001WestBounder(String bounder) {
        this.xuc001_WestBounder.setText(bounder);
    }

    public void addSurfaceOwnery(String description, int gridY) {
        xuc002_SurfaceOwnerPane.add(addComponent(description, gridY), new GridBagConstraints(0, gridY, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        xuc002_SurfaceOwnerPane.revalidate();
    }

    public void updateSurfaceOwner(String description, int gridY) {
        JPanel test = (JPanel) xuc002_SurfaceOwnerPane.getComponent(gridY);
        JTextField field = (JTextField) test.getComponent(0);
        field.setText(description);
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

    public JPanel addComponent(String owner, int index) {

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
        ((GridBagLayout) surface.getLayout()).columnWidths = new int[]{440, 0, 0};
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

    public void addMineralOwnery(String description, int gridY) {
        xuc003_MineralOwnerPane.add(addComponent(description, gridY), new GridBagConstraints(0, gridY, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        xuc003_MineralOwnerPane.revalidate();
    }

    public void updateMineralOwner(String description, int gridY) {
        JPanel test = (JPanel) xuc003_MineralOwnerPane.getComponent(gridY);
        JTextField field = (JTextField) test.getComponent(0);
        field.setText(description);
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

    public JPanel addMineralComponent(String owner, int index) {

        JPanel mineral = new JPanel();
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
        mineral.setLayout(new GridBagLayout());
        ((GridBagLayout) mineral.getLayout()).columnWidths = new int[]{440, 0, 0};
        ((GridBagLayout) mineral.getLayout()).rowHeights = new int[]{0, 0};
        ((GridBagLayout) mineral.getLayout()).columnWeights = new double[]{0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout) mineral.getLayout()).rowWeights = new double[]{0.0, 1.0E-4};

        //---- _owner ----
        _owner.setText(owner);
        _owner.setFont(_owner.getFont().deriveFont(_owner.getFont().getSize() + 2f));
        _owner.setEditable(false);
        mineral.add(_owner, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        // ---- _remove ----
        mineral.add(remove, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        //---- xuc007_EditProperty ----
        mineral.add(edit, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

        this.xuc002_EditMineralOwner = edit;
        this.xuc002_RemoveMineralOwner = remove;
        return mineral;
    }

    JButton xuc002_EditMineralOwner = new JButton();
    JButton xuc002_RemoveMineralOwner = new JButton();

    public JButton getEditMineralOwnerButton() {
        return this.xuc002_EditMineralOwner;
    }

    public JButton getRemoveMineralOwnerButton() {
        return this.xuc002_RemoveMineralOwner;
    }
}
