package com.threerings.getdown.launcher;

import static com.threerings.getdown.Log.log;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import com.samskivert.util.RunAnywhere;
//import com.sun.jna.platform.win32.Advapi32Util;
//import com.sun.jna.platform.win32.WinReg;
import com.threerings.getdown.util.ConfigUtil;
import com.threerings.getdown.util.ConnectionUtil;

public class WinRegistry {

	/**
     * Reads and/or autodetects our proxy settings.
     *
     * @return true if we should proceed with running the launcher, false if we need to wait for
     * the user to enter proxy settings.
     */

	/*
    protected boolean detectProxy ()
    {
        // we may already have a proxy configured
    	String proxyHost = System.getProperty("http.proxyHost");
        if (proxyHost != null) {
        	log.debug("System http.proxyHost propertiy: " + proxyHost);
            return true;
        }

        // look in the Vinders registry
        if (RunAnywhere.isWindows()) {
            try {
                String host = null, port = null;
                boolean enabled = false;

                
                Map<String, Object> values = Advapi32Util.registryGetValues(WinReg.HKEY_CURRENT_USER, PROXY_REGISTRY);
                for (Map.Entry<String, Object> entry : values.entrySet()) {
                	Object value = entry.getValue();
                	String key = entry.getKey() ;
                    if (key.equals("ProxyEnable")) {
                        enabled = value.toString().equals("1");
                    }
                    if (key.equals("ProxyServer")) {
                        String strval = value.toString();
                        int cidx = strval.indexOf(":");
                        if (cidx != -1) {
                            port = strval.substring(cidx+1);
                            strval = strval.substring(0, cidx);
                        }
                        host = strval;
                    }
                }

                if (enabled) {
                    setProxyProperties(host, port);
                    log.debug("Proxy: " + host + ":" + port);
                    return true;
                } else {
                    log.info("Detected no proxy settings in the registry.");
                }

            } catch (Throwable t) {
                log.info("Failed to find proxy settings in Windows registry", "error", t);
            }
        }

        // otherwise look for and read our proxy.txt file
        File pfile = _app.getLocalPath("proxy.txt");
        if (pfile.exists()) {
            try {
                Map<String, Object> pconf = ConfigUtil.parseConfig(pfile, false);
                String host = (String)pconf.get("host");
                String port = (String)pconf.get("port");
                setProxyProperties(host, port);
                log.debug("Proxy: " + host + ":" + port);
                return true;
            } catch (IOException ioe) {
                log.warning("Failed to read '" + pfile + "': " + ioe);
            }
        }

        // otherwise see if we actually need a proxy; first we have to initialize our application
        // to get some sort of interface configuration and the appbase URL
        log.info("Checking whether we need to use a proxy...");
        try {
            _ifc = _app.init(true);
        } catch (IOException ioe) {
            // no worries
        }
        updateStatus("m.detecting_proxy");

        URL rurl = _app.getConfigResource().getRemote();
        try {
            // try to make a HEAD request for this URL
            URLConnection conn = ConnectionUtil.open(rurl);
            if (conn instanceof HttpURLConnection) {
                HttpURLConnection hcon = (HttpURLConnection)conn;
                try {
                    hcon.setRequestMethod("HEAD");
                    hcon.connect();
                    // make sure we got a satisfactory response code
                    if (hcon.getResponseCode() != HttpURLConnection.HTTP_OK) {
                        log.warning("Got a non-200 response but assuming we're OK because we got " +
                                    "something...", "url", rurl, "rsp", hcon.getResponseCode());
                    }
                } finally {
                    hcon.disconnect();
                }
            }

            // we got through, so we appear not to require a proxy; make a blank proxy config and
            // get on gettin' down
            log.info("No proxy appears to be needed.");
            try {
                pfile.createNewFile();
                log.debug("Proxy is needed");
            } catch (IOException ioe) {
                log.warning("Failed to create blank proxy file '" + pfile + "': " + ioe);
            }
            return true;

        } catch (IOException ioe) {
            log.info("Failed to HEAD " + rurl + ": " + ioe);
            log.info("We probably need a proxy, but auto-detection failed.");
        }

        // let the caller know that we need a proxy but can't detect it
        return false;
    }
    */
}
