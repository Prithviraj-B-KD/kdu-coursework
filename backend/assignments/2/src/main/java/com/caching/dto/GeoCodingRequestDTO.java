package com.caching.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GeoCodingRequestDTO {
    private String address;
}
