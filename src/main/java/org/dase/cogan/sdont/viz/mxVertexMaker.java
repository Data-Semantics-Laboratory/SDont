package org.dase.cogan.sdont.viz;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.dase.cogan.sdont.model.SDNode;

import com.mxgraph.view.mxGraph;

public class mxVertexMaker implements NodeMaker<Object>
{
	private static final String datatypeStyle = "";
	private static final String standardStyle = "";
	
	private mxGraph graph;
	private Object parent;
	
	public mxVertexMaker(mxGraph graph)
	{
		this.graph = graph;
		this.parent = this.graph.getDefaultParent();
	}
	
	public Map<String, Object> makeNodes(Set<SDNode> nodes)
	{
		Map<String, Object> vertices = new HashMap<>();
		for(SDNode node : nodes)
		{
			vertices.put(node.getLabel(), makeNode(node));
		}
		return vertices;
	}
	
	public Object makeNode(SDNode node)
	{
		// Extract the data from the node
		String id = node.getLabel();
		String value = node.getLabel();
		
		// Create the vertex
		Object vertex = null;
		if(node.isDatatype())
		{
			vertex = this.graph.createVertex(parent, id, value, 0, 0, 100, 100, datatypeStyle);
		}
		else
		{
			vertex = this.graph.createVertex(parent, id, value, 0, 0, 100, 100, standardStyle);
		}
		
		return vertex;
	}
}
