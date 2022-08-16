package com.example.apitest

import org.junit.platform.suite.api.SelectClasses
import org.junit.platform.suite.api.Suite
import org.junit.platform.suite.api.SuiteDisplayName


@SelectClasses(NameTests::class,CanRelistTests::class,GalleryTests::class)
@Suite
@SuiteDisplayName("JUnit Platform Suite")
class AllUnitTests 

