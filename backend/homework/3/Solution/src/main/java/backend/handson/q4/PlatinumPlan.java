package backend.handson.q4;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        super.setCoverage(0.9);
    }

    @Override
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.08* salary + getOfferdBy().computeMonthlyPremium(this, age, userSmoke);
    }
}
