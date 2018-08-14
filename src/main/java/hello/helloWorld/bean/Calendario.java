/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.helloWorld.bean;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Haylton
 */

@Entity
@Table(name = "calendario", schema = "sis_teste_cronograma")
public class Calendario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    
    @Column(name = "cronograma_data")
    private LocalDate cronogramaData;
    
    
    @Column(name= "cadastro_data")
    private LocalDate cadastroData;

    public Calendario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getCronogramaData() {
        return cronogramaData;
    }

    public void setCronogramaData(LocalDate cronogramaData) {
        this.cronogramaData = cronogramaData;
    }

    public LocalDate getCadastroData() {
        return cadastroData;
    }

    public void setCadastroData(LocalDate cadastroData) {
        this.cadastroData = cadastroData;
    }
    
    
    
}
