package com.taxisharing.server.user.service;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.user.domain.Ban;
import com.taxisharing.server.user.domain.MannerRecord;
import com.taxisharing.server.user.domain.User;
import com.taxisharing.server.user.dto.*;
import com.taxisharing.server.user.exception.AlreadyEvaluateException;
import com.taxisharing.server.user.exception.UserNotFoundException;
import com.taxisharing.server.user.repository.MannerRepository;
import com.taxisharing.server.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final MannerRepository mannerRepository;
    public final AuthenticationService authenticationService;

    @Transactional(readOnly = true)
    public SignUpResponse signUp(SignUpRequest signUpRequest)
    {
        User user = signUpRequest.toUser();
        User savedUser = userRepository.save(user);
        return new SignUpResponse(authenticationService.createToken(savedUser));
    }

    public boolean isSignUp(String userName)
    {
        return userRepository.existsByUsername(userName);
    }

    @Transactional(readOnly = true)
    public EvaluateMannerResponse evaluateManner(int targetId, EvaluateMannerRequest evaluateMannerRequest)
    {
        if(mannerRepository.existsByUser_IdAndTarget_Id(evaluateMannerRequest.getUid(), targetId))
        {
            throw new AlreadyEvaluateException();
        }

        User target = findUser(targetId);
        User user = findUser(evaluateMannerRequest.getUid());
        MannerRecord mannerRecord = new MannerRecord(evaluateMannerRequest.getScore());

        user.addTargetRecord(mannerRecord);
        target.addEvaluateRecord(mannerRecord);
        mannerRepository.save(mannerRecord);
        target.setMeanScore();
        User saveTarget = userRepository.save(target);

        return new EvaluateMannerResponse(saveTarget.getManner());
    }

    @Transactional(readOnly = true)
    public User findUser(int id)
    {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Transactional(readOnly = true)
    public UserBanResponse userBan(int uid, UserBanRequest userBanRequest)
    {
        User user = userRepository.findById(uid).orElseThrow(UserNotFoundException::new);
        User target = userRepository.findById(userBanRequest.getTargetId()).orElseThrow(UserNotFoundException::new);
        user.addBan(target);
        userRepository.save(user);
        return new UserBanResponse(user.getBanList());
    }

    @Transactional(readOnly = true)
    public BanListResponse getBanList(int uid)
    {
        User user = userRepository.findById(uid).orElseThrow(UserNotFoundException::new);
        return new BanListResponse(user.getBanList());
    }
}
