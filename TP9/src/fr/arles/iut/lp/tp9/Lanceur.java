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
		//gestion de la fen�tre
		setTitle("Jeu des billes");
		getContentPane().setBackground(Color.white);
		setSize(850,1000);
		setLocationRelativeTo(null) ; //centre la fen�tre au milieu de l'�cran
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//termine l'application
	}

	public static void main(String[] args) 
	{
		Lanceur fenetre = new Lanceur();
		
		//cr�ation des composant graphique
		JTextField textNbrBoite = new JTextField();
		JTextField textNbrBille= new JTextField();
		String[] messageStrings = {"Chainage", "Double choix", "Addressage ouvert lin�aire", "Addressage ouvert quadrique"};// on cr�e le tableau
		JComboBox choixStrat = new JComboBox(messageStrings); //on lit la List au �l�ments du tableau
		JButton btnLance = new JButton("Lanc�");

		//personnalisation des composants graphique
		textNbrBoite.setText("Nombre de boite");
		textNbrBille.setText("Nombre de bille");
		
		//couche dessin
		JPanel panel1 =new JPanel();//cr�ation de mon objet JPanel
		panel1.add(textNbrBoite);//ajout de boite
		panel1.add(textNbrBille);//ajout de bille
		panel1.add(choixStrat);//ajout des diff�rente strat�gie
		panel1.add(btnLance);//ajout du bouton
		
		fenetre.add(panel1); //ajout du panel dans la fen�tre
		
		fenetre.setVisible(true);//affichage de la fen�tre 
		
		//cr�ation de l'action au click du bouton
		btnLance.addActionListener(new ActionListener() 
		{
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//r�cup�ration des valeurs + cast des JTextField
				String SnbrBoite= textNbrBoite.getText();//r�cup�re en type string Boite
				String SnbrBille= textNbrBille.getText();//r�cup�re en type string Bille
				int nbrBoite=Integer.parseInt(SnbrBoite);//cast du String vers un type entier
				int nbrBille=Integer.parseInt(SnbrBille);
				
				
				//r�cup�ration de la valeurs JComboBox
				int numChoixLister=choixStrat.getSelectedIndex();//retourne le int de l'index
				String strategieChoix= messageStrings[numChoixLister];//on met le string demand�
						
				if(nbrBille>=(nbrBoite/2)&& nbrBille<=nbrBoite)//si nbr de bille compris entre K/2 et K
				{
					Strategie strat = new Strategie();
					ArrayList<Boite> listBoite = new ArrayList<Boite>();//cr�ation de ma nouvelle liste boite
					listBoite=strat.choixStrategie(nbrBoite, nbrBille, strategieChoix); //appelle de la strategie et r�cup�ration de la liste renvoy�
					
//					for (int iBille=0;iBille=<boite.nbrBille;iBille++)//on dessine les billes
//					{
//						char cercle = '\u25CF';
//						String mybille = cercle;
//						System.out.println(mybille); //displays "? result"
//					}
						
				}
				
				else
				{
					System.out.println("Erreur: le nombre de bille demand� ne se situe pas entre le nombre de Boite/2 et la nombre de Boite");
					//Bo�te du message d'erreur
					JOptionPane winErreurNbrBille = new JOptionPane();
					winErreurNbrBille.showMessageDialog(null, "le nombre de bille demand� ne se situe pas entre le nombre de Boite/2 et le nombre de Boite total", "Erreur nombre de bille", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});

	
	}
	
}
