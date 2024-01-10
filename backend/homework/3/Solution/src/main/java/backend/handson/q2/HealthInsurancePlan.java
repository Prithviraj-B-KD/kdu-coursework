package backend.handson.q2;

public abstract class HealthInsurancePlan {
    private double coverage;

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public abstract double computeMonthlyPremium(double salary);
}
