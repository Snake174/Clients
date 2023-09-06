package com.gmail.serebryannikovev.clients.controller;

import com.gmail.serebryannikovev.clients.api.ClientRq;
import com.gmail.serebryannikovev.clients.api.ContactRq;
import com.gmail.serebryannikovev.clients.api.Info;
import com.gmail.serebryannikovev.clients.model.Client;
import com.gmail.serebryannikovev.clients.model.Email;
import com.gmail.serebryannikovev.clients.model.Phone;
import com.gmail.serebryannikovev.clients.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/clients")
@RequiredArgsConstructor
@Transactional
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> clients() {
        return ResponseEntity.ok(clientService.getClients());
    }

    @PostMapping
    public ResponseEntity<Client> add(@RequestBody ClientRq client)
    {
        List<Email> pEmails = client.getEmails().stream().map(e -> Email.builder().email(e).build()).toList();
        List<Phone> pPhones = client.getPhones().stream().map(p -> Phone.builder().phone(p).build()).toList();

        Client pClient = Client.builder()
            .name(client.getName())
            .emails(pEmails)
            .phones(pPhones)
            .build();

        clientService.save(pClient);
        clientService.saveEmails(pClient);
        clientService.savePhones(pClient);

        return new ResponseEntity<>(pClient, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/email")
    public ResponseEntity<List<String>> getEmails(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getEmails(id));
    }

    @PostMapping("/{id}/email")
    public ResponseEntity<String> addEmail(@RequestBody ContactRq contactRq) {
        clientService.saveEmail(contactRq.getClientId(), contactRq.getData());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/phone")
    public ResponseEntity<List<String>> getPhones(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getPhones(id));
    }

    @PostMapping("/{id}/phone")
    public ResponseEntity<String> addPhone(@RequestBody ContactRq contactRq) {
        clientService.savePhone(contactRq.getClientId(), contactRq.getData());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/info")
    public ResponseEntity<Info> getInfo(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getInfo(id));
    }

    @GetMapping("/{id}/contacts")
    public ResponseEntity<List<Map<String, String>>> getContacts(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getContacts(id));
    }
}
