import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MediaObject implements MediaItem {
	private String title;
	List<MediaItem> items = new ArrayList<MediaItem>();
	
	public void add(MediaItem item) {
		items.add(item);
	 }
	
	 public void remove(MediaItem item) {
		 items.remove(item);
	 }
	 
	 public void print() {	  
		  Iterator<MediaItem> itemIterator = items.iterator();
		    while(itemIterator.hasNext()){
		     MediaItem item = itemIterator.next();
		     item.print();
		    }
	}
	 
	 public MediaItem getChild(int i) {
		  return items.get(i);
	 }

	public String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public boolean isEmpty() {
		boolean state = false;
		if(items.isEmpty()) {
			state = true;
		}
		return state;
	}
	
	public List<MediaItem> getItems() {
		return items;
	}
	
	public List<MediaItem> getObject(String name) {
		List<MediaItem> objects = new ArrayList<MediaItem>();
		Iterator<MediaItem> iterator = items.iterator();
		while(iterator.hasNext()) {
			MediaItem tmp = iterator.next();
			if(tmp.getTitle() == name) {
				objects.add(tmp);
			}
		}
		return objects;
	}
	
	public void deleteObjectById(int id) {
		for(int i=0; i < items.size(); i++) {
			MediaItem tmp = items.get(i);
			if(tmp.getId() == id) {
				items.remove(tmp);
			} else {
				tmp.deleteObjectById(id);
			}
		}
	}
	
	public MediaItem getObjectById(int id) {
		MediaItem item = null;
		for(int i=0; i < items.size(); i++) {
			MediaItem tmp = items.get(i);
			if(tmp.getId() == id) {
				item = tmp;
			}
		}
		return item;
	}
	
	public void modifyObjectById(int id, String[] row) {
		
	}

	@Override
	public String[] getRow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
