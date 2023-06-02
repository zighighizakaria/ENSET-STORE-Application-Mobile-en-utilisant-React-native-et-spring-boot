package ma.ensetstore.mobileprojectrestapi.service;

import lombok.Data;
import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LocationService {
    List<LocationDTO> getAllLocations();
    LocationDTO getLocationById(Long id);
    LocationDTO saveLocation(LocationDTO locationDTO);
    void deleteLocation(Long id);
    List<AnnonceDTO> getAnnoncesByLocation(LocationDTO locationDTO);
}
