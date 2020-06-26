package abbaco.usecases;

import java.util.Optional;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abbaco.entities.models.CashFlow;
import abbaco.entities.models.QCashFlow;
import abbaco.entities.repositories.CashFlowsRepository;

@Service
public class CashFlowService {

    @Autowired
    CashFlowsRepository cashFlowsRepository;

    public Iterable<CashFlow> getAll() {
        return cashFlowsRepository.findAll();
    }

    public Iterable<CashFlow> getAllFiltered(CashFlowFiltersSvc filters){
        Predicate resultPredicate = resolveFilters(filters);

        return cashFlowsRepository.findAll(resultPredicate);
    }

    private Predicate resolveFilters(CashFlowFiltersSvc filters) {
        QCashFlow cashFlow = QCashFlow.cashFlow;
        BooleanExpression initial = cashFlow.id.isNotNull();

        BooleanExpression cfTitlePredicate = filters.getTitle() != null ? cashFlow.title.contains(filters.getTitle()) : null;
        BooleanExpression cfClassification = filters.getClassificationId() != null ? cashFlow.cashFlowClassifier.id.eq(filters.getClassificationId()) : null;
        BooleanExpression cfDatePredicate = filters.getMinDate()!= null || filters.getMaxDate() != null ? cashFlow.creationDate.between(filters.getMinDate(), filters.getMaxDate()) : null;
        BooleanExpression cfCashAmount = filters.getMinCashAmount()!= null || filters.getMaxCashAmount() != null ? cashFlow.cashAmount.between(filters.getMinCashAmount(), filters.getMaxCashAmount()) : null;

        Predicate resultPredicate = initial.and(cfTitlePredicate).and(cfClassification).and(cfDatePredicate).and(cfCashAmount);

        return resultPredicate;
    }

    public Optional<CashFlow> getById(Long id) {
        return cashFlowsRepository.findById(id);
    }

    public CashFlow add(CashFlow cashFlow){
        return cashFlowsRepository.save(cashFlow);
    }

    public void delete(Long id){
        cashFlowsRepository.deleteById(id);
    }
}