package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="AllUsers",
                query = "select u from Utilisateur as u where u.prenom=:prenomUser")
})
public class Utilisateur {
    @Id
    private String code ;
    private String nom;
    private String prenom;
    private String email;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
    private List<Fiche> fiches;


    public Utilisateur() {
        super();
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}
