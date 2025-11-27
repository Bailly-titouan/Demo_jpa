package fr.diginamic.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Client
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    @OneToMany(mappedBy="client")
    private Set<Emprunt> emprunts;


    public String getNom() { return this.nom; }
    public String getPrenom() {return this.prenom; }
    public int getId() { return this.id; }
    public Set<Emprunt> getEmprunts() { return this.emprunts; }

    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setId(int id) {this.id = id; }
    public void setEmprunts(Set<Emprunt> emprunts) { this.emprunts = emprunts; }


    public Client()
    {
        emprunts = new HashSet<Emprunt>();
    }

}
