package com.hreinn.backend.domain;

import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.model.StreamingResponseHandler;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;
import dev.langchain4j.model.output.Response;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
public class StreamingChatModel {
    private final OllamaStreamingChatModel llama3;
    public StreamingChatModel () {
        this.llama3 = OllamaStreamingChatModel.builder()
                .baseUrl("http://localhost:8081")
                .modelName("llama3")
                .temperature(0.0)
                .build();
    }

    @Tool("Get the current temperature climate in the office.")
    public String getOfficeTemperatureClimate() {
        return "Temperature climate in the office is nice";
    }

    public String message(String message) {
        CompletableFuture<Response<AiMessage>> futureResponse = new CompletableFuture<>();
        llama3.generate(message, new StreamingResponseHandler<>() {

            @Override
            public void onNext(String token) {
                System.out.print(token);
            }

            @Override
            public void onComplete(Response<AiMessage> response) {
                futureResponse.complete(response);
            }

            @Override
            public void onError(Throwable error) {
                futureResponse.completeExceptionally(error);
            }
        });
        Response<AiMessage> join = futureResponse.join();
        return join.content().text();
    }
}
