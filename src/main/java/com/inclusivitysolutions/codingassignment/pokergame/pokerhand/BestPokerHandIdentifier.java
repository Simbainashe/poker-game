package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.Set;

/**
 * @author fact
 * 28/1/2021
 */
public interface BestPokerHandIdentifier {
    PokerHand determineBestHand(Set<Card> cards);
}
