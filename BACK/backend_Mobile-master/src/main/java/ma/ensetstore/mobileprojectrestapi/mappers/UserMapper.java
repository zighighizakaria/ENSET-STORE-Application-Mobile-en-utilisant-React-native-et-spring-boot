package ma.ensetstore.mobileprojectrestapi.mappers;

import ma.ensetstore.mobileprojectrestapi.dtos.UserDTO;
import ma.ensetstore.mobileprojectrestapi.entities.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {
    public static UserDTO fromUser(User user) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    public static User fromUserDTO(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return user;
    }
}
