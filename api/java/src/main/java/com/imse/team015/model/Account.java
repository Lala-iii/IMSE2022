package com.imse.team015.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account implements DataGenerator {
    @Id
    //@GeneratedValue
    private Long id;

   private String account_type;
    //private Date date_of_creation;
    private String date_of_creation;
    private String iban;
    private String bic;
    private double balance;
    private String currency;
    private Long owner; // customerid


    @Override
    public void generateData(){
          String[] accountypes = new String[] {"Saving Account","Family Account",
                  "Student Account","Mutual Account","Normal Account"};
        String[] date = new String[] {"12-3-21", "15-10-20", "18-10-20", "4-4-21", "24-1-21",
                "12-5-21","11-7-17", "3-5-10","4-8-9","10-5-16","8-9-9",
                "1-10-19","7-6-05","17-4-14","11-6-12"};
        String[] ibans = new String[] {"AT67 7788 9999 0001 2011", "AT56 5056 7784 8253 2013",
        "AT56 5056 7253 5553 2012", "AT66 5056 3735 3324 2119", "AT16 4433 6253 9834 2202",
                "AT11 7354 8454 2312 1113","AT44 5056 7784 3984 2399",
                "AT13 7465 8365 1211 9375","AT56 6456 7357 2314 8736",
                "AT86 5056 7784 8253 2013","AT56 2256 9577 5553 2846"};
        String[] bics = new String[] {"GIBDHDY","NKSDUYCA","SDAHWYIDT","JHHAGJYD",
                "SDJGFJTA","GIVAATD","ESJGASD","SADSKDG","SDVASJDF","SDASDUUY","UCGSACYUS","JKKXASCSG"};
        Double[] balances = new Double[]{7245.67,3981.5,8745.98,736.78,982.28,2873.35,900.0,
                665.87,5556.89,889.9,644.78,896.7,890.78,644.17,123.56,342.78,765.9,780.9,765.12,
                342.12,9096.90,567.89,890.67,342.67,896.66,837.33,1000.57,90372.44,73552.67,393643.0,200.45,
                22.67,34675.78,235.12,8762.34,9832.67,9037.67,23721.10,10232.34,8624.45,87946.67,34231.40,23641.40};
        String[] currencies = new String[] {"EUR","GBP","AEL","TRY"};
        for(int i=0; i<100; i++){
            String RANDOM_ACCOUNT_QUERY = "INSERT INTO account(id, owner, account_type, date_of_creation, iban, bic, balance, currency) " +
                    "VALUES (" + i + ",'" + accountypes[ThreadLocalRandom.current().nextInt(0, accountypes.length)] + "', '" +
                    date[ThreadLocalRandom.current().nextInt(0, date.length)]+ "', " + ibans[ThreadLocalRandom.current().nextInt(0, ibans.length)] +
                    ", " + bics[ThreadLocalRandom.current().nextInt(0, bics.length)] + ", '" + balances[ThreadLocalRandom.current().nextInt(0, balances.length)] +
                    "', '" + currencies[ThreadLocalRandom.current().nextInt(0, currencies.length)] + ","+ i + ")" ;
        }
    }

    @Override
    public void createTable() {
        String CREATE_ACCOUNT_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS account(id int primary key," +
                "account_type varchar, " +
                "date_of_creation varchar, iban varchar, bic varchar, balance double, currency varchar," +
                "CONSTRAINT fk_owner FOREIGN KEY(owner) REFERENCES customer(id))";
    }


}
