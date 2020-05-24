package abbaco.usecases;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abbaco.entities.models.CashFlow;
import abbaco.entities.repositories.CashFlowsRepository;

@Service
public class CashFlowService {
    
    @Autowired
    CashFlowsRepository cashFlowsRepository;

    public Iterable<CashFlow> getAll(){
        return cashFlowsRepository.findAll();
    }

    public Optional<CashFlow> getById(String id){
        return cashFlowsRepository.findById(id);
    }

    public CashFlow add(CashFlow cashFlow){
        return cashFlowsRepository.save(cashFlow);
    }

    public void delete(String id){
        cashFlowsRepository.deleteById(id);
    }
}