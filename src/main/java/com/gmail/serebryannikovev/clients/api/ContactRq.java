package com.gmail.serebryannikovev.clients.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRq {
    @JsonProperty("client_id")
    private Long clientId;
    private String data;
}
