package sage.springcoder.jamhub.inventory.service.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sage.springcoder.jamhub.inventory.service.repositories.JamInventoryRepository;
import sage.springcoder.jamhub.inventory.service.web.mappers.JamInventoryMapper;
import sage.springcoder.jamhub.inventory.service.web.model.JamInventoryDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class JamInventoryController {

    private final JamInventoryRepository jamInventoryRepository;
    private final JamInventoryMapper jamInventoryMapper;
   @GetMapping("api/v1/jam/{jamId}/inventory")
   List<JamInventoryDto> listJamsById(@PathVariable UUID jamId){
       log.debug("Finding Inventory for jamId:" + jamId);

       return jamInventoryRepository.findAllByJamId(jamId)
               .stream()
               .map(jamInventoryMapper::jamInventoryToJamInventoryDto)
               .collect(Collectors.toList());
   }
}
