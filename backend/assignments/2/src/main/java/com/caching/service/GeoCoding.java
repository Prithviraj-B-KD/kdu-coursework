package com.caching.service;


import com.caching.dto.GeoCodingRequestDTO;
import com.caching.dto.GeoCodingResponseDTO;
import com.caching.dto.ReverseGeoCodingRequestDTO;
import com.caching.dto.ReverseGeoCodingResponseDTO;

public interface GeoCoding {
    public GeoCodingResponseDTO getGeoCoding(GeoCodingRequestDTO requestDTO);
    public ReverseGeoCodingResponseDTO getReverseGeoCoding(ReverseGeoCodingRequestDTO requestDTO);
}
