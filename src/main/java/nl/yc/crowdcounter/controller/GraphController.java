package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.GraphCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.GraphData;
import nl.yc.crowdcounter.model.User;
import nl.yc.crowdcounter.util.WlanSniffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
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
        //sniffer activated
        Set<String> hostAddresses = WlanSniffer.checkAllHosts();
        Set<GraphData> graphs = new HashSet<>();


        for (String s : hostAddresses) {
            GraphData gData = new GraphData();
            gData.setAddress(s);
            graphs.add(gData);
        }
        graphCrudRepo.save(graphs);

        return "/graphMaker";
    }

    @RequestMapping("/fetching")
    public String fetchFromDB(HttpServletRequest request) {
        User u = (User) request.getSession().getAttribute("user");
        Long id = u.getId();
        return "/graphMaker";
    }

}
