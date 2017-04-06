import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FactorFinder extends JFrame{

  private JButton submitButton, helpButton;
  private JLabel titleLabel, factorDisplay;
  private JTextField textField;

  public FactorFinder(){
    createUI();
    setSize(new Dimension(600, 400));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Factor Finder");
    setResizable(false);
  }

  private void createUI(){
    Box chiefBox = Box.createVerticalBox();
    Box topBox = Box.createHorizontalBox();
    Box middleBox = Box.createHorizontalBox();
    Box bottomBox = Box.createHorizontalBox();
    getContentPane().add(chiefBox);
    //--------------------------------------------------------------------------
    topBox.add(Box.createHorizontalStrut(10));
    titleLabel = new JLabel("Enter Coefficients: ");
    topBox.add(titleLabel);

    topBox.add(Box.createHorizontalStrut(10));

    textField = new JTextField(30);
    topBox.add(textField);
    //--------------------------------------------------------------------------
    helpButton = new JButton("Help");
    helpButton.addActionListener(new HelpButtonActionListener());
    middleBox.add(helpButton);

    middleBox.add(Box.createHorizontalStrut(10));

    submitButton = new JButton("Find Factors");
    submitButton.addActionListener(new SubmitButtonActionListener());
    middleBox.add(submitButton);
    //--------------------------------------------------------------------------
    bottomBox.add(Box.createHorizontalStrut(10));
    factorDisplay = new JLabel();
    bottomBox.add(factorDisplay);
    //--------------------------------------------------------------------------
    chiefBox.add(Box.createVerticalStrut(10));
    chiefBox.add(topBox);
    chiefBox.add(Box.createVerticalStrut(10));
    chiefBox.add(middleBox);
    chiefBox.add(Box.createVerticalStrut(10));
    chiefBox.add(bottomBox);
    chiefBox.add(Box.createVerticalStrut(600));
  }

  private void displayFactors(String[] factors){
    factorDisplay.setText("");
    StringBuilder sb = new StringBuilder();
    sb.append("<HTML>The following are factors: <br/>");
    for (String f : factors){
      if (f != null){sb.append(f + "<br/>");}
    }
    sb.append("</HTML>");
    factorDisplay.setText(sb.toString());
  }

  public static void main(String[] args){
    new FactorFinder().setVisible(true);


  }

  private class HelpButtonActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      String info = "Enter the coefficients of the polynomial with a space between each coefficient.\n" +
                    "You must include a zero if there is no coefficient for that power.\n" +
                    "Examples: \n" +
                    "3x^4 + 2x^2 + 6x + 1 would be entered as \"3 0 2 6 1\"\n" +
                    "19x^12 + x^3 + x + 4 would be entered as \"19 0 0 0 0 0 0 0 0 1 0 1 4\"\n" +
                    "-x^3+ 6x - 1 would be entered as \"-1 0 6 -1\"";
      JOptionPane.showMessageDialog(null, info, "Help", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  private class SubmitButtonActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
      String userInput = textField.getText();
      String[] convertedInput = userInput.split(" ");
      String[] factors = SyntheticDivision.findFactors(convertedInput);
      for (String s : factors){
        System.out.println(s);
      }
      displayFactors(factors);
    }
  }
}
