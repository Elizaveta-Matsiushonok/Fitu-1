package com.linoge.dao;

import com.linoge.models.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Timo on 31.01.2017.
 */
@Repository
public interface OrganisationDAO extends JpaRepository<Organisation, Long>{
}
