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
    public final CardsReader cardsReader;

    public PokerGameApplication(CardsReader cardsReader) {
        this.cardsReader = cardsReader;
    }

    public static void main(String[] args) {
        SpringApplication.run(PokerGameApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Paying poker game");
        Set<Card> cards = cardsReader.readCardSelection();
    }
}
