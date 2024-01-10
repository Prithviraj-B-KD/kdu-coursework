package backend.handson.q4;

public abstract class HealthInsurancePlan {
    private double coverage;

    private InsuranceBrand offeredBy;

    public InsuranceBrand getOfferdBy(){
        return offeredBy;
    }
    public void setOfferedBy(InsuranceBrand offeredBy) {
        this.offeredBy = offeredBy;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    public abstract double computeMonthlyPremium(double salary, int age, boolean userSmoke);
}