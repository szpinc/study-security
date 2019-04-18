package org.szpinc.study.security.provider;

import org.szpinc.study.security.annotation.Json;
import org.szpinc.study.security.annotation.Jsons;
import org.szpinc.study.security.filter.CustomerJsonSerializer;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JsonBodyWriter.java
 * @Description TODO
 * @createTime 2019年04月17日 23:07:00
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JsonBodyWriter implements MessageBodyWriter<Object> {

    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations,
                               MediaType mediaType) {

        for (Annotation annotation : annotations) {
            if (annotation instanceof Json || annotation instanceof Jsons) {
                return true;
            }
        }
        return false;
    }

    @Override
    public long getSize(Object t, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType) {

        return -1;
    }

    @Override
    public void writeTo(Object t, Class<?> type, Type genericType, Annotation[] annotations,
                        MediaType mediaType, MultivaluedMap<String, Object> httpHeaders,
                        OutputStream entityStream) throws IOException, WebApplicationException {
        CustomerJsonSerializer jsonSerializer = new CustomerJsonSerializer();
        Arrays.asList(annotations).forEach(a -> {
            if (a instanceof Json) {
                Json json = (Json) a;
                jsonSerializer.filter(json);
            } else if (a instanceof Jsons) {
                Jsons jsons = (Jsons) a;
                Arrays.asList(jsons.value()).forEach(json -> {
                    jsonSerializer.filter(json);
                });
            }
        });
        entityStream.write(jsonSerializer.toJson(t).getBytes());
    }
}
