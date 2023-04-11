package com.todolist11apr.todolist11apr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppinglist")
public class ListaCumparaturiController {

    @Autowired
    private ListaCumparaturiRepository listaCumparaturiRepository;

    @GetMapping("")
    public List<ListaCumparaturiModel> getListaCumparaturi() {
        return listaCumparaturiRepository.findAll();
    }

    @PostMapping("")
    public  ListaCumparaturiModel createListaCumparaturi(@RequestBody ListaCumparaturiModel lcm) {
        return listaCumparaturiRepository.save(lcm);
    }

    @PutMapping("/{id}")
    public  ListaCumparaturiModel updateListaCumparaturi(@PathVariable Long id, @RequestBody ListaCumparaturiModel lcm) {
        //caut ca exista acea inreg in db
        ListaCumparaturiModel mylcm = listaCumparaturiRepository.findById(id).orElseThrow(() -> new RuntimeException("nu este, va apare in logs ca ui dev da prostii "));
        // daca am ajuns aici sigur exista, altfel optional m-ar fi aruncat in exceptie si s-ar fi terminat metoda
        // pun completed pe ce imi da colegul de la ui/web
        mylcm.setCompleted(lcm.isCompleted());

        return listaCumparaturiRepository.save(mylcm);
    }

    @DeleteMapping("/{id}")
    public  void deleteListaCumparaturi(@PathVariable Long id) {
         listaCumparaturiRepository.deleteById(id);
    }
}
