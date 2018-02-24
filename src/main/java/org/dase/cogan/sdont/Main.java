package org.dase.cogan.sdont;

import org.dase.cogan.sdont.ui.SDontConsole;
import org.dase.cogan.sdont.ui.SDontGUI;

/**
 * @author Cogan Shimizu
 */
public class Main
{
	public static void main(String[] args)
	{
		// -d opens the debugging window
		if(args.length == 1 && args[0].equals("-d"))
		{
			(new SDontConsole()).run();
		}
		else
		{
			(new SDontGUI()).run();
		}
	}
}
