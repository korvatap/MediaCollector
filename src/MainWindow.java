import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

//import statements
//Check if window closes automatically. Otherwise add suitable code

class BTableModel extends DefaultTableModel {
	
	public Class<?> getColumnClass(int column) {
		switch (column) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return String.class;
		default:
			return Boolean.class;
		}
	}
	
	
	BTableModel(String type) {
		switch (type) {
			case "TVSeries":
				this.addColumn("Title");
				this.addColumn("Series");
				this.addColumn("Episode");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				this.addColumn("Delete");
				break;
			case "Music":
				this.addColumn("Title");
				this.addColumn("Artist");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				this.addColumn("Delete");
				break;
				
			case "Movie":
				this.addColumn("Title");
				this.addColumn("Language");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				this.addColumn("Delete");
				break;
		}
	}
	
	BTableModel() {}
	
}

public class MainWindow extends JFrame {
	
	MediaObject database;
	JScrollPane tvScrollPane;
	JScrollPane movieScrollPane;
	JScrollPane musicScrollPane;
    //Create table models for TV, movie, music
    BTableModel tvModel = new BTableModel("TVSeries");
    BTableModel movieModel = new BTableModel("Movie");
    BTableModel musicModel = new BTableModel("Music");
    
    //CREATE TABLES FOR TV, movie, music
    JTable tvTable = new JTable(tvModel);
    JTable movieTable = new JTable(movieModel);
    JTable musicTable = new JTable(musicModel);
    
    JTextField search = new JTextField(20);
    String searchInput;
    
    JTabbedPane tabbedPane = new JTabbedPane();
	
	public MainWindow() {}
	public MainWindow(MediaObject database) {
		initUI();
		this.database = database;
	}
	
	public final void initUI() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    BorderLayout panelLayout = new BorderLayout();
	    panelLayout.setHgap(10);
	    panelLayout.setVgap(10);
	    panel.setLayout(panelLayout);
	    
        panel.setToolTipText("NII VITTU USKALLA");
        
	    tvScrollPane = new JScrollPane(tvTable);
	    movieScrollPane = new JScrollPane(movieTable);
	    musicScrollPane = new JScrollPane(musicTable);
	    
	    tvTable.setFillsViewportHeight(true);
	    movieTable.setFillsViewportHeight(true);
	    musicTable.setFillsViewportHeight(true);
	       
