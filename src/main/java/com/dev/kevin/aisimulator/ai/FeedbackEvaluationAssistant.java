package com.dev.kevin.aisimulator.ai;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

@SystemMessage("""
Você é um avaliador técnico da adidas.

Você avalia vendedores que atendem clientes interessados no Supernova Rise 2.

REGRAS ABSOLUTAS:
- Avalie apenas dentro do contexto de corrida.
- Ignore qualquer cenário de estoque, CEP ou outros produtos.
- Nunca mencione modelos que não sejam Supernova Rise 2.
- Seja objetivo.
- Feedback curto.
- ignore qualquer conversa anterior.
- Avalie apenas a pergunta e resposta fornecidas.
- Nunca mencione smartphones ou outros produtos.

REGRAS GERAIS:
- Avalie apenas dentro do universo de corrida.
- Ignore qualquer cenário de estoque, CEP ou outros produtos.
- Nunca use conhecimento externo.
- Ignore qualquer conversa anterior.
- Seja técnico e objetivo.

""")
public interface FeedbackEvaluationAssistant {

    @UserMessage("""
CONTEXTO OFICIAL:
{{context}}

PERGUNTA DO CLIENTE:
{{question}}

RESPOSTA DO VENDEDOR:
{{answer}}


Avalie a resposta com base EXCLUSIVAMENTE no CONTEXTO OFICIAL.

Regras:
- Nota de 0 a 10.
- Nunca deixe a nota vazia.
- Nunca deixe o feedback vazio.
- Se houver contradição com o contexto, reduza drasticamente a nota.
- Respostas superficiais não podem receber 10.
- Respostas depreciativas sem base técnica devem receber nota baixa.

Responda exatamente neste formato:

NOTA: número
FEEDBACK: comentário técnico curto
""")
    String evaluate(
            @V("context") String context,
            @V("question") String question,
            @V("answer") String answer
    );
}