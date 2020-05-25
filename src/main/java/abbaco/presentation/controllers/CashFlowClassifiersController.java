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

import abbaco.entities.models.CashFlowClassifier;
import abbaco.presentation.dtoModels.CashFlowClassifierDto;
import abbaco.usecases.CashFlowClassifierService;

@RestController
@RequestMapping("/api/cash-flow-classifiers")
public class CashFlowClassifiersController {
    @Autowired
	private CashFlowClassifierService cashFlowClassifierService;
	
    @Autowired
    private ModelMapper modelMapper;
    
    @GetMapping
	public CollectionModel<CashFlowClassifierDto> getAll() {
		java.lang.reflect.Type targetListType = new TypeToken<Collection<CashFlowClassifierDto>>(){}.getType();
		Collection<CashFlowClassifierDto> cashFlowsDtos = modelMapper.map(cashFlowClassifierService.getAll(), targetListType);

		return CollectionModel.of(cashFlowsDtos,
		linkTo(methodOn(CashFlowsController.class).getAll()).withSelfRel());
	}

	@PostMapping
	public ResponseEntity<Void> add(@RequestBody CashFlowClassifierDto classifierDto){
		cashFlowClassifierService.add(modelMapper.map(classifierDto, CashFlowClassifier.class));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCashFlow( @PathVariable String id) {
		cashFlowClassifierService.delete(id);
		return ResponseEntity.ok().build();
	}
}