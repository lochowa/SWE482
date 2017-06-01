package JavaApp.mvccompliant;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author by Michael Barth
 */
public class VMenu extends JFrame implements java.util.Observer {

    @Override
    public void update(Observable obs, Object obj) {
        // Test Script:  Who called the operation and what did they send?
        System.out.println("Menu View : Observable is " + obj.getClass() + ", object passed is " + obj.getClass());
    }

    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    VMenu() {
        initComponents();
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Menu Controller");
        _StartFunction.addActionListener(controller);
        _CancelButton.addActionListener(controller);
    }

    private void _StartFunctionActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void _CancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(240,320));
        _FunctionList = new JList(new SysFeatures().buildList());
        _FunctionList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _FunctionList.setAutoscrolls(false);
        _FunctionList.addListSelectionListener(e -> _FunctionListValueChanged(e));
        buttonBar = new JPanel();
        _StartFunction = new JButton();
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
                contentPanel.setLayout(new GridLayout(1, 0, 5, 10));

                //======== scrollPane ========
                {
                    scrollPane.setViewportView(_FunctionList);
                }
                contentPanel.add(scrollPane);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout) buttonBar.getLayout()).columnWidths = new int[]{0, 85, 80};
                ((GridBagLayout) buttonBar.getLayout()).columnWeights = new double[]{1.0, 0.0, 0.0};

                //---- _StartFunction ----
                _StartFunction.setText("Start Function");

                _StartFunction.addActionListener(e -> _StartFunctionActionPerformed(e));
                buttonBar.add(_StartFunction, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- _CancelButton ----
                _CancelButton.setText("Cancel");
                _CancelButton.setActionCommand("CLOSEWINDOW");
                _CancelButton.addActionListener(e -> _CancelButtonActionPerformed(e));
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
    private JScrollPane scrollPane;
    private JList<String> _FunctionList;
    private JPanel buttonBar;
    private JButton _StartFunction;
    private JButton _CancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void _FunctionListValueChanged(ListSelectionEvent e) {
        // Operation assigns .setActionCommand to the _StartFunction button.
        if (!_FunctionList.isSelectionEmpty()) {
            String command = _FunctionList.getSelectedValue().replaceAll(" ", "_");
            _StartFunction.setActionCommand(command);

        }
    }
}
