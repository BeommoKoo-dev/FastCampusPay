package com.fastcampuspay.membership.adapter.out.persistence;

import com.fastcampuspay.membership.application.port.out.FindMembershipPort;
import com.fastcampuspay.membership.application.port.out.RegisterMembershipPort;
import com.fastcampuspay.membership.domain.Membership;

import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

    private final SpringDataMembershipRepository membershipRepository;

    @Override
    public MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
        Membership.MembershipEmail membershipEmail, Membership.MembershipAddress membershipAddress,
        Membership.MembershipIsValid membershipIsValid, Membership.MembershipIsCorp membershipIsCorp) {
        return membershipRepository.save(
            new MembershipJpaEntity(
                membershipName.getMembershipName(),
                membershipAddress.getMembershipAddress(),
                membershipEmail.getMembershipEmail(),
                membershipIsValid.isMembershipIsValid(),
                membershipIsCorp.isMembershipIsCorp()
            )
        );
    }

    @Override
    public MembershipJpaEntity findMembership(Membership.MembershipId membershipId) {
        return membershipRepository.getById(Long.parseLong(membershipId.getMembershipId()));
    }
}
