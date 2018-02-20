package org.dase.cogan.sdont.ui;

import java.util.Scanner;

public class SDontConsole
{
	public void run()
	{
		Scanner keyboard = new Scanner(System.in);
		String line = " ";

		while(!line.equals(""))
		{
			System.out.print("Enter name (empty string to quit): ");

			String fn = keyboard.nextLine();
			
			// TODO implement access to parsing
		}

		System.out.println("End.");
		keyboard.close();
	}
}
