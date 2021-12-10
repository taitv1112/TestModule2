package model;

public class Contacts {
    //Số điện thoại.
    //- Nhóm.
    //- Họ tên.
    //- Giới tính.
    //- Địa chỉ

    private String phone;
    private String group;
    private String name;
    private String gender;
    private String address;

    public Contacts(String phone, String group, String name, String gender, String address) {
        this.phone = phone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return phone + "," +
                group + "," +
               name + "," +
                gender + "," +
                address;
    }
}
