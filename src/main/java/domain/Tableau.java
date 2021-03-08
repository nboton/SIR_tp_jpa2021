package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "T_Tableau")
public class Tableau {
    @Id
    @GeneratedValue
    private long idTableau;
    private String libelle;
    @ManyToMany
    @JoinTable( name = "T_Tableau_Section",
            joinColumns = @JoinColumn( name = "idTableau" ),
            inverseJoinColumns = @JoinColumn( name = "idSection" ) )
    private List<Section> sections=new ArrayList<>();

    @OneToMany(mappedBy = "tableau", cascade = CascadeType.PERSIST)
    private List<Fiche> fiches=new ArrayList<>();


    public Tableau() {
        super();
    }

    public Tableau(String libelle) {
        this.libelle = libelle;
    }

    public long getIdTableau() {
        return idTableau;
    }

    public void setIdTableau(long id) {
        this.idTableau = id;
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
