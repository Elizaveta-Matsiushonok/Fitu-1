package com.linoge.models.shared;

import lombok.Builder;
import lombok.Data;

/**
 * Created by Timo on 12.01.2017.
 */
@Data
@Builder
public final class Job {
    private String organisation;
    private String position;
    private String dateBegin;
    private String dateEnd;
}
