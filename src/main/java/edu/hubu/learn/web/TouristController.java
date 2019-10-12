package edu.hubu.learn.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import edu.hubu.learn.entity.Tourist;
import edu.hubu.learn.service.TouristService;


@Controller
@RequestMapping("/tourist")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @RequestMapping("/tourist")
    public ModelAndView tourist() {
        ModelAndView mav = new ModelAndView();
        Tourist tourist = touristService.getTourist(1l);
        mav.addObject("tourist", tourist);
        mav.setViewName("tourist");
        return mav;
    }

    @RequestMapping("/list")
    public ModelAndView tourists(){
        ModelAndView mav = new ModelAndView();
        List<Tourist> tourists = touristService.getTourists();
        mav.addObject("tourists", tourists);
        mav.setViewName("tourists");
        return mav;
    }

    @RequestMapping("/add")
    public ModelAndView addTourist() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("tourist_add");
        return mav;
    }

    @RequestMapping("/do_add")
    public ModelAndView doAddTourist(Tourist tourist) {
        tourist.setAvatar("");
        touristService.addTourist(tourist);
        ModelAndView mav = new ModelAndView("redirect:/tourist/list");
        return mav;
    }
}