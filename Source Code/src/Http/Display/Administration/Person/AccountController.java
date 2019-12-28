package Http.Display.Administration.Person;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AccountController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/administration/person/account/master/account";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}