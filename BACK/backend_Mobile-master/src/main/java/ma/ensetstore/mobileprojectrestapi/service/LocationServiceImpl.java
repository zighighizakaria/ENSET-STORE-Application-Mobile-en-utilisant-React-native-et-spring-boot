package ma.ensetstore.mobileprojectrestapi.service;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Location;
import ma.ensetstore.mobileprojectrestapi.exceptions.LocationException;
import ma.ensetstore.mobileprojectrestapi.mappers.LocationMapper;
import ma.ensetstore.mobileprojectrestapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;
    private final AnnonceService annonceService;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository, AnnonceService annonceService) {
        this.locationRepository = locationRepository;
        this.annonceService = annonceService;
    }

    @Override
    public List<LocationDTO> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream()
                .map(LocationMapper::fromLocation)
                .collect(Collectors.toList());
    }

    @Override
    public LocationDTO getLocationById(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationException("Location not found with id: " + id));
        return LocationMapper.fromLocation(location);
    }
    @Override
    public LocationDTO saveLocation(LocationDTO locationDTO) {
        Location location = LocationMapper.fromLocationDTO(locationDTO);
        Location savedLocation = locationRepository.save(location);
        return LocationMapper.fromLocation(savedLocation);
    }
    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
    @Override
    public List<AnnonceDTO> getAnnoncesByLocation(LocationDTO locationDTO) {
        Location location = LocationMapper.fromLocationDTO(locationDTO);
        return annonceService.getAnnoncesByLocation(locationDTO);
    }
}

