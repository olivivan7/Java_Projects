package codein;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class zumbaClassManagementSys
{	
	static void display(ArrayList<Participant> al)
	{
		System.out.println("\n--------------Participants List---------------\n");
		System.out.println(String.format("%-10s%-15s%-10s%-20s%-10s", "ID","Name","Last Name","Contact Number",
							"Email","Monthly Payment Status","Shift"));
		for(Participant p : al)
		{
			System.out.println(String.format("%-5s%-20s%-10s%-15s%-10s", p.id, p.first_name, p.last_name, p.contact_no,
								p.email_id, p.monthlyPaymentStatus, p.class_day, p.class_hour));
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		Integer id;
		String first_name;
		String last_name;
		Long contact_no;
		String email_id;
		String monthlyPaymentStatus;
		String class_day;
		Integer class_hour;
		String weekday;
		Integer hour;
		
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Participant> al = new ArrayList<Participant>();
		
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try{
			
			f = new File("C:/Users/olivi/eclipse-workspace/Zumba_Class_Management_Sys/src/ParticipantsDataset.txt");
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			al = (ArrayList<Participant>)ois.readObject();
			
			
		}
		catch(Exception exp){
			System.out.println(exp);
		}
		do
		{
			System.out.println("\n*********Welcome to the Zumba Class Management System**********\n");
			System.out.println("1) Add Participant to the DataBase\n" +
								"2) Search for Participant\n" +
								"3) Edit Participant details\n" +
								"4) Delete Participant details\n" +
								"5) Display all Participant signed up in Zumba Classes\n" +
								"6) Send message to Participants from actual Batch\n" +
								"7) EXIT\n");
			
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			
			switch(ch)
			{
			case 1:System.out.println("\nEnter the following details to ADD list:");
				System.out.println("Enter ID:");
				id = sc.nextInt();
				
				System.out.println("\nEnter Name:");
				first_name = sc.next();
				
				System.out.println("\nEnter Last Name:");
				last_name = sc.next();
				
				System.out.println("\nEnter Contact Number:");
				contact_no = sc.nextLong();
				
				System.out.println("\nEnter Email:");
				email_id = sc.next();
				
				System.out.println("\nEnter Monthly Payment Status:");
				monthlyPaymentStatus = sc.next();
				
				System.out.println("\nEnter Class Day:");
				class_day = sc.next();
				
				System.out.println("\nEnter Class Hour:");
				class_hour = sc.nextInt();
				
				al.add(new Participant(id, first_name, last_name, contact_no, email_id, monthlyPaymentStatus, class_day, class_hour));
				display(al);
				break;
				
			case 2: System.out.println("Enter the Participant ID to search:");
					id = sc.nextInt();
					
					int i=0;
					for(Participant p: al)
					{
						if(id == p.id)
						{
							System.out.println(p + "\n");
							i++;
						}
					}
					
					if(i == 0)
					{
						System.out.println("\nParticipant Details are not available.\nPlease enter a valid ID!");
					}
					break;
			
			case 3: System.out.println("\nEnter the Participant ID to EDIT the details:");
					id = sc.nextInt();
					int j=0;
					for(Participant p: al)
					{
						if(id == p.id)
						{	
							j++;
						do{
							int ch1 = 0;
							System.out.println("\nEDIT Participant Details:\n" +
												"1) Participant ID\n" +
												"2) Name\n" +
												"3) Last Name\n" +
												"4) Contact Number\n" +
												"5) Email\n" +
												"6) Monthly Payment Status\n" +
												"7) Class Day\n" +
												"8) Class Hour\n" +
												"9) GO BACK\n");
							
							System.out.println("Enter your choice:");
							ch1 = sc.nextInt();
							
							switch(ch1)
							{
							case 1: System.out.println("\nEnter new Participant ID:");
									p.id = sc.nextInt();
									System.out.println(p+"\n");
									break;
							
							case 2: System.out.println("Enter new Participant Name:");
									p.first_name = sc.next();
									System.out.println(p+"\n");
									break;
									
							case 3: System.out.println("Enter new Participant Last Name:");
									p.last_name = sc.next();
									System.out.println(p+"\n");
									break;
									
							case 4: System.out.println("Enter new Participant Contact Number:");
									p.contact_no = sc.nextLong();
									System.out.println(p+"\n");
									break;
									
							case 5: System.out.println("Enter new Participant Email:");
									p.email_id = sc.next();
									System.out.println(p+"\n");
									break;
							
							case 6: System.out.println("Enter new Participant Monthly Payment Status:");
									p.monthlyPaymentStatus = sc.next();
									System.out.println(p+"\n");
									break;
							
							case 7: System.out.println("Enter new Participant Class Day:");
									p.class_day =sc.next();
									System.out.println(p+"\n");
									break;
							
							case 8: System.out.println("Enter new Participant Class Hour:");
									p.class_hour =sc.nextInt();
									System.out.println(p+"\n");
									break;
									
							case 9: j++;
									break;
									
							default : System.out.println("\nEnter a correct choice from the List:");
										break;
							
							}
							}
						while(j==1);
						}
					}
					if(j == 0)
					{
						System.out.println("\nParticipant Details are not available.\nPlease enter a valid ID!");
					}
				
					break;
					
			case 4: System.out.println("\nEnter Participant ID to DELETE from the Database:");
					id = sc.nextInt();
					int k=0;
					try{
					for(Participant p: al)
					{
						if(id == p.id)
						{
								al.remove(p);
								display(al);
								k++;
						}
					}
					if(k == 0)
					{
						System.out.println("\nParticipant Details are not available.\nPlease enter a valid ID!");
					}
					}
					catch(Exception ex){
						System.out.println(ex);
					}
					break;
			
			case 5: try {
					al = (ArrayList<Participant>)ois.readObject();
				
					} catch (ClassNotFoundException e2) {
						System.out.println(e2);
						
					} catch (Exception e2) {
						System.out.println(e2);
					
					}
					
					display(al);
					break;
			
			case 6: System.out.println("Enter the Class Weekday:");
					weekday = sc.next();
					
					System.out.println("Enter the Class Hour:");
					hour = sc.nextInt();
					
					int counter=0;
					for(Participant p: al)
					{
						if(weekday == p.class_day && hour == p.class_hour)
						{
							sendEmail.main(args, p.email_id);
							counter++;
						}
					}
					
					if(counter == 0)
					{
						System.out.println("\nParticipant Details are not available.\nPlease enter a valid Weekday and Hour!");
					}
					
					break;	
			
			case 7: try {
					fos = new FileOutputStream(f);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(al);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				catch(Exception e2){
					e2.printStackTrace();
				}
				finally{
					try {
						fis.close();
						ois.close();
						fos.close();
						oos.close();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
					System.out.println("\nYou have chosen EXIT!\nSaving Files and closing the tool.");
					sc.close();
					
					System.exit(0);
					break;
					
			default : System.out.println("\nEnter a correct choice from the List:");
						break;
			
			}
		}
		while(true);
	}

	
}