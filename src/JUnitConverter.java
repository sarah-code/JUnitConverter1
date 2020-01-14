import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.util.*;


public class JUnitConverter 
{
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
	
	int varA;

	public void readUnits()
	{
		//100 cm = 1m, 1000 m = 1 km, 1 in = 2.51 cm, 12 in = 1 ft, 5280 ft = 1 mi, 1 mi = 1.6 km, 1ft = 0.3048 m, 1 m = 3.28084 ft
				oUnits =  new ArrayList<String>(Arrays.asList("centimeter", "meter", "kilometer", "inch", "feet", "miles"));
				convUnits = oUnits;
	}
	public void start()
	{
		
		try
		{
			
		
			int choice;
			double valuengdl;
			double valuengml;
			double valuenmoll;
			Scanner nmoll;
			Scanner nmoll1;
			String mode;
			Scanner ngdl;
			Scanner ngml;
			System.out.println("This programme calculates testosterone values\n================= \nfrom 1. nmol/L to ng/ml\n 2. nmol/L to ng/dL\n 3. ng/dL to nmol/L\n4. ng/mL to nmol/L\n5. Show stored values\n 6. Flush values. \n 7. EXIT.");
			Scanner menu = new Scanner(System.in);
			choice = menu.nextInt();
			
			switch(choice)
			{
				case 1: 
				mode = "nmol/L to ng/ml";
				System.out.println("You have selected "+mode+". Please enter your values:");
				nmoll = new Scanner(System.in);
				valuenmoll = nmoll.nextDouble();
				
				valuengml =  valuenmoll * 0.314465;
				System.out.println(valuenmoll+" nmol/L are "+valuengml+" ng/mL.");
				
				start();
				break;
				case 2: 
					mode = "nmol/L to ng/dL";
					System.out.println("You have selected "+mode+". Please enter your values:");
					nmoll1 = new Scanner(System.in);
					valuenmoll = nmoll1.nextDouble();
					
					valuengdl =  valuenmoll * 28.842;
					System.out.println(valuenmoll+" nmol/L are "+valuengdl+" ng/dL.");
					
					start();
					break;
				case 3: 
					mode = "ng/dL to nmol/L";
					System.out.println("You have selected "+mode+". Please enter your values:");
					ngdl = new Scanner(System.in);
					valuengdl = ngdl.nextDouble();
					
					valuenmoll =  valuengdl * 	0.0347;
					System.out.println(valuengdl+" ng/dL are "+valuenmoll+" nmol/L.");
					
					start();
					break;
				case 4: 
					mode = "ng/dL to nmol/L";
					System.out.println("You have selected "+mode+". Please enter your values:");
					ngml = new Scanner(System.in);
					valuengml = ngml.nextDouble();
					
					valuenmoll =  valuengml * 	0.314465;
					System.out.println(valuengml+" ng/mL are "+valuenmoll+" nmol/L.");
					
					start();
					break;
					default: System.out.println("Invalid entry."); start();
				
			}
			
			menu.close();
			
		}
		catch(Exception E)
		{
			System.out.println(E+"was caught");
		}
	}
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
