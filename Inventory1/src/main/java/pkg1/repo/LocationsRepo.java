package pkg1.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import pkg1.entity.LocationsEntity;

public interface LocationsRepo extends JpaRepository<LocationsEntity, Long>{

}
