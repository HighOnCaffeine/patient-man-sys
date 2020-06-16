/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmansys;

import java.sql.SQLException;
import patientmansys.Patient;
import java.util.ArrayList;
import patientmansys.Doctor;
import patientmansys.Nurse;

/**
 *
 * @author saad_
 */
public class Department {
    
    private String name;
    private int nPatients;
    private ArrayList<Patient> patientAL; 
    private ArrayList<Nurse> nurseAL; 
    private ArrayList<Doctor> doctorAL;
    private Ward ward;

    public Department(String name, int nPatients) {
        this.name = name;
        this.nPatients = nPatients;
        this.patientAL = new ArrayList<>();
        this.nurseAL = new ArrayList<>();
        this.doctorAL = new ArrayList<>();
        this.ward = new Ward();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getnPatients() {
        return nPatients;
    }

    public void setnPatients(int nPatients) {
        this.nPatients = nPatients;
    }
    
    public void addPatient(Patient p) throws SQLException {
        this.patientAL.add(p);
        DatabaseManager dbm = new DatabaseManager();
        dbm.addPatient(p);
        nPatients++;
    }
    
    public void addPatientInWard(Patient p) throws Exception {
        ward.addPatient(p);
        addPatient(p);
    }
    
    public void removePatient(Patient p) throws Exception {
        this.patientAL.remove(p);
        ward.removePatient(p);
        nPatients--;
    }

    public ArrayList<Patient> getPatientAL() {
        return patientAL;
    }
    
    
    
}
