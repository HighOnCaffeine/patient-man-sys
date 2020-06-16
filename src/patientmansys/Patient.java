package patientmansys;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author saad_
 */
public class Patient extends Person{
    
    private boolean isAlive;
    private String prescription, dept;
    private int age,id;
    private String illnessDesc;

    public Patient(int id, boolean isAlive, String prescription, int age, String illnessDesc, String name, String gender, String dept) {
        super(name, gender);
        this.isAlive = isAlive;
        this.prescription = prescription;
        this.age = age;
        this.illnessDesc = illnessDesc;
        this.dept = dept;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isIsAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIllnessDesc() {
        return illnessDesc;
    }

    public void setIllnessDesc(String illnessDesc) {
        this.illnessDesc = illnessDesc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Patient{" + "isAlive=" + isAlive + ", prescription=" + prescription + ", dept=" + dept + ", age=" + age + ", id=" + id + ", illnessDesc=" + illnessDesc + '}';
    }
    
}
