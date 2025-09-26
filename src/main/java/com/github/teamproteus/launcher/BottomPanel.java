package com.github.teamproteus.launcher;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.geom.Point2D;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class BottomPanel extends JPanel {
	Image image = null;
	Image img;
	public static int paddingx = 1;
	public static int paddingy = 1;

	public BottomPanel() {
		setLayout(new GridBagLayout());
		try {
			image = ImageIO.read(Launcher.class.getResource("/icons/dirt.png")).getScaledInstance(32, 32, 16);
		} catch (IOException e2) {
			e2.printStackTrace();
			return;
		}

		JComponent empty = new JComponent() {};
		empty.setSize(2, 0);
		empty.setPreferredSize(new Dimension(2,0));

		GridBagConstraints constr = new GridBagConstraints();

		JPanel buttons = new JPanel();
		buttons.setLayout(new GridBagLayout());
		buttons.setOpaque(false);

		//Versions
		constr.gridx = 0;
		constr.gridy = 2;
		constr.insets = new Insets(paddingy, paddingx, paddingy, paddingx);
		buttons.add(Window.selectVersionButton, constr);

		//Edit Instance
		constr.gridx = 0;
		constr.gridy = 1;
		buttons.add(Window.settingsButton, constr);	

		//Language
		constr.gridx = 0;
		constr.gridy = 0;
		buttons.add(Window.langButton, constr);

		//Username
		constr.gridx = 2;
		constr.gridy = 0;
		constr.insets = new Insets(paddingy, -(Window.loginButton.getPreferredSize().width + paddingx), paddingy, paddingx);
		buttons.add(Window.nick_input, constr);

		//Login
		constr.gridx = 2;
		constr.gridy = 0;
		constr.insets = new Insets(paddingy, Window.nick_input.getPreferredSize().width + paddingx*3 + 2, paddingy, paddingx);
		buttons.add(Window.loginButton, constr);

		//Spacer
		constr.gridx = 1;
		constr.gridy = 1;
		constr.insets = new Insets(paddingy, 10, paddingx, 10);
		buttons.add(empty, constr);
		
		//Play
		constr.gridy = 1;
		constr.gridx = 2;
		constr.insets = new Insets(paddingy, paddingx, paddingy, paddingx);
		buttons.add(Window.playButton, constr);


		//Selected Version Display
		constr.gridy = 2;
		constr.gridx = 2;

		int number0 = (Window.tabinstances.getPreferredSize().width);
		constr.insets = new Insets(paddingy, -number0, paddingy, paddingx);
		buttons.add(Window.selectedInstanceDisplay, constr);

		//Instances
		int number1 = (Window.playButton.getPreferredSize().width - Window.tabinstances.getPreferredSize().width) + paddingx;

		constr.insets = new Insets(paddingy, number1, paddingx, paddingy);
		buttons.add(Window.tabinstances, constr);

		GridBagConstraints constr1 = new GridBagConstraints();
		this.add(buttons, constr1);
	}

	public void update(final Graphics graphics) {
		this.paint(graphics);
	}

	public void paintComponent(Graphics g) {
		final int n = this.getWidth() / 2 + 1;
		final int n2 = this.getHeight() / 2 + 1;
		if (this.img == null || this.img.getWidth(null) != n || this.img.getHeight(null) != n2) {
			this.img = this.createImage(n, n2);
			final Graphics graphics2 = this.img.getGraphics();
			for (int i = 0; i <= n / 32; ++i) {
				for (int j = 0; j <= n2 / 32; ++j) {
					graphics2.drawImage(this.image, i * 32, j * 32, null);
				}
			}
			if (graphics2 instanceof Graphics2D) {
				final Graphics2D graphics2D = (Graphics2D)graphics2;
				final int n3 = 1;
				graphics2D.setPaint(new GradientPaint(new Point2D.Float(0.0f, 0.0f), new Color(553648127, true), new Point2D.Float(0.0f, n3), new Color(0, true)));
				graphics2D.fillRect(0, 0, n, n3);
				final int n4 = n2;
				graphics2D.setPaint(new GradientPaint(new Point2D.Float(0.0f, 0.0f), new Color(0, true), new Point2D.Float(0.0f, n4), new Color(1610612736, true)));
				graphics2D.fillRect(0, 0, n, n4);
			}
			graphics2.dispose();
		}
		g.drawImage(this.img, 0, 0, n * 2, n2 * 2, null);
	}
}
