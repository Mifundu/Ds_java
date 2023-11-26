public class fournisseur extends personne{
    private String specialite;
    public fournisseur(int ident, String nomsocial,String adresse,String specialite){
        super(ident, nomsocial, adresse);
        this.specialite=specialite;
    }
    public String getspecialite(){
        return specialite;
    }
    public void setspecialite(String nouveau){
        specialite=nouveau;
    }
      @Override
    public void afficher(){
         super.afficher();
         System.out.print("Spécialité : "+specialite+"\n");
    }

}