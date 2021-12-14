package com.test;

import com.Util.Helper;
//import com.pages.ReadExcelData;
import org.openqa.selenium.devtools.v85.css.model.Value;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;

public class sampleTEst {
    public static void main(String[] args) {

    }
    @DataProvider(name = "dataProvider")
    public static Object[][] dataProvider() throws IOException {
        Object[][] data = Helper.readDataFromEcxelSheet();
        return data;
    }

    @Test(dataProvider = "dataProvider")
    public void testProvder(Object[] data) {
        System.out.println(data[16]);
    }
}
