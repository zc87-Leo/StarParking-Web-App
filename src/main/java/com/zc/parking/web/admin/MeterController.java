package com.zc.parking.web.admin;

import com.zc.parking.po.Meter;
import com.zc.parking.service.MeterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class MeterController {
    @Autowired
    private MeterService meterService;

    @GetMapping("/meters")
    public String meters(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                 Pageable pageable,
                         Model model) {
        model.addAttribute("page", meterService.listMeter(pageable));
        return "admin/meters";
    }

    @PostMapping("/query")
    public String query(@PageableDefault(size = 5, sort = {"id"}, direction = Sort.Direction.DESC)
                                Pageable pageable,
                        Meter meter,
                        Model model) {
        model.addAttribute("page", meterService.listAMeter(pageable, meter));

        return "admin/meters";
    }

    @PostMapping("/query_one")
    public String query_one(@PageableDefault(size = 1, sort = {"id"}, direction = Sort.Direction.DESC)
                                    Pageable pageable,
                            Meter meter,
                            Model model) {
        model.addAttribute("page", meterService.listAMeter(pageable, meter));

        return "admin/meter";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Long id, @PageableDefault(size = 1, sort = {"id"}, direction = Sort.Direction.DESC)
            Pageable pageable, Model model) {
        Meter meter = meterService.findOne(id);
        if (meter.getAvailability() == 1) {
            meter.setAvailability(0);
        } else {
            meter.setAvailability(1);
        }
        meterService.updateMeter(meter);
        model.addAttribute("page", meterService.listAMeter(pageable, meter));
        return "admin/meter";
    }


}
