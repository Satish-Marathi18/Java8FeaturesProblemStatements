package ClaimsPolicy;

public class PolicyClaimsSummary {
    private int policyNumber;
    private double totalClaimAmount;
    private double averageClaimAmount;

    public PolicyClaimsSummary(int policyNumber, double totalClaimAmount, double averageClaimAmount) {
        this.policyNumber = policyNumber;
        this.totalClaimAmount = totalClaimAmount;
        this.averageClaimAmount = averageClaimAmount;
    }
    

    public int getPolicyNumber() {
        return policyNumber;
    }


    public double getTotalClaimAmount() {
        return totalClaimAmount;
    }


    public double getAverageClaimAmount() {
        return averageClaimAmount;
    }


    @Override
    public String toString() {
        return "PolicyClaimsSummary [policyNumber=" + policyNumber + ", totalClaimAmount=" + totalClaimAmount
                + ", averageClaimAmount=" + averageClaimAmount + "]";
    }

    
}
