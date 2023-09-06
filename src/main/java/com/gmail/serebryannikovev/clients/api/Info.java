package com.gmail.serebryannikovev.clients.api;

import lombok.*;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Info {
    private String name;
    private Map<String, String> contacts;
}
