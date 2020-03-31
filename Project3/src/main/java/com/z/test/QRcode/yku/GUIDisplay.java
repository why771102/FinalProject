package com.z.test.QRcode.yku;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
//import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.Dimension;

public class GUIDisplay extends JFrame {

	public static void main(String args[])
	{
		GUIDisplay d = new GUIDisplay();
		d.setVisible(true);
	}
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	
	private QrCodePaintPanel jPanel = null;
	private JTextArea jTextArea = null;
	private JButton jButton = null;
	/**
	 * This is the default constructor
	 */
	public GUIDisplay() {
		super();
		initialize();
		
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(443, 440);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanel(), null);
			jContentPane.add(getJTextArea(), null);
			jContentPane.add(getJButton(), null);
		}
		return jContentPane;
	}



	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private QrCodePaintPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new QrCodePaintPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.setBounds(new Rectangle(30, 183, 292, 215));
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextArea	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getJTextArea() {
		if (jTextArea == null) {
			jTextArea = new JTextArea();
			jTextArea.setBounds(new Rectangle(30, 3, 296, 177));
		}
		return jTextArea;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(329, 30, 66, 98));
			jButton.setText("����");
			jButton.addActionListener(new java.awt.event.ActionListener() {
	               
	            public void actionPerformed(java.awt.event.ActionEvent e)
	            {
	            	getJPanel().paintMakeQrcode(getJTextArea().getText().trim().length()==0?null:getJTextArea().getText());
	            }
	        }
			);
		}
		return jButton;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
