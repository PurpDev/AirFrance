package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.AirFrance;
import controleur.User;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel unPanel = new JPanel(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btSeConnecter = new JButton("Se Connecter"); 
	private JTextField txtEmail = new JTextField(); 
	private JPasswordField txtMdp = new JPasswordField(); 
	
	public VueConnexion()
	{
		this.setTitle("Connexion au Logiciel Admin-AirFrance");
		this.setBounds(200, 100, 700, 300);
		this.getContentPane().setBackground(Color.cyan);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//construire le panel de connexion 
		this.unPanel.setBounds(350, 50, 300, 180);
		this.unPanel.setLayout(new GridLayout(3,2));
		this.unPanel.setBackground(Color.cyan);
		this.unPanel.add(new JLabel("Email : ")); 
		this.unPanel.add(this.txtEmail); 
		this.unPanel.add(new JLabel("MDP : ")); 
		this.unPanel.add(this.txtMdp); 
		this.unPanel.add(this.btAnnuler); 
		this.unPanel.add(this.btSeConnecter); 
		
		//ajout d'une image 
		ImageIcon uneImage = new ImageIcon("src/images/logo.png");
		JLabel   logo = new JLabel(uneImage); 
		logo.setBounds(10, 50, 320, 180);
		this.add(logo); 
		
		this.add(this.unPanel); //ajout du pannel dans la fenetre 
		
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btSeConnecter.addActionListener(this);
		
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
		if(e.getSource() == this.btAnnuler)
		{
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else if (e.getSource() == this.btSeConnecter)
		{
			traitement (); 
		}
	}
	
	public void traitement ()
	{
		String email = this.txtEmail.getText(); 
		String mdp = new String (this.txtMdp.getPassword()); 
		
		User unUser = AirFrance.selectWhereUser(email, mdp); 
		if (unUser == null)
		{
			JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		}
		else {
			JOptionPane.showMessageDialog(this, "Bienvenue "
					+ unUser.getNom()+"  "+unUser.getPrenom()
					+"\n\n Vous avez le rôle : " + unUser.getRole()); 
			//lancer l'application VueGenerale 
			AirFrance.instancierVueGenerale(unUser);
			
			//on rend invisible la vueConnexion 
			AirFrance.rendreVisibleVueConnexion(false);
			this.txtEmail.setText("");
			this.txtMdp.setText("");	
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			traitement (); 
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}










