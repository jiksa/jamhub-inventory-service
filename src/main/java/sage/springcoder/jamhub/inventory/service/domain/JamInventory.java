package sage.springcoder.jamhub.inventory.service.domain;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class JamInventory extends BaseEntity{

    @Builder
    public JamInventory(UUID id, Long version, Timestamp createdDate, Timestamp lastModifiedDate,
                        UUID jamId,
                        String upc, Integer quantityOnHand) {
        super(id, version, createdDate, lastModifiedDate);
        this.jamId = jamId;
        this.upc = upc;
        this.quantityOnHand = quantityOnHand;
    }

    private UUID jamId;
    private String upc;
    private Integer quantityOnHand = 0;
}
