/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmansys;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author saad_
 */
public class Prescription {
    private ArrayList<String> meds;
    private Date date;
    private Doctor doctor;

    public Prescription(ArrayList<String> meds, Date date, Doctor doctor) {
        this.meds = new ArrayList<>();
        this.date = date;
        this.doctor = doctor;
    }

    public ArrayList<String> getMeds() {
        return meds;
    }

    public void setMeds(ArrayList<String> meds) {
        this.meds = meds;
    }
    
    public void addMeds(String medicine) {
        meds.add(medicine);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    @Override
    public String toString() {
        String s = "Prescreption by Dr. " + doctor.getName() + "\n"
                + "Dated: " + date.toString() + "\n"
                + "Medicines: \n";
        for (String str : meds){
            s += "\t" + str + "\n";
        }
        return s;
    }
}
