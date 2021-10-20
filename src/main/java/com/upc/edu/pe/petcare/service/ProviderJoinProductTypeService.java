package com.upc.edu.pe.petcare.service;

import com.upc.edu.pe.petcare.model.ProviderJoinProduct;

public interface ProviderJoinProductTypeService extends CrudService<ProviderJoinProduct, Long> {
    ProviderJoinProduct registerByProviderIdAndProductTypeId(Long providerId, Long productTypeId) throws Exception;


}
