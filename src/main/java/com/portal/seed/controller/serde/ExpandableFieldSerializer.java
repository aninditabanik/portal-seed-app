package com.portal.seed.controller.serde;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.portal.seed.payment.model.api.ExpandableField;

import java.io.IOException;

public class ExpandableFieldSerializer extends StdSerializer<ExpandableField<?>> {

    public ExpandableFieldSerializer() {
        this(null);
    }

    public ExpandableFieldSerializer(Class<ExpandableField<?>> vc) {
        super(vc);
    }

    @Override
    public void serialize(ExpandableField<?> value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value.isExpanded()) {
            gen.writeObject(value.getUnderlyingObject());
        } else {
            gen.writeString(value.getId().toString());
        }
    }
}

