package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.GraphCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.GraphData;
import nl.yc.crowdcounter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public String graphPicker(HttpServletRequest request) {
        return "graphMaker";
    }

    @RequestMapping(value = "/graphMaker", method = RequestMethod.POST)
    public String doPost(HttpServletRequest request) {
        ArrayList<Integer> hourMapping = new ArrayList<>();
        String location = request.getParameter("location");
        String date = request.getParameter("date");
        Date beginDate = Util.beginDate(date);
        Date oldBeginDate = beginDate;
        Date endDate = Util.setNewTime(beginDate);

        int totalcount = 0;
        int count;
        for (int i = 0; i < 24; i++) {
            count = 0;
            Set<GraphData> found = graphCrudRepo.findAllByTimeAndLocation(beginDate, endDate, location);

            for (GraphData gd : found) {
                count++;
                totalcount++;
            }
            hourMapping.add(count);
            beginDate = Util.setNewTime(beginDate);
            endDate = Util.setNewTime(endDate);
        }
        System.out.println(Arrays.toString(hourMapping.toArray()));
        System.out.println("found adresses :" + totalcount);
        System.out.println("All results found for: " + location + " on " + oldBeginDate + " till " + beginDate);
        request.getSession().setAttribute("hourmap", hourMapping);

        return "redirect:/graphPlotter";
    }

    @RequestMapping(value = "/graphPlotter", method = RequestMethod.GET)
    public String graphPlotter(HttpServletRequest request) {
        return "graphPlotter";
    }


    //    @RequestMapping(value = "/graphMaker", method = RequestMethod.GET)
//    @Accessibility(requireLogin = true)
//    public String createGraphHandle(HttpServletRequest request, Model model) {
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
//
//        return "/graphMaker";
//    }
}
