package ma.ensetstore.mobileprojectrestapi.service;


import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long id);
    List<AnnonceDTO> getUserAnnonces(Long userId);
    boolean isEmailUnique(String email);
    UserDTO getUserByEmail(String email);
    boolean isUserAnnonceOwner(Long userId, Long annonceId);
}
