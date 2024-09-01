import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        PackageDAO packageDAO=new PackageDaoImp(em);


        Package pack = new Package();
        pack.setDeliveryStatus(DeliveryStatus.PENDING);
        pack.setSenderName("John");
        pack.setReceiverName("Smith");
        pack.setTrackingNumber("4");
        packageDAO.persistPackage(pack);

        Package pack1 =packageDAO.retrievePackageTrackingnumber("4");
        System.out.println(pack1);

    }

}