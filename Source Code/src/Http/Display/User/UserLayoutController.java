package Http.Display.User;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


/**
 * Created by salahtobok on 22/04/17.
 */
@ManagedBean
@SessionScoped
public class UserLayoutController {

    private String page;


    @PostConstruct
    public void init() {
                this.page = "/resources/views/user/user/leave_management/leave/leave";
    }

    public String getPage() {
        return page;
    }


    public void setPage(String page) {

        this.page = page;
    }


}
