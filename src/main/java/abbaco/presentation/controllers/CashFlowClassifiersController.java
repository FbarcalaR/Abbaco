package abbaco.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Collection;
import java.util.LinkedList;

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

import abbaco.presentation.dtoModels.CashFlowClassifierDto;
import abbaco.presentation.mappers.CashFlowClassifierDtoEntityMapper;
import abbaco.usecases.CashFlowClassifierService;

@RestController
@RequestMapping("/api/cash-flow-classifiers")
@CrossOrigin(origins = { "http://localhost:3000" })
public class CashFlowClassifiersController {
    @Autowired
	private CashFlowClassifierService cashFlowClassifierService;

	@Autowired
	private CashFlowClassifierDtoEntityMapper mapper;

	@GetMapping
	public CollectionModel<CashFlowClassifierDto> getAll() {
		 Iterable<CashFlowClassifierDto> cashFlowsDtos = mapper.cashFlowClassifierToCashFlowClassifierDto(cashFlowClassifierService.getAll());

		return CollectionModel.of(cashFlowsDtos,
		linkTo(methodOn(CashFlowsController.class).getAll()).withSelfRel());
	}

	@PostMapping
	public ResponseEntity<Void> add(@RequestBody CashFlowClassifierDto classifierDto){
		cashFlowClassifierService.add(mapper.CashFlowClassifierDtoToCashFlowClassifier(classifierDto));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCashFlow( @PathVariable Long id) {
		cashFlowClassifierService.delete(id);
		return ResponseEntity.ok().build();
	}
}