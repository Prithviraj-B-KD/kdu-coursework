package backend.handson.q4;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan() {
        super.setCoverage(0.8);
    }

    public double computeMonthlyPremium(double salary, int age, boolean userSmoke) {
        return 0.07 * salary + getOfferdBy().computeMonthlyPremium(this, age, userSmoke);
    }
}