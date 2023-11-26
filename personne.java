public abstract class personne{
    private int ident;
    private String nomsocial;
    private String adresse;

    protected personne(int ident,String nomsocial, String adresse){
        this.ident=ident;
        this.nomsocial=nomsocial;
        this.adresse=adresse;}
    
    
    protected int getident(){
        return ident;
    }
    protected String getnomsocial(){
        return nomsocial;
    }
    protected String getadresse(){
        return adresse;
    }

    protected void setident(int nouveau){
        ident=nouveau;
    }
     protected void setnomsocial(String nouveau){
       nomsocial=nouveau;
    }
    protected void setadresse(String nouveau){
        adresse=nouveau;
    }
    protected void afficher(){
        System.out.print("ident : "+ident+" "+"nomsocial : "+nomsocial+" "+"adresse : "+adresse+" ");
    }
    public String toString(){
        return "ident : " + ident + " nomsocial : " + nomsocial + " adresse : " + adresse + " ";
    }

 
}