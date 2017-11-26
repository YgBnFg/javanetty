package com.binfeng;

import com.google.protobuf.InvalidProtocolBufferException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static javafx.scene.input.KeyCode.T;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {
    private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testProto() {
        TestProto.Person.Builder builder = TestProto.Person.newBuilder();
        builder.setEmail("test@gmail.com");
        builder.setId(1000);
        TestProto.Person.Phone.Builder phone = TestProto.Person.Phone.newBuilder();
        phone.setNumber("18610000000");
        phone.setType(TestProto.Person.PhoneType.WORK);

        builder.setName("张三");
        builder.addPhone(phone);

        TestProto.Person person = builder.build();
        //serialize
        byte[] data = person.toByteArray();
        try {
            logger.info(String.valueOf(TestProto.Person.parseFrom(data)));
        } catch (InvalidProtocolBufferException e) {
            logger.info("data error!");
        }
        //
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            person.writeDelimitedTo(byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        try {
            logger.info(String.valueOf(TestProto.Person.parseDelimitedFrom(byteArrayInputStream)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
