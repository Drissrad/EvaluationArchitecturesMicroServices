package ma.enset.virementservice.feign;

import ma.enset.virementservice.Model.Beneficiary;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "beneficiary-service")
public interface BeneficiaryRestClient {
        @GetMapping("/beneficiaries/{id}")
        Beneficiary GetBeneficiaryrById(@PathVariable Long id);
        @GetMapping("/beneficiaries")
        PagedModel< Beneficiary> GetAllBeneficiars();

}
