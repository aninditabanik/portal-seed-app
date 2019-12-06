package com.portal.seed.controller.serde;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.portal.seed.payment.model.api.Auditable;
import com.portal.seed.payment.model.api.ExpandableField;

import java.io.IOException;
import java.util.UUID;

public class ExpandableFieldDeserializer extends JsonDeserializer<ExpandableField<?>>
        implements ContextualDeserializer {

    private JavaType valueType;

    @Override
    public ExpandableField<?> deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        if (jp.currentToken() == JsonToken.VALUE_STRING) {
            Auditable emptyObject;
            try {
                emptyObject = (Auditable) valueType.getRawClass().getConstructor().newInstance();
            } catch (Exception e) {
                throw JsonMappingException.from(jp, "Unable to construct " + valueType.toCanonical(), e);
            }
            emptyObject.setId(ctxt.readValue(jp, UUID.class));
            return ExpandableField.id(emptyObject);
        }

        if (jp.currentToken() == JsonToken.START_OBJECT) {
            return ExpandableField.of(ctxt.readValue(jp, valueType));
        }

        throw JsonMappingException.from(jp, "Invalid value for " + jp.currentName());
    }

    @Override
    public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property)
            throws JsonMappingException {
        ExpandableFieldDeserializer deserializer = new ExpandableFieldDeserializer();
        deserializer.valueType = property.getType().containedType(0);
        return deserializer;
    }
}

