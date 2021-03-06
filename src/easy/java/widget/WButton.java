package easy.java.widget;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;

import easy.java.ui.TargetPanel;

public class WButton extends JButton implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private int pressedX, pressedY;

	private int curX, curY, curWidth, curHeight;

	private TargetPanel mTargetPanel;

	private ExtraInfo mExtraInfo;

	private boolean resizeNotMove = false;// 标记是resize还是move

	public WButton(String tag, TargetPanel targetPanel) {
		super(tag);
		mExtraInfo = new ExtraInfo();
		mTargetPanel = targetPanel;
		curX = 100;
		curY = 10;
		setSize(90, 50);
		curWidth = 90;
		curHeight = 50;
		setLocation(curX, curY);
		addMouseListener(this);
		addMouseMotionListener(this);
		mExtraInfo.setClickMethod("on" + tag + "Clicked");
	}

	public void setClickMethod(String clickMethod) {
		mExtraInfo.setClickMethod(clickMethod);
	}

	public String getClickMethod() {
		return mExtraInfo.getClickMethod();
	}

	@Override
	protected void fireActionPerformed(ActionEvent event) {
		System.out.println("=========fireActionPerformed");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("=========mouseClicked:");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("=========mousePressed:" + e.getXOnScreen());
		mTargetPanel.setFocusComponent(this);
		pressedX = e.getXOnScreen();
		pressedY = e.getYOnScreen();

		Point location = getLocationOnScreen();
		Dimension size = getSize();
		int left = location.x;
		int top = location.y;
		int right = left + size.width;
		int bottom = top + size.height;

		System.out.println("=========pressedX:" + pressedX + " , right:" + right + " , pressedY:" + pressedY + " , top:"
				+ top + " , bottom:" + bottom);
		if (Math.abs(right - pressedX) <= 2) {
			if (pressedY >= top && pressedY <= bottom) {
				resizeNotMove = true;
				System.out.println("=========resizeNotMove");
			}
		} else {
			resizeNotMove = false;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("=========mouseReleased:[" + e.getXOnScreen() + "," + e.getYOnScreen() + "]");
		if (resizeNotMove) {
			curWidth = getWidth();
			curHeight = getHeight();
		} else {
			curX = curX + e.getXOnScreen() - pressedX;
			curY = curY + e.getYOnScreen() - pressedY;
			if (curX <= 0) {
				curX = 0;
			}
			if (curY <= 0) {
				curY = 0;
			}
			System.out.println("=========curX:" + curX + ",curY:" + curY);
		}
		resizeNotMove = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// System.out.println("=========mouseDragged:" + e.getXOnScreen());
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		int detaX = x - pressedX;
		int detaY = y - pressedY;
		if (resizeNotMove) {
			setSize(curWidth + detaX, curHeight + detaY);
		} else {
			if (curX + detaX <= 0) {
				detaX = -curX;
			}
			if (curY + detaY <= 0) {
				detaY = -curY;
			}
			// System.out.println("=======detaX:" + detaX);
			setLocation(curX + detaX, curY + detaY);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}
}
