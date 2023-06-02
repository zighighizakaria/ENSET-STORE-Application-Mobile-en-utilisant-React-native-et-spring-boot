package ma.ensetstore.mobileprojectrestapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocation;
    private double lat;
    private double lon;
}
