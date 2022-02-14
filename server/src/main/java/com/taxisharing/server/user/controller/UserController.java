package com.taxisharing.server.user.controller;

import com.taxisharing.server.auth.dto.BasicUserInfo;
import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.user.dto.*;
import com.taxisharing.server.user.exception.*;
import com.taxisharing.server.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @PutMapping("/nickname")
    ResponseEntity<Void> upddateNickname(BasicUserInfo userInfo, @Valid @RequestBody NicknameRequest nicknameRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new NicknameValidationException();
        }
        userService.updateNickname(userInfo.getId(),nicknameRequest.getNickname());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/password")
    ResponseEntity<Void> updatePassword(BasicUserInfo userInfo, @Valid @RequestBody PasswordRequest passwordRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new PasswordValidationException();
        }
        userService.updatePassword(userInfo.getId(), passwordRequest.toHash());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/profile")
    ResponseEntity<ProfileResponse> updateProfile(BasicUserInfo userInfo, @RequestParam MultipartFile file)
    {
        return ResponseEntity.ok(userService.updateProfile(userInfo.getId(), file));
    }

    @PostMapping("/{UID}")
    ResponseEntity<EvaluateMannerResponse> evaluateManner(@PathVariable("UID") int targetId, @RequestBody EvaluateMannerRequest evaluateMannerRequest)
    {
        return ResponseEntity.ok(userService.evaluateManner(targetId,evaluateMannerRequest));
    }

    @GetMapping("/ban")
    ResponseEntity<BanListResponse> banList(BasicUserInfo userInfo)
    {
        return ResponseEntity.ok(userService.getBanList(userInfo.getId()));
    }

    @PostMapping("/ban")
    ResponseEntity<UserBanResponse> userBan(BasicUserInfo userInfo, @Valid @RequestBody UserBanRequest userBanRequest, BindingResult result)
    {
        if(result.hasErrors())
        {
            throw new UserBanException();
        }
        return ResponseEntity.ok(userService.userBan(userInfo.getId() ,userBanRequest));
    }
}
