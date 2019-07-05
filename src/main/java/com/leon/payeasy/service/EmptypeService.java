
package com.leon.payeasy.service;


import com.leon.payeasy.model.Emptype;
import org.springframework.stereotype.Service;

/**
 *
 * @author Saiful Leon
 */

@Service
public interface EmptypeService {
    public String insertEmptype(Emptype emptype);

    public String updateEmptype(Emptype emptype);

    public String deleteEmptype(int emptypeid);

    public String viewEmptypeList();

    public Emptype viewEmptype(int emptypeid);
}
