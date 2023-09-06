package com.gmail.serebryannikovev.clients.repository;

import com.gmail.serebryannikovev.clients.model.Phone;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {
    List<Phone> findByClientId(Long clientId);

    @Modifying
    @Query(value = "insert into phones (client_id, phone) values (:id, :phone);", nativeQuery = true)
    void save(@Param("id") Long clientId, @Param("phone") String phone);
}
