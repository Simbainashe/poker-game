package com.inclusivitysolutions.codingassignment.pokergame.card;

import java.util.Objects;

/**
 * @author fact
 * 28/1/2021
 */
public class Card {
    private final Rank rank;
    private final Suit suit;

    private Card(Rank rank, Suit suit) {
        Objects.requireNonNull(rank, "rank cannot be null");
        if (Objects.isNull(suit) && !rank.equals(Rank.JOKER)) {
            throw new IllegalStateException("Only joker can have null suit");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public static Card of(Rank rank, Suit suit) {
        return new Card(rank, suit);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank=" + rank +
                ", suit=" + suit +
                '}';
    }

    public enum Rank {
        ACE(0),
        KING(1),
        QUEEN(2),
        JACK(3),
        TEN(4),
        NINE(5),
        EIGHT(6),
        SEVEN(7),
        SIX(8),
        FIVE(9),
        FOUR(10),
        THREE(11),
        TWO(12),
        JOKER(-78);
        private final int orderOfRanking;

        Rank(int orderOfRanking) {
            this.orderOfRanking = orderOfRanking;
        }

        public int getOrderOfRanking() {
            return orderOfRanking;
        }
    }

    public enum Suit {
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES
    }
}