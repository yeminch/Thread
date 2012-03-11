package Time;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Time extends Thread {
	private JFrame jf;
	private JLabel label;
	private JTextField jtf;
	private int day,i,j,k;

	public Time(int day,int i,int j,int k) {
		jf = new JFrame("倒计时");
		// jta=new JTextArea();
		label = new JLabel("倒计时:");
		jtf = new JTextField(16);
		jtf.setEditable(false);
		this.day=day;
		this.i=i;
		this.j=j;
		this.k=k;
		init();
		show();
		doit();

	}

	private void doit() {
		
		while(day>=0){
			while(i>=0){
				while(j>=0){
					while(k>=0){
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						jtf.setText(day+"天 "+i + "小时 " + j + "分 " + k + "秒");
						k--;						
						}
					if(k<0){
						k=59;
					}
					j--;
					}
				if(j<0){
					j=59;
				}
				i--;
			}
			day--;
			if(i<0){
				i=59;
			}
			
		}
		System.out.println("Time up!");

	}

	private void init() {
		jf.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 10));
		jf.add(label, BorderLayout.WEST);
		jf.add(jtf, BorderLayout.CENTER);

	}

	public void show() {
		jf.setVisible(true);
//		jf.pack();
		
		jf.setSize(300, 200);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Time(0,3,56,5);
	}
}
