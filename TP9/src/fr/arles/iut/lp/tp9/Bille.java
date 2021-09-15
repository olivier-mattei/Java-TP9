package fr.arles.iut.lp.tp9;

public class Bille 
{
	String nom;
	int numBoite;
	
	public Bille(String nombille) 
	{
		this.nom= nombille;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {//méthode d'affichage d'un objet de type Bille
		
		String billeAfficher="Bille [nom=" + nom + ", numBoite=" + numBoite + "]";
		System.out.println(billeAfficher);
		return billeAfficher;
	}
}
