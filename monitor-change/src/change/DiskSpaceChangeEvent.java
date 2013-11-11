package change;

public class DiskSpaceChangeEvent {

	private final long freeSpace;

	public DiskSpaceChangeEvent(long freeSpace) {
		this.freeSpace = freeSpace;
	}

	public long getFreeSpace() {
		return freeSpace;
	}

	public long getFreeSpaceInMegaBytes() {
		return freeSpace / 1024 / 1024;
	}
	
	public long getFreeSpaceInMibiBytes() {
		return freeSpace / 1000 / 1000;
	}
	
}
