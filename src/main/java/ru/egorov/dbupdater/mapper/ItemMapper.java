package ru.egorov.dbupdater.mapper;

import org.mapstruct.Mapper;
import ru.egorov.dbupdater.dto.ProductDto;
import ru.egorov.dbupdater.model.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    Item toEntity(ProductDto productDto);
}
