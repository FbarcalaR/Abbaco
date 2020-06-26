package abbaco.entities.repositories;

import java.util.List;

import com.querydsl.core.types.Predicate;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;

import abbaco.entities.models.CashFlow;

public interface CashFlowsRepository extends CrudRepository<CashFlow, Long>, QuerydslPredicateExecutor<CashFlow> {
    public List<CashFlow> findAll(Predicate predicate);
    
}