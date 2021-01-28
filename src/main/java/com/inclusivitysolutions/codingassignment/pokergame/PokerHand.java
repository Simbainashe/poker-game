package com.inclusivitysolutions.codingassignment.pokergame;

import java.util.List;
import java.util.Map;

/**
 * @author fact
 * 28/1/2021
 */
public abstract class PokerHand {
    private final String name;
    private final int rank;

    protected PokerHand(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public abstract boolean matches(Map<Card.Rank, List<Card.Suit>> valueSuitMap);

    @Override
    public String toString() {
        return "PokerHand{" +
                "name='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
