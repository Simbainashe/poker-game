package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author fact
 * 28/1/2021
 */
class TwoPairPokerHand extends PokerHand {
    static final TwoPairPokerHand INSTANCE = new TwoPairPokerHand();

    private TwoPairPokerHand() {
        super("Two Pair", 7);
    }

    @Override
    public boolean matches(Map<Card.Rank, List<Card.Suit>> rankSuitMap) {
        Objects.requireNonNull(rankSuitMap, "rankSuitMap cannot be null");
        boolean hasAKicker = false;
        if (!rankSuitMap.containsKey(Card.Rank.JOKER)) {
            hasAKicker = true;
        }
        int twoOfAKindCount = 0;
        for (List<Card.Suit> suitCards : rankSuitMap.values()) {
            if (suitCards.size() == 2) {
                twoOfAKindCount++;
            }
        }

        return hasAKicker && twoOfAKindCount == 2;
    }
}