package org.dase.cogan.sdont;

import org.dase.cogan.sdont.ui.SDontConsole;
import org.dase.cogan.sdont.ui.SDontGUI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Cogan Shimizu
 */
public class Main
{
	private static final Logger	log	= LoggerFactory.getLogger(Main.class);

	public static void main(String[] args)
	{
		// -d opens the debugging window
		if(args.length == 1 && args[0].equals("-d"))
		{
			(new SDontConsole()).run();
		}
		else
		{
			SDontGUI gui = new SDontGUI();
		}
	}
}
