package backend.handson.q2;

public class BronzePlan extends HealthInsurancePlan {

    public BronzePlan() {
        super.setCoverage(0.6);
    }

    @Override
    public double computeMonthlyPremium(double salary) {
        return salary*0.05;
    }
}