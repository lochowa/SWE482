package aLochowSandbox.main;
/**
 * @author Michael Barth
 */
import swe482_Main.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;


public class VDocument  {

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
        System.out.println("Document View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }

    public VDocument() {
        initComponents();
    }

    private enum Actions {
        INSERTDOCUMENT,
        CLOSEWINDOW
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Document Controller");
        _SaveDocument.addActionListener(controller);
        _CancelButton.addActionListener(controller);

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        lblRecordIdentification = new JLabel();
        _RecordIdentification = new JTextField();
        lblDocumentType = new JLabel();
        _cboDocumentType = new JComboBox();
        lblEffectiveDate = new JLabel();
        _EffectiveDate = new JTextField();
        lblRecordedDate = new JLabel();
        _RecordedDate = new JTextField();
        lblReceptionNumber = new JLabel();
        _ReceptionNumber = new JTextField();
        lblBook = new JLabel();
        _Book = new JTextField();
        lblPage = new JLabel();
        _Page = new JTextField();
        buttonBar = new JPanel();
        _SaveDocument = new JButton();
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
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[]{140, 140, 135, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[]{0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //---- lblRecordIdentification ----
                lblRecordIdentification.setText("Record Identification");
                contentPanel.add(lblRecordIdentification, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));
                _RecordIdentification.setEditable(false);
                contentPanel.add(_RecordIdentification, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- lblDocumentType ----
                lblDocumentType.setText("Document Type");
                lblDocumentType.setFont(lblDocumentType.getFont().deriveFont(lblDocumentType.getFont().getSize() + 1f));
                contentPanel.add(lblDocumentType, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _cboDocumentType ----
                _cboDocumentType.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_cboDocumentType, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblEffectiveDate ----
                lblEffectiveDate.setText("Effective Date");
                lblEffectiveDate.setFont(lblEffectiveDate.getFont().deriveFont(lblEffectiveDate.getFont().getSize() + 1f));
                contentPanel.add(lblEffectiveDate, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _EffectiveDate ----
                _EffectiveDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_EffectiveDate, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblRecordedDate ----
                lblRecordedDate.setText("Recorded Date");
                lblRecordedDate.setFont(lblRecordedDate.getFont().deriveFont(lblRecordedDate.getFont().getSize() + 1f));
                contentPanel.add(lblRecordedDate, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _RecordedDate ----
                _RecordedDate.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_RecordedDate, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblReceptionNumber ----
                lblReceptionNumber.setText("Document Number");
                lblReceptionNumber.setFont(lblReceptionNumber.getFont().deriveFont(lblReceptionNumber.getFont().getSize() + 1f));
                contentPanel.add(lblReceptionNumber, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _ReceptionNumber ----
                _ReceptionNumber.setFont(_ReceptionNumber.getFont().deriveFont(_ReceptionNumber.getFont().getSize() + 1f));
                _ReceptionNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_ReceptionNumber, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblBook ----
                lblBook.setText("Book");
                lblBook.setFont(lblBook.getFont().deriveFont(lblBook.getFont().getSize() + 1f));
                contentPanel.add(lblBook, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 5), 0, 0));

                //---- _Book ----
                _Book.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Book, new GridBagConstraints(1, 5, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 10, 0), 0, 0));

                //---- lblPage ----
                lblPage.setText("Page");
                lblPage.setFont(lblPage.getFont().deriveFont(lblPage.getFont().getSize() + 1f));
                contentPanel.add(lblPage, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- _Page ----
                _Page.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_Page, new GridBagConstraints(1, 6, 2, 1, 0.0, 0.0,
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

                //---- _SaveDocument ----
                _SaveDocument.setText("INSERT");
                _SaveDocument.setActionCommand(Actions.INSERTDOCUMENT.name());
                buttonBar.add(_SaveDocument, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JLabel lblRecordIdentification;
    private JTextField _RecordIdentification;
    private JLabel lblDocumentType;
    private JComboBox _cboDocumentType;
    private JLabel lblEffectiveDate;
    private JTextField _EffectiveDate;
    private JLabel lblRecordedDate;
    private JTextField _RecordedDate;
    private JLabel lblReceptionNumber;
    private JTextField _ReceptionNumber;
    private JLabel lblBook;
    private JTextField _Book;
    private JLabel lblPage;
    private JTextField _Page;
    private JPanel buttonBar;
    private JButton _SaveDocument;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    String getRecordIdentification(){
        return this._RecordIdentification.getText();
    }
    
    void setRecordIdentification(int number){
        _RecordIdentification.setText(Integer.toString(number));
    }
    
    String getDocumentType(){
        return _cboDocumentType.getSelectedItem().toString();
    }
    
    String getEffectiveDate(){
        return _EffectiveDate.getText();
    }
    
    String getRecordingDate(){ 
        return _RecordedDate.getText(); 
    }
    
    String getReceptionNumber(){
        return this._ReceptionNumber.getText();
    }
    
    void setReceptionNumber(int number){
        this._ReceptionNumber.setText(Integer.toString(number));
    }
    
    String getBook(){
        return this._Book.getText();
    }
    
    String getPage(){
        return this._Page.getText();
    }
}
