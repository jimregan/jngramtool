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
	}
}
