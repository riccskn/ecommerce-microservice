package com.riccskn.repository;

import com.riccskn.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    Boolean existsByName(@NotBlank String name);

    Optional<ProductModel> findByName(@NotBlank String email);

}
