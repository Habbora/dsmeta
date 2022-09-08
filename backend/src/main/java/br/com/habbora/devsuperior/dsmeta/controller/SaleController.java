package br.com.habbora.devsuperior.dsmeta.controller;

import br.com.habbora.devsuperior.dsmeta.entites.Sale;
import br.com.habbora.devsuperior.dsmeta.services.SaleSavice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleSavice saleSavice;

    @GetMapping
    public List<Sale> listAllSales() {
        return saleSavice.findSales();
    }

}
