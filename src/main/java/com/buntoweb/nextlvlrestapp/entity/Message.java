package com.buntoweb.nextlvlrestapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table (name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.IdMsg.class)
    private Long id;

    @Column(name = "message")
    @JsonView(Views.IdMsg.class)
    private String msg;

    @Column(name = "time_create_at", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @CreationTimestamp
//    @Generated(GenerationTime.INSERT)
    private LocalDateTime creationDate;
}
