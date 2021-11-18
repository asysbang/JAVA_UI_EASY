package easy.java.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame implements ActionListener, TargetPanelListener {

	private static final long serialVersionUID = 1L;
	
	JButton mBtnAdd,mBtnCode;
	TargetPanel tPanel;
	
	PropertyPanel pPanel;
	public MainFrame() {
		setLocationByPlatform(true);
		setSize(1700, 900);
		setLayout(null);
		tPanel = new TargetPanel(this);
		add(tPanel);
		
		pPanel = new PropertyPanel();
		add(pPanel);
		mBtnAdd = new JButton("添加按钮");
		mBtnAdd.setLocation(1540, 300);
		mBtnAdd.setSize(100, 40);
		mBtnAdd.addActionListener(this);
		add(mBtnAdd);
		
		mBtnCode = new JButton("生成代码");
		mBtnCode.setLocation(1540, 370);
		mBtnCode.setSize(100, 40);
		mBtnCode.addActionListener(this);
		add(mBtnCode);
	
		setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == mBtnAdd) {
			tPanel.addButton();
		} else if (source == mBtnCode) {
			tPanel.generateCode();
		}
	}


	@Override
	public void onFocusComponentChanged(JButton btn) {
		// TODO Auto-generated method stub
		pPanel.updateInfo(btn);
	}
}
