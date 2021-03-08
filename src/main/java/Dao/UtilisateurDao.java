package Dao;

import domain.Utilisateur;
import jpa.EntityManagerHelper;

import java.util.List;

public class UtilisateurDao {

    public Utilisateur save(Utilisateur u ){
        EntityManagerHelper.beginTransaction();
        int number = EntityManagerHelper.getEntityManager().createQuery("Select a From Utilisateur a", Utilisateur.class).getResultList().size();
        
        if (number != 0) {
            EntityManagerHelper.getEntityManager().merge(u);

        } else {
            EntityManagerHelper.getEntityManager().persist(u);

        }
        EntityManagerHelper.commit();
        return u;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
    public Utilisateur findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Utilisateur.class, id);

    }

    public List<Utilisateur> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u", Utilisateur.class)
                .getResultList();
    }

    public List<Utilisateur> findByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select u from Utilisateur as u where u.nom = :name", Utilisateur.class)
                .setParameter("nom", name).getResultList();

    }


    public List<Utilisateur> findByFirstname(String firstname) {
        return EntityManagerHelper.getEntityManager().createNamedQuery("AllUsers", Utilisateur.class)
                .setParameter("prenomUser", firstname).getResultList();

    }


}
