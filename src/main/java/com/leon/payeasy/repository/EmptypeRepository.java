
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Emptype;
import com.leon.payeasy.service.EmptypeService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.google.gson.Gson;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Saiful Leon
 */

@Repository
@Transactional
public class EmptypeRepository implements EmptypeService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertEmptype(Emptype emptype) {
        Session session = sessionFactory.getCurrentSession();
        session.save(emptype);
        return null;
    }

    @Override
    public String updateEmptype(Emptype emptype) {
        Session session = sessionFactory.getCurrentSession();
        session.update(emptype);
        return null;
    }

    @Override
    public String deleteEmptype(int emptypeid) {
        Session session = sessionFactory.getCurrentSession();
        Emptype emptype = (Emptype) session.get(Emptype.class, emptypeid);
        if(null != emptype){
            session.delete(emptype);
        }
        return null;
    }

    @Override
    public String viewEmptypeList() {
        Session session = sessionFactory.getCurrentSession();
        List<Emptype> emptypeList = session.createQuery("from Emptype").list();
        
        Gson g = new Gson();
        String emptypeListJson = g.toJson(emptypeList);
        return emptypeListJson;
    }

    @Override
    public Emptype viewEmptype(int emptypeid) {
        Session session = sessionFactory.getCurrentSession();
        Emptype emptype = (Emptype) session.get(Emptype.class, emptypeid);
        return emptype;
    }
    
}
