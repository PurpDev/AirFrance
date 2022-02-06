package vue;

import java.awt.Color;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.AirFrance;
import controleur.User;

public class VueGenerale extends JFrame implements ActionListener
{
	private JPanel panelMenu = new JPanel(); 
	private JButton btProfil = new JButton("Profil"); 
	private JButton btPilotes = new JButton("Pilotes");
	private JButton btAvions = new JButton("Avions");
	private JButton btVols = new JButton("Vols");
	private JButton btStats = new JButton("Statistiques");
	private JButton btBord = new JButton("T-Bord");
	private JButton btDeconnexion= new JButton("Déconnexion");
	
	private JPanel panelProfil = new JPanel(); 
	
	public VueGenerale(User unUser)
	{
		this.setTitle("Administration des vols Air France ");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 100, 800, 400);
		this.setLayout(null);
		this.setResizable(false);
		this.getContentPane().setBackground(Color.cyan);
		
		//contruction du Panel Menu 
		this.panelMenu.setLayout(new GridLayout(1, 7));
		this.panelMenu.setBounds(20, 20, 760, 40);
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btPilotes);
		this.panelMenu.add(this.btAvions);
		this.panelMenu.add(this.btVols);
		this.panelMenu.add(this.btStats);
		this.panelMenu.add(this.btBord);
		this.panelMenu.add(this.btDeconnexion);
		this.panelMenu.setBackground(Color.cyan);
		this.add(this.panelMenu);
		
		//construction du panel Profil 
		this.panelProfil.setBounds(100, 100, 500, 200);
		this.panelProfil.setLayout(new GridLayout(4, 1));
		this.panelProfil.add(new JLabel("Nom User    : " + unUser.getNom()));
		this.panelProfil.add(new JLabel("Prénom User : " + unUser.getPrenom())); 
		this.panelProfil.add(new JLabel("Email User  : " + unUser.getEmail())); 
		this.panelProfil.add(new JLabel("Role User   : " + unUser.getRole())); 
		this.panelProfil.setVisible(false);
		
		this.add(panelProfil);
		
		//rendre les boutons ecoutables 
		this.btDeconnexion.addActionListener(this);
		this.btProfil.addActionListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btDeconnexion)
		 {
			 AirFrance.detruireVueGenerele();
			 AirFrance.rendreVisibleVueConnexion(true);
		 }
		 else if (e.getSource() == this.btProfil)
		 {
			 this.panelProfil.setVisible(true);
		 }
		
	}

}
