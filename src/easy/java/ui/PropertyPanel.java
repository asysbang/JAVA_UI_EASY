package easy.java.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * 属性框
 * 
 * @author karl
 *
 */

public class PropertyPanel extends JPanel implements DocumentListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PropertyPanel() {
		setLocation(1100, 10);
		setSize(400, 700);
		setLayout(null);
//		addMouseMotionListener(this);
		setBackground(Color.lightGray);
		initUI();
	}

	private JLabel mLabelClass, mLabelName, mLabelMethod;
	private JTextField mTextCLass,mTextName,mTextMethod;
	
	private JButton mCurComponent;

	private void initUI() {
		mLabelClass = new JLabel("类型:");
		mLabelClass.setLocation(10, 10);
		mLabelClass.setSize(70, 40);
		add(mLabelClass);
		
		mTextCLass = new JTextField();
		mTextCLass.setLocation(110, 10);
		mTextCLass.setSize(70, 30);
		add(mTextCLass);

		mLabelName = new JLabel("名称:");
		mLabelName.setLocation(10, 70);
		mLabelName.setSize(70, 40);
		add(mLabelName);

		mTextName = new JTextField();
		mTextName.setLocation(110, 70);
		mTextName.setSize(70, 30);
		mTextName.getDocument().addDocumentListener(this);
		add(mTextName);

		mLabelMethod = new JLabel("点击事件:");
		mLabelMethod.setLocation(10, 130);
		mLabelMethod.setSize(70, 40);
		add(mLabelMethod);
		
		mTextMethod = new JTextField();
		mTextMethod.setLocation(110, 130);
		mTextMethod.setSize(270, 30);
		add(mTextMethod);
	}

	public void updateInfo(JButton btn) {
		mCurComponent = btn;
		mTextCLass.setText(btn.getClass().getSimpleName());
		mTextName.setText(btn.getText());
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("======insertUpdate");
		if (mCurComponent!=null) {
			mCurComponent.setText(mTextName.getText());
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("======removeUpdate");
		if (mCurComponent!=null) {
			mCurComponent.setText(mTextName.getText());
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("======changedUpdate");
		if (mCurComponent!=null) {
			mCurComponent.setText(mTextName.getText());
		}
		
	}
}
