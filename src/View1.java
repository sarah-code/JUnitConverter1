import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class View1 {
    public JPanel converterPanel;
    private JComboBox UnitCategory;
    private JComboBox<Object> originalUnit;
    private JTextField oUnitValue;
    private JTextField conResult;
    private JButton CONVERTButton;
    private JButton resetButton;
    private JComboBox<Object> convertedUnit;
    private ArrayList<String> oUnits;
    private ArrayList<String> convUnits;

    public View1 ()
    {

    }
    public void readUnits()
    {
        //100 cm = 1m, 1000 m = 1 km, 1 in = 2.51 cm, 12 in = 1 ft, 5280 ft = 1 mi, 1 mi = 1.6 km, 1ft = 0.3048 m, 1 m = 3.28084 ft
        oUnits =  new ArrayList<String>(Arrays.asList("centimeter", "meter", "kilometer", "inch", "feet", "miles"));
        convUnits = oUnits;
    }
    public void awtui() {
        String[] unitCategories = {"Distance", "Mass", "Medical"};
        originalUnit = new JComboBox(oUnits.toArray());
        convertedUnit = new JComboBox(convUnits.toArray());
    }

}
