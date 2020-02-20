package capgemini.healthcaresystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import capgemini.healthcaresystem.dao.UserDaoImplemts;
import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public class ServiceLayerImpl implements ServiceLayer {
	UserDaoImplemts userdao=new UserDaoImplemts();
	public List<Test> getListOfTestService(String centerid)
	{
		return userdao.getListOfTest(centerid);
	}
	
	public boolean addCenterService(DiagnosticCenter center) {
		userdao.addCenter(center);
		return false;
	}

	public boolean removeCenterService(String center) {
		userdao.removeCenter(center);
		return false;
	}

	public String addTestService(String str,Test test) {
		// TODO Auto-generated method stub
		userdao.addTest(str,test);
		return null;
	}

	public boolean removeTestService(String str) {
		userdao.removeTest(str);
		return false;
	}

	public boolean approveAppointmentService() {
		userdao.approveAppointment();
		return false;
	}

	public String makeAppointmentService(DiagnosticCenter str,Test t,Appointment a) {
		System.out.println(".......................................");
		userdao.makeAppointment(str,t,a) ;
		// TODO Auto-generated method stub
		return null;
	}

	public String registerService(ArrayList<User> user) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean validateName(String username) {
		Pattern p=Pattern.compile("[A-Z]\\w");
		Matcher m=p.matcher(username);
		if(m.find())
		   return true;
		else
		 return false;
	}

	public boolean validatePassword(String userpassword) {
	 
		Pattern p1=Pattern.compile("\\w{1,4}[!@#$%^&*]{1,4}+");
		Matcher m1=p1.matcher(userpassword);
		if(m1.find())
		   return true;
		else
		 return false;
	}
	public boolean validateNum(String contactno) {
		Pattern p1=Pattern.compile("0?[7-9][0-9]{9}");
		Matcher m1=p1.matcher(contactno);
		if(m1.find())
		   return true;
		else
		   return false;
	}

	public boolean validateemail(String email) {
		Pattern p1=Pattern.compile("[0-9a-zA-Z][0-9a-zA-Z._]*[@]gmail.com");
		Matcher m1=p1.matcher(email);
		if(m1.find())
		   return true;
		else
		   return false;
	}
  public void downloadAppointmentService(){
	  System.out.println("-----------------");
	  userdao.download();
  }
  }

