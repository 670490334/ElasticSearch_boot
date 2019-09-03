package chshady.joy.demo.configbean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 错误页面拦截,现在配置文件中把whiteLable自动生成取消了
 * @Author 廖凡
 * @Date 2019/9/3 16:36
 */
@Controller
public class AppErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
    @Autowired
    public AppErrorController(ErrorAttributes errorAttributes){
        this.errorAttributes = errorAttributes;
    }

    /**
     * web错误处理
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public String errorPageHandler(HttpServletRequest request, HttpServletResponse response){
        int status = response.getStatus();
        switch (status){
            case 403:
                return "403";
            case 404:
                return "404";
            case 500:
                return "500";
        }
        return "error";
    }
    /**
     * 除web外的错误处理
     */
    @RequestMapping(value = ERROR_PATH)
    @ResponseBody
    public Result errorApiHandler(HttpServletRequest request){
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String,Object> attr = this.errorAttributes.getErrorAttributes(webRequest,false);
        int status = getStatus(request);
        return Result.ofMessage(status,String.valueOf(attr.getOrDefault("message","error")));
    }

    private int getStatus(HttpServletRequest request){
        Integer status = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (status !=null){
            return status;
        }
        return 500;
    }
}
