package nl.yc.crowdcounter.controller;

import nl.yc.crowdcounter.crudrepositories.GraphCrudRepo;
import nl.yc.crowdcounter.crudrepositories.UserCrudRepo;
import nl.yc.crowdcounter.model.Accessibility;
import nl.yc.crowdcounter.model.GraphData;
import nl.yc.crowdcounter.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    @Accessibility
    public String graphPicker() {
        return "graphMaker";
    }

    @RequestMapping(value = "/graphMaker", method = RequestMethod.POST)
    @Accessibility
    public String doPost(HttpServletRequest request) {
        generateGraphAndTableData(request);

        return "redirect:/graphPlotter";
    }

    @RequestMapping(value = "/graphPlotter", method = RequestMethod.GET)
    @Accessibility
    public String graphPlotter(HttpServletRequest request, Model model) {
        fillModelWithRequestData(request, model);

        return "graphPlotter";
    }

    @RequestMapping(value = "/fetchgraphloc", method = RequestMethod.POST)
    @ResponseBody
    @Accessibility
    public String fetchGraphLocation(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            return "<div href=\"#\" class=\"list-group-item\"><p class=\"list-group-item-text\">No results found!</p></div>";
        }

        Set<String> gData = graphCrudRepo.findDistinctByLocationContaining(name);

        if (gData != null && !gData.isEmpty()) {

            if (gData.size() == 1 && gData.iterator().next().equalsIgnoreCase(name)) {
                return "";
            }

            StringBuilder sb = new StringBuilder();

            for (String gd : gData) {
                sb.append("<a href=\"#\" class=\"list-group-item\" onclick=\"fillSearch('").append(gd).append("')\">")
                        .append("<p class=\"list-group-item-text\">")
                        .append(gd).append("</p>").append("</a>");
            }

            return sb.toString();
        }

        return "<div href=\"#\" class=\"list-group-item\"><p class=\"list-group-item-text\">No results found!</p></div>";
    }

    @RequestMapping(value = "/tableMaker", method = RequestMethod.GET)
    @Accessibility
    public String tablePicker() {
        return "tableMaker";
    }

    @RequestMapping(value = "/tableMaker", method = RequestMethod.POST)
    @Accessibility
    public String tablePost(HttpServletRequest request) {
        generateGraphAndTableData(request);

        return "redirect:/tablePlotter";
    }

    @RequestMapping(value = "/tablePlotter", method = RequestMethod.GET)
    @Accessibility
    public String tablePlotter(HttpServletRequest request, Model model) {
        fillModelWithRequestData(request, model);

        return "tablePlotter";
    }

    private void generateGraphAndTableData(HttpServletRequest request) {
        String location = request.getParameter("location");
        String date = request.getParameter("date");

        if (date == null || date.isEmpty() ||
                location == null || location.isEmpty()) return;

        Date beginDate = Util.beginDate(date);
        Date oldBeginDate = beginDate;
        Date endDate = Util.setNewTime(beginDate);
        Date oldEndDate = endDate;

        String signalStrength = "";
        int totalcount = 0;
        int count;

        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> hourMapping = new ArrayList<>();
            beginDate = oldBeginDate;
            endDate = oldEndDate;
            signalStrength = Util.setNewString(i);

            for (int j = 0; j < 24; j++) {
                count = 0;
                Set<GraphData> found = graphCrudRepo.findAllByTimeAndLocationAndSignalStrength(beginDate, endDate, location, signalStrength);

                for (GraphData gd : found) {
                    count++;
                    totalcount++;
                }

                hourMapping.add(count);
                beginDate = Util.setNewTime(beginDate);
                endDate = Util.setNewTime(endDate);
            }

            Util.setRightName(request, hourMapping, i);
        }

        request.getSession().setAttribute("date", date);
        request.getSession().setAttribute("location", location);
    }

    private void fillModelWithRequestData(HttpServletRequest request, Model model) {
        model.addAttribute("date", request.getSession().getAttribute("date"));
        request.getSession().setAttribute("date", null);
        model.addAttribute("location", request.getSession().getAttribute("location"));
        request.getSession().setAttribute("location", null);
        model.addAttribute("weakhourmap", request.getSession().getAttribute("weakhourmap"));
        request.getSession().setAttribute("weakhourmap", null);
        model.addAttribute("mediumhourmap", request.getSession().getAttribute("mediumhourmap"));
        request.getSession().setAttribute("mediumhourmap", null);
        model.addAttribute("highhourmap", request.getSession().getAttribute("highhourmap"));
        request.getSession().setAttribute("highhourmap", null);
    }
}
