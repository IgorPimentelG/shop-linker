package com.shoplinker.api.infra.services;

import com.shoplinker.api.domain.errors.NotFoundException;
import com.shoplinker.api.infra.mappers.ClientMapper;
import com.shoplinker.api.infra.repositories.ClientRepository;
import com.shoplinker.api.infra.resources.ClientDTO;
import com.shoplinker.api.infra.resources.ClientInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ClientMapper mapper;

	public ClientInfoDTO create(ClientDTO resource) {
		var client = mapper.map(resource);
		client = clientRepository.save(client);
		return mapper.map(client);
	}

	public ClientInfoDTO update(UUID id, ClientDTO resource) {
		var client = clientRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Client not found."));
		mapper.update(resource, client);
		client = clientRepository.save(client);
		return mapper.map(client);
	}

	public ClientInfoDTO find(UUID id) {
		var client = clientRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Client not found."));
		return mapper.map(client);
	}

	public Page<ClientInfoDTO> listAll(Pageable pageable) {
		var clients = clientRepository.findAll(pageable);
		return mapper.map(clients);
	}

	public void enable(UUID id) {
		var client = clientRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Client not found."));
		client.setActive(true);
		clientRepository.save(client);
	}

	public void disable(UUID id) {
		var client = clientRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Client not found."));
		client.setActive(false);
		clientRepository.save(client);
    }
}
