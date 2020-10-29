package com.threerings.getdown.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.threerings.getdown.data.Application;

public class VersionUtilTest {

	@Test
	public void testParseJavaVersion() {
		final String versStr = "16-ea+21-1209";
		 long result = VersionUtil.parseJavaVersion(Application._javaVersionRegex, versStr);
		 System.out.println("testParseJavaVersion1: " + result);
		 assertTrue(result>1060000);
	}
	
	@Test
	public void testParseJavaVersion2() {
		final String versStr = "16-ea";
		 long result = VersionUtil.parseJavaVersion(Application._javaVersionRegex, versStr);
		 System.out.println("testParseJavaVersion2: " + result);
		 assertTrue(result>1060000);
	}	

}
