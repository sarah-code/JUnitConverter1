import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.JComboBox;
import java.awt.event.*;
import java.util.*;
public class JUnitConverter extends JFrame
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
	public String [] oUnits;
	public String [] convUnits;
	
	int varA;
	
	public String[] readUnits()
	{
		oUnits = { "centimeter", "inch", "meter", "feet" };
		convUnits = new String [oUnits.length];
		for (int i = 0; i > oUnits.length; i++)
		{
			convUnits[i] = oUnits[i];
		}
		
		return oUnits;
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
	public static void main (String args[])
	{
		
		
		
		
		JFrame frame = new JFrame("Convert Units");
		GridBagLayout gridbaglay = new GridBagLayout();
		frame.setLayout(gridbaglay);
		
		oUnitText = new JLabel("Value to convert:");
		oUnitText.setSize(200,10);
		oUnitText.setLocation(20,15);
		oUnitValue = new JTextField("",30);
		oUnitValue.setSize(300,25);
		oUnitValue.setLocation(10,40);
		
		String [] unitCategories = { "Distance", "Mass/Weight", "Medical" };
		categoryChoice = new JComboBox(unitCategories);
		categoryChoice.setBounds(320,40,150,25);
		

		JComboBox originalUnit = new JComboBox(oUnits);
		categoryChoice.setBounds(500,40,150,25);
		conResult = new JTextField();
		conResult.setSize(200,10);
		conResult.setLocation(600, 15);
		frame.setLayout(null);
		frame.add(categoryChoice);
		frame.add(originalUnit);
		frame.add(oUnitText);
		frame.add(oUnitValue);
		
		frame.setSize(1000,800);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
		frame.setVisible(true);
		categoryChoice.setVisible(true);
	
		
		
	}
}
