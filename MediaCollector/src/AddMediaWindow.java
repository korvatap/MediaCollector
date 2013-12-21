import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTable;


public class AddMediaWindow extends JFrame{

	/**
	 * @param args
	 */
	
	private String[] mediaTypes = { "Ebullient", "Obtuse", "Recalcitrant", "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent" };
	private String[] categories = { "Ebullient", "Obtuse", "Recalcitrant", "Brilliant", "Somnescent", "Timorous", "Florid", "Putrescent" };  
	
	public AddMediaWindow() {
		initWindow();
	}
	
	
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    
        panel.setToolTipText("NII VITTU USKALLA");
	    
        JLabel mediaTitle = new JLabel("Media",JLabel.CENTER); 
        JLabel nameTitle = new JLabel("Name", JLabel.CENTER);
        JLabel categoryTitle = new JLabel("Category", JLabel.CENTER);
	   
	    JComboBox type = new JComboBox();
	    
	    for (int i = 0; i < mediaTypes.length; i++) {
	        type.addItem(mediaTypes[i]);
	    }
	    
	    JComboBox category = new JComboBox();
	    
	    for (int i = 0; i < categories.length; i++) {
	        category.addItem(categories[i]);
	    }
	    
	    JTextField name = new JTextField("mm");
	    JTextField setti = new JTextField("SEK");
   
	    JButton addButton = new JButton("Lisää");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    	}
	    });
	       
	    JButton nextButton = new JButton("Seuraava");
	    nextButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    	}
	    });
	       
	    JButton cancelButton = new JButton("Peruuta");
	    cancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    	}
	    });
	       

	    JPanel north = new JPanel();
	    JPanel south = new JPanel();
	    JPanel center = new JPanel();
	    
	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    
	    south.add(addButton);
	    south.add(nextButton);
	    south.add(cancelButton);
	    
	    north.add(mediaTitle, BorderLayout.LINE_START);
	    north.add(nameTitle, BorderLayout.CENTER);
	    north.add(categoryTitle, BorderLayout.LINE_END);
	   
	   // north.add(searchButton);

	    center.add(type);
	    center.add(name);
	    center.add(setti);
   
	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
