import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HelpWindow extends JFrame {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel helpText = new JLabel();

	public HelpWindow() {
		initWindow();
	}
	
	public void setHelpText(int type) {
		switch(type) {
			case 1: helpText.setText("<html>Median lisaysohjeet<br> Median lisays on kivaa jee!</html>");				
			break;
			case 2: helpText.setText("<html>Median etsintaohjeet<br> Median etsinta on helppoa</html>");
									
			break;
			case 3: helpText.setText("<html>Median poistoohjeet <br> Median poistaminen kay katevasti</html>");
									
			break;
			case 4: helpText.setText("<html>Median muokkausohjeet <br> Median muokkaus on nopeaa toimintaa ja ehka hieman pervoa</html>");
									
			break;
			default: helpText.setText("<html>Median etsintaohjeet <br>Median etsinta on helppoa</html>");
									
			break;
		}
	}
	
	public final void initWindow() {
		 JPanel panel = new JPanel();
		 getContentPane().add(panel);
		 panel.setLayout(new BorderLayout());
		 
		 helpText.setText("Valitse painikeesta ohje mita haluat tarkastella");
		 
		 
		 JButton mediaAddHelp = new JButton("Median lisays ohjeet");
		 mediaAddHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(1);
		    	}
		 });
		 
		 JButton mediaSearchHelp = new JButton("Median etsintaohjeet");
		 mediaSearchHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(2);
		    	}
		 });
		 
		 JButton mediaDeleteHelp = new JButton("Median poistoohjeet");
		 mediaDeleteHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(3);
		    	}
		 });
		 
		 JButton mediaModifyHelp = new JButton("Median muokkausohjeet");
		 mediaModifyHelp.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent event) {
		    		setHelpText(4);
		    	}
		 });
		 
		 JPanel north = new JPanel();
		 JPanel center = new JPanel();
		 center.setBorder(BorderFactory.createLineBorder(Color.black));
		    
		 panel.add(north, BorderLayout.NORTH);
		 panel.add(center, BorderLayout.CENTER);
		    
		 north.add(mediaAddHelp);
		 north.add(mediaSearchHelp);
		 north.add(mediaDeleteHelp);
		 north.add(mediaModifyHelp);
		 
		 center.add(helpText);

		 setTitle("Media Collector");
		 setSize(800, 600);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
