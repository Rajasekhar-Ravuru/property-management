package com.mycompany.property.management.service;

import com.mycompany.property.management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateFullProperty(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyTitle(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, Long propertyId);

//    PropertyDTO updatePropertyOwnerName(PropertyDTO propertyDTO, Long propertyId);
//    PropertyDTO updatePropertyOwnerEmail(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePropertyAddress(PropertyDTO propertyDTO, Long propertyId);
    void deleteProperty(Long propertyId);

}
