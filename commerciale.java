import java.util.Vector;   
import java.util.Scanner;
import java.util.Date;
import java.util.InputMismatchException;
public class commerciale {
    //déclaration et initialisation des vecteurs 
    private static Vector<article> articles=new Vector<>();
    private static Vector<Client>clients=new Vector<>();
    private static Vector<commande> commandes=new Vector<>();
    private static Vector<ligne> lignes=new Vector<>();
    public static void Passercommande(commande c){
        //ajouter la commande c passé en paramètre dans le vecteur commandes
        commandes.add(c);
    }
    public static void Annulercommande(commande c){
        //supprimer une commande si le vecteur commandes contient des commandes afficher un message
        if (commandes.size()==0)
            System.out.print("Le vecteur commandes est vide vous ne pouvez pas faire de suppression\n");
        else
            commandes.remove(c);
    }
    public static void AjouterArticle(article a){
        //ajouter l'article a passé en parametré dans le vecteur articles 
        articles.add(a);
    }
    public static void SupprimerArticle(article a){
        //supprimer un article si le vecteur articles contient des commandes afficher un message
        if(articles.size()==0)
            System.out.print("Le vecteur articles est vide vous ne pouvez pas faire de suppression\n");
        else
            articles.remove(a);
    }
    public static void AjouterClient(Client c){
        //ajouter le client c passé en paramètre dans le vecteur clients
        clients.add(c);
    }
    public static void SupprimerClient(Client c){
        //supprimer un client si le vecteur clients contient des commandes afficher un message
        if (clients.size()==0)
            System.out.print("Le vecteur clients est vide vous ne pouvez pas faire de suppression\n");
        else
            clients.remove(c);
    }
    public static void main(String args[]) {
        Scanner clavier= new Scanner(System.in);
        int n=0;
        boolean saisit=false;
        do{ 
            do{
                try{
                    System.out.println("--------------------GESTION COMMERCIALE--------------------\n1)Ajouter un article\n2)Supprimer un article\n3)Ajouter un client\n4)Supperimer un client\n5)Passer commande\n6)Annuler commande\n0)Quitter");
                    System.out.print("Entrez un nombre : \n");
                    n=clavier.nextInt();
                    saisit=true;
                }catch(InputMismatchException e){
                    System.err.println("\nErreur de saisit\n");
                    clavier.nextLine();//je vide le tampon de saisie
                }
            }while(!saisit);
            
            
            switch(n){
                case 1:
                    //Controle la saisit des toutes les entrées 
                    do{
                        try{
                            //Je demande à l'utilisateur d'entrez les données corespondant à l'article
                            System.out.println("--------------------Ajout d'un article--------------------");
                            System.out.print("Entrez la reférence de l'article : \n");
                            int ref=clavier.nextInt();
                            boolean x=false;
                            //contrôle de saisit pour ne pas entrer deux fois le même article
                            if(articles.size()!=0){
                                do{
                                    for(article e:articles)
                                        if(e.getrefrence()==ref){
                                            System.out.print("L'article "+ref+" existe déjà\n");
                                            System.out.print("Entrez la reférence de l'article : \n");
                                            ref=clavier.nextInt();
                                            break;
                                        }
                                        else
                                            x=true;
                                }while(!x);
                                
                            }
                            clavier.nextLine();//je vide le tampon de saisie
                            System.out.print("Entrez la désignation de l'article : \n");
                            String des=clavier.nextLine();
                            System.out.print("Entrez le prix unitaire de l'article : \n");
                            Double prixunit=clavier.nextDouble();
                            System.out.print("Entrez la quantité de stock de l'article : \n");
                            int quantstock=clavier.nextInt();
                            //je stocke les informations réçu dans le vecteur articles de type article
                            article c=new article(ref, des,prixunit,quantstock);
                            AjouterArticle(c);
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit);
                   
                    //Affichage des articles stockés dans le vecteur articles 
                    System.out.println("----------------Listes des Articles-------------------\n");
                    for(article a : articles)
                        a.afficher();
                    System.out.print("\n");
                    break;

                case 2:
                    //Supression d'un article
                    do{
                        try{
                            System.out.println("--------------------Supression d'un article--------------------");
                            System.out.println("Donnez la reférence de l'article à supprimer : \n" );
                            int x=clavier.nextInt();
                            article tmp=null;
                            boolean tr=false;
                            for(article a : articles){
                                if(a.getrefrence()==x){
                                    tmp=a;
                                    tr=true;
                                }
                            }
                            System.out.println("----------------Avant la suppression-------------------\n");
                            for(article a : articles)
                                a.afficher();
                            System.out.print("\n");
                            System.out.print("Taille: "+articles.size()+"\n");
                            if (tr==true){
                                SupprimerArticle(tmp); 
                                System.out.println("--------------------Après la suppression--------------------\n"); 
                                for(article a : articles)
                                a.afficher();
                                System.out.print("\n");
                                System.out.println("Taille: " + articles.size()+"\n");
                                System.out.println("L'article numéro "+x+" a bien été supprimé.\n");
                            }
                            else{
                                SupprimerArticle(tmp); 
                                System.out.println("L'article numéro "+x+" n'a pas été trouvé.");
                            }
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit);
                    break;
                    
                case 3:
                    do{
                        try{
                            System.out.println("--------------------Ajout d'client--------------------");
                            System.out.print("Entrez l'identifiant du client  : \n");
                            int ident=clavier.nextInt();
                            boolean x=false;
                            if(clients.size()!=0){
                                do{
                                    for(Client e:clients)
                                        if(e.getident()==ident){
                                            System.out.print("Le client "+ident+" existe déjà\n");
                                            System.out.print("Entrez l'identifiant du client : \n");
                                            ident=clavier.nextInt();
                                            break;
                                        }
                                        else
                                            x=true;
                                }while(!x);
                                
                            }
                            clavier.nextLine();
                            System.out.print("Entrez le nom socialt du client  : ");
                            String nomso=clavier.nextLine();
                            System.out.print("Entrez l'adresse du client  : ");
                            String adresse=clavier.nextLine();
                            System.out.print("Entrez le chiffre d'affaire du client  : ");
                            Double chiffaf=clavier.nextDouble();
                            Client cli=new Client(ident, nomso, adresse,chiffaf);
                            AjouterClient(cli);
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit);

                    System.out.println("--------------------liste des clients--------------------");
                    for(Client e : clients)
                        e.afficher();
                    break;
            
                case 4:
                    do{
                        try{
                            System.out.println("--------------------Supression d'un client--------------------");
                            System.out.println("Donnez l'identifiant du client à supprimer : " );
                            int z=clavier.nextInt();
                            Client tmpc=null;
                            boolean trc=false;
                            for(Client a : clients){
                                if(a.getident()==z){
                                    tmpc=a;
                                    trc=true;
                                }
                            }
                            System.out.println("----------------Avant la suppression-------------------\n");
                            for(Client a : clients)
                                a.afficher();
                            System.out.print("\n");
                            System.out.print("Taille: "+clients.size()+"\n");
                            if (trc==true){
                                SupprimerClient(tmpc); 
                                System.out.println("--------------------Après la suppression--------------------\n"); 
                                for(Client a : clients)
                                    a.afficher();
                                System.out.print("\n");
                                System.out.println("Taille: " + clients.size()+"\n");
                                System.out.println("Le client "+z+" a bien été supprimé.\n");
                            }
                            else{
                                SupprimerClient(tmpc); 
                                System.out.println("Le client "+z+" n'a pas été trouvé.");
                            }
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit);   
                    for(Client a : clients)
                        a.afficher();
                    break;
                case 5:
                    do{
                        try{
                            System.out.println("--------------------Passer commande--------------------");
                            System.out.print("Entrez le numéro de la commande : ");
                            int numco=clavier.nextInt();
                            boolean x=false;
                            
                            if(commandes.size()!=0){
                                do{
                                    for(commande e:commandes)
                                        if(e.getnumcomm()==numco){
                                            System.out.print("La commande "+numco+" existe déjà\n");
                                            System.out.print("Entrez le numéro de la commande : \n");
                                            numco=clavier.nextInt();
                                            clavier.nextLine();
                                            break;
                                            
                                        }
                                        else
                                            x=true;
                                }while(!x);
                                
                            }
                            System.out.print("Entrez l'identifiant du client  : ");
                            int identCo=clavier.nextInt();
                            clavier.nextLine();
                            System.out.print("Entrez le nom socialt du client  : ");
                            String nomsoCo=clavier.nextLine();
                            System.out.print("Entrez l'adresse du client  : ");
                            String adresseCo=clavier.nextLine();
                            System.out.print("Entrez le chiffre d'affaire du client  : ");
                            Double chiffafCo=clavier.nextDouble();
                            commande co=(new commande(numco, new Date(), new Client(identCo, nomsoCo,adresseCo , chiffafCo)));
                            Passercommande(co);
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit);
                    System.out.println("--------------------Liste des commandes--------------------"); 
                    for(commande a : commandes)
                        a.afficher();
                    break;
                case 6:
                    do{
                        try{
                            System.out.println("--------------------Supression d'une commande--------------------");
                            System.out.println("Donnez le numéro de la commande à supprimer : " );
                            int xc=clavier.nextInt();
                            commande tmpco=null;
                            boolean trco=false;
                            for(commande a : commandes){
                                if(a.getnumcomm()==xc){
                                    tmpco=a;
                                    trco=true;
                                }
                            }
                            System.out.println("----------------Avant la suppression-------------------\n");
                            for(commande a: commandes)
                                a.afficher();
                            System.out.print("\n");
                            System.out.print("Taille: "+commandes.size()+"\n");
                            if (trco==true){
                                Annulercommande(tmpco); 
                                System.out.println("--------------------Après la suppression--------------------\n"); 
                                for(commande a: commandes)
                                    a.afficher();
                                System.out.print("\n");
                                System.out.println("Taille: " + commandes.size()+"\n");
                                System.out.println("La commande "+xc+" a bien été supprimé.\n");
                            }
                            else{
                                Annulercommande(tmpco);
                                System.out.println("La commande "+xc+" n'a pas été trouvé.");
                            }
                            saisit=true;
                        }catch(InputMismatchException e){
                            System.err.println("\nErreur de saisit\n");
                            clavier.nextLine();//je vide le tampon de saisie
                        }
                    }while(!saisit); 
                    break;
                case 0:
                    System.out.println("Au revoir. :)");
                    System.exit(0);
                    break;
                default:
                        System.out.println("Veuillez enter un chiffre correspondnat svp");
            }
    }while(n!=0);
    clavier.close();
    
}
}