package io.github.lucianodacunha.appservlet.model;

import io.github.lucianodacunha.appservlet.dao.Database;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Machine {

    private Long id;
    @NonNull
    private String type;
    @NonNull
    private String model;
    @NonNull
    private Integer year;

    public Machine(){
        this.id = Database.getSequence();
    }

    public Machine(String type, String model, Integer year){
        this.id = Database.getSequence();
        this.type = type;
        this.model = model;
        this.year = year;
    }

}
