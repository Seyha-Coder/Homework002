package org.example.homework002.Model.StudentModel;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class StudentResponse <T> {
    String message;
    T payload;
    String status;
    LocalDateTime time;
}
