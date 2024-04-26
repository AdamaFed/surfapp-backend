package com.surfapp.GPT;


import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class ChatGPT {
    static List<ChatMessage> messages = new ArrayList<>();

    public static String gptMethod(String messageFromTelegram) {
        String token = System.getenv("OPENAI_TOKEN");
        OpenAiService service = new OpenAiService(token);

        ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "Du bist ein Assistent in einem Chat zum Thema Kitesurfen, du antwortest in kurzen präzisen Sätzen. Sei höflich. maximal 10 wörter für die Antwort.");
        messages.add(systemMessage);

        System.out.println("ChatGPT generiert antwort.");
        Scanner scanner = new Scanner(System.in);
        ChatMessage firstMsg = new ChatMessage(ChatMessageRole.USER.value(), messageFromTelegram);//scanner.nextLine());
        messages.add(firstMsg);


        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0613")
                .messages(messages)
                .n(1)
                .maxTokens(100)
                .logitBias(new HashMap<>())
                .build();
        ChatMessage responseMessage = service.createChatCompletion(chatCompletionRequest).getChoices().get(0).getMessage();
        messages.add(responseMessage); // don't forget to update the conversation with the latest response

        return (responseMessage.getContent());


    }

}
