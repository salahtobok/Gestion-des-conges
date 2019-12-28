package Http.Display.Administration.LeaveManagement;


import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LeaveAdministrationManagementController
{

    private String page;



    @PostConstruct
    public void init() {


            this.page = "/resources/views/user/administration/leave_management/leave/master/leave";

    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}