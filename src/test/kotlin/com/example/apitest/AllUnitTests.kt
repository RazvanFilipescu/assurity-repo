package com.example.apitest

import org.junit.platform.suite.api.SelectPackages
import org.junit.platform.suite.api.Suite


@Suite
@SelectPackages("com.example.apitest")
//@ExcludePackages("com.baeldung.suites")
class AllUnitTests {

}

