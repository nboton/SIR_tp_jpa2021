package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity @Table(name = "T_PositionnementFiche")
public class PositionnementFiche {
    @Id
    @GeneratedValue
    private long idPositionnementFiche;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn( name="idFiche" )
    private Fiche fiche;
    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn( name="idSection" )
    private Section section;

    public PositionnementFiche() {
        super();
    }

    public long getId() {
        return idPositionnementFiche;
    }

    public PositionnementFiche setId(long id) {
        this.idPositionnementFiche = id;
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
