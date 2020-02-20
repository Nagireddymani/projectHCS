package capgemini.healthcaresystem.dto;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class DiagnosticCenter {
	
// Variable
private String centerName;
private String centerId;
List <Test> listOfTests =new ArrayList<Test>();
List <Appointment> appointmentList =new ArrayList<Appointment>();

//  Getter-Setter methods
public String getCenterName() {
	return centerName;
}
public void setCenterName(String centerName) {
	this.centerName = centerName;
}
public String getCenterId() {
	return centerId;
}
public void setCenterId(String centerId) {
	this.centerId = centerId;
}
public List<Test> getListOfTests() {
	return listOfTests;
}
public void setListOfTests(List<Test> listOfTests) {
	this.listOfTests = listOfTests;
}
public List<Appointment> getAppointmentList() {
	return appointmentList;
}
public void setAppointmentList(List<Appointment> appointmentList) {
	this.appointmentList = appointmentList;
}

//  toString method
@Override
public String toString() {
	return "DiagnosticCenter [centerName=" + centerName + ", centerId=" + centerId + ", listOfTests=" + listOfTests
			+ ", appointmentList=" + appointmentList + "]";
}


// default Constructor
public DiagnosticCenter() {
	super();
}

public DiagnosticCenter(String centerName, String centerId, List<Test> listOfTests, List<Appointment> appointmentList) {
	super();
	this.centerName = centerName;
	this.centerId = centerId;
	this.listOfTests = listOfTests;
	this.appointmentList = appointmentList;
}
//Overridden hashcode method
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((appointmentList == null) ? 0 : appointmentList.hashCode());
	result = prime * result + ((centerId == null) ? 0 : centerId.hashCode());
	result = prime * result + ((centerName == null) ? 0 : centerName.hashCode());
	result = prime * result + ((listOfTests == null) ? 0 : listOfTests.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DiagnosticCenter other = (DiagnosticCenter) obj;
	if (appointmentList == null) {
		if (other.appointmentList != null)
			return false;
	} else if (!appointmentList.equals(other.appointmentList))
		return false;
	if (centerId == null) {
		if (other.centerId != null)
			return false;
	} else if (!centerId.equals(other.centerId))
		return false;
	if (centerName == null) {
		if (other.centerName != null)
			return false;
	} else if (!centerName.equals(other.centerName))
		return false;
	if (listOfTests == null) {
		if (other.listOfTests != null)
			return false;
	} else if (!listOfTests.equals(other.listOfTests))
		return false;
	return true;
}

}
