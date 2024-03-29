package animation;

import java.awt.Color;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import java.awt.Insets;

public class TwoPageFour extends JFrame {

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(600, 700));
		frame.setTitle("Data Movement & Encapsulation");

		JPanel panel = new JPanel();

		TestPane testPane = new TestPane();
		panel.add(testPane);
		TestPaneHi testPaneHi = new TestPaneHi(frame);
		panel.add(testPaneHi);

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

	}
}

class TestPane extends JPanel {

	Image img = new ImageIcon(this.getClass().getResource("/data5.png")).getImage();

	int x = 100, y = 100, radius = 20, velX = 10, velY = 10;

	public TestPane() {

		Timer timer = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (y > 540) {
					x += velX;
					y = 540;
				}

				if (x == 600 && y == 540) {
					y = 100;
					x = 100;
					y += velY;
					if (y > 540) {
						x += velX;
						y = 540;
					}

				}
				y += velY;

				repaint();

			}
		});
		timer.start();
	}

	public Dimension getPreferredSize() {
		return new Dimension(600, 600);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		setLayout(null);
		g.drawImage(img, 0, 0, this);
		setOpaque(false);
		g.setColor(Color.yellow);
		g.fillRect(x, y - radius, radius * 3, radius);
		g.setColor(Color.black);
		g.drawString("Data", x + 15, y - 5);
	}
}

class TestPaneHi extends JPanel {

	boolean isClicked;
	JButton btnNext = new JButton("next");

	public TestPaneHi(JFrame frame) {

		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setOpaque(false);
		setLocation(0, 600);

		// btnNext.addActionListener();
		btnNext.setBounds(460, 800, 117, 29);
		add(btnNext);

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frame.dispose();
					TwoPageFourHalf mD = new TwoPageFourHalf();
					mD.setVisible(true);
					}catch(Exception d) {
						JOptionPane.showMessageDialog(null, d);
					}
			}
		});
	}
	public Dimension getPreferredSize() {
		return new Dimension(600, 200);
	}

	public boolean isClicked() {

		return isClicked;
	}

}
