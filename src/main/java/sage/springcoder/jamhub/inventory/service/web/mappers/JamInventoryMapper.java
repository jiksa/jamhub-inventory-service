package sage.springcoder.jamhub.inventory.service.web.mappers;

import org.mapstruct.Mapper;
import sage.springcoder.jamhub.inventory.service.domain.JamInventory;
import sage.springcoder.jamhub.inventory.service.web.model.JamInventoryDto;

@Mapper(uses = {DateMapper.class})
public interface JamInventoryMapper {
    JamInventory jamInventoryDtoToJamInventory(JamInventoryDto jamInventoryDTO);

    JamInventoryDto jamInventoryToJamInventoryDto(JamInventory jamInventory);
}
