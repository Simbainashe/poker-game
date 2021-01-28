package com.inclusivitysolutions.codingassignment.pokergame.cardreader;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author fact
 * 28/1/2021
 */
@Service
class CardsReaderImpl implements CardsReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CardsReaderImpl.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public Set<Card> readCardSelection() {
        LOGGER.info("Reading user's card selection <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        String playerInput = SCANNER.nextLine();
        String[] cardDetails = playerInput.split(",");
        return Arrays.stream(cardDetails).map(this::convertToCard).collect(Collectors.toSet());
    }

    private Card convertToCard(String stringCardDetails) {
        return Card.of(convertToCardRank(stringCardDetails), convertToCardSuit(stringCardDetails));
    }

    private Card.Rank convertToCardRank(String stringCardDetails) {
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

    private Card.Suit convertToCardSuit(String stringCardDetails) {
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
