/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmansys;

import java.util.ArrayList;

/**
 *
 * @author saad_
 */
public class Ward {
    
    private final int MAX_BEDS = 30;
    private int availableBedCount;
    private ArrayList<Patient> beds;
    
    Ward(){
        this.beds = new ArrayList<>(30);
        this.availableBedCount = 30;
    }
    
    public void addPatient(Patient p) throws Exception {
        if(this.availableBedCount != 0){
            beds.add(p);
            availableBedCount--;
        } else {
            throw new Exception("No more beds Available!");
        }
    }
    
    public void removePatient(Patient p) {
            beds.remove(p);
            availableBedCount++;
    }
    
    public int getAvailableBedCount() {
        return this.availableBedCount;
    }
    
}
