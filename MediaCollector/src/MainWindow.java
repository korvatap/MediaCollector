import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

//import statements
//Check if window closes automatically. Otherwise add suitable code
public class MainWindow extends JFrame {
	
	public MainWindow() {
		initUI();
	}
	
	public final void initUI() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    
        panel.setToolTipText("NII VITTU USKALLA");
	       
        Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", "Row1-Column4" },
        		{ "Row2-Column1", "Row2-Column2", "Row2-Column3", "Row2-Column4" } };
		Object columnNames[] = { "Kategoria", "Nimi", "Arvosana", "Poista" };
	    JTable table = new JTable(rowData, columnNames);
	    JScrollPane scrollPane = new JScrollPane(table);
	    table.setFillsViewportHeight(true);
	       
	    JButton quitButton = new JButton("Quit");
	    //quitButton.setBounds(50, 60, 80, 30);
	    quitButton.setToolTipText("SAMMUTA MUT PRKL");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		System.exit(0);
	    	}
	    });
   
	    JTextField search = new JTextField(20);
   
	    JButton searchButton = new JButton("Etsi");
	    searchButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    	}
	    });
	       
	    JButton addButton = new JButton("Lis‰‰");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
                AddMediaWindow xe = new AddMediaWindow();
                xe.setVisible(true);
	    	}
	    });
	       
	    JButton removeButton = new JButton("Poista");
	    removeButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		PromptWindow pw = new PromptWindow("Oletko varma etta haluat poistaa?");
	    		pw.setVisible(true);
	    	}
	    });
	       
	    JButton helpButton = new JButton("Ohjeet");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });

	    JPanel north = new JPanel();
	    JPanel south = new JPanel();
	    JPanel center = new JPanel();
	    
	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    
	    south.add(addButton);
	    south.add(removeButton);
	    south.add(helpButton);
	    south.add(quitButton);
	    
	    north.add(search);
	    north.add(searchButton);

	    center.add(scrollPane);
   

	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	try {
	            		FileParser fp = new FileParser();
	            		//fp.readFile();
	            		
	            		fp.printWords();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                MainWindow ex = new MainWindow();
	                ex.setVisible(true);
	            }
	        });
	}
	
}


