package Http.Controller.Leave;


import DBUtil.Admin.LeaveAdministrationDBUtil;
import DBUtil.Admin.PersonDBUtil;
import Entities.Demande;
import Entities.Personne;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@RequestScoped
public class LeaveAdministrationRequestScopedController implements Serializable{

    @EJB
    LeaveAdministrationDBUtil leaveDBUtil ;

    @EJB
    PersonDBUtil personDBUtil ;

    private List<Demande> demandes ;
    private List<Demande> filteredDemandes ;


    @PostConstruct
    public void init() {
    }


    public List<Demande> getDemandes() {
        demandes =leaveDBUtil.loadDemandList();
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public List<Demande> getFilteredDemandes() {
        return filteredDemandes;
    }

    public void setFilteredDemandes(List<Demande> filteredDemandes) {
        this.filteredDemandes = filteredDemandes;
    }


}
