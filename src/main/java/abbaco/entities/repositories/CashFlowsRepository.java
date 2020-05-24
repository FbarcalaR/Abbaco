package abbaco.entities.repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import abbaco.entities.models.CashFlow;

public interface CashFlowsRepository extends CrudRepository<CashFlow, UUID> {}