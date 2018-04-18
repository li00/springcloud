package com.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by LI on 2018/4/16.
 */
@Component
public class CloudFilter extends ZuulFilter {

    @Value("${security.list}")
    private String security;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object token = request.getParameter("token");

        String url = request.getRequestURI();
        String securityList[] = security.split(",");
        for (String str : securityList){
            if (url.indexOf(str)!= -1){//如果是放行接口那么允许通过
                return null;
            }
        }
        if (token == null || "".equals(token)){//token不存在则不允许通过
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(403);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {

            if( !token.equals("1")){//如果token不正确则不允许通过
                ctx.setSendZuulResponse(false);
                ctx.setResponseStatusCode(403);
                try {
                    ctx.getResponse().getWriter().write("token is error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
               return null;
            }
        }
        return null;
    }
}
