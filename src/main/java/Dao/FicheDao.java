package Dao;

import domain.Fiche;
import domain.Utilisateur;
import jpa.EntityManagerHelper;

import java.util.List;

public class FicheDao {

    public Fiche save(Fiche f ){
        EntityManagerHelper.beginTransaction();
        int number = EntityManagerHelper.getEntityManager().createQuery("Select a From Fiche a", Fiche.class).getResultList().size();
        if (number != 0) {
            EntityManagerHelper.getEntityManager().merge(f);

        } else {
            EntityManagerHelper.getEntityManager().persist(f);

        }
        EntityManagerHelper.commit();
        return f;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
    public Fiche findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Fiche.class, id);

    }

    public List<Fiche> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select f from Fiche as f", Fiche.class)
                .getResultList();
    }


}
