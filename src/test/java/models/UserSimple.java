package models;

import lombok.*;

@Data
@Builder
public class UserSimple {

    String login;
    String password;
}
