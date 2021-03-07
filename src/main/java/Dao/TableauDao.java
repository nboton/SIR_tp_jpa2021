package Dao;

import domain.Fiche;
import domain.Section;
import domain.Tableau;
import jpa.EntityManagerHelper;

import java.util.List;

public class TableauDao {
    public Tableau save(Tableau t ){
        EntityManagerHelper.beginTransaction();
        int number = EntityManagerHelper.getEntityManager().createQuery("Select a From Tableau a", Tableau.class).getResultList().size();
        if (number != 0) {
            EntityManagerHelper.getEntityManager().merge(t);

        } else {
            EntityManagerHelper.getEntityManager().persist(t);

        }
        EntityManagerHelper.commit();
        return t;

    }

    public void delete(String id) {
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().remove(this.findById(id));
        EntityManagerHelper.commit();
    }
    public Tableau findById(String id) {
        return EntityManagerHelper.getEntityManager().find(Tableau.class, id);

    }

    public List<Tableau> findAll() {
        return EntityManagerHelper.getEntityManager().createQuery("select t from Tableau as t", Tableau.class)
                .getResultList();
    }
}
