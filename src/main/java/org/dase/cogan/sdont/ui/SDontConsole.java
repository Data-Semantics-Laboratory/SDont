package org.dase.cogan.sdont.ui;

import java.util.Scanner;

import org.dase.cogan.sdont.model.SDGraph;
import org.dase.cogan.sdont.parsing.OntologyParser;
import org.dase.cogan.sdont.viz.SDMaker;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;

public class SDontConsole
{
	public void run()
	{
		Scanner keyboard = new Scanner(System.in);
		boolean cont = true;

		while(cont)
		{
			System.out.print("Enter name (or empty string to quit): ");

			String filename = "resources/" + keyboard.nextLine();

			if(filename.equals(""))
			{
				cont = false;
			}
			else
			{
				try
				{
					OntologyParser ontologyParser = new OntologyParser(filename);
					SDGraph graph = ontologyParser.parseOntology();
					SDMaker maker = new SDMaker(graph);
					maker.visualize();
				}
				catch(OWLOntologyCreationException e)
				{
					System.out.println("Could not create ontology from file: " + filename);
				}
			}
		}

		System.out.println("Good bye!");
		keyboard.close();
	}
}
