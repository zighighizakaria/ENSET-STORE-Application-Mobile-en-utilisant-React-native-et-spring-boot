package ma.ensetstore.mobileprojectrestapi.controller;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import ma.ensetstore.mobileprojectrestapi.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {
    private final LocationService locationService;
    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }
    @GetMapping
    public ResponseEntity<List<LocationDTO>> getAllLocations() {
        List<LocationDTO> locations = locationService.getAllLocations();
        return ResponseEntity.ok(locations);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LocationDTO> getLocationById(@PathVariable("id") Long id) {
        LocationDTO location = locationService.getLocationById(id);
        return ResponseEntity.ok(location);
    }
    @PostMapping
    public ResponseEntity<LocationDTO> saveLocation(@RequestBody LocationDTO locationDTO) {
        LocationDTO savedLocation = locationService.saveLocation(locationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable("id") Long id) {
        locationService.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/annonces")
    public ResponseEntity<List<AnnonceDTO>> getAnnoncesByLocation(@PathVariable("id") Long id) {
        LocationDTO location = locationService.getLocationById(id);
        List<AnnonceDTO> annonces = locationService.getAnnoncesByLocation(location);
        return ResponseEntity.ok(annonces);
    }
}

