package com.portal.seed.payment.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class VersionedEntity {
    @Column(name = "version", nullable = false)
    @Version
    protected long version;
}
