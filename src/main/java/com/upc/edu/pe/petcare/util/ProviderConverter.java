package com.upc.edu.pe.petcare.util;

import com.upc.edu.pe.petcare.dto.ProviderRequest;
import com.upc.edu.pe.petcare.dto.response.ProviderResponse;
import com.upc.edu.pe.petcare.model.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProviderConverter {
    @Autowired
    private ModelMapper modelMapper;



    public Provider convertDTOToEntity(ProviderRequest providerRequest){
        return modelMapper.map(providerRequest, Provider.class);
    }

    public ProviderResponse convertEntityToDTO(Provider entity){
        return modelMapper.map(entity, ProviderResponse.class);
    }

    public List<ProviderResponse> convertListEntityToDTO(List<Provider> providers){
        return providers
                .stream()
                .map(mapEntity -> convertEntityToDTO(mapEntity)).collect(Collectors.toList());
    }
}
