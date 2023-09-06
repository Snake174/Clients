package com.gmail.serebryannikovev.clients.service;

import com.gmail.serebryannikovev.clients.api.Info;
import com.gmail.serebryannikovev.clients.model.Client;
import com.gmail.serebryannikovev.clients.repository.ClientRepository;
import com.gmail.serebryannikovev.clients.repository.EmailRepository;
import com.gmail.serebryannikovev.clients.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final EmailRepository emailRepository;
    private final PhoneRepository phoneRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(Long id) {
        return clientRepository.findById(id).get();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public void saveEmails(Client client) {
        client.getEmails().forEach(emailRepository::save);
    }

    public List<String> getEmails(Long clientId) {
        List<String> result = new ArrayList<>();
        emailRepository.findByClientId(clientId).forEach(e -> result.add(e.getEmail()));
        return result;
    }

    public void savePhones(Client client) {
        client.getPhones().forEach(phoneRepository::save);
    }

    public List<String> getPhones(Long clientId) {
        List<String> result = new ArrayList<>();
        phoneRepository.findByClientId(clientId).forEach(e -> result.add(e.getPhone()));
        return result;
    }

    public void saveEmail(Long clientId, String email) {
        emailRepository.save(clientId, email);
    }

    public void savePhone(Long clientId, String phone) {
        phoneRepository.save(clientId, phone);
    }

    public Info getInfo(Long id) {
        Client client = clientRepository.findById(id).get();
        Map<String, String> contacts = new HashMap<>();
        client.getEmails().forEach(e -> contacts.put(e.getEmail(), "email"));
        client.getPhones().forEach(p -> contacts.put(p.getPhone(), "phone"));

        return Info.builder()
            .name(client.getName())
            .contacts(contacts)
            .build();
    }

    public List<Map<String, String>> getContacts(Long id) {
        return clientRepository.getContactsWithType(id);
    }
}
