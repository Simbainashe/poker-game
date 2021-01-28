package com.inclusivitysolutions.codingassignment.pokergame;

import java.util.Set;

/**
 * @author fact
 * 28/1/2021
 */
public interface BestPokerHandIdentifier {
    PokerHand determineBestHand(Set<Card> cards);
}
