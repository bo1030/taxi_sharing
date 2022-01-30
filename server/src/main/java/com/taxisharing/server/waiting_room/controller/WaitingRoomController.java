package com.taxisharing.server.waiting_room.controller;

import com.taxisharing.server.waiting_room.dto.ListRequest;
import com.taxisharing.server.waiting_room.dto.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/waiting-room")
public class WaitingRoomController {

    @GetMapping()
    ResponseEntity<ListResponse> list(@ModelAttribute ListRequest listRequest) {
        String result = listRequest.toString();
        return ResponseEntity.ok(new ListResponse(result));
    }
}
