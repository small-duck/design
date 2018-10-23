package com.zy.spring.formework.webmvc.servlet;

import com.zy.spring.formework.annotaiton.GPController;
import com.zy.spring.formework.annotaiton.GPRequestMapping;
import com.zy.spring.formework.annotaiton.GPRequestParam;
import com.zy.spring.formework.context.GPApplicationContext;
import com.zy.spring.formework.context.support.GPBeanDefinitionReader;
import com.zy.spring.formework.webmvc.GPHandlerAdapter;
import com.zy.spring.formework.webmvc.GPHandlerMapping;
import com.zy.spring.formework.webmvc.GPModelAndView;
import com.zy.spring.formework.webmvc.GPViewResolver;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName GPDispatchServlet
 * @Description
 * @Author Benny
 * @Date 2018/8/26 0026 11:08
 * @Version 1.0
 **/
public class GPDispatchServlet extends HttpServlet {

    private  final String LOCATION = "contextConfigLocation";

    //核心设计
    private List<GPHandlerMapping> handlerMappings = new ArrayList<>();

    private Map<GPHandlerMapping, GPHandlerAdapter> handlerAdapters = new HashMap<>();

    private List<GPViewResolver> viewResolvers = new ArrayList<GPViewResolver>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("<font size='25' color='blue'>500 Exception</font><br/>Details:<br/>" + Arrays.toString(e.getStackTrace()).replaceAll("\\[|\\]","")
                    .replaceAll("\\s","\r\n") +  "<font color='green'><i>Copyright@GupaoEDU</i></font>");
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        GPHandlerMapping handler = getHandler(req);
        if (handler == null) {
            resp.getWriter().write("<font size='25' color='red'>404 Not Found</font><br/><font color='green'><i>Copyright@GupaoEDU</i></font>");
            return;
        }
        GPHandlerAdapter ha = getHandlerAdapter(handler);

        GPModelAndView mv = ha.handle(req, resp, handler);

        processDispatchResult(resp, mv);
    }

    private void processDispatchResult(HttpServletResponse resp, GPModelAndView mv) throws IOException {
        //调用viewResolver的resolveView
        if (null == mv) {
            return;
        }

        if (viewResolvers.isEmpty()) {
            return;
        }
        for (GPViewResolver viewResolver : viewResolvers)
            if (!mv.getViewName().equals(viewResolver.getViewName())) {
                try {
                    String out = viewResolver.viewResolver(mv);
                    if (out != null) {
                        resp.getWriter().write(out);

                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }


    }

    private GPHandlerAdapter getHandlerAdapter(GPHandlerMapping handler) {
        if (this.handlerAdapters.isEmpty()) {
            return null;
        }
        return this.handlerAdapters.get(handler);
    }

    private GPHandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }

        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url= url.replace(contextPath, "").replaceAll("/+", "/");

        for (GPHandlerMapping handler : this.handlerMappings) {
            Matcher matcher = handler.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }

        }


        return null;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //相当于把ioc容器初始化了
        GPApplicationContext applicationContext = new GPApplicationContext(config.getInitParameter(LOCATION));

        initStrategies(applicationContext);
    }

    private void initStrategies(GPApplicationContext context) {
        /**
         * 有九种策略模式
         * 针对每个用户请求 都会经过一些处理的策略之后最后才有结果输出
         * 每种策略可以自定义干预 但最终的结果是一致的
         */
        /**
         * 文件上传解析 如果请求类型是multipart将通过MultipartResolver进行文件上传解析
         *
         */
        initMultipartResolver(context);
        /**
         * 本地化解析
         */
        initLocaleResolver(context);
        /**
         * 主题解析
         */
        initThemeResolver(context);
        /**
         * 通过handlerAdapter进行解析 将请求映射到处理器
         */
        initHandlerMappings(context);
        /**
         * handleradapetr进行多种类型的参数动态匹配
         */
        initHandlerAdapters(context);
        /**
         * 如果执行过程中遇到异常，将交给handlerExceptionResolver来 解析
         */
        initHandlerExceptionResolvers(context);
        /**
         * 直接解析到请求到视图
         */
        initRequestToViewNameTranslator(context);
        /**
         * 通过viewResolver解析逻辑视图到具体视图实现
         */
        initViewResolvers(context);
        /**
         * flash映射管理器
         */
        initFlashMapManager(context);
    }

    private void initFlashMapManager(GPApplicationContext context) {

    }



    private void initRequestToViewNameTranslator(GPApplicationContext context) {

    }

    private void initHandlerExceptionResolvers(GPApplicationContext context) {

    }


    private void initThemeResolver(GPApplicationContext context) {

    }

    private void initLocaleResolver(GPApplicationContext context) {

    }

    private void initMultipartResolver(GPApplicationContext context) {
    }




    private void initHandlerAdapters(GPApplicationContext context) {
        for (GPHandlerMapping handlerMapping : handlerMappings) {
            Map<String, Integer> paramMapping = new HashMap<>();

            Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
            for (int i = 0; i < pa.length; i++) {
                for (Annotation a : pa[i]) {
                    if (a instanceof GPRequestParam) {
                        String paramName = ((GPRequestParam) a).value();
                        if (!"".equals(paramName.trim())) {
                            paramMapping.put(paramName, i);
                        }
                    }
                }

            }

            //接下来 我们处理非命名参数
            //只处理request response

            Class<?>[] paramTypes = handlerMapping.getMethod().getExceptionTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                Class<?> type = paramTypes[i];
                if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                    paramMapping.put(type.getName(), i);
                }
            }

            this.handlerAdapters.put(handlerMapping, new GPHandlerAdapter(paramMapping));
        }

    }

    private void initHandlerMappings(GPApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();

        try {
            for (String beanName : beanNames) {
                Object bean = context.getBean(beanName);
                Class<?> clazz = bean.getClass();
                if (!clazz.isAnnotationPresent(GPController.class)) {
                    continue;
                }

                String baseUrl = "";
                if (clazz.isAnnotationPresent(GPRequestMapping.class)) {
                    GPRequestMapping requestMapping = clazz.getAnnotation(GPRequestMapping.class);
                    baseUrl = requestMapping.value();
                }

                //扫描所有的public方法
                Method[] methods =
                        clazz.getMethods();
                for (Method method : methods) {
                    if (!method.isAnnotationPresent(GPRequestMapping.class)) {
                        continue;
                    }

                    GPRequestMapping requestMapping = method.getAnnotation(GPRequestMapping.class);
                    String regex = ("/" + baseUrl + requestMapping.value().replaceAll("\\*", ".*")).replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new GPHandlerMapping(bean, method, pattern));
                    System.out.println("Mapping: " + regex + " , " + method);

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void initViewResolvers(GPApplicationContext context) {
        String templateRoot = context.getConfig().getProperty("templateRoot");
        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootDir = new File(templateRootPath);
        for (File template : templateRootDir.listFiles()) {
            this.viewResolvers.add(new GPViewResolver(template.getName(), template));
        }

    }


}
