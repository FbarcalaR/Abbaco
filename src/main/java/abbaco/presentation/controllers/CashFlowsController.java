package abbaco.presentation.controllers;

import java.util.Collection;
import java.util.LinkedList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abbaco.presentation.dtoModels.CashFlowDto;
import abbaco.presentation.dtoModels.CashFlowFiltersDto;
import abbaco.presentation.mappers.CashFlowDtoEntityMapper;
import abbaco.presentation.mappers.CashFlowFiltersDtoSvcMapper;
import abbaco.usecases.CashFlowFiltersSvc;
import abbaco.usecases.CashFlowService;

@RestController
@RequestMapping("/api/cash-flows")
@CrossOrigin
public class CashFlowsController {
    @Autowired
	private CashFlowService cashFlowsService;
	@Autowired
	private CashFlowDtoEntityMapper cashFlowsMapper;
	@Autowired
	private CashFlowFiltersDtoSvcMapper filtersMapper;
	
	@GetMapping
	public CollectionModel<EntityModel<CashFlowDto>> getAll(@Valid CashFlowFiltersDto cashFlowFiltersDto) {
		CashFlowFiltersSvc filtersSvc = filtersMapper.cashFlowFiltersDtoToCashFlowFiltersSvc(cashFlowFiltersDto);
		Iterable<CashFlowDto> cashFlowsDtos = cashFlowsMapper.cashFlowToCashFlowDto(cashFlowsService.getAllFiltered(filtersSvc));

		Collection<EntityModel<CashFlowDto>> cashFlowsEntities = new LinkedList<>();

		for (CashFlowDto cashFlowDto : cashFlowsDtos) {
			EntityModel<CashFlowDto> cEntityModel = EntityModel.of(cashFlowDto, linkTo(methodOn(CashFlowsController.class).getById(cashFlowDto.getId())).withSelfRel());
			cashFlowsEntities.add(cEntityModel);
		}

		return CollectionModel.of(cashFlowsEntities,
		linkTo(methodOn(CashFlowsController.class).getAll(cashFlowFiltersDto)).withSelfRel());
	}

	@GetMapping("/{id}")
	EntityModel<CashFlowDto> getById(@PathVariable Long id) {
		CashFlowDto cashFlowResult = cashFlowsMapper.cashFlowToCashFlowDto(cashFlowsService.getById(id).get());

		return EntityModel.of(cashFlowResult,
		linkTo(methodOn(CashFlowsController.class).getById(id)).withSelfRel());
	}

	@PostMapping
	public ResponseEntity<Void> add(@RequestBody @Valid CashFlowDto cashFlowDto){
		cashFlowsService.add(cashFlowsMapper.CashFlowDtoToCashFlow(cashFlowDto));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCashFlow( @PathVariable Long id) {
		cashFlowsService.delete(id);
		return ResponseEntity.ok().build();
	}
} 
