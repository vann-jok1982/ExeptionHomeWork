package isklyucheniya;

public class Person {
    String surname;
    String name;
    String patronymic;
    String birthdata;
    String phone;
    String gender;

    public Person(String surname, String name, String patronymic, String birthdata, String phone, String gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthdata = birthdata;
        this.phone = phone;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("<%s><%s><%s><%s><%s><%s>" , surname,name,patronymic,birthdata,phone,gender);
    }
}
