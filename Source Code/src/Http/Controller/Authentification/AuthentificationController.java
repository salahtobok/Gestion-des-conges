package Http.Controller.Authentification;


import DBUtil.Admin.PersonDBUtil;
import DBUtil.User.LoginDbUtil;
import Entities.Compte;
import Handlers.PropertiesHandler;
import SessionUtil.SessionUtils;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;


@ManagedBean
@SessionScoped
public class AuthentificationController implements Serializable {

    @EJB
    LoginDbUtil loginDbUtil;

    HttpSession session = SessionUtils.getSession();


    private String login;
    private String password;


    private Compte userCompte;

    private String successMsg = PropertiesHandler.getProperty(PersonDBUtil.class, "messeges_fr.properties", "updated_successfully");
    private String failMsg = PropertiesHandler.getProperty(PersonDBUtil.class, "messeges_fr.properties", "failure_update");


    @PostConstruct
    public void init() {
    }


    public String authenticate() {

        boolean authenticate = false;

        Compte userAccount = loginDbUtil.authenticate(login, password);
        if (userAccount != null) {

            showInfo(successMsg);
            authenticate = true;
        } else
            showError(failMsg);


        if (authenticate) {
            session.setAttribute("userAccount", userAccount);
            return "/public/pages/user/dashboard.xhtml";
        }else
            return null;
    }


    public void showInfo(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void showError(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Compte getUserCompte() {
        return userCompte;
    }

    public void setUserCompte(Compte userCompte) {
        this.userCompte = userCompte;
    }
}
