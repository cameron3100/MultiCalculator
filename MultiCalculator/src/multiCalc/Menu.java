package multiCalc;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Menu {
	
	protected JFrame mainFrame;
	protected JFrame binaryFrame;
	
	protected Menu() {
		InitialiseUI();
	}

	private void InitialiseUI() {
		//Initialise mainFrame.
		mainFrame = new JFrame();
		mainFrame.setTitle("Menu");
		mainFrame.setBounds(50, 50, 400, 200);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		//Initialise display panel.
		JPanel pnlMain = new JPanel();
		pnlMain.setLayout(new BoxLayout(pnlMain, BoxLayout.Y_AXIS));
		pnlMain.setBorder(new EmptyBorder(15, 10, 10, 10));
		JLabel titleLbl = new JLabel("Please select a Calculator");
		titleLbl.setFont(new Font("Ariel", Font.PLAIN, 20));
		pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER));
		pnlMain.add(titleLbl);
		pnlMain.setBackground(Color.WHITE);
		
		//Initialise button dimensions.
		Dimension hexButtonsSize = new Dimension(164, 25);
		Dimension binButtonsSize = new Dimension(150, 25);
		
		//Initialise hexadecimal calc panel.
		JPanel pnlHex = new JPanel();
		pnlHex.setBounds(50, 50, 100, 100);
		JButton hexBtn = new JButton("Hexadecimal");
		hexBtn.setPreferredSize(hexButtonsSize);
		hexBtn.setMinimumSize(hexButtonsSize);
		hexBtn.setMaximumSize(hexButtonsSize);
		hexBtn.addActionListener(this::handleClickHex);
		pnlHex.add(hexBtn);
		pnlMain.add(pnlHex);
		
		//Initialise binary calc panel.
		JPanel pnlBin = new JPanel();
		JButton binBtn = new JButton("Binary");
		binBtn.setPreferredSize(binButtonsSize);
		binBtn.setMinimumSize(binButtonsSize);
		binBtn.setMaximumSize(binButtonsSize);
		binBtn.addActionListener(this::handleClickBin);
		pnlBin.add(binBtn);
		pnlMain.add(pnlBin);

		mainFrame.add(pnlMain);
	}
	
	private void handleClickBin(ActionEvent ae) {
		//Opens binary calc and closes menu.
		BinCalc binWindow = new BinCalc();
		binWindow.binaryFrame.setVisible(true);
		mainFrame.dispose();
	}
	
	private void handleClickHex(ActionEvent ae) {
		//Opens hex calc and closes menu.
		HexCalc hexWindow = new HexCalc();
		hexWindow.hexFrame.setVisible(true);
		mainFrame.dispose();
	}
}