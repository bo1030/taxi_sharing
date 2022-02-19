package com.taxisharing.server.waiting_room.controller;

import com.taxisharing.server.waiting_room.dto.WaitingRoomCreateRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomCreateResponse;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListRequest;
import com.taxisharing.server.waiting_room.dto.WaitingRoomListResponse;
import com.taxisharing.server.waiting_room.exception.CreateWaitingRoomException;
import com.taxisharing.server.waiting_room.exception.WaitingRoomListException;
import com.taxisharing.server.waiting_room.service.WaitingRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/waiting-room")
@RequiredArgsConstructor
public class WaitingRoomController {
    private final WaitingRoomService waitingRoomService;

    @GetMapping()
    ResponseEntity<WaitingRoomListResponse> waitingRoomList(@Valid @ModelAttribute WaitingRoomListRequest waitingRoomListRequest, BindingResult result) {
        if (result.hasErrors())
        {
            throw new WaitingRoomListException();
        }
        return ResponseEntity.ok(waitingRoomService.getWaitingRoomList(waitingRoomListRequest));
    }
    
    @PostMapping()
    ResponseEntity<WaitingRoomCreateResponse> createWaitingRoom(@RequestAttribute int uid, @Valid @RequestBody WaitingRoomCreateRequest createWaitingRoomRequest, BindingResult result)
    {
        if (result.hasErrors())
        {
            throw new CreateWaitingRoomException();
        }
        return ResponseEntity.ok(waitingRoomService.createWaitingRoom(uid, createWaitingRoomRequest));
    }


}
