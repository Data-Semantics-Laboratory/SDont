package org.dase.cogan.sdont.viz;

import java.util.Map;
import java.util.Set;

import org.dase.cogan.sdont.model.SDEdge;
import org.dase.cogan.sdont.model.SDGraph;
import org.dase.cogan.sdont.model.SDNode;
import org.dase.cogan.sdont.ui.SDontViewFrame;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class SDMaker
{
	private SDGraph		sdGraph;
	private mxGraph		mxGraph;
	private NodeMaker<Object>	vertexMaker;
	private EdgeMaker<Object>	edgeMaker;

	private Map<String, Object> vertices;
	private Map<String, Object> edges;
	
	public SDMaker(SDGraph sdGraph)
	{
		this.sdGraph = sdGraph;

		this.mxGraph = new mxGraph();
		this.vertexMaker = new mxVertexMaker(mxGraph);
		this.edgeMaker = new mxEdgeMaker(mxGraph);
	}

	public void visualize()
	{
		// Make the graph
		makeGraph();
		// Create and display the visualization
		mxGraphComponent graphComponent = new mxGraphComponent(this.mxGraph);
		@SuppressWarnings("unused")
		SDontViewFrame frame = new SDontViewFrame(graphComponent);
	}

	private void makeGraph()
	{
		// Get default parent
		Object parent = this.mxGraph.getDefaultParent();
		// Make all vertices
		makeVertices(parent);
		// Make all edges
		makeEdges(parent);
	}

	private void makeVertices(Object parent)
	{
		// Get all nodes from sdgraph
		Set<SDNode> nodeset = this.sdGraph.getNodeSet();
		// Create the visualizations of the nodes
		this.vertices = this.vertexMaker.makeNodes(nodeset);
		// Add them all to the graph
		this.mxGraph.getModel().beginUpdate();
		try
		{
			for(Object vertex : this.vertices.values())
			{
				this.mxGraph.addCell(vertex);
			}
		}
		finally
		{
			this.mxGraph.getModel().endUpdate();
		}
	}

	private void makeEdges(Object parent)
	{
		// Get all edges from the sdgraph
		Set<SDEdge> edgeset = this.sdGraph.getEdgeSet();
		// Create the visualizations of the edges
		this.edges = this.edgeMaker.makeEdges(edgeset, this.vertices);
		// Add them all to the graph
		this.mxGraph.getModel().beginUpdate();
		try
		{
			for(Object edge : edges.values())
			{
				this.mxGraph.addCell(edge);
			}
		}
		finally
		{
			this.mxGraph.getModel().endUpdate();
		}
	}
}
