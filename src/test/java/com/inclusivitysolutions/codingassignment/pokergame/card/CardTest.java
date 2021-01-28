package com.inclusivitysolutions.codingassignment.pokergame.card;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fact
 * 28/1/2021
 */
class CardTest {
    private static final Card.Rank RANK= Card.Rank.ACE;
    private static final Card.Suit SUIT= Card.Suit.CLUBS;

    @Test
    void creatingCardThrowsWhenRankIsNull() {
        assertThrows(NullPointerException.class, () -> Card.of(null, Card.Suit.CLUBS));
    }

    @Test
    void creatingCardThrowsWhenNonJokerSuitIsNull() {
        assertThrows(IllegalStateException.class, () -> Card.of(Card.Rank.ACE, null));
    }

    @Test
    void cardRankIsCorrectlyInitialised() {
        Card card= Card.of(RANK,SUIT) ;
        assertThat(RANK).isEqualTo(card.getRank());
    }

    @Test
    void cardSuitIsCorrectlyInitialised() {
        Card card= Card.of(RANK,SUIT) ;
        assertThat(SUIT).isEqualTo(card.getSuit());
    }
}