package abbaco.entities.configuration;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class RandomIdGenerator implements IdentifierGenerator {

    public static final String generatorName = "RandomIdGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        long leftLimit = 0L;
        long rightLimit = 9007199254740990L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }
}