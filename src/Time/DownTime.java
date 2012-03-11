package Time;
import java.awt.FlowLayout;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DownTime extends Thread {
	private JFrame jframe;
	private JLabel jlabel;
	private JLabel jlabel1;
	private Date datetime;

	public DownTime(Date datetime) {
		this.datetime = datetime;
		jframe = new JFrame("倒计时");
		jlabel = new JLabel("2012世界末日倒计时 ：");
		jlabel1 = new JLabel("  天  时  分  秒");
		init();
		show();
	}

	private void init() {
		jframe.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 8));
		jframe.add(jlabel);
		jframe.add(jlabel1);
	}

	public void show() {
		jframe.setVisible(true);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(300, 200);
		this.start();
	}

	public void run() {
		while (true) {
			//得到当前时间
			Date nowtime = new Date();
			//得到时间差
			long timesForSeconds = (datetime.getTime() - nowtime.getTime()) / 1000;
		    if(timesForSeconds<=0){
		    	jlabel1.setText("末日来啦");
		    	break;
		    }
		    int day=(int)(timesForSeconds/(24*60*60));
		    int hour=(int)(timesForSeconds%(24*60*60)/(60*60));
		    int min=(int)(timesForSeconds%(3600)/60);
		    int second=(int)(timesForSeconds%60);
		    jlabel1.setText(day+"天"+hour+"时"+min+"分"+second+"秒");
		    try {
				this.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Date datetime = new Date(112, 12, 21, 0, 0, 0);
		new DownTime(datetime);
	}
}
