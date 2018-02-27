package org.dase.cogan.sdont.viz;

import org.dase.cogan.sdont.model.SDEdge;
import org.dase.cogan.sdont.parsing.Triple;

public interface EdgeMaker
{
	public SDEdge makeRoleEdge(Triple t);
	public SDEdge makeSubclassEdge(Triple t);
}
