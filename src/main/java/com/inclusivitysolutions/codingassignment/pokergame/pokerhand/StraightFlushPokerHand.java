package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author fact
 * 28/1/2021
 */
class StraightFlushPokerHand extends PokerHand {
    static final StraightFlushPokerHand INSTANCE = new StraightFlushPokerHand();

    private StraightFlushPokerHand() {
        super("Straight Flush", 1);
    }

    @Override
    public boolean matches(Map<Card.Rank, List<Card.Suit>> rankSuitMap) {
        Objects.requireNonNull(rankSuitMap, "rankSuitMap cannot be null");
        List<Card.Rank> sortedKeys = rankSuitMap.keySet().stream()
                .sorted(Comparator.comparingInt(Card.Rank::getOrderOfRanking)).collect(Collectors.toList());
        int commonDifferenceSum = 0;
        for (int i = 0; i < sortedKeys.size() - 1; i++) {
            commonDifferenceSum += (sortedKeys.get(i+1).getOrderOfRanking() - sortedKeys.get(i).getOrderOfRanking());
        }
        if (commonDifferenceSum == 4) {
            return true;
        }
        return false;
    }
}
