package com.upc.edu.pe.petcare.util;

import java.util.List;
import java.util.Optional;

public interface IGenericConverter<M,MRQ,MRP> {
    M convertDTOToEntity(MRQ rq);
    MRP convertEntityToDTO(M entity);
    List<MRP> convertListEntityToDTO(List<M> models);
}
