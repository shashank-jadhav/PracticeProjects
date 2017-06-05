package co.nworks.swing.ReplayApp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;

public class ReplayApplication1 {

	private JFrame frmReplaytool;
	private JTextField fromTime;
	private JTextField toTime;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReplayApplication1 window = new ReplayApplication1();
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
	public ReplayApplication1() {
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

		JButton Play = new JButton("Play");
		Play.setBounds(35, 129, 89, 23);
		frmReplaytool.getContentPane().add(Play);

		JButton Pause = new JButton("Pause");
		Pause.setBounds(158, 129, 89, 23);
		frmReplaytool.getContentPane().add(Pause);

		JButton Stop = new JButton("Stop");
		Stop.setBounds(292, 129, 89, 23);
		frmReplaytool.getContentPane().add(Stop);

		JDateChooser fromDate = new JDateChooser();
		fromDate.setBounds(35, 54, 91, 20);
		frmReplaytool.getContentPane().add(fromDate);

		JDateChooser toDate = new JDateChooser();
		toDate.setBounds(236, 54, 91, 20);
		frmReplaytool.getContentPane().add(toDate);

		JButton oneTimes = new JButton("1x");
		oneTimes.setBounds(51, 181, 45, 23);
		frmReplaytool.getContentPane().add(oneTimes);

		JButton twoTimes = new JButton("2x");
		twoTimes.setBounds(176, 181, 45, 23);
		frmReplaytool.getContentPane().add(twoTimes);

		JButton threeTimes = new JButton("5x");
		threeTimes.setBounds(292, 181, 45, 23);
		frmReplaytool.getContentPane().add(threeTimes);

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
}
