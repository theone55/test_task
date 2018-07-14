package by.justfors.softclub.repository;

import by.justfors.softclub.msg.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {

    Message findByNumber(Long number);
}
