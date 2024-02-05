package com.kdu.smartHome.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDeviceRequest {

    private String houseId;

    private String roomId;

    private String kickstonId;


}

