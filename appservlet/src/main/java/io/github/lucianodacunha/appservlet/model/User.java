package io.github.lucianodacunha.appservlet.model;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    private String id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
