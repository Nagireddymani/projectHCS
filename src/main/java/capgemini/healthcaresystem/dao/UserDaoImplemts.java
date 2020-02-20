package capgemini.healthcaresystem.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public  class UserDaoImplemts implements UserDao {
public static HashMap<String,DiagnosticCenter> centerList=new HashMap<>();
 
static Scanner sc=new Scanner(System.in);


   public static void addSomeCenters()
   {
	   Test t1=new Test();
	   t1.setTestId("100001");
	   t1.setTestName("Colonoscopy");
	   Test t3=new Test();
	   t3.setTestId("100003");
	   t3.setTestName("CT-Scan");
	   
	   DiagnosticCenter d1=new DiagnosticCenter();
	   Appointment a1=new Appointment();
	   a1.setTest(t1);
	   a1.setTest(t3);
	   
	   a1.setAppointmentId(1111111111L);
	   a1.setApproved(false);
	   a1.setDatetime(new Date(2020,1,20));                                    //String centerName, String centerId, List<Test> listOfTests, List<Appointment> appointmentList
	   a1.setCenter(d1);                                                       //String testId, String testName
	   a1.setUserId("16211a0278");                                    //String userId, long appointmentId, Date datetime, boolean approved, Test test,DiagnosticCenter center	
       
	   d1.setAppointmentList(Arrays.asList(a1));
	   d1.setListOfTests(Arrays.asList(t1));
	   d1.setListOfTests(Arrays.asList(t3));
	   
	   d1.setCenterId("77777777");                   // --->CenterId
	   d1.setCenterName("Nagireddy Diagnostic Center");
	   
	   Test t2=new Test();
	   t2.setTestId("100002");
	   t2.setTestName("Biopsy");
	   
	   DiagnosticCenter d2=new DiagnosticCenter();
	   Appointment a2=new Appointment();
	   
	   a2.setTest(t2);
	   
	   a2.setAppointmentId(2222222222L);
	   a2.setApproved(false);
	   a2.setDatetime(new Date(2020,1,20));                                    //String centerName, String centerId, List<Test> listOfTests, List<Appointment> appointmentList
	   a2.setCenter(d1);                                                       //String testId, String testName
	   a2.setUserId("16211A0279");                                    //String userId, long appointmentId, Date datetime, boolean approved, Test test,DiagnosticCenter center	
	   
	   d2.setAppointmentList(Arrays.asList(a1));
	   d2.setListOfTests(Arrays.asList(t1));
	   d2.setCenterId("88888888");                 //  ----->CenterId
	   d2.setCenterName("Afreen Diagnoistic Center ");
	   
	   centerList.put(d1.getCenterId(), d1);
	   centerList.put(d2.getCenterId(), d2);
	   
	   
	   
   }
   public List<Test> getListOfTest(String centerid)
   { 
	  return centerList.get(centerid).getListOfTests();
	  
   }
   
// HashMap<Integer,Test> testList=new HashMap<Integer,Test>();
   
	public UserDaoImplemts() {
		addSomeCenters();
	// TODO Auto-generated constructor stub
}

	public boolean addCenter(DiagnosticCenter center) {
		UserDaoImplemts u=new UserDaoImplemts();
	    centerList.put(center.getCenterId(), center);
		return false;
	}

	public boolean removeCenter(String center) {
		(UserDaoImplemts.centerList).remove(center);
		return false;
	}

	public String addTest(String str,Test test) {
		// TODO Auto-generated method stub
		 System.out.println("...........addTest Method............");
		 DiagnosticCenter dc=centerList.get(str);
		 List<Test> l= dc.getListOfTests();
		 //System.out.println(l);
		 List<Test> l1=new ArrayList<>();
		 l1.add(test);
		// System.out.println("...........hi............");
		 //System.out.println(l1);
		 l1.addAll(l);
		 //System.out.println(".......end.................");
		 //System.out.println(l1);
		 dc.setListOfTests(l1); 
		 System.out.println(dc.getListOfTests());
		 System.out.println("Test added Succussfully in "+str);
		 
		 List<Test> l2= dc.getListOfTests();
		 System.out.println("New Test List :"+l2);
		 
		return null;
	}
	public boolean removeTest(String str) {
		 System.out.println("...........RemoveTest Method............");
		 
		 DiagnosticCenter dc=centerList.get(str);
		 List<Test> list= dc.getListOfTests();
		 int x=1;
		 for(Test t:list)
		 {
				 System.out.println(x+" : "+t.getTestId()+"--->"+t.getTestName());		
				 x++;
		 }
		 List list1=new ArrayList();
		 System.out.println("Enter Test Id :");
		 String select=sc.next();
		 for(Test t:list)
		 {
			 if(select.equals(t.getTestId()))
			 {
				 list1.add(t);
			 }
		 }
		 System.out.println(list1);
		 list1.removeAll(list);
		 System.out.println(list1);
		return false;
	}

	public boolean approveAppointment() {
        UserDaoImplemts udao1=new UserDaoImplemts();
        
		Set<String> s=(UserDaoImplemts.centerList).keySet();
		int x=1;
		System.out.println("List Of Diagonistic center ids : ");
		for(String i:s)
		{
			System.out.println(x+" : " +i);
			x++;
		}
		
		System.out.println("Enter your center id  ");
		String select=sc.next();
		
		DiagnosticCenter dc=centerList.get(select);
		List<Appointment> l=dc.getAppointmentList();
		for(Appointment a:l) 
		{  
			System.out.println(a.getAppointmentId()+"...");
			System.out.println("Enter status : ");
			boolean b=sc.nextBoolean();
			if(a.isApproved()==false)
			   a.setApproved(b);
			
			if(a.isApproved())
			    System.out.println("Appointment Approved");
			else
				System.out.println("Appointment rejected");
		}
		dc.setAppointmentList(l);
		return false;
		
	}

	public String makeAppointment(DiagnosticCenter str,Test t,Appointment a) {
		 List<Appointment> l= str.getAppointmentList();
		 List<Appointment> l1=new ArrayList<>();
		 l1.add(a);
		 l1.addAll(l);
		 str.setAppointmentList(l);
		 System.out.println("Appointment submitted");
			return null;
	}

	public String register(ArrayList<User> user) {
		return null;
	}
	public static void download() {
		long l=sc.nextLong();
		System.out.println("Enter Center id : ");
		String select=sc.next();
		DiagnosticCenter dc=centerList.get(select);
		List<Appointment> list=dc.getAppointmentList();
		for(Appointment a:list) 
		{  
			if(l==a.getAppointmentId())
			System.out.println("User           : "+ a.getUserId());
		    System.out.println("Appointment Id : "+ a.getAppointmentId());
		    System.out.println("Date           : "+ a.getDatetime());
		    System.out.println("Center         : "+ a.getCenter());
		    System.out.println("Test           : "+ a.getTest());
		}
			System.out.println("Thank you");
	}
}
