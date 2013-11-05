package monitor.core;

import java.io.File;

public class MonitorEngine {
    
    
    private long freeSpace = 0;
	private final String path;
	
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
