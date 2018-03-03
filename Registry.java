import java.util.ArrayList;

public class Registry {
	private ArrayList<Suspect> suspects = new ArrayList<Suspect>();
	private ArrayList<Communication> communications = new ArrayList<Communication>();
	
	public Registry() {
		//No fields
	}

	public void addSuspect(Suspect aSuspect)
	{
		suspects.add(aSuspect);
	}
	
	public void addCommunication(Communication aCommunication)
	{
		String num1 = aCommunication.getPhoneNumber1();
		String num2 = aCommunication.getPhoneNumber2();
		Suspect s1 = null;
		Suspect s2 = null;
		
		communications.add(aCommunication);
		
		for(Suspect s : suspects)
		{
			if(s.getTelephoneNumbers().contains(num1))
			{
				s1 = s;
			}
			
			if(s.getTelephoneNumbers().contains(num2))
			{
				s2 = s;
			}
		}
		
		s1.setCoSuspect(s2);
		s2.setCoSuspect(s1);
	}	
	
	public Suspect getSuspectWithMostPartners()
	{
		int max = 0;
		Suspect maxSuspect = null;
		for(Suspect s : suspects)
		{
			if (s.getCoSuspects().size() >=  max)
			{
			max = s.getCoSuspects().size();
			maxSuspect = s;
			}
		}
	return(maxSuspect);
	}
	
	public PhoneCall getLongestPhoneCallBetween(String number1, String number2)
	{
		int maxSeconds = 0;
		PhoneCall longestPhoneCall = null;
		for(Communication c: communications)
		{
			if(c.getPhoneNumber1() == number1 && c instanceof PhoneCall) //an den anaferetai se phonecall na min ginei elenxos
			{
				if(c.getPhoneNumber2() == number2)
				{
					if(((PhoneCall)c).getSeconds() > maxSeconds) //DownCasting
					{
						maxSeconds = ((PhoneCall)c).getSeconds();
						longestPhoneCall = ((PhoneCall)c);
					}
				}
			}
			else if(c.getPhoneNumber2() == number2 && c instanceof PhoneCall)
			{
				if(c.getPhoneNumber1() == number1)
				{
					if(((PhoneCall)c).getSeconds() > maxSeconds)
					{
						maxSeconds = ((PhoneCall)c).getSeconds();
						longestPhoneCall = ((PhoneCall)c);
					}
				}
			}
		}
		return longestPhoneCall;	
	}
	
	public ArrayList<SMS> getMessagesBetween(String number1, String number2)
	{
		ArrayList<SMS> messages = new ArrayList<SMS>();
		String w1 = ".*Gun.*" , w2 = ".*Explosives.*" , w3 = ".*Attack.*" , w4 = ".*Bomb.*" ; // .* => any character as many times
		
		for(Communication c: communications)
		{
			if(c.getPhoneNumber1() == number1 && c instanceof SMS) //an den anaferetai se sms na min ginei elenxos
			{
				if(c.getPhoneNumber2() == number2)
				{
					if ((((SMS)c).getText()).matches(w1) || (((SMS)c).getText()).matches(w2) || (((SMS)c).getText()).matches(w3) || (((SMS)c).getText()).matches(w4))
					{
						messages.add(((SMS)c));
					}
				}
			}
			else if(c.getPhoneNumber2() == number2 && c instanceof SMS)
			{
				if(c.getPhoneNumber1() == number1)
				{
					if ((((SMS)c).getText()).matches(w1) || (((SMS)c).getText()).matches(w2) || (((SMS)c).getText()).matches(w3) || (((SMS)c).getText()).matches(w4))
					{
						messages.add(((SMS)c));
					}
				}
			}
		}
		
	return(messages);
	}

	public ArrayList<Suspect> getSuspects() {
		return suspects;
	}

	public ArrayList<Communication> getCommunications() {
		return communications;
	}
	
	
	
	
}
