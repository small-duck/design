package com.zz.written.reserve;


import org.springframework.util.StringUtils;

import java.awt.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName reserve
 * @Description
 * @Author Benny
 * @Date 2018/9/20 0020 13:24
 * @Version 1.0
 **/
public class Reserve {

    //豪华房
    private final BigDecimal priceL= new BigDecimal(800.00);

    private final BigDecimal discountPriceL = new BigDecimal(0.8);
    private final BigDecimal discountPriceLCunt = new BigDecimal(0.2);

    private final BigDecimal discountPriceP = new BigDecimal(0.85);
    private final BigDecimal discountPricePCunt = new BigDecimal(0.15);
    //单人房
    private final BigDecimal  priceS = new BigDecimal(400.00).setScale(2);
    //双人房
    private final BigDecimal priceD = new BigDecimal(500.00).setScale(2);


    public  String doReserve(String message) throws ParseException {
        if (StringUtils.isEmpty(message)) {
            return null;
        }
        StringBuffer buffer = new StringBuffer();
        String[] split = message.split(" ");

        String member = split[0];

        String[] roomTypes = split[1].split("&");
        String lroomType = roomTypes[0].substring(0, 1);
        String lroomTypeNum = roomTypes[0].substring(1,2);

        String sroomType = roomTypes[1].substring(0, 1);
        String sroomTpyeNum = roomTypes[1].substring(1,2);

        String times = split[2];
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse(times);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatDate = dateFormat.format(parse);
        
        String roomNumber = split[3];

        BigDecimal discountL = null ;
        BigDecimal discountS =null;
        BigDecimal summaryL =null;
        BigDecimal summaryS =null;
        BigDecimal bigLroom = new BigDecimal(lroomTypeNum);
        BigDecimal bigRoomNumber = new BigDecimal(roomNumber);
        BigDecimal bigsRoom = new BigDecimal(sroomTpyeNum);
        if (lroomType.equals("L")) {
            discountL = priceL.multiply(discountPriceLCunt).multiply(bigLroom).multiply(bigRoomNumber);
            summaryL = priceL.multiply(discountPriceL).multiply(bigLroom).multiply(bigRoomNumber);

            buffer.append("Luxury ").append(priceL.setScale(2)).append(" ").
                    append(lroomTypeNum).append("\n");
        }
        if (sroomType.equals("S")) {
            discountS = priceS.multiply(discountPricePCunt).multiply(bigsRoom).multiply(bigRoomNumber);
            summaryS = priceS.multiply(discountPriceP).multiply(bigsRoom).multiply(bigRoomNumber);

            buffer.append("Single ").append(priceS.setScale(2)).append(" ").
                    append(sroomTpyeNum).append("\n");
        }
        buffer.append("Duration ").append(roomNumber).append(" days")
                .append("(").append("start from ").append(formatDate).append(")").append("\n");
        buffer.append("-------------").append("\n");
        buffer.append("Discount ").append(discountS.add(discountL).setScale(2,BigDecimal.ROUND_HALF_UP)).append("\n");
        buffer.append("Summary ").append(summaryS.add(summaryL).setScale(2,BigDecimal.ROUND_HALF_UP)).append("\n");
        buffer.append("Member ").append(member).append("\n");

        return buffer.toString();
    }
}
