package abbaco.presentation.controllers;

import java.util.Collection;
import java.util.LinkedList;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abbaco.entities.models.CashFlow;
import abbaco.presentation.dtoModels.CashFlowDto;
import abbaco.usecases.CashFlowService;

@RestController
@RequestMapping("/api/cash-flows")
public class CashFlowsController {
    @Autowired
	private CashFlowService cashFlowsService;
	
    @Autowired
    private ModelMapper modelMapper;
	

	@GetMapping
	public CollectionModel<EntityModel<CashFlowDto>> getAll() {
		java.lang.reflect.Type targetListType = new TypeToken<Collection<CashFlowDto>>(){}.getType();
		Collection<CashFlowDto> cashFlowsDtos = modelMapper.map(cashFlowsService.getAll(), targetListType);
		
		Collection<EntityModel<CashFlowDto>> cashFlowsEntities = new LinkedList<>();

		for (CashFlowDto cashFlowDto : cashFlowsDtos) {
			EntityModel<CashFlowDto> cEntityModel = EntityModel.of(cashFlowDto, linkTo(methodOn(CashFlowsController.class).getById(cashFlowDto.getId())).withSelfRel());
			cashFlowsEntities.add(cEntityModel);
		}

		return CollectionModel.of(cashFlowsEntities,
		linkTo(methodOn(CashFlowsController.class).getAll()).withSelfRel());
	}

	@GetMapping("/{id}")
	EntityModel<CashFlowDto> getById(@PathVariable String id) {
		CashFlowDto cashFlowResult = modelMapper.map(cashFlowsService.getById(id).get(), CashFlowDto.class);

		return EntityModel.of(cashFlowResult,
		linkTo(methodOn(CashFlowsController.class).getById(id)).withSelfRel());
	}

	@PostMapping
	public ResponseEntity<Void> add(@RequestBody CashFlowDto cashFlowDto){
		cashFlowsService.add(modelMapper.map(cashFlowDto, CashFlow.class));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCashFlow( @PathVariable String id) {
		cashFlowsService.delete(id);
		return ResponseEntity.ok().build();
	}
} 