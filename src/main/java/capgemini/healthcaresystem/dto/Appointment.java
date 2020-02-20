package capgemini.healthcaresystem.dto;
import java.util.Date;
public class Appointment  {
   private  String userId;
   private long appointmentId;
   private Date datetime;
   private boolean approved;
   Test test;
   DiagnosticCenter center;
   
   // Getter-Setter method 
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public long getAppointmentId() {
	return appointmentId;
}
public void setAppointmentId(long appointmentId) {
	this.appointmentId = appointmentId;
}
public Date getDatetime() {
	return datetime;
}
public void setDatetime(Date datetime) {
	this.datetime = datetime;
}
public boolean isApproved() {
	return approved;
}
public void setApproved(boolean approved) {
	this.approved = approved;
}
public Test getTest() {
	return test;
}
public void setTest(Test test) {
	this.test = test;
}
public DiagnosticCenter getCenter() {
	return center;
}
public void setCenter(DiagnosticCenter center) {
	this.center = center;
}

// Overridden hashcode method
@Override
public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + (int) (appointmentId ^ (appointmentId >>> 32));
	result = prime * result + (approved ? 1231 : 1237);
	result = prime * result + ((center == null) ? 0 : center.hashCode());
	result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
	result = prime * result + ((test == null) ? 0 : test.hashCode());
	result = prime * result + ((userId == null) ? 0 : userId.hashCode());
	return result;
}
//Overridden equals method
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Appointment other = (Appointment) obj;
	if (appointmentId != other.appointmentId)
		return false;
	if (approved != other.approved)
		return false;
	if (center == null) {
		if (other.center != null)
			return false;
	} else if (!center.equals(other.center))
		return false;
	if (datetime == null) {
		if (other.datetime != null)
			return false;
	} else if (!datetime.equals(other.datetime))
		return false;
	if (test == null) {
		if (other.test != null)
			return false;
	} else if (!test.equals(other.test))
		return false;
	if (userId == null) {
		if (other.userId != null)
			return false;
	} else if (!userId.equals(other.userId))
		return false;
	return true;
}
//Overridden toString
@Override
public String toString() {
	return "Appointment [userId=" + userId + ", appointmentId=" + appointmentId + ", datetime=" + datetime + ", approved=" + approved + ", test=" + test + ", center=" + center + "]";
}
//default Constructor
public Appointment() {
	super();
}
public Appointment(String userId, long appointmentId, Date datetime, boolean approved, Test test,
		DiagnosticCenter center) {
	super();
	this.userId = userId;
	this.appointmentId = appointmentId;
	this.datetime = datetime;
	this.approved = approved;
	this.test = test;
	this.center = center;
}
   

}
