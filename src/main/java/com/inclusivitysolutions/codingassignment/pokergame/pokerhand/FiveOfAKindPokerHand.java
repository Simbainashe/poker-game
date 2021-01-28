package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author fact
 * 28/1/2021
 */
class FiveOfAKindPokerHand extends PokerHand {
    static final FiveOfAKindPokerHand INSTANCE = new FiveOfAKindPokerHand();

    private FiveOfAKindPokerHand() {
        super("Five Of A Kind", 0);
    }

    @Override
    public boolean matches(Map<Card.Rank, List<Card.Suit>> rankSuitMap) {
        Objects.requireNonNull(rankSuitMap, "rankSuitMap cannot be null");
        boolean hasFourOfAKind = false, hasAJoker = false;
        if (rankSuitMap.containsKey(Card.Rank.JOKER)) {
            hasAJoker = true;
        }
        for (List<Card.Suit> suitCards : rankSuitMap.values()) {
            if (suitCards.size() == 4) {
                hasFourOfAKind = true;
                break;
            }
        }

        return hasFourOfAKind && hasAJoker;
    }
}
