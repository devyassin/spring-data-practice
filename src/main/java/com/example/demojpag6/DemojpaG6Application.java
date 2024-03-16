package com.example.demojpag6;

import com.example.demojpag6.Entity.Produit;
import com.example.demojpag6.Repositery.ProductRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class DemojpaG6Application implements CommandLineRunner {

    @Autowired
    private ProductRepositery productRepositery;

    public static void main(String[] args) {
        SpringApplication.run(DemojpaG6Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //ajouter produit
        productRepositery.save(new Produit(null,"Produit 1",15.5,50));
        productRepositery.save(new Produit(null,"Produit 2",50.3,20));
        productRepositery.save(new Produit(null,"Produit 3",51.4,30));

        //Consulter tous les produits

        productRepositery.findAll().forEach(p->{
            System.out.println(p);
        });

        //Consulter un produit

        Optional<Produit> produitWithIdOne=productRepositery.findById(1L);
        System.out.println(produitWithIdOne);

        //Chercher des produits
        ArrayList<Produit> produitsAvecPrixSup50 = (ArrayList<Produit>) productRepositery.findProductsByPriceGreaterThan(50.0);
        System.out.println("-----Chercher des produits----");
        for(Produit prod:produitsAvecPrixSup50){
            System.out.println(prod);
        }

        //Mettre à jour un produit
        System.out.println("-----Mettre à jour un produit----");
        Produit produitToUpdate=productRepositery.findById(2L).get();
        produitToUpdate.setPrice(80);
        productRepositery.save(produitToUpdate);
        System.out.println(productRepositery.findAll().stream().filter(p->p.getId()==2L).findFirst());


        //supprimer un produit

        System.out.println("-------supprimer un produit-------");
        productRepositery.deleteById(2L);

        productRepositery.findAll().forEach(p->{
            System.out.println(p);
        });


    }
}
