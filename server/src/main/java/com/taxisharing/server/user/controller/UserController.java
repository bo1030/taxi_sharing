package com.taxisharing.server.user.controller;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.auth.util.AuthorizationExtractor;
import com.taxisharing.server.user.dto.*;
import com.taxisharing.server.user.exception.DuplicatedUsernameException;
import com.taxisharing.server.user.exception.SignUpRequestException;
import com.taxisharing.server.user.exception.UserBanException;
import com.taxisharing.server.user.repository.UserRepository;
import com.taxisharing.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.BulkInsertionCapableIdentifierGenerator;
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
    ResponseEntity<IdDuplicateResponse> idDuplicateCheck(@ModelAttribute IdDuplicateRequest idDuplicateRequest, BindingResult result)
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

    @PostMapping("/{UID}")
    ResponseEntity<EvaluateMannerResponse> evaluateManner(@PathVariable("UID") int targetId, @RequestBody EvaluateMannerRequest evaluateMannerRequest)
    {
        return ResponseEntity.ok(userService.evaluateManner(targetId,evaluateMannerRequest));
    }

    @GetMapping("/ban")
    ResponseEntity<BanListResponse> banList(@RequestAttribute int uid)
    {
        return ResponseEntity.ok(userService.getBanList(uid));
    }

    @PostMapping("/ban")
    ResponseEntity<UserBanResponse> userBan(@RequestAttribute int uid, @Valid @RequestBody UserBanRequest userBanRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new UserBanException();
        }
        return ResponseEntity.ok(userService.userBan(uid ,userBanRequest));
    }
}
