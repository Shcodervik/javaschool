package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoutepointEntity;
import net.tsystems.springframe.services.objects.RoutepointEntitySO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoutepointEntityMapper {
    RoutepointEntityMapper INSTANCE = Mappers.getMapper(RoutepointEntityMapper.class);
    @Mapping(target="orderIdOrder.closed", expression="java(net.tsystems.springframe.services.Utils.byteToBool(orderEntity.getClosed()))")
    RoutepointEntitySO routepointEntityToDto(RoutepointEntity routepointEntity);
}
