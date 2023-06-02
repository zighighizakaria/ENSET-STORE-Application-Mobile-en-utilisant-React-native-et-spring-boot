package ma.ensetstore.mobileprojectrestapi.repository;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Annonce;
import ma.ensetstore.mobileprojectrestapi.entities.Location;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Long> {

    List<Annonce> findByProgress(Progress progress);

    List<Annonce> findByLocation(Location location);

    List<Annonce> findByCategory(String categorie);
}
