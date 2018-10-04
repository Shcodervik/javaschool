package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.OrderEntity;
import net.tsystems.springframe.services.objects.OrderEntitySO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface OrderEntityMapper {
    OrderEntityMapper INSTANCE = Mappers.getMapper(OrderEntityMapper.class);

   // @Mapping(target="Closed", expression="java(Util.byteToBool())")
    OrderEntitySO orderEntityToDto(OrderEntity orderEntity);
}
