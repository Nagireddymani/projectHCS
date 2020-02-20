package capgemini.healthcaresystem.ui;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Random; 
import capgemini.healthcaresystem.dao.*;
import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;
import capgemini.healthcaresystem.service.*;
public class presentation {
	
	static ServiceLayerImpl service=new ServiceLayerImpl();
	static Random rand = new Random(); 
	static Scanner sc=new Scanner(System.in);
	static HashMap<String,String> adminlist=new HashMap<>();
	static List testList=new ArrayList();
	static HashMap<String,User> userlist=new HashMap();
	public presentation() {
		addSomeAdminDetails();
		addSomeTest();
		addSomeUser();
	}
	private void addSomeUser() {
		User u1=new User("101","manikanta","Nagireddymani",9505411992L,"Customer","16211a0278@gmail.com",21,"male");
		User u2=new User("102","harsh","SambhuHarsh",8106327350L,"Customer","16211a0280@gmail.com",25,"male");
		userlist.put(u1.getUserName(),u1);
		userlist.put(u2.getUserName(),u2);
	}
	private void addSomeTest() {
		testList.add("BloopPressure");
		testList.add("Blood Group");
		testList.add("Bloop Sugar");
		
	}
	public static void addSomeAdminDetails()
	{
		adminlist.put("Nagireddymani","11111");
		adminlist.put("eppakayala","22222");
		adminlist.put("Ravali2420","33333");
		adminlist.put("Ashritha3","4444");
		
	}

	public static void main(String[] args)
	{
	System.out.println("    Home");
	System.out.println("1.  Customer");
	System.out.println("2.  Admin");
	System.out.println("Enter your choice");
	int choose=sc.nextInt();
   
	switch(choose)
	{
	case 1 :{
		presentation p=new presentation();
		System.out.println("   Customer ");
		System.out.println("1. register");
		System.out.println("2. login");
		System.out.println("3. download");
		int c=sc.nextInt();
        switch(c)
        {
        case 1 :  register(); break;
        case 2 :  login();break;
        case 3 :  downloadAppointment(); break;
   
        }	
		
	} break;
	case 2 : {           
			   for(int i=0;i<4;i++)
			   {
		         presentation p=new presentation();
		         System.out.println("Username : " );
		         String username=sc.next();
		         System.out.println("Password : " );
		         String password=sc.next();
		         Set s=adminlist.keySet();    
		         Collection c=adminlist.values();
		         int flag=0;
		        if(adminlist.containsKey(username) && adminlist.containsValue(password))
		        {
		        	flag=1;
		        	System.out.println("   Admin ");
		    		System.out.println("1. addCenter");
		    		System.out.println("2. removeCenter");
		    		System.out.println("3. addTest");
		    		System.out.println("4. removeTest");
		    		System.out.println("5. approveAppointment");
		        System.out.println("Enter your choose :");
		        int ch=sc.nextInt();
		        switch(ch)
		        {
		        case 1 :  addCenter(); break;
		        case 2 :  removeCenter(); break;
		        case 3 :  addTest(); break;
		        case 4 :  removeTest();break;
		        case 5 :  approveAppointment();break;
		        }
		        }
		        else 
		        	System.out.println("Invalid Username or password");
		        if(flag==1)
		        	break;
			   }
	         } break;
	default : System.out.println("Go  to Home");
	         break;
	}
	
    }
	
	public static void addCenter()
	{
		DiagnosticCenter dcenter=new DiagnosticCenter();
		UserDaoImplemts dao=new UserDaoImplemts();
		//CenterName
		System.out.println("CenterName :");
		dcenter.setCenterName(sc.next());
		//CenterId  Automaticaally generating
		System.out.println("Center Id : ");
		dcenter.setCenterId(Integer.toString(rand.nextInt(1000)));
		System.out.println(dcenter.getCenterId());
		// Adding default Tests(Blood sugar,Blood Pressure,Blood Group)
		dcenter.setListOfTests(testList);
		service.addCenterService(dcenter); 
		System.out.println("Status : Successfully Added");
		removeCenter();
	}
	public static void removeCenter()
	{
		Set<String> s=(UserDaoImplemts.centerList).keySet();
		int x=1;
		System.out.println("List Of Diagonistic center ids : ");
		for(String i:s)
		{
			System.out.println(x+" : " +i);
			x++;
		}
		System.out.println("Enter a  Center Id to     remove :");
		String select=sc.next();
		service.removeCenterService(select);
		System.out.println("Center Removed succesfully");
		int y=1;
		System.out.println("List Of Diagonistic center ids : ");
		for(String i:s)
		{
			System.out.println(y+" : " +i);
			y++;
		}
		System.out.println("Status : Successfully Removed");
	}
	public static void addTest()
	{
		
		UserDaoImplemts udao1=new UserDaoImplemts();
		Test test=new Test();
		
		// test id
		System.out.println("test Id : ");
		String TestId=Integer.toString(Math.abs(rand.nextInt(1000)));
		System.out.println(TestId);
		test.setTestId(TestId);
			
			//test Name
		System.out.println("test Name");
		String tname=sc.next();
		test.setTestName(tname);
		
		Set<String> s=(UserDaoImplemts.centerList).keySet();
		System.out.println("..........hi..............");
		int x=1;
		System.out.println("List Of Diagonistic center ids : ");
		for(String i:s)
		{
			System.out.println(x+" : " +i);
			x++;
		}
		System.out.println("Enter your center id  ");
		String select=sc.next();
		service.addTestService(select, test);
	}
	
