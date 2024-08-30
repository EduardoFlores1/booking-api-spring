package com.tarker.booking_api.core.application.mappers;

import com.tarker.booking_api.core.domain.entities.AddressEntity;
import com.tarker.booking_api.core.domain.models.AddressModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    AddressModel toModel(AddressEntity addressEntity);
    AddressEntity toEntity(AddressModel addressModel);
}
