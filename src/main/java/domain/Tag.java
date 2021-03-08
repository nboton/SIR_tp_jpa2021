package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "T_Tag")
public class Tag  {
    @Id
    @GeneratedValue
    private long idTag;
    private String libelle;
    @ManyToMany
    @JoinTable( name = "T_Fiche_Tag",
            joinColumns = @JoinColumn( name = "id_Tag" ),
            inverseJoinColumns = @JoinColumn( name = "idFiche" ) )
    List<Fiche> fiches=new ArrayList<>();


    public Tag() {
        super();
    }

    public Tag(String libelle) {
        this.libelle = libelle;
    }

    public long getIdTag() {
        return idTag;
    }

    public void setIdTag(long id) {
        this.idTag = id;

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
