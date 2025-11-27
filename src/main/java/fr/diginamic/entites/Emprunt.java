package fr.diginamic.entites;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Emprunt
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int delai;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @ManyToMany
    @JoinTable(name="compo",
                joinColumns = @JoinColumn(name="ID_EMP", referencedColumnName="ID"),
                inverseJoinColumns = @JoinColumn(name="ID_LIV", referencedColumnName="ID"))
    private Set<Livre> livres;

    @ManyToOne
    @JoinColumn(name="ID_CLIENT")
    private Client client;

    public int getId() {return this.id; }
    public Date getDateDebut() {return this.dateDebut; }
    public Date getDateFin() {return this.dateFin; }
    public Client getClient() {return this.client; }

    public void setId(int id) {this.id = id;}
    public void setDateDebut(Date date) {this.dateDebut = date;}
    public void setDateFin(Date date) {this.dateFin = date;}
    public void setClient(Client client) {this.client = client;}

    public Emprunt()
    {
        livres = new HashSet<Livre>();
    }

    @Override
    public String toString()
    {
        return ("Date début : " + dateDebut + " | date fin : " + dateFin + " | emprunté par : " + client.getPrenom() + " " + client.getNom());
    }
}
