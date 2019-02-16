package swingdemo;
import java.awt.Graphics;

import java.awt.Color;
import java.awt.Event;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;

public class swingdemo {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swingdemo window = new swingdemo();
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
	public swingdemo() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.PINK);
		frame.getContentPane().setLayout(null);
		String url = "download.jpg";
		ImageIcon icon = new ImageIcon(url);
		JLabel label = new JLabel(icon ,JLabel.CENTER);
		label.setBounds(149, 88, 254, 404);
		frame.getContentPane().add(label);
		
		label.setIcon(new ImageIcon("C:\\Users\\ayans\\OneDrive\\Desktop\\download.jpg"));
		label.enable();
		Event r ;
		
		int x=8,y=9;
		
	
		
		    
		JPanel panel = new JPanel();
		panel.setBounds(149, 88, 254, 404);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel();
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(477, 179, 146, 40);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(719, 174, 182, 51);
		frame.getContentPane().add(comboBox);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s;
				s = textField.getText();
				comboBox.addItem(s);
				
			}
		});
		btnAdd.setBounds(492, 256, 115, 29);
		frame.getContentPane().add(btnAdd);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST PAGE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_1.setBounds(546, 37, 300, 97);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(741, 434, 160, -114);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(751, 290, 150, 193);
		frame.getContentPane().add(panel_2);
		 
		frame.setBounds(100, 100, 1393, 730);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	

}

