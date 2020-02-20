package capgemini.healthcaresystem.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Date;

import capgemini.healthcaresystem.dto.Appointment;
import capgemini.healthcaresystem.dto.DiagnosticCenter;
import capgemini.healthcaresystem.dto.Test;
import capgemini.healthcaresystem.dto.User;

public interface UserDao {
  public boolean addCenter(DiagnosticCenter center);
  public boolean removeCenter(String center);
  public String addTest(String str,Test test);
  public boolean removeTest(String str);
  public boolean approveAppointment();
  public String makeAppointment(DiagnosticCenter str,Test t,Appointment a);
  public String register(ArrayList<User> user);
}
