package infra.adapters.input;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateCardRequestDto(@JsonProperty(value = "card_name") String cardName) {

}
