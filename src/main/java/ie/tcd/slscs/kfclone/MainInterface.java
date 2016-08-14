package ie.tcd.slscs.kfclone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class MainInterface {

	private JFrame frame;

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
		frame.setBounds(100, 100, 450, 300);
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
	}

}
