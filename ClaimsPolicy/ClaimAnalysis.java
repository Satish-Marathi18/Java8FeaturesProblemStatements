package ClaimsPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ClaimAnalysis {
    public static List<Claim> filter(List<Claim> claims) {
        return claims.stream()
            .filter(claim -> claim.getStatus().equals("Approved") && claim.getClaimAmount() > 5000.0).toList();
    }

    public static Map<Integer, List<Claim>> groupClaimsByPolicyNumber(List<Claim> claims){
        return claims.stream()
            .collect(Collectors.groupingBy(Claim::getPolicyNumber));
    }

    public static List<PolicyClaimsSummary> aggregateClaims(List<Claim> claims) {
        return claims.stream()
        .collect(Collectors.groupingBy(Claim::getPolicyNumber,
                Collectors.collectingAndThen(Collectors.toList(), claimList -> {
                    double total = claimList.stream().mapToDouble(Claim::getClaimAmount).sum();
                    double average = claimList.stream().mapToDouble(Claim::getClaimAmount).average().orElse(0);
                    return new PolicyClaimsSummary(claimList.get(0).getPolicyNumber(), total, average);
                })))
        .values().stream()
        .collect(Collectors.toList());
    }

    public static List<PolicyClaimsSummary> topPolicies(List<PolicyClaimsSummary> aggregate){
        return aggregate.stream().sorted((p1,p2) -> Double.compare(p2.getTotalClaimAmount(), p1.getTotalClaimAmount())).limit(2).toList();
    }

    public static void main(String[] args) {
        List<Claim> claims = new ArrayList<>();
        claims.add(new Claim(101, 123456, 1500.50, "2023-06-15", "Approved"));
        claims.add(new Claim(102, 123457, 7500.00, "2023-07-01", "Pending"));
        claims.add(new Claim(103, 123458, 3200.75, "2023-07-20", "Rejected"));
        claims.add(new Claim(104, 123456, 6800.00, "2023-08-05", "Approved"));
        claims.add(new Claim(105, 123457, 2500.00, "2023-08-18", "Pending"));
        
        System.out.println("Claims which is in Approved status and claim amount more than 5000:");
        List<Claim> filteredClaims = filter(claims);
        for(Claim claim : filteredClaims) {
            System.out.println(claim);
        }
        System.out.println();
        System.out.println("Group of claims based on policy number:");
        Map<Integer, List<Claim>> groups = groupClaimsByPolicyNumber(claims);
        Set<Integer> policyNumbers = groups.keySet();
        for(Integer policyNumber : policyNumbers) {
            System.out.println(policyNumber+" : "+groups.get(policyNumber));
        }

        System.out.println();
        System.out.println("For each policy total claimAmount and the average claimAmount: ");
        List<PolicyClaimsSummary> aggregate = aggregateClaims(claims);
        for(PolicyClaimsSummary policy : aggregate) {
            System.out.println(policy);
        }

        System.out.println();
        System.out.println("Top 2 policies with the highest total claim amounts:");
        List<PolicyClaimsSummary> topPolicies = topPolicies(aggregate);
        for(PolicyClaimsSummary policy : topPolicies) {
            System.out.println(policy);
        }
    }
}
