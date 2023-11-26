public class ligne {

    private commande commande;
    private article article;
    private int quantitecomm;
    

    public ligne(commande commande, article article, int quantitecomm){
        this.commande=commande;
        this.article=article;
        this.quantitecomm=quantitecomm;
    }
    //accesseur getting
    public commande getCommande(){
        return commande;
    }
    public article getaArticle(){
        return article;
    }
    public int getquantitecomm(){
        return quantitecomm;
    }
//accesseur setting
    public void setCommande(commande nouveau){
        commande=nouveau;
    }
    public void setaArticle(article nouveau){
        article=nouveau;
    }
    public void setcquantitecomm(int nouveau){
         quantitecomm=nouveau;
    }
}