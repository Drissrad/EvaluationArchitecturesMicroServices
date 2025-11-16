package ma.enset.virementservice.web;

import ma.enset.virementservice.entities.Virement;
import ma.enset.virementservice.feign.BeneficiaryRestClient;
import ma.enset.virementservice.repositories.VirementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ViremntRestcontoller {
    @Autowired
    private VirementRepository virementRepository;
    @Autowired
    private BeneficiaryRestClient beneficiaryRestClient;

@GetMapping("/api/virements/{id}")
    public Virement getVirementById(@PathVariable Long id){

        Virement virement=virementRepository.findById(id).get();
        virement.setBeneficiary(beneficiaryRestClient.GetBeneficiaryrById(virement.getBeneficiaireId()));
        return virement;}
}
