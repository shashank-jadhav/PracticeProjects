package co.nworks.swing.ReplayApp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import co.nworks.swing.ReplayApp.MessageProducer.Times;

public class ReplayApplication implements ActionListener {

	private JFrame frmReplaytool;
	private JTextField fromTime;
	private JTextField toTime;
	private JButton Play, Pause, Stop, oneTimes, twoTimes, fiveTimes;
	private JDateChooser fromDate, toDate;
	private MessageProducer mp = new MessageProducer();
	private Thread th = new Thread(mp);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReplayApplication window = new ReplayApplication();
					window.frmReplaytool.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReplayApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReplaytool = new JFrame();
		frmReplaytool.setTitle("ReplayTool");
		frmReplaytool.setBounds(100, 100, 450, 300);
		frmReplaytool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReplaytool.getContentPane().setLayout(null);

		Play = new JButton("Play");
		Play.setBounds(35, 129, 89, 23);
		frmReplaytool.getContentPane().add(Play);
		Play.addActionListener(this);

		Pause = new JButton("Pause");
		Pause.setBounds(158, 129, 89, 23);
		frmReplaytool.getContentPane().add(Pause);
		Pause.addActionListener(this);

		Stop = new JButton("Stop");
		Stop.setBounds(292, 129, 89, 23);
		frmReplaytool.getContentPane().add(Stop);
		Stop.addActionListener(this);

		fromDate = new JDateChooser();
		fromDate.setBounds(35, 54, 91, 20);
		frmReplaytool.getContentPane().add(fromDate);

		toDate = new JDateChooser();
		toDate.setBounds(236, 54, 91, 20);
		frmReplaytool.getContentPane().add(toDate);

		oneTimes = new JButton("1x");
		oneTimes.setBounds(51, 181, 45, 23);
		frmReplaytool.getContentPane().add(oneTimes);
		oneTimes.addActionListener(this);

		twoTimes = new JButton("2x");
		twoTimes.setBounds(176, 181, 45, 23);
		frmReplaytool.getContentPane().add(twoTimes);
		twoTimes.addActionListener(this);

		fiveTimes = new JButton("5x");
		fiveTimes.setBounds(292, 181, 45, 23);
		frmReplaytool.getContentPane().add(fiveTimes);
		fiveTimes.addActionListener(this);

		fromTime = new JTextField();
		fromTime.setBounds(38, 85, 86, 20);
		frmReplaytool.getContentPane().add(fromTime);
		fromTime.setColumns(10);

		toTime = new JTextField();
		toTime.setBounds(236, 85, 86, 20);
		frmReplaytool.getContentPane().add(toTime);
		toTime.setColumns(10);

		JLabel lblNewLabel = new JLabel("1X");
		lblNewLabel.setBounds(61, 215, 46, 14);
		frmReplaytool.getContentPane().add(lblNewLabel);

		JLabel lblx = new JLabel("2X");
		lblx.setBounds(186, 215, 46, 14);
		frmReplaytool.getContentPane().add(lblx);

		JLabel lblx_1 = new JLabel("5X");
		lblx_1.setBounds(302, 215, 46, 14);
		frmReplaytool.getContentPane().add(lblx_1);

	}

	public void actionPerformed(ActionEvent e) {

		JButton btn = (JButton) e.getSource();

		//Logic to play the file on click on play button
		if (btn == Play) {
			if (mp.isRunning() == false) {
				mp.resumeThread();
			} else if (mp.isRunning() == true)
				th.start();

		}

		//logic to pause the file on click on pause button
		if (btn == Pause) {

			try {
				mp.pauseThread();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}

		//logic to Stop the file on click on stop button
		if (btn == Stop) {
			try {
				// mp.terminate();
				th.join();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		//This will send the data one at time
		if (btn == oneTimes) {
			mp.setTime(Times.OneX);
		}

		//This will send data two at a time
		if (btn == twoTimes) {
			mp.setTime(Times.TwoX);
		}

		//This will send data five at a time
		if (btn == fiveTimes) {
			mp.setTime(Times.FiveX);
		}

	}
}
