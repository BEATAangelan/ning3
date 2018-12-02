package ningjiaxin1.bwie.com.ning_lian;

public class UserBean {
    public String name;
    public String UUid;

    public UserBean(String name, String UUid) {
        this.name = name;
        this.UUid = UUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUUid() {
        return UUid;
    }

    public void setUUid(String UUid) {
        this.UUid = UUid;
    }
}
