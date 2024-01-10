package backend.handson.q2;

import backend.handson.LogBack;
import backend.handson.q1.Doctor;
import backend.handson.q1.Patient;

public class Main {
    public static void main(String[] args){
        double billedAmount = 10000.0;
        Patient patient = new Patient();
        LogBack.outputLogger("Question 1:","INFO");
        patient.setFirstName("arun");
        patient.setLastName("kumar");
        String formattedString = String.format("Patient: %s %s", patient.getFirstName(),patient.getLastName());
        LogBack.outputLogger(formattedString,"INFO");
        HealthInsurancePlan platinumPlan = new PlatinumPlan();
        patient.setInsurancPlan(platinumPlan);
        LogBack.outputLogger("Question 2:","INFO");
        double[] paymentList = Billing.computePaymentAmount(patient, billedAmount);
        LogBack.outputLogger(Double.toString(paymentList[0]),"INFO");
        LogBack.outputLogger(Double.toString(paymentList[1]),"INFO");
        LogBack.outputLogger("Question 3:","INFO");
        Doctor doctor = new Doctor();
        doctor.setSalary(10000.0);
        LogBack.outputLogger(Double.toString(doctor.getSalary()),"INFO");
        double monthlyPremium = platinumPlan.computeMonthlyPremium(doctor.getSalary());
        LogBack.outputLogger(Double.toString(monthlyPremium),"INFO");
    }
}
