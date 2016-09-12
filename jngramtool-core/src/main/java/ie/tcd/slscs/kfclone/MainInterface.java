package ie.tcd.slscs.kfclone;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.JButton;

public class MainInterface {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Font kfFont = new Font("Arial", Font.PLAIN, 11);

	private static Config initCfg() throws Exception {
		IniFile ini = new IniFile();
		ini.fromFile();
		return ini.getCfg();
	}
	private static String getEditorCommand() {
		String os = System.getProperty("os.name");
		if(os.startsWith("Windows")) {
			return "notepad.exe";
		} else if(os.toLowerCase().startsWith("mac os x")) {
			return "open /Application/TextEdit.app";
		} else {
			return System.getenv("EDITOR");
		}
	}
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
	public MainInterface() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws Exception {
		final Config cfg = initCfg();
		frame = new JFrame();
		frame.setBounds(100, 100, 690, 490);
		if(!cfg.isAdvanced()) {
			frame.setBounds(100, 100, 545, 490);
		}
		frame.setResizable(false);
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
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec(getEditorCommand() + " " + cfg.getConfigPath());
				} catch (Exception ex) {
					// Do nothing
				}
			}
		});
		mnOptions.add(mntmNewMenuItem_4);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Advanced");
		chckbxmntmNewCheckItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		final ActionListener l = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AbstractButton absbut = (AbstractButton) evt.getSource();
				boolean selected = absbut.getModel().isSelected();
				if (selected) {
					frame.setBounds(100, 100, 690, 490);
					cfg.setAdvanced(true);
				} else {
					frame.setBounds(100, 100, 545, 490);
					cfg.setAdvanced(false);
				}
			}
		};
		chckbxmntmNewCheckItem.addActionListener(l);
		chckbxmntmNewCheckItem.setSelected(cfg.isAdvanced());
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
		lblNewLabel.setFont(kfFont);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(2, 2, 120, 25);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(kfFont);
		textField.setBounds(130, 7, 110, 15);
		frame.getContentPane().add(textField);
		textField.setText(cfg.getNgramRange());
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfg.setNgramRange(textField.getText());
			}
		});
		textField.setColumns(10);
		
		JLabel lblFloor = new JLabel("Floor");
		lblFloor.setFont(kfFont);
		lblFloor.setBounds(245, 2, 46, 25);
		frame.getContentPane().add(lblFloor);
		
		textField_1 = new JTextField();
		textField_1.setFont(kfFont);
		textField_1.setBounds(275, 7, 30, 15);
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setText(cfg.getFloorString());
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cfg.setFloor(textField_1.getText());
			}
		});
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		Choice choice = new Choice();
		choice.setBounds(315, 3, 95, 20);
		choice.setFont(kfFont);
		choice.addItem("Don't show");
		choice.addItem("Show n-grams");
		frame.getContentPane().add(choice);
		
		JLabel lblNewLabel_1 = new JLabel("Chars to sort");
		lblNewLabel_1.setFont(kfFont);
		lblNewLabel_1.setBounds(415, 2, 65, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(485, 3, 50, 20);
		choice_1.setFont(kfFont);
		choice_1.addItem("128");
		choice_1.addItem("256");
		choice_1.addItem("512");
		choice_1.addItem("1024");
		choice_1.addItem("2048");
		frame.getContentPane().add(choice_1);

		JLabel lblAdvOpt = new JLabel("Advanced Options");
		lblAdvOpt.setFont(kfFont);
		lblAdvOpt.setBounds(540, 2, 95, 20);
		frame.getContentPane().add(lblAdvOpt);

		final Choice choice_2 = new Choice();
		choice_2.setBounds(5, 30, 115, 20);
		choice_2.setFont(kfFont);
		choice_2.addItem("not case-sensitive");
		choice_2.addItem("Case sensitive");
		choice_2.select(cfg.isCaseSensitive() ? 1 : 0);
		choice_2.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(choice_2.getSelectedIndex() == 1) {
					cfg.setCaseSensitive(true);
				} else {
					cfg.setCaseSensitive(false);
				}
			}
		});
		frame.getContentPane().add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(125, 30, 145, 20);
		choice_3.setFont(kfFont);
		choice_3.addItem("Observe TreatAsToken");
		choice_3.addItem("Punct. as in KeepChars");
		choice_3.addItem("Replace . , - ' with space");
		choice_3.addItem("Keep internal . , - '");
		choice_3.addItem("Delete internal - keep  . , '");
		frame.getContentPane().add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setFont(kfFont);
		choice_4.setBounds(275, 30, 115, 20);
		choice_4.addItem("Alphabetical Sort");
		choice_4.addItem("Frequency Sort");
		frame.getContentPane().add(choice_4);
		
		Choice choice_5 = new Choice();
		choice_5.setFont(kfFont);
		choice_5.setBounds(395, 30, 130, 20);
		choice_5.addItem("Retain numerals");
		choice_5.addItem("Change numerals to #");
		choice_5.addItem("Make all numbers #");
		choice_5.select(cfg.getReplaceNumbersIndex());
		frame.getContentPane().add(choice_5);
		
        JLabel lblNewLabel_2 = new JLabel("Source files");
        lblNewLabel_2.setFont(kfFont);
        lblNewLabel_2.setBounds(2, 70, 70, 20);
        frame.getContentPane().add(lblNewLabel_2);
        
		JButton btnNewButton = new JButton("<html><center>Add<br><u>S</u>ource&nbsp;files</center></html>");
		btnNewButton.setMargin(new Insets(0,0,0,0));
		btnNewButton.setFont(kfFont);
		btnNewButton.setBounds(2, 95, 75, 35);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<html><center><u>R</u>eplace<br>Source&nbsp;files</center></html>");
        btnNewButton_1.setMargin(new Insets(0,0,0,0));
		btnNewButton_1.setFont(kfFont);
		btnNewButton_1.setBounds(2, 135, 75, 35);
		frame.getContentPane().add(btnNewButton_1);
		
		Choice choice_6 = new Choice();
		choice_6.setBounds(0, 277, 28, 20);
		frame.getContentPane().add(choice_6);
	}
	
}
