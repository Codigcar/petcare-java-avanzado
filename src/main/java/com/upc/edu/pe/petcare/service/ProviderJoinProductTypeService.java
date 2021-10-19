package com.upc.edu.pe.petcare.service;

import com.upc.edu.pe.petcare.model.Account;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.ProviderJoinProductType;

public interface ProviderJoinProductTypeService extends CrudService<ProviderJoinProductType, Long> {
    ProviderJoinProductType registerByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception;


}
