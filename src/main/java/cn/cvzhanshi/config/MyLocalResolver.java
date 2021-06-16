package cn.cvzhanshi.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author cVzhanshi
 * @create 2021-06-15 11:22
 */
public class MyLocalResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //请求语言中的参数
        String language = request.getParameter("l");
        Locale locale = Locale.getDefault();//没有就用默认的

        //如果参数携带了国际化的参数
        if (!StringUtils.isEmpty(language)){
            //zh_CN
            String[] split = language.split("_");
            //国家，地区
            locale = new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
