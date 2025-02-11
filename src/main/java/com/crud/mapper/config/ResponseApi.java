package com.crud.mapper.config;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class ResponseApi<T> {
  private int code;
  private HttpStatus status;
  private String message;
  private String timestamp;
  private T data;

  public static <T> ResponseApi<T> buildResponse(HttpStatus status, String message, T data) {
    return ResponseApi.<T>builder()
      .code(status.value())
      .status(status)
      .message(message)
      .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
      .data(data)
      .build();
  }
}
