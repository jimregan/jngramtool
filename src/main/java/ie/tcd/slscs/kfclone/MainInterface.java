package ie.tcd.slscs.kfclone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Choice;
import javax.swing.JButton;

public class MainInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainInterface window = new MainInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 673, 485);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmViewNgramFile = new JMenuItem("View n-Gram File");
		mntmViewNgramFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mnFile.add(mntmViewNgramFile);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View Text File");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.ALT_MASK));
		mnFile.add(mntmNewMenuItem);
		
		mnFile.addSeparator();
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Exit");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnFile.add(mntmNewMenuItem_1);
		
		JMenu mnTools = new JMenu("Tools");
		mnTools.setMnemonic('T');
		menuBar.add(mnTools);
		
		JMenuItem mntmGetWordgrams = new JMenuItem("Get Wordgrams");
		mntmGetWordgrams.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		mnTools.add(mntmGetWordgrams);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Get Chargrams from Wordgram file");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnTools.add(mntmNewMenuItem_2);
		
		mnTools.addSeparator();
		
		JMenuItem mntmMergeTwoOr = new JMenuItem("Merge Two or More Alphabetically-Sorted Wordgram files");
		mntmMergeTwoOr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnTools.add(mntmMergeTwoOr);
		
		JMenuItem mntmConvertAlphabeticSort = new JMenuItem("Convert Alphabetic Sort to Frequency Sort");
		mntmConvertAlphabeticSort.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnTools.add(mntmConvertAlphabeticSort);
		
		mnTools.addSeparator();
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Get Phrase-Frames from Wordgram file");
		mntmNewMenuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnTools.add(mntmNewMenuItem_3);
		
		JMenuItem mntmBrowsePhraseframeFile = new JMenuItem("Browse Phrase-Frame file");
		mntmBrowsePhraseframeFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnTools.add(mntmBrowsePhraseframeFile);
		
		JMenuItem mntmCountTokensIn = new JMenuItem("Count Tokens in Source file");
		mntmCountTokensIn.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnTools.add(mntmCountTokensIn);
		
		mnTools.addSeparator();
		
		JMenuItem mntmConvertHtmlTo = new JMenuItem("Convert HTML to Text");
		mntmConvertHtmlTo.setEnabled(false);
		mnTools.add(mntmConvertHtmlTo);
		
		JMenuItem mntmConvertSgml = new JMenuItem("Convert SGML / XML to Text");
		mntmConvertSgml.setEnabled(false);
		mnTools.add(mntmConvertSgml);
		
		JMenu mnOptions = new JMenu("Options");
		mnOptions.setMnemonic('O');
		menuBar.add(mnOptions);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Edit Options");
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnOptions.add(mntmNewMenuItem_4);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Advanced");
		chckbxmntmNewCheckItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		mnOptions.add(chckbxmntmNewCheckItem);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('H');
		menuBar.add(mnHelp);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Help");
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnHelp.add(mntmNewMenuItem_5);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("nGrams (e.g. 1-3, 5, 10)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 128, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(129, 0, 120, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setBounds(259, 0, 46, 20);
		frame.getContentPane().add(lblFloor);
		
		textField_1 = new JTextField();
		textField_1.setBounds(290, 0, 46, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(342, 0, 82, 20);
		choice.addItem("Don't show");
		choice.addItem("Show n-grams");
		frame.getContentPane().add(choice);
		
		JLabel lblNewLabel_1 = new JLabel("Chars to sort");
		lblNewLabel_1.setBounds(424, 3, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(476, 0, 28, 20);
		choice_1.addItem("128");
		choice_1.addItem("256");
		choice_1.addItem("512");
		choice_1.addItem("1024");
		choice_1.addItem("2048");
		frame.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(0, 26, 119, 20);
		choice_2.addItem("not case-sensitive");
		choice_2.addItem("Case sensitive");
		frame.getContentPane().add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(125, 26, 124, 20);
		choice_3.addItem("Observe TreatAsToken");
		choice_3.addItem("Punct. as in KeepChars");
		choice_3.addItem("Replace . , - ' with space");
		choice_3.addItem("Keep internal . , - '");
		choice_3.addItem("Delete internal - keep  . , '");
		frame.getContentPane().add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(252, 26, 94, 20);
		choice_4.addItem("Alphabetical Sort");
		choice_4.addItem("Frequency Sort");
		frame.getContentPane().add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setBounds(424, 26, 80, 20);
		choice_5.addItem("Retain numerals");
		choice_5.addItem("Change numerals to #");
		choice_5.addItem("Make all numbers #");
		frame.getContentPane().add(choice_5);
		
		JButton btnNewButton = new JButton("Add Source Files");
		btnNewButton.setBounds(10, 94, 82, 75);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(0, 180, 82, 75);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Source files");
		lblNewLabel_2.setBounds(10, 69, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(0, 277, 28, 20);
		frame.getContentPane().add(choice_6);
	}
}