	public static void removeTest()
	{
		UserDaoImplemts udao1=new UserDaoImplemts();
		
		Set<String> s=(UserDaoImplemts.centerList).keySet();
		System.out.println("..........hi..............");
		int x=1;
		System.out.println("List Of Diagonistic center ids : ");
		for(String i:s)
		{
			System.out.println(x+" : " +i);
			x++;
		}
		System.out.println("Enter your center id  ");
		String select=sc.next();
		service.removeTestService(select);
	}
	public static void approveAppointment()
	{ 
		service.approveAppointmentService();
	}
	
	// Customer
	public static void register()
	{
		System.out.println("Registeration Form :   ");
		User u=new User();
		u.setUserId(Integer.toString(Math.abs(rand.nextInt(1000))));
		System.out.println("UserId : "+u.getUserId());
		
		System.out.println("UserName : ");
		String username =sc.next();
		if(service.validateName(username))
		{
			System.out.println("Validated Successfully");
			u.setUserName(username); 
		}
		else
		{
		  System.out.println("Name should not start with special characters  First letter should be capital ");
		}
    	// UserPassword
		 System.out.println("UserPassword : ");
		 String userpassword=sc.next();
		 if(service.validatePassword(userpassword))
		 {
		   System.out.println("Validated Successfully");
		   u.setUserPassword(userpassword);
		 }
		 else
		 {
			 System.out.println(" Password must contain one number,one alphabet,one special character and size should be at least 8 characters and not more than 14 characters.");
		 }
		 
		 //Contact Number
		System.out.println("Contact No : ");
		long contactno=sc.nextLong();
		if(service.validateNum(Long.toString(contactno)))
		{
			u.setContactNo(contactno);
			System.out.println("setted Successfully");
		}
		else
		{
			System.out.println("Invalid Number");
		}
		System.out.println("Age : ");u.setAge(sc.nextInt());        //Age
		System.out.println("Gender : ");u.setGender(sc.next());     //Gender
		System.out.println("UserRole : ");u.setUserRole(sc.next()); //StudentRole
		
		//email
		System.out.println("email Id : ");          
		String email=sc.next();
		if(service.validateemail(email))
		{
			System.out.println("Validated Successfully");
			u.setEmailId(email);	
		}
		else
		{
			System.out.println("Invalid Email");
		}
		userlist.put(u.getUserName(),u);
		
	}
	public static void makeanappointment()
	{
		System.out.println("Appointment Form :");
		Appointment a=new Appointment();
		
		String userId=Integer.toString(Math.abs(rand.nextInt(1000)));
		System.out.println("userId :"+userId);
		a.setUserId(userId);
		
		long appid=Math.abs(rand.nextInt(1000));
		a.setAppointmentId(appid);
		System.out.println("AppointMent Id : "+appid);
		
		System.out.println("Date (dd-MM-yyyy) : ");
		String date=sc.next();
		java.util.Date d = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		   try {
			d=formatter.parse(date);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		a.setDatetime(d);
		a.setApproved(false);
		UserDaoImplemts da=new UserDaoImplemts();
		Set<String> s=(UserDaoImplemts.centerList).keySet();
		
		int x=1;
		System.out.println("List Of Diagonistic center ids : ");
		System.out.println(".................................");
		for(String i:s)
		{
			System.out.println(x+" : " +i);
			x++;
		}
		
		System.out.println("Enter Center id : ");
		String str=sc.next();
		DiagnosticCenter dcen=(UserDaoImplemts.centerList).get(str);
		a.setCenter(dcen);
		List<Test> l=service.getListOfTestService(str);
		System.out.println("Test list of Center "+ str);
		int i=1;
		for(Test t:l)
		{
			System.out.println(i+"   "+t.getTestName()+"   "+t.getTestId());
		    i++;
		}
		System.out.println("Enter Test Id ");
		String t=sc.next();
		List<Test> t1=dcen.getListOfTests();
		Test t5 = null;
		for(Test m:t1)
		{
			if(t.equals(m.getTestId()))
			{
				 t5=m;
			}
		}
		a.setTest(t5);
		System.out.println(a.getTest());
		System.out.println(".........HI....................");
		service.makeAppointmentService(dcen,t5,a);
	}
	public static void downloadAppointment()
	{
	                 service.downloadAppointmentService();    
	}
	public static void login()
	{
	  System.out.println("Username :   ");
	  String username=sc.next();
	  System.out.println("Password :   ");
	  String password=sc.next();
	  System.out.println();
	  User u=userlist.get(username);
	  if(userlist.containsKey(username) && u.getUserPassword().equals(password))
	  {
		  makeanappointment();
	  }
	  else
	  { 
		  System.out.println("Account not found");
		  register();
	  }
	}
	
	
}










