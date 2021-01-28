package com.inclusivitysolutions.codingassignment.pokergame.cardreader;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author fact
 * 28/1/2021
 */
class CardConverterTest {
    private static final String USER_INPUT = "AS, 10C, 10H, 9D, 8C, *, 2H, 3S, 4D, 5H, 6C, 7S, KD, QC, JS";

    private static Stream<Arguments> cardsProvider() {
        return Stream.of(
                Arguments.of(Card.of(Card.Rank.ACE, Card.Suit.SPADES)),
                Arguments.of(Card.of(Card.Rank.TEN, Card.Suit.CLUBS)),
                Arguments.of(Card.of(Card.Rank.TEN, Card.Suit.HEARTS)),
                Arguments.of(Card.of(Card.Rank.NINE, Card.Suit.DIAMONDS)),
                Arguments.of(Card.of(Card.Rank.EIGHT, Card.Suit.CLUBS)),
                Arguments.of(Card.of(Card.Rank.JOKER, null)),
                Arguments.of(Card.of(Card.Rank.TWO, Card.Suit.HEARTS)),
                Arguments.of(Card.of(Card.Rank.THREE, Card.Suit.SPADES)),
                Arguments.of(Card.of(Card.Rank.FOUR, Card.Suit.DIAMONDS)),
                Arguments.of(Card.of(Card.Rank.FIVE, Card.Suit.HEARTS)),
                Arguments.of(Card.of(Card.Rank.SIX, Card.Suit.CLUBS)),
                Arguments.of(Card.of(Card.Rank.SEVEN, Card.Suit.SPADES)),
                Arguments.of(Card.of(Card.Rank.KING, Card.Suit.DIAMONDS)),
                Arguments.of(Card.of(Card.Rank.QUEEN, Card.Suit.CLUBS)),
                Arguments.of(Card.of(Card.Rank.JACK, Card.Suit.SPADES))
        );
    }

    @ParameterizedTest
    @MethodSource("cardsProvider")
    void convertToCards(Card card) {
        Set<Card> cards = CardConverter.convertToCards(USER_INPUT);
        assertThat(cards).contains(card);
    }

    @Test
    void convertToCardsThrowsWhenInputIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> CardConverter.convertToCards("AS, 10C, 10H, 9D, 8C, #G"));
    }
}