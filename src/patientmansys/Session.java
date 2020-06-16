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
public class Session {
    
    private static int id;
    private static String name;
    private static boolean loggedIn;

    private Session() {
        this.id = 1;
        this.name = "";
        this.loggedIn = false;
    }

    public static int getId() {
        return id;
    }

    public static String getName() {
        return name;
    }

    public static void setId(int id) {
        Session.id = id;
    }

    public static void setName(String name) {
        Session.name = name;
    }

    public static void setLoggedIn(boolean loggedIn) {
        Session.loggedIn = loggedIn;
    }
    
    public static boolean isLoggedIn(){
        return loggedIn;
    }
    
}
