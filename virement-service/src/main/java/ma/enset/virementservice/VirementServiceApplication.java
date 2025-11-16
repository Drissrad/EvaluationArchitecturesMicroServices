package ma.enset.virementservice;

import ma.enset.virementservice.Model.Beneficiary;
import ma.enset.virementservice.entities.Virement;
import ma.enset.virementservice.enums.VirementType;
import ma.enset.virementservice.feign.BeneficiaryRestClient;
import ma.enset.virementservice.repositories.VirementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableFeignClients
public class VirementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VirementServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(VirementRepository repo, BeneficiaryRestClient beneficiaryRestClient) {
        return args -> {
            Beneficiary b = beneficiaryRestClient.GetBeneficiaryrById(1L);

            if (b != null) {
                System.out.println("✅ Beneficiary récupéré depuis le microservice :");
                System.out.println("   ID : " + b.getId());
                System.out.println("   Nom : " + b.getNom());
                System.out.println("   Prénom : " + b.getPrenom());
                System.out.println("   RIB : " + b.getRib());
                System.out.println("   Type : " + b.getType());
            } else {
                System.out.println("⚠️ Impossible de récupérer le Beneficiary depuis le microservice !");
            }

            repo.save(Virement.builder()
                    .beneficiaireId(b != null ? b.getId() : null)
                    .ribSource("RIB-SOURCE-001")
                    .montant(BigDecimal.valueOf(1230))
                    .description("Paiement initial")
                    .dateVirement(LocalDateTime.now())
                    .type(VirementType.NORMAL)
                    .beneficiary(b)
                    .build());
        };
    }


}
