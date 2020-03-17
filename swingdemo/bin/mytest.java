package swingdemo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



import javax.swing.JButton;

public class mytest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mytest window = new mytest();
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
	public mytest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	  void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 976, 589);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(411, 398, 115, 43);
		frame.getContentPane().add(btnNewButton);
		 
		 class Action implements ActionListener
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				JFrame frame2 = new JFrame("job done");
				 frame2.setVisible(true);
				 frame2.setSize(200,200);
				 
			 }
		 }
		 btnNewButton.addActionListener(new Action());
		
	}
	
}
