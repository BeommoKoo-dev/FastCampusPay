package com.fastcampuspay.membership.adapter.out.persistence;

import org.springframework.stereotype.Component;

import com.fastcampuspay.membership.domain.Membership;

@Component
public class MembershipMapper {
    public Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity) {
        return Membership.generateMember(
            new Membership.MembershipId(membershipJpaEntity.getMembershipId() + ""),
            new Membership.MembershipName(membershipJpaEntity.getName()),
            new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
            new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
            new Membership.MembershipIsValid(membershipJpaEntity.isValid()),
            new Membership.MembershipIsCorp(membershipJpaEntity.isCorp()
            ));
    }
}
