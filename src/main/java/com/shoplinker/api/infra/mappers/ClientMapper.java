package com.shoplinker.api.infra.mappers;

import com.shoplinker.api.domain.entities.Client;
import com.shoplinker.api.infra.resources.ClientDTO;
import com.shoplinker.api.infra.resources.ClientInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
	@Mapping(target = "isActive", defaultValue = "true")
	Client map(ClientDTO source);

	ClientInfoDTO map(Client source);
	Page<ClientInfoDTO> map(Page<Client> source);
	void update(ClientDTO source, @MappingTarget Client target);
}
