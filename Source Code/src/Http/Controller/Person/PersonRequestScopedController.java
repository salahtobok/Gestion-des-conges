package Http.Controller.Person;


import DBUtil.Admin.PersonDBUtil;
import Entities.Personne;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.List;


@ManagedBean
@RequestScoped
public class PersonRequestScopedController implements Serializable{

    @EJB
    PersonDBUtil PersonneDBUtil ;

    private List<Personne> Personnes ;
    private List<Personne> filteredPersonnes ;


    @PostConstruct
    public void init() {
        }


    public List<Personne> getPersonnes() {
        Personnes =PersonneDBUtil.loadPersonList();
        return Personnes;
    }

    public void setPersonnes(List<Personne> Personnes) {
        this.Personnes = Personnes;
    }


    public List<Personne> getFilteredPersonnes() {
        return filteredPersonnes;
    }

    public void setFilteredPersonnes(List<Personne> filteredPersonnes) {
        this.filteredPersonnes = filteredPersonnes;
    }



}
