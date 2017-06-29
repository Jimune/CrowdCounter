package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.GraphCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;


/**
 * Created by yvo.romp on 28/06/2017.
 */

@Controller
public class GraphController {

    @Autowired
    UserCrudRepo userRepo;
    @Autowired
    GraphCrudRepo graphCrudRepo;

    @RequestMapping(value = "/graphMaker", method = RequestMethod.GET)
    @Accessibility(requireLogin = true)
    public String createGraphHandle(HttpServletRequest request, Model model) {
//        Set<GraphData> macs = new HashSet<>();
//
//
//        for (int i = 0; i < 1000000; i++) {
//            GraphData graphData = new GraphData();
//            String mac = Util.getRandomMac();
//            String location = Util.getRandomLocation();
//            String strength = Util.getRandomStrenght();
//            Date date = Util.getRandomDate();
//
//            graphData.setAddress(mac);
//            graphData.setLocation(location);
//            graphData.setSignalStrength(strength);
//            graphData.setTimestamp(date);
//
//            macs.add(graphData);
//        }
//
//        graphCrudRepo.save(macs);

        return "/graphMaker";
    }

//    @RequestMapping("/fetching")
//    public String fetchFromDB(HttpServletRequest request) {
//        User u = (User) request.getSession().getAttribute("user");
//        Long id = u.getId();
//        return "/graphMaker";
//    }

    @RequestMapping("/query")
    public String fetchFromDB(HttpServletRequest request) {
        Set<String> found = graphCrudRepo.findByTime();
        System.out.println(found.toString());
        request.getSession().setAttribute("cache", found);


        return "/login";
    }
}
