package org.dase.cogan.sdont.viz;

import org.dase.cogan.sdont.model.SDNode;
import org.dase.cogan.sdont.parsing.Triple;

public interface NodeMaker
{
	public SDNode makeNode(Triple t);
}
