import java.util.ArrayList;
import java.util.HashSet;

public class Suspect {
	protected String name;
	protected String nickname;
	protected String town;
	private ArrayList<String> telephoneNumbers
				= new ArrayList<String>();
	private ArrayList<Suspect> coSuspects //co-suspects (Synergates)
				= new ArrayList<Suspect>();
	
	public Suspect(String name, String nickname, String town)
	{
		this.name = name;
		this.nickname = nickname;
		this.town = town;
	}
	
	public void addNumber (String number)
	{
		telephoneNumbers.add(number);
	}

	public void setCoSuspect(Suspect likelyNewCoSuspect) 
	{
		for(Suspect s : coSuspects)
		{
			if(likelyNewCoSuspect.equals(s))
			{
				return; //jump out of method (already contained)
			}
		}
		coSuspects.add(likelyNewCoSuspect);
	}
	
	public boolean isConnectedTo (Suspect aSuspect)
	{
		for(Suspect cs : coSuspects)
		{
			if(aSuspect.equals(cs))
			{
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Suspect> getCommonPartners(Suspect aSuspect)
	{
		ArrayList<Suspect> commonPartners
				= new ArrayList<Suspect>();
		
		for(Suspect s : coSuspects)
		{
			for(Suspect cs : aSuspect.coSuspects)
			{
				if(s.equals(cs))
				{
					commonPartners.add(s);
				}
			}
		}
		
		return commonPartners;
	}
	
	public HashSet<Suspect> getSuggestedPartners(Suspect aSuspect)
	{
		HashSet<Suspect> set=new HashSet<Suspect>(); //hash for no duplicates
		
		for(Suspect cs : aSuspect.coSuspects)
		{
			for(Suspect cs2 : cs.coSuspects)
			{
				if(!aSuspect.coSuspects.contains(cs2) && !cs2.equals(aSuspect))
				{
					set.add(cs2);
				}
			}
		}
		return(set);
	}
	
	public void printInfo()
	{
		for (Suspect s : coSuspects)
		{
			System.out.println(s.name + ", " + s.nickname);
		}
	}

	public ArrayList<String> getTelephoneNumbers() {
		return telephoneNumbers;
	}

	public ArrayList<Suspect> getCoSuspects() {
		return coSuspects;
	}
	
	public String getName() {
		return name;
	}

	public String getCodeName() {
		return nickname;
	}
	
	
	
	

	
	

	

	
	
	
	
	
	
	
	
	
	

}
