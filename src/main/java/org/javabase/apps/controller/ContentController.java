/**
 * 
 */
package org.javabase.apps.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javabase.apps.entity.Content;
import org.javabase.apps.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Controller
@RequestMapping(value="content")
public class ContentController {
    
    @Autowired
    ContentService contentService;
    
    @RequestMapping(value="create",method=RequestMethod.GET)
    public String thread(){
        return "new_topic";
    }
    
    @RequestMapping(value="view/{contentId}",method=RequestMethod.GET)
    public String loadThread(@PathVariable int contentId){
        return "topic";
    }
    
    @ResponseBody
    @RequestMapping(value="new",method=RequestMethod.POST)
    public Map<String, Object> newThread(@RequestBody Content content){
        Map<String, Object> response = new HashMap<>();
        
        try {
            content.setCreateDate(new Date());
             boolean save = contentService.addContent(content);
            if (save) {
                response.put("suceess", true);
                response.put("message", "Content Post");
            }else {
                response.put("error", true);
                response.put("message", "unable to save");
            }
        } catch (Exception e) {
            response.put("suceess", false);
            response.put("message", "unable to save");
            e.printStackTrace();
        }
        
        return response;
    }

}
