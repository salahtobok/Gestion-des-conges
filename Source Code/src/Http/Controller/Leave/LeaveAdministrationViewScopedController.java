package Http.Controller.Leave;


import DAO.Local.IPersonneDAOLocal;
import DBUtil.Admin.LeaveAdministrationDBUtil;
import DBUtil.Admin.PersonDBUtil;
import Entities.Demande;
import Entities.Personne;
import Handlers.PropertiesHandler;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class LeaveAdministrationViewScopedController implements Serializable {
    @EJB
    IPersonneDAOLocal iPersonneDAOLocal;

    @EJB
    LeaveAdministrationDBUtil leaveDBUtil;

    @EJB
    PersonDBUtil personDBUtil;


    private String selectedIdPerson;

    private Demande selectedDemande;

    private Demande newDemande;

    private String successMsg = PropertiesHandler.getProperty(LeaveAdministrationDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(LeaveAdministrationDBUtil.class, "messeges_fr.properties", "failure_update");

    private List<Personne> personnes;

    @PostConstruct
    public void init() {

        personnes = personDBUtil.loadPersonList();
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

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public String getSelectedIdPerson() {
        return selectedIdPerson;
    }

    public void setSelectedIdPerson(String selectedIdPerson) {
        this.selectedIdPerson = selectedIdPerson;
    }

    public void create() {

        Personne personne = iPersonneDAOLocal.find(Integer.valueOf(selectedIdPerson));
//        newDemande.setIdDemande();
        newDemande.setPersonne(personne);
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
