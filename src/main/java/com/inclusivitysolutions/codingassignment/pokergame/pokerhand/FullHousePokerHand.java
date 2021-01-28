package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author fact
 * 28/1/2021
 */
class FullHousePokerHand extends PokerHand {
    static final FullHousePokerHand INSTANCE = new FullHousePokerHand();

    private FullHousePokerHand() {
        super("Full House", 2);
    }

    @Override
    public boolean matches(Map<Card.Rank, List<Card.Suit>> rankSuitMap) {
        Objects.requireNonNull(rankSuitMap, "rankSuitMap cannot be null");
        boolean hasThreeOfAKind = false, hasATwoOfAKind = false;

        for (List<Card.Suit> suitCards : rankSuitMap.values()) {
            if (suitCards.size() == 3) {
                hasThreeOfAKind = true;
            } else if (suitCards.size() == 2) {
                hasATwoOfAKind = true;
            }
        }

        return hasThreeOfAKind && hasATwoOfAKind;
    }
}