/**
 * 
 */
package org.javabase.apps.controller;

import org.javabase.apps.entity.User;
import org.javabase.apps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Controller
@RequestMapping(value="registration")
public class RegistrationController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }
    
    
    @RequestMapping(value="new", method = RequestMethod.POST)
    public String newRegistration(User user){
        
        boolean save =userService.addUser(user);
        if (save) {
            return "redirect:/login";
        }else {
            return "redirect:/registration";
        }
    }

}
