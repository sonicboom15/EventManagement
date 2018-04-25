package ctsstudentclub.sist.com.eventmanagement;

public class Event {
    private int id;
    private int userid;
    private String eventname;
    private String startdate;
    private String enddate;
    private String time;
    private String desc;
    private int adminapp;
    private String address;
    private String category;
    public Event(int id,int userid,String eventname,String startdate,String enddate,String time,String desc,int adminapp,String address,String category){
        this.id = id;
        this.userid = userid;
        this.eventname = eventname;
        this.startdate = startdate;
        this.enddate = enddate;
        this.time = time;
        this.desc = desc;
        this.adminapp = adminapp;
        this.address = address;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getEventname() {
        return eventname;
    }

    public String getStartdate() {
        return startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getTime() {
        return time;
    }

    public String getDesc() {
        return desc;
    }

    public int getAdminapp() {
        return adminapp;
    }

    public String getAddress() {
        return address;
    }

    public String getCategory() {
        return category;
    }
}
