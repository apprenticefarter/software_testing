package ru.software_test.soap;

import generated.GeoIPService;
import org.junit.Assert;
import org.junit.Test;

public class GeoIpServiceTests {
    @Test
    public void testMyIp(){
        String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("128.72.66.93");
        System.out.println(ipLocation);
        Assert.assertTrue(ipLocation.contains("RU"));
    }
}
