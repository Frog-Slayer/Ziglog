package com.ziglog.ziglog.domain.member.service;

import com.ziglog.ziglog.domain.member.dto.request.ModifyUserRequestDto;
import com.ziglog.ziglog.domain.member.dto.request.NicknameDto;
import com.ziglog.ziglog.domain.member.dto.response.MyInfoResponseDto;
import com.ziglog.ziglog.domain.member.dto.response.NicknameValidationResponseDto;
import com.ziglog.ziglog.domain.member.dto.response.UserPublicInfoResponseDto;
import com.ziglog.ziglog.domain.member.entity.Member;
import com.ziglog.ziglog.domain.member.exception.exceptions.InvalidUserModificationRequestException;
import com.ziglog.ziglog.domain.member.exception.exceptions.UserNotFoundException;
import com.ziglog.ziglog.domain.note.exception.exceptions.FolderNotFoundException;

public interface MemberService {

    /**
     * DTO 변환 로직을 포함하는 인터페이스
     */

    //사용자 닉네임 및 프로필 이미지를 변경
    UserPublicInfoResponseDto modifyUserInfo(Member member, ModifyUserRequestDto modifyUserRequestDto) throws  UserNotFoundException, InvalidUserModificationRequestException;

    //사용자의 공개 정보를 닉네임을 통해 조회
    UserPublicInfoResponseDto getUserPublicInfoByNickname(String nickname) throws UserNotFoundException;

    //닉네임 변경 시의 유효성을 검사
    NicknameValidationResponseDto validateNickname(Member member, NicknameDto nicknameDto);

    //현재 로그인한 회원의 정보를 조회
    MyInfoResponseDto getLoginUserInfo(Member member) throws UserNotFoundException, FolderNotFoundException;

    /**
     * 엔티티와 그 필드만을 사용하는 함수 인터페이스
     */
    Member findUserByEmail(String email) throws UserNotFoundException;
    Member findUserByNickname(String nickname) throws UserNotFoundException;
    void modifyUserNickname(Member member, String nickname) throws UserNotFoundException, InvalidUserModificationRequestException;
    void modifyUserProfile(Member member, String profileUrl) throws UserNotFoundException;
    boolean isValidNickname(Member member, String nickname);
    boolean isValidNicknameFormat(String nickname);
    boolean isNotDuplicatedNickname(String nickname);

    //테스트를 위한 회원가입 인터페이스. 실제로 사용되지는 않음
    Member signUp(String email, String nickname) throws Exception;
}

