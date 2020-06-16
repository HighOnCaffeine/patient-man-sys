package patientmansys;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author saad_
 */
public class Hospital {
    private String name;
    private ArrayList<Department> departmentsList;
    private ArrayList<Doctor> doctorsList;
    private ArrayList<Nurse> nursesList;

    public Hospital() throws SQLException {
        this.name = "La-Waris Hospital";
        departmentsList = new ArrayList<>();
        doctorsList = new ArrayList<>();
        nursesList = new ArrayList<>();
        departmentsList.add(new Department("OPD", 0));
        departmentsList.add(new Department("ICU", 0));
        departmentsList.add(new Department("Burn Center", 0));
        departmentsList.add(new Department("General", 0));
        departmentsList.add(new Department("Emergency", 0));
        
        fetchDB();
    }
    
    public void fetchDB() throws SQLException {
        DatabaseManager dbm = new DatabaseManager();
        ArrayList<Staff> al = dbm.fetchStaff();
        
        for(Staff s : al){
            if(s instanceof Doctor)
                doctorsList.add((Doctor) s);
            else if(s instanceof Nurse)
                nursesList.add((Nurse) s);
        }
        ArrayList<Patient> pAl = dbm.fetchPatients();
        for(Patient p : pAl) {
            for (Department d : this.departmentsList){
                if(p.getDept().equals(d.getName())){
                    d.addPatient(p);
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Department> getDepartmentsList() {
        return departmentsList;
    }

    public void setDepartmentsList(ArrayList<Department> departmentsList) {
        this.departmentsList = departmentsList;
    }

    public ArrayList<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(ArrayList<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public ArrayList<Nurse> getNursesList() {
        return nursesList;
    }

    public void setNursesList(ArrayList<Nurse> nursesList) {
        this.nursesList = nursesList;
    }
    
}
