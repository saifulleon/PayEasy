
package com.leon.payeasy.service;


import com.leon.payeasy.model.Jobtitle;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface JobtitleService {
    public String insertJobtitle(Jobtitle jobtitle);

    public String updateJobtitle(Jobtitle jobtitle);

    public String deleteJobtitle(int jobtitleid);

    public String viewJobtitleList();

    public Jobtitle viewJobtitle(int jobtitleid);
}
