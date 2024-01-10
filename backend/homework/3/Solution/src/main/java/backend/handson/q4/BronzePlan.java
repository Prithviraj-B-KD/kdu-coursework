package backend.handson.q4;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super.setCoverage(0.6);
    }

    @Override
    public double computeMonthlyPremium(double salary, int age, boolean userSmoke) {
        return 0.05 * salary + getOfferdBy().computeMonthlyPremium(this, age, userSmoke);
    }
}