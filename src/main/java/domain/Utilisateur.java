package domain;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "T_Utilisateur")
@NamedQueries({
        @NamedQuery(name="AllUsers",
                query = "select u from Utilisateur as u where u.prenom=:prenomUser")
})
public class Utilisateur {
    @Id
    private String codeUser ;
    private String nom;
    private String prenom;
    private String email;
    @OneToMany(mappedBy = "utilisateur", cascade = { CascadeType.PERSIST})
    //@JsonIgnoreProperties("utilisateur")
    private List<Fiche> fiches=new ArrayList<>();


    public Utilisateur() {
        super();
    }
    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String code) {
        this.codeUser = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    public String toString() {
        return this.codeUser + ": " + this.nom + "/" + this.prenom
                + " - " + this.email ;
    }

}
