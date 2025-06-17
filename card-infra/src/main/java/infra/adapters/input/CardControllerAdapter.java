package infra.adapters.input;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.domain.model.Card;
import core.ports.input.CardServicePort;

@RestController
@RequestMapping("cards")
public class CardControllerAdapter {

	private CardServicePort cardServicePort;

	public CardControllerAdapter(CardServicePort cardServicePort) {
		this.cardServicePort = cardServicePort;
	}

	@PostMapping()
	public CardResponseDto saveCard(@RequestBody CreateCardRequestDto request) {
		Card card = cardServicePort.createCard(request.cardName());
		return new CardResponseDto(card.cardId().toString(), card.cardName());
	}

	@GetMapping()
	public List<CardResponseDto> getAllCards() {
		List<Card> cards = cardServicePort.getAllCards();
		return cards.stream().map(card -> new CardResponseDto(card.cardId().toString(), card.cardName())).toList();
	}

}
