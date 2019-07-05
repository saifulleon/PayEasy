
package com.leon.payeasy.repository;

import com.leon.payeasy.model.Jobtitle;
import com.leon.payeasy.service.JobtitleService;
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
public class JobtitleRepository implements JobtitleService{
    
    @Autowired
    SessionFactory sessionFactory;

    
    @Override
    public String insertJobtitle(Jobtitle jobtitle) {
        Session session = sessionFactory.getCurrentSession();
        session.save(jobtitle);
        return null;
    }

    @Override
    public String updateJobtitle(Jobtitle jobtitle) {
        Session session = sessionFactory.getCurrentSession();
        session.update(jobtitle);
        return null;
    }

    @Override
    public String deleteJobtitle(int jobtitleid) {
        Session session = sessionFactory.getCurrentSession();
        Jobtitle jobtitle = (Jobtitle) session.get(Jobtitle.class, jobtitleid);
        if(null != jobtitle){
            session.delete(jobtitle);
        }
        return null;
    }

    @Override
    public String viewJobtitleList() {
        Session session = sessionFactory.getCurrentSession();
        List<Jobtitle> jobtitleList = session.createQuery("from Jobtitle").list();
        
        Gson g = new Gson();
        String jobtitleListJson = g.toJson(jobtitleList);
        return jobtitleListJson;
    }

    @Override
    public Jobtitle viewJobtitle(int jobtitleid) {
        Session session = sessionFactory.getCurrentSession();
        Jobtitle jobtitle = (Jobtitle) session.get(Jobtitle.class, jobtitleid);
        return jobtitle;
    }
    
}
