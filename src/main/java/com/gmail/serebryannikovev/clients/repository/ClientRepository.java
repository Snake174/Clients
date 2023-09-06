package com.gmail.serebryannikovev.clients.repository;

import com.gmail.serebryannikovev.clients.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
    List<Client> findAll();

    @Query(
        value =
            "SELECT t.contact as contact, " +
            "       t.t as ctype" +
            "  FROM ( " +
            "SELECT 'email' as t, " +
            "       e.email as contact " +
            "  FROM clients c " +
            "  JOIN emails e " +
            "    ON e.client_id = c.id " +
            " WHERE c.id = :id " +
            " UNION " +
            "SELECT 'phone' as t, " +
            "       p.phone as contact " +
            "  FROM clients c " +
            "  JOIN phones p " +
            "    ON p.client_id = c.id " +
            " WHERE c.id = :id " +
            ") t " +
            "ORDER BY t.t;",
        nativeQuery = true)
    List<Map<String, String>> getContactsWithType(@Param("id") Long clientId);
}
