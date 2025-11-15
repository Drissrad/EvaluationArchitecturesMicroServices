package ma.enset.virementservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.virementservice.enums.VirementType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long beneficiaireId;
    private String ribSource;
    private BigDecimal montant;
    private String description;

    private LocalDateTime dateVirement;

    @Enumerated(EnumType.STRING)
    private VirementType type;
}
