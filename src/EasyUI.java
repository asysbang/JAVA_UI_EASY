import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class EasyUI extends JFrame implements ActionListener {
	public EasyUI() {
		setLocationByPlatform(true);
		setSize(1000, 700);
		setLayout(null);
		initUI();
		setVisible(true);
	}

	private JLabel mLabel0, mLabel1;
	private JButton mBtn0, mBtn1;

	private void initUI() {
		mLabel0 = new JLabel("Label0");
		mLabel0.setSize(90, 50);
		mLabel0.setLocation(64, 292);
		add(mLabel0);

		mLabel1 = new JLabel("Label1");
		mLabel1.setSize(90, 50);
		mLabel1.setLocation(60, 399);
		add(mLabel1);

		mBtn0 = new JButton("Button0");
		mBtn0.setSize(129, 50);
		mBtn0.setLocation(200, 293);
		mBtn0.addActionListener(this);
		add(mBtn0);

		mBtn1 = new JButton("Button1");
		mBtn1.setSize(90, 50);
		mBtn1.setLocation(199, 393);
		mBtn1.addActionListener(this);
		add(mBtn1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == mBtn0) {
			onButton0Clicked();
		} else if (source == mBtn1) {
			onButton1Clicked();
		}
	}

	private void onButton0Clicked() {
		System.out.println("======onButton0Clicked");
	}

	private void onButton1Clicked() {
		System.out.println("======onButton1Clicked");
	}

	public static void main(String[] args) {
		new EasyUI();
	}
}
