package br.com.habbora.devsuperior.dsmeta.controller;

import br.com.habbora.devsuperior.dsmeta.entites.Sale;
import br.com.habbora.devsuperior.dsmeta.services.SaleSavice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    public Page<Sale> listAllSales(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10)
                                   Pageable paginacao) {
        return saleSavice.findSales(paginacao);
    }

    @GetMapping
    public Page<Sale> listSalesBetweenDate(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                           @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                           @PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0,
                                                   size = 10) Pageable paginacao) {
        return saleSavice.findSalesBetweenDate(paginacao, minDate, maxDate);
    }

}
