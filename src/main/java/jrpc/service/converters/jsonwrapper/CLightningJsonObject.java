package jrpc.service.converters.jsonwrapper;

import com.google.gson.*;
import jrpc.service.converters.JsonConverter;

import java.util.Map;
import java.util.Set;

public class CLightningJsonObject extends JsonElement {

    private JsonObject jsonObject;
    private JsonConverter converter;

    public CLightningJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
        this.converter = new JsonConverter();
    }

    public CLightningJsonObject() {
        this.jsonObject = new JsonObject();
        this.converter = new JsonConverter();
    }

    public void add(String property, JsonElement value) {
        this.jsonObject.add(property,value);
    }

    public JsonElement remove(String property) {
        return this.jsonObject.remove(property);
    }

    public void addProperty(String property, String value) {
        this.jsonObject.addProperty(property, value);
    }

    public void addProperty(String property, Number value) {
        this.jsonObject.addProperty(property, value);
    }

    public void addProperty(String property, Boolean value) {
        this.jsonObject.addProperty(property, value);
    }

    public void addProperty(String property, Character value) {
        this.jsonObject.addProperty(property, value);
    }

    public Set<Map.Entry<String, JsonElement>> entrySet() {
        return this.jsonObject.entrySet();
    }

    public Set<String> keySet() {
        return this.jsonObject.keySet();
    }

    public int size() {
        return this.jsonObject.size();
    }

    public boolean has(String memberName) {
        return this.jsonObject.has(memberName);
    }

    public JsonElement get(String memberName) {
        return this.jsonObject.get(memberName);
    }

    public JsonPrimitive getAsJsonPrimitive(String memberName) {
        return (JsonPrimitive) this.jsonObject.get(memberName);
    }

    public JsonArray getAsJsonArray(String memberName) {
        return (JsonArray) this.jsonObject.get(memberName);
    }

    public JsonObject getAsJsonObject(String memberName) {
        return (JsonObject) this.jsonObject.get(memberName);
    }

    @Override
    public boolean equals(Object o) {
        return this.jsonObject.equals(o);
    }

    @Override
    public int hashCode() {
        return this.jsonObject.hashCode();
    }

    public void add(String propriety, Object value) {
        JsonElement element = (JsonElement) converter.deserialization(converter.serialization(value), JsonElement.class);
        this.jsonObject.add(propriety, element);
    }

    public void mapping(JsonObject jsonObject) {
        for (Map.Entry<String, JsonElement> set : jsonObject.entrySet()) {
            add(set.getKey(), set.getValue());
        }
    }

    public JsonObject getWrapper(){
        return this.jsonObject;
    }

    @Override
    public JsonElement deepCopy() {
        return this.jsonObject.deepCopy();
    }

    @Override
    public String toString() {
        return this.jsonObject.toString();
    }
}
