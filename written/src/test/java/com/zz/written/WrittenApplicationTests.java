package com.zz.written;

import com.zz.written.reserve.Reserve;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WrittenApplicationTests {

    @Test
    public void contextLoads() {

    }

    public static void main(String[] args) throws ParseException {
        Reserve reserve = new Reserve();
        String doReserve = reserve.doReserve("M999999 L1&S1 2011-6-1 2");
        System.err.println(doReserve);
    }

}
