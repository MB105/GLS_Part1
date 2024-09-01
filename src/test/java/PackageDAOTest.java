import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class PackageDAOTest {

    private static PackageDAO packageDAO;
    private static EntityManagerFactory emfTest;
    private static EntityManager emt;


    @BeforeAll
    static void setUpAll() {
        emfTest = HibernateConfig.getEntityManagerFactoryTest();
        //packageDAO= PackageDAO.getInstance(emfTest);
    }

    @BeforeEach
    void setUp() {
        emt = emfTest.createEntityManager();
        packageDAO = new PackageDaoImp(emt);
    }

    @AfterAll
    public static void tearDown() {
        emt.close();
    }

    @Test
    public void testPersistPackage() {
        Package pkg = new Package();
        pkg.setTrackingNumber("ABC123");
        pkg.setSenderName("Sender");
        pkg.setReceiverName("Receiver");
        pkg.setDeliveryStatus(DeliveryStatus.PENDING);

        packageDAO.persistPackage(pkg);

        emt = emfTest.createEntityManager();
        // Retrieve the package from the database and assert its existence
        Package retrievedPackage = emt.find(Package.class, pkg.getID());
        Assertions.assertNotNull(retrievedPackage);
        Assertions.assertEquals("ABC123", retrievedPackage.getTrackingNumber());
    }

}