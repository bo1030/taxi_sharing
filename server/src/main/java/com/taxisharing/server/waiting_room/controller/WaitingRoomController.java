package com.taxisharing.server.waiting_room.controller;

import com.taxisharing.server.waiting_room.dto.ListRequest;
import com.taxisharing.server.waiting_room.dto.ListResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/waiting-room")
public class WaitingRoomController {

    @GetMapping()
    ResponseEntity<ListResponse> list(@RequestParam(required = false) ListRequest listRequest) {
        String result = "";
        return ResponseEntity.ok(new ListResponse(result));
    }
}
