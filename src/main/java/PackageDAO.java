import jakarta.persistence.EntityManagerFactory;

public interface PackageDAO {



    void persistPackage(Package pack);

    Package retrievePackageTrackingnumber (String trackingNumber);
}
