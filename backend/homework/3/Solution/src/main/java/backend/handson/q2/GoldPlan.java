package backend.handson.q2;

public class GoldPlan extends HealthInsurancePlan {

    public GoldPlan() {
        super.setCoverage(0.8);
    }

    public double computeMonthlyPremium(double salary) {
        return salary*0.07;
    }
}
