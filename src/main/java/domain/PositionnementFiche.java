package domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class PositionnementFiche {
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @ManyToOne
    private Fiche fiche;
    @ManyToOne
    private Section section;

    public PositionnementFiche() {
        super();
    }

    public long getId() {
        return id;
    }

    public PositionnementFiche setId(long id) {
        this.id = id;
        return this;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public PositionnementFiche setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public Fiche getFiche() {
        return fiche;
    }

    public void setFiche(Fiche fiche) {
        this.fiche = fiche;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}
