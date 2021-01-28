package com.inclusivitysolutions.codingassignment.pokergame.pokerhand;

import com.inclusivitysolutions.codingassignment.pokergame.card.Card;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author fact
 * 28/1/2021
 */
@Service
class BestPokerHandIdentifierImpl implements BestPokerHandIdentifier {
    private static final Logger LOGGER = LoggerFactory.getLogger(BestPokerHandIdentifierImpl.class);
    private static final List<PokerHand> POKER_HANDS = Arrays.asList(FiveOfAKindPokerHand.INSTANCE,
            FourOfAKindPokerHand.INSTANCE, StraightFlushPokerHand.INSTANCE,FullHousePokerHand.INSTANCE);

    @Override
    public Optional<PokerHand> determineBestHand(Set<Card> cards) {
        LOGGER.info("Determining best poker from card collection: {}", cards);
        Map<Card.Rank, List<Card.Suit>> rankSuitMap = cards.stream()
                .collect(Collectors.groupingBy(Card::getRank, Collectors.mapping(Card::getSuit, Collectors.toList())));
        List<PokerHand> sortedPossiblePokerHands = POKER_HANDS.stream().filter(pokerHand -> pokerHand.matches(rankSuitMap))
                .sorted(Comparator.comparingInt(PokerHand::getRank)).collect(Collectors.toList());
        if (sortedPossiblePokerHands.size() == 0) {
            return Optional.empty();
        }
        return Optional.of(sortedPossiblePokerHands.get(0));
    }
}
