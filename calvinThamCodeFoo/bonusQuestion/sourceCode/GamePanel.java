//Calvin Tham
//IGN CODE FOO April 25 2013
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;


public class GamePanel extends JPanel implements  FocusListener, MouseListener, MouseMotionListener
{	
	
	//screen width and height
	static int width = 1000; //800
	static int height = 800; //600SIZE
	
	static boolean mousePress = false;
	static Rectangle greg = new Rectangle(400,600,100,125);
	static Rectangle gregHand = new Rectangle(0,0,50,100);
	boolean handFired = false;
	double handVelocity = -2;
	
	Image gregImage;
	Image gregHandImage;
	
	//Rectangle nose = new Rectangle(0, 0, 80, 100);

	ArrayList<Rectangle> noses = new ArrayList<Rectangle>();
	Image noseImage;
	
	int level = 1;
	int noseSpeed = 1;
	
	
	
	public GamePanel(){
		addMouseListener(this);
		addMouseMotionListener(this);
		addFocusListener(this);
		
		initialize();
	}
	
	public void levelPrep()
	{
		if(level == 1)
		{
			noseSpeed = 3;
			//INITIALIZE NOSES!
			for(int c = 0; c < 50; c++)
			{
				int r = 0;
				if(c < 5)
					r = -200;
				else if( c <10)
					r = -240;
				else if( c <15)
					r = -280;
				else
					r= -c*10;
				
				int x = (int)(Math.random()*width);
				int scale = (int)(1.6*Math.random()+1);
				int widthNose = 80*scale;
				if(x < 0)
					x = 0;
				if(x+widthNose > width - 140)
					x = (int)(width - widthNose-140*Math.random());
				noses.add(new Rectangle(x,r- (int)(30*Math.random()),widthNose,100*scale));
			}
		}
		
		if(level == 2)
		{
			noseSpeed = 10;
			//INITIALIZE NOSES!
			for(int c = 0; c < 150; c++)
			{
				int r = 0;
				if(c < 5)
					r = -100;
				else if( c <10)
					r = -140;
				else if( c <15)
					r = -180;
				else
					r= -c*10;
				int x = (int)(Math.random()*width);
				int scale = (int)(1.8*Math.random()+1);
				int widthNose = 130*scale;
				if(x < 0)
					x = 0;
				if(x+widthNose > width - 50)
					x = (int)(width - widthNose-30*Math.random());
				noses.add(new Rectangle(x,r- (int)(30*Math.random()),widthNose,160*scale));
			}
		}
		if(level == 3)
		{
			noseSpeed = 12;
			noseNearSpeed = 1;
			//INITIALIZE NOSES!
			for(int c = 0; c < 260; c++)
			{
				int r = 0;
				if(c < 5)
					r = -100;
				else if( c <10)
					r = -140;
				else if( c <15)
					r = -180;
				else
					r= -c*10;
				int x = (int)(Math.random()*width);
				double scale = (int)(0.1*Math.random()+1);
				int widthNose = (int)(80*scale);
				if(x < 0)
					x = 0;
				if(x+widthNose > width - 150)
					x = (int)(width - widthNose-150*Math.random());
				
				int finalWidth = (int)((widthNose*0.3)*Math.random()*2);
				int finalHeight = (int)((100*scale*0.4)*Math.random()*2);
				
				if(finalWidth < 10)
				{
					finalWidth = 7;

					finalHeight = 14;
				}
				if(finalHeight < 10)
				{
					finalHeight = 7;

					finalHeight = 14;
				}
				
				noses.add( new Rectangle(x,r- (int)(30*Math.random()),finalWidth, finalHeight));
			}
		}
		
		if(level == 4)
		{
			noseSpeed = 50;
			noseNearSpeed = 3;
			//INITIALIZE NOSES!
			for(int c = 0; c < 100; c++)
			{
				int r = 0;
				if(c < 5)
					r = -100;
				else if( c <10)
					r = -140;
				else if( c <15)
					r = -180;
				else
					r= -c*10;
				int x = (int)(Math.random()*width);
				int scale = (int)(1.6*Math.random()+1);
				int widthNose = 80*scale;
				if(x < 0)
					x = 0;
				if(x+widthNose > width - 50)
					x = (int)(width - widthNose-30*Math.random());
				noses.add(new Rectangle(x,r- (int)(30*Math.random()),widthNose,100*scale));
			}
		}
	}
	public void initialize() //initialize or return to default variables

	{
		//basic variables
		
		//INITIALIZE NOSES!

		if(level == 1)
		{
			noseSpeed = 3;
			//INITIALIZE NOSES!
			for(int c = 0; c < 50; c++)
			{
				int r = 0;
				if(c < 5)
					r = -200;
				else if( c <10)
					r = -240;
				else if( c <15)
					r = -280;
				else
					r= -c*10;
				
				int x = (int)(Math.random()*width);
				int scale = (int)(1.6*Math.random()+1);
				int widthNose = 80*scale;
				if(x < 0)
					x = 0;
				if(x+widthNose > width - 140)
					x = (int)(width - widthNose-140*Math.random());
				noses.add(new Rectangle(x,r- (int)(30*Math.random()),widthNose,100*scale));
			}
		}
		
		
		//greg stuff
		gregHand.x = greg.x-60-(int)(Math.random()*10);
		gregHand.y = greg.y;
		
		//temporary method

		gregImage = Toolkit.getDefaultToolkit().getImage("images/gregHead.png");
		gregHandImage = Toolkit.getDefaultToolkit().getImage("images/Hand.png");
		
		noseImage = Toolkit.getDefaultToolkit().getImage("images/nose.png");
		
	}
	
