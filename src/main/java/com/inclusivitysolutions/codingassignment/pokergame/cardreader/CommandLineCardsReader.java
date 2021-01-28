package com.inclusivitysolutions.codingassignment.pokergame.cardreader;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Scanner;
import java.util.Set;

/**
 * @author fact
 * 28/1/2021
 */
@Service
class CommandLineCardsReader implements CardsReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandLineCardsReader.class);
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public Set<Card> readCardSelection() {
        LOGGER.info("Reading user's card selection <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        try {
            return readCardSelectionFromCommandLineInput();
        } catch (IllegalArgumentException e) {
            return readCardSelectionFromCommandLineInput();
        }
    }

    private Set<Card> readCardSelectionFromCommandLineInput() {
        System.out.print("Enter card selection: ");
        String playerInput = SCANNER.nextLine();
        return CardConverter.convertToCards(playerInput);
    }

}
