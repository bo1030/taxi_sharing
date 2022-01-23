package com.taxisharing.server.chat.controller;

import com.taxisharing.server.chat.dto.*;
import com.taxisharing.server.chat.exception.InvalidChatRoomOption;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/open-chatting")
public class ChatController {
    @GetMapping()
    ResponseEntity<ChatRoomListResponse> chatRoomList(@Valid @RequestParam ChatRoomListRequest chatRoomListRequest, BindingResult result){
        if(result.hasErrors()){
            throw new InvalidChatRoomOption();
        }
        return ResponseEntity.ok(null/*new ChatRoomListResponse()*/);
    }

    @PostMapping()
    ResponseEntity<MakeChatRoomResponse> makeChatRoom(){
        return null;
    }

    @GetMapping("/{crid}")
    ResponseEntity<ChatRoomInfoResponse> chatRoomInfo(@PathVariable("crid")int crid){
        return null;
    }

    @PostMapping("/{crid}")
    ResponseEntity<EnterChatRoomResponse> enterChatRoom(@PathVariable("crid")int crid) {
        return null;
    }

    @PutMapping("/{crid}")
    ResponseEntity<String> modifyChatInfo(@PathVariable("crid")int crid){
        return null;
    }

    @DeleteMapping("/{crid}")
    ResponseEntity<String> deleteChatRoom(@PathVariable("crid")int crid){
        return null;
    }

    @GetMapping("/{crid}/chatting")
    ResponseEntity<String> chattingList(@PathVariable("crid")int crid){
        return null;
    }

    @PostMapping("/{crid}/chatting")
    ResponseEntity<String> writeChatting(@PathVariable("crid")int crid){
        return null;
    }

    @DeleteMapping("/{crid}/chatting")
    ResponseEntity<String> deleteChatting(@PathVariable("crid")int crid){
        return null;
    }

    @GetMapping("/{crid}/chatting/count")
    ResponseEntity<String> getChatCount(@PathVariable("crid")int crid){
        return null;
    }

    @PutMapping("/{crid}/chatting/count")
    ResponseEntity<String> modifyChatCount(@PathVariable("crid")int crid){
        return null;
    }
}
