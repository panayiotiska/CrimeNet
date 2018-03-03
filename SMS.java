
public class SMS extends Communication{
	String text;
	
	public SMS(String phoneNumber1, String phoneNumber2, int day, int month, int year, String text) {
		super(phoneNumber1, phoneNumber2, day, month, year);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void printInfo()
	{
		System.out.println("This SMS has the following info\n"
				+ "Between " + phoneNumber1 + " --- " + phoneNumber2
				+ "\nOn " + year + "/" + month + "/" + day
				+ "\nText: " + text);
	}

}
