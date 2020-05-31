package abbaco.entities.repositories;

import org.springframework.data.repository.CrudRepository;

import abbaco.entities.models.CashFlow;

public interface CashFlowsRepository extends CrudRepository<CashFlow, Long> {}