package ru.kpfu.itis.ek.homework.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Task014:Correct URI
 * /getdate
 * /add/{int}/{int}
 * /mult/{int}/{int}
 * /{address}/search
 *
 * Task015:
 * textarea, button result,
 * list of operation(/process):
 *  1)num of words
 *  2)num of symbols
 *  3)num of sentences
 *  4)num of paragraph
 *
 *  post method, redirect to /result
 */
@Controller
public class TasksController {


    //Task 014
    @RequestMapping("/getdate")
    public String getdatePage(ModelMap model) {
        model.put("time", new java.util.Date());
        return "getdate";
    }

    @RequestMapping("/add/{val1}/{val2}")
    public String addPage(@PathVariable int val1,@PathVariable int val2,ModelMap model) {
        model.put("message",val1 +"+" +val2 +"= " +(val1+val2));
        return "add";
    }

    @RequestMapping("/mult/{val1}/{val2}")
    public String multPage(@PathVariable int val1,@PathVariable int val2,ModelMap model) {
        model.put("message",val1 +"*" +val2 +"= " +(val1*val2));
        return "add";
    }

    @RequestMapping("/{address}/search")
    public ModelAndView searchPage(@PathVariable String address, ModelMap model) {
        boolean correctAddress=false;
        switch (address) {
            case "baidu.com":
                correctAddress = true;
                break;
            case "bing.com":
                correctAddress=true;
                break;
            case "yahoo.com":
                correctAddress=true;
                break;
            case "aol.com":
                correctAddress=true;
                break;
        }

        if(!correctAddress)
           address= "localhost:8083/error-404.jsp";
        return new ModelAndView("redirect:http://"+address,model) ;
    }

    //Task 015


    @RequestMapping("/process")
    public ModelAndView process(ModelMap modelMap,HttpServletRequest request){
        ModelAndView mav=new ModelAndView("process");


        int count=0;
        String operation="symbol";
        String message="";

        if (request.getParameter("text")!=null && request.getParameter("text")!="") message=request.getParameter("text");
        if(request.getParameter("Operation")!=null) operation=request.getParameter("Operation");


        Matcher m = Pattern.compile("[A-Za-z]+").matcher(message);
        int check=0;
        while (m.find()) {
            check++;
        }

        if(check!=0) {

            switch (operation) {
                case "symbol":
                    count = message.trim().length();
                    message = "Количество символов " + count;
                    break;
                case "word":
                    Matcher m1 = Pattern.compile("\\b([A-Za-z]+)\\b").matcher(message);
                    while (m1.find()) {
                        count++;
                    }
                    message = "Количество слов " + count;
                    break;
                case "sentence":
                    Matcher m2 = Pattern.compile("(\\b[A-Za-z]+\\b)+\\.").matcher(message.replace(" ",""));
                    while (m2.find()) {
                        count++;
                    }
                    message = "Количество предложений " + count;
                    break;
                case "paragraph":
                    Matcher m3 = Pattern.compile("(\\b[A-Za-z]+\\b)+\\b\\r\\n").matcher(message.replace(" ",""));
                    while (m3.find()) {
                        count++;
                    }
                    if(message.lastIndexOf("\n")<message.trim().length()) count++;
                    message = "Количество абзацев " + count;
                    break;
            }

        }
        else message="Мы считаем только английские буквы";

        modelMap.addAttribute("message",message);
        mav.addObject("message", message);
        return mav;
    }


    @RequestMapping("/result")
    public String resultPage(ModelMap modelMap){

        String message= (String)modelMap.get("message");
        modelMap.put("message",message);
        return "result";

    }

}

