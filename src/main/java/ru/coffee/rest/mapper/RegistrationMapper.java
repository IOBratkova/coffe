package ru.coffee.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import ru.coffee.entity.UserCredential;
import ru.coffee.rest.dto.RegistrationRequest;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegistrationMapper {

    @Mapping(target = "role", constant = "USER")
    UserCredential toEntity(RegistrationRequest dto);

}
