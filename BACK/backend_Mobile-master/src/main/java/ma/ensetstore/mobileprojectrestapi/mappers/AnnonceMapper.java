package ma.ensetstore.mobileprojectrestapi.mappers;

import ma.ensetstore.mobileprojectrestapi.dtos.AnnonceDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Annonce;
import org.springframework.beans.BeanUtils;

public class AnnonceMapper {
    public static AnnonceDTO fromAnnonce(Annonce annonce) {
        AnnonceDTO annonceDTO = new AnnonceDTO();
        BeanUtils.copyProperties(annonce, annonceDTO);
        return annonceDTO;
    }
    public static Annonce fromAnnonceDTO(AnnonceDTO annonceDTO) {
        Annonce annonce = new Annonce();
        BeanUtils.copyProperties(annonceDTO, annonce);
        return annonce;
    }
}
