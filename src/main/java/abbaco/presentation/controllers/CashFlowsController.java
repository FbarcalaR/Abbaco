package abbaco.presentation.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import abbaco.presentation.dtoModels.CashFlowDto;

@RestController
@RequestMapping("/api")
public class CashFlowsController {

    //TODO: add when ready
    // @Autowired
    // CashFlowsService cashFlowsService;
    

	@GetMapping("/cash-flows/{id}")
	EntityModel<CashFlowDto> one(@PathVariable UUID id) {

		// CashFlowDto employee = repository.findById(id)
		// .orElseThrow(() -> new EmployeeNotFoundException(id))
		// .map<CashFlowDto>();

		EntityModel result = new EntityModel<>(new CashFlowDto(id, null, 0, null, 0),
		linkTo(methodOn(CashFlowsController.class).one(id)).withSelfRel());
		return result;
	}
} 