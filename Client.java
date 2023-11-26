public class Client extends personne{
    private Double chiffreaffaire;
    public Client(int ident, String nomsocial, String adresse, double chiffreaffaire){
        super(ident, nomsocial, adresse);
        this.chiffreaffaire=chiffreaffaire;
    }
    public Double getChiffreaffaire(Double nouveau){
        return chiffreaffaire;
    }
    public void setChiffreaffaire(Double nouveau){
        chiffreaffaire=nouveau;
    }
    @Override
    public void afficher(){
         super.afficher();
         System.out.print("chiffreaffaire : "+chiffreaffaire+"\n");
    }
    
}