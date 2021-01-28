package com.inclusivitysolutions.codingassignment.pokergame.cardreader;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fact
 * 28/1/2021
 */
final class CardConverter {
    private CardConverter() {
    }

    /**
     *
     * @param stringCardDetails
     * @return Set<Card>
     * @throws IllegalArgumentException
     */
    public static Set<Card> convertToCards(String stringCardDetails) {
        String[] cardDetails = stringCardDetails.split(",");
        return Arrays.stream(cardDetails).map(CardConverter::convertToCard).collect(Collectors.toSet());
    }

    private static Card convertToCard(String stringCardDetails) {
        stringCardDetails = stringCardDetails.trim();
        return Card.of(convertToCardRank(stringCardDetails), convertToCardSuit(stringCardDetails));
    }

    private static Card.Rank convertToCardRank(String stringCardDetails) {
        char firstCharacter = stringCardDetails.charAt(0);
        switch (firstCharacter) {
            case '*':
                return Card.Rank.JOKER;
            case 'J':
                return Card.Rank.JACK;
            case 'A':
                return Card.Rank.ACE;
            case 'Q':
                return Card.Rank.QUEEN;
            case 'K':
                return Card.Rank.KING;
            case '1':
                return Card.Rank.TEN;
            case '2':
                return Card.Rank.TWO;
            case '3':
                return Card.Rank.THREE;
            case '4':
                return Card.Rank.FOUR;
            case '5':
                return Card.Rank.FIVE;
            case '6':
                return Card.Rank.SIX;
            case '7':
                return Card.Rank.SEVEN;
            case '8':
                return Card.Rank.EIGHT;
            case '9':
                return Card.Rank.NINE;
            default:
                throw new IllegalArgumentException("Invalid digit symbol " + firstCharacter);
        }
    }

    private static Card.Suit convertToCardSuit(String stringCardDetails) {
        String stringCardDetailsExcludingFirstCharacter = stringCardDetails.substring(1);
        if (stringCardDetailsExcludingFirstCharacter.contains("S")) {
            return Card.Suit.SPADES;
        }

        if (stringCardDetailsExcludingFirstCharacter.contains("C")) {
            return Card.Suit.CLUBS;
        }

        if (stringCardDetailsExcludingFirstCharacter.contains("D")) {
            return Card.Suit.DIAMONDS;
        }
        if (stringCardDetailsExcludingFirstCharacter.contains("H")) {
            return Card.Suit.HEARTS;
        }
        return null;
    }
}
