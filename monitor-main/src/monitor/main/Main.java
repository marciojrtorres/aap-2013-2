package monitor.main;

import monitor.core.MonitorEngine;
import monitor.gui.MonitorWindow;

public class Main {
	public static void main(String[] args) {

		MonitorEngine m = new MonitorEngine("/");
		m.inicia();
		
		MonitorWindow w = new MonitorWindow();
		w.visible();
		
	}
}
