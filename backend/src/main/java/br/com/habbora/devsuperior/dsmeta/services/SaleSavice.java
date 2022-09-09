package br.com.habbora.devsuperior.dsmeta.services;

import br.com.habbora.devsuperior.dsmeta.entites.Sale;
import br.com.habbora.devsuperior.dsmeta.repository.SaleRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Stream;

@Service
public class SaleSavice {

    @Autowired
    private SaleRepository saleRepository;

    public Page<Sale> findSales(Pageable paginacao) {
        Page<Sale> sales = saleRepository.findAll(paginacao);
        return sales;
    }

    public Page<Sale> findSalesBetweenDate(Pageable paginacao, String minDate, String maxDate) {

        LocalDate today = LocalDate.now(ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

        Page<Sale> sales = saleRepository.findBetweenDate(min, max, paginacao);
        return sales;
    }

    public static void main(String[] args) {

    }

}
