package com.upc.edu.pe.petcare.repository;

import com.upc.edu.pe.petcare.model.Pet;
import com.upc.edu.pe.petcare.model.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends GenericRepository<Product, Long> {
    @Query("select p from Product p where p.provider.id =?1 and p.productType.id =?2")
    List<Product> getProductByProviderIdAndProductTypeId(Long productId, Long productTypeId);
//    @Query("select a from Account  a where a.email = ?1 and a.password=?2")

}
