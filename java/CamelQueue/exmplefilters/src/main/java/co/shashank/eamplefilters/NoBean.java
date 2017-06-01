package co.shashank.eamplefilters;

public class NoBean {

	public void printB(Persons p)
	{
		System.out.println("IN NO BEAN" + p.getPersons().get(1).getName());
	}
}
