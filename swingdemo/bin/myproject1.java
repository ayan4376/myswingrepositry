package swingdemo;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class myproject1 extends JFrame implements MouseListener,MouseMotionListener, ActionListener
{
	PixelGrabber pg,pg1;
	Graphics2D gg,gg1;
	JLabel l,k;
	public JLabel l_1;
    JFrame frame,frame2;
    ImageIcon ii,ii1;
    Image img;
    BufferedImage img1 = null;
    int [] a = new int[200]; 
    int [] s = new int[200]; 
    JPanel panel,panel1;
    int pixels[],pixels1[];
    JLabel lblNewLabel;
    Polygon pp;
	int b;
	int c;
	int d;
     int e,p=0;
	int i=0;
	 File f = null;
	 magnify m;
	private JLabel label,label_1;
	private JTextField textField;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					myproject1 window = new myproject1();
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
	 myproject1() {
		
		frame=new JFrame("project work");
		frame.setSize(1920,1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ii=new ImageIcon("E:\\image of india.jpg");
		try{
		      f = new File("E:\\image of india.jpg");
		      img1 = ImageIO.read(f);
		    }catch(IOException e){
		      
		    }
		
		
		
		img=ii.getImage();
		pixels=new int[ii.getIconWidth()*ii.getIconHeight()];
		pg=new PixelGrabber(img,0,0,ii.getIconWidth(),ii.getIconHeight(),pixels,0,ii.getIconWidth());
		try
		{
			pg.grabPixels();
		}
		catch(InterruptedException k)
		{
		}
		l=new JLabel(ii,JLabel.CENTER);
		l.addMouseListener(this);
		l.addMouseMotionListener(this);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1361, 687);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("x cordinate");
		lblNewLabel_1.setBounds(951, 188, 89, 50);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		panel.add(lblNewLabel_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(1144, 173, 4, 22);
		panel.add(textArea_1);
		
		label = new JLabel("");
		label.setBounds(1078, 188, 181, 50);
		label.setFont(new Font("Tahoma", Font.PLAIN, 33));
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		lblNewLabel_2.setBounds(1124, 173, 115, 41);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("y cordinate");
		lblNewLabel_3.setBounds(951, 297, 89, 50);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 33));
		panel.add(lblNewLabel_3);
		
		 label_1 = new JLabel("");
		 label_1.setBounds(1078, 297, 181, 50);
		 label_1.setFont(new Font("Tahoma", Font.PLAIN, 33));
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 0, 625, 671);
		panel.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane.setViewportView(scrollPane_1);
		l_1=new JLabel(ii,JLabel.CENTER);
		scrollPane_1.setViewportView(l_1);
		
		JLabel lblNewLabel_4 = new JLabel("state");
		lblNewLabel_4.setBounds(951, 406, 69, 38);
		panel.add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(1078, 403, 146, 41);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("segment");
		label_2.setBounds(951, 491, 69, 38);
		panel.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1078, 497, 146, 41);
		panel.add(textField_1);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(1034, 584, 115, 29);
		panel.add(btnNewButton);
		l_1.setVisible(true);
		
		
		
		l_1.addMouseListener(this);
		l_1.addMouseMotionListener(this);
		btnNewButton.addActionListener(this);
		
		

	
	 }
	 public void actionPerformed(ActionEvent e) { 
		 
		   String g = textField.getText();
		   String f = textField_1.getText(); 

	        String Url = "jdbc:mysql://localhost:3306/soo";
	        String user = "root";
	        String pass = "root";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Trying to connect");
	            Connection connection = DriverManager.getConnection(Url,user,pass);
	           
	            
	            String SQL = "INSERT INTO `state_segment`\r\n" + 
	            		"        (state,segment) VALUE \r\n" + 
	            		"        (?,?)";
	        		
	            
	             PreparedStatement preparedStmt = connection.prepareStatement(SQL);
	             preparedStmt.setString(1, g);
	             preparedStmt.setString(2, f);
	             preparedStmt.execute();
	                     
	            System.out.println("Connection Established Successfull and the DATABASE NAME IS:"
	                    + connection.getMetaData().getDatabaseProductName());
	        } catch (Exception P) {
	System.out.println("Unable to make connection with DB");
	            P.printStackTrace();
	        }
	    
		   draw d = new draw(f);
		   data_insert insert = new data_insert(a,s,f,i);
		    
		   for(int i=0,j=0;i<a.length && j<s.length;i++,j++)
		   {
			   a[i]=0;
			   s[j]=0;
		   }
		        
		    
		}
	 

	/**
	 * Initialize the contents of the frame.
	 */
	 int r=0;
	public void mouseClicked(MouseEvent me)
	{
	  
		
		c = me.getX();
		b = me.getY();
		 
	    a[i]=c;
	    s[i]=b;
	   
	    i=i+1;
	  
	   
		String str1 = Integer.toString(c);
		String str2 = Integer.toString(b);
		label.setText( str1);
		label_1.setText(str2);
		
		ColorModel cm=pg.getColorModel();
  		gg=(Graphics2D)l_1.getGraphics();
   	   
  
         pp=new Polygon();
       for(int i=0,j=0;i<a.length && j<s.length;i++,j++)
        pp.addPoint(a[i],s[j]);
          
      
       
        gg.setColor(new Color(200,13,40) );
        gg.fillPolygon(pp);
         
		  
		
	}
	 

	
	public void mouseMoved(MouseEvent me)
	{ 
	
	}
	public void mouseEntered(MouseEvent me)
	{
			
	}
	public void mouseExited(MouseEvent me)
	{
	 
	}
		
	public void mousePressed(MouseEvent me)
	{
		 m = new magnify(this);	
	}
	public void mouseReleased(MouseEvent me)
	{
		   	
	}
		
	
	public void mouseDragged(MouseEvent me)
	{
	}
	
	
	public void addChangeListener()
	{
	}
}

