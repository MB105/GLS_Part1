import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

public class PackageDaoImp implements PackageDAO {

    private EntityManager em;

    EntityManagerFactory emf=HibernateConfig.getEntityManagerFactory();

    public PackageDaoImp(EntityManager em) {
        this.em=em;
    }


    public void persistPackage(Package pack) {

        //EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(pack);
            em.getTransaction().commit();

        } finally {
            em.close();
        }


    }


    public Package retrievePackageTrackingnumber(String trackingNumber) {
        EntityManager em = emf.createEntityManager();
        try {
             return em.createQuery("SELECT pack FROM Package pack WHERE trackingNumber=:trackingNumber",Package.class)
            .setParameter("trackingNumber", trackingNumber)
                    .getSingleResult();
        }catch (NoResultException e) {
            System.out.println("No Package found with trackingNumber " + trackingNumber);
            return null;
        }finally{
            em.close();
        }
    }


            }


