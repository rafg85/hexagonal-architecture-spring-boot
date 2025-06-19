package infra.adapters.outbound;

import java.util.List;

import org.springframework.stereotype.Component;

import core.domain.model.Card;
import core.ports.outbound.CardRepositoryPort;
import jakarta.transaction.Transactional;

@Component
public class CardJpaRepositoryAdapter implements CardRepositoryPort {

	private CardJpaRepository cardJpaRepository;

	public CardJpaRepositoryAdapter(CardJpaRepository cardJpaRepository) {
		this.cardJpaRepository = cardJpaRepository;
	}

	@Override
	public List<Card> findAllCards() {
		return cardJpaRepository.findAll().stream().map(entity -> new Card(entity.getCardId(), entity.getCardName()))
				.toList();
	}

	@Override
	@Transactional
	public Card saveCard(String cardName) {
		CardEntity entity = cardJpaRepository.save(new CardEntity(null, cardName));
		return new Card(entity.getCardId(), entity.getCardName());
	}

}
