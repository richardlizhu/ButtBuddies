package name.bagi.levente.pedometer;

public class Person implements Comparable<Person>{
	
	private String user;
	private int step;
	private String dist;
	
	public int compareTo(Person comparePerson)
	{
		int compareQuantity = comparePerson.getStep();
		return this.step - compareQuantity;
	}
	
	
	public String getUser() 
		{
		return user;
		}
	
	public int getStep()
	{
		return step;
	}
	
	public String getDist()
	{
		return dist;
	}
	
	
	public void setUser(String user)
	{
		this.user = user;
	}
	
	
	public void setStep (int step)
	{
		this.step = step;
	}
	
	public void setDist (String dist)
	{
		this.dist = dist;
	}
	
	
	

}
