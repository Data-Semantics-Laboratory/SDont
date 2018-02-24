package org.dase.cogan.sdont.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SDontGUI
{
	public void run()
	{
		// create a top-level window and add the graph component.
		JFrame frame = new JFrame("SD4ODP");

		frame.setLayout(new FlowLayout());

		JButton open = new JButton("OPEN");
		JButton save = new JButton("SAVE");

		open.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				// TODO finish actionlistener
			}
		});

		save.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				// TODO finish actionlistener
			}
		});

		frame.add(open);
		frame.add(save);

		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
