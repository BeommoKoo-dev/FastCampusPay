package com.fastcampuspay.membership.adapter.in.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fastcampuspay.membership.application.port.in.RegisterMembershipCommand;
import com.fastcampuspay.membership.application.port.in.RegisterMembershipUseCase;
import com.fastcampuspay.membership.domain.Membership;

import common.WebAdapter;
import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterMembershipController {

    private final RegisterMembershipUseCase registerMembershipUseCase;

    @PostMapping("/membership/register")
    Membership registerMembership(@RequestBody RegisterMembershipRequest request) {
        RegisterMembershipCommand command = RegisterMembershipCommand.builder()
            .name(request.getName())
            .address(request.getAddress())
            .email(request.getEmail())
            .isValid(true)
            .isCorp(request.isCorp())
            .build();

        return registerMembershipUseCase.registerMembership(command);
    }

}
