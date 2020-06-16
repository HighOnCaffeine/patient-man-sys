/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patientmansys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saad_
 */
public class Validate {

    public Staff validateSignup(String id, char[] pass) throws UserValidationException, SQLException {
        
        //database connection
        String passString = new String(pass), dbPass = null;
        Staff user = null;
        
        DatabaseManager dbm = new DatabaseManager();
 
        if(!(id.isEmpty() || pass.length <= 0)){
            
            try {
                user = dbm.getUser(Integer.parseInt(id));
                dbPass = user.getPassword();
            } catch(UserValidationException ex){
                throw ex;
            } catch (NumberFormatException ex) {
                throw new UserValidationException("Invalid Employee ID");
            } catch (SQLException ex){
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            if(passString.equals(dbPass)){
                return user;
            } else {
                throw new UserValidationException("Incorrect Password! ");
            }
            
        } else {
            throw new UserValidationException("Required Field(s) is/are empty!");
        }
        
    }
    
}
