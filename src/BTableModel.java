import javax.swing.table.DefaultTableModel;

class BTableModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String type;
	int del;
	
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
		case 6:
			if(type.equals("TVSeries")) {
				return String.class;
			} else { return Boolean.class; }
			
		default:
			return Boolean.class;
		}
	}
	
	
	BTableModel(String type, int del) {
		this.type = type;
		this.del = del;
		switch (type) {
			case "TVSeries":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Series");
				this.addColumn("Episode");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
			case "Music":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Artist");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
				
			case "Movie":
				this.addColumn("ID");
				this.addColumn("Title");
				this.addColumn("Language");
				this.addColumn("Publish Year");
				this.addColumn("Rating");
				this.addColumn("Genre");
				break;
		}
		if(del == 1) {
			this.addColumn("Select");
		}
	}
	
	 public boolean isCellEditable ( int row, int column )
     {
		 if(del == 1) {
			 if(getColumnClass(column) == Boolean.class) {
				 return true;
			 } else {
				 return false; 
			 }
		 }  else {
				 return true;
		 }
		
     }
	
	BTableModel() {}
	
}