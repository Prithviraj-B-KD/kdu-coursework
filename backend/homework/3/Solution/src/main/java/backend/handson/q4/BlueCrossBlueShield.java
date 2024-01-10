package backend.handson.q4;

import backend.handson.LogBack;

public class BlueCrossBlueShield implements InsuranceBrand{
    public static double[] platinum(int age,boolean smoking){
        double[] arr = new double[2];
        if(age > 55){
            arr[0] = 200;
        }
        if(smoking){
            arr[1] = 100;
        }
        return arr;
    }public static double[] gold(int age,boolean smoking){
        double[] arr = new double[2];
        if(age > 55){
            arr[0] = 150;
        }
        if(smoking){
            arr[1] = 90;
        }
        return arr;
    }
    public static double[] silver(int age,boolean smoking){
        double[] arr = new double[2];
        if(age > 55){
            arr[0] = 100;
        }
        if(smoking){
            arr[1] = 80;
        }
        return arr;
    }
    public static double[] bronze(int age,boolean smoking){
        double[] arr = new double[2];
        if(age > 55){
            arr[0] = 50;
        }
        if(smoking){
            arr[1] = 70;
        }
        return arr;
    }

    /**
     Calculates the monthly premium for a Blue Cross Blue Shield health insurance plan.
     @param insurancePlan The type of health insurance plan.
     @param age The age of the insured individual.
     @param userSmoke True if the insured individual smokes, false otherwise.
     @return The calculated monthly premium amount.
     @throws IllegalArgumentException if the provided insurancePlan is not a valid plan type.
     */
    public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean userSmoke) {
        double[] answer = new double[2];
        if (insurancePlan instanceof PlatinumPlan) {
          answer = platinum(age,userSmoke)
        } else if (insurancePlan instanceof GoldPlan) {
            answer = gold(age,userSmoke)
        } else if (insurancePlan instanceof SilverPlan) {
            answer = silver(age,userSmoke)
        } else if (insurancePlan instanceof BronzePlan) {
            answer = bronze(age,userSmoke)
        } else {
            LogBack.outputlogger("Invalid insurance plan type","ERROR");
            throw new IllegalArgumentException("Invalid insurance plan type");
        }
        return answer[0]+answer[1];
    }
}