package Http.Controller.Person;



import DBUtil.Admin.PersonDBUtil;
import Entities.Personne;
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
public class PersonViewScopedController implements Serializable{

    @EJB
    PersonDBUtil PersonDBUtil ;

    private Personne selectedPerson;

    private Personne newPerson;

    private String successMsg = PropertiesHandler.getProperty(PersonDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PersonDBUtil.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {
        newPerson = PersonDBUtil.createFakePerson() ;
    }



    public Personne getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Personne selectedPerson) {
        this.selectedPerson = selectedPerson;
    }

    public Personne getNewPerson() {
        return newPerson;
    }

    public void setNewPerson(Personne newPerson) {
        this.newPerson = newPerson;
    }


    public void create() {
        newPerson.setIdPersonne(0);
        newPerson.getCompte().setIdCompte(0);
        if (PersonDBUtil.createPerson(newPerson))
            showInfo(successMsg);
        else
            showError(failMsg);

    }


    public void update() {
//        showInfo("Updated :"+selectedPerson.getIdPerson());
        if (PersonDBUtil.updatePerson(selectedPerson))
            showInfo(successMsg);
        else
            showError(failMsg);
    }

    public void delete() {
        if (PersonDBUtil.deletePerson(selectedPerson))
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
