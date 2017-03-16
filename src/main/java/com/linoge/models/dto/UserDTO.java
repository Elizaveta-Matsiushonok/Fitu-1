package com.linoge.models.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by Tim on 08.01.2017.
 */
@Data
@Builder
public class UserDTO {
    public Long id;
    public String username;
    public List<String> authorities;
}
