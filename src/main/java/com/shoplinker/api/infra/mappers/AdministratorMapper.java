package com.shoplinker.api.infra.mappers;

import com.shoplinker.api.domain.entities.Administrator;
import com.shoplinker.api.infra.resources.AdministratorDTO;
import com.shoplinker.api.infra.resources.AdministratorInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface AdministratorMapper {
	@Mapping(target = "isActive", defaultValue = "true")
	Administrator map(AdministratorDTO source);

	AdministratorInfoDTO map(Administrator source);
	Page<AdministratorInfoDTO> map(Page<Administrator> source);
	void update(AdministratorDTO source, @MappingTarget Administrator target);
}
