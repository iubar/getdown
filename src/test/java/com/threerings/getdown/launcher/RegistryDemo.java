package com.threerings.getdown.launcher;

import static com.threerings.getdown.Log.log;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import com.samskivert.util.RunAnywhere;
import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinReg;
 

public class RegistryDemo {
	
    protected static final String PROXY_REGISTRY = "SOFTWARE\\Iubar\\Paghe Open (full)";    
    
	public void demo() {
        if (RunAnywhere.isWindows()) {
            try {
         
                 Map<String, Object> values = Advapi32Util.registryGetValues(WinReg.HKEY_CURRENT_USER, PROXY_REGISTRY);
                 if(values.size()==0) {
                	 System.out.println("No results");
                 }
                 for (Map.Entry<String, Object> entry : values.entrySet()) {      
                    Object value = entry.getValue();
                    String key = entry.getKey() ;  
                    System.out.println("Read " + key + " : " + value);
                }
            } catch (Throwable t) {
                log.error("Failed to read Windows registry", "error", t);
            }
        }		
	}
	
	private void demo2() {
        System.out.println(Advapi32Util.registryGetStringValue
                (WinReg.HKEY_CURRENT_USER,
                 "Software\\Microsoft\\Internet Explorer\\Main", "Search Page")
        );
       
        Advapi32Util.registryCreateKey(WinReg.HKEY_CURRENT_USER, "Software", "JNA");
        Advapi32Util.registrySetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\JNA", "IntValue", 42);
        System.out.println(Advapi32Util.registryGetIntValue(WinReg.HKEY_CURRENT_USER, "Software\\JNA", "IntValue"));
        Advapi32Util.registryDeleteKey(WinReg.HKEY_CURRENT_USER, "Software", "JNA");
        
	}
	
	
	/**
	 * Run with:
	 *  java -cp target\getdown-1.5.1.jar com.threerings.getdown.launcher.RegistryDemo
	 *  java -cp target\getdown-with-dependencies.jar com.threerings.getdown.launcher.RegistryDemo
	 *  
	 *  
	 *  java -cp target/* com.threerings.getdown.launcher.RegistryDemo
	 *  (-Djava.util.logging.ConsoleHandler.level=FINE)
	 *  
	 * @param args
	 */
	public static void main(String[] args) {
		RegistryDemo demo = new RegistryDemo();
		demo.demo();
	}
}
