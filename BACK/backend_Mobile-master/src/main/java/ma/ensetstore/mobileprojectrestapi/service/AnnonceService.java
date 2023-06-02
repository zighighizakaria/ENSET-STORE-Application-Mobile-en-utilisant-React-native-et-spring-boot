package ma.ensetstore.mobileprojectrestapi.service;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Location;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnnonceService {
    List<AnnonceDTO> getAllAnnonces();

    AnnonceDTO getAnnonceById(Long id);

    AnnonceDTO saveAnnonce(AnnonceDTO annonceDTO);

    void deleteAnnonce(Long id);

    UserDTO getAnnonceUser(Long annonceId);

    // Other methods as needed

    List<AnnonceDTO> getAnnoncesByUser(Long userId);

    List<AnnonceDTO> getAnnoncesByCategorie(String categorie);

    List<AnnonceDTO> getAnnoncesByProgress(Progress progress);

    List<AnnonceDTO> getUserAnnonces(Long userId);

    AnnonceDTO addUserAnnonce(Long userId, AnnonceDTO annonceDTO);

    AnnonceDTO updateAnnonce(AnnonceDTO annonceDTO);


    List<AnnonceDTO> getAnnoncesByLocation(LocationDTO locationDTO);
}