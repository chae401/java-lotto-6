package lotto.model;

import java.util.List;

public class Result {
    private static final String UNIT = "개\n";
    private final List<Ranking> rankings;
    private final double totalProfit;

    public Result(List<Ranking> rankings, int payment) {
        this.rankings = rankings;
        this.totalProfit = calculateTotalProfit(payment);
    }

    private double calculateTotalProfit(int payment) {
        double profit = 0;
        for (Ranking ranking : rankings) {
            profit += ranking.getProfit();
        }
        System.out.println("profit : " + profit);
        System.out.println("payment : " + payment);
        return (profit / payment) * 100;
    }

    public String getNumOfRanks() {
        StringBuilder sb = new StringBuilder();
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.FAIL) {
                continue;
            }
            int cnt = (int) rankings.stream().filter(r -> r == ranking).count();
            sb.append(ranking.getCondition()).append(cnt).append(UNIT);
        }
        return sb.toString();
    }

    public double getTotalProfit() {
        return totalProfit;
    }
}
