import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class MediaObject implements MediaItem{
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

	private String getTitle() {
		// TODO Auto-generated method stub
		return title;
	}
	
	public boolean isEmpty() {
		boolean state = false;
		if(items.isEmpty()) {
			state = true;
		}
		return state;
	}
}
