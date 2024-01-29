package com.caching.controller;


import com.caching.dto.GeoCodingRequestDTO;
import com.caching.dto.GeoCodingResponseDTO;
import com.caching.dto.ReverseGeoCodingRequestDTO;
import com.caching.dto.ReverseGeoCodingResponseDTO;
import com.caching.service.GeoCodingImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping
public class GeoCodingController {
    private final GeoCodingImp geoCodingService;

    @Autowired
    public GeoCodingController(GeoCodingImp geoCodingService){
        this.geoCodingService = geoCodingService;
    }
    /**
     * Performs forward geocoding to retrieve geographic coordinates for a given address.
     *
     * @param address The address to geocode.
     * @return A {@link ResponseEntity} containing the geocoding results as a {@link GeoCodingResponseDTO}.
     */
    @GetMapping("/geocoding")
    public ResponseEntity<GeoCodingResponseDTO> forwardGeoCoding(@RequestParam("address") String address) {
        log.info(address);
        GeoCodingRequestDTO requestDTO = GeoCodingRequestDTO.builder()
                .address(address)
                .build();
        return ResponseEntity.ok(geoCodingService.getGeoCoding(requestDTO));
    }
    /**
     * Performs reverse geocoding to retrieve an address for given geographic coordinates.
     *
     * @param latitude  The latitude of the location.
     * @param longitude The longitude of the location.
     * @return A {@link ResponseEntity} containing the reverse geocoding results as a {@link ReverseGeoCodingResponseDTO}.
     */
    @GetMapping("/reverse-geocoding")
    public ResponseEntity<ReverseGeoCodingResponseDTO> reverseGeoCoding(@RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude){
        ReverseGeoCodingRequestDTO requestDTO = ReverseGeoCodingRequestDTO.builder()
                .latitude(latitude)
                .longitude(longitude)
                .build();
        return ResponseEntity.ok(geoCodingService.getReverseGeoCoding(requestDTO));
    }
}
