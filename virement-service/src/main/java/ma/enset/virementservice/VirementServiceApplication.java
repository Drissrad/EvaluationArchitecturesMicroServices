package ma.enset.virementservice;

import ma.enset.virementservice.entities.Virement;
import ma.enset.virementservice.enums.VirementType;
import ma.enset.virementservice.repositories.VirementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(VirementRepository repo) {
        return args -> {
            repo.save(Virement.builder()
                    .beneficiaireId(1L)
                    .ribSource("RIB-SOURCE-001")
                    .montant(BigDecimal.valueOf(1230))
                    .description("Paiement initial")
                    .dateVirement(LocalDateTime.now())
                    .type(VirementType.NORMAL)
                    .build());
        };
    }
}
