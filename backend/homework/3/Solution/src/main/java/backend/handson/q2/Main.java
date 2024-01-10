package backend.handson.q2;

import backend.handson.LogBack;
import backend.handson.q1.Doctor;
import backend.handson.q1.Patient;

public class Main {
    public static void main(String[] args){
        double billedAmount = 10000.0;
        Patient patient = new Patient();
        LogBack.outputlogger("Question 1:","INFO");
        patient.setFirstName("arun");
        patient.setLastName("kumar");
        String formattedString = String.format("Patient: %s %s", patient.getFirstName(),patient.getLastName());
        LogBack.outputlogger(formattedString,"INFO");
        HealthInsurancePlan platinumPlan = new PlatinumPlan();
        patient.setInsurancPlan(platinumPlan);
        LogBack.outputlogger("Question 2:","INFO");
        double[] paymentList = Billing.computePaymentAmount(patient, billedAmount);
        LogBack.outputlogger(Double.toString(paymentList[0]),"INFO");
        LogBack.outputlogger(Double.toString(paymentList[1]),"INFO");
        LogBack.outputlogger("Question 3:","INFO");
        Doctor doctor = new Doctor();
        doctor.setSalary(10000.0);
        LogBack.outputlogger(Double.toString(doctor.getSalary()),"INFO");
        double monthlyPremium = platinumPlan.computeMonthlyPremium(doctor.getSalary());
        LogBack.outputlogger(Double.toString(monthlyPremium),"INFO");
    }
}
