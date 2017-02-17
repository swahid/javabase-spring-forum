/**
 * 
 */
package org.javabase.apps.controller;

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
    
    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }

}
