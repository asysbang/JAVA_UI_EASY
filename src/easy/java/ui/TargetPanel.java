package easy.java.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JPanel;

import easy.java.widget.WButton;

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

	public void setFocusComponent(JButton btn) {
		if (mListener != null) {
			mListener.onFocusComponentChanged(btn);
		}
	}

	public void generateCode() {
		Component[] components = getComponents();
		System.out.println("====components:" + components.length);
		for (Component com : components) {
			System.out.println("=====" + com);
		}
		try {
			File file = new File("EasyUI.java");
			FileOutputStream fos = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			bw.write("import javax.swing.JFrame;\n");
			bw.write("import java.awt.event.ActionEvent;\n");
			bw.write("import java.awt.event.ActionListener;\n");
			if (components.length > 0) {
				bw.write("import javax.swing.JButton;\n");
			}
			bw.write("public class EasyUI extends JFrame implements ActionListener {\n");
			bw.write("public EasyUI() {\n");
			bw.write("setLocationByPlatform(true);\n");
			bw.write("setSize(1000, 700);\n");
			bw.write("setLayout(null);\n");
			bw.write("initUI();\n");
			bw.write("setVisible(true);\n");
			bw.write("}\n");
			if (components.length > 0) {
				bw.write("private JButton ");
				for (int i = 0; i < components.length; i++) {
					bw.write("mBtn" + i);
					if (i == components.length - 1) {
						bw.write(";\n");
					} else {
						bw.write(",");
					}
				}
			}

			bw.write("private void initUI(){\n");
			for (int i = 0; i < components.length; i++) {
				JButton btn = (JButton) components[i];
				bw.write("mBtn" + i + "= new JButton(\"" + btn.getText() + "\");\n");
				Dimension size = btn.getSize();
				bw.write("mBtn" + i + ".setSize(" + size.width + "," + size.height + ");\n");
				Point location = btn.getLocation();
				bw.write("mBtn" + i + ".setLocation(" + location.x + "," + location.y + ");\n");
				bw.write("mBtn" + i + ".addActionListener(this);\n");
				bw.write("add(mBtn" + i + ");\n");
				bw.write("\n");
			}
			bw.write("}\n");
			bw.write("@Override\n");
			bw.write("public void actionPerformed(ActionEvent e) {\n");
			bw.write("Object source = e.getSource();\n");
			if (components.length > 0) {
				for (int i = 0; i < components.length; i++) {
					if (i > 0) {
						bw.write("else ");
					}
					bw.write("if(source == mBtn" + i + "){");
					bw.write("\n");
					bw.write("}");
				}
			}

			bw.write("}\n");
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

	public void addButton() {
		WButton wb = new WButton("Button", this);
		add(wb);
		this.updateUI();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("========mouseDragged=" + e.getX());
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
