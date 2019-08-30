package rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


@SpringBootApplication
public class Main {

    public final static EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
