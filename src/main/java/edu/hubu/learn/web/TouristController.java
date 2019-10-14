package edu.hubu.learn.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        touristService.addTourist(tourist);
        ModelAndView mav = new ModelAndView("redirect:/tourist/list");
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        touristService.deleteTourist(id);
        ModelAndView mav = new ModelAndView("redirect:/tourist/list");
        return mav;
    }

    @RequestMapping("/modify/{id}")
    public ModelAndView modifyTourist(@PathVariable Long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("tourist", touristService.getTourist(id));
        mav.setViewName("tourist_modify");
        return mav;
    }

    @RequestMapping("/do_modify")
    public ModelAndView doModifyTourist(Tourist tourist){
        touristService.modifyTourist(tourist);
        ModelAndView mav = new ModelAndView("redirect:/tourist/list");
        return mav;
    }
   
    @RequestMapping("/search")
    public ModelAndView searchTourist() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("tourist_search");
        return mav;
    }

    @RequestMapping("/do_search")
    public ModelAndView doSearchTourist(HttpServletRequest httpRequest) {
        ModelAndView mav = new ModelAndView();
        String keyword = httpRequest.getParameter("keyword");
        List<Tourist> tourists =touristService.searchTourist(keyword);
        mav.addObject("tourists", tourists);
        mav.setViewName("tourists");
        return mav;
    }

    public List<Tourist> searchTourists(String keyword) {
        Tourist tourist = new Tourist();
        tourist.setWriter("tourist");
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("writer", match->match.startsWith());
        tourist.setWriter(keyword);
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("writer", match->match.contains());
        Example<Tourist> example = Example.of(tourist, matcher);
        Sort sort = new Sort(Direction.DESC, "id");
        return touristDao.findAll(example, sort);
    }
    
}