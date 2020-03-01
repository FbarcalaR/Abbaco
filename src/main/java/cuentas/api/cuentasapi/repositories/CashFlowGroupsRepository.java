package cuentas.api.cuentasapi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cuentas.api.cuentasapi.models.CashFlowGroup;


public interface CashFlowGroupsRepository extends CrudRepository<CashFlowGroup, Integer>{

    List<CashFlowGroup> findByName(String name);

}