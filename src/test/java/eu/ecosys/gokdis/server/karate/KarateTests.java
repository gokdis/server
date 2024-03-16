package eu.ecosys.gokdis.server.karate;

import org.junit.jupiter.api.Test;

import com.intuit.karate.junit5.Karate;

class KarateTests {
    @Test
    void contextLoads() {
    }

    @Karate.Test
    Karate dummyTest() {
        return Karate.run("dummy").relativeTo(getClass());
    }

    @Karate.Test
    Karate personTest() {
        return Karate.run("person").relativeTo(getClass());
    }

    @Karate.Test
    Karate beaconTest() {
        return Karate.run("beacon").relativeTo(getClass());
    }

    @Karate.Test
    Karate cellTest() {
        return Karate.run("cell").relativeTo(getClass());
    }

    @Karate.Test
    Karate sectionTest() {
        return Karate.run("section").relativeTo(getClass());
    }
}