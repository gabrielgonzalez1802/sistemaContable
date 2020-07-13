package com.contable.app.panels;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelInicio extends JPanel {

	private static final long serialVersionUID = -7444184312954198013L;

	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		this.setBounds(32, 122, 534, 270);
	}
	
	@Override
	public void paint(Graphics g) {
		Dimension dimension = this.getSize();
		ImageIcon icon = new ImageIcon(getClass().getResource("/inicio.jpg"));
		g.drawImage(icon.getImage(), 0, 0, dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
	}

}
