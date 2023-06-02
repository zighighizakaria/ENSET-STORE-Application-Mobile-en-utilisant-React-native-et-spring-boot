package ma.ensetstore.mobileprojectrestapi.repository;

import ma.ensetstore.mobileprojectrestapi.entities.Annonce;
import ma.ensetstore.mobileprojectrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

}

