package org.szpinc.study.security.filter;

import org.springframework.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.szpinc.study.security.annotation.Json;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName CustomerJsonSerializer.java
 * @Description TODO
 * @createTime 2019年04月17日 23:04:00
 */
public class CustomerJsonSerializer {

    ObjectMapper mapper = new ObjectMapper();
    JacksonJsonFilter jacksonFilter = new JacksonJsonFilter();

    /**
     * @param clazz   target type
     * @param include include fields
     * @param filter  filter fields
     */
    public void filter(Class<?> clazz, String include, String filter) {
        if (clazz == null) return;
        if (!StringUtils.isEmpty(include)) {
            jacksonFilter.include(clazz, include.split(","));
        }
        if (!StringUtils.isEmpty(filter)) {
            jacksonFilter.filter(clazz, filter.split(","));
        }
        mapper.addMixIn(clazz, jacksonFilter.getClass());
    }

    public String toJson(Object object) throws JsonProcessingException {
        mapper.setFilterProvider(jacksonFilter);
        return mapper.writeValueAsString(object);
    }

    public void filter(Json json) {
        this.filter(json.type(), json.include(), json.filter());
    }

    /**
     * 用于测试自定义是否起作用
     *
     * @param args
     * @throws JsonProcessingException
     */
    public static void main(String args[]) throws JsonProcessingException {
//        CustomerJsonSerializer cjs= new CustomerJsonSerializer();
//        cjs.filter(Test.class, "name,age", null);
//
//        String include = cjs.toJson(new Test());
//
//        cjs = new CustomerJsonSerializer();
//        // 设置转换 Test 类时，过滤掉 name
//        cjs.filter(Test.class, null, "name");
//
//        String filter = cjs.toJson(new Test());
//
//        System.out.println("include: " + include);
//        System.out.println("filter: " + filter);
    }
}
