package fr.arles.iut.lp.tp9;

import java.util.ArrayList;
import java.util.Random;

public class Strategie 
{
	 ArrayList<Bille> listeBille = new ArrayList<Bille>();
	 ArrayList<Boite> listeBoite = new ArrayList<Boite>();
	 Boite boite = new Boite();//nouvelle instanciation
	 int nbrBoite,nbrBille;
	 
	 public ArrayList<Boite> choixStrategie(int demandeBoite,int demandeBille,String Strategie)
	 {
		 Boite boite =new Boite();
		//récupération des paramétres
		 this.nbrBoite=(demandeBoite-1);
		 this.nbrBille=(demandeBille-1);
		 
		 //création de mes objets et stockage dans les 2 ArrayList
		 this.creeBille(nbrBille);
		 this.creeBoite(nbrBoite);
		 
		 switch(Strategie)
		 {
		 	case "Chainage":
		 		//lancement de la méthode chainage
		 		System.out.println("lancement de la méthode de chainage \n");
		 		this.chainage(nbrBoite, nbrBille);
		 		break;
		 		
		 	case "Double choix":
		 		//lancement 
		 		System.out.println("lancement de la méthode Double choix \n");
		 		this.doubleChoix(nbrBoite, nbrBille);
		 		break;
		 		
		 	case "Addressage ouvert linéaire":
		 		System.out.println("lancement de la méthode adressage ouvert linéaire");
		 		this.addressageOuvertLineaire(nbrBoite, nbrBille);
		 		break;
		 		
		 	case "Addressage ouvert quadrique":
		 		break;
		 }
		 boite.toString(listeBoite);
		 return listeBoite;
	 }
	 
	 public void creeBille(int nbrBille)
	 {
		 for(int i=0;i<=nbrBille;i++)
		 {
			 String nombille="Bille"+i;//création du nom avec le nombre de la bille
			 Bille mabille= new Bille(nombille);//création de notre objet bille
			 listeBille.add(mabille);//ajout de notre objet bille dans l'ArrayList Bille
		 }
		 System.out.println("Taille de la liste Bille: "+ listeBille.size());
	 }
	 
	 public void creeBoite(int nbrBoite)
	 {
		 for(int i=0;i<=nbrBoite;i++)
		 {
			 String nomBoite="Boite"+i;//création du nom avec le nombre de la boite
			 Boite maBoite= new Boite(nomBoite);//création de notre objet boite
			 listeBoite.add(maBoite);//ajout de notre objet boite dans l'ArrayList boite
		 }
		 System.out.println("Taille de la liste Boite: "+ listeBoite.size());
	 }
	 
		public void chainage (int nbrBoite,int nbrBille)
		{
			for(int i=0;i<=listeBille.size()-1;i++)//tant que on a des billes on mets dans les boites
			{
				//fonction random 
				Random rand = new Random();
				int nombreRandomBoite =rand.nextInt(listeBoite.size()); // le random max est égal au Nbr de Boite
				
				//gestion de bille
				Bille maBille = listeBille.get(i);//on prend l'objet bille du tableau
				maBille.numBoite=nombreRandomBoite; //on lui change sont numéro de boite
				listeBille.set(i,maBille);// on met l'objet modifié dans le tableau existant
				
				//gestion de boite
				Boite maBoite =listeBoite.get(nombreRandomBoite);//récupération de la boite choisi au hasard
				maBoite.nbrBille+=1;//on ajoute plus un au nbr de bille dans la boite
				maBoite.billecontenu.add(maBille);//ajout de la bille dans la boite
				
			}

		}
		
		public void doubleChoix(int nbrBoite,int nbrBille)
		{
			for (int iBille=0;iBille<=nbrBille;iBille++)
			{
				//fonction random
				Random rand1 =new Random();
				Random rand2 =new Random();
				
				int randomNbr1 =rand1.nextInt(listeBoite.size()); // le random max est égal au Nbr de Boite
				int randomNbr2 =rand2.nextInt(listeBoite.size()); // le random max est égal au Nbr de Boite
				
				//gestion de boite
				
				Boite Boite1 = listeBoite.get(randomNbr1);
				Boite Boite2 = listeBoite.get(randomNbr2);
				
				int nbrBille1= Boite1.nbrBille;
				int nbrBille2= Boite2.nbrBille;
				
				//gestion de bille
				Bille mabille= listeBille.get(iBille);//récupération de ma bille
				
				if(nbrBille1<nbrBille2)//si boite 1 a le moin de bille
				{
					mabille.numBoite=randomNbr1;//on affecte le nbr de la boite à mabille				
					Boite1.nbrBille+=1;//ajout de 1 bille dans la boite1
					Boite1.billecontenu.add(mabille);//ajout de ma bille dans la boite
					System.out.println("Ajout dans la boite: "+ Boite1.nom + "\n La boite ayant le plus de bille est la "+ Boite2.nom +" avec "+Boite2.nbrBille+" nombre de bille \n");
				}
				
				if(nbrBille1>nbrBille2)//si boite 2 a le moin de bille
				{
					mabille.numBoite=randomNbr2;//on affecte le nbr de la boite à mabille
					Boite2.nbrBille+=1;//ajout de 1 bille dans la boite2
					Boite2.billecontenu.add(mabille);//ajout de ma bille dans la boite
					System.out.println("Ajout dans la boite: "+ Boite2.nom + "\n La boite ayant le plus de bille est la "+ Boite1.nom +" avec "+Boite1.nbrBille+" nombre de bille \n");
				}
				
				if(nbrBille1==nbrBille2)//si égal alors ajout dans la boite 1
				{
					mabille.numBoite=randomNbr1;//on affecte le nbr de la boite à mabille					
					Boite1.nbrBille+=1;//ajout de 1 bille dans la boite1
					Boite1.billecontenu.add(mabille);//ajout de ma bille dans la boite
					System.out.println("Le nombre de bille est égal, par conséquent j'ajoute la bille dans la "+Boite1.nom+ "\n nombre de bille: "+Boite1.nbrBille +"\n");
				}
	
				
			}

		}
		
		public void addressageOuvertLineaire(int nbrBoite,int nbrBille)
		{
			for (int iBille=0;iBille<=nbrBille;iBille++)
			{
				Bille maBille= listeBille.get(iBille);//on prend la bille
				boolean mis=false;
				while(mis==false)
				{
					
					for (int iBoite=0;iBoite<=nbrBille;iBoite++)
					{
						Boite maBoite = listeBoite.get(iBoite);//on prend la boite
						if(maBoite.nbrBille==1)
						{
							System.out.println("pas mis");//pas mis
							mis=false;
							
						}
						
						else
						{
							maBille.numBoite=iBoite; //on lui change sont numéro de boite
							mis=true;
							//gestion de boite
							maBoite.nbrBille+=1;//on ajoute plus un au nbr de bille dans la boite
							maBoite.billecontenu.add(maBille);//ajout de la bille dans la boite
						}
						System.out.println("Pour la "+maBille+" je suis passé par "+iBoite+" Boite \n");
					}
				}
			}
		}
		
		

	 

}
