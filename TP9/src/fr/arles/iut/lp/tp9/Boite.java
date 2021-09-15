package fr.arles.iut.lp.tp9;

import java.util.ArrayList;

public class Boite 
{
	String nom;
	int nbrBille;
	ArrayList <Bille> billecontenu = new ArrayList<Bille>();
	
	public Boite(String nomBoite)
	{
		this.nom=nomBoite;
		
	}

	public Boite() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() { //m�thode d'affichage d'un objet de type Boite
		String boiteAfficher= "Boite [nom=" + nom + ", nbrBille=" + nbrBille + ", billecontenu=" + billecontenu + "]";
		System.out.println(boiteAfficher);
		return boiteAfficher ;
	}
	
	public void toString(ArrayList<Boite>listeBoite ) { //m�thode d'affichage d'une Arraylist avec des objet de type Boite � l'int�rieur
		for (int iBoite=0;iBoite<=listeBoite.size()-1;iBoite++)
		{
			Boite boite= listeBoite.get(iBoite);//recup�ration de la boite
			String boiteAfficher= " Boite [nom=" + boite.nom + ", nbrBille=" + boite.nbrBille + ", billecontenu=" + boite.billecontenu + "]";
			System.out.println(boiteAfficher+"\n");
		}
	}

}
