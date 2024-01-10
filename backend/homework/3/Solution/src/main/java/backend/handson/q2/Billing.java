package backend.handson.q2;

import backend.handson.LogBack;
import backend.handson.q1.Patient;

public class Billing {
    private Billing() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Computes the payment amounts for a patient based on their insurance plan and any applicable discounts.
     *
     * @param patient The {@link Patient} whose payment amounts are being calculated.
     * @param amount The total bill amount before applying insurance or discounts.
     * @return A {@code double[]} where the first element is the insurance payment amount and the second element is the patient's payment amount.
     */
    public static double[] computePaymentAmount(Patient patient, double amount) {


        double[] payments = new double[2];

        HealthInsurancePlan patientInsurancePlan = patient.getInsurancPlan();
        if (patientInsurancePlan != null){
            double insuranceCompanyPayment = amount * patientInsurancePlan.getCoverage() ;
            double patientPayment = getPatientPayment(amount, insuranceCompanyPayment, patientInsurancePlan);

            payments[0] = patientPayment;
            payments[1] = insuranceCompanyPayment;
        } else {
            payments[0] = 0;
            if(amount > 20) {
                payments[1] = amount - 20;
            } else {
                payments[1] = 0.0;
            }
        }
        return payments;
    }
    private static double getPatientPayment(double amount, double insuranceCompanyPayment, HealthInsurancePlan patientInsurancePlan) {
        double patientPayment = amount - insuranceCompanyPayment;
        //patientCompanyPayment > 50 to handle edge case if patientCompanyPayment is less than 50
        if (patientInsurancePlan instanceof PlatinumPlan && patientPayment > 50){
            patientPayment = patientPayment - 50;

        } else if (patientInsurancePlan instanceof GoldPlan && patientPayment > 40) {
            patientPayment = patientPayment - 40;
        }else if (patientInsurancePlan instanceof SilverPlan && patientPayment > 30) {
            patientPayment = patientPayment - 30;
        } else if (patientInsurancePlan instanceof BronzePlan && patientPayment > 25) {
            patientPayment = patientPayment -25;
        } else {
                LogBack.outputlogger("Invalid insurance plan type","ERROR");
                throw new IllegalArgumentException("Invalid insurance plan type");


        }

        return patientPayment;
    }
}
