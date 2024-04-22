package com.gustavo.pinto.ticketservice.application.services;

import com.gustavo.pinto.ticketservice.domain.exceptions.NotFoundException;
import com.gustavo.pinto.ticketservice.domain.models.Client;
import com.gustavo.pinto.ticketservice.domain.repositories.ClientRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
    @Mock
    private ClientRepository clientRepository;
    @InjectMocks
    private ClientService clientService;

    @Test
    public void testCreateClientSuccessfully() {
        //When
        clientService.createClient(ClientData.createClientDTO);
        //Then
        Mockito.verify(clientRepository).createClient(Mockito.any(Client.class));
    }

    @Test
    public void testGetClientByIdIfClientNotExists() {
        //Given
        Mockito.when(clientRepository.getClientById("123")).thenReturn(Optional.empty());
        //When
        Assertions.assertThatThrownBy(() -> {
            clientService.getClientById("123");
        }).isInstanceOf(NotFoundException.class);
        //Then
        Mockito.verify(clientRepository).getClientById("123");
    }

    @Test
    public void testGetClientByIdSuccessfully() {
        //Given
        Mockito.when(clientRepository.getClientById("123")).thenReturn(Optional.of(ClientData.createClient()));
        //When
        clientService.getClientById("123");
        //Then
        Mockito.verify(clientRepository, Mockito.times(1)).getClientById("123");
    }
}
