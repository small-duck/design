package com.zy.spring.formework.webmvc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName GPViewResolver
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 17:11
 * @Version 1.0
 **/

public class GPViewResolver {
    private String viewName;

    private File templateFile;

    public GPViewResolver(String viewName, File templateFile) {
        this.viewName = viewName;
        this.templateFile = templateFile;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String viewResolver(GPModelAndView mv) throws FileNotFoundException {

        StringBuffer sb = new StringBuffer();
        RandomAccessFile ra = new RandomAccessFile(templateFile, "r");
        try {
            String line = null;
            while (null != (line = ra.readLine())) {
                line = new String(line.getBytes("ISO-8859-1"), "utf-8");
                Matcher m = match(line);
                while (m.find()) {
                    for (int i = 1; i <= m.groupCount(); i++) {
                        String paramName = m.group(i);
                        Object paramValue = mv.getModel().get(paramName);
                        if (null == paramValue) {
                            continue;
                        }
                        line = line.replaceAll("￥\\{" + paramName + "\\}", paramValue.toString());
                        line = new String(line.getBytes("utf-8"), "ISO-8859-1");
                    }
                }
                sb.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                ra.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    private Matcher match(String line) {
        Pattern pattern = Pattern.compile("￥\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(line);
        return matcher;
    }
}
