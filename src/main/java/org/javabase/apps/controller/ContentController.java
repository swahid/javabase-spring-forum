/**
 * 
 */
package org.javabase.apps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Controller
@RequestMapping(value="content")
public class ContentController {
    
    @RequestMapping(method=RequestMethod.GET)
    public String thread(){
        return "new_topic";
    }
    
    @RequestMapping(value="view/{contentId}",method=RequestMethod.GET)
    public String loadThread(@PathVariable int contentId){
        return "topic";
    }
    @RequestMapping(value="create",method=RequestMethod.GET)
    public String newThread(){
        return "new_topic";
    }

}
