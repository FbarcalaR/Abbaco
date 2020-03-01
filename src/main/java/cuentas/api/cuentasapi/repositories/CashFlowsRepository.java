package cuentas.api.cuentasapi.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cuentas.api.cuentasapi.models.CashFlow;

public interface CashFlowsRepository extends CrudRepository<CashFlow, Integer> {
    List<CashFlow> findByCreationDateBetween(Date startDate, Date endDate);

    List<CashFlow> findByCashBetween(double min, double max);

    List<CashFlow> findByCashFlowDescriptionContaining(String descripion);

    List<CashFlow> findByCashFlowGroup(int group);

    List<CashFlow> findByCreationDateBetweenAndCashBetweenAndCashFlowDescriptionContaining(
            Date startDate, Date endDate, double min, double max, String descripion);
    List<CashFlow> findByCreationDateBetweenAndCashBetweenAndCashFlowDescriptionContainingAndCashFlowGroup(
            Date startDate, Date endDate, double min, double max, String descripion, int group);
}