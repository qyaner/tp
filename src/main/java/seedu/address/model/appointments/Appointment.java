package seedu.address.model.appointments;

import seedu.address.model.person.Name;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;

/**
 * Represents an Appointment in ToothTracker.
 */
public class Appointment {
    private final long dentistId;
    private final long patientId;
    private final AppointmentTime appointmentTime;
    private final String duration;
    private final String treatment;
    private long id;
    private String dentistName;
    private String patientName;

    /**
     * Constructs an Appointment with the specified details.
     *
     * @param dentistId The name of the dentist for the appointment.
     * @param patientId The name of the patient for the appointment.
     * @param appointmentTime The time and date of the appointment.
     * @param duration The duration of the appointment.
     * @param treatment The treatment provided.
     */
    public Appointment(long dentistId, long patientId, AppointmentTime appointmentTime,
                       String duration, String treatment) {
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.treatment = treatment;
        this.id = -1;
    }

    /**
     * Constructs an Appointment with the specified details.
     *
     * @param dentistId The name of the dentist for the appointment.
     * @param patientId The name of the patient for the appointment.
     * @param appointmentTime The time and date of the appointment.
     * @param duration The duration of the appointment.
     * @param treatment The treatment provided.
     * @param id The appointment id.
     */
    public Appointment(long dentistId, long patientId, AppointmentTime appointmentTime,
                       String duration, String treatment, long id) {
        this.dentistId = dentistId;
        this.patientId = patientId;
        this.appointmentTime = appointmentTime;
        this.duration = duration;
        this.treatment = treatment;
        this.id = id;
    }

    public long getDentistId() {
        return this.dentistId;
    }

    public long getPatientId() {
        return this.patientId;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDentistName() {
        return this.dentistName;
    }

    public String getPatientName() {
        return this.patientName;
    }
    public String getDuration() {
        return this.duration;
    }

    public AppointmentTime getAppointmentTime() {
        return this.appointmentTime;
    }

    public String getTreatment() {
        return this.treatment;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }


    /**
     * Checks whether this appointment clashes with another.
     *
     * @param appointment The other appointment.
     * @return true if this appointment clashes with another
     *         false if it does not clash with another appointment.
     */
    public boolean isSameAppointmentTime(Appointment appointment) {
        return this.appointmentTime.isClashingAppointment(appointment.getAppointmentTime());
    }
}
