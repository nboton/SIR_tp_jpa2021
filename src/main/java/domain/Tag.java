package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue
    private long id;
    private String libelle;
    @ManyToMany
    List<Fiche> fiches;


    public Tag() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;

    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<Fiche> getFiches() {
        return fiches;
    }

    public void  setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
}
