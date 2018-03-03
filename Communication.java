
public class Communication{
	String phoneNumber1;
	String phoneNumber2;
	int day, month, year;
	
	public Communication(String phoneNumber1, String phoneNumber2, int day, int month, int year) {
		this.phoneNumber1 = phoneNumber1;
		this.phoneNumber2 = phoneNumber2;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

}
