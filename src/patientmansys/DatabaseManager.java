package patientmansys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseManager {
    
    final private String dbPath = "jdbc:ucanaccess://D:\\db.accdb";

    public Staff getUser(int id) throws SQLException, UserValidationException {
        //---Declaration------------------------------------------------
        Connection conn = null;
        Statement statement = null;
        PreparedStatement ps;
        try {
            //---Initialization---------------------------------------------
            conn = DriverManager.getConnection(dbPath);
            statement = conn.createStatement();
            
            String query = String.format("SELECT * FROM Staff WHERE id = %s", id);
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            if (rs == null) {
                throw new UserValidationException("Invalid Employee ID");
            } else {
                return new Staff(id, rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("gender"), rs.getString("type"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex2) {//ignoring this exception}
                throw ex;
            } finally {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException ex2) {
                    // do nothing
                }
            }

        }
        return null;
    }
    
    public ArrayList<Staff> fetchStaff() throws SQLException {
        //---Declaration------------------------------------------------
        Connection conn = null;
        Statement statement = null;
        PreparedStatement ps;
        ArrayList<Staff> staffAL = new ArrayList<>();
        try {
            //---Initialization---------------------------------------------
            conn = DriverManager.getConnection(dbPath);
            statement = conn.createStatement();
            
            String query = String.format("SELECT * FROM Staff");
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                staffAL.add(new Staff(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("gender"), rs.getString("type")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex2) {//ignoring this exception}
                throw ex;
            } finally {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException ex2) {
                    // do nothing
                }
            }

        }
        return staffAL;
    }
    
    public ArrayList<Patient> fetchPatients() throws SQLException {
        //---Declaration------------------------------------------------
        Connection conn = null;
        Statement statement = null;
        PreparedStatement ps;
        ArrayList<Patient> patientAL = new ArrayList<>();
        try {
            //---Initialization---------------------------------------------
            conn = DriverManager.getConnection(dbPath);
            statement = conn.createStatement();
            
            String query = String.format("SELECT * FROM Patients");
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                patientAL.add(new Patient(rs.getInt("ID"), rs.getBoolean("isAlive"), rs.getString("Prescription"), rs.getInt("age"), rs.getString("illnessDesc"), rs.getString("name"), rs.getString("gender"), rs.getString("Department")));
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex2) {//ignoring this exception}
                throw ex;
            } finally {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException ex2) {
                    // do nothing
                }
            }

        }
        return patientAL;
    }
    
    public void addPatient(Patient p) throws SQLException {
        Connection conn = null;
        Statement statement = null;
        PreparedStatement ps;
        try {
            //---Initialization---------------------------------------------
            conn = DriverManager.getConnection(dbPath);
            statement = conn.createStatement();
            System.out.println(p.toString());
            
            String pres = "";
            if (p.getPrescription() == null)
                pres =  "-";
            else
                pres = p.getPrescription();
            
            String query = String.format("INSERT INTO Patients(name, gender, isAlive, age, prescription, illnessDesc, Department) "
                    + "VALUES (%s, %s, %b, %d, %s, %s, %s)", p.getName(), p.getGender(), true, p.getAge(), pres, p.getIllnessDesc(), p.getDept());
            System.out.println(statement.executeUpdate(query));
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex2) {//ignoring this exception}
                throw ex;
            } finally {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException ex2) {
                    // do nothing
                }
            }

        }
    }
    
    
    public void removePatient(int index) throws SQLException {
        Connection conn = null;
        Statement statement = null;
        PreparedStatement ps;
        try {
            //---Initialization---------------------------------------------
            conn = DriverManager.getConnection(dbPath);
            statement = conn.createStatement();
            
            String query = String.format("DELETE * FROM Patients where id = %d", index);
            statement.executeUpdate(query);
            
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex2) {//ignoring this exception}
                throw ex;
            } finally {
                try {
                    statement.close();
                    conn.close();
                } catch (SQLException ex2) {
                    // do nothing
                }
            }

        }
    }
    
}
