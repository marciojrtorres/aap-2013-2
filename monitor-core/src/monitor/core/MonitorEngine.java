package monitor.core;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JTextField;

import toolkit.List;
import change.DiskSpaceChangeEvent;
import change.DiskSpaceChangeEventSource;
import change.DiskSpaceListener;

// observado, gerador, produtor  

public class MonitorEngine implements DiskSpaceChangeEventSource {
    
    private long freeSpace = 0;
	private final String path;
	
	private List<DiskSpaceListener> ouvintes 
					= new List<DiskSpaceListener>();
	
	@Override
	public void addDiskSpaceListener(DiskSpaceListener l) {
		ouvintes.append(l);
	}
	
	@Override
	public void removeDiskSpaceListener(DiskSpaceListener l) {
		// ouvintes.remove(l);
	}
	
	public MonitorEngine(final String path) {
		this.path = path;
	}
	
	public long getFreeSpace() {
		return freeSpace;
	}
	
	public String getPath() {
		return path;
	}
        
    public void inicia() {
        final File dir = new File(getPath());
        
        new Thread(new Runnable() { 

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("tic");
                        if (dir.getFreeSpace() != freeSpace) {
                            freeSpace = dir.getFreeSpace();
                            System.out.println("new free space " + freeSpace);
                            
                            for (int i = 0; i < ouvintes.length(); i++) {
                            	DiskSpaceListener ouvinte = ouvintes.get(i);
                            	ouvinte.onDiskSpaceChange(new DiskSpaceChangeEvent(freeSpace));
                            }
                            
                        }
                        Thread.sleep(1000); 
                    } catch (Exception e) {
                    	System.err.println(e);
                    }                    
                }
            }
        }).start();          
    }


    
    
}
