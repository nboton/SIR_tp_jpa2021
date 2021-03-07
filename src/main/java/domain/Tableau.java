package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tableau {
    @Id
    @GeneratedValue
    private long id;
    private String libelle;
    @ManyToMany(mappedBy = "tableaux")
    private List<Section> sections;

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    private List<Fiche> fiches;


    public Tableau() {
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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }
}
