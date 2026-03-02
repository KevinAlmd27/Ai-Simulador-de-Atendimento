package com.dev.kevin.aisimulator.knowledge;

public class ProductKnowledge {

    private final String name;
    private final String category;
    private final String cushioning;
    private final String plate;
    private final String drop;
    private final String weight;
    private final String idealUse;
    private final String targetRunner;
    private final String officialDescription;

    public ProductKnowledge(String name,
                            String category,
                            String cushioning,
                            String plate,
                            String drop,
                            String weight,
                            String idealUse,
                            String targetRunner,
                            String officialDescription) {

        this.name = name;
        this.category = category;
        this.cushioning = cushioning;
        this.plate = plate;
        this.drop = drop;
        this.weight = weight;
        this.idealUse = idealUse;
        this.targetRunner = targetRunner;
        this.officialDescription = officialDescription;
    }

    public String getName() {
        return name;
    }

    public String buildContext() {

        return """
        MODELO: %s

        Categoria: %s
        Amortecimento: %s
        Placa: %s
        Drop: %s
        Peso / Estrutura: %s
        Uso ideal: %s
        Perfil de corredor: %s

        DESCRIÇÃO OFICIAL:
        %s
        """.formatted(
                name,
                category,
                cushioning,
                plate,
                drop,
                weight,
                idealUse,
                targetRunner,
                officialDescription
        );
    }
}