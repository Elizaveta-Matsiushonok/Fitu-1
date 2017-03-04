package com.linoge.servicies;

import com.linoge.models.dto.LectorDTO;

/**
 * Created by Timo on 10.02.2017.
 */
public interface LectorService {
    void createLectorFromDTO(LectorDTO lector);

    void updateLectorFromDTO(LectorDTO lector);
}
