import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateConfig {

    private static EntityManagerFactory emfTest = Persistence.createEntityManagerFactory("myPersistenceUnitTest");

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public static EntityManagerFactory getEntityManagerFactoryTest() {

        return emfTest;
    }
    public static EntityManagerFactory getEntityManagerFactory() {

        return emf;
    }


}
