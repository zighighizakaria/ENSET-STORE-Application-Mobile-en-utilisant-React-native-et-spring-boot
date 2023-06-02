package ma.ensetstore.mobileprojectrestapi.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.ensetstore.mobileprojectrestapi.enums.Progress;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String image;
    private String price;
    private String phone;
    private String title;
    private String category;
    private String about;
    @Enumerated(EnumType.STRING)
    private Progress progress;
    @OneToOne(cascade = CascadeType.ALL)
    private Location location;
    @ManyToOne
    private User user;

}