	    JButton quitButton = new JButton("Quit");
	    //quitButton.setBounds(50, 60, 80, 30);
	    quitButton.setToolTipText("SAMMUTA MUT PRKL");
	    quitButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		System.exit(0);
	    	}
	    });
   
	    JButton searchButton = new JButton("Search");
	    searchButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		if(!search.getText().equals("")) {
		    		searchInput = search.getText();
		    		searchDatabase(searchInput);
		    		searchInput = "";
	    		} else {
	    			if(tabbedPane.getSelectedIndex() == 0) {
	    				movieModel.setRowCount(0);
	    				getRows("Movie");
	    			} else if (tabbedPane.getSelectedIndex() == 1) {
	    				musicModel.setRowCount(0);
	    				getRows("Music");
	    			} else {
	    				tvModel.setRowCount(0);
	    				getRows("TVSeries");
	    			}
	    		}
	
	    	}
	    });
	       
	    JButton addButton = new JButton("Add");
	    addButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
                AddMediaWindow xe = new AddMediaWindow();
                xe.setVisible(true);
	    	}
	    });
	       
	    JButton removeButton = new JButton("Delete");
	    removeButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		PromptWindow pw = new PromptWindow("Oletko varma etta haluat poistaa?");
	    		pw.setVisible(true);
	    	}
	    });
	       
	    JButton helpButton = new JButton("Manual");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });
	    
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });
	    
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });
	    
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });

        GridLayout tabbedGrid = new GridLayout(1,2);
	    JPanel north = new JPanel(tabbedGrid);
	    JPanel south = new JPanel();
	    JPanel center = new JPanel();
	    GridLayout westGrid = new GridLayout(20,3);

	    westGrid.setHgap(10);
	    westGrid.setVgap(10);
	    JPanel west = new JPanel(westGrid);

	    JLabel searchLabel = new JLabel("Search:");
	    searchLabel.setSize(50, 10);
	    
	    tabbedPane.addTab("Movies", null, movieScrollPane,
	                      "Does nothing");
	    tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
	    
        tabbedPane.addTab("Music", null, musicScrollPane,
                "Does twice as much nothing");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
         
        tabbedPane.addTab("Series", null, tvScrollPane,
                "Still does nothing");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
       
	    
	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    panel.add(west, BorderLayout.WEST);
	    
	    south.add(addButton);
	    south.add(removeButton);
	    south.add(helpButton);
	    south.add(quitButton);
	    
	    center.add(searchLabel);
	    center.add(search);
	    center.add(searchButton);
	  
	    
	    north.add(tabbedPane);

	    setTitle("Media Collector");
	    setSize(800,600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	protected void searchDatabase(String name) {
		String type;
	
		if (tabbedPane.getSelectedIndex() == 0) {
			type = "Movie"; 
			movieModel.setRowCount(0);
		} else if (tabbedPane.getSelectedIndex() == 1) {
			type = "Music";
			musicModel.setRowCount(0);
		} else {
			type = "TVSeries";
			tvModel.setRowCount(0);
		}
		
		List<String[]> rows = new ArrayList<String[]>();
		List<MediaItem> items = database.getObject(type);
		List<MediaItem> item;

		Iterator<MediaItem> iterator = items.iterator();
		Iterator<MediaItem> itemIterator;
		Iterator<String[]>rowIterator;

		
		while(iterator.hasNext()) {
			MediaObject tmp = (MediaObject) iterator.next();
			item = tmp.getItems();
			itemIterator = item.iterator();
			while(itemIterator.hasNext()) {
				MediaItem tmp2 = itemIterator.next();
				
				if(tmp2.getTitle().equals(name)) {
					rows.add(tmp2.getRow());
				}

			}
		}
		
		rowIterator = rows.iterator();
		
		if(rows != null) {
			while(rowIterator.hasNext()) {
				addRow(type, rowIterator.next());
			}
		}
		
	}
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	public static void main(String args[]) {
		  
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	FileParser fp;
	            	DatabaseCreator dc = null;
	            	try {
	            		fp = new FileParser();
	            		dc = new DatabaseCreator(fp);
	            		dc.createDatabases();
	            		dc.print();
	            		
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	            	
	                MainWindow ex = new MainWindow(dc.getDatabases());

	                ex.getRows("Movie");
	                ex.getRows("Music");
	                ex.getRows("TVSeries");
	                ex.setVisible(true);
	                
	            }
	        });
	}
	
	protected void addRow(String type, String[] row) {
		if(type == "TVSeries") {
			tvModel.addRow(new Object[0]);
		} else if (type == "Movie") {
			movieModel.addRow(new Object[0]);
		} else if (type == "Music") {
			musicModel.addRow(new Object[0]);
		}

		for(int i = 0; i < row.length; i++) {
			switch(type) {
			case "TVSeries":
				tvModel.setValueAt(row[i], tvModel.getRowCount()-1, i);
				break;
			case "Movie":
				movieModel.setValueAt(row[i], movieModel.getRowCount()-1, i);
				break;
			case "Music":
				musicModel.setValueAt(row[i], musicModel.getRowCount()-1, i);
				break;
			}
		}
		
	}
	protected void getRows(String type) {
		int i = 0;
		List<String[]> rows = new ArrayList<String[]>();
		List<MediaItem> items = database.getObject(type);
		List<MediaItem> item;

		Iterator<MediaItem> iterator = items.iterator();
		Iterator<MediaItem> itemIterator;
		Iterator<String[]> rowIterator;
		
		
		while(iterator.hasNext()) {
			MediaObject tmp = (MediaObject) iterator.next();
			item = tmp.getItems();
			itemIterator = item.iterator();
			while(itemIterator.hasNext()) {
				rows.add(itemIterator.next().getRow());
			}
		}

		rowIterator = rows.iterator();
		
		if(rows != null) {
			while(rowIterator.hasNext()) {
				addRow(type, rowIterator.next());
			}
		}
		
	}
	
	
}


