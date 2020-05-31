package abbaco.entities.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import abbaco.entities.configuration.RandomIdGenerator;

@Entity
@Table(name = "cashflowsclassifiers")
public class CashFlowClassifier {
    @Id
    @GeneratedValue(generator = RandomIdGenerator.generatorName)
    @GenericGenerator(name = RandomIdGenerator.generatorName, strategy = "abbaco.entities.configuration.RandomIdGenerator")
    private Long id;
    private int code;
    private String name;

    public CashFlowClassifier(){}

    public CashFlowClassifier(Long id, int code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}