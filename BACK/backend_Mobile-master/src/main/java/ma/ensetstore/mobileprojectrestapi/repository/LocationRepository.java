package ma.ensetstore.mobileprojectrestapi.repository;

import ma.ensetstore.mobileprojectrestapi.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {
}
