package ma.ensetstore.mobileprojectrestapi.mappers;

import ma.ensetstore.mobileprojectrestapi.dtos.LocationDTO;
import ma.ensetstore.mobileprojectrestapi.entities.Location;
import org.springframework.beans.BeanUtils;

public class LocationMapper {
    public static LocationDTO fromLocation(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        BeanUtils.copyProperties(location, locationDTO);
        return locationDTO;
    }
    public static Location fromLocationDTO(LocationDTO locationDTO) {
        Location location = new Location();
        BeanUtils.copyProperties(locationDTO, location);
        return location;
    }
}
