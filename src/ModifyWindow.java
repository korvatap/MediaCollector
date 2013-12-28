import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class ModifyWindow extends JFrame {

	private static final long serialVersionUID = 3781413385233728385L;
	
	private MainWindow mainRef;
	private int targetTable;
	private MediaObject database;
	private List<MediaItem> items = new ArrayList<MediaItem>();
	private List<String[]> rows = new ArrayList<String[]>();
    //Create table models for TV, movie, music
    BTableModel tableModel = new BTableModel("Movie",0);
    
    //CREATE TABLES FOR TV, movie, music
    JTable table = new JTable(tableModel);
    
	JScrollPane tableScrollPane = new JScrollPane(table);
	
	 JPanel south = new JPanel();
	 JPanel center = new JPanel(new BorderLayout());
	 
	 
	 List<String[]> addRows = new ArrayList<String[]>();

	private List<Integer> idArray;

	public ModifyWindow(MainWindow mainRef, MediaObject database, List<Integer> idArray, int targetTable) {
		this.mainRef = mainRef;
		this.targetTable = targetTable;
		this.database = database;
		this.idArray = idArray;

		initWindow();
	}
	
	protected void addTargetRows() {
		for(int i = 0; i < rows.size(); i++) {
			tableModel.addRow(new Object[0]);
			for(int y = 0; y < rows.get(i).length; y++) {
				String[] tmp = rows.get(i);
				tableModel.setValueAt(tmp[y], tableModel.getRowCount()-1, y);
			}
			
		}
	}
	
	protected void getRowsFromTargetObjects() {
		for(int i = 0; i < items.size(); i++) {
			rows.add(items.get(i).getRow());
		}
	}
	
	
	protected void getTargetObjects(List<Integer> idArray) {
		List<MediaItem> tmp;
		if(targetTable == 0) {
			tmp = database.getObject("Movie");
		} else if (targetTable == 1) {
			tmp = database.getObject("Music");
		} else {
			tmp = database.getObject("TVSeries");
		}
		
		for(int x=0; x < tmp.size(); x++) {
			for(int i=0; i < idArray.size(); i++) {
				items.add(((MediaObject) tmp.get(x)).getObjectById(idArray.get(i)));	
			}
		}
	}
	
	public final void initWindow() {
	    JPanel panel = new JPanel();
	    getContentPane().add(panel);
	    panel.setLayout(new BorderLayout());
	    table.setEnabled(true);
	    
		if(this.targetTable == 0) {
			tableModel = new BTableModel("Movie",0);
			table.setModel(tableModel);
		} else if (this.targetTable == 1) {
			tableModel = new BTableModel("Music",0);
			table.setModel(tableModel);
		} else {
			tableModel = new BTableModel("TVSeries", 1);
			table.setModel(tableModel);
		}
	
		getTargetObjects(idArray);
		getRowsFromTargetObjects();
		addTargetRows();
	    
	    table.setFillsViewportHeight(true);
	    
        panel.setToolTipText("NII VITTU USKALLA");
	       
	    JButton nextButton = new JButton("Save");
	    nextButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		tableModel.addRow(new Object[0]);
	    		table.editCellAt(table.getRowCount()-1, 0);
	    	}
	    });
	       
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		setVisible(false);
	    	}
	    });

	    panel.add(south, BorderLayout.SOUTH);
	    panel.add(center, BorderLayout.CENTER);
	    
	    south.add(nextButton);
	    south.add(cancelButton);

	    center.add(tableScrollPane);
	    setTitle("Media Collector");
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
