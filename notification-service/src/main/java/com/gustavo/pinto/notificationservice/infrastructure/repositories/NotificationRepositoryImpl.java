package com.gustavo.pinto.notificationservice.infrastructure.repositories;

import com.gustavo.pinto.notificationservice.domain.models.Notification;
import com.gustavo.pinto.notificationservice.domain.repositories.NotificationRepository;
import com.gustavo.pinto.notificationservice.infrastructure.entities.NotificationEntity;
import com.gustavo.pinto.notificationservice.infrastructure.mappers.NotificationEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {
    private final NotificationEntityRepository notificationEntityRepository;

    public NotificationRepositoryImpl(NotificationEntityRepository notificationEntityRepository) {
        this.notificationEntityRepository = notificationEntityRepository;
    }

    @Override
    public List<Notification> getNotificationsByTournamentIdAndTicketType(String tournamentId, String ticketType) {
        return notificationEntityRepository
                .findByTournamentIdAndAndTicketType(tournamentId, ticketType)
                .stream()
                .map(NotificationEntityMapper::toModel)
                .toList();
    }

    @Override
    public String createNotification(Notification notification) {
        NotificationEntity notificationEntity = NotificationEntityMapper.toEntity(notification);
        notificationEntityRepository.save(notificationEntity);
        return notificationEntity.getId();
    }
}
