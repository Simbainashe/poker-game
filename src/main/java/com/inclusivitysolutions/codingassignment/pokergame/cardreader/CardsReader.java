package com.inclusivitysolutions.codingassignment.pokergame.cardreader;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.Set;

/**
 * @author fact
 * 28/1/2021
 */
public interface CardsReader {
    Set<Card> readCardSelection();
}
