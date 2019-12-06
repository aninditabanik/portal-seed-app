package com.portal.seed.payment.model.api;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.UUID;

import com.portal.seed.controller.serde.ExpandableFieldDeserializer;
import com.portal.seed.controller.serde.ExpandableFieldSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonSerialize(using = ExpandableFieldSerializer.class)
@JsonDeserialize(using = ExpandableFieldDeserializer.class)
public class ExpandableField<T extends Auditable> {
    private UUID id;

    private T underlyingObject;
    private boolean expanded = false;

    public ExpandableField(T underlyingObject) {
        this(underlyingObject, false);
    }

    public ExpandableField(T underlyingObject, boolean expand) {
        id = underlyingObject == null ? null : underlyingObject.getId();
        this.underlyingObject = underlyingObject;
        this.expanded = expand;
    }

    public static <T extends Auditable> ExpandableField<T> id(T underlyingObject) {
        UUID id = underlyingObject == null ? null : underlyingObject.getId();
        return new ExpandableField<>(id, underlyingObject, false);
    }

    public static <T extends Auditable> ExpandableField<T> of(T underlyingObject) {
        UUID id = underlyingObject == null ? null : underlyingObject.getId();
        return new ExpandableField<>(id, underlyingObject, true);
    }
}
