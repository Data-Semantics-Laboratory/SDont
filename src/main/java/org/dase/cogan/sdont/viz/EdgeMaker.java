package org.dase.cogan.sdont.viz;

public interface EdgeMaker
{
	public SDEdge makeRoleEdge(Triple t);
	public SDEdge makeSubclassEdge(Triple t);
}
