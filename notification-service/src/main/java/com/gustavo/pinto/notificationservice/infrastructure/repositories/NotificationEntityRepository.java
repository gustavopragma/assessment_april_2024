package com.gustavo.pinto.notificationservice.infrastructure.repositories;

import com.gustavo.pinto.notificationservice.infrastructure.entities.NotificationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationEntityRepository extends MongoRepository<NotificationEntity, String> {
    List<NotificationEntity> findByTournamentIdAndAndTicketType(String tournamentId, String ticketType);
}
