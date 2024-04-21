package com.shoplinker.api.infra.services;

import com.shoplinker.api.domain.errors.NotFoundException;
import com.shoplinker.api.infra.mappers.AdministratorMapper;
import com.shoplinker.api.infra.repositories.AdministratorRepository;
import com.shoplinker.api.infra.resources.AdministratorDTO;
import com.shoplinker.api.infra.resources.AdministratorInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdministratorService {

	@Autowired
	private AdministratorRepository administratorRepository;

	@Autowired
	private AdministratorMapper administratorMapper;

	public AdministratorInfoDTO create(AdministratorDTO resource) {
		var administrator = administratorMapper.map(resource);
		administrator = administratorRepository.save(administrator);
		return administratorMapper.map(administrator);
	}

	public AdministratorInfoDTO update(UUID id, AdministratorDTO resource) {
		var administrator = administratorRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Administrator not found."));
		administratorMapper.update(resource, administrator);
		administrator = administratorRepository.save(administrator);
		return administratorMapper.map(administrator);
	}

	public AdministratorInfoDTO find(UUID id) {
		var administrator = administratorRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Administrator not found."));
		return administratorMapper.map(administrator);
	}

	public Page<AdministratorInfoDTO> listAll(Pageable pageable) {
		var administrators = administratorRepository.findAll(pageable);
		return administratorMapper.map(administrators);
	}

	public void enable(UUID id) {
		var administrator = administratorRepository.findById(id)
		  .orElseThrow(() -> new NotFoundException("Administrator not found."));
		administrator.setActive(true);
		administratorRepository.save(administrator);
	}

	public void disable(UUID id) {
        var administrator = administratorRepository.findById(id)
          .orElseThrow(() -> new NotFoundException("Administrator not found."));
		administrator.setActive(false);
		administratorRepository.save(administrator);
    }
}
