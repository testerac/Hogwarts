package WeWork;

/**
 * @program:
 * @description:
 * @author: Mr.libb
 * @creat: 2022-07-04 12-24
 **/
public class Member {
    String name;
    String phone;
    String depart;

    public Member( String name, String phone,String depart) {
        this.name = name;
        this.phone = phone;
        this.depart = depart;
    }



    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepart() {
        return depart;
    }
}
