package backend.handson.q2;

import backend.handson.LogBack;
import backend.handson.q1.Doctor;
import backend.handson.q1.Patient;

public class Main {
    public static void main(String[] args){
        double billedAmount = 10000.0;
        Patient patient = new Patient();
        LogBack.Outputlogger("Question 1:","INFO");
        patient.setFirstName("arun");
        patient.setLastName("kumar");
        String formattedString = String.format("Patient: %s %s", patient.getFirstName(),patient.getLastName());
        LogBack.Outputlogger(formattedString,"INFO");
        HealthInsurancePlan platinumPlan = new PlatinumPlan();
        patient.setInsurancPlan(platinumPlan);
        LogBack.Outputlogger("Question 2:","INFO");
        double[] paymentList = Billing.computePaymentAmount(patient, billedAmount);
        LogBack.Outputlogger(Double.toString(paymentList[0]),"INFO");
        LogBack.Outputlogger(Double.toString(paymentList[1]),"INFO");
        LogBack.Outputlogger("Question 3:","INFO");
        Doctor doctor = new Doctor();
        doctor.setSalary(10000.0);
        LogBack.Outputlogger(Double.toString(doctor.getSalary()),"INFO");
        double monthlyPremium = platinumPlan.computeMonthlyPremium(doctor.getSalary());
        LogBack.Outputlogger(Double.toString(monthlyPremium),"INFO");
    }
}
