package com.example.apitest

import org.junit.platform.suite.api.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest


@SelectClasses(NameTests::class,CanRelistTests::class,GalleryTests::class)
@Suite
@SuiteDisplayName("JUnit Platform Suite")
class AllUnitTests {

}

