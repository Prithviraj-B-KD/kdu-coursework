package backend.handson.q1;

import backend.handson.q2.HealthInsurancePlan;

public class User {
    private long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private boolean insured;
    private HealthInsurancePlan insurancePlan;
    private int age;
    private boolean smoking;

    public

    int

    getAge()

    {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw

                    new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }


    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }


    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public boolean isInsured() {
        return insured;
    }
    public void setInsured(boolean insured) {
        this.insured = insured;
    }
    public HealthInsurancePlan getInsurancPlan(){
        return insurancePlan;
    }
    /**
     * Sets the patient's health insurance plan.
     *
     * @param insurancPlan The new {@link HealthInsurancePlan} to assign to the patient.
     */
    public void setInsurancPlan(HealthInsurancePlan insurancPlan){
        this.insurancePlan =insurancPlan;
    }


}
