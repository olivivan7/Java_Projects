package codein;
import java.io.Serializable;

@SuppressWarnings("serial")
class Participant implements Serializable{

	int id;
	String first_name;
	String last_name;
	long contact_no;
	String email_id;
	String monthlyPaymentStatus;
	String class_day;
	int class_hour;
	
	public Participant(int id, String first_name, String last_name, long contact_no, String email_id, String monthlyPaymentStatus, String class_day, int class_hour)
	{
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.contact_no = contact_no;
		this.email_id = email_id;
		this.monthlyPaymentStatus = monthlyPaymentStatus;
		this.class_day = class_day;
		this.class_hour = class_hour;
	}
	
	public String toString()
	{
		return "\nParticipant Details:" + "\nID: " + this.id + "\nName: " + this.first_name + "\nLast Name: " + this.last_name 
				+ "\nContact Number: " + this.contact_no + "\nEmail: " + this.email_id + "\nMonthly Payment Status: " + this.monthlyPaymentStatus
				+ "\nClass Day: " + this.class_day + "\nClass Hour: " + this.class_hour;
	}
	
}