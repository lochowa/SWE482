package swe482_Main;
/**
 *
 * @author by Michael Barth
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;


public class VMenu extends JFrame  {

    public static class CloseListener extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            e.getWindow().setVisible(false);
            System.exit(0);
        }
    }

    // CloseListener Class Object
    

    VMenu() {
        initComponents();
    }
    
    public enum UserActions {
        START_FUNCTION,
        CLOSE_MENU
    }

    void addController(ActionListener controller) {
        System.out.println("View: Adding Menu Controller");
        _StartFunction.addActionListener(controller);
        _CancelButton.addActionListener(controller);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(240, 320));
        _FunctionList = new JList(FunctionList);
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
                buttonBar.add(_StartFunction, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                //---- _CancelButton ----
                _CancelButton.setText("Cancel");
                _CancelButton.setActionCommand(UserActions.CLOSE_MENU.name());
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
    private final String[] FunctionList = {
        "ADD ABSTRACT TITLE PACKAGE",
        "ADD PAID-UP LEASE"
    };
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private void _FunctionListValueChanged(ListSelectionEvent e) {
        // Operation assigns .setActionCommand to the _StartFunction button.
        if (!_FunctionList.isSelectionEmpty()) {
            String command = _FunctionList.getSelectedValue().replaceAll(" ", "_");
            _StartFunction.setActionCommand(command);

        }
    }
}
