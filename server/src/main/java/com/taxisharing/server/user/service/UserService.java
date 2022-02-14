package com.taxisharing.server.user.service;

import com.taxisharing.server.auth.service.AuthenticationService;
import com.taxisharing.server.common.util.S3Connector;
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
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    public final UserRepository userRepository;
    public final MannerRepository mannerRepository;
    public final AuthenticationService authenticationService;
    public final S3Connector s3Connector;

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
        return new EvaluateMannerResponse(target.getManner());
    }

    public void updateNickname(int uid, String nickname)
    {
        User user = this.findUser(uid);
        user.updateNickname(nickname);
    }

    public void updatePassword(int uid, String newHash)
    {
        User user = this.findUser(uid);
        user.updateHash(newHash);
    }

    public ProfileResponse updateProfile(int uid, MultipartFile file)
    {
        User user = findUser(uid);
        deleteProfile(user);
        String uploadedFile  = s3Connector.uploadProfile(file,uid);
        user.updateProfileImage(uploadedFile);

        return new ProfileResponse(uploadedFile);
    }

    private void deleteProfile(User user)
    {
        if(user.getProfileImage().equals("users/profiles/default"))
        {
            return;
        }
        s3Connector.delete(user.getProfileImage());
        user.deleteProfile();
    }

    @Transactional(readOnly = true)
    public User findUser(int id)
    {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public UserBanResponse userBan(int uid, UserBanRequest userBanRequest)
    {
        User user = userRepository.findById(uid).orElseThrow(UserNotFoundException::new);
        User target = userRepository.findById(userBanRequest.getTargetId()).orElseThrow(UserNotFoundException::new);
        user.addBan(target);
        return new UserBanResponse(user.getBanList());
    }

    @Transactional(readOnly = true)
    public BanListResponse getBanList(int uid)
    {
        User user = userRepository.findById(uid).orElseThrow(UserNotFoundException::new);
        return new BanListResponse(user.getBanList());
    }
}
