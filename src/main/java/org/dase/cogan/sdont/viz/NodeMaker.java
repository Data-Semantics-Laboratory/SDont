package org.dase.cogan.sdont.viz;

import java.util.Map;
import java.util.Set;

import org.dase.cogan.sdont.model.SDNode;

public interface NodeMaker<T>
{
	public Map<String, T> makeNodes(Set<SDNode> nodes);
	public T makeNode(SDNode node);
}
