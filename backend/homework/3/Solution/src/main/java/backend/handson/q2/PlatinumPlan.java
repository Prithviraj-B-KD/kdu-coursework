package backend.handson.q2;

public class PlatinumPlan extends HealthInsurancePlan {

    public PlatinumPlan() {
        super.setCoverage(0.9);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.08;
    }
}
