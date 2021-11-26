package com.upc.edu.pe.petcare.util;


import com.google.common.reflect.TypeToken;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericConverter<M, MRQ, MRP> implements IGenericConverter<M, MRQ, MRP> {

    @Autowired
    private ModelMapper modelMapper;

/*
    public Object convert(Object object,Class<?> type) {

        Object MapperObject=modelMapper.map(object, type);

        return MapperObject;

    }
    */
@Override
    public M convertDTOToEntity(MRQ rq) {
        Type model = new com.google.gson.reflect.TypeToken<M>() {}.getType();
        return modelMapper.map(rq, model);

    }
    @Override
    public MRP convertEntityToDTO(M entity) {
        Type dto = new com.google.gson.reflect.TypeToken<MRP>() {}.getType();
        return modelMapper.map(entity, dto);
    }
    @Override
    public List<MRP> convertListEntityToDTO(List<M> models) {
        return models.stream().map(mapEntity -> convertEntityToDTO(mapEntity)).collect(Collectors.toList());
    }

}
