package com.taxisharing.server.waiting_room.controller;

import com.taxisharing.server.waiting_room.dto.WaitingRoomListRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListResponse;
import com.taxisharing.server.waiting_room.service.WaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/waiting-room")
public class WaitingRoomController {

    @GetMapping()
    ResponseEntity<WaitingRoomListResponse> waitingRoomList(@ModelAttribute WaitingRoomListRequest waitingRoomListRequest) {
        return ResponseEntity.ok(waitingRoomService.getWaitingRoomList(waitingRoomListRequest));
    }
}
