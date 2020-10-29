//
// Getdown - application installer, patcher and launcher
// Copyright (C) 2004-2014 Three Rings Design, Inc.
// https://raw.github.com/threerings/getdown/master/LICENSE

package com.threerings.getdown.data;

import org.junit.*;

public class SysPropsTest {
	
	/**
     * @see https://regex101.com/r/jkCR3j/4
     */
    private final String REGEX = "((\\d+)-ea.*|(\\d+)\\.(\\d+)\\.(\\d+)([_+]\\d+)?(-b\\d+)?)";

  @Test public void testParseJavaVersion () {
    long vers = SysProps.parseJavaVersion("java.version", REGEX); // "(\\d+)\\.(\\d+)\\.(\\d+)(_\\d+)?"
    assert(vers > 1060000);

    long runVers = SysProps.parseJavaVersion("java.runtime.version", REGEX); // "(\\d+)\\.(\\d+)\\.(\\d+)(_\\d+)?(-b\\d+)?"
    assert(runVers > 106000000);
  }
}