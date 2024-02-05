package com.kdu.smartHome.DTO;


import com.kdu.smartHome.entity.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddRoomResponse {
    private String message;
    private Room room;
    private HttpStatus status;
}
