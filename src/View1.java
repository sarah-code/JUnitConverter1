import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class View1 extends JFrame implements ActionListener {
    public JFrame view = new JFrame();
    public JPanel converterPanel;
    private JComboBox<Object> unitCategory;
    private JComboBox<Object> originalUnit;
    private JTextField oUnitValue;
    private JTextField conResult;
    private JButton convertButton;
    private JButton resetButton;
    private JComboBox<Object> convertedUnit;
    Model cs = new Model();

    private String [] oUnits;
    private String [] convUnits;

    public View1 ()
    {
        //readUnits();
        String[] unitCategories = {"----------", "Distance", "Mass", "Medical"};
        for (String cat : unitCategories)
        {
            unitCategory.addItem(cat);
        }
        String init[] = {"----------"};
        addToCombo(init);
        if (unitCategory.getSelectedItem().equals("----------")) {
            originalUnit.setEnabled(false);
            oUnitValue.setEnabled(false);
            conResult.setEnabled(false);
            convertedUnit.setEnabled(false);
            convertButton.setEnabled(false);
            resetButton.setEnabled(false);
        }


        convertButton.addActionListener(this);

        unitCategory.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //if(e.getSource() == unitCategory) {
                            if (unitCategory.getSelectedItem().equals("----------")) {
                                originalUnit.setEnabled(false);
                                oUnitValue.setEnabled(false);
                                conResult.setEnabled(false);
                                convertedUnit.setEnabled(false);
                                convertButton.setEnabled(false);
                                resetButton.setEnabled(false);
                            } else {
                                originalUnit.setEnabled(true);
                                oUnitValue.setEnabled(true);
                                conResult.setEnabled(true);
                                convertedUnit.setEnabled(true);
                                convertButton.setEnabled(true);
                                resetButton.setEnabled(true);
                                String select = (String)unitCategory.getSelectedItem();
                                switch(select){
                                    case "Distance": String distances [] = {"----------", "centimeter", "meter", "kilometer", "inch", "feet", "miles"};
                                        addToCombo(distances); break;
                                    case "Mass":
                                        String mass [] = {"----------", "milligramm", "gramm", "kilogramm", "m ton", "us ton", "pound", "stone", "oz"};
                                        addToCombo(mass); break;
                                    case "Medical":
                                        String medical [] = {"----------", "mnol/L", "ng/dL", "pg/mL", "pmol/L"};
                                        addToCombo(medical); break;
                                }
                                if(unitCategory.getSelectedItem().equals("Distance"))
                                {

                                }
                                if(unitCategory.getSelectedItem().equals("Mass"))
                                {

                                }
                            }
                       // }
                    }
                }
        );

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
                double value = Integer.parseInt(oUnitValue.getText());
                System.out.println(value);
                String unitO = originalUnit.getSelectedItem().toString();
                String unitC = convertedUnit.getSelectedItem().toString();
                if(unitO.equals("----------") != false || !unitC.equals("----------") != false) {
                    String conConv = unitO.concat(unitC);
                    System.out.println(conConv);
                    System.out.println(cs.unittable.containsKey(conConv));
                    if (cs.unittable.containsKey(conConv))
                    {
                        System.out.println(cs.unittable.get(conConv));
                        double conversionRate = cs.unittable.get(conConv);
                        double result = value * conversionRate;
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

