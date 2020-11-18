package multiCalc;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HexCalc{
	
	protected JFrame hexFrame;
	private JTextField hexInputA;
	private JTextField hexInputB;
	private JTextField hexOutput;
	
	protected HexCalc() {
		initialiseHexCalc();
	}
	
	private void initialiseHexCalc() {
		//Initialise hexFrame.
		hexFrame = new JFrame();
		hexFrame.setTitle("Hexadecimal Calculator");
		hexFrame.setBounds(50, 50, 400, 300);
		hexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		hexFrame.setResizable(false);
		hexFrame.setVisible(true);
		
		//Initialise display panel.
		JPanel pnlHex = new JPanel();
		pnlHex.setLayout(new BoxLayout(pnlHex, BoxLayout.Y_AXIS));
		pnlHex.setBorder(new EmptyBorder(20, 10, 10, 10));
		pnlHex.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Initialise JTextField "hexInputA".
		JPanel pnlInputA = new JPanel();
		pnlInputA.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblInputA = new JLabel("Input A: ");
		pnlInputA.add(lblInputA);
		hexInputA = new JTextField();
		hexInputA.setColumns(10);
		pnlInputA.add(hexInputA);
		pnlHex.add(pnlInputA);
		
		//Initialise JComboBox "hexSelection".
		JPanel pnlSelection = new JPanel();
		pnlHex.setLayout(new BoxLayout(pnlHex, BoxLayout.Y_AXIS));
		pnlSelection.setLayout(new FlowLayout(FlowLayout.CENTER));
		String[] addSubtract = {"+", "-"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox hexSelection = new JComboBox(addSubtract);
		pnlSelection.add(hexSelection);
		pnlHex.add(pnlSelection);
		
		//Initialise JTextField "hexInputB".
		JPanel pnlInputB = new JPanel();
		pnlInputB.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblInputB = new JLabel("Input B: ");
		pnlInputB.add(lblInputB);
		hexInputB = new JTextField();
		hexInputB.setColumns(10);
		pnlInputB.add(hexInputB);
		pnlHex.add(pnlInputB);
		
		//Initialise "btnHexEquals" and defines button dimensions.
		JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnHexEquals = new JButton("=");
		Dimension dimButtonsSize = new Dimension(59, 25);
		btnHexEquals.setPreferredSize(dimButtonsSize);
		btnHexEquals.setMinimumSize(dimButtonsSize);
		btnHexEquals.setMaximumSize(dimButtonsSize);
		pnlButton.add(btnHexEquals);
		pnlHex.add(pnlButton);
		
		//Initialise JTextField "hexOutput".
		JPanel pnlHexOutput = new JPanel();
		pnlHexOutput.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBinOutput = new JLabel("Output: ");
		pnlHexOutput.add(lblBinOutput);
		hexOutput = new JTextField();
		hexOutput.setColumns(10);
		hexOutput.setEditable(false);
		pnlHexOutput.add(hexOutput);
		pnlHex.add(pnlHexOutput);
		
		//Determine whether add or subtract is selected.
        btnHexEquals.addActionListener(e->{
        	int finalSelection = hexSelection.getSelectedIndex(); 
        	if(finalSelection==0) {
        		addHex();
        	} 
        	else {
        		subtractHex();
        	}
        });
		hexFrame.add(pnlHex);
	}
	
	private void addHex() {
		//Takes in 2 hex values from user and converts them to decimal then adds them then converts them back to hex.
		String hex1 = hexInputA.getText(), hex2 = hexInputB.getText();
		
		try {
		int decimal1 = Integer.parseInt(hex1, 16);
		int decimal2 = Integer.parseInt(hex2, 16);
		int decimalTotal = decimal1 + decimal2;
				
		String sum = Integer.toHexString(decimalTotal);
		hexOutput.setText(sum);
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(hexFrame, "Incorrect input, please try again!", "Incorrect input!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void subtractHex() {
		//Takes in 2 hex values from user and converts them to decimal then subtracts them then converts them back to hex.
		String hex1 = hexInputA.getText(), hex2 = hexInputB.getText();
		
		try {
		int decimal1 = Integer.parseInt(hex1, 16);
		int decimal2 = Integer.parseInt(hex2, 16);
		int decimalTotal = decimal1 - decimal2;
		
		String sum = Integer.toHexString(decimalTotal);
		hexOutput.setText(sum);
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(hexFrame, "Incorrect input, please try again!", "Incorrect input!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
