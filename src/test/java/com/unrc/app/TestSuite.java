package com.unrc.app;

import org.junit.ClassRule;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("unused")
@RunWith(Suite.class)
@Suite.SuiteClasses( { InmoTest.class, UserSpec.class, OwnerSpec.class, BuildingSpec.class, CitySpec.class, RealEstateSpec.class } )
public class TestSuite {
}