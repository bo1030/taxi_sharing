package com.taxisharing.server.user.controller;

import com.taxisharing.server.user.dto.IdDuplicateResponse;
import com.taxisharing.server.user.dto.SignUpRequest;
import com.taxisharing.server.user.dto.SignUpResponse;
import com.taxisharing.server.user.exception.DuplicatedUsernameException;
import com.taxisharing.server.user.exception.SignUpRequestException;
import com.taxisharing.server.user.repository.UserRepository;
import com.taxisharing.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping()
    ResponseEntity<IdDuplicateResponse> idDuplicateCheck(@RequestParam("username") String username)
    {
        if(!userRepository.existsByUsername(username))
        {
            throw new DuplicatedUsernameException();
        }
        return ResponseEntity.ok(new IdDuplicateResponse(true));
    }

    @PostMapping()
    ResponseEntity<SignUpResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new SignUpRequestException();
        }
        return ResponseEntity.ok(userService.signUp(signUpRequest));
    }
}
