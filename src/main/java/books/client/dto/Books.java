package books.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Books {
 private Map<String, Book> books;
}
