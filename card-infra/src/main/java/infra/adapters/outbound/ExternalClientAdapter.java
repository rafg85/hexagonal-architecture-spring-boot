package infra.adapters.outbound;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import core.ports.outbound.ExternalClientPort;

@Component
public class ExternalClientAdapter implements ExternalClientPort {

	private RestTemplate restTemplate;

	private static final String BASE_URL = "https://api.scryfall.com/cards/named?fuzzy=";

	public ExternalClientAdapter(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public String getVerifiedCardName(String cardName) {
		try {
			String url = BASE_URL + cardName;
			ResponseEntity<ClientCardDto> response = restTemplate.getForEntity(url, ClientCardDto.class);
			return Optional.ofNullable(response.getBody()).map(ClientCardDto::name).orElse(null);
		} catch (Exception e) {
			return null;
		}
	}

}
