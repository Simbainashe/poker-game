package com.inclusivitysolutions.codingassignment.pokergame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class PokerGameApplication implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(PokerGameApplication.class);
    private final CardsReader cardsReader;
    private final BestPokerHandIdentifier bestPokerHandIdentifier;

    PokerGameApplication(CardsReader cardsReader, BestPokerHandIdentifier bestPokerHandIdentifier) {
        this.cardsReader = cardsReader;
        this.bestPokerHandIdentifier = bestPokerHandIdentifier;
    }

    public static void main(String[] args) {
        SpringApplication.run(PokerGameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Paying poker game");
        Set<Card> cards = cardsReader.readCardSelection();
        System.out.println(bestPokerHandIdentifier.determineBestHand(cards));
    }
}
