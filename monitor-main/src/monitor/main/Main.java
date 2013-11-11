package monitor.main;

import monitor.core.MonitorEngine;
import monitor.gui.MonitorWindow;

public class Main {
	public static void main(String[] args) {

		MonitorEngine m = new MonitorEngine("/home/marcio");
		
		MonitorWindow w = new MonitorWindow(m);
		w.visible();
		
		m.inicia();
		
		// componente main precisa do compoente change
		// m.addDiskSpaceListener(w);
		
	}
}
