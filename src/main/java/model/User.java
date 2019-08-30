package model;


import com.google.gson.annotations.SerializedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "USERS")
@Entity
public class User {

    @Id
    @Column(name = "MAIL")
    @SerializedName("mail")
    private String mail;
    @Column(name = "LAST_NAME")
    @SerializedName("lastName")
    private String lastName;
    @Column(name = "FIRST_NAME")
    @SerializedName("firstName")
    private String firstName;
    @Column(name = "BIRTH_DATE")
    @SerializedName("birthDate")
    private String birthDate;
    @Column(name = "NUMBER")
    @SerializedName("number")
    private Integer number;
    @Column(name = "NAME_CHILDREN")
    @SerializedName("nameChildren")
    private String nameChildren;
    @Column(name = "GENDER")
    @SerializedName("gender")
    private String gender;





    public void setMail(String mail) throws Exception {

        if (mail==null){
            throw new Exception("Вы забыли указать почту");
        }

        this.mail = mail;
    }

    public void setLastName(String lastName) throws Exception {

        if (lastName==null){
            throw new Exception("Вы забыли указать фамилию");
        }
        if (lastName.length()<2){
            throw new Exception("Количество символов у фамилиии должно быть больше 2");
        }
        if (lastName.length()>50){
            throw new Exception("Количество символов у фамилиии должно быть меньше 50");
        }

        this.lastName = lastName;
    }

    public void setFirstName(String firstName) throws Exception {

        if (firstName==null){
            throw new Exception("Вы забыли указать имя");
        }

        if (lastName.length()<2){
            throw new Exception("Количество символов у имени должно быть больше 2");
        }
        if (lastName.length()>50){
            throw new Exception("Количество символов у имени должно быть меньше 50");
        }

        this.firstName = firstName;
    }

    public void setBirthDate(String birthDate) throws Exception {

        if (birthDate==null){
            throw new Exception("Вы забыли указать дату рождения");
        }

        if (birthDate.length()!=10){
            throw new Exception("Дата рождения должна быть 10 символов");

        }

        this.birthDate = birthDate;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setNameChildren(List<String> nameChildren) {
        this.nameChildren = nameChildren.toString();
    }

    public void setGender(String gender) throws Exception {

        if (gender==null){
            throw new Exception("Вы забыли указать пол");
        }
        else if (gender.equals("м") || (gender.equals("ж"))){
            this.gender = gender;
        }
        else {
            switch (gender){
                case "":
                    throw new Exception("Вы не заполнили пол");
                case " ":
                    throw new Exception("Вы прислали пробел");
                default:
                    throw new Exception("Неверный символ! Должен быть \"м\" или \"ж\"");
            }
        }

    }


    public String getMail() {
        return mail;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Integer getNumber() {
        return number;
    }

    public String getNameChildren() {
        return nameChildren;
    }

    public String getGender() {
        return gender;
    }
}
