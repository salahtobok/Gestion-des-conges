package Http.Controller.Leave;


import DAO.Local.IPersonneDAOLocal;
import DBUtil.User.LeaveUserDBUtil;
import Entities.Demande;
import Handlers.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@ManagedBean
@ViewScoped
public class LeaveUserViewScopedController implements Serializable {
    @EJB
    IPersonneDAOLocal iPersonneDAOLocal;

    @EJB
    LeaveUserDBUtil leaveDBUtil;




    private Demande selectedDemande;

    private Demande newDemande;

    private String successMsg = PropertiesHandler.getProperty(LeaveUserViewScopedController.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(LeaveUserViewScopedController.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {

        newDemande = leaveDBUtil.createFakeDemand();
    }


    public Demande getSelectedDemande() {
        return selectedDemande;
    }

    public void setSelectedDemande(Demande selectedDemande) {
        this.selectedDemande = selectedDemande;
    }

    public Demande getNewDemande() {
        return newDemande;
    }

    public void setNewDemande(Demande newDemande) {
        this.newDemande = newDemande;
    }




    public void create() {

        newDemande.setIdDemande(0);
        if (leaveDBUtil.createDemande(newDemande))
            showInfo(successMsg);
        else
            showError(failMsg);

    }


    public void update() {
//        showInfo("Updated :"+selectedDemande.getIdDemande());
        if (leaveDBUtil.updateDemande(selectedDemande))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void delete() {
        if (leaveDBUtil.deleteDemande(selectedDemande))
            showInfo(successMsg);
        else
            showError(failMsg);
    }


    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
