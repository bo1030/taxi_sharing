package com.taxisharing.server.user.controller;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.auth.util.AuthorizationExtractor;
import com.taxisharing.server.user.dto.*;
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
    private final AuthenticationService authenticationService;

    @GetMapping()
    ResponseEntity<IdDuplicateResponse> idDuplicateCheck(@Valid @RequestParam("username") IdDuplicateRequest idDuplicateRequest, BindingResult result)
    {
        if(result.hasErrors() || userService.isSignUp(idDuplicateRequest.getUsername()))
        {
            throw new DuplicatedUsernameException();
        }
        return ResponseEntity.ok(new IdDuplicateResponse("이 ID는 사용가능합니다."));
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

    @GetMapping("/{UID}")


    @PostMapping("/{UID}")
    ResponseEntity<EvaluateMannerResponse> evaluateManner(@PathVariable("UID") int targetId, @RequestBody EvaluateMannerRequest evaluateMannerRequest)
    {
        return ResponseEntity.ok(userService.evaluateManner(targetId,evaluateMannerRequest));
    }
}
