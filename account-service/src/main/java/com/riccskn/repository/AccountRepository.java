package com.riccskn.repository;

import com.riccskn.model.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository  extends JpaRepository<AccountModel,Long> {

    Optional<AccountModel> findByUsername(String username);

    Boolean existsByUsername(String username);

    void deleteByUsername(String username);

}
