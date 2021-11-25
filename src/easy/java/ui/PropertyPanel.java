package easy.java.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import easy.java.widget.WButton;
import easy.java.widget.WLabel;

/**
 * 属性框
 * 
 * @author karl
 *
 */

public class PropertyPanel extends JPanel implements DocumentListener {

	private static final long serialVersionUID = 1L;

	public PropertyPanel() {
		setLocation(1100, 10);
		setSize(400, 700);
		setLayout(null);
		setBackground(Color.lightGray);
		initUI();
	}

	private JLabel mLabelClass, mLabelName, mLabelMethod;
	private JLabel mLabelX, mLabelY, mLabelWidth, mLabelHeight;
	private JTextField mTextCLass, mTextName, mTextMethod;
	private JTextField mTextX, mTextY, mTextWidth, mTextHeight;
	private WButton mCurWButton;
	private WLabel mCurWLabel;

	private void initUI() {
		mLabelClass = new JLabel("类型:");
		mLabelClass.setLocation(10, 10);
		mLabelClass.setSize(70, 40);
		add(mLabelClass);
		mTextCLass = new JTextField();
		mTextCLass.setLocation(110, 10);
		mTextCLass.setSize(70, 30);
		mTextCLass.setEditable(false);
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
		mLabelX = new JLabel("坐标X:");
		mLabelX.setLocation(10, 190);
		mLabelX.setSize(70, 40);
		add(mLabelX);
		mTextX = new JTextField();
		mTextX.setLocation(110, 190);
		mTextX.setSize(70, 30);
		mTextX.getDocument().addDocumentListener(this);
		add(mTextX);
		mLabelY = new JLabel("坐标Y:");
		mLabelY.setLocation(220, 190);
		mLabelY.setSize(70, 40);
		add(mLabelY);
		mTextY = new JTextField();
		mTextY.setLocation(290, 190);
		mTextY.setSize(70, 30);
		mTextY.getDocument().addDocumentListener(this);
		add(mTextY);
		mLabelWidth = new JLabel("Width:");
		mLabelWidth.setLocation(10, 250);
		mLabelWidth.setSize(70, 40);
		add(mLabelWidth);
		mTextWidth = new JTextField();
		mTextWidth.setLocation(110, 250);
		mTextWidth.setSize(70, 30);
		mTextWidth.getDocument().addDocumentListener(this);
		add(mTextWidth);
		mLabelHeight = new JLabel("Height:");
		mLabelHeight.setLocation(220, 250);
		mLabelHeight.setSize(70, 40);
		add(mLabelHeight);
		mTextHeight = new JTextField();
		mTextHeight.setLocation(290, 250);
		mTextHeight.setSize(70, 30);
		mTextHeight.getDocument().addDocumentListener(this);
		add(mTextHeight);
	}

	public void updateInfo(JComponent btn) {
		mCurWLabel = null;
		mCurWButton= null;
		if (btn instanceof WButton) {
			System.out.println("======WButton");
			mCurWButton = (WButton) btn;
			mTextCLass.setText(btn.getClass().getSimpleName());
			mTextName.setText(mCurWButton.getText());
			mTextMethod.setText(mCurWButton.getClickMethod());
			Point location = btn.getLocation();
			mTextX.setText(location.x+"");
			mTextY.setText(location.y+"");
			Dimension size = btn.getSize();
			mTextWidth.setText(size.width+"");
			mTextHeight.setText(size.height+"");
			
		} else if (btn instanceof WLabel) {
			System.out.println("======WLabel");
			mCurWLabel = (WLabel) btn;
			mTextCLass.setText(btn.getClass().getSimpleName());
			mTextName.setText(mCurWLabel.getText());
			mTextMethod.setText("xxxxxxx");
			Point location = btn.getLocation();
			mTextX.setText(location.x+"");
			mTextY.setText(location.y+"");
			Dimension size = btn.getSize();
			mTextWidth.setText(size.width+"");
			mTextHeight.setText(size.height+"");
			
		}
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		System.out.println("======insertUpdate");
		if (mCurWButton != null) {
			mCurWButton.setText(mTextName.getText());
		}
		if (mCurWLabel != null) {
			mCurWLabel.setText(mTextName.getText());
		}
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		System.out.println("======removeUpdate");
		if (mCurWButton != null) {
			mCurWButton.setText(mTextName.getText());
		}
		if (mCurWLabel != null) {
			mCurWLabel.setText(mTextName.getText());
		}
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		System.out.println("======changedUpdate");
		if (mCurWButton != null) {
			mCurWButton.setText(mTextName.getText());
		}
	}
}
