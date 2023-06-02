package ma.ensetstore.mobileprojectrestapi.service;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Annonce;
import ma.ensetstore.mobileprojectrestapi.entities.Location;
import ma.ensetstore.mobileprojectrestapi.entities.User;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
import ma.ensetstore.mobileprojectrestapi.exceptions.AnnonceException;
import ma.ensetstore.mobileprojectrestapi.exceptions.UserException;
import ma.ensetstore.mobileprojectrestapi.mappers.AnnonceMapper;
import ma.ensetstore.mobileprojectrestapi.mappers.LocationMapper;
import ma.ensetstore.mobileprojectrestapi.mappers.UserMapper;
import ma.ensetstore.mobileprojectrestapi.repository.AnnonceRepository;
import ma.ensetstore.mobileprojectrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnonceServiceImpl implements AnnonceService {
    private final AnnonceRepository annonceRepository;
    private final UserService userService;
    private final UserRepository userRepository;


    @Autowired
    public AnnonceServiceImpl(AnnonceRepository annonceRepository, UserService userService,UserRepository userRepository) {
        this.annonceRepository = annonceRepository;
        this.userService = userService;
        this.userRepository=userRepository;
    }

    @Override
    public List<AnnonceDTO> getAllAnnonces() {
        List<Annonce> annonces = annonceRepository.findAll();
        return annonces.stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }

    @Override
    public AnnonceDTO getAnnonceById(Long id) {
        Annonce annonce = annonceRepository.findById(id)
                .orElseThrow(() -> new AnnonceException("Annonce not found with id: " + id));
        return AnnonceMapper.fromAnnonce(annonce);
    }

    @Override
    public AnnonceDTO saveAnnonce(AnnonceDTO annonceDTO) {
        Annonce annonce = AnnonceMapper.fromAnnonceDTO(annonceDTO);
        Annonce savedAnnonce = annonceRepository.save(annonce);
        return AnnonceMapper.fromAnnonce(savedAnnonce);
    }

    @Override
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }
    @Override
    public UserDTO getAnnonceUser(Long annonceId) {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElseThrow(() -> new AnnonceException("Annonce not found with id: " + annonceId));
        User user = annonce.getUser();
        if (user == null) {
            throw new UserException("User not found for the annonce with id: " + annonceId);
        }
        return UserMapper.fromUser(user);
    }
    @Override
    public List<AnnonceDTO> getAnnoncesByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));
        List<Annonce> annonces = user.getAnnonces();
        return annonces.stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }
    @Override
    public List<AnnonceDTO> getAnnoncesByCategorie(String categorie) {
        List<Annonce> annonces = annonceRepository.findByCategory(categorie);
        return annonces.stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }
    @Override
    public List<AnnonceDTO> getAnnoncesByProgress(Progress progress) {
        List<Annonce> annonces = annonceRepository.findByProgress(progress);
        return annonces.stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }
    @Override
    public List<AnnonceDTO> getUserAnnonces(Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return userDTO.getAnnonces();
    }
    @Override
    public AnnonceDTO addUserAnnonce(Long userId, AnnonceDTO annonceDTO) {
        UserDTO userDTO = userService.getUserById(userId);
        annonceDTO.setUserId(userDTO.getId());
        return saveAnnonce(annonceDTO);
    }

    @Override
    public AnnonceDTO updateAnnonce(AnnonceDTO annonceDTO) {
        Annonce existingAnnonce = annonceRepository.findById(annonceDTO.getId())
                .orElseThrow(() -> new AnnonceException("Annonce not found with id: " + annonceDTO.getId()));

        existingAnnonce.setTitle(annonceDTO.getTitle());
        existingAnnonce.setImage(annonceDTO.getImage());
        existingAnnonce.setCategory(annonceDTO.getCategory());
        existingAnnonce.setLocation(LocationMapper.fromLocationDTO(annonceDTO.getLocation()));
        existingAnnonce.setProgress(annonceDTO.getProgress());

        Annonce updatedAnnonce = annonceRepository.save(existingAnnonce);
        return AnnonceMapper.fromAnnonce(updatedAnnonce);
    }

    @Override
    public List<AnnonceDTO> getAnnoncesByLocation(LocationDTO locationDTO) {
        Location location = LocationMapper.fromLocationDTO(locationDTO);
        List<Annonce> annonces = annonceRepository.findByLocation(location);
        return annonces.stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }

}
