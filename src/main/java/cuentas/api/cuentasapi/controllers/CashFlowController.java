package cuentas.api.cuentasapi.controllers;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cuentas.api.cuentasapi.DtoModels.CashFlowDto;
import cuentas.api.cuentasapi.models.CashFlow;
import cuentas.api.cuentasapi.models.CashFlowGroup;
import cuentas.api.cuentasapi.models.SearchCashFlow;
import cuentas.api.cuentasapi.repositories.CashFlowGroupsRepository;
import cuentas.api.cuentasapi.repositories.CashFlowsRepository;;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "https://abbaco-spa.herokuapp.com" })
@RestController
public class CashFlowController {

    @Autowired
    CashFlowsRepository cashFlowsRepository;
    @Autowired
    CashFlowGroupsRepository cashFlowGroupsRepository;

	@GetMapping("/cashFlows")
	public Iterable<CashFlowDto> getAllCashFlows() {
		Iterable<CashFlow> cashFlows=cashFlowsRepository.findAll();
		List<CashFlowDto> cashFlowsDto=new LinkedList<CashFlowDto>();
		cashFlows.forEach(cashFlow->{
			cashFlowsDto.add(mapToDto(cashFlow));
		});
		return cashFlowsDto;
	}

	@PutMapping("/cashFlows/search")
	public Iterable<CashFlowDto> searchCashFlows(@RequestBody SearchCashFlow cashFlowSearch) {
		Iterable<CashFlow> cashFlows;
		Date startDate = cashFlowSearch.getStartDate()==null ? new Date(0, 0, 1) : cashFlowSearch.getStartDate();
		Date endDate = cashFlowSearch.getEndDate()==null ? new Date(200, 11, 31) : cashFlowSearch.getEndDate();
		
		if(cashFlowSearch.getCashFlowGroup()!=null){
			int cashFlowGroup=cashFlowGroupsRepository.findByName(cashFlowSearch.getCashFlowGroup()).get(0).getId();
			cashFlows = cashFlowsRepository
			.findByCreationDateBetweenAndCashBetweenAndCashFlowDescriptionContainingAndCashFlowGroup(
					startDate, endDate, cashFlowSearch.getMinCash(),
					cashFlowSearch.getMaxCash(), cashFlowSearch.getCashFlowDescription(), cashFlowGroup);
		}
		else{
			cashFlows = cashFlowsRepository
			.findByCreationDateBetweenAndCashBetweenAndCashFlowDescriptionContaining(
					startDate, endDate, cashFlowSearch.getMinCash(),
					cashFlowSearch.getMaxCash(), cashFlowSearch.getCashFlowDescription());
		}

		List<CashFlowDto> cashFlowsDto=new LinkedList<CashFlowDto>();
		cashFlows.forEach(cashFlow->{
			cashFlowsDto.add(mapToDto(cashFlow));
		});
		return cashFlowsDto;
	}

	@GetMapping("/cashFlows/{id}")
	public CashFlow getCashFlow(@PathVariable int id) {
		return cashFlowsRepository.findById(id).get();
	}

	@DeleteMapping("/cashFlows/{id}")
	public ResponseEntity<Void> deleteCashFlow( @PathVariable int id) {
		if (!cashFlowsRepository.existsById(id)) return ResponseEntity.noContent().build();

		cashFlowsRepository.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PostMapping("/cashFlows")
	public ResponseEntity<Void> createCashFlow( @RequestBody CashFlowDto cashFlowDto) {
		CashFlow cashFlow = mapFromDto(cashFlowDto);
		cashFlowsRepository.save(cashFlow);

		return ResponseEntity.ok().build();
	}

	private CashFlowDto mapToDto(CashFlow cashFlow){
		String cashFlowGroupName=cashFlowGroupsRepository.findById(cashFlow.getCashFlowGroup()).get().getName();
		return new CashFlowDto(
			cashFlow.getId(),
			cashFlow.getCreationDate(),
			cashFlow.getCash(),
			cashFlow.getCashFlowDescription(),
			cashFlowGroupName
		);
	}

	private CashFlow mapFromDto(CashFlowDto cashFlowDto){
		List<CashFlowGroup> group = cashFlowGroupsRepository.findByName(cashFlowDto.getCashFlowGroup());
		int cashFlowGroupName = 1;

		if(!group.isEmpty())
			cashFlowGroupName = group.get(0).getId();
		return new CashFlow(
			cashFlowDto.getId(),
			cashFlowDto.getCreationDate(),
			cashFlowDto.getCash(),
			cashFlowDto.getCashFlowDescription(),
			cashFlowGroupName
		);
	}

}