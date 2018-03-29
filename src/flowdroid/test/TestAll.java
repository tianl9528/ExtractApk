package flowdroid.test;

import flowdroid.helper.DataParsing;
import flowdroid.helper.ExtractAndroidManifest;
import flowdroid.helper.ExtractSourceSinkFlow;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;


public class TestAll {
    @Test
    public void test1() throws IOException, XmlPullParserException {
        String fullFilePath = "/Users/tianl9528/Desktop/FlowDroid_0927/apk1/fe5ab57d32cc043d895520015cf9b9de60b64289ea91982a0909abeb5514f304.apk";
        String androidJar = "/Users/tianl9528/Library/Android/sdk/platforms/android-16/android.jar";

        ExtractSourceSinkFlow ESSF = new ExtractSourceSinkFlow();
        ExtractAndroidManifest EAM = new ExtractAndroidManifest();
        DataParsing results = new DataParsing(fullFilePath);

        EAM.setApkFile(fullFilePath);
        EAM.run();
        results.setManifestResults(EAM.getManifestResult().getExtractContents());


        ESSF.setApkFile(fullFilePath);
        ESSF.setAndroidJar(androidJar);
        ESSF.run();
        results.savaFlowResult(ESSF);
        results.setMode("0");

        List<String> data = results.toStringList();
        System.out.println("开始输出：\n============\n");
        for(String a:data) {
            System.out.println(a);
            System.out.println("-----------");
        }


    }
}
