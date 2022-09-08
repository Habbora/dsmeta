package br.com.habbora.devsuperior.dsmeta.services;

import br.com.habbora.devsuperior.dsmeta.entites.Sale;
import br.com.habbora.devsuperior.dsmeta.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleSavice {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        List<Sale> sales = saleRepository.findAll();
        return sales;
    }

}
