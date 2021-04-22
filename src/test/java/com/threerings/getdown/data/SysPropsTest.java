//
// Getdown - application installer, patcher and launcher
// Copyright (C) 2004-2014 Three Rings Design, Inc.
// https://raw.github.com/threerings/getdown/master/LICENSE

package com.threerings.getdown.data;

import org.junit.*;

public class SysPropsTest {
	
	
  @Test public void testParseJavaVersion() {
    long vers = SysProps.parseJavaVersion("java.version", Application._javaVersionRegex);
    assert(vers > 1060000);

    long runVers = SysProps.parseJavaVersion("java.runtime.version", Application._javaVersionRegex);
    assert(runVers > 106000000);
  }
  

}