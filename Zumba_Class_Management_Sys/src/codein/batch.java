package codein;
import java.io.Serializable;

@SuppressWarnings("serial")
class Batch extends Participant implements Serializable{

	String day;
	int hour;
	
	public Batch(int id, String first_name, String last_name, long contact_no, String email_id, String monthlyPaymentStatus, String day, int hour)
	{
		super(id, first_name, last_name, contact_no, email_id, monthlyPaymentStatus, day, hour);
		this.day = day;
		this.hour= hour;
	}
	

	public String getDay()
	{
		return day;
	}

	public int getHour(int hour)
	{
	    return hour;
	}


	public String toString()
	{
		return "\nBatch Details:" + "\nShift:" + this.day + "\nHour:" + this.hour;
	}
	
}