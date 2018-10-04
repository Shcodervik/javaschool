package net.tsystems.springframe.services.mappers;

import net.tsystems.springframe.database.RoutepointEntityPK;
import net.tsystems.springframe.services.objects.RoutepointEntityPKSO;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface RoutepointEntityPKMapper {
    RoutepointEntityPKMapper INSTANCE = Mappers.getMapper(RoutepointEntityPKMapper.class);
    RoutepointEntityPKSO routepointEntityPKToDto(RoutepointEntityPK routepointEntityPK);
}
