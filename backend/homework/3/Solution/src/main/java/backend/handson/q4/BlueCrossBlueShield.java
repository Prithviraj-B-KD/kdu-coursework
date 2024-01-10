package backend.handson.q4;

import backend.handson.LogBack;

public class BlueCrossBlueShield implements InsuranceBrand{

    /**
     Calculates the monthly premium for a Blue Cross Blue Shield health insurance plan.
     @param insurancePlan The type of health insurance plan.
     @param age           The age of the insured individual.
     @param userSmoke     True if the insured individual smokes, false otherwise.
     @return The calculated monthly premium amount.
     @throws IllegalArgumentException if the provided insurancePlan is not a valid plan type.
     */
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean userSmoke) {
        double answer = 0.0;
        if (insurancePlan instanceof PlatinumPlan) {
            if (age > 55) {
                answer += 200.0;
            }
            if (userSmoke) {
                answer += 100.0;
            }
        } else if (insurancePlan instanceof GoldPlan) {
            if (age > 55) {
                answer += 150.0;
            }
            if (userSmoke) {
                answer += 90.0;
            }
        } else if (insurancePlan instanceof SilverPlan) {
            if (age > 55) {
                answer += 100.0;
            }
            if (userSmoke) {
                answer += 80.0;
            }
        } else if (insurancePlan instanceof BronzePlan) {
            if (age > 55) {
                answer += 50.0;
            }
            if (userSmoke) {
                answer += 70.0;
            }
        } else {
            LogBack.Outputlogger("Invalid insurance plan type","ERROR");
            throw new IllegalArgumentException("Invalid insurance plan type");
        }
        return answer;
    }
}