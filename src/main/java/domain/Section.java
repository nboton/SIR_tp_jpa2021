package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "T_Section")
public class Section {
    @Id
    @GeneratedValue
    private long idSection;
    private String libelle;
    @ManyToMany
    @JoinTable( name = "T_Tableau_Section",
            joinColumns = @JoinColumn( name = "idSection" ),
            inverseJoinColumns = @JoinColumn( name = "idTableau" ) )
    private List<Tableau> tableaux =new ArrayList<>();

    @OneToMany(mappedBy = "section", cascade = CascadeType.PERSIST)
    private List<PositionnementFiche> positionnementFiches=new ArrayList<>();

    public Section() {
        super();
    }

    public Section(String libelle) {
        this.idSection = idSection;
        this.libelle = libelle;
        this.tableaux = tableaux;
        this.positionnementFiches = positionnementFiches;
    }

    public long getIdSection() {
        return idSection;
    }

    public void setIdSection(long id) {
        this.idSection = id;
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
