package com.prem.mvc.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Date:   14/8/16 / 1:10:04 PM (SGT)
 * Author: Prem Kumar
 * <p/>
 * Comments: 
 * <p/>
 * This is my basic controller for my web app.
 */


@Controller
@RequestMapping("/askMe")
class IndexController
{

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
   	private Environment env;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String displayRequestPage()
    {
    	
    	logger.info("Start of displayRequestPage()");
        /*
           I am going to display the helloworld.jsp page now :)
         */
        logger.debug("made it to controller");
        logger.debug(env.getProperty("bpm.wrapper.ip"));
        
        logger.info("End of displayRequestPage()");
        return "helloworld";

    }


}
