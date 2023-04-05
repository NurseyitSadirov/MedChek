package database;

import lombok.Data;
import model.Hospital;

import java.util.List;

@Data
public class Database {
    private List<Hospital> hospitals;
}
