package capgemini.healthcaresystem.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public interface ServiceLayer {
	 public boolean addCenterService(DiagnosticCenter center);
	  public boolean removeCenterService(String center);
	  public String addTestService(String str,Test test);
	  public boolean removeTestService(String str);
	  public boolean approveAppointmentService();
	  public String makeAppointmentService(DiagnosticCenter str,Test t,Appointment a);
	  public String registerService(ArrayList<User> user);
}
