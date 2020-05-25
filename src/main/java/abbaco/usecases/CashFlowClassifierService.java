package abbaco.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abbaco.entities.models.CashFlowClassifier;
import abbaco.entities.repositories.CashFlowClassifiersRepository;

@Service
public class CashFlowClassifierService {
    @Autowired
    CashFlowClassifiersRepository cashFlowClassifierRepository;

    public Iterable<CashFlowClassifier> getAll(){
        return cashFlowClassifierRepository.findAll();
    }

    public CashFlowClassifier add(CashFlowClassifier cashFlowClassifier){
        return cashFlowClassifierRepository.save(cashFlowClassifier);
    }

    public void delete(String id){
        cashFlowClassifierRepository.deleteById(id);
    }
}