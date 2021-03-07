package domain;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Fiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Temporal(TemporalType.DATE)
    private Date dateButoire;
    private String libelle;
    private String lieu;
    private String url;
    private String noteExplicative;
    private int delai;

    @ManyToMany(mappedBy = "fiches")
    private List<Tag> tags;

    @ManyToOne
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "fiche", cascade = CascadeType.PERSIST)
    private List<PositionnementFiche> positionnementFiches;

    @ManyToOne
    private Tableau tableau;

    public Fiche() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateButoire() {
        return dateButoire;
    }

    public void setDateButoire(Date dateButoire) {
        this.dateButoire = dateButoire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNoteExplicative() {
        return noteExplicative;
    }

    public void setNoteExplicative(String noteExplicative) {
        this.noteExplicative = noteExplicative;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Tableau getTableau() {
        return tableau;
    }

    public void setTableau(Tableau tableau) {
        this.tableau = tableau;
    }

    public List<PositionnementFiche> getPositionnementFiches() {
        return positionnementFiches;
    }

    public void setPositionnementFiches(List<PositionnementFiche> positionnementFiches) {
        this.positionnementFiches = positionnementFiches;

    }
}
