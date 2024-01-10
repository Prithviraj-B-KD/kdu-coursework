package backend.handson.q4;

import backend.handson.LogBack;
import backend.handson.q1.Staff;


public class Main {
    public static void main(String[] args){
        LogBack.outputLogger("Question 4:","INFO");
    Staff surgeon = new Staff();
    surgeon.setSalary(5000);
    surgeon.setAge(56);
    surgeon.setSmoking(true);
    InsuranceBrand insuranceBrand = new BlueCrossBlueShield();
    HealthInsurancePlan insurancePlan = new PlatinumPlan();
    insurancePlan.setOfferedBy(insuranceBrand);
    double monthlyPremium= insurancePlan.computeMonthlyPremium(surgeon.getSalary(), surgeon.getAge(), surgeon.isSmoking());
    String formattedString = String.format("Monthly Salary: %.2f", surgeon.getSalary());
    LogBack.outputLogger(formattedString,"INFO");
    formattedString = String.format("Surgeon Age: %d", surgeon.getAge());
    LogBack.outputLogger(formattedString,"INFO");
    formattedString = String.format("Surgeon Age: %s", surgeon.isSmoking() ? "True": "False");
    LogBack.outputLogger(formattedString,"INFO");
    formattedString = String.format("Monthly Premium: %.2f", monthlyPremium);
    LogBack.outputLogger(formattedString,"INFO");

    }
}
