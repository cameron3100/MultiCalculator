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

public class BinCalc{
	
	protected JFrame binaryFrame;
	private JTextField binInputA;
	private JTextField binInputB;
	private JTextField binOutput;
	
	protected BinCalc() {
		initialiseBinCalc();
	}
	
	private void initialiseBinCalc() {
		//Initialise binaryFrame.
		binaryFrame = new JFrame();
		binaryFrame.setTitle("Binary Calculator");
		binaryFrame.setBounds(50, 50, 400, 300);
		binaryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		binaryFrame.setResizable(false);
		binaryFrame.setVisible(true);
		
		//Initialise display panel.
		JPanel pnlBin = new JPanel();
		pnlBin.setLayout(new BoxLayout(pnlBin, BoxLayout.Y_AXIS));
		pnlBin.setBorder(new EmptyBorder(20, 10, 10, 10));
		pnlBin.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//Initialise JTextField "binInputA".
		JPanel pnlInputA = new JPanel();
		pnlInputA.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblInputA = new JLabel("Input A: ");
		pnlInputA.add(lblInputA);
		binInputA = new JTextField();
		binInputA.setColumns(10);
		pnlInputA.add(binInputA);
		pnlBin.add(pnlInputA);
		
		//Initialise JComboBox "binSelection".
		JPanel pnlSelection = new JPanel();
		pnlBin.setLayout(new BoxLayout(pnlBin, BoxLayout.Y_AXIS));
		pnlSelection.setLayout(new FlowLayout(FlowLayout.CENTER));
		String[] addSubtract = {"+", "-"};
		@SuppressWarnings({ "rawtypes", "unchecked" })
		JComboBox binSelection = new JComboBox(addSubtract);
		pnlSelection.add(binSelection);
		pnlBin.add(pnlSelection);
		
		//Initialise JTextField "binInputA".
		JPanel pnlInputB = new JPanel();
		pnlInputB.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblInputB = new JLabel("Input B: ");
		pnlInputB.add(lblInputB);
		binInputB = new JTextField();
		binInputB.setColumns(10);
		pnlInputB.add(binInputB);
		pnlBin.add(pnlInputB);
		
		//Initialise "btnBinEquals" and defines button dimensions.
		JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton btnBinEquals = new JButton("=");
		Dimension dimButtonsSize = new Dimension(59, 25);
		btnBinEquals.setPreferredSize(dimButtonsSize);
		btnBinEquals.setMinimumSize(dimButtonsSize);
		btnBinEquals.setMaximumSize(dimButtonsSize);
		pnlButton.add(btnBinEquals);
		pnlBin.add(pnlButton);
		
		//Initialise JTextField "binOutput".
		JPanel pnlBinOutput = new JPanel();
		pnlBinOutput.setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel lblBinOutput = new JLabel("Output: ");
		pnlBinOutput.add(lblBinOutput);
		binOutput = new JTextField();
		binOutput.setColumns(10);
		binOutput.setEditable(false);
		pnlBinOutput.add(binOutput);
		pnlBin.add(pnlBinOutput);
		
		//Determine whether add or subtract is selected.
        btnBinEquals.addActionListener(e->{
        	int finalSelection = binSelection.getSelectedIndex(); 
        	if(finalSelection==0) {
        		addBinary();
        	} 
        	else {
        		subtractBinary();
        	}
        });
		binaryFrame.add(pnlBin);
	}
	
	public void addBinary(){
		//Takes input from binary JTextFields and add them together then outputs result.
		String convert1 = binInputA.getText(), convert2 = binInputB.getText();
		
		try {
			long binary1 = Long.parseLong(convert1, 2), binary2 = Long.parseLong(convert2, 2);
			Long sum =(long) binary1 + binary2;
			
			binOutput.setText(String.valueOf(Long.toBinaryString(sum)));
			}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(binaryFrame, "Incorrect input, please try again!", "Incorrect input!", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void subtractBinary() {
		//Takes input from binary JTextFields and subtracts them then outputs result.
		String convert1 = binInputA.getText(), convert2 = binInputB.getText();
		
		try {
			long binary1 = Long.parseLong(convert1, 2), binary2 = Long.parseLong(convert2, 2);
			Long sum =(long) binary1+(~binary2 + 1);

			binOutput.setText(String.valueOf(Long.toBinaryString(sum)));
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(binaryFrame, "Incorrect input, please try again!", "Incorrect input!", JOptionPane.ERROR_MESSAGE);
		}
	}
}
