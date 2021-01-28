package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author fact
 * 28/1/2021
 */
class FlushPokerHand extends PokerHand {
    static final FlushPokerHand INSTANCE = new FlushPokerHand();

    private FlushPokerHand() {
        super("Flush", 2);
    }

    @Override
    public boolean matches(Map<Card.Rank, List<Card.Suit>> rankSuitMap) {
        Objects.requireNonNull(rankSuitMap, "rankSuitMap cannot be null");
        for (List<Card.Suit> suitCards : rankSuitMap.values()) {
            if (suitCards.size() != 1) {
                return false;
            }
        }

        return true;
    }
}