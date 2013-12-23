import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

//import statements
//Check if window closes automatically. Otherwise add suitable code

class ColorTableModel extends AbstractTableModel {
	
    Object rowData[][] = { { "Row1-Column1", "Row1-Column2", "Row1-Column3", new Boolean(false) },
			   { "Row2-Column1", "Row2-Column2", "Row2-Column3", new Boolean(false) } };
    
    String columnNames[] = { "Category", "Title", "Rating", "Poista" };

	public int getColumnCount() {
	    return columnNames.length;
	  }

	  public String getColumnName(int column) {
	    return columnNames[column];
	  }

	  public int getRowCount() {
	    return rowData.length;
	  }

	  public Object getValueAt(int row, int column) {
	    return rowData[row][column];
	  }

	  public Class getColumnClass(int column) {
	    return (getValueAt(0, column).getClass());
	  }

	  public void setValueAt(Object value, int row, int column) {
	    rowData[row][column] = value;
	  }

	  public boolean isCellEditable(int row, int column) {
	    return (column != 0);
	  }
}
public class MainWindow extends JFrame {
	
	public MainWindow() {
		initUI();
	}
	
	public final void initUI() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    BorderLayout panelLayout = new BorderLayout();
	    panelLayout.setHgap(10);
	    panelLayout.setVgap(10);
	    panel.setLayout(panelLayout);
	    
        panel.setToolTipText("NII VITTU USKALLA");	
        TableModel model = new ColorTableModel();
        JTable table = new JTable(model);
        
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
	    
	    JButton movieButton = new JButton("Movies");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });
	    
	    JButton musicButton = new JButton("Music");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });
	    
	    JButton tvButton = new JButton("TV");
	    helpButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		HelpWindow hw = new HelpWindow();
	    		hw.setVisible(true);
	    	}
	    });

	    JPanel north = new JPanel();
	    JPanel south = new JPanel();
	    JPanel center = new JPanel(new BorderLayout());
	    GridLayout westGrid = new GridLayout(20,3);
	    westGrid.setHgap(10);
	    westGrid.setVgap(10);
	    JPanel west = new JPanel(westGrid);
	    
	    JLabel category = new JLabel("Select Category:");
	    JLabel searchLabel = new JLabel("Search:");
	    
	    panel.add(north, BorderLayout.NORTH);
	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    panel.add(west, BorderLayout.WEST);
	    
	    south.add(addButton);
	    south.add(removeButton);
	    south.add(helpButton);
	    south.add(quitButton);
	    
	    north.add(searchLabel);
	    north.add(search);
	    north.add(searchButton);

	    center.add(scrollPane);
	    
	    west.add(category);
	    west.add(movieButton);
	    west.add(musicButton);
	    west.add(tvButton);

	    setTitle("Media Collector");
	    setSize(800,600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String args[]) {
		  
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	            	FileParser fp;
	            	DatabaseCreator dc;
	            	try {
	            		fp = new FileParser();
	            		dc = new DatabaseCreator(fp);
	            		dc.createDatabases();
	            		dc.print();
	            		
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


