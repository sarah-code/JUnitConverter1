import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class View {
    static JLabel oUnitText;
    static JTextField oUnitValue;
    static BoxLayout left;
    static BoxLayout right;
    static JTextField conversionRate;
    static JLabel conversion;
    static JTextField conResult;
    static JLabel result;
    static JButton convert;
    static JComboBox categoryChoice;
    private ArrayList<String> oUnits;
    private ArrayList<String> convUnits;

    public void awtui()
    {
        JFrame frame = new JFrame("Convert Units");
        GridBagLayout gridbaglay = new GridBagLayout();
        frame.setLayout(gridbaglay);

        oUnitText = new JLabel("Value to convert:");
        oUnitText.setSize(200,10);
        oUnitText.setLocation(20,15);
        oUnitValue = new JTextField("",30);
        oUnitValue.setSize(200,25);
        oUnitValue.setLocation(10,40);

        String [] unitCategories = { "Distance", "Mass", "Medical" };

        categoryChoice = new JComboBox<Object>(unitCategories);
        categoryChoice.setBounds(220,40,100,25);


        JComboBox<Object> originalUnit = new JComboBox(oUnits.toArray());
        originalUnit.setBounds(325,40,100,25);
        JComboBox<Object> convertedUnit = new JComboBox(convUnits.toArray());
        convertedUnit.setBounds(450,40,100,25);
        conResult = new JTextField();
        conResult.setSize(200,25);
        conResult.setLocation(500, 40);
        frame.setLayout(null);
        frame.add(categoryChoice);
        frame.add(originalUnit);
        frame.add(convertedUnit);
        frame.add(oUnitText);
        frame.add(oUnitValue);
        frame.add(conResult);

        frame.setSize(1000,800);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
        frame.setVisible(true);
        categoryChoice.setVisible(true);
    }
}
