package org.dase.cogan.sdont.viz;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.dase.cogan.sdont.model.SDEdge;

import com.mxgraph.view.mxGraph;

public class mxEdgeMaker implements EdgeMaker<Object>
{
	private static final String subclassStyle = "";
	private static final String standardStyle = "";
	
	private mxGraph graph;
	private Object parent;
	
	public mxEdgeMaker(mxGraph graph)
	{
		this.graph = graph;
		this.parent = this.graph.getDefaultParent();
	}
	
	public Map<String, Object> makeEdges(Set<SDEdge> sdedges, Map<String, Object> vertices)
	{
		Map<String, Object> edges = new HashMap<>();
		for(SDEdge sdedge : sdedges)
		{
			edges.put(sdedge.getLabel(), makeEdge(sdedge, vertices));
		}
		return edges;
	}
	
	public Object makeEdge(SDEdge sdedge, Map<String, Object> vertices)
	{
		// Extract the data from the edge
		String id = sdedge.getLabel();
		String value = sdedge.getLabel();
		
		Object source = vertices.get(sdedge.getSource().getLabel());
		Object target = vertices.get(sdedge.getTarget().getLabel());
		
		// Create the mxEdge
		Object edge = null;
		if(sdedge.isSubclass())
		{
			edge = this.graph.createEdge(parent, id, value, source, target, subclassStyle);
		}
		else
		{
			edge = this.graph.createEdge(parent, id, value, source, target, standardStyle);			
		}
		return edge;
	}
}
