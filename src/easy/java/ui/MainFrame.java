package easy.java.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

import easy.java.widget.WButton;

public class MainFrame extends JFrame implements ActionListener, TargetPanelListener {

	private static final long serialVersionUID = 1L;
	
	JButton mBtnAddBtn,mBtnCode,mBtnAddLabel;
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
		mBtnAddBtn = new JButton("添加按钮");
		mBtnAddBtn.setLocation(1540, 300);
		mBtnAddBtn.setSize(100, 40);
		mBtnAddBtn.addActionListener(this);
		add(mBtnAddBtn);
		
		mBtnAddLabel = new JButton("添加标签");
		mBtnAddLabel.setLocation(1540, 230);
		mBtnAddLabel.setSize(100, 40);
		mBtnAddLabel.addActionListener(this);
//		mBtnAddLabel.setEnabled(false);
		add(mBtnAddLabel);
		
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
		if (source == mBtnAddBtn) {
			tPanel.addButton();
		} else if (source == mBtnCode) {
			tPanel.generateCode();
		} else if (source == mBtnAddLabel) {
			tPanel.addLabel();
		}
	}


	@Override
	public void onFocusComponentChanged(JComponent btn) {
		// TODO Auto-generated method stub
		pPanel.updateInfo(btn);
	}
}
