package ru.egorov.dbupdater.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.egorov.dbupdater.dto.ProductDto;
import ru.egorov.dbupdater.model.Offer;

@Mapper(componentModel = "spring")
public interface OfferMapper {

    @Mapping(source = "productDto.storeType", target = "storeName")
    Offer toEntity(ProductDto productDto);
}
