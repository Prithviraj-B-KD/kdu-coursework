package backend.handson.q4;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan() {
        super.setCoverage(0.7);
    }

    @Override
    public double computeMonthlyPremium(double salary,int age,boolean userSmoke){
        return 0.06*salary+ getOfferdBy().computeMonthlyPremium(this, age, userSmoke);
    }
}
