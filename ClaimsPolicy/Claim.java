package ClaimsPolicy;

public class Claim {
    private int claimId;
    private int policyNumber;
    private double claimAmount;
    private String claimDate;
    private String status;
    public Claim(int claimId, int policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
    public int getClaimId() {
        return claimId;
    }
    public int getPolicyNumber() {
        return policyNumber;
    }
    public double getClaimAmount() {
        return claimAmount;
    }
    public String getClaimDate() {
        return claimDate;
    }
    public String getStatus() {
        return status;
    }
    @Override
    public String toString() {
        return "Claim [claimId=" + claimId + ", policyNumber=" + policyNumber + ", claimAmount=" + claimAmount
                + ", claimDate=" + claimDate + ", status=" + status + "]";
    }

}
