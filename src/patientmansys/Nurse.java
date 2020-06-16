/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmansys;

/**
 *
 * @author saad_
 */
public class Nurse extends Staff {

    public Nurse(int id, String username, String password, String name, String gender, String type) {
        super(id, username, password, name, gender, type);
    }
    
    public void checkPrescription() {
        
    }
    
}
