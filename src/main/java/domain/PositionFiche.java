package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PositionFiche {
    @Id
    @GeneratedValue
    private long id;
}
