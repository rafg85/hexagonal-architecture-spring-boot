package infra.adapters.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CardResponseDto(@JsonProperty(value = "card_id") String cardId,
		@JsonProperty(value = "card_name") String cardName) {

}
