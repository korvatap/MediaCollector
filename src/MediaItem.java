import java.io.Serializable;


public interface MediaItem extends Serializable {

	void print();

	void add(MediaItem item);
	String getTitle();
	String[] getRow();
	void deleteObjectById(int id);
	int getId();
}
