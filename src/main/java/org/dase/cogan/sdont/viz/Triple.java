package org.dase.cogan.sdont.viz;

/**
 * 
 * @author Cogs
 *
 * This object is used for passing source to target via role edges from a Parser to a Visualizer
 *
 */
public class Triple
{
	private String fr;
	private String to;
	private String pr;

	public Triple(String fr, String to, String pr)
	{
		this.fr = fr;
		this.to = to;
		this.pr = pr;
	}
	
	public Triple(String fr, String to)
	{
		this.fr = fr;
		this.to= to;
		this.pr = "SUBCLASS";
	}
	
	public String getFr()
	{
		return fr;
	}
	public void setFr(String fr)
	{
		this.fr = fr;
	}
	public String getTo()
	{
		return to;
	}
	public void setTo(String to)
	{
		this.to = to;
	}
	public String getPr()
	{
		return pr;
	}
	public void setPr(String pr)
	{
		this.pr = pr;
	}
}
