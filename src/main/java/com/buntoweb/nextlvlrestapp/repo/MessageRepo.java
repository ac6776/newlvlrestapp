package com.buntoweb.nextlvlrestapp.repo;

import com.buntoweb.nextlvlrestapp.entity.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepo extends CrudRepository<Message, Long> {
}
