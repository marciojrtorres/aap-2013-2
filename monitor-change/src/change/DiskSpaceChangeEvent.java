package change;

public class DiskSpaceChangeEvent {

	private final long freeSpace;

	public DiskSpaceChangeEvent(long freeSpace) {
		this.freeSpace = freeSpace;
	}

	public long getFreeSpace() {
		return freeSpace;
	}
	
}