	int timeNosed = 0;
	int noseNearSpeed = 1;
	public void paintComponent(Graphics g2){
		Graphics2D g = (Graphics2D)g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON); //ANTI ALIAS
		
		//super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		requestFocus();
		
		//levels
		
		
		//nose enemy
		g.setColor(Color.ORANGE);
		//g.fill(nose.nose);
		//g.drawImage(noseImage, nose.x, nose.y, nose.width, nose.height, null);
		
		//nose movement
		//if(Math.random()>0.2)
		//	nose.y+= noseSpeed;
		
		///if(nose.intersects(gregHand))
		//{
			
		//	nose.y-=20;
		//}
		//
		//noses collision and movemebt
		boolean intersectedOne = false;//for music purposes
		for(int c = 0; c < noses.size(); c++)
		{
			
			//nose movement
			if(noses.get(c).y < 270)
			{
				if(Math.random()>0.2)
					noses.get(c).y+=noseSpeed;
			}
			else
				if(Math.random()>0.2)
				{
					if(noses.get(c).y < greg.y+100*Math.random())
						noses.get(c).y+=noseNearSpeed;
					else
						noses.get(c).y--;
					
					if(noses.get(c).x < greg.x && noses.get(c).x < (width-noses.get(c).width))
					{
						if(level != 3 || (level == 3 || level == 1) && (noses.get(c).x < width - 150))
							noses.get(c).x+=2;
					}
					else
						noses.get(c).x-=2;
				}
					
			
			if(noses.get(c).intersects(gregHand))
			{
				if(Math.random()>0.982)
				{
					//soundHandler.playTouchSound();
				}
				noses.get(c).y+=handVelocity;
				
				//REMOVING NOSES IF HIT ALL THE WAY
				if(noses.get(c).y < -30)
				{
					noses.remove(c);
					if(c!=0)
						c--;
					
					//NEW LEVEL IF ALL GONE
					if(noses.size() == 0)
					{
						level++;
						if(level == 4)
							level = 1;
						timeNosed = 0;
						levelPrep();
					}
				}
			}
			
			if(noses.get(c).intersects(greg))
			{
				intersectedOne = true;
				
				if(level !=5)
				{
					timeNosed++;
					
					if(timeNosed > 700)
					{

						g.drawImage(gregImage, 100, 100, greg.width*3, greg.height*3, null);
						g.drawImage(gregHandImage, 20-(int)(Math.random()*10), 130, gregHand.width*3, gregHand.height*3, null);
						
						if(level == 1)
							g.drawImage(noseImage,  greg.width*3/2, greg.height*3/4, noses.get(c).width, noses.get(c).height, null);
						else if(level == 3)
							g.drawImage(noseImage, 50+ greg.width*3/2, greg.height*3/2, noses.get(c).width, noses.get(c).height, null);
						else if(level == 4)
							g.drawImage(noseImage,  greg.width*3/2, greg.height*3/3, noses.get(c).width, noses.get(c).height, null);
						else
								g.drawImage(noseImage,  greg.width*3/2, greg.height*3/4, noses.get(c).width, noses.get(c).height, null);
						
						
					}
				}
			}
			
			
			
			
		}

		//hand fired stuff
		if(handFired)
		{
			handFired = true;
			
			
			if(gregHand.y > -50)
			{
				handVelocity-=2;
				gregHand.y+=handVelocity;
			}
			else
			{
				handVelocity = -2;
				handFired = false;
			}
		}
		else
		{
			gregHand.x = greg.x-60-(int)(Math.random()*10);
			gregHand.y = greg.y;
		}
		//draw
		g.setColor(Color.BLACK);
		//g.fill(greg);
		g.drawImage(gregImage, greg.x, greg.y, greg.width, greg.height, null);
		
		//draw noses
		for(int c = 0; c < noses.size(); c++)
		{
			//System.out.println("drawing");
		//nose enemy
		g.setColor(Color.ORANGE);
		//g.fill(noses.get(c));
		g.drawImage(noseImage, noses.get(c).x, noses.get(c).y, noses.get(c).width, noses.get(c).height, null);
		}
		
		g.setColor(Color.RED);
		//g.fill(gregHand);
		g.drawImage(gregHandImage, gregHand.x, gregHand.y, gregHand.width, gregHand.height, null);
		
		sleep();
		repaint();
		}
		//takes the file and does stuff

	public void sleep(){
		try{
			
			Thread.sleep(21);//about 60 fps
			
		}catch(Exception e){}
	}
	public void focusGained(FocusEvent e){}
	public void focusLost(FocusEvent e){}
	public void mousePressed(MouseEvent e){
		mousePress = true;
		
		if(handFired == false)
		{
			handFired = true;
			if(Math.random()>0.96)
			{
				//soundHandler.playZoomSound();
			}
		}
	}
	public void mouseClicked(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e){
		mousePress = false;
	}
	public void mouseMoved(MouseEvent e)
	{

		greg.x = e.getX();
			
		if(e.getY() > 600)
		{	
			greg.y = e.getY()-50;
		}
		
	}
	public void mouseDragged(MouseEvent e)
	{
		greg.x = e.getX();
		
		if(e.getY() > 600)
		{	
			greg.y = e.getY()-50;
		}
	}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
}