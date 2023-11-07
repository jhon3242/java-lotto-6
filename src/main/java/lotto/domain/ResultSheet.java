package lotto.domain;

import java.util.Map;

public record ResultSheet(Map<Rank, Integer> sheet) {
    private static final int PERCENTAGE = 100;

    public int findCountByRank(Rank rank) {
        return sheet.get(rank);
    }

    public double getTotalProfit() {
        int purchaseCost = LottoOption.LOTTO_PRICE * getCount();
        double totalPrize = sheet.keySet()
                .stream()
                .mapToDouble(rank -> rank.getPrize() * sheet.get(rank))
                .sum();
        return (totalPrize / purchaseCost) * PERCENTAGE;
    }

    public int getCount() {
        return sheet.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
