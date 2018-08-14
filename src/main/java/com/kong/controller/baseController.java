package com.kong.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.kong.dao.UserMapper;
import com.kong.entity.User;


@Controller
public class baseController {
  private static Log logger = LogFactory.getLog(baseController.class);
  // private final static DefaultHttpClient HTTP_CLIENT = getHTTPClient();
  private static final String MY_JSESSIONID = "MY_JSESSIONID";
  private Map<String, String> paramInfo = null;

  protected @Autowired HttpSession session;
  protected @Autowired HttpServletRequest request;
  @Autowired
  private UserMapper userMapper;

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler(Exception.class)
  public ModelAndView handleException(Exception e) throws IOException {
    e.printStackTrace();
    return handleStaticHtml("index");
  }

  @RequestMapping("/{folderName}/{fileName}.html")
  public ModelAndView getResource(@PathVariable("folderName") String folderName,
      @PathVariable("fileName") String fileName, HttpServletRequest request,
      HttpServletResponse response) {
    if (this.checkNeedToLogin(folderName, fileName)) {
      ModelAndView view = new ModelAndView();
      view.setViewName("redirect:/login.html");
      return view;
    }
    ModelAndView view = handleStaticHtml(folderName + "/" + fileName);
    return view;
  }

  /*
   * @RequestMapping("/{fileName}.html") public ModelAndView getResource(@PathVariable("fileName")
   * String fileName, HttpServletRequest request, HttpServletResponse response) {
   * 
   * this.putMktCodeToCookie(response); if("logout".equals(fileName)){
   * request.getSession().removeAttribute(MY_JSESSIONID); } return handleStaticHtml(fileName); }
   */

  @RequestMapping("/")
  public ModelAndView getResource() {
    logger.debug("-----------user count is: "+ userMapper.listCount(new User()));
    return new ModelAndView("index");
  }

  // 一层级动态转发
  @RequestMapping(value = "/{actionName}.action")
  public @ResponseBody String handleLevelOneAction(@PathVariable("actionName") String actionName) {
	  return "";
  }

  // 2层级动态转发
  @RequestMapping(value = "/{folderName}/{actionName}.action")
  public @ResponseBody String handleLevelTwoAction(@PathVariable("folderName") String folderName,
      @PathVariable("actionName") String actionName) {
	  return "";
  }

  // 3层级动态转发
  @RequestMapping(value = "/{folderName}/{folderName2}/{actionName}.action")
  public @ResponseBody String handleLevelThreeAction(@PathVariable("folderName") String folderName,
      @PathVariable("folderName2") String folderName2,
      @PathVariable("actionName") String actionName) {
    return "";
  }

 
  public static Map<String, String> cookieMap = new HashMap<String, String>(64);

  // 从响应信息中获取cookie
  public static String setCookie(HttpResponse httpResponse) {
    System.out.println("----setCookieStore");
    Header headers[] = httpResponse.getHeaders("Set-Cookie");
    if (headers == null || headers.length == 0) {
      System.out.println("----there are no cookies");
      return null;
    }
    String cookie = "";
    for (int i = 0; i < headers.length; i++) {
      cookie += headers[i].getValue();
      if (i != headers.length - 1) {
        cookie += ";";
      }
    }

    String cookies[] = cookie.split(";");
    for (String c : cookies) {
      c = c.trim();
      if (cookieMap.containsKey(c.split("=")[0])) {
        cookieMap.remove(c.split("=")[0]);
      }
      cookieMap.put(c.split("=")[0],
          c.split("=").length == 1
              ? ""
              : (c.split("=").length == 2 ? c.split("=")[1] : c.split("=", 2)[1]));
    }
    System.out.println("----setCookieStore success");
    String cookiesTmp = "";
    for (String key : cookieMap.keySet()) {
      cookiesTmp += key + "=" + cookieMap.get(key) + ";";
    }

    return cookiesTmp.substring(0, cookiesTmp.length() - 2);
  }

  /**
   * 检测是否需要登录
   * 
   * @param folderName
   * @param fileName
   * @return
   */
  private boolean checkNeedToLogin(String folderName, String fileName) {
    boolean needToCheckPath = false;
    if ("user".equals(folderName) || "payment".equals(folderName)) {
      needToCheckPath = true;
    }
    if (needToCheckPath && request.getSession().getAttribute(MY_JSESSIONID) == null) {
      logger.info("检测到" + folderName + "/" + fileName + " 回话过期，需要重新登录");
      return true;
    }
    return false;
  }

  private ModelAndView handleStaticHtml(String tempalgeName) {
    ModelAndView view = new ModelAndView();
    view.setViewName("/" + tempalgeName);
    return view;
  }

}
