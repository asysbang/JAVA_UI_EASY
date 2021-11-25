import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class EasyUI extends JFrame implements ActionListener {
	public EasyUI() {
		setLocationByPlatform(true);
		setSize(1000, 700);
		setLayout(null);
		initUI();
		setVisible(true);
	}

	private JButton mBtn1;

	private void initUI() {
		mBtn1 = new JButton("Button1");
		mBtn1.setSize(90, 50);
		mBtn1.setLocation(237, 117);
		mBtn1.addActionListener(this);
		add(mBtn1);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == mBtn1) {
			onButton1Clicked();
		}
	}

	private void onButton1Clicked() {
		System.out.println("======onButton1Clicked");
	}

	public static void main(String[] args) {
		new EasyUI();
	}
}
