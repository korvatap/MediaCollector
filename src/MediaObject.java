import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * MediaObject class is used as a composite in composite pattern.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public class MediaObject implements MediaItem {
	static final long serialVersionUID = 53L;
	private String title;
	List<MediaItem> items = new ArrayList<MediaItem>();
	
	/**
	 * Used to add new MediaItems to a list.
	 * 
	 * @param item	MediaItem to be added.
	 */
	public void add(MediaItem item) {
		items.add(item);
	 }
	
	/**
	 * Used to remove MediaItems from the list.
	 * 
	 * @param item MediaItem to be removed
	 */
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
	 
	/**
	 * Used to get child of mediaObject.
	 * 
	 * @param i	which item to get.
	 * @return	MediaItem which is child of MediaObject.
	 */
	public MediaItem getChild(int i) {
		return items.get(i);
	}

	/**
	 * Returns the title of the mediaObject.
	 * 
	 * @return title of the mediaObject.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Used to set the title of the mediaObject.
	 * 
	 * @param title	name of the title to be set.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Used to check if there MediaItem list is empty.
	 * 
	 * @return	true if empty, false if not.
	 */
	public boolean isEmpty() {
		boolean state = false;
		if(items.isEmpty()) {
			state = true;
		}
		return state;
	}
	
	/**
	 * Returns the list of MediaItems.
	 * 
	 * @return	list of MediaItems.
	 */
	public List<MediaItem> getItems() {
		return items;
	}
	
	/**
	 * Searches for MediaItems by name and adds them to a list.
	 * 
	 * @param name	name of the MediaItems to be searched.
	 * @return		list of found MediaItems.
	 */
	public List<MediaItem> getObject(String name) {
		List<MediaItem> objects = new ArrayList<MediaItem>();
		Iterator<MediaItem> iterator = items.iterator();
		while(iterator.hasNext()) {
			MediaItem tmp = iterator.next();
			if(tmp.getTitle().equals(name)) {
				objects.add(tmp);
			}
		}
		return objects;
	}
	
	/**
	 * Searches for MediaItems by id and deletes them
	 * if found.
	 */
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
	
	/**
	 * Searches for MediaItem by id and returns if found.
	 * 
	 * @param id	used to find the right MediaItem.
	 * @return		found MediaItem, null if not found.
	 */
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

	/**
	 * Not needed in this class but is inherited.
	 * 
	 * @return null always.
	 */
	@Override
	public String[] getRow() {
		return null;
	}

	/**
	 * Not needed in this class but is inherited.
	 * 
	 * @return 0, always.
	 */
	@Override
	public int getId() {
		return 0;
	}
}
