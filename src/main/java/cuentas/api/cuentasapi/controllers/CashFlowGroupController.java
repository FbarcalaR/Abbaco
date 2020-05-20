package cuentas.api.cuentasapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cuentas.api.cuentasapi.models.CashFlowGroup;
import cuentas.api.cuentasapi.repositories.CashFlowGroupsRepository;

@CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200", "https://abbaco-spa.herokuapp.com" })
@RestController
public class CashFlowGroupController {

    @Autowired
    CashFlowGroupsRepository cashFlowGroupsRepository;

    @GetMapping("/cashFlowGroupsId/{name}")
	public int getCashFlowGroupId(@PathVariable String name) {
        List<CashFlowGroup> result=cashFlowGroupsRepository.findByName(name);

        if(result.isEmpty()) return -1;

		return result.get(0).getId();
    }

    @GetMapping("/cashFlowGroupsName/{id}")
	public String getCashFlowGroupName(@PathVariable int id) {
        return cashFlowGroupsRepository.findById(id).get().getName();
    }

    @GetMapping("/cashFlowGroups")
	public Iterable<CashFlowGroup> getAllCashFlows() {
		return cashFlowGroupsRepository.findAll();
    }
}