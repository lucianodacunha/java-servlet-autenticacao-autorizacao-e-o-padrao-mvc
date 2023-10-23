package io.github.lucianodacunha.appservlet.dao;

import io.github.lucianodacunha.appservlet.model.Machine;

import java.util.*;

public class Database {

    private static List<Machine> machines = new ArrayList<>();
    private static Long sequence = 0L;

    static {
        Database db = new Database();
        db.add(new Machine("Trator", "7160J", 2019));
        db.add(new Machine("Trator", "8160R", 2020));
        db.add(new Machine("Colhedora", "3520", 2016));
    }

    public static Long getSequence(){
        Database.sequence++;
        return Database.sequence;
    }

    public boolean add(Machine machine){
        return Database.machines.add(machine);
    }

    public List<Machine> list(){
        return Database.machines;
    }

    public void remove(Machine machine) {
       Database.machines.remove(machine);
    }

    public Machine findById(Long id) {
        return Database.machines.stream().filter(m -> m.getId().equals(id)).findFirst().get();
    }
}
