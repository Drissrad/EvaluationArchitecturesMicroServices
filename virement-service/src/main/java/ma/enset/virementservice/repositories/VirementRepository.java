package ma.enset.virementservice.repositories;

import ma.enset.virementservice.entities.Virement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface VirementRepository extends JpaRepository<Virement, Long> {

    List<Virement> findByBeneficiaireId(Long beneficiaireId);
}