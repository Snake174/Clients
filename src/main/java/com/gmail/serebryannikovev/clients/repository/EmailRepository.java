package com.gmail.serebryannikovev.clients.repository;

import com.gmail.serebryannikovev.clients.model.Email;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
    List<Email> findByClientId(Long clientId);

    @Modifying
    @Query(value = "insert into emails (client_id, email) values (:id, :email);", nativeQuery = true)
    void save(@Param("id") Long clientId, @Param("email") String email);
}
