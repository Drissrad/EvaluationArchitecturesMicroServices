package ma.enset.virementservice.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import ma.enset.virementservice.enums.BeneficiaryType;
@Getter
@Setter
public class Beneficiary {
    private Long id;

    private String nom;
    private String prenom;
    private String rib;

    @Enumerated(EnumType.STRING)
    private BeneficiaryType type;

}
