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

public class VFractionTool extends JFrame implements java.util.Observer {

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
        System.out.println("FractionTool View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }
    public VFractionTool() {
        initComponents();
    }

    private enum Actions{
        CLOSEWINDOW,
        INSERTDECIMAL,
        CONVERTFRACTION
    }
    
        void addController(ActionListener controller) {
        System.out.println("View: Adding Menu Controller");
        _InsertDecimal.addActionListener(controller);
        _CancelButton.addActionListener(controller);
        _ConvertFraction.addActionListener(controller);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        headerFractionConversionTool = new JLabel();
        _TopNumber = new JTextField();
        lblDividedBY = new JLabel();
        _BottomNumber = new JTextField();
        lblSumEQUALS = new JLabel();
        _Decimal = new JTextField();
        buttonBar = new JPanel();
        _ConvertFraction = new JButton();
        _InsertDecimal = new JButton();
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
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {140, 0, 140, 0, 135, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 30, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                //---- headerFractionConversionTool ----
                headerFractionConversionTool.setText("Fraction Conversions Self-Help Tool");
                headerFractionConversionTool.setFont(headerFractionConversionTool.getFont().deriveFont(headerFractionConversionTool.getFont().getStyle() | Font.BOLD, headerFractionConversionTool.getFont().getSize() + 1f));
                contentPanel.add(headerFractionConversionTool, new GridBagConstraints(0, 0, 5, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 10, 0), 0, 0));

                //---- _TopNumber ----
                _TopNumber.setAutoscrolls(false);
                _TopNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_TopNumber, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- lblDividedBY ----
                lblDividedBY.setText("/");
                lblDividedBY.setFont(lblDividedBY.getFont().deriveFont(lblDividedBY.getFont().getStyle() | Font.BOLD, lblDividedBY.getFont().getSize() + 10f));
                lblDividedBY.setHorizontalAlignment(SwingConstants.CENTER);
                contentPanel.add(lblDividedBY, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- _BottomNumber ----
                _BottomNumber.setAutoscrolls(false);
                _BottomNumber.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                contentPanel.add(_BottomNumber, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- lblSumEQUALS ----
                lblSumEQUALS.setText("=");
                lblSumEQUALS.setHorizontalAlignment(SwingConstants.CENTER);
                lblSumEQUALS.setFont(lblSumEQUALS.getFont().deriveFont(lblSumEQUALS.getFont().getStyle() | Font.BOLD, lblSumEQUALS.getFont().getSize() + 10f));
                contentPanel.add(lblSumEQUALS, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- _Decimal ----
                _Decimal.setAutoscrolls(false);
                _Decimal.setEditable(false);
                contentPanel.add(_Decimal, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
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

                //---- _ConvertFraction ----
                _ConvertFraction.setText("Convert Fraction");
                _ConvertFraction.setActionCommand(Actions.CONVERTFRACTION.name());
                buttonBar.add(_ConvertFraction, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- _InsertDecimal ----
                _InsertDecimal.setText("INSERT");
                _InsertDecimal.setActionCommand(Actions.INSERTDECIMAL.name());
                buttonBar.add(_InsertDecimal, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JLabel headerFractionConversionTool;
    private JTextField _TopNumber;
    private JLabel lblDividedBY;
    private JTextField _BottomNumber;
    private JLabel lblSumEQUALS;
    private JTextField _Decimal;
    private JPanel buttonBar;
    private JButton _ConvertFraction;
    private JButton _InsertDecimal;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    String getTopNumber(){
        return this._TopNumber.getText();
    }
    
    String getBottomNumber(){
        return this._BottomNumber.getText();
    }
    
    void setDecimal(double Decimal){
        this._Decimal.setText(Double.toString(Decimal));
    }
}
