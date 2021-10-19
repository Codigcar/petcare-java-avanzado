package com.upc.edu.pe.petcare.controller;

import com.upc.edu.pe.petcare.dto.PersonProfileRequest;
import com.upc.edu.pe.petcare.dto.ProductTypeRequest;
import com.upc.edu.pe.petcare.dto.response.PersonProfileResponse;
import com.upc.edu.pe.petcare.dto.response.ProductTypeResponse;
import com.upc.edu.pe.petcare.model.PersonProfile;
import com.upc.edu.pe.petcare.model.ProductType;
import com.upc.edu.pe.petcare.service.PersonProfileService;
import com.upc.edu.pe.petcare.service.ProductTypeService;
import com.upc.edu.pe.petcare.util.AccountConverter;
import com.upc.edu.pe.petcare.util.PersonProfileConverter;
import com.upc.edu.pe.petcare.util.ProductTypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productTypes")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ProductTypeConverter productTypeConverter;

    @GetMapping()
    public ResponseEntity<List<ProductTypeResponse>> getAll() throws Exception{
        List<ProductType> list = productTypeService.getAll();
        return new ResponseEntity<>(productTypeConverter.convertListEntityToDTO(list), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProductTypeResponse> create(@Valid @RequestBody ProductTypeRequest requestModel) throws Exception{
        ProductType newModel = productTypeService
                .create(productTypeConverter.convertDTOToEntity(requestModel));
        return new ResponseEntity<>(productTypeConverter.convertEntityToDTO(newModel), HttpStatus.CREATED);
    }
}
