package computacao.paralela.produtor11.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DadosContratos implements Serializable {

    @Id
    private Integer id;
    private String empresaEnvolvida;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private double valorTotal;
    private String moeda;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpresaEnvolvida() {
        return empresaEnvolvida;
    }

    public void setEmpresaEnvolvida(String empresaEnvolvida) {
        this.empresaEnvolvida = empresaEnvolvida;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getMoeda() {
        return moeda;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }
}
