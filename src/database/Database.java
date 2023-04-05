package database;

import lombok.Data;
import model.Hospital;
import java.util.ArrayList;
import java.util.List;
@Data
public class Database {
    private List<Hospital> hospitals;

    public Database(){
        this.hospitals = new ArrayList<>();
    }

    public List<Hospital> getHospitals() {
        return hospitals;
    }

}
