package com.livraria.livros.service.calculo;

public class CalcularPreco {

    public Double calcular(Double valor, Double cupom) {

        Double desconto = valor * (cupom/100);

        return desconto;
} }
