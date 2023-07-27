package sage.springcoder.jamhub.inventory.service.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sage.springcoder.jamhub.inventory.service.domain.JamInventory;
import sage.springcoder.jamhub.inventory.service.repositories.JamInventoryRepository;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class JamInventoryBootstrap implements CommandLineRunner {

    public static final String JAM_1_UPC = "0631234200036";
    public static final String JAM_2_UPC = "0631234300019";
    public static final String JAM_3_UPC = "0083783375213";
    public static final UUID JAM_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");
    public static final UUID JAM_2_UUID = UUID.fromString("a712d914-61ea-4623-8bd0-32c0f6545bfd");
    public static final UUID JAM_3_UUID = UUID.fromString("026cc3c8-3a0c-4083-a05b-e908048c1b08");

    private final JamInventoryRepository jamInventoryRepository;

    @Override
    public void run(String... args) throws Exception {
        if (jamInventoryRepository.count() == 0) {
            loadInitialInv();
        }
    }

    private void loadInitialInv() {
        jamInventoryRepository.save(JamInventory
                .builder()
                .jamId(JAM_1_UUID)
                .upc(JAM_1_UPC)
                .quantityOnHand(50)
                .build());

        jamInventoryRepository.save(JamInventory
                .builder()
                .jamId(JAM_2_UUID)
                .upc(JAM_2_UPC)
                .quantityOnHand(50)
                .build());

        jamInventoryRepository.saveAndFlush(JamInventory
                .builder()
                .jamId(JAM_3_UUID)
                .upc(JAM_3_UPC)
                .quantityOnHand(50)
                .build());

        log.info("Loaded Inventory. Record count: " + jamInventoryRepository.count());
    }

}
