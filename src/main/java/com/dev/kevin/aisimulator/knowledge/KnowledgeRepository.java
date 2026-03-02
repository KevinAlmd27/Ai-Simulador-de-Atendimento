package com.dev.kevin.aisimulator.knowledge;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class KnowledgeRepository {

    private final List<ProductKnowledge> products;

    public KnowledgeRepository() {

        products = List.of(


                new ProductKnowledge(
                        "Ultraboost 5",
                        "Daily Trainer Premium",
                        "Light Boost V2 - máximo conforto",
                        "Sem placa de carbono",
                        "10mm",
                        "310g",
                        "Rodagem longa e uso diário",
                        "Corredor neutro que prioriza conforto",
                        """
                        Modelo focado em máximo conforto.
                        Indicado para corridas longas e uso diário.
                        Entressola com Light Boost V2 oferece alto retorno de energia.
                        Sensação de maciez com estabilidade.
                        """
                ),

                new ProductKnowledge(
                        "Adizero Adios Pro 3",
                        "Performance / Competição",
                        "Lightstrike Pro",
                        "EnergyRods 2.0 em carbono",
                        "6.5mm",
                        "220g",
                        "Provas e alta performance",
                        "Corredor competitivo",
                        """
                        Modelo de competição com foco em performance.
                        EnergyRods 2.0 proporcionam rigidez e propulsão.
                        Drop reduzido favorece biomecânica agressiva.
                        Alta responsividade para provas.
                        """
                ),

                new ProductKnowledge(
                        "Adizero Boston 12",
                        "Treino de Ritmo",
                        "Lightstrike + Lightstrike Pro",
                        "EnergyRods parciais",
                        "8mm",
                        "260g",
                        "Treinos de velocidade e ritmo",
                        "Corredor intermediário a avançado",
                        """
                        Modelo versátil para treinos rápidos.
                        Combinação de espumas para equilíbrio entre amortecimento e resposta.
                        EnergyRods auxiliam transição dinâmica.
                        Ideal para ritmo controlado.
                        """
                ),

                new ProductKnowledge(
                        "Supernova Prima 2",
                        "Daily Trainer Estável",
                       "Entressola Dreamstrike+ com composto PEBA",
                        "Sem placa",
                        "9mm",
                        "290g",
                        "Rodagem diária",
                        "Corredor que busca estabilidade",
                        """
                        Modelo estável para treinos diários.
                        Dreamstrike+ oferece amortecimento consistente.
                        Indicado para corredores que priorizam segurança.
                        Boa absorção de impacto.
                        """
                ),

                new ProductKnowledge(
                        "Supernova Rise 2",
                        "Daily Trainer versátil",
                        "Entressola Dreamstrike+ com composto PEBA",
                        "Sem placa de carbono",
                        "10mm",
                        "Não é tênis de pilha alta",
                        "Rodagem diária e treinos longos",
                        "Corredores que buscam estabilidade e segurança",
                        """
                        O Rise não é um tênis de pilha alta.
                        Seu drop de 10mm favorece transições naturais.

                        O cabedal em engineering mesh é projetado para melhor ajuste,
                        conforto e alta respirabilidade, utilizando camadas mais finas
                        para melhor adaptação ao pé.

                        A região do tornozelo possui acolchoamento reforçado,
                        proporcionando segurança e conforto durante a corrida.
                        O bico e o acolchoado do calcanhar apresentam alta durabilidade.

                        As hastes de espuma auxiliam em transições mais leves e estáveis.
                        A rigidez torsional acima da média oferece maior controle
                        na região do médio pé, aumentando a sensação de segurança.

                        A entressola Dreamstrike+ com PEBA garante resistência,
                        amortecimento consistente e manutenção de desempenho
                        em diferentes temperaturas.

                        Comparado ao Rise 1, o Rise 2 apresenta um cabedal
                        mais resistente, confortável e respirável,
                        mantendo estabilidade acima da média e grande versatilidade
                        para corridas diárias.
                        """
                )
        );
    }

    public ProductKnowledge getRandomProduct() {
        int index = ThreadLocalRandom.current().nextInt(products.size());
        return products.get(index);
    }

    public ProductKnowledge findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não encontrado: " + name)
                );
    }
}