import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class View extends JFrame implements ActionListener {
    public JFrame view = new JFrame();
    public JPanel converterPanel;
    private JComboBox<Object> unitCategory;
    private JComboBox<Object> originalUnit;
    private JTextField oUnitValue;
    private JTextField conResult;
    private JButton convertButton;
    private JButton resetButton;
    private JComboBox<Object> convertedUnit;
    private JButton switchButton;
    private JLabel oText;
    Model cs = new Model();
    Controller controller = new Controller();
    //Font arial = new Font("Arial", Font.PLAIN, 14);
    private String [] oUnits;
    private String [] convUnits;
    String units [];

    public View()
    {

        //readUnits();
        String [] unitCategories = cs.unitCategories();
        for (String cat : unitCategories)
        {
            unitCategory.addItem(cat);
        }


        String init[] = { unitCategories[0]};
        //switchButton.setFont(arial);
        switchButton.setText("\u2191  SWITCH  \u2193");
        conResult.setEditable(false);
        addToCombo(init);
        if (unitCategory.getSelectedItem().equals("----------")) {
            originalUnit.setEnabled(false);
            oUnitValue.setEnabled(false);
            switchButton.setEnabled(false);
            convertedUnit.setEnabled(false);
            convertButton.setEnabled(false);
            resetButton.setEnabled(false);
        }


        convertButton.addActionListener(this);

        switchButton.addActionListener((ActionEvent e) -> {
                        try {
                            int posO = originalUnit.getSelectedIndex();
                            int posC = convertedUnit.getSelectedIndex();
                            originalUnit.setSelectedIndex(posC);
                            convertedUnit.setSelectedIndex(posO);
                            double valO = Double.parseDouble(oUnitValue.getText());
                            double valC = Double.parseDouble(conResult.getText());
                            oUnitValue.setText(Double.toString(valC));
                            conResult.setText(Double.toString(valO));
                        }
                        catch (Exception npl)
                        {
                            JOptionPane.showMessageDialog(null, "The following exception occured: \n" + npl + "\n Please enter a valid entry into the first field.","Exception occured." , JOptionPane.ERROR_MESSAGE);
                        }
                    });

        resetButton.addActionListener ((ActionEvent e)->{
                        addToCombo(init);
                        oUnitValue.setText("");
                        conResult.setText("");
                        unitCategory.setSelectedIndex(0);});

        unitCategory.addActionListener((ActionEvent e)-> {
            if (unitCategory.getSelectedItem().equals("----------")) {
                originalUnit.setEnabled(false);
                oUnitValue.setEnabled(false);
                switchButton.setEnabled(false);
                convertedUnit.setEnabled(false);
                convertButton.setEnabled(false);
                resetButton.setEnabled(false);
            } else {
                originalUnit.setEnabled(true);
                oUnitValue.setEnabled(true);
                switchButton.setEnabled(true);
                convertedUnit.setEnabled(true);
                convertButton.setEnabled(true);
                resetButton.setEnabled(true);
                String select = (String) unitCategory.getSelectedItem();
                switch (select) {
                    case "Distance":
                        units = new String[]{"----------", "centimeter", "meter", "kilometer", "inch", "feet", "miles"};
                        break;
                    case "Mass":
                        units = new String[]{"----------", "milligramm", "gramm", "kilogramm", "m ton", "us ton", "pound", "stone", "oz"};
                        break;
                    case "Medical":
                        units = new String[]{"----------", "mnol/L", "ng/dL", "pg/mL", "pmol/L"};
                        break;
                }
                addToCombo(units);
            }
        });

    }

    public void addToCombo (String [] add)
    {
       originalUnit.removeAllItems();
        convertedUnit.removeAllItems();
        for (Object unit : add)
        {
            originalUnit.addItem(unit.toString());
        }
        for (Object convUnit : add)
        {
            convertedUnit.addItem(convUnit.toString());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cs.unittable.size() == 0) {
            cs.initUnittable();
        }
        if(e.getSource() == convertButton) {
            try {
                double value = Double.parseDouble(oUnitValue.getText());
                System.out.println(value);
                String unitO = originalUnit.getSelectedItem().toString();
                String unitC = convertedUnit.getSelectedItem().toString();

                String conConv = unitO.concat(unitC);
                if(conConv.contains("-") != true) {
                    System.out.println(conConv);
                    System.out.println(cs.unittable.containsKey(conConv));
                    if (cs.unittable.containsKey(conConv))
                    {
                        System.out.println(cs.unittable.get(conConv));
                        double conversionRate = cs.unittable.get(conConv);
                        // double result = value * conversionRate;
                        double result = controller.calcResult(value, conversionRate);
                        conResult.setText(Double.toString(result));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "The following exception occured: \n OUPPS. This combo is yet to be implemented. \n WIP.","Exception occured." , JOptionPane.ERROR_MESSAGE);
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(null, "The following exception occured: \n Invalid Unit \n Please enter a valid entry.","Exception occured." , JOptionPane.ERROR_MESSAGE);
                }


            } catch (Exception npe) {
                System.out.println(npe);
                JOptionPane.showMessageDialog(null, "The following exception occured: \n" + npe + "\n Please enter a valid entry.","Exception occured." , JOptionPane.ERROR_MESSAGE);

            }
        }

    }
}

