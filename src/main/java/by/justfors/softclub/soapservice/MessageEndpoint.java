package by.justfors.softclub.soapservice;

import by.justfors.softclub.msg.GetMessageRequest;
import by.justfors.softclub.msg.GetMessageResponse;
import by.justfors.softclub.msg.Message;
import by.justfors.softclub.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


@Endpoint
public class MessageEndpoint {
    private static final String NAMESPACE_URI = "http://www.justfors.by/softclub/msg";

    private MessageRepository messageRepository;

    @Autowired
    public MessageEndpoint(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getMessageRequest")
    @ResponsePayload
    public GetMessageResponse getMessage(@RequestPayload GetMessageRequest request) {
        GetMessageResponse response = new GetMessageResponse();
        Message message = new Message();
        message.setName(request.getName());
        message.setNumber(request.getNumber());
        if(messageRepository.findByNumber(message.getNumber())==null) {
            messageRepository.save(message);
            response.setStatus("OK");
        }else response.setStatus("ERROR");

        return response;
    }
}
