package com.taxisharing.server.user.service;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.user.domain.MannerRecord;
import com.taxisharing.server.user.domain.User;
import com.taxisharing.server.user.dto.EvaluateMannerRequest;
import com.taxisharing.server.user.dto.EvaluateMannerResponse;
import com.taxisharing.server.user.dto.SignUpRequest;
import com.taxisharing.server.user.dto.SignUpResponse;
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

    public SignUpResponse signUp(SignUpRequest signUpRequest)
    {
        User user = signUpRequest.toUser();
        User savedUser = userRepository.save(user);
        return new SignUpResponse(authenticationService.createToken(savedUser));
    }

    @Transactional(readOnly = true)
    public boolean isSignUp(String userName)
    {
        return userRepository.existsByUsername(userName);
    }

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


}
