
public interface MediaItem {

	void print();

	void add(MediaItem item);
	String getTitle();
	String[] getRow();
	void deleteObjectById(int id);
	int getId();
}
