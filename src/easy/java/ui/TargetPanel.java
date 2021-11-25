package easy.java.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JComponent;
import javax.swing.JPanel;

import easy.java.encode.Encode;
import easy.java.widget.WButton;
import easy.java.widget.WLabel;

public class TargetPanel extends JPanel implements MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private TargetPanelListener mListener;

	public TargetPanel(TargetPanelListener listener) {
		setLocation(10, 10);
		setSize(1000, 700);
		setLayout(null);
		mListener = listener;
		setBackground(Color.gray);
	}

	public void setFocusComponent(JComponent btn) {
		if (mListener != null) {
			mListener.onFocusComponentChanged(btn);
		}
	}

	public void generateCode() {
		Component[] components = getComponents();
		try {
			File file = new File("EasyUI.java");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("import javax.swing.JFrame;\n");
			bw.write("import java.awt.event.ActionEvent;\n");
			bw.write("import java.awt.event.ActionListener;\n");
			if (components.length > 0) {
				bw.write("import javax.swing.JButton;\n");
				bw.write("import javax.swing.JLabel;\n");
			}
			bw.write("public class EasyUI extends JFrame implements ActionListener {\n");
			bw.write("public EasyUI() {\n");
			bw.write("setLocationByPlatform(true);\n");
			bw.write("setSize(1000, 700);\n");
			bw.write("setLayout(null);\n");
			bw.write("initUI();\n");
			bw.write("setVisible(true);\n");
			bw.write("}\n");
			Encode.encodeA(bw, components);
//			if (components.length > 0) {
//				bw.write("private JButton ");
//				for (int i = 0; i < components.length; i++) {
//					if (components[i] instanceof JButton) {
//						bw.write("mBtn" + i);
//						if (i == components.length - 1) {
//							bw.write(";\n");
//						} else {
//							bw.write(",");
//						}
//					}
//				}
//			}

			bw.write("private void initUI(){\n");
			Encode.encodeB(bw, components);
//			for (int i = 0; i < components.length; i++) {
//				if (components[i] instanceof JButton) {
//					JButton btn = (JButton) components[i];
//					bw.write("mBtn" + i + "= new JButton(\"" + btn.getText() + "\");\n");
//					Dimension size = btn.getSize();
//					bw.write("mBtn" + i + ".setSize(" + size.width + "," + size.height + ");\n");
//					Point location = btn.getLocation();
//					bw.write("mBtn" + i + ".setLocation(" + location.x + "," + location.y + ");\n");
//					bw.write("mBtn" + i + ".addActionListener(this);\n");
//					bw.write("add(mBtn" + i + ");\n");
//					bw.write("\n");
//				}
//			}
			bw.write("}\n");
			bw.write("@Override\n");
			bw.write("public void actionPerformed(ActionEvent e) {\n");
			bw.write("Object source = e.getSource();\n");
			int btnCount = 0;
			if (components.length > 0) {
				for (int i = 0; i < components.length; i++) {
					if (components[i] instanceof WButton) {
						WButton btn = (WButton) components[i];
						if (btnCount > 0) {
							bw.write("else ");
						}
						bw.write("if(source == mBtn" + btnCount + "){\n");
						bw.write(btn.getClickMethod() + "();\n");
						bw.write("}");
						btnCount++;
					}
				}
			}
			bw.write("}\n");
			if (components.length > 0) {
				for (int i = 0; i < components.length; i++) {
					if (components[i] instanceof WButton) {
						WButton btn = (WButton) components[i];
						bw.write("private void " + btn.getClickMethod() + "(){\n");
						bw.write("System.out.println(\"======" + btn.getClickMethod() + "\");\n");
						bw.write("}\n");
					}

				}
			}
			bw.write("public static void main(String[] args) {\n");
			bw.write("new EasyUI();\n");
			bw.write("}\n");
			bw.write("}\n");
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int getBtnCount() {
		int count = 0;
		for (Component c : getComponents()) {
			if (c instanceof WButton) {
				count++;
			}
		}
		return count;
	}

	private int getLabelCount() {
		int count = 0;
		for (Component c : getComponents()) {
			if (c instanceof WLabel) {
				count++;
			}
		}
		return count;
	}

	public void addLabel() {
		int count = getLabelCount();
		WLabel wl = new WLabel("Label" + count, this);
		add(wl);
		this.updateUI();
	}

	public void addButton() {
		int count = getBtnCount();
		WButton wb = new WButton("Button" + count, this);
		add(wb);
		this.updateUI();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// System.out.println("========mouseDragged=" + e.getX());
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
