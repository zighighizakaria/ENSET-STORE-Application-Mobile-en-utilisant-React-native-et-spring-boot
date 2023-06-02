package ma.ensetstore.mobileprojectrestapi.service;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import ma.ensetstore.mobileprojectrestapi.entities.User;
import ma.ensetstore.mobileprojectrestapi.exceptions.UserException;
import ma.ensetstore.mobileprojectrestapi.mappers.AnnonceMapper;
import ma.ensetstore.mobileprojectrestapi.mappers.UserMapper;
import ma.ensetstore.mobileprojectrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper::fromUser)
                .collect(Collectors.toList());
    }
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with id: " + id));
        return UserMapper.fromUser(user);
    }
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.fromUserDTO(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.fromUser(savedUser);
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public List<AnnonceDTO> getUserAnnonces(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));
        return user.getAnnonces().stream()
                .map(AnnonceMapper::fromAnnonce)
                .collect(Collectors.toList());
    }
    @Override
    public boolean isEmailUnique(String email) {
        User existingUser = userRepository.findByEmail(email);
        return existingUser == null;
    }
    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserException("User not found with email: " + email);
        }
        return UserMapper.fromUser(user);
    }
    @Override
    public boolean isUserAnnonceOwner(Long userId, Long annonceId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException("User not found with id: " + userId));
        return user.getAnnonces().stream()
                .anyMatch(annonce -> annonce.getId().equals(annonceId));
    }

}
