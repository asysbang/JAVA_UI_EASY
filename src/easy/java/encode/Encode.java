package easy.java.encode;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

import easy.java.widget.WButton;
import easy.java.widget.WLabel;

public class Encode {

	public static String encodeA(BufferedWriter bw, Component[] components) throws Exception {
		List<WButton> btns = new ArrayList<WButton>();
		List<WLabel> labels = new ArrayList<WLabel>();
		for (Component comp : components) {
			if (comp instanceof WButton) {
				btns.add((WButton) comp);
			}
			if (comp instanceof WLabel) {
				labels.add((WLabel) comp);
			}
		}
		if (labels.size() > 0) {
			bw.write("private JLabel ");
			for (int i =0;i<labels.size();i++) {
				bw.write("mLabel"+i);
				if (i == labels.size()-1) {
					bw.write(";\n");
				}else {
					bw.write(",");
				}
			}
		}
		if (btns.size() > 0) {
			bw.write("private JButton ");
			for (int i =0;i<btns.size();i++) {
				bw.write("mBtn"+i);
				if (i == btns.size()-1) {
					bw.write(";\n");
				}else {
					bw.write(",");
				}
			}
		}
		return null;
	}


	public static String encodeB(BufferedWriter bw, Component[] components) throws Exception {
		List<WButton> btns = new ArrayList<WButton>();
		List<WLabel> labels = new ArrayList<WLabel>();
		for (Component comp : components) {
			if (comp instanceof WButton) {
				btns.add((WButton) comp);
			}
			if (comp instanceof WLabel) {
				labels.add((WLabel) comp);
			}
		}
		if (labels.size() > 0) {
			for (int i =0;i<labels.size();i++) {
				WLabel wLabel = labels.get(i);
				bw.write("mLabel"+i+"= new JLabel(\""+wLabel.getText()+"\");\n");
				Dimension size = wLabel.getSize();
				bw.write("mLabel" + i + ".setSize(" + size.width + "," + size.height + ");\n");
				Point location = wLabel.getLocation();
				bw.write("mLabel" + i + ".setLocation(" + location.x + "," + location.y + ");\n");
				bw.write("add(mLabel" + i + ");\n");
				bw.write("\n");
			}
		}
		if (btns.size() > 0) {
			for (int i =0;i<btns.size();i++) {
				WButton wButton = btns.get(i);
				bw.write("mBtn"+i+"= new JButton(\""+wButton.getText()+"\");\n");
				Dimension size = wButton.getSize();
				bw.write("mBtn" + i + ".setSize(" + size.width + "," + size.height + ");\n");
				Point location = wButton.getLocation();
				bw.write("mBtn" + i + ".setLocation(" + location.x + "," + location.y + ");\n");
				bw.write("mBtn" + i + ".addActionListener(this);\n");
				bw.write("add(mBtn" + i + ");\n");
				bw.write("\n");
			}
		}
		return null;
	}
}
