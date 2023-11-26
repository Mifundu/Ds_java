public class article{
    private int reference;
    private String designation;
    private double prixunitaire;
    private int quantitestock;
//constructeur parametré
    public article(int refrence,String designation, double prixunitaire,int quantitestock){
        this.reference=refrence;
        this.designation=designation;
        this.prixunitaire=prixunitaire;
        this.quantitestock=quantitestock;
    }
//constructeur parametré par copie
    public article(article a){
        this.reference=a.reference;
        this.designation=a.designation;
        this.prixunitaire=a.prixunitaire;
        this.quantitestock=a.quantitestock;
    }
//accesseur getting
    public int getrefrence(){
        return reference;
    }
    public String getdesignation(){
        return designation;
    }
    public double getprixunitaire(){
        return prixunitaire;
    }
    public int getquantitestock(){
        return quantitestock;
    }
//accesseur setting
    public void setrefrence(int nouveau){
        reference=nouveau;
    }
    public void setdesignation(String nouveau){
        designation=nouveau;
    }
    public void setprixunitaire(Double nouveau){
        prixunitaire=nouveau;
    }
    public void setquantitestock(int nouveau){
        quantitestock=nouveau;
    }
    public void afficher(){
        System.out.println("Reference : "+reference+" "+"Designation : "+designation+" "+"Prixunitaire : "+prixunitaire+" "+" Quantitéstock : "+quantitestock);
    }
}