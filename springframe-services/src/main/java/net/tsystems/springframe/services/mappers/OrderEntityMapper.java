package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

    @Mapping(target="closed", expression="java(net.tsystems.springframe.services.Utils.byteToBool(orderEntity.getClosed()))")
    OrderEntitySO orderEntityToDto(OrderEntity orderEntity);
}
