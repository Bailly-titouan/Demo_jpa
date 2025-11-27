package fr.diginamic.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="LIVRE")
public class Livre
{
    @Id
    private int id;
    private String titre;
    private String auteur;
    @ManyToMany
    @JoinTable(name="compo",
            joinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID"),
            inverseJoinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"))
    private Set<Emprunt> emprunts;

    public String getTitre() { return this.titre; }
    public String getAuteur() { return this.auteur; }
    public int getId() { return this.id; }

    public void setTitre(String titre) { this.titre = titre; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public void setId(int id) {this.id = id; }

    public Livre()
    {
        emprunts = new HashSet<Emprunt>();
    }

    @Override
    public String toString()
    {
        return (this.titre + " écrit par " + this.auteur + " | ID : " + this.id);
    }
}
