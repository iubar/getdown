package com.threerings.getdown.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.threerings.getdown.data.Application;

public class VersionUtilTest {

	@Test
	public void testParseJavaVersion() {
		final String versStr = "16-ea+21-1209";
		 long result = VersionUtil.parseJavaVersion(Application._javaVersionRegex, versStr);
		 System.out.println("testParseJavaVersion1: " + result);
		 assertEquals(1600000000, result);
	}
	
	@Test
	public void testParseJavaVersion2() {
		final String versStr = "16-ea";
		 long result = VersionUtil.parseJavaVersion(Application._javaVersionRegex, versStr);
		 System.out.println("testParseJavaVersion2: " + result);
		 assertEquals(1600000000, result);
	}
	
	@Test
	public void testParseJavaVersion3() {
		String verstr = "16.0.1+9-24";
		long result = VersionUtil.parseJavaVersion(Application._javaVersionRegex, verstr );
		System.out.println("testParseJavaVersion3: " + result);
		assertEquals(1600010000, result);
	}	

}
