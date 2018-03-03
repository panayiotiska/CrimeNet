
public class PhoneCall extends Communication{
	int seconds;
	
	public PhoneCall(String phoneNumber1, String phoneNumber2, int day, int month, int year, int seconds) {
		super(phoneNumber1, phoneNumber2, day, month, year);
		this.seconds = seconds;
	}
	
	public int getSeconds() {
		return seconds;
	}

	public void printInfo()
	{
		System.out.println("This phone call has the following info\n"
				+ "Between " + phoneNumber1 + " --- " + phoneNumber2
				+ "\nOn " + year + "/" + month + "/" + day
				+ "\nDuration: " + seconds);
	}

}
