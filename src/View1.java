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

    private ArrayList<String> oUnits;
    private ArrayList<String> convUnits;

    public View1 ()
    {
        readUnits();
        String[] unitCategories = {"----------", "Distance", "Mass", "Medical"};
        for (String cat : unitCategories)
        {
            unitCategory.addItem(cat);
        }
        for (Object unit : getoUnits())
        {
            originalUnit.addItem(unit.toString());
        }
        for (Object convUnit : getConvUnits())
        {
            convertedUnit.addItem(convUnit.toString());
        }


        convertButton.addActionListener(this);

    }
    public void readUnits()
    {
        //100 cm = 1m, 1000 m = 1 km, 1 in = 2.51 cm, 12 in = 1 ft, 5280 ft = 1 mi, 1 mi = 1.6 km, 1ft = 0.3048 m, 1 m = 3.28084 ft
        oUnits =  new ArrayList<String>(Arrays.asList("----------", "centimeter", "meter", "kilometer", "inch", "feet", "miles"));
        convUnits = oUnits;
    }


    public ArrayList<String> getoUnits() {
        return oUnits;
    }

    public ArrayList<String> getConvUnits() {
        return convUnits;
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

