package ma.ensetstore.mobileprojectrestapi.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnnonceDTO {
    private Long id;
    private String image;
    private String title;
    private String category;

    private String price;
    private String phone;
    private String about;
    private Progress progress;
    private LocationDTO location;
    private Long UserId;

}
