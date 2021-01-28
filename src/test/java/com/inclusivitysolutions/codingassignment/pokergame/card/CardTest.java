package com.inclusivitysolutions.codingassignment.pokergame.card;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fact
 * 28/1/2021
 */
class CardTest {

    @Test
    void creatingCardThrowsWhenRankIsNull() {
        assertThrows(NullPointerException.class, () -> Card.of(null, Card.Suit.CLUBS));
    }

    @Test
    void creatingCardThrowsWhenNonJokerSuitIsNull() {
        assertThrows(IllegalStateException.class, () -> Card.of(Card.Rank.ACE, null));
    }
}