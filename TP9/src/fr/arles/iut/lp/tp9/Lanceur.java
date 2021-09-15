package fr.arles.iut.lp.tp9;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Lanceur extends JFrame
{
	public Lanceur()
	{
		//gestion de la fenêtre
		setTitle("Jeu des billes");
		getContentPane().setBackground(Color.white);
		setSize(850,1000);
		setLocationRelativeTo(null) ; //centre la fenêtre au milieu de l'écran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//termine l'application
	}

	public static void main(String[] args) 
	{
		Lanceur fenetre = new Lanceur();
		
		//création des composant graphique
		JTextField textNbrBoite = new JTextField();
		JTextField textNbrBille= new JTextField();
		String[] messageStrings = {"Chainage", "Double choix", "Addressage ouvert linéaire", "Addressage ouvert quadrique"};// on crée le tableau
		JComboBox choixStrat = new JComboBox(messageStrings); //on lit la List au éléments du tableau
		JButton btnLance = new JButton("Lancé");

		//personnalisation des composants graphique
		textNbrBoite.setText("Nombre de boite");
		textNbrBille.setText("Nombre de bille");
		
		//couche dessin
		JPanel panel1 =new JPanel();//création de mon objet JPanel
		panel1.add(textNbrBoite);//ajout de boite
		panel1.add(textNbrBille);//ajout de bille
		panel1.add(choixStrat);//ajout des différente stratégie
		panel1.add(btnLance);//ajout du bouton
		
		fenetre.add(panel1); //ajout du panel dans la fenêtre
		
		fenetre.setVisible(true);//affichage de la fenêtre 
		
		//création de l'action au click du bouton
		btnLance.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//récupération des valeurs + cast des JTextField
				String SnbrBoite= textNbrBoite.getText();//récupère en type string Boite
				String SnbrBille= textNbrBille.getText();//récupère en type string Bille
				int nbrBoite=Integer.parseInt(SnbrBoite);//cast du String vers un type entier
				int nbrBille=Integer.parseInt(SnbrBille);
				
				
				//récupération de la valeurs JComboBox
				int numChoixLister=choixStrat.getSelectedIndex();//retourne le int de l'index
				String strategieChoix= messageStrings[numChoixLister];//on met le string demandé
						
				if(nbrBille>=(nbrBoite/2)&& nbrBille<=nbrBoite)//si nbr de bille compris entre K/2 et K
				{
					Strategie strat = new Strategie();
					ArrayList<Boite> listBoite = new ArrayList<Boite>();//création de ma nouvelle liste boite
					listBoite=strat.choixStrategie(nbrBoite, nbrBille, strategieChoix); //appelle de la strategie et récupération de la liste renvoyé
					
//					for (int iBille=0;iBille=<boite.nbrBille;iBille++)//on dessine les billes
//					{
//						char cercle = '\u25CF';
//						String mybille = cercle;
//						System.out.println(mybille); //displays "? result"
//					}
						
				}
				
				else
				{
					System.out.println("Erreur: le nombre de bille demandé ne se situe pas entre le nombre de Boite/2 et la nombre de Boite");
					//Boîte du message d'erreur
					JOptionPane winErreurNbrBille = new JOptionPane();
					winErreurNbrBille.showMessageDialog(null, "le nombre de bille demandé ne se situe pas entre le nombre de Boite/2 et le nombre de Boite total", "Erreur nombre de bille", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});

	
	}
	
}
