package change;

public interface DiskSpaceChangeEventSource {
	
	void addDiskSpaceListener(DiskSpaceListener l);
	
	void removeDiskSpaceListener(DiskSpaceListener l);

}
