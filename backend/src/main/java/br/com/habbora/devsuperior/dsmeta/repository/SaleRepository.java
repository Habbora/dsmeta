package br.com.habbora.devsuperior.dsmeta.repository;

import br.com.habbora.devsuperior.dsmeta.entites.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max")
    Page<Sale> findBetweenDate(LocalDate min, LocalDate max, Pageable paginacao);
}
