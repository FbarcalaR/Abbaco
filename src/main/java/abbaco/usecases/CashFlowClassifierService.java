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
        cashFlowClassifier.setCode((int) cashFlowClassifierRepository.count());
        return cashFlowClassifierRepository.save(cashFlowClassifier);
    }

    public void delete(Long id){
        cashFlowClassifierRepository.deleteById(id);
    }
}