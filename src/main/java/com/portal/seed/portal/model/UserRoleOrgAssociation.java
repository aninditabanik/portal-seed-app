package com.portal.seed.portal.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "person_roles", schema = "abanik")
public class UserRoleOrgAssociation {

    @Id
    @GeneratedValue(generator = "id_generator")
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_sequence",
            initialValue = 1000
    )
    private Long id;

    @Column(name = "role_id")
    private Long roleId = 1003L; //employeeRole

    @Column(name = "person_id")
    private Long personId = 1021L; //wamp user

    @Column(name = "org_id")
    private Long orgId;
}
