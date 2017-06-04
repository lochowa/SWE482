package mbarthSandbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddPanelTestCode
{
  JPanel visiblePanel = new JPanel(new FlowLayout()); //is the default, but showing it set
  public void buildGUI()
  {
    visiblePanel.setBorder(BorderFactory.createTitledBorder("Visible Panel"));
    JButton btn2 = new JButton("Add JPanel");
    JPanel p = new JPanel(new GridLayout(1,2));
    p.add(btn2);
 
    JFrame f = new JFrame();
    f.getContentPane().add(visiblePanel);
    f.getContentPane().add(p,BorderLayout.SOUTH);
    f.setSize(400,300);
    f.setResizable(false);
    f.setLocationRelativeTo(null);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    btn2.addActionListener((ActionEvent ae) -> {
        visiblePanel.add(createJPanel());
        visiblePanel.revalidate();
        visiblePanel.repaint();
    });
  }

  private JPanel createJPanel(){
      
      JTextField netInterest = new JTextField();
      netInterest.setText(".125");
      
      JTextField status = new JTextField();
      status.setText("Open");
      
      JTextField mineralOwner = new JTextField();
      mineralOwner.setText("Michael");
      
      JTextField source = new JTextField();
      source.setText("125/42");
      
      JTextField date = new JTextField();
      date.setText("06/17/1940");
      
      JPanel panel = new JPanel(new GridLayout(1,5,5,5));
          
      panel.add(netInterest);
      panel.add(status);
      panel.add(mineralOwner);
      panel.add(source);
      panel.add(date);
      return panel;
  }

  public static void main(String[] args)
  {
    SwingUtilities.invokeLater(() -> {
        new AddPanelTestCode().buildGUI();
    });
  }
}


