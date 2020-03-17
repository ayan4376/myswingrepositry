package swingdemo;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.mysql.cj.xdevapi.Statement;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class apptrack extends JFrame implements MouseListener,MouseMotionListener 
{
	int [] a = new int[200]; 
    int [] s = new int[200]; 
	JLabel lblNewLabel;
	PixelGrabber pg;
	ColorModel cm;
	Graphics2D gg;
	Image img;
	ImageIcon ii;
	 BufferedImage img1 = null;
	 int pixels[];
	 File f = null;
	 JPanel panel;
	 Container c;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					apptrack window = new apptrack();
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
	public apptrack() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("draw circle");
	
		frame.setSize(1920,1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ii=new ImageIcon("E:\\project_poli.png");
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
		
		
		lblNewLabel = new JLabel(ii,JLabel.CENTER);
		lblNewLabel.addMouseListener(this);
		lblNewLabel.addMouseMotionListener(this);
	
		
		
		
		
	
		
		panel = new JPanel();
			panel.setLayout(new FlowLayout());
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 1361, 687);
			frame.getContentPane().add(panel);
			
				panel.setVisible(true);
				panel.add(lblNewLabel);
	
		
		   String Url = "jdbc:mysql://localhost:3306/soo";
	        String user = "root";
	        String pass = "root";
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Trying to connect");
	            Connection connection = DriverManager.getConnection(Url,user,pass);
	            String SQL = "select x_axis,y_axis from segment2";
	            PreparedStatement stmt = connection.prepareStatement(SQL); 
	            ResultSet rs = stmt.executeQuery();
	            int i=0;
	            while(rs.next())
	            {
	              s[i++] = rs.getInt(1);
	              a[i++] = rs.getInt(2);
	             
	             
	            }
	           
	        }catch (Exception e) {
	        	System.out.println("Unable to make connection with DB");
	            e.printStackTrace();
	        }
	        
	}     
	        public void mouseClicked(MouseEvent me)
	        {
	        	
	        	 ColorModel cm=pg.getColorModel();
	     		gg=(Graphics2D)lblNewLabel.getGraphics();
	       	   
	             //Drawing Poligon
	             Polygon pp=new Polygon();
	            for(int i=0,j=0;i<a.length && j<s.length;i++,j++)
	             pp.addPoint(a[i],s[j]);
	             
	           
	            
	             gg.setColor(new Color(200,13,40) );
	             gg.fillPolygon(pp);
	             
	           

		      		
		      		
		      		
		      		
	        }
	        
	        public void mouseEntered(MouseEvent me)
	        {
	        	
	        }
	        public void mouseExited(MouseEvent me)
	        {
	         
	        }
	        	
	        public void mousePressed(MouseEvent me)
	        {
	        	 	
	        }
	        public void mouseReleased(MouseEvent me)
	        {
	        	   	
	        }
	        	
	        public void mouseMoved(MouseEvent me)
	        {
	        	
	        	 
		      	    
	      	    
	      	 

	        }
	        
      
	       
	        
        
	        public void mouseDragged(MouseEvent me)
	        {
	        }
}
