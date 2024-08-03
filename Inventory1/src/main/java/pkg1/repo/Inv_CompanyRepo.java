package pkg1.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import pkg1.entity.Inv_CompanyEntity;

public interface Inv_CompanyRepo extends JpaRepository<Inv_CompanyEntity,Long>{

}
