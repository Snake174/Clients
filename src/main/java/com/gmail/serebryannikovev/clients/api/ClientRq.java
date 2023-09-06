package com.gmail.serebryannikovev.clients.api;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientRq {
    private String name;
    private List<String> emails;
    private List<String> phones;
}
