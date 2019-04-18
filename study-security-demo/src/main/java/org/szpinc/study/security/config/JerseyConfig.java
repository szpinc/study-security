package org.szpinc.study.security.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.szpinc.study.security.provider.JsonBodyWriter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName JerseyConfig.java
 * @Description TODO
 * @createTime 2019年04月17日 23:12:00
 */

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        //response message writer
        register(JsonBodyWriter.class);

        //exceptions
//        register(ExceptionMapperSupport.class);
    }

}
