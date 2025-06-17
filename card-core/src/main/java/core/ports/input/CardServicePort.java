package core.ports.input;

import java.util.List;

import core.domain.model.Card;

public interface CardServicePort {

	Card createCard(String cardName);

	List<Card> getAllCards();

}
