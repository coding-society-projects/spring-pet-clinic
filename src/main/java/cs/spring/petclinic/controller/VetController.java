package cs.spring.petclinic.controller;


import cs.spring.petclinic.model.Veterinary;
import cs.spring.petclinic.repository.VeterinaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VetController {

    @Autowired
    private VeterinaryRepository veterinaryRepository;

    @GetMapping("/vet/all")
    public String vetAll(Model model) {
        List<Veterinary> vets = veterinaryRepository.findAll();
        model.addAttribute("vets", vets);
        model.addAttribute("search", new String());
        return "vetall.html";
    }

    @PostMapping("/vet/search")
    public String vetSearch(@ModelAttribute("search") String search, Model model) {
        model.addAttribute("search", search);
        List<Veterinary> vets = veterinaryRepository.findByCity(search);
        model.addAttribute("vets", vets);
        return "search.html";
    }
}
