package ma.enset.beneficiaryservice;

import ma.enset.beneficiaryservice.entities.Beneficiary;
import ma.enset.beneficiaryservice.enums.BeneficiaryType;
import ma.enset.beneficiaryservice.repositories.BeneficiaryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeneficiaryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeneficiaryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner initData(BeneficiaryRepository repo) {
        return args -> {
            repo.save(Beneficiary.builder()
                    .nom("Dupont")
                    .prenom("Alice")
                    .rib("RIB001")
                    .type(BeneficiaryType.PHYSIQUE)
                    .build());

            repo.save(Beneficiary.builder()
                    .nom("ACME Corp")
                    .prenom("")
                    .rib("RIB002")
                    .type(BeneficiaryType.MORALE)
                    .build());
        };
    }

}
