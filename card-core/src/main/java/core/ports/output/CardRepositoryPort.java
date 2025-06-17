package core.ports.output;

import java.util.List;

import core.domain.model.Card;

public interface CardRepositoryPort {

	List<Card> findAllCards();
	
	Card saveCard(String cardName);

}
