package com.linoge.dao;

import com.linoge.models.entities.AdmissionOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Timo on 03.03.2017.
 */
@Repository
public interface AdmissionOrderDAO extends JpaRepository<AdmissionOrder, Long>{
}
