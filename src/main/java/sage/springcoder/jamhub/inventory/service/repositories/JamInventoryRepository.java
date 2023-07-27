package sage.springcoder.jamhub.inventory.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sage.springcoder.jamhub.inventory.service.domain.JamInventory;

import java.util.List;
import java.util.UUID;

@Repository
public interface JamInventoryRepository extends JpaRepository<JamInventory, UUID> {

    List<JamInventory> findAllByJamId(UUID jamId);
}
