package com.imse.team015.model;

import com.imse.team015.api.dao.MySQLUtils;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Customer  implements DataGenerator{

    @Id
    //@GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;
    private String gender;
    private int svnr;
    //private Date date_of_birth;
    private String date_of_birth;
    private String address;
    //private String street_with_no;
    //private String city;
    //private String postal_code;


    @Override
    public void generateData(){
        String[] firstNames = new String[] {"David", "John", "Alice", "Emily","Kenan",
                "Eyal","Marie", "Ariana", "Anna","Brisa", "Ava","Eva",
                "Jeremy", "Sevval","Melisa","Melamie","Jakob", "Enes","Eren","Emil", "Friedrich","Max"};

        String[] lastNames = new String[] {"Botros", "Gumpendorfer", "Engels", "Donko","Musterman",
                "Vigne","Aldente", "Prichtine", "Week","Pitt", "Rives","Hathaway",
                "Geissler", "Wagner","Hofer","Grande","Timberlake", "Batur","Yaman","Muller", "Schneider","Schmidt"};
        String[] genders = new String[] {"female","male"};
        Integer[] svnrs = new Integer[] {1234586,2764312,286312,3289410,2635443,8276535,
                52446268,7812355,862155,21628827,23535272,26342552,26352442,84846465,88923563};
        //Date[] dates = new Date[]{};
        String[] date = new String[] {"12-3-1990", "15-10-1991", "18-10-1988", "4-4-1994", "24-1-1998",
                "12-5-1992","11-7-1993", "3-5-1990","4-8-1970","10-5-1980","8-9-1990","1-10-1996","7-6-1999","17-4-1990","11-6-2002"};
        String[] addresses = new String[] {"Vereinsgasse 4/11","Gumpendorferstrasse 39", "Johngasse 4",
                "Lacknergasse 21", "Laudongasse 31", "Mitterberggasse 23",
                "Stutterheimstrasse 18/16","Laaerberggasse 45/4","Garnisongasse 9/10",
                "Wiedner Hauptstrasse 20", "Taborstrasse 11"};
         for(int i = 0; i< 30; i++){
             String RANDOM_CUSTOMER_QUERY = "INSERT INTO customer(id, firstname, lastname, gender, svnr, date_of_birth, address) " +
                     "VALUES (" + i + ",'" + firstNames[ThreadLocalRandom.current().nextInt(0, firstNames.length)] + "', '" +
                     lastNames[ThreadLocalRandom.current().nextInt(0, lastNames.length)]+ "', '" + genders[ThreadLocalRandom.current().nextInt(0, genders.length)] +
                     "', " + svnrs[ThreadLocalRandom.current().nextInt(0, svnrs.length)]+ ", '" + date[ThreadLocalRandom.current().nextInt(0, date.length)] +
                     "', '" + addresses[ThreadLocalRandom.current().nextInt(0, addresses.length)] + "');" ;

             System.out.println(RANDOM_CUSTOMER_QUERY);
             MySQLUtils.executeUpdate(RANDOM_CUSTOMER_QUERY);

         }

    }

    @Override
    public void createTable() {
        String CREATE_CUSTOMER_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS customer(id INT PRIMARY KEY," +
                "firstname VARCHAR(100), lastname VARCHAR(100), gender VARCHAR(100), svnr INT, date_of_birth VARCHAR(100), address VARCHAR(100));";
        MySQLUtils.executeUpdate(CREATE_CUSTOMER_TABLE_QUERY);
    }

    @Override
    public void dropTable() {
        String DROP_CUSTOMER_IF_EXISTS_QUERY = "DROP TABLE IF EXISTS customer;";
        MySQLUtils.executeUpdate(DROP_CUSTOMER_IF_EXISTS_QUERY);
    }

}
