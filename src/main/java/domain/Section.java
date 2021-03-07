package domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Section {
    @Id
    @GeneratedValue
    private long id;
    private String libelle;
    @ManyToMany
    private List<Tableau> tableaux;
    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    private List<PositionnementFiche> positionnementFiches;

    public Section() {
        super();
    }

    public Section(String libelle) {
        this.id = id;
        this.libelle = libelle;
        this.tableaux = tableaux;
        this.positionnementFiches = positionnementFiches;
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

    public List<Tableau> getTableaux() {
        return tableaux;
    }

    public void setTableaux(List<Tableau> tableaux) {
        this.tableaux = tableaux;
    }

    public List<PositionnementFiche> getPositionnementFiches() {
        return positionnementFiches;
    }

    public void setPositionnementFiches(List<PositionnementFiche> positionnementFiches) {
        this.positionnementFiches = positionnementFiches;
    }
}
