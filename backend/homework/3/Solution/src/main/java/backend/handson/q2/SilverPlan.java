package backend.handson.q2;

public class SilverPlan extends HealthInsurancePlan {

    public SilverPlan() {
        super.setCoverage(0.7);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.06;
    }
}
