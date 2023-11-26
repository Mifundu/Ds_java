
import java.util.Date;
public class commande{
    private int numcomm;
    private Date datecomm;
    private Client client;

    public commande(int numcomm, Date datecomm, Client client){
        this.numcomm=numcomm;
        this.datecomm=datecomm;
        this.client=client;
    }
    //accesseur getting
    public int getnumcomm(){
        return numcomm;
    }
    public Date getdatecomm(){
        return datecomm;
    }
    public Client getclient(){
        return client;
    }
    //accesseur setting
    public void setnumcomm(int nouveau){
        numcomm=nouveau;
    }
    public void setdatecomm(Date nouveau){
         datecomm=nouveau;
    }
    public void setclient(Client nouveau){
        client=nouveau;
    }
    public void afficher(){
        System.out.println("Numéro de la commande : "+numcomm+" "+"Date de la commande : "+datecomm+" "+"Client : "+client);
    }
}