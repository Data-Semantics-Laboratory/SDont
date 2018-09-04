package org.dase.cogan.sdont.parsing;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.MissingImportHandlingStrategy;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAxiom;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;

public class OWLConnector
{
	private OWLOntology			ontology;
	private OWLDataFactory		dataFactory;

	public OWLConnector(String filename) throws OWLOntologyCreationException
	{
		// Get an ontology manager and datafactory
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		this.dataFactory = manager.getOWLDataFactory();
		// Force silent import errors
		manager.setOntologyLoaderConfiguration(manager.getOntologyLoaderConfiguration()
		        .setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT));
		// Create a file from the name
		File file = new File(filename);
		IRI iri = IRI.create(file.toURI());
		// Load Ontology
		this.ontology = manager.loadOntologyFromOntologyDocument(iri);
	}

	public OWLConnector(File file) throws OWLOntologyCreationException
	{
		// Get an ontology manager and datafactory
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		this.dataFactory = manager.getOWLDataFactory();
		// Force silent import errors
		manager.setOntologyLoaderConfiguration(manager.getOntologyLoaderConfiguration()
		        .setMissingImportHandlingStrategy(MissingImportHandlingStrategy.SILENT));
		IRI iri = IRI.create(file.toURI());
		// Load Ontology
		this.ontology = manager.loadOntologyFromOntologyDocument(iri);
	}
	
	public List<OWLClass> retrieveClasses()
	{
		return asList(this.ontology.classesInSignature());
	}
	
	public List<OWLDatatype> retrieveDatatypes()
	{
		return asList(this.ontology.datatypesInSignature());
	}
	
	public List<OWLObjectProperty> retrieveObjectProperties()
	{
		return asList(this.ontology.objectPropertiesInSignature());
	}
	
	public List<OWLDataProperty> retrieveDataProperties()
	{
		return asList(this.ontology.dataPropertiesInSignature());
	}
	
	public List<OWLAxiom> retrieveAxioms()
	{
		return asList(this.ontology.axioms());
	}
	
	public List<OWLSubClassOfAxiom> retrieveSubClassAxioms()
	{
		return asList(this.ontology.axioms(AxiomType.SUBCLASS_OF));
	}
	
	public List<OWLObjectPropertyAxiom> retreiveAxiomsRelatedToObjProp(OWLObjectProperty op)
	{
		return asList(this.ontology.axioms(op));
	}
	
	public List<OWLDataPropertyAxiom> retreiveAxiomsRelatedToDataProp(OWLDataProperty dp)
	{
		return asList(this.ontology.axioms(dp));
	}
	
	private static <T> List<T> asList(Stream<T> s)
	{
		return s.collect(Collectors.toList());
	}
	
	public OWLOntology getOntology()
	{
		return ontology;
	}

	public OWLDataFactory getDataFactory()
	{
		return dataFactory;
	}

	public void setOntology(OWLOntology ontology)
	{
		this.ontology = ontology;
	}

	public void setDataFactory(OWLDataFactory dataFactory)
	{
		this.dataFactory = dataFactory;
	}
}
