package ma.ensetstore.mobileprojectrestapi.controller;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
import ma.ensetstore.mobileprojectrestapi.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonce")
public class AnnonceController {
    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public ResponseEntity<List<AnnonceDTO>> getAllAnnonces() {
        List<AnnonceDTO> annonces = annonceService.getAllAnnonces();
        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnonceDTO> getAnnonceById(@PathVariable Long id) {
        AnnonceDTO annonce = annonceService.getAnnonceById(id);
        return ResponseEntity.ok(annonce);
    }

    @PostMapping
    public ResponseEntity<AnnonceDTO> saveAnnonce(@RequestBody AnnonceDTO annonceDTO) {
        AnnonceDTO savedAnnonce = annonceService.saveAnnonce(annonceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAnnonce);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AnnonceDTO>> getAnnoncesByUser(@PathVariable Long userId) {
        List<AnnonceDTO> annonces = annonceService.getAnnoncesByUser(userId);
        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/categorie/{categorie}")
    public ResponseEntity<List<AnnonceDTO>> getAnnoncesByCategorie(@PathVariable String categorie) {
        List<AnnonceDTO> annonces = annonceService.getAnnoncesByCategorie(categorie);
        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/progress/{progress}")
    public ResponseEntity<List<AnnonceDTO>> getAnnoncesByProgress(@PathVariable Progress progress) {
        List<AnnonceDTO> annonces = annonceService.getAnnoncesByProgress(progress);
        return ResponseEntity.ok(annonces);
    }

    @GetMapping("/user/{userId}/annonces")
    public ResponseEntity<List<AnnonceDTO>> getUserAnnonces(@PathVariable Long userId) {
        List<AnnonceDTO> annonces = annonceService.getUserAnnonces(userId);
        return ResponseEntity.ok(annonces);
    }

    @PostMapping("/user/{userId}/annonces")
    public ResponseEntity<AnnonceDTO> addUserAnnonce(@PathVariable Long userId, @RequestBody AnnonceDTO annonceDTO) {
        AnnonceDTO addedAnnonce = annonceService.addUserAnnonce(userId, annonceDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedAnnonce);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnonceDTO> updateAnnonce(@PathVariable Long id, @RequestBody AnnonceDTO annonceDTO) {
        annonceDTO.setId(id);
        AnnonceDTO updatedAnnonce = annonceService.updateAnnonce(annonceDTO);
        return ResponseEntity.ok(updatedAnnonce);
    }
}
