package org.szpinc.study.security.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Data
public class User {

    public interface UserSimpleView {}

    public interface UserDetailView extends UserSimpleView {}

    @JsonView(UserSimpleView.class)
    private Integer id;

    @JsonView(UserSimpleView.class)
    private String username;

    @JsonView(UserDetailView.class)
    private String password;
}
