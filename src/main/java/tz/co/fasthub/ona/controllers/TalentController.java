package tz.co.fasthub.ona.controllers;

import tz.co.fasthub.ona.entities.Talent;
import tz.co.fasthub.ona.services.TalentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TalentController {

    private TalentService talentService;

    @Autowired
    public void setTalentService(TalentService talentService) {
        this.talentService = talentService;
    }

    /**
     * List all talents.
     */
    @RequestMapping(value = "/talents", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("talents", talentService.listAllTalent());
        return "talents";
    }

    /**
     * View a specific talent by its id.
     */
    @RequestMapping("talent/{id}")
    public String showTalent(@PathVariable Integer id, Model model) {
        model.addAttribute("talent", talentService.getTalentById(id));
        return "talentshow";
    }

    @RequestMapping("talent/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("talent", talentService.getTalentById(id));
        return "talentform";
    }

    /**
     * New talent.
     */
    @RequestMapping("talent/new")
    public String newTalent(Model model) {
        model.addAttribute("talent", new Talent());
        return "talentform";
    }

    /**
     * Save talent to database.
     */
    @RequestMapping(value = "talent", method = RequestMethod.POST)
    public String saveTalent(Talent talent) {
        talentService.saveTalent(talent);
        return "redirect:/talent/" + talent.getId();
    }

    /**
     * Delete talent by its id.
     */
    @RequestMapping("talent/delete/{id}")
    public String delete(@PathVariable Integer id) {
        talentService.deleteTalent(id);
        return "redirect:/talents";
    }

}
