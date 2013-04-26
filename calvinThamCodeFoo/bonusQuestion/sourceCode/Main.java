//Calvin Tham CODEFOO
//April 25 2013
import java.awt.Dimension;

import javax.swing.*;

public class Main extends JFrame {
	
	static Main defendsGame;
	static GamePanel panel;
	
	public Main(){
		setSize(1000,822);//includes borders (+18, +38)
		panel = new GamePanel();
		setContentPane(panel);
		//setPreferredSize(new Dimension(800,800));
		//setUndecorated(true);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Greg Miller Does Not Want a New Nose!");
	}
	
	public static void main(String[]args){
		defendsGame = new Main();
	}
}