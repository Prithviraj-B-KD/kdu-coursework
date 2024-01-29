package com.caching.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoCodingResponseDTO {
    private String latitude;
    private String longitude;
}
