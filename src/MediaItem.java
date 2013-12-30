import java.io.Serializable;

/**
 * MediaItem class is used as a component in composite pattern.
 * 
 * @author      Juha Hirvasniemi <jhirvasn@paju.oulu.fi>, Tapio Korvala <korvatap@paju.oulu.fi>
 * @version     1.0
 * @since       2013-12-30
 */
public interface MediaItem extends Serializable {

	void print();
	void add(MediaItem item);
	String getTitle();
	String[] getRow();
	void deleteObjectById(int id);
	int getId();
